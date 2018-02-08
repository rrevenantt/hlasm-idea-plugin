package com.ftp_plugin;

import com.intellij.ide.util.PropertiesComponent;
import com.intellij.notification.NotificationGroup;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.application.TransactionGuardImpl;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.fileTypes.PlainTextFileType;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowContentUiType;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.testFramework.LightVirtualFile;
import com.intellij.ui.Gray;
import com.intellij.ui.content.ContentFactory;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SclmToolWindowFactory implements ToolWindowFactory {
    private JPanel myToolWindowContent;
    private JTextField textLpar;
    private JTextField textUser;
    private JPasswordField passwordField;
    private JTextField textProject;
    private JTextField textGroup;
    private JTextField textType;
    private JButton refreshButton;
    private JList<String> list1;
    private JScrollPane scrollPane1;

    private ListCellRenderer myRenderer = new DefaultListCellRenderer() {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            setBorder(BorderFactory.createEmptyBorder());
            return this;
        }
    };

    private FTPClient ftpClient;
    private Lock lock = new ReentrantLock();
    private String datasetSCLM;
    private ConcurrentMap<String, WeakReference<VirtualFile>> sysoutsCache = new ConcurrentHashMap<>();
    private final NotificationGroup groupError = NotificationGroup.findRegisteredGroup("MF-UI Error") == null ?
            NotificationGroup.balloonGroup("MF-UI Error") : NotificationGroup.findRegisteredGroup("MF-UI Error");
    private final NotificationGroup groupWarning = NotificationGroup.findRegisteredGroup("MF-UI Warning") == null ?
            NotificationGroup.balloonGroup("MF-UI Warning") : NotificationGroup.findRegisteredGroup("MF-UI Warning");

    public SclmToolWindowFactory() {
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        myToolWindowContent = new JPanel();
        myToolWindowContent.setLayout(new GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), -1, -1));
        myToolWindowContent.setMaximumSize(new Dimension(600, 100));
        myToolWindowContent.setMinimumSize(new Dimension(400, 50));
        myToolWindowContent.setPreferredSize(new Dimension(500, 80));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(1, 9, new Insets(0, 0, 0, 0), -1, -1));
        myToolWindowContent.add(panel1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        textUser = new JTextField();
        Font textUserFont = this.$$$getFont$$$("Consolas", -1, 12, textUser.getFont());
        if (textUserFont != null) textUser.setFont(textUserFont);
        textUser.setText("");
        panel1.add(textUser, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(70, 25), null, 0, false));
        final JLabel label1 = new JLabel();
        Font label1Font = this.$$$getFont$$$("Consolas", -1, -1, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setText("Password");
        panel1.add(label1, new GridConstraints(0, 4, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        refreshButton = new JButton();
        Font refreshButtonFont = this.$$$getFont$$$("Consolas", -1, -1, refreshButton.getFont());
        if (refreshButtonFont != null) refreshButton.setFont(refreshButtonFont);
        refreshButton.setText("Refresh");
        panel1.add(refreshButton, new GridConstraints(0, 7, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        Font label2Font = this.$$$getFont$$$("Consolas", -1, -1, label2.getFont());
        if (label2Font != null) label2.setFont(label2Font);
        label2.setText(" User");
        panel1.add(label2, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        passwordField = new JPasswordField();
        Font passwordFieldFont = this.$$$getFont$$$("Consolas", -1, 12, passwordField.getFont());
        if (passwordFieldFont != null) passwordField.setFont(passwordFieldFont);
        panel1.add(passwordField, new GridConstraints(0, 5, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(70, 25), null, 0, false));
        final Spacer spacer1 = new Spacer();
        panel1.add(spacer1, new GridConstraints(0, 6, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, new Dimension(-1, 11), null, 0, false));
        final JLabel label3 = new JLabel();
        Font label3Font = this.$$$getFont$$$("Consolas", -1, -1, label3.getFont());
        if (label3Font != null) label3.setFont(label3Font);
        label3.setText("LPAR IP");
        panel1.add(label3, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        textLpar = new JTextField();
        Font textLparFont = this.$$$getFont$$$("Consolas", -1, 12, textLpar.getFont());
        if (textLparFont != null) textLpar.setFont(textLparFont);
        panel1.add(textLpar, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(135, 23), null, 0, false));
        final Spacer spacer2 = new Spacer();
        panel1.add(spacer2, new GridConstraints(0, 8, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayoutManager(1, 7, new Insets(0, 0, 0, 0), -1, -1));
        Font panel2Font = this.$$$getFont$$$("Consolas", -1, -1, panel2.getFont());
        if (panel2Font != null) panel2.setFont(panel2Font);
        myToolWindowContent.add(panel2, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        textProject = new JTextField();
        Font textProjectFont = this.$$$getFont$$$("Consolas", -1, 12, textProject.getFont());
        if (textProjectFont != null) textProject.setFont(textProjectFont);
        textProject.setText("");
        panel2.add(textProject, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, 1, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        textGroup = new JTextField();
        Font textGroupFont = this.$$$getFont$$$("Consolas", -1, 12, textGroup.getFont());
        if (textGroupFont != null) textGroup.setFont(textGroupFont);
        textGroup.setText("");
        panel2.add(textGroup, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label4 = new JLabel();
        Font label4Font = this.$$$getFont$$$("Consolas", -1, -1, label4.getFont());
        if (label4Font != null) label4.setFont(label4Font);
        label4.setText("Group");
        panel2.add(label4, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label5 = new JLabel();
        Font label5Font = this.$$$getFont$$$("Consolas", -1, -1, label5.getFont());
        if (label5Font != null) label5.setFont(label5Font);
        label5.setText(" Project");
        panel2.add(label5, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        textType = new JTextField();
        Font textTypeFont = this.$$$getFont$$$("Consolas", -1, 12, textType.getFont());
        if (textTypeFont != null) textType.setFont(textTypeFont);
        panel2.add(textType, new GridConstraints(0, 5, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label6 = new JLabel();
        Font label6Font = this.$$$getFont$$$("Consolas", -1, -1, label6.getFont());
        if (label6Font != null) label6.setFont(label6Font);
        label6.setText("Type");
        panel2.add(label6, new GridConstraints(0, 4, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer3 = new Spacer();
        panel2.add(spacer3, new GridConstraints(0, 6, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        scrollPane1 = new JScrollPane();
        myToolWindowContent.add(scrollPane1, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        list1 = new JList();
        Font list1Font = this.$$$getFont$$$("Consolas", -1, 12, list1.getFont());
        if (list1Font != null) list1.setFont(list1Font);
        list1.setSelectionMode(0);
        scrollPane1.setViewportView(list1);
        label1.setLabelFor(passwordField);
        label2.setLabelFor(textUser);
        label3.setLabelFor(textLpar);
        label4.setLabelFor(textGroup);
        label5.setLabelFor(textProject);
        label6.setLabelFor(textType);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return myToolWindowContent;
    }

    public class FTPUpdater extends SwingWorker<Void, Void> {
        private Project project;

        FTPUpdater(@NotNull Project project) {
            this.project = project;
        }

        private ArrayList<String> fileList = new ArrayList<>();

        @Override
        protected Void doInBackground() throws Exception {

            lock.lock();
            try {
                FTPFile[] Sclmfiles = ftpClient.listFiles();
                if (Sclmfiles.length == 0) {
                    Notifications.Bus.notify(groupWarning.createNotification("SCLM Project",
                            "In the project no members found", NotificationType.WARNING, null));
                } else {
                    fileList.add("    Member             Text     Chg Date");
                    System.out.println("    Member             Text     Chg Date");
                    for (FTPFile file : Sclmfiles) {
                        Date fileDate = file.getTimestamp().getTime();
                        String fileName = alignString(file.getName(), 8 - file.getName().length());
                        String fileGroup = alignString(textGroup.getText(), 8 - textGroup.getText().length());
                        System.out.println("    " + fileName + "           " + fileGroup + " " + fileDate);
                        fileList.add("    " + fileName + "           " + fileGroup + " " + fileDate);
                    }
                }
            } catch (IOException e1) {
                System.err.println(e1.getMessage());
                Notifications.Bus.notify(groupError.createNotification("SCLM Project",
                        e1.getMessage(), NotificationType.ERROR, null));
            }
            lock.unlock();

            return null;
        }

        @Override
        protected void done() {
            String[] result = {""};
            result = fileList.toArray(result);
            refreshButton.setEnabled(true);
            refreshButton.setText("Refresh");
            list1.setListData(result);
            list1.updateUI();
        }
    }

    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        PropertiesComponent properties = PropertiesComponent.getInstance(project);
        textLpar.setText(properties.getValue("FTPSclmHost", ""));
        textUser.setText(properties.getValue("FTPSclmUser", ""));
        passwordField.setText(properties.getValue("FTPSclmPassword", ""));
        textProject.setText(properties.getValue("FTPSclmProject", ""));
        textGroup.setText(properties.getValue("FTPSclmGroup", ""));
        textType.setText(properties.getValue("FTPSclmType", ""));
        refreshButton.addActionListener(e -> {
            System.out.println("SCLM Host: " + textLpar.getText() + " User: " + textUser.getText() + " Password: " + passwordField.getText());

            refreshButton.setEnabled(false);
            refreshButton.setText("Updating..");
            refreshButton.updateUI();

            if (!(properties.getValue("FTPSclmHost", "").equals(textLpar.getText())
                    && properties.getValue("FTPSclmUser", "").equals(textUser.getText())
                    && properties.getValue("FTPSclmPassword", "").equals(passwordField.getText())
                    && properties.getValue("FTPSclmProject", "").equals(textProject.getText())
                    && properties.getValue("FTPSclmGroup", "").equals(textGroup.getText())
                    && properties.getValue("FTPSclmType", "").equals(textType.getText()))
                    || ftpClient == null || !ftpClient.isConnected()) {
                properties.setValue("FTPSclmHost", textLpar.getText());
                properties.setValue("FTPSclmUser", textUser.getText());
                properties.setValue("FTPSclmPassword", passwordField.getText());
                properties.setValue("FTPSclmProject", textProject.getText());
                properties.setValue("FTPSclmGroup", textGroup.getText());
                properties.setValue("FTPSclmType", textType.getText());
                lock.lock();
                try {
                    if (ftpClient != null && ftpClient.isConnected()) {
                        ftpClient.logout();
                        ftpClient.disconnect();
                    }
                    ftpClient = new FTPClient();
                    ftpClient.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out), true));
                    ftpClient.connect(properties.getValue("FTPSclmHost", ""), Integer.parseInt("21"));
                    ftpClient.login(properties.getValue("FTPSclmUser", ""), properties.getValue("FTPSclmPassword", ""));
                    datasetSCLM = "'SCLM." + properties.getValue("FTPSclmProject", "") + "." +
                            properties.getValue("FTPSclmGroup", "") + "." +
                            properties.getValue("FTPSclmType", "") + "'";
                    System.out.println("SCLM Getting members from dataset: " + datasetSCLM);
                    ftpClient.changeWorkingDirectory(datasetSCLM);
                    ftpClient.setKeepAlive(true);

                } catch (IOException e1) {
                    System.err.println(e1.getMessage());
                    Notifications.Bus.notify(groupError.createNotification("SCLM Project",
                            e1.getMessage(), NotificationType.ERROR, null));

                }
                lock.unlock();
            }
            SclmToolWindowFactory.FTPUpdater worker = new SclmToolWindowFactory.FTPUpdater(project);
            worker.execute();
        });
        list1.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Gray._50), "SCLM files"),
                BorderFactory.createEtchedBorder(EtchedBorder.LOWERED)));
        list1.setCellRenderer(myRenderer);
        String[] data = new String[1];
        data[0] = "    Member             Text     Chg Date";
        list1.setListData(data);

        list1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if ((e.getClickCount() > 0) && (e.getClickCount() >= 2)) {
                    String fileInfo = list1.getModel().getElementAt(list1.locationToIndex(e.getPoint()));
                    String fileNamePre = fileInfo.split(" ")[4];
                    lock.lock();
                    try {
                        InputStream remote = ftpClient.retrieveFileStream(fileNamePre);
                        final VirtualFile[] openFile = new VirtualFile[1];
                        TransactionGuardImpl.getInstance().submitTransactionAndWait(() -> {
                            ApplicationManager.getApplication().runWriteAction(() -> {
                                try {
                                    BufferedReader reader = new BufferedReader(new InputStreamReader(remote));
                                    String line = reader.readLine();
                                    if (line == null) {
                                        Notifications.Bus.notify(groupError.createNotification("SCLM Project",
                                                "Possibly file is locked on target LPAR", NotificationType.ERROR, null));
                                        remote.close();
                                        return;
                                    }
                                    String extention = "asm";
                                    if (line.startsWith("//")) {
                                        extention = "jcl";
                                    } else if (line.matches("[ ]* /\\* [^*]+? \\*/ .*")) {
                                        extention = "rexx";
                                    }
                                    final String fileName = fileNamePre + "." + extention;

                                    VirtualFile cachedSysout = null;
                                    if (sysoutsCache.get(fileName) != null) {
                                        sysoutsCache.remove(fileName);
                                    }
                                    VirtualFile sysout = new LightVirtualFile(fileName, PlainTextFileType.INSTANCE, "");
                                    sysoutsCache.put(fileName, new WeakReference<>(sysout));
                                    cachedSysout = sysout;
                                    OutputStream out = sysout.getOutputStream(null);
                                    while (line != null) {
                                        out.write((line + "\r\n").getBytes());
                                        line = reader.readLine();
                                    }
                                    out.close();
                                    sysout.refresh(true, false);
                                    openFile[0] = cachedSysout;
                                } catch (IOException e1) {
                                    System.err.println(e1.getMessage());
                                    Notifications.Bus.notify(groupError.createNotification("SCLM Project",
                                            e1.getMessage(), NotificationType.ERROR, null));
                                }
                            });
                        });
                        remote.close();
                        ftpClient.completePendingCommand();
                        FileEditorManager.getInstance(project).openFile(openFile[0], true, true);
                    } catch (IOException e1) {
                        System.err.println(e1.getMessage());
                        Notifications.Bus.notify(groupError.createNotification("SCLM Project",
                                e1.getMessage(), NotificationType.ERROR, null));
                    }
                    lock.unlock();
                }
            }
        });

        toolWindow.setTitle("SCLM");
        toolWindow.setContentUiType(ToolWindowContentUiType.TABBED, null);
        toolWindow.getContentManager().addContent(
                ContentFactory.SERVICE.getInstance().createContent(myToolWindowContent, "", true));
    }

    private String alignString(String line, int numberSpaces) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < numberSpaces; ++i)
            builder.append(" ");
        return (line + builder.toString());
    }
}