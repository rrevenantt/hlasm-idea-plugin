package com.ftp_plugin;

import com.intellij.notification.*;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.progress.Task;
import com.intellij.openapi.vfs.VirtualFile;
import org.apache.commons.net.ftp.FTPClient;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created by anisik on 09.06.2016.
 */
public class HlasmPutRemotePDSAction extends AnAction {
    public static final int SIMULT_FTP_CONN = 2;

    @Override
    public void actionPerformed(AnActionEvent ev) {
        VirtualFile virtualFile = ev.getData(PlatformDataKeys.VIRTUAL_FILE);
        VirtualFile[] virtualFiles;

//        FTPClient client = new FTPClient();
//        client.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out), true));

        LogonSettingsComponent settingsComponent = (LogonSettingsComponent) ev.getProject().getComponent("LogonSettingsComponent");
        if (settingsComponent == null || settingsComponent.getUsername().equals("")) {
            // create new logon info
            (new LogonSettingsAction()).actionPerformed(ev);
            return;
        }


        //FileInputStream in = new FileInputStream("test.txt");
        Semaphore s = new Semaphore(SIMULT_FTP_CONN);
        //client.storeFile("EIPINIT",in);
        try {
            s.acquire();
        }
        catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        if (virtualFile != null && virtualFile.isDirectory()) {
            //FTPFile[] files = client.listFiles();
            virtualFiles = virtualFile.getChildren();
        } else if (virtualFile != null ) {
            virtualFiles = new VirtualFile[]{virtualFile};
        } else {
            virtualFiles = new VirtualFile[]{};
        }
//            client.disconnect();
        System.out.println(virtualFiles.length);
        System.out.println(virtualFile.getExtension());
        System.out.println(virtualFile.getName());

        for (VirtualFile file : virtualFiles
                ) {

            FileDocumentManager.getInstance().saveDocument(FileDocumentManager.getInstance().getDocument(file));

            if (!file.isDirectory()) {

                ProgressManager.getInstance().run(new Task.Backgroundable(ev.getProject(), "Uploading", false) {
                    @Override
                    public void run(@NotNull ProgressIndicator indicator) {
                        try {
                            s.acquire();
                            FTPClient client = FTPServiceProvider.createFTPClient(virtualFile, settingsComponent,settingsComponent.getHost());
                            FTPServiceProvider.uploadFile(client, virtualFile);

                            indicator.setFraction(1.0);

                            client.disconnect();
                            System.out.println("upload finished");
                            s.release();

                        } catch (IOException | InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                });

            }
        }

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String text = "";
                    if (!s.tryAcquire(SIMULT_FTP_CONN,virtualFiles.length * 10, TimeUnit.SECONDS)){
                        text = "Upload failed";
                    }
                    else {
                        text = "Upload finished";
                    }

                    NotificationGroup group = NotificationGroup.findRegisteredGroup("MF-UI Information LogOnly");
                    if (group == null){
                        group = NotificationGroup.logOnlyGroup("MF-UI Information LogOnly");
                    }

                    Notifications.Bus.notify(group.createNotification(text,NotificationType.INFORMATION));
                    s.release();

                }
                catch (InterruptedException e){
                    System.err.println(e.getMessage());
                }
            }
        });
        thread.start();
        s.release();
    }

    @Override
    public void update(AnActionEvent e){
        VirtualFile virtualFile = e.getData(PlatformDataKeys.VIRTUAL_FILE);
        e.getPresentation().setVisible(virtualFile != null /*&& (virtualFile.isDirectory()
                || virtualFile.getExtension().equals("asm"))*/);
    }
}
