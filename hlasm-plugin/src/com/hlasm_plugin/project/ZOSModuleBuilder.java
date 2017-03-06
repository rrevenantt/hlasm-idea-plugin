package com.hlasm_plugin.project;

import com.hlasm_plugin.HlasmIcons;
import com.intellij.ide.util.projectWizard.ModuleBuilder;
import com.intellij.ide.util.projectWizard.ModuleWizardStep;
import com.intellij.ide.util.projectWizard.ProjectWizardStepFactory;
import com.intellij.ide.util.projectWizard.WizardContext;
import com.intellij.openapi.Disposable;
import com.intellij.openapi.module.ModuleType;
import com.intellij.openapi.module.StdModuleTypes;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.roots.ModifiableRootModel;
import com.intellij.openapi.roots.ui.configuration.ModulesProvider;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.openapi.vfs.LocalFileSystem;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.io.File;

/**
 * Created by anisik on 09.08.2016.
 */
public class ZOSModuleBuilder extends ModuleBuilder {
    @Override
    public void setupRootModel(ModifiableRootModel modifiableRootModel) throws ConfigurationException {
        String path = FileUtil.toSystemIndependentName(getContentEntryPath());
        new File(path).mkdirs();
        modifiableRootModel.addContentEntry(LocalFileSystem.getInstance().refreshAndFindFileByPath(path));
        modifiableRootModel.inheritSdk();

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

    @Override
    public ModuleWizardStep[] createWizardSteps(@NotNull WizardContext wizardContext, @NotNull ModulesProvider modulesProvider) {
        System.out.println("createSteps module");
        final ProjectWizardStepFactory stepFactory = ProjectWizardStepFactory.getInstance();
        return new ModuleWizardStep[]{
                new ModuleWizardStep() {
                    @Override
                    public JComponent getComponent() {
                        return new JLabel("asdfasdfasdfasdfa");
                    }

                    @Override
                    public void updateDataModel() {

                    }
                }
        };
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
