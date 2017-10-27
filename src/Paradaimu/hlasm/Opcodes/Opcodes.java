package Paradaimu.hlasm.Opcodes;

import org.jetbrains.annotations.NotNull;

import javax.xml.bind.DatatypeConverter;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Opcodes {
    
    public static HashMap<String, Opcode> opcodes = new HashMap<>();
    
    public static class Opcode{
        public final byte[] opcode;
        public final String mnemonic;
        public final OpcodeType type;
        public final String description;
        public final String mf_since;
        public final String arch;
        
        public Opcode(byte[] opcode,String mnemonic,OpcodeType type,String description,String mf_since,String arch){
            this.opcode = opcode;
            this.mnemonic = mnemonic;
            this.type = type;
            this.description = description;
            this.mf_since = mf_since;
            this.arch = arch;
            Opcodes.opcodes.put(mnemonic,this);    
        }
    }
    
    public static void ReadFileWithOpcodes(@NotNull File toAdd) {
        String list[] = OpenFile(toAdd);
        String[] line = new String[7];
        Boolean flag;
        OpcodeType tempType;
        for (String iter : list)
            if (iter.length() > 0 && iter.charAt(0) != '#') {
                flag = false;
                for (int i = 0, k = 0, beginSub = 0; i < iter.length(); i++) {
                    if (iter.charAt(i) == ' ' && !flag) {
                        line[k] = iter.substring(beginSub, i);
                        k++;
                        beginSub = i + 1;
                    }
                    else if (iter.charAt(i) == '"' && !flag) {
                        beginSub++;
                        flag = true;
                    }
                    else if (iter.charAt(i) == '"' && flag) {
                        flag = false;
                        line[k] = iter.substring(beginSub, i);
                        k++;
                        i++;
                        beginSub = i + 1;
                    }
                }
                try {
                    tempType = OpcodeType.valueOf(line[2]);
                }
                catch (IllegalArgumentException e) {
                    //for debug only
                    //System.out.println("Unknown type: " + line[2]);
                    tempType = OpcodeType.UNKNOWN;
                }
                Opcode A = new Opcode(DatatypeConverter.parseHexBinary(line[0]), line[1], tempType, line[3], line[4], line[5]);
            }
    }
    
    @NotNull
    private static String[] OpenFile(File file){
        ArrayList<String> list = new ArrayList<>();
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(file));
            String text = null;

            while ((text = reader.readLine()) != null) {
                list.add(text);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (reader != null)
                    reader.close();
            }
            catch (IOException e) {
            }
        }
        String[] a = new String[1];
        return list.toArray(a);
    }
}