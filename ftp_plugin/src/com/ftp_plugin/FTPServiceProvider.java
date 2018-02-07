package com.ftp_plugin;


import com.intellij.notification.Notification;
import com.intellij.notification.NotificationGroup;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.application.TransactionGuardImpl;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.fileTypes.PlainTextFileType;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Computable;
import com.intellij.openapi.util.Key;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.testFramework.LightVirtualFile;
import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.*;
import org.apache.commons.net.ftp.parser.DefaultFTPFileEntryParserFactory;
import org.stringtemplate.v4.ST;

import java.io.*;
import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by anisik on 25.07.2016.
 */
public class FTPServiceProvider {
    public static final Pattern jid = Pattern.compile("J([0-9]{1,7})");
    public static final Pattern stepname = Pattern.compile("(STEPNAME [A-Za-z0-9$#@]+)");
    public static final Pattern elapsedTime = Pattern.compile("(ELAPSED TIME [ 0-9]+\\.[0-9]+)");
    public static final int RECONNECT_TRIES = 5;
    public static final Key<Date> FTP_LAST_SYNC = new Key<>("ftp_last_sync");
    private static final ConcurrentMap<String, WeakReference<VirtualFile>> sysoutsCache = new ConcurrentHashMap<>();
    private static final Lock lock = new ReentrantLock();
    private static final NotificationGroup groupError = NotificationGroup.findRegisteredGroup("MF-UI Error") == null ?
            NotificationGroup.balloonGroup("MF-UI Error") : NotificationGroup.findRegisteredGroup("MF-UI Error");
    private static final NotificationGroup groupWarning = NotificationGroup.findRegisteredGroup("MF-UI Warning") == null ?
            NotificationGroup.balloonGroup("MF-UI Error") : NotificationGroup.findRegisteredGroup("MF-UI Warning");

    // Create the conection to Lpar.
    public static FTPClient createJESFTPClient(VirtualFile virtualFile, LogonSettingsComponent settingsComponent) {
        String lpar = settingsComponent.getHost();
        return createJESFTPClient(virtualFile, settingsComponent, lpar);
    }

    public static FTPClient createJESFTPClient(VirtualFile virtualFile, LogonSettingsComponent settingsComponent, String lpar) {
        FTPClient client = createFTPClient(virtualFile, settingsComponent, lpar);
        try {
            client.site("FILETYPE=JES jesjobname=*");
        } catch (IOException e) {
            System.err.println("FTPSERVPR " + e.getMessage());
            Notifications.Bus.notify(groupError.createNotification("FTP Service",
                    e.getMessage(), NotificationType.ERROR, null));
        }
        return client;
    }

