package config;


import com.ftp_plugin.FTPServiceProvider;
import com.ftp_plugin.LogonSettingsComponent;
import com.hlasm_plugin.regex.HlasmRegexLibrary;
import com.intellij.execution.process.ProcessOutputTypes;
import com.intellij.notification.Notification;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import org.apache.commons.net.ftp.FTPClient;

import java.io.*;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.regex.Matcher;

class BuildProcess extends Process {

    private LinkedList<String> jobs = new LinkedList<>();
    private Thread buildThread;
    private BuildProcessHandler handler;
    private Project project;
    private int rc;

    BuildProcess(LinkedList<String> jobs,Project pr) {
        this.jobs.addAll(jobs);
        this.project = pr;
        rc = 0;

        buildThread = new Thread(
                () -> {
                    try {
                        Thread.sleep(1000);
                        handler.notifyTextAvailable("\n", ProcessOutputTypes.STDOUT);
                        handler.notifyTextAvailable("Build started\n", ProcessOutputTypes.STDOUT);
                        //handler.notifyTextAvailable("Just a stub. Will not submit anything \n", ProcessOutputTypes.STDERR);
                        LogonSettingsComponent settingsComponent = (LogonSettingsComponent)project.getComponent("LogonSettingsComponent");
                        if (settingsComponent == null) {
                            handler.notifyTextAvailable("Build error\n", ProcessOutputTypes.STDERR);
                            handler.notifyProcessTerminated(1);
                            return;
                        }

                        for (String job : jobs) {
                                handler.notifyTextAvailable("Submit job " + job + "\n", ProcessOutputTypes.STDOUT);
                            Matcher datasetMatcher = RemoteHlasmConfiguration.jobname.matcher(job);
                            if (datasetMatcher.find()) {
                                //TODO properly find file
                                VirtualFile virtualFile = null;
                                for (VirtualFile vf: project.getBaseDir().getChildren()
                                     ) {
                                    virtualFile = vf.findChild(datasetMatcher.group(3));
                                    if (virtualFile != null){
                                        virtualFile = virtualFile.findChild(datasetMatcher.group(4)+"."+"jcl");
                                        break;
                                    }
                                }
                                if (virtualFile == null){
                                    handler.notifyTextAvailable("Build error\n", ProcessOutputTypes.STDERR);
                                    handler.notifyProcessTerminated(1);
                                    break;
                                }
                                System.out.println(virtualFile.getCanonicalPath());
                                FTPClient client = FTPServiceProvider.createJESFTPClient(virtualFile, settingsComponent,datasetMatcher.group(1));

                                FTPServiceProvider.submitJob(virtualFile, project, client, new FTPServiceProvider.JobSubmitCallback() {
                                    @Override
                                    public void progressResult(String info) {
                                        handler.notifyTextAvailable(info+"\n",ProcessOutputTypes.STDOUT);
                                    }

                                    @Override
                                    public void completeResult(Notification notification) {
                                        String briefResult = notification.getTitle();
                                        handler.notifyTextAvailable(briefResult+"\n",ProcessOutputTypes.STDOUT);
                                        handler.notifyTextAvailable(notification.getContent(),ProcessOutputTypes.STDOUT);
                                        //System.out.println(briefResult.substring(briefResult.lastIndexOf("=")+1));
                                        rc = Integer.parseInt(briefResult.substring(briefResult.lastIndexOf("=")+1).trim(),10);
                                    }
                                });
                                try {
                                    client.disconnect();
                                } catch (IOException e){
                                    e.printStackTrace();
                                }
                                if (rc > 4){
                                    handler.notifyTextAvailable("Build error job RC > 0\n", ProcessOutputTypes.STDERR);
                                    handler.notifyProcessTerminated(rc);
                                    return;
                                }
                            }
                            else {
                                handler.notifyTextAvailable("Build error invalid build configuration\n", ProcessOutputTypes.STDERR);
                                handler.notifyProcessTerminated(1);
                                break;
                            }
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        handler.notifyTextAvailable("Build error\n", ProcessOutputTypes.STDERR);
                        handler.notifyProcessTerminated(1);
                    }

                    handler.notifyTextAvailable("Build finished " + DateFormat.getInstance().format(Calendar.getInstance().getTime())+"\n", ProcessOutputTypes.STDOUT);
                    handler.notifyProcessTerminated(0);
                }
        );
    }

    @Override
    public OutputStream getOutputStream() {
        return null;
    }

    @Override
    public InputStream getInputStream() {
        return null;
    }

    @Override
    public InputStream getErrorStream() {
        return null;
    }

    @Override
    public int waitFor() throws InterruptedException {
        buildThread.wait();
        return rc;
    }

    @Override
    public int exitValue() {
        return rc;
    }

    @Override
    // todo: terminate the thread using shared variable instead of calling stop() method.
    public void destroy() {
        rc = 1;
        buildThread.stop();
    }

    public BuildProcessHandler start() {
        System.out.println("build started");
        handler = new BuildProcessHandler(this);
        buildThread.start();
        return handler;
    }
}
