package config;

import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.ConfigurationType;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

class RemoteHlasmConfigurationFactory extends ConfigurationFactory {
    private static final String FACTORY_NAME = "Remote code execution";

    RemoteHlasmConfigurationFactory(ConfigurationType type) {
        super(type);
    }

    @NotNull
    @Override
    public RunConfiguration createTemplateConfiguration(@NotNull Project project) {
        return new RemoteHlasmConfiguration(project, this, "HLASM");
    }

    @Override
    public String getName() {
        return FACTORY_NAME;
    }
}