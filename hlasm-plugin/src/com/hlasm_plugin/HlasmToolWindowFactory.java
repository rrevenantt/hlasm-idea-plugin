package com.hlasm_plugin;

import com.hlasm_plugin.psi.HlasmPSIFileRoot;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.fileEditor.FileEditor;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.fileEditor.ex.FileEditorManagerEx;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowContentUiType;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.psi.PsiDocumentManager;
import com.intellij.psi.PsiFile;
import com.intellij.ui.content.ContentFactory;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.map_dump.controller.HexStringDumpMapper;
import com.map_dump.model.dsect.*;
import com.map_dump.model.dump.ControlBlockDump;
//import com.map_dump.model.log.SnapLog;
import com.map_dump.model.map.MappedDsect;
import groovy.lang.ExpandoMetaClass;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import groovy.util.Expando;
import org.codehaus.groovy.reflection.MixinInMetaClass;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by anisik on 26.07.2016.
 */
public class HlasmToolWindowFactory implements ToolWindowFactory {
    private Project localCopy;
    private HlasmPSIFileRoot localFileRoot = null;
    private JPanel myToolWindowContent;
    private JPanel HeadPanel;
    private JPanel BodyPanel;
    private JPanel SelectDSECTnamePanel;
    private JPanel SelectDSECTtypePanel;
    private JPanel SelectDSCETfilePanel;
    private JComboBox selectDSECTnameBox;
    private JComboBox selectDSECTtypeBox;
    private JTextField pathFile;
    private JButton browseButton;
    private JPanel InputDUMPpanel;
    private JPanel OutputDUMPpanel;
    private JEditorPane inputArea;
    private JEditorPane outputArea;


