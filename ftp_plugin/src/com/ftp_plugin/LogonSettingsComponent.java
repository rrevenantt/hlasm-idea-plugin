package com.ftp_plugin;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ProjectComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@State(name = "LogonSettingsComponent", storages = @Storage(id = "LogonSettings", value = "LogonSettings.xml"))
public class LogonSettingsComponent implements ProjectComponent, PersistentStateComponent<LogonSettingsComponent> {

    private String host;
    private String username;
    private String password;
    private String initDir;
    private String port;

    public LogonSettingsComponent() {
        initDir = host = username = password = "" ;
        port = "21";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getInitDir() {
        return initDir;
    }

    public void setInitDir(String initDir) {
        this.initDir = initDir;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }


    @Nullable
    @Override
    public LogonSettingsComponent getState() {
        return this;
    }

    @Override
    public void loadState(LogonSettingsComponent state) {
        XmlSerializerUtil.copyBean(state, this);
    }

    @Override
    public void projectOpened() { }

    @Override
    public void projectClosed() { }

    @Override
    public void initComponent() { }

    @Override
    public void disposeComponent() { }

    @NotNull
    @Override
    public String getComponentName() {
        return "LogonSettingsComponent";
    }
}

