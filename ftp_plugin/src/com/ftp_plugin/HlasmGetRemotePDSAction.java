package com.ftp_plugin;

import com.intellij.codeInsight.completion.CompletionProgressIndicator;
import com.intellij.notification.Notification;
import com.intellij.notification.NotificationGroup;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.application.*;
import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.progress.ProgressIndicatorProvider;
import com.intellij.openapi.progress.Task;
import com.intellij.openapi.progress.impl.CoreProgressManager;
import com.intellij.openapi.progress.impl.ProgressManagerImpl;
import com.intellij.openapi.progress.util.ProgressIndicatorBase;
import com.intellij.openapi.util.Computable;
import com.intellij.openapi.util.ThrowableComputable;
import com.intellij.openapi.vfs.VirtualFile;

import com.intellij.openapi.vfs.VirtualFileManager;
import com.intellij.openapi.vfs.VirtualFileSystem;
import com.intellij.openapi.vfs.impl.local.LocalFileSystemImpl;
import com.intellij.openapi.vfs.newvfs.NewVirtualFileSystem;
import com.intellij.openapi.vfs.newvfs.impl.VfsData;
import com.intellij.openapi.vfs.newvfs.impl.VirtualFileImpl;
import com.intellij.openapi.vfs.newvfs.impl.VirtualFileSystemEntry;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.util.ThrowableRunnable;
import com.intellij.util.indexing.FileBasedIndex;
import com.intellij.util.indexing.FileBasedIndexImpl;
import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.text.SimpleDateFormat;
import java.text.spi.DateFormatProvider;
import java.util.*;

import static com.ftp_plugin.FTPServiceProvider.FTP_LAST_SYNC;
import static com.ftp_plugin.FTPServiceProvider.RECONNECT_TRIES;

/**
 * Created by anisik on 07.06.2016.
 */
public class HlasmGetRemotePDSAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent ev) {
        actionPerformed(ev,false);
    }

    protected void actionPerformed(AnActionEvent ev,boolean force) {
        //Editor ed = ev.getData(CommonDataKeys.EDITOR);
        //CaretModel caret = ed.getCaretModel();
        LogonSettingsComponent settingsComponent = (LogonSettingsComponent) ev.getProject().getComponent("LogonSettingsComponent");
        if (settingsComponent == null) {
            // create new logon info
            (new LogonSettingsAction()).actionPerformed(ev);
            return;
        }

        String username = settingsComponent.getUsername();
        String password = settingsComponent.getPassword();
        String dataset1;
        final NotificationGroup group = NotificationGroup.findRegisteredGroup("MF-UI Error") == null ? NotificationGroup.balloonGroup("MF-UI Error") : NotificationGroup.findRegisteredGroup("MF-UI Error");


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

//        try {
                    //FileInputStream in = new FileInputStream("test.txt");

                    client.connect(settingsComponent.getHost(), Integer.parseInt(settingsComponent.getPort()));
                    client.login(username, password);
//                    client.enterLocalPassiveMode();
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
                                System.out.println(result);
                                return result;
                            }
                        });

                    FTPFile[] files = client.listFiles();
