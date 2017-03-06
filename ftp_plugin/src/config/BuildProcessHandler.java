package config;


import com.intellij.execution.process.ProcessHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.OutputStream;

class BuildProcessHandler extends ProcessHandler {
    @NotNull
    private
    BuildProcess process;

    BuildProcessHandler(@NotNull BuildProcess process) {
        this.process = process;
    }

    @Override
    protected void destroyProcessImpl() {
        process.destroy();
    }

    @Override
    protected void detachProcessImpl() { }

    @Override
    public boolean detachIsDefault() {
        return false;
    }

    public void notifyProcessTerminated(int rc) {
        super.notifyProcessTerminated(rc);
    }

    @Nullable
    @Override
    public OutputStream getProcessInput() {
        return null;
    }
}
