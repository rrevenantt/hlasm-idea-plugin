package config;

import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.ConfigurationType;
import com.intellij.icons.AllIcons;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class HlasmConfigurationType implements ConfigurationType {

    @Override
    public String getDisplayName() {
        return "HLASM";
    }

    @Override
    public String getConfigurationTypeDescription() {
        return "Build and run your code remotely on the Mainframe";
    }

    @Override
    // todo: Add custom icon
    public Icon getIcon() {
        return AllIcons.General.Information;
    }

    @NotNull
    @Override
    public String getId() {
        return "HLASM_RUN_CONFIGURATION";
    }

    @Override
    // todo: Implement local code execution
    public ConfigurationFactory[] getConfigurationFactories() {
        return new ConfigurationFactory[]{
                // new LocalHlasmConfigurationFactory(this),
                new RemoteHlasmConfigurationFactory(this)
        };
    }
}