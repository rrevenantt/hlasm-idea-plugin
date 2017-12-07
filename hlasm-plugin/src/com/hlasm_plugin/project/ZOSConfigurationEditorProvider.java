package com.hlasm_plugin.project;

import com.intellij.openapi.module.ModuleConfigurationEditor;
import com.intellij.openapi.module.ModuleServiceManager;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.roots.ui.configuration.*;
import com.intellij.ui.CollectionListModel;
import org.jetbrains.annotations.Nls;
import org.jetbrains.jps.model.module.JpsModuleSourceRootType;

import javax.swing.*;


/**
 * Created by anisik on 10.08.2016.
 */
public class ZOSConfigurationEditorProvider implements ModuleConfigurationEditorProvider {
    @Override
    public ModuleConfigurationEditor[] createEditors(ModuleConfigurationState state) {
        return new ModuleConfigurationEditor[]{
                new CommonContentEntriesEditor(state.getRootModel().getModule().getName(),state,new JpsModuleSourceRootType[]{}),

                new ModuleElementsEditor(state){
                    private CollectionListModel<String> listModel;
                    @Override
                    protected JComponent createComponentImpl() {

                         listModel = new CollectionListModel<>(
                                ModuleServiceManager.getService(state.getRootModel().getModule(),ZOSProjectService.class).getMacroConcatenation());

                        return ZOSModuleBuilder.createMacroConfigPanel(listModel);

                    }

                    @Override
                    public boolean isModified() {
                        return !listModel.getItems().equals(ModuleServiceManager.getService(state.getRootModel().getModule(),ZOSProjectService.class).getMacroConcatenation());
                    }

                    @Override
                    public void apply() throws ConfigurationException {
                        ModuleServiceManager.getService(state.getRootModel().getModule(),ZOSProjectService.class).setMacroConcatenation(listModel.getItems());
                    }

                    @Nls
                    @Override
                    public String getDisplayName() {
                        return "Macros";
                    }
                }
        };
    }
}
