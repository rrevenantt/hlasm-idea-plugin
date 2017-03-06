package config;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.configurations.CommandLineState;
import com.intellij.execution.process.ProcessHandler;
import com.intellij.execution.runners.ExecutionEnvironment;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;


class HlasmRunProfileState extends CommandLineState {
    private LinkedList<String> jobs = new LinkedList<>();

    HlasmRunProfileState(ExecutionEnvironment environment, LinkedList<String> jobs) {
        super(environment);
        this.jobs.addAll(jobs);
    }

    @NotNull
    @Override
    protected ProcessHandler startProcess() throws ExecutionException {
        return new BuildProcess(jobs,this.getEnvironment().getProject()).start();
    }
}
