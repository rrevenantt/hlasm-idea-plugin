package config;

//import com.github.rjeschke.txtmark.Run;
import com.hlasm_plugin.regex.HlasmRegexLibrary;
import com.intellij.execution.ExecutionException;
import com.intellij.execution.Executor;
import com.intellij.execution.configurations.*;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.InvalidDataException;
import com.intellij.openapi.util.WriteExternalException;
import org.jetbrains.annotations.NotNull;
import com.sun.istack.internal.Nullable;
import org.jdom.Element;

import java.util.Collections;
import java.util.LinkedList;
import java.util.regex.Pattern;

class RemoteHlasmConfiguration extends RunConfigurationBase {
    public static final Pattern jobname = Pattern.compile("(?:([A-Za-z0-9]+):)?(((?:[A-Za-z#@$][\\w#@$\\-]{1,7}\\.)*[A-Za-z#@$][\\w#@$\\-]{1,7})\\(([A-Za-z#@$][\\w#@$\\-]{1,7})\\))");


    private LinkedList<String> buildJobs = new LinkedList<>();

    LinkedList<String> getBuildJobs() {
        LinkedList<String> jobs = new LinkedList<>();
        jobs.addAll(buildJobs);
        return jobs;
    }

    void addJob(String job) {
        buildJobs.add(job);
    }

    void removeJob(String job) {
        buildJobs.remove(job);
    }

    RemoteHlasmConfiguration(Project project, ConfigurationFactory factory, String name) {
        super(project, factory, name);
    }

    @Override
    public void writeExternal(Element element) throws WriteExternalException {
        super.writeExternal(element);
        Element e = new Element("JobNames");

        for(String job : buildJobs) {
            e.addContent(job + ' ');
        }

        element.addContent(e);
    }

    @Override
    public void readExternal(Element element) throws InvalidDataException {
        super.readExternal(element);
        buildJobs.clear();

        Element jobNamesElement = element.getChild("JobNames");
        String names = jobNamesElement.getValue();
        String [] jobList = names.split(" ");

        Collections.addAll(buildJobs, jobList);
    }

    @NotNull
    @Override
    public SettingsEditor<? extends RunConfiguration> getConfigurationEditor() {
        return new HlasmSettingsEditor(buildJobs);
    }

    @Override
    public void checkConfiguration() throws RuntimeConfigurationException {
        for (String dataset: buildJobs
             ) {
            if (!jobname.matcher(dataset).matches()){
                throw new RuntimeConfigurationError("invalid dataset name");
            }
        }
        // todo: проверить корректность имен наборов данных
    }

    @Nullable
    @Override
    public RunProfileState getState(@NotNull Executor executor, @NotNull ExecutionEnvironment executionEnvironment) throws ExecutionException {
        return new HlasmRunProfileState(executionEnvironment, buildJobs);
    }
}
