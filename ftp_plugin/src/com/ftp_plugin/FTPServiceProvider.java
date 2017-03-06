package com.ftp_plugin;


import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Computable;
import com.intellij.openapi.vfs.VirtualFile;
import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.*;
import org.apache.commons.net.ftp.parser.DefaultFTPFileEntryParserFactory;
import org.stringtemplate.v4.*;

import java.io.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by anisik on 25.07.2016.
 */
public class FTPServiceProvider {
    public static final Pattern jid = Pattern.compile("J([0-9]{7})");
    public static final Pattern stepname = Pattern.compile("(STEPNAME [A-Za-z0-9$#@]+)");
    public static final Pattern elapsedTime = Pattern.compile("(ELAPSED TIME [ 0-9]+\\.[0-9]+)");

    public static FTPClient createJESFTPClient(VirtualFile virtualFile, LogonSettingsComponent settingsComponent) {
        String lpar = settingsComponent.getHost();
        return createJESFTPClient(virtualFile, settingsComponent, lpar);
    }

    public static FTPClient createJESFTPClient(VirtualFile virtualFile, LogonSettingsComponent settingsComponent, String lpar)  {
        FTPClient client = createFTPClient(virtualFile,settingsComponent,lpar);
        try {
//            if (!virtualFile.isDirectory() && virtualFile.getExtension().equals("jcl")) {


                client.site("FILETYPE=JES NOJESGETBYDSN jesjobname=*");

//            }
//            else {
//                return null;
//            }
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return client;
    }

    public static FTPClient createFTPClient(VirtualFile virtualFile, LogonSettingsComponent settingsComponent, String lpar) {
        FTPClient client = new FTPClient();
        client.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out), true));
        String username = settingsComponent.getUsername();
        String password = settingsComponent.getPassword();

        final String dataset = ((Function<VirtualFile, String>) p -> {
            String ds;
            if (virtualFile.isDirectory()) {
                ds = virtualFile.getName();
            } else {
                ds = virtualFile.getParent().getName();
            }
            return ds = "'" + ds + "'";
        }).apply(virtualFile);

        try {
            //FileInputStream in = new FileInputStream("test.txt");

            client.connect(lpar);
            client.login(username, password);
            client.enterLocalPassiveMode();
            client.changeWorkingDirectory(dataset);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return client;
    }

    public interface JobSubmitCallback{
        void progressResult(String info);
        void completeResult(Notification notification);
    }

    public static void submitJob(VirtualFile virtualFile, Project project, FTPClient client, JobSubmitCallback callback) {


        //ProgressManager.getInstance().run(new Task.Backgroundable(project, "Running", false) {
        //    @Override
        //    public void run(@NotNull ProgressIndicator indicator) {
                uploadFile(client, virtualFile);
                //indicator.setFraction(0.3);

                String job = "";
                for (String result : client.getReplyStrings()
                        ) {


                    Matcher matcher = jid.matcher(result);
                    if (matcher.find())
                        job = result.substring(matcher.start(), matcher.end());
                }
                System.out.println(job);

                String jobResult = "error";
                String RC = "";
                StringBuilder builder = new StringBuilder();
                try {
                    //System.out.println(client.getReplyString());
                    //client.noop();
                    FTPFile[] list;//= client.listFiles(job);
                    while (true) {
                        client.setParserFactory(new DefaultFTPFileEntryParserFactory() {
                            @Override
                            public FTPFileEntryParser createFileEntryParser(String key) {
                                if (key.equals("MyParser")) {
                                    return new FTPFileEntryParserImpl() {
                                        @Override
                                        public FTPFile parseFTPEntry(String s) {
                                            System.out.println(s);
                                            FTPFile f = new FTPFile();
                                            f.setRawListing(s);
                                            return f;
                                        }
                                    };
                                }
                                return super.createFileEntryParser(key);
                            }
                        });

                        list = client.initiateListParsing("MyParser", job).getFiles();
                        if (list[1].getRawListing().split("\\s+")[3].equalsIgnoreCase("OUTPUT")) {
                            RC = list[1].getRawListing().substring(list[1].getRawListing().trim().lastIndexOf(" "));
                            break;
                        } else if (list.length >= 4){
                            //indicator.setFraction(0.5);
                            String text = "";
                            Matcher matcher = stepname.matcher(list[3].getRawListing());
                            if (matcher.find()) {
                                text = text + matcher.group();
                            }
                            matcher = elapsedTime.matcher(list[4].getRawListing());
                            if (matcher.find()) {
                                text = text +"  "+ matcher.group();
                            }
                            callback.progressResult(text);
                        }

                        try {
                            Thread.sleep(700);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }

                    for (FTPFile file : list
                            ) {
                        builder.append(file.getRawListing());
                        builder.append("\n");
                    }
                    jobResult = builder.toString();
                    //jobResult = StringUtil.join(client.getReplyStrings(),"\n");
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                System.out.println(jobResult);
                String title = job + " finished, " + RC;


                Notification notification = new Notification("MF-UI Information", title,
                        jobResult, NotificationType.INFORMATION);
                callback.completeResult(notification);

         //   }
        //});
    }

    public static void uploadFile(FTPClient client, VirtualFile file) {
        try {
            BufferedReader reader;

            if (file.getExtension().equalsIgnoreCase("jclt")){

                reader = ApplicationManager.getApplication().runReadAction(new Computable<BufferedReader>() {
                    @Override
                    public BufferedReader compute() {
                        ST jobTemplate = new ST(FileDocumentManager.getInstance().getDocument(file).getImmutableCharSequence().toString());
                        return new BufferedReader(new StringReader(jobTemplate.render()));
                    }
                });
//                System.out.println(jobTemplate.render());
            }
            else {
                reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
            }
            OutputStream output = client.storeFileStream(file.getName().substring(0, Math.min(8,file.getName().lastIndexOf('.'))));
            String line;
            //System.out.println("output started");
            while ((line = reader.readLine()) != null) {
                output.write((line.substring(0, (line.length() > 72) ? 72 : line.length()) + "\r\n").getBytes());

            }
            //wSystem.out.println("output ended");
            reader.close();
            output.close();
            if (!client.completePendingCommand()) {
                System.out.println("uploading failed");
            }
            //client.storeFile(file.getName().substring(0,file.getName().lastIndexOf('.')),file.getInputStream());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
