package com.ftp_plugin;

import com.intellij.notification.NotificationGroup;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.application.TransactionGuardImpl;
import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.progress.Task;
import com.intellij.openapi.progress.impl.ProgressManagerImpl;
import com.intellij.openapi.util.Computable;
import com.intellij.openapi.util.ThrowableComputable;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.newvfs.impl.VirtualFileSystemEntry;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.util.indexing.FileBasedIndex;
import com.intellij.util.indexing.FileBasedIndexImpl;
import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.*;

import static com.ftp_plugin.FTPServiceProvider.FTP_LAST_SYNC;
import static com.ftp_plugin.FTPServiceProvider.RECONNECT_TRIES;

/**
 * Created by anisik on 07.06.2016.
 */
public class HlasmGetRemotePDSAction extends AnAction {

    private static final NotificationGroup groupError = NotificationGroup.findRegisteredGroup("MF-UI Error") == null ?
            NotificationGroup.balloonGroup("MF-UI Error") : NotificationGroup.findRegisteredGroup("MF-UI Error");

    private static final NotificationGroup groupInform = NotificationGroup.findRegisteredGroup("MF-UI Information") == null ?
            NotificationGroup.balloonGroup("MF-UI Information") : NotificationGroup.findRegisteredGroup("MF-UI Information");

    @Override
    public void actionPerformed(AnActionEvent ev) {
        actionPerformed(ev,false);
    }

