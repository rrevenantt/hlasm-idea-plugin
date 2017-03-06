package com.hlasm_plugin.project;

import com.intellij.ide.util.projectWizard.ModuleWizardStep;
import com.intellij.ide.util.projectWizard.ProjectWizardStepFactory;
import com.intellij.ide.util.projectWizard.WizardContext;
import com.intellij.projectImport.ProjectImportProvider;
import com.intellij.projectImport.ProjectImportWizardStep;

import javax.swing.*;

/**
 * Created by anisik on 09.08.2016.
 */
public class ZOSProjectImportProvider extends ProjectImportProvider {
    public ZOSProjectImportProvider(ZOSProjectBuilder builder) {
        super(builder);
        System.out.println("import provider created" + builder.getName());
    }

    @Override
    public ModuleWizardStep[] createSteps(WizardContext context) {
        System.out.println("createStepsProject");
        final ProjectWizardStepFactory stepFactory = ProjectWizardStepFactory.getInstance();
        return new ModuleWizardStep[]{
            new ProjectImportWizardStep(context) {
                @Override
                public JComponent getComponent() {
                    return new JLabel("wowwowwow");
                }

                @Override
                public void updateDataModel() {

                }
            },
            stepFactory.createNameAndLocationStep(context)
        };
    }
}
