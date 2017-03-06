package com.ftp_plugin;

import com.intellij.notification.Notification;
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

/**
 * Created by anisik on 25.07.2016.
 */
public class JclFTPSubmitAction extends AnAction {
    @Override
    public void actionPerformed(AnActionEvent ev) {
        VirtualFile virtualFile = ev.getData(PlatformDataKeys.VIRTUAL_FILE);
        LogonSettingsComponent settingsComponent = (LogonSettingsComponent)ev.getProject().getComponent("LogonSettingsComponent");
        if (settingsComponent == null){
            // create new logon info
            (new LogonSettingsAction()).actionPerformed(ev);
            return;
        }
        FileDocumentManager.getInstance().saveDocument(FileDocumentManager.getInstance().getDocument(virtualFile));
        ProgressManager.getInstance().run(new Task.Backgroundable(ev.getProject(), "Running", false) {
            @Override
            public void run(@NotNull ProgressIndicator indicator) {
//                ApplicationManagerEx.getApplicationEx().runReadAction(new Runnable() {
//                    @Override
//                    public void run() {
                        FTPClient client = FTPServiceProvider.createJESFTPClient(virtualFile,settingsComponent);
                        FTPServiceProvider.submitJob(virtualFile, ev.getProject(), client, new FTPServiceProvider.JobSubmitCallback() {
                            @Override
                            public void progressResult(String info) {
                                indicator.setFraction(0.5);
                                indicator.setText(info);
                            }

                            @Override
                            public void completeResult(Notification notification) {
                                Notifications.Bus.notify(notification, ev.getProject());
                            }
                        });
                        try {
                            client.disconnect();
                        }
                        catch (IOException e){
                            e.printStackTrace();
                        }

//                    }
//                });

            }
        });

    }

    @Override
    public void update(AnActionEvent e){
        VirtualFile virtualFile = e.getData(PlatformDataKeys.VIRTUAL_FILE);
        e.getPresentation().setVisible(virtualFile.getExtension() != null && (virtualFile.getExtension().equalsIgnoreCase("jcl")
                        || virtualFile.getExtension().equalsIgnoreCase("jclt")));
    }
}