    public HlasmToolWindowFactory() {
//        selectDSECTnameBox.addItem("@QCREQ");
//        selectDSECTnameBox.addItem("@QCREQ2");
//
//        selectDSECTtypeBox.addItem("SNAP");

        browseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

 /*               JFileChooser jFileChooser = new JFileChooser();
                int retVal = jFileChooser.showOpenDialog(myToolWindowContent);
                if (retVal == JFileChooser.APPROVE_OPTION) {
                    File file = jFileChooser.getSelectedFile();
                    pathFile.setText(file.getAbsolutePath());
                    try {
                        inputArea.read(new FileReader(file.getAbsolutePath()), null);

                    } catch (IOException ex) {
                        System.out.println("Problem accessing file");
                    }
                    Dsect dsect = buildNewDsect();       // govno
                    HexStringDumpMapper mapper = new HexStringDumpMapper();
                    SnapLog snapLog = new SnapLog(inputArea.getText());
                    List<ControlBlockDump> cbdList = snapLog.getControlBlockDumpList();
                    MappedDsect mappedDsect = mapper.map(dsect, cbdList.get(0).dump.hexString);
                    outputArea.setText(mappedDsect.toString());
                } else {
                    System.out.println("Open file cancel");
                }
*/            }
        });
        selectDSECTnameBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
 /*               if (e.getItemSelectable().getSelectedObjects().length == 0)
                    return;
                FileEditorManagerEx fileEditor = FileEditorManagerEx.getInstanceEx(localCopy);
                Editor editor = fileEditor.getSelectedTextEditor();
                if (editor != null) {
                    PsiFile psiFile = PsiDocumentManager.getInstance(localCopy).getPsiFile(editor.getDocument());
                    if (psiFile.getLanguage() == HlasmLanguage.INSTANCE) {
                        HlasmPSIFileRoot fileRoot = (HlasmPSIFileRoot) psiFile;
                        localFileRoot = fileRoot;
                        for (String name :
                                fileRoot.dsects.keySet()) {
                            selectDSECTnameBox.addItem(name);
                        }
                    }
                }

                Dsect dsect = localFileRoot.dsects.get((String) e.getItemSelectable().getSelectedObjects()[0]);
                HexStringDumpMapper mapper = new HexStringDumpMapper();
                SnapLog snapLog = new SnapLog(inputArea.getText());
                List<ControlBlockDump> cbdList = snapLog.getControlBlockDumpList();
                MappedDsect mappedDsect = mapper.map(dsect, cbdList.get(0).dump.hexString);
                outputArea.setText(mappedDsect.toString());
*/            }
        });
        selectDSECTnameBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                if (localFileRoot == null) {
//                }
            }
        });
    }

    private static Dsect buildNewDsect() {
//        List<DsectStatement> dsList = new ArrayList<DsectStatement>();
//        dsList.add(new DsectStatement(0, "CTCVHDR", "DS", 1, C, 1, null));
//        dsList.add(new DsectStatement(4, "CTCVDEV@", "DS", 1, A, 4, null));
//        dsList.add(new DsectStatement(8, "CTCVCYCL", "DS", 1, VarType.X, 3, null));
//        dsList.add(new DsectStatement(11, "CTCVFLG1", "DS", 1, VarType.X, 1, null));
//        dsList.add(new DsectStatement(12, "LABEL1", "DS", 4, VarType.X, 1, null));
//        dsList.add(new DsectStatement(16, "LABEL2", "DS", 3, VarType.F, 4, null));
//        dsList.add(new DsectStatement(28, "LABEL2_2", "DS", 2, VarType.B, 2, null));
//        dsList.add(new DsectStatement(32, null, "DS", 0, VarType.H, 2, null));
//        dsList.add(new DsectStatement(32, "LABEL3", "DS", 2, VarType.Y, 4, null));
//        dsList.add(new DsectStatement(40, "LABEL3_3", "DS", 1, VarType.X, 1, null));
//        dsList.add(new DsectStatement(48, null, "DS", 0, VarType.D, 8, null));
//        dsList.add(new DsectStatement(48, "LABEL2", "DS", 2, VarType.F, 4, null));
//
        return new Dsect("@CTRKDS", null);
    }

    ///
    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        localCopy = project;
        toolWindow.setTitle("z/OS");
        toolWindow.setContentUiType(ToolWindowContentUiType.TABBED, null);
        toolWindow.getContentManager().addContent(
                ContentFactory.SERVICE.getInstance().createContent(myToolWindowContent, "", true));

       /* Class a = new GroovyClassLoader().parseClass("adf");
        Class b = HexStringDumpMapper.class;
        ExpandoMetaClass emc = new ExpandoMetaClass(b, false, true);
        try {
            GroovyObject aObj = (GroovyObject) a.newInstance();
            //    aObj.
        } catch (InstantiationException | IllegalAccessException e) {
        }*/


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
        HeadPanel = new JPanel();
        HeadPanel.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        myToolWindowContent.add(HeadPanel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        SelectDSECTnamePanel = new JPanel();
        SelectDSECTnamePanel.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        HeadPanel.add(SelectDSECTnamePanel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setEnabled(false);
        label1.setText("Select DSECT");
        SelectDSECTnamePanel.add(label1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        selectDSECTnameBox = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        selectDSECTnameBox.setModel(defaultComboBoxModel1);
        SelectDSECTnamePanel.add(selectDSECTnameBox, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        SelectDSECTtypePanel = new JPanel();
        SelectDSECTtypePanel.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        HeadPanel.add(SelectDSECTtypePanel, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setEnabled(false);
        label2.setText("Select DSECT type");
        SelectDSECTtypePanel.add(label2, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        selectDSECTtypeBox = new JComboBox();
        SelectDSECTtypePanel.add(selectDSECTtypeBox, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        SelectDSCETfilePanel = new JPanel();
        SelectDSCETfilePanel.setLayout(new GridLayoutManager(2, 2, new Insets(0, 0, 0, 0), -1, -1));
        HeadPanel.add(SelectDSCETfilePanel, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setEnabled(false);
        label3.setText("Select file for mapping");
        SelectDSCETfilePanel.add(label3, new GridConstraints(0, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        pathFile = new JTextField();
        pathFile.setEditable(false);
        pathFile.setEnabled(false);
        SelectDSCETfilePanel.add(pathFile, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        browseButton = new JButton();
        browseButton.setText("Browse");
        SelectDSCETfilePanel.add(browseButton, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        BodyPanel = new JPanel();
        BodyPanel.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        myToolWindowContent.add(BodyPanel, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        InputDUMPpanel = new JPanel();
        InputDUMPpanel.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        InputDUMPpanel.setEnabled(true);
        BodyPanel.add(InputDUMPpanel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setEnabled(false);
        label4.setText("Input");
        InputDUMPpanel.add(label4, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        inputArea = new JEditorPane();
        inputArea.setBackground(new Color(-12236470));
        InputDUMPpanel.add(inputArea, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JSeparator separator1 = new JSeparator();
        separator1.setOrientation(1);
        BodyPanel.add(separator1, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        OutputDUMPpanel = new JPanel();
        OutputDUMPpanel.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        BodyPanel.add(OutputDUMPpanel, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setEnabled(false);
        label5.setText("Output");
        OutputDUMPpanel.add(label5, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        outputArea = new JEditorPane();
        outputArea.setEditable(false);
        outputArea.setEnabled(false);
        OutputDUMPpanel.add(outputArea, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JSeparator separator2 = new JSeparator();
        myToolWindowContent.add(separator2, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return myToolWindowContent;
    }
}
