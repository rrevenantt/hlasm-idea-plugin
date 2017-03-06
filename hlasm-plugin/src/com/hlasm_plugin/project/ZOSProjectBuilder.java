package com.hlasm_plugin.project;

import com.hlasm_plugin.HlasmIcons;
import com.intellij.ide.util.projectWizard.ProjectBuilder;
import com.intellij.openapi.module.ModifiableModuleModel;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ui.configuration.ModulesProvider;
import com.intellij.packaging.artifacts.ModifiableArtifactModel;
import com.intellij.projectImport.ProjectImportBuilder;
import com.intellij.projectImport.ProjectImportProvider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.List;

/**
 * Created by anisik on 09.08.2016.
 */
public class ZOSProjectBuilder extends ProjectImportBuilder<ZOSProject> {
    public ZOSProjectBuilder() {
        System.out.println("ProjectImportBuilder");
    }

    @NotNull
    @Override
    public String getName() {
        return "ZOS";
    }

    @Override
    public List<ZOSProject> getList() {
        return null;
    }

    @Override
    public void setOpenProjectSettingsAfter(boolean on) {

    }

    @Override
    public List<Module> commit(@NotNull Project project, ModifiableModuleModel model, ModulesProvider modulesProvider) {
        return super.commit(project, model, modulesProvider);
    }

    @Nullable
    @Override
    public List<Module> commit(Project project, ModifiableModuleModel model, ModulesProvider modulesProvider, ModifiableArtifactModel artifactModel) {
        return null;
    }

    @Override
    public boolean isMarked(ZOSProject element) {
        return false;
    }

    @Override
    public void setList(List<ZOSProject> list) throws ConfigurationException {

    }

    @Override
    public Icon getIcon() {
        return HlasmIcons.HLASM;
    }
}