    public static FTPClient createFTPClient(VirtualFile virtualFile, LogonSettingsComponent settingsComponent, String lpar) {
        FTPClient client = new FTPClient();
        client.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out), true));
        String username = settingsComponent.getUsername();
        String password = settingsComponent.getPassword();

        final String dataset = ((Function<VirtualFile, String>) p -> {
            String ds;
            if (virtualFile == null)
                return "";
            if (virtualFile.isDirectory()) {
                ds = virtualFile.getName();
            } else {
                ds = virtualFile.getParent().getName();
            }
            return ds = "'" + ds + "'";
        }).apply(virtualFile);

        try {
            client.connect(lpar, Integer.parseInt(settingsComponent.getPort()));
            if (!client.login(username, password)) {
                Notifications.Bus.notify(groupWarning.createNotification("FTP Service",
                        "Attempts to login failed. \n Check the login and password", NotificationType.WARNING, null));
            }
            if (!settingsComponent.getInitDir().equals(""))
                client.changeWorkingDirectory(settingsComponent.getInitDir());
            client.changeWorkingDirectory(dataset);

        } catch (IOException e) {
            System.err.println("FTPSERVPR " + e.getMessage());
            Notifications.Bus.notify(groupError.createNotification("FTP Service",
                    e.getMessage(), NotificationType.ERROR, null));
        }
        return client;
    }

    public interface JobSubmitCallback {
        void progressResult(String info);

        void completeResult(Notification notification);
    }

    public static void submitJob(VirtualFile virtualFile, Project project, FTPClient client,
                                 JobSubmitCallback callback) throws IOException, InterruptedException {
        uploadFile(client, virtualFile);
        String job = "";
        for (String result : client.getReplyStrings()) {

            Matcher matcher = jid.matcher(result);
            if (matcher.find())
                job = result.substring(matcher.start(), matcher.end());
        }
        System.out.println("FTPSERVPR JobID: " + job);
        String jobResult = "error";
        String RC = "";
        StringBuilder builder = new StringBuilder();
        try {
            FTPFile[] list;
            while (true) {
                client.setParserFactory(new DefaultFTPFileEntryParserFactory() {
                    @Override
                    public FTPFileEntryParser createFileEntryParser(String key) {
                        if (key.equals("MyParser")) {
                            return new FTPFileEntryParserImpl() {
                                @Override
                                public FTPFile parseFTPEntry(String s) {
                                    System.out.println("FTPSERVPR " + s);
                                    FTPFile f = new FTPFile();
                                    f.setRawListing(s);
                                    return f;
                                }
                            };
                        }
                        return super.createFileEntryParser(key);
                    }
                });

                list = client.initiateListParsing("MyParser", job).getFiles();
                if (list[1].getRawListing().split("\\s+")[3].equalsIgnoreCase("OUTPUT")) {
                    RC = list[1].getRawListing().substring(list[1].getRawListing().trim().lastIndexOf(" "));
                    break;
                } else if (list.length >= 4) {
                    String text = "";
                    Matcher matcher = stepname.matcher(list[3].getRawListing());
                    if (matcher.find()) {
                        text = text + matcher.group();
                    }
                    matcher = elapsedTime.matcher(list[4].getRawListing());
                    if (matcher.find()) {
                        text = text + "  " + matcher.group();
                    }
                    callback.progressResult(text);
                }

                try {
                    Thread.sleep(700);
                } catch (InterruptedException e) {
                    System.err.println("FTPSERVPR " + e.getMessage());
                    Thread.currentThread().interrupt();
                }
            }

            for (FTPFile file : list) {
                builder.append(file.getRawListing());
                builder.append("\n");
            }
            jobResult = builder.toString();
        } catch (IOException e) {
            System.err.println("FTPSERVPR " + e.getMessage());
            Notifications.Bus.notify(groupError.createNotification("FTP Service",
                    e.getMessage(), NotificationType.ERROR, null));
        }
        System.out.println("FTPSERVPR Result of Job: " +  jobResult);
        String title = job + " finished, " + RC;
        Notification notification = new Notification("MF-UI Information", title,
                jobResult, NotificationType.INFORMATION);
        callback.completeResult(notification);
    }

    public static void uploadFile(FTPClient client, VirtualFile file) {
        try {
            BufferedReader reader;

            if (file.getExtension().equalsIgnoreCase("jclt")) {

                reader = ApplicationManager.getApplication().runReadAction((Computable<BufferedReader>) () -> {
                    ST jobTemplate = new ST(FileDocumentManager.getInstance().getDocument(file).getImmutableCharSequence().toString());
                    return new BufferedReader(new StringReader(jobTemplate.render()));
                });
            } else {
                reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
            }
            OutputStream output = client.storeFileStream(file.getName().substring(0, Math.min(8, file.getName().lastIndexOf('.'))));
            if (FTPReply.isNegativePermanent(client.getReplyCode())) {
                Notifications.Bus.notify(groupError.createNotification("FTP Service",
                        "Error uploading file " + file.getName(), NotificationType.ERROR, null));
                return;
            }
            String line;
            while ((line = reader.readLine()) != null) {
                output.write((line + "\r\n").getBytes());
            }
            reader.close();
            output.close();
            if (!client.completePendingCommand()) {
                Notifications.Bus.notify(groupError.createNotification("FTP Service",
                        "Uploading failed for file " + file.getName(), NotificationType.ERROR, null));
            }
        } catch (IOException e) {
            System.err.println("FTPSERVPR " + e.getMessage());
            Notifications.Bus.notify(groupError.createNotification("FTP Service",
                    e.getMessage(), NotificationType.ERROR, null));
        }

    }

    public static void fullJobLog(FTPClient client, Project project, String jobID)
            throws IOException, InterruptedException {
        FTPFile[] ddnames_list;
        ddnames_list = client.initiateListParsing("MyParser", jobID).getFiles();
        for (int i = 4; i < ddnames_list.length - 1; ++i) {
            String ddName = jobID + "." + (i - 3);
            System.out.println("FTPSERVPR Starting creating of " + ddName);
            VirtualFile cachedSysout = null;
            if (sysoutsCache.get(ddName) != null) {
                cachedSysout = sysoutsCache.get(ddName).get();
            }
            if (cachedSysout == null) {
                VirtualFile sysout = new LightVirtualFile(ddName, PlainTextFileType.INSTANCE, "");
                sysoutsCache.put(ddName, new WeakReference<>(sysout));
                cachedSysout = sysout;
                TransactionGuardImpl.getInstance().submitTransactionAndWait(() -> {
                    ApplicationManager.getApplication().runWriteAction(() -> {
                        lock.lock();
                        try {
                            OutputStream out = sysout.getOutputStream(null);
                            InputStream in = client.retrieveFileStream(ddName);
                            byte[] buffer = new byte[1024];
                            while (true) {
                                int readed = in.read(buffer, 0, buffer.length);
                                if (readed < 0)
                                    break;
                                out.write(buffer, 0, readed);
                            }
                            in.close();
                            out.close();
                            client.completePendingCommand();
                        } catch (IOException e) {
                            System.err.println("FTPSERVPR " + e.getMessage());
                        }
                        sysout.refresh(true, false);
                        lock.unlock();
                    });
                });
                System.out.println("FTPSERVPR Creating of " + ddName + " copleted successfully");
            }
            System.out.println("FTPSERVPR Opening of " + ddName);
            VirtualFile finalCachedSysout = cachedSysout;
            TransactionGuardImpl.getInstance().submitTransactionAndWait(() -> {
                ApplicationManager.getApplication().runWriteAction(() -> {
                    FileEditorManager.getInstance(project).openFile(finalCachedSysout, true, true);
                });
            });
            try {
                Thread.currentThread().sleep(2000);
            } catch (InterruptedException e) {
                System.err.println("FTPSERVPR " + e.getMessage());
                Notifications.Bus.notify(groupError.createNotification("FTP Service",
                        e.getMessage(), NotificationType.ERROR, null));
            }
            System.out.println("FTPSERVPR Opening of " + ddName + " copleted successfully");
        }
    }
}

