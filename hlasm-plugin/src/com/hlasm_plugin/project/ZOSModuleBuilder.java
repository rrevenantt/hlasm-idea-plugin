package com.hlasm_plugin.project;

import com.intellij.ide.util.projectWizard.*;
import com.intellij.openapi.Disposable;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleServiceManager;
import com.intellij.openapi.module.ModuleType;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.roots.ModifiableRootModel;
import com.intellij.openapi.roots.ui.configuration.ModulesProvider;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.ui.CollectionListModel;
import com.intellij.ui.ToolbarDecorator;
import com.intellij.ui.components.JBList;
import com.intellij.util.ArrayUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by anisik on 09.08.2016.
 */
public class ZOSModuleBuilder extends ModuleBuilder implements ModuleBuilderListener{

    public ZOSModuleBuilder() {
        addListener(this);
    }

    List<String> collectedDatasets = new LinkedList<>();

    @Override
    public void setupRootModel(ModifiableRootModel modifiableRootModel) throws ConfigurationException {
        String path = FileUtil.toSystemIndependentName(getContentEntryPath());
        System.out.println("adding content entry: " + path);
        new File(path).mkdirs();
        modifiableRootModel.addContentEntry(LocalFileSystem.getInstance().refreshAndFindFileByPath(path));


//        modifiableRootModel.inheritSdk();

    }

    @Override
    public ModuleType getModuleType() {
        return ZOSModuleType.getInstance();
    }

    @Override
    public String getDescription() {
        return "ZOS project creation. It can be SCLM project or JCL based one";
    }

    @Override
    public String getPresentableName() {
        return "z/OS";
    }

    @Nullable
    @Override
    public String getBuilderId() {
        return "ZOS";
    }

    public static JPanel createMacroConfigPanel(CollectionListModel<String> jobListModel){
         JList list;
         JTextField jobMemberName;
        JPanel editor = new JPanel();
        editor.setLayout(new BoxLayout(editor, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Configure dataset order for macro definition search");
        title.setAlignmentX( Component.LEFT_ALIGNMENT );
        title.setBorder(BorderFactory.createEmptyBorder(9,9,9,9));


        list = new JBList<>(jobListModel);
        list.setMinimumSize(new Dimension(300, 150));
        list.setMaximumSize(new Dimension(300, 150));
        list.setAlignmentX( Component.LEFT_ALIGNMENT );
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setSelectedIndex(0);


        jobMemberName = new JTextField();
        jobMemberName.setMinimumSize(new Dimension(300, 20));
        jobMemberName.setMaximumSize(new Dimension(300, 20));
        jobMemberName.setAlignmentX( Component.LEFT_ALIGNMENT );

        JButton addButton = new JButton("Add");
        addButton.setAlignmentX( Component.LEFT_ALIGNMENT );

        addButton.addActionListener(e -> {
                    if(!jobListModel.contains(jobMemberName.getText())) {
                        jobListModel.add(jobMemberName.getText());
                        jobMemberName.setText("");
                    }
                }
        );

        editor.add(title);

        editor.add(jobMemberName);
        editor.add(addButton);
        editor.add(list);


        final ToolbarDecorator decorator = ToolbarDecorator.createDecorator(list);

        decorator.setMoveUpAction(anActionButton -> {
            for ( int index:
                    list.getSelectedIndices()) {
                jobListModel.exchangeRows(index,index-1);
                list.removeSelectionInterval(index,index);
                list.addSelectionInterval(index-1,index-1);
            }
            list.updateUI();
        }).setMoveUpActionUpdater((actionEvent)->!list.isSelectedIndex(0) && list.getSelectedIndex() != -1)
                .setMoveUpActionName("Move up")
                .setMoveDownAction(anActionButton -> {
                    for ( int index:
                            ArrayUtil.reverseArray(list.getSelectedIndices())) {
                        jobListModel.exchangeRows(index,index+1);
                        list.removeSelectionInterval(index,index);
                        list.addSelectionInterval(index+1,index+1);
                    }
                    list.updateUI();
                } )
                .setMoveDownActionUpdater((actionEvent)-> !list.isSelectedIndex(jobListModel.getSize()-1) && list.getSelectedIndex() != -1)
                .setMoveUpActionName("Move up")
                .setRemoveAction(anActionButton -> {
                    for ( int index:
                            ArrayUtil.reverseArray(list.getSelectedIndices())) {
                        jobListModel.remove(index);
                    }
                    list.updateUI();
                } )
                .setRemoveActionUpdater(e -> list.getSelectedIndex() != -1)
                .setRemoveActionName("Remove");

        editor.add(decorator.createPanel());
        return editor;
    }

    @Override
    public ModuleWizardStep[] createWizardSteps(@NotNull WizardContext wizardContext, @NotNull ModulesProvider modulesProvider) {
        System.out.println("createSteps module");
        final ProjectWizardStepFactory stepFactory = ProjectWizardStepFactory.getInstance();
        return new ModuleWizardStep[]{
                new ModuleWizardStep() {

                    JPanel panel;
                    CollectionListModel<String> jobListModel = new CollectionListModel<>();

                    @Override
                    public JComponent getComponent() {

                        panel = createMacroConfigPanel(jobListModel);

                        return panel;
                    }

                    @Override
                    public void updateDataModel() {
                        collectedDatasets = new ArrayList<String> (jobListModel.toList());
                    }
                }
        };
    }

    @Override
    public void moduleCreated(@NotNull Module module) {
        ModuleServiceManager.getService(module,ZOSProjectService.class).setMacroConcatenation(collectedDatasets);
//        ModuleRootManager.getInstance(module).getModifiableModel().
    }

    @Nullable
    @Override
    public ModuleWizardStep getCustomOptionsStep(WizardContext context, Disposable parentDisposable) {
        return new ModuleWizardStep() {
            @Override
            public JComponent getComponent() {
                return new JLabel("test custom first step");
            }

            @Override
            public void updateDataModel() {

            }
        };
    }
}
