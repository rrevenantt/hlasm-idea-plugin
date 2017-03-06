package com.ftp_plugin;

import com.intellij.notification.NotificationGroup;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.vfs.VirtualFile;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import java.io.*;

/**
 * Created by anisik on 07.06.2016.
 */
public class HlasmGetRemotePDSAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent ev) {
        //Editor ed = ev.getData(CommonDataKeys.EDITOR);
        //CaretModel caret = ed.getCaretModel();
        LogonSettingsComponent settingsComponent = (LogonSettingsComponent)ev.getProject().getComponent("LogonSettingsComponent");
        if (settingsComponent == null){
            // create new logon info
            (new LogonSettingsAction()).actionPerformed(ev);
            return;
        }

        String username = settingsComponent.getUsername();
        String password = settingsComponent.getPassword();
        String dataset;

        VirtualFile virtualFile = ev.getData(PlatformDataKeys.VIRTUAL_FILE);
        if (virtualFile.isDirectory()){
            dataset = virtualFile.getName();
        }
        else{
            dataset = virtualFile.getParent().getName();
        }
        dataset = "'" + dataset + "'";
        VirtualFile[] virtualFiles;

        FTPClient client = new FTPClient();
        // for debug
        client.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out), true));

        try {
            //FileInputStream in = new FileInputStream("test.txt");

            client.connect(settingsComponent.getHost());
            client.login(username,password);
            client.enterLocalPassiveMode();
            client.changeWorkingDirectory(dataset);
            //client.storeFile("EIPINIT",in);


            FTPFile[] files = client.listFiles();
            client.disconnect();
            //FTPFile file = files[0];
            for (FTPFile file: files
                    ) {
                if ((virtualFile != null && virtualFile.isDirectory())
                        || (//virtualFile.getExtension().equals("asm") &&
                            file.getName().equals(virtualFile.getNameWithoutExtension()))
                        ) {
                    try {
                        System.out.println("getting file");
                        client.connect(settingsComponent.getHost());
                        client.login(username,password);
                        client.enterLocalPassiveMode();
                        client.changeWorkingDirectory(dataset);
                        if (!FTPReply.isPositiveCompletion(client.getReplyCode())) {
                            System.out.println("bad reply code");
                            return;
                        }
                        System.out.println(file.getName());
                        InputStream remote = client.retrieveFileStream(file.getName());
                        BufferedReader reader = new BufferedReader(new InputStreamReader(remote));
                        //VirtualFile vf = virtualFile.findOrCreateChildData(null, file.getName() + ".asm");

                        FileOutputStream outputStream;
                        /*if (virtualFile.getExtension().equals("asm")){
                            outputStream = new FileOutputStream(virtualFile.getCanonicalPath());
                        }
                        else {
                            outputStream = new FileOutputStream(virtualFile.getCanonicalPath() + "/" + file.getName() + ".asm");
                        }*/
                        //FileOutputStream outputStream = new FileOutputStream(virtualFile.getCanonicalPath() + "/" + file.getName() + ".asm");
                        //OutputStream outputStream = vf.getOutputStream(this);


                        String line = reader.readLine();
                        if (line == null) {
                            NotificationGroup group = NotificationGroup.findRegisteredGroup("MF-UI Error");
                            if (group == null) {
                                group = NotificationGroup.balloonGroup("MF-UI Error");
                            }
                            Notifications.Bus.notify(group.createNotification("Error ",null,
                                    "something wrong happened while downloading " + file.getName()+"\n Possibly file is locked on target LPAR", NotificationType.ERROR));
                        }
                        String extention = "asm";
                        if (line.startsWith("//")){
                            extention = "jcl";
                        }
                        else if (line.matches("[ ]* /\\* [^*]+? \\*/ .*")){
                            extention = "rexx";
                        }

                        if (virtualFile.isDirectory()){
                            outputStream = new FileOutputStream(
                                    virtualFile.getCanonicalPath() + "/" + file.getName() + "." + extention);
                        }
                        else {
                            if (!virtualFile.getExtension().equals(extention)) {
                                // TODO handle existing file
                                virtualFile.rename(null,virtualFile.getNameWithoutExtension()+"."+extention);
                            }
                            outputStream = new FileOutputStream(virtualFile.getCanonicalPath());
                        }


                        String spaces = "                                                                                "; // 72 spaces
                        while (line != null) {
//                            if (line.length() < 72) {
//                                line = line + spaces.substring(0, 72 - line.length());
//                            }
                            if (line.length() > 72) {
                                line = line.substring(0, 72);
                            }
                            outputStream.write((line + "\r\n").getBytes());
                            line = reader.readLine();
                        }
                        remote.close();
                        outputStream.close();
                        virtualFile.refresh(true,true);
                        client.disconnect();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }

            }

            //client.disconnect();
        }
        catch (IOException e){
            System.out.println(e.toString());
        }

    }

    @Override
    public void update(AnActionEvent e){
        VirtualFile virtualFile = e.getData(PlatformDataKeys.VIRTUAL_FILE);
        e.getPresentation().setVisible((virtualFile != null && virtualFile.isDirectory())
                || (virtualFile != null ));
    }
}
