package hlasm; /**
 * Created by anisik on 26.05.2016. main class
 */
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.PredictionMode;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.*;

public class HlasmAnalyzer {
    public static void main(String[] args){

        int a = Integer.decode("0");
        System.out.println(a);


        String preparedFile = "test.txt";

        ANTLRInputStream input;
        try {
            input = new ANTLRFileStream(preparedFile);
        }
        catch (IOException e){
            System.out.println("file read error");
            return;
        }
        TestLexer lexer = new TestLexer(input);
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        TestParser parser = new TestParser(tokenStream);
        parser.setBuildParseTree(true);
//        parser.setProfile();
//        parser.getInterpreter().setPredictionMode(PredictionMode.SLL);
        parser.addParseListener(new ParseTreeListener() {
            @Override
            public void visitTerminal(TerminalNode terminalNode) {

            }

            @Override
            public void visitErrorNode(ErrorNode errorNode) {
                System.out.println("error really?");
            }

            @Override
            public void enterEveryRule(ParserRuleContext parserRuleContext) {

            }

            @Override
            public void exitEveryRule(ParserRuleContext parserRuleContext) {

            }
        });
        parser.addErrorListener(new DiagnosticErrorListener(false));
        parser.addErrorListener(new BaseErrorListener(){
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
                System.out.println(msg);
            }
        });
        RuleContext tree = parser.code();

/*
        FTPClient client = new FTPClient();
        client.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out), true));
        try {
            client.connect("X102");
            client.login("KANISI1","KOSTYAN");
            client.enterLocalPassiveMode();
        }
        catch (IOException e){
            System.out.println(e.toString());
            return;
        }

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
                outputStream.write((line+"\r\n").getSize());
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
