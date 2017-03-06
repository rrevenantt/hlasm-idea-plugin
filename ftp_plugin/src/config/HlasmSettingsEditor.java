package config;

import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.ui.components.JBList;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

class HlasmSettingsEditor extends SettingsEditor<RemoteHlasmConfiguration> {

    private JList list;
    private JTextField jobMemberName;
    private DefaultListModel<String> jobListModel;
    private LinkedList<String> jobs = new LinkedList<>();

    HlasmSettingsEditor(LinkedList<String> jobs) {
        this.jobs.addAll(jobs);
    }

    @Override
    protected void resetEditorFrom(RemoteHlasmConfiguration configuration) {
        jobMemberName.setText("");
    }

    @Override
    protected void applyEditorTo(RemoteHlasmConfiguration configuration) throws ConfigurationException {
        LinkedList<String> jobNames = configuration.getBuildJobs();

        for(int i = 0; i < jobNames.size(); i++) {
            if(!jobListModel.contains(jobNames.get(i))) {
                configuration.removeJob(jobNames.get(i));
                jobNames.remove(i);
                i--;
            }
        }

        for (int i = 0; i < jobListModel.size(); i++) {
            String job = jobListModel.get(i);
            if(!jobNames.contains(job)) {
                jobNames.add(job);
                configuration.addJob(job);
            }
        }
    }

    @NotNull
    @Override
    // todo: Сделать нормальный GUI
    protected JComponent createEditor() {
        JPanel editor = new JPanel();
        editor.setLayout(new BoxLayout(editor, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Add jobs to build and run your project");
        title.setAlignmentX( Component.LEFT_ALIGNMENT );

        jobListModel = new DefaultListModel<>();
        for(String job : jobs) {
            jobListModel.addElement(job);
        }

        list = new JBList(jobListModel);
        list.setMinimumSize(new Dimension(300, 150));
        list.setMaximumSize(new Dimension(300, 150));
        list.setAlignmentX( Component.LEFT_ALIGNMENT );

        jobMemberName = new JTextField();
        jobMemberName.setMinimumSize(new Dimension(300, 20));
        jobMemberName.setMaximumSize(new Dimension(300, 20));
        jobMemberName.setAlignmentX( Component.LEFT_ALIGNMENT );

        JButton addButton = new JButton("Add");
        addButton.setAlignmentX( Component.LEFT_ALIGNMENT );

        addButton.addActionListener(e -> {
                if(!jobListModel.contains(jobMemberName.getText())) {
                    jobListModel.addElement(jobMemberName.getText());
                    jobMemberName.setText("");
                }
            }
        );

        JButton removeButton = new JButton("Remove");
        removeButton.setAlignmentX( Component.LEFT_ALIGNMENT );

        removeButton.addActionListener(e -> {
                if(list.getSelectedIndex() >= 0) {
                    jobListModel.remove(list.getSelectedIndex());
                }
            }
        );

        editor.add(title);
        editor.add(jobMemberName);
        editor.add(addButton);
        editor.add(removeButton);
        editor.add(list);

        return editor;
    }

    private void createUIComponents() { }
}