//                    client.disconnect();
                    //FTPFile file = files[0];
                    int currFileId = 0;
                    for (FTPFile file : files
                            ) {
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
                                    System.out.println("no need to update " + file.getName());
                                    continue;
                                }
                            }
                            int retry = 0;
                            do {

                                try {

                                    indicator.checkCanceled();
                                    System.out.println("getting file");
//                                    client.enterLocalPassiveMode();
//                                    client.changeWorkingDirectory(dataset);
//                                    if (!FTPReply.isPositiveCompletion(client.getReplyCode())) {
//                                        System.out.println("bad reply code");
//                                        return;
//                                    }
                                    System.out.println(file.getName());

                                    InputStream remote = client.retrieveFileStream(file.getName());
                                    ((TransactionGuardImpl) TransactionGuardImpl.getInstance()).submitTransactionAndWait(new Runnable() {
                                        //                                    ApplicationManager.getApplication().invokeAndWait(new Runnable() {
                                        @Override
                                        public void run() {
                                            try {
                                                BufferedReader reader = new BufferedReader(new InputStreamReader(remote));
                                                //VirtualFile vf = virtualFile.findOrCreateChildData(null, file.getName() + ".asm");


                                                String line = reader.readLine();
                                                if (line == null) {
//                                                    NotificationGroup group = NotificationGroup.findRegisteredGroup("MF-UI Error");
//                                                    if (group == null) {
//                                                        group = NotificationGroup.balloonGroup("MF-UI Error");
//                                                    }
                                                    Notifications.Bus.notify(group.createNotification("Error ",
                                                            "something wrong happened while downloading " + file.getName() +
                                                                    "\n Possibly file is locked on target LPAR", NotificationType.ERROR, null));
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
//                                                    VirtualFile newFile = new VirtualFileImpl(0,new VfsData.Segment(),virtualFile);
                                                    //virtualFile.createChildData(null,"");

                                                    file1 = ApplicationManager.getApplication().runWriteAction(
                                                            new ThrowableComputable<VirtualFile, IOException>() {
                                                                @Override
                                                                public VirtualFile compute() throws IOException {
                                                                    return virtualFile.findOrCreateChildData(null, fileName);
                                                                }
                                                            });
//                                                    VirtualFile file1 = VirtualFileManager.getInstance().getFileSystem(LocalFileSystemImpl.PROTOCOL).findFileByPath(virtualFile.getCanonicalPath() + "/" + file.getName() + "." + extention);
//                                                    Date date = file1.getUserData(FTPServiceProvider.FTP_LAST_SYNC);
                                                }
                                                System.out.println("saving date");
                                                if (file.getTimestamp() != null)
                                                    file1.putUserData(FTPServiceProvider.FTP_LAST_SYNC, file.getTimestamp().getTime());
                                                ((VirtualFileSystemEntry) file1).setFileIndexed(false);

                                                OutputStream outputStream = new FileOutputStream(file1.getCanonicalPath());
//                                                OutputStream outputStream = file1.getOutputStream(null);
                                                while (line != null) {
                                                    if (line.length() > 72 && extention.equals("asm")) {
                                                        line = line.substring(0, 72);
                                                    }
                                                    outputStream.write((line + "\r\n").getBytes());
                                                    line = reader.readLine();
                                                }
                                                outputStream.close();
                                                FileBasedIndex.getInstance().requestReindex(file1);
                                            } catch (IOException e) {
                                                System.out.println(e.getMessage());
                                                e.printStackTrace();
                                                Notifications.Bus.notify(group.createNotification("Error ",
                                                        "something wrong happened while downloading " + file.getName() +
                                                                "\n Unexpected IO error. Connection might have been interrupted", NotificationType.ERROR, null));

                                            }
                                        }
                                    });
                                    remote.close();
                                    client.completePendingCommand();

                                    virtualFile.refresh(true, true);

//                                client.disconnect();
                                } catch (IOException e1) {
                                    e1.printStackTrace();
                                }
                                if (client.isConnected()) break; // from retry loop
                                Thread.currentThread().wait(1000);
                                System.out.println("FTP reconnecting");
                                client.connect(settingsComponent.getHost());
                                client.login(username, password);
                                retry += 1;
                            }
                            while (retry < RECONNECT_TRIES);
                            if (retry >= RECONNECT_TRIES) {
                                Notifications.Bus.notify(group.createNotification("Error ",
                                        "something wrong happened while downloading " + file.getName() +
                                                "\n Attempts to reconnect and continue failed. \n Try to redownload files later", NotificationType.ERROR, null));
                                return;
                            }


                        }

                    }

                    //client.disconnect();

                } catch (IOException e) {
                    System.out.println(e.toString());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

//                FileBasedIndex.getInstance().requestRebuild(FTPLastSyncIndex.FTP_ID);
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