    protected void actionPerformed(AnActionEvent ev,boolean force) {
        LogonSettingsComponent settingsComponent = (LogonSettingsComponent) ev.getProject().getComponent("LogonSettingsComponent");
        if (settingsComponent == null) {
            // create new logon info
            (new LogonSettingsAction()).actionPerformed(ev);
            return;
        }

        String username = settingsComponent.getUsername();
        String password = settingsComponent.getPassword();
        String dataset1;

        VirtualFile virtualFile = ev.getData(PlatformDataKeys.VIRTUAL_FILE);
        if (virtualFile.isDirectory()) {
            dataset1 = virtualFile.getName();
        } else {
            dataset1 = virtualFile.getParent().getName();
        }
        final String dataset = "'" + dataset1 + "'";
        VirtualFile[] virtualFiles;
        ((ProgressManagerImpl) ProgressManagerImpl.getInstance()).runProcessWithProgressAsynchronously(new Task.Backgroundable(ev.getProject(), "Downloading", true) {
            @Override
            public void run(@NotNull ProgressIndicator indicator) {
                try {

                    FTPClient client = new FTPClient();
                    // for debug
                    client.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out), true));

                    client.connect(settingsComponent.getHost(), Integer.parseInt(settingsComponent.getPort()));
                    client.login(username, password);
                    client.changeWorkingDirectory(dataset);
                    client.setKeepAlive(true);

                    Map<String, Date> lastUpdateDate = Collections.emptyMap();
                    if (virtualFile.isDirectory())
                        lastUpdateDate = ApplicationManager.getApplication().runReadAction(new Computable<Map<String, Date>>() {
                            @Override
                            public Map<String, Date> compute() {
                                Map<String, Date> result = new HashMap<>(virtualFile.getChildren().length);
                                for (VirtualFile toCheck :
                                        virtualFile.getChildren()) {

                                    List<Date> oldDate = FileBasedIndexImpl.getInstance().getValues(
                                            FTPLastSyncIndex.FTP_ID, FileBasedIndex.getFileId(toCheck), GlobalSearchScope.everythingScope(getProject()));
                                    if (oldDate.size() > 0) {
                                        toCheck.putUserDataIfAbsent(FTP_LAST_SYNC, oldDate.get(0));
                                        result.put(toCheck.getNameWithoutExtension(), oldDate.get(0));
                                    }
                                }
                                System.out.println("HLASMGETPDS " + result);
                                return result;
                            }
                        });

                    FTPFile[] files = client.listFiles();
                    int currFileId = 0;
                    for (FTPFile file : files) {
                        if ((virtualFile != null && virtualFile.isDirectory())
                                || (//virtualFile.getExtension().equals("asm") &&
                                file.getName().equals(virtualFile.getNameWithoutExtension()))
                                ) {
                            currFileId += 1;
                            indicator.setFraction((double) currFileId / (double) files.length);

                            if (file.getTimestamp() != null && !force) {
                                Date remoteDate = file.getTimestamp().getTime();
                                Date oldDate = lastUpdateDate.get(file.getName());
                                if (oldDate != null && oldDate.equals(remoteDate)) {
                                    System.out.println("HLASMGETPDS No need to update file " + file.getName());
                                    continue;
                                }
                            }
                            int retry = 0;
                            do {
                                try {
                                    indicator.checkCanceled();
                                    System.out.println("HLASMGETPDS Getting file " + file.getName());
                                    InputStream remote = client.retrieveFileStream(file.getName());
                                    ((TransactionGuardImpl) TransactionGuardImpl.getInstance()).submitTransactionAndWait(new Runnable() {
                                       @Override
                                        public void run() {
                                            try {
                                                BufferedReader reader = new BufferedReader(new InputStreamReader(remote));
                                                String line = reader.readLine();
                                                if (line == null) {
                                                    Notifications.Bus.notify(groupError.createNotification("Loading files",
                                                            "Possibly file is locked on target LPAR", NotificationType.ERROR, null));
                                                    return;
                                                }
                                                String extention = "asm";
                                                if (line.startsWith("//")) {
                                                    extention = "jcl";
                                                } else if (line.matches("[ ]* /\\* [^*]+? \\*/ .*")) {
                                                    extention = "rexx";
                                                }

                                                final String fileName = file.getName() + "." + extention;
                                                VirtualFile file1 = virtualFile;
                                                if (virtualFile.isDirectory()) {
                                                    file1 = ApplicationManager.getApplication().runWriteAction(
                                                            new ThrowableComputable<VirtualFile, IOException>() {
                                                                @Override
                                                                public VirtualFile compute() throws IOException {
                                                                    return virtualFile.findOrCreateChildData(null, fileName);
                                                                }
                                                            });
                                                }
                                                System.out.println("HLASMGETPDS Saving date");
                                                if (file.getTimestamp() != null)
                                                    file1.putUserData(FTPServiceProvider.FTP_LAST_SYNC, file.getTimestamp().getTime());
                                                ((VirtualFileSystemEntry) file1).setFileIndexed(false);

                                                OutputStream outputStream = new FileOutputStream(file1.getCanonicalPath());
                                                while (line != null) {
                                                    outputStream.write((line + "\r\n").getBytes());
                                                    line = reader.readLine();
                                                }
                                                outputStream.close();
                                                FileBasedIndex.getInstance().requestReindex(file1);
                                            } catch (IOException e) {
                                                System.err.println(e.getMessage());
                                                Notifications.Bus.notify(groupError.createNotification("Loading files",
                                                        e.getMessage(), NotificationType.ERROR, null));
                                            }
                                        }
                                    });
                                    remote.close();
                                    client.completePendingCommand();
                                    virtualFile.refresh(true, true);

                                } catch (IOException e1) {
                                    System.err.println(e1.getMessage());
                                    Notifications.Bus.notify(groupError.createNotification("Loading files",
                                            e1.getMessage(), NotificationType.ERROR, null));
                                }
                                if (client.isConnected()) break; // from retry loop
                                Thread.currentThread().wait(1000);
                                System.out.println("HLASMGETPDS FTP reconnecting");
                                client.connect(settingsComponent.getHost());
                                client.login(username, password);
                                retry += 1;
                            }
                            while (retry < RECONNECT_TRIES);
                            if (retry >= RECONNECT_TRIES) {
                                Notifications.Bus.notify(groupError.createNotification("Loading files",
                                        "\n Attempts to reconnect and continue failed. \n Try to redownload files later",
                                        NotificationType.ERROR, null));
                                return;
                            }
                        }

                    }
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                    Notifications.Bus.notify(groupError.createNotification("Loading files", e.getMessage(), NotificationType.ERROR, null));
                } catch (InterruptedException e) {
                    System.err.println(e.getMessage());
                    Notifications.Bus.notify(groupError.createNotification("Loading files", e.getMessage(), NotificationType.ERROR, null));
                }
            }
        });

    }
    @Override
    public void update(AnActionEvent e) {
        VirtualFile virtualFile = e.getData(PlatformDataKeys.VIRTUAL_FILE);
        e.getPresentation().setVisible((virtualFile != null && virtualFile.isDirectory())
                || (virtualFile != null));
    }
}
