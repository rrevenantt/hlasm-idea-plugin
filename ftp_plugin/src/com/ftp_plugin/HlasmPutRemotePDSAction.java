package com.ftp_plugin;

import com.intellij.notification.NotificationGroup;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
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

import java.io.IOException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created by anisik on 09.06.2016.
 */
public class HlasmPutRemotePDSAction extends AnAction {
    public static final int SIMULT_FTP_CONN = 2;
    private static final NotificationGroup groupError = NotificationGroup.findRegisteredGroup("MF-UI Error") == null ?
            NotificationGroup.balloonGroup("MF-UI Error") : NotificationGroup.findRegisteredGroup("MF-UI Error");

    private static final NotificationGroup groupInform = NotificationGroup.findRegisteredGroup("MF-UI Information") == null ?
            NotificationGroup.balloonGroup("MF-UI Information") : NotificationGroup.findRegisteredGroup("MF-UI Information");

    @Override
    public void actionPerformed(AnActionEvent ev) {
        VirtualFile virtualFile = ev.getData(PlatformDataKeys.VIRTUAL_FILE);
        VirtualFile[] virtualFiles;

        LogonSettingsComponent settingsComponent = (LogonSettingsComponent) ev.getProject().getComponent("LogonSettingsComponent");
        if (settingsComponent == null || settingsComponent.getUsername().equals("")) {
            // create new logon info
            (new LogonSettingsAction()).actionPerformed(ev);
            return;
        }

        Semaphore s = new Semaphore(SIMULT_FTP_CONN);

        if (virtualFile != null && virtualFile.isDirectory()) {
            virtualFiles = virtualFile.getChildren();
        } else if (virtualFile != null) {
            virtualFiles = new VirtualFile[]{virtualFile};
        } else {
            virtualFiles = new VirtualFile[]{};
        }

        System.out.println("HLASMPUTPDS Number of files for upload: " +  virtualFiles.length);
        System.out.println("HLASMPUTPDS Extension of file " + virtualFile.getName() + " for upload: " +
                virtualFile.getExtension());

        for (VirtualFile file : virtualFiles) {

            FileDocumentManager.getInstance().saveDocument(FileDocumentManager.getInstance().getDocument(file));

            if (!file.isDirectory()) {
                ProgressManager.getInstance().run(new Task.Backgroundable(ev.getProject(),
                        "Uploading", false) {
                    @Override
                    public void run(@NotNull ProgressIndicator indicator) {
                        try {
                            s.acquire();
                            FTPClient client = FTPServiceProvider.createFTPClient(file, settingsComponent, settingsComponent.getHost());
                            FTPServiceProvider.uploadFile(client, file);
                            indicator.setFraction(1.0);
                            client.disconnect();
                            System.out.println("HLASMPUTPDS Upload finished for file: " + file.getName());

                        } catch (IOException | InterruptedException e) {
                            System.err.println("HLASMPUTPDS " + e.getMessage());
                            Notifications.Bus.notify(groupError.createNotification("Uploading files",
                                    e.getMessage(), NotificationType.ERROR, null));
                        } finally {
                            s.release();
                        }
                    }
                });
            }
        }

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                    String status;
                    if (!s.tryAcquire(SIMULT_FTP_CONN, virtualFiles.length * 10, TimeUnit.SECONDS)) {
                        status = "Uploading not completed";
                        System.err.println("HLASMPUTPDS " + status);
                    } else {
                        status = "Uploading completed successfully";
                        System.out.println("HLASMPUTPDS " + status);
                        s.release(SIMULT_FTP_CONN);
                    }
                } catch (InterruptedException e) {
                    System.err.println("HLASMPUTPDS " + e.getMessage());
                    Notifications.Bus.notify(groupError.createNotification("Uploading files",
                            e.getMessage(), NotificationType.ERROR, null));
                }

            }
        });
        thread.start();
    }

    @Override
    public void update(AnActionEvent e) {
        VirtualFile virtualFile = e.getData(PlatformDataKeys.VIRTUAL_FILE);
        e.getPresentation().setVisible(virtualFile != null);
    }
}
