package com.ftp_plugin;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

class LogonSettingsDialog extends DialogWrapper {

    private final JTextField hostTextField;
    private final JTextField nameTextField;
    private final JPasswordField passTextField;

    LogonSettingsDialog(Project project, LogonSettingsComponent component) {
        super(project);

        hostTextField = new JTextField(component.getHost());
        nameTextField = new JTextField(component.getUsername());
        passTextField = new JPasswordField(component.getPassword());

        init();
        setTitle("MF Logon Settings");
    }

    String getHost() {
        return hostTextField.getText();
    }

    String getUsername() {
        return nameTextField.getText();
    }

    String getPassword() {
        return new String(passTextField.getPassword());
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(new JLabel("Host:"));
        panel.add(hostTextField);

        panel.add(new JLabel("Username:"));
        panel.add(nameTextField);

        panel.add(new JLabel("Password:"));
        panel.add(passTextField);

        return panel;
    }
}
