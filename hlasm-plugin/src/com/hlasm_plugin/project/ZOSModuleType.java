package com.hlasm_plugin.project;

import com.hlasm_plugin.HlasmIcons;
import com.intellij.ide.util.projectWizard.*;
import com.intellij.openapi.module.ModuleType;
import com.intellij.openapi.projectRoots.SdkTypeId;
import com.intellij.openapi.roots.ui.configuration.ModulesProvider;
import com.intellij.openapi.util.Condition;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sun.security.pkcs11.Secmod;

import javax.swing.*;

/**
 * Created by anisik on 09.08.2016.
 */
public class ZOSModuleType extends ModuleType<ZOSModuleBuilder> {
    public static final ZOSModuleType INSTANCE= new ZOSModuleType();

    public ZOSModuleType(@NotNull @NonNls String id) {
        super(id);
    }

    public ZOSModuleType() {
        super("ZOS");
    }

    @NotNull
    @Override
    public ZOSModuleBuilder createModuleBuilder() {
        return new ZOSModuleBuilder();
    }


    @NotNull
    @Override
    public String getName() {
        return "ZOS";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "asdfasdfasfafasfasfasdfff";
    }

    @Override
    public Icon getBigIcon() {
        return HlasmIcons.HLASM;
    }

    @Override
    public Icon getNodeIcon(@Deprecated boolean isOpened) {
        return HlasmIcons.HLASM;
    }

    @NotNull
    @Override
    public ModuleWizardStep[] createWizardSteps(@NotNull WizardContext wizardContext, @NotNull ZOSModuleBuilder moduleBuilder, @NotNull ModulesProvider modulesProvider) {
        System.out.println("Module type createSteps");
        return super.createWizardSteps(wizardContext, moduleBuilder, modulesProvider);
    }

    public static ZOSModuleType getInstance() {
        return INSTANCE;
    }

    @Nullable
    @Override
    public ModuleWizardStep modifySettingsStep(@NotNull SettingsStep settingsStep, @NotNull ModuleBuilder moduleBuilder) {
        //return super.modifySettingsStep(settingsStep, moduleBuilder);
        return new ModuleWizardStep() {
            @Override
            public JComponent getComponent() {
                return new JLabel("custom module settings");
            }

            @Override
            public void updateDataModel() {

            }
        };
    }
}
