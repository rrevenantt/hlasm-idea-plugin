package com.ftp_plugin;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;

public class LogonSettingsAction extends AnAction  {

    @Override
    public void actionPerformed(AnActionEvent event) {
        Project project = event.getData(PlatformDataKeys.PROJECT);
        if(project == null) {
            Messages.showMessageDialog(project, "Project is inactive", "Warning", Messages.getWarningIcon());
            return;
        }

        LogonSettingsComponent component = (LogonSettingsComponent)project.getComponent("LogonSettingsComponent");
        if(component == null) {
            Messages.showMessageDialog(project, "Component is inactive", "Warning", Messages.getWarningIcon());
            return;
        }

        LogonSettingsDialog dialog = new LogonSettingsDialog(project, component);
        dialog.show();

        if(dialog.getExitCode() == LogonSettingsDialog.OK_EXIT_CODE) {
            component.setHost(dialog.getHost());
            component.setUsername(dialog.getUsername());
            component.setPassword(dialog.getPassword());
            component.setInitDir(dialog.getInitDir());
            component.setPort(dialog.getPort());

            sendNotification(project, component);
        }
    }

    // For debug reason to see what actually was saved. Remove it if the action works fine.
    private void sendNotification(Project project, LogonSettingsComponent component) {
        String text = "It's not the pass you are looking for...<br>" +
                "<br><b>Host:    </b> '" + component.getHost()       + "'" +
                "<br><b>Username:</b> '" + component.getUsername()   + "'" +
                "<br><b>Port:</b> '" + component.getPort()   + "'";

        String title = "All changes have been saved";

        Notification notification = new Notification("MF-UI Debug", title, text, NotificationType.INFORMATION);
        Notifications.Bus.notify(notification, project);
    }
}
