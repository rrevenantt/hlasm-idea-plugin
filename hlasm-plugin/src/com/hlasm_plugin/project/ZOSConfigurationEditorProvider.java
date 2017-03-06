package com.hlasm_plugin.project;

import com.intellij.openapi.module.ModuleConfigurationEditor;
import com.intellij.openapi.roots.ui.configuration.CommonContentEntriesEditor;
import com.intellij.openapi.roots.ui.configuration.DefaultModuleConfigurationEditorFactory;
import com.intellij.openapi.roots.ui.configuration.ModuleConfigurationEditorProvider;
import com.intellij.openapi.roots.ui.configuration.ModuleConfigurationState;
import org.jetbrains.jps.model.module.JpsModuleSourceRootType;


/**
 * Created by anisik on 10.08.2016.
 */
public class ZOSConfigurationEditorProvider implements ModuleConfigurationEditorProvider {
    @Override
    public ModuleConfigurationEditor[] createEditors(ModuleConfigurationState state) {
        return new ModuleConfigurationEditor[]{
                new CommonContentEntriesEditor(state.getRootModel().getModule().getName(),state,new JpsModuleSourceRootType[]{}),
                DefaultModuleConfigurationEditorFactory.getInstance().createModuleContentRootsEditor(state),
                DefaultModuleConfigurationEditorFactory.getInstance().createOutputEditor(state)
        };
    }
}
