package hlasm; /**
 * Created by anisik on 26.05.2016. main class
 */
import org.antlr.v4.runtime.*;
import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.*;

public class HlasmAnalyzer {
    public static void main(String[] args){

        int a = Integer.decode("0");
        System.out.println(a);


        String preparedFile = "temp.txt";

        ANTLRInputStream input;
        try {
            input = new ANTLRFileStream(preparedFile);
        }
        catch (IOException e){
            System.out.println("file read error");
            return;
        }
        HlasmLexer lexer = new HlasmLexer(input);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        HlasmParser parser = new HlasmParser(tokenStream);
        parser.setBuildParseTree(true);
        RuleContext tree = parser.lines();
/*
        FTPClient client = new FTPClient();
        client.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out), true));

        if (!FTPReply.isPositiveCompletion(client.getReplyCode())){
            System.out.println("bad reply code");
            return;
        }

        try {
            FileInputStream in = new FileInputStream("test.txt");
            client.changeWorkingDirectory("'KANISI1.CLAY.ASM'");
            client.storeFile("EIPINIT",in);

            InputStream remote =  client.retrieveFileStream("OCEOV");


            BufferedReader reader = new BufferedReader(new InputStreamReader(remote));
            FileOutputStream outputStream = new FileOutputStream("OCEOV.asm");
            String line;
            String spaces = "                                                                                ";
            while ( (line = reader.readLine()) != null ){
                if (line.length() < 72){
                    line = line + spaces.substring(0,72-line.length());
                }
                if (line.length() > 72) {
                    line = line.substring(0,72);
                }
                outputStream.write((line+"\r\n").getBytes());
            }

            client.disconnect();
        }
        catch (IOException e){
            System.out.println(e.toString());
            return;
        }

*/
        System.out.println(tokenStream.getTokens().toString());
        for (int i=0; i<tree.getChildCount(); i++){
            System.out.println(i+"  " +tree.getChild(i).toStringTree(parser));
        }
        //System.out.println(tree.toStringTree(parser));
    }
}
