import sys
import re

if __name__ == "__main__":
	if len(sys.argv) != 3:
		print ("error, there should be 2 arguments")
	
	filein = open(sys.argv[1],"r");
	fileout = open(sys.argv[2],"w");
	
	i=0
	mnemonic = []
	opcodetypes = []
	fileout.writelines(["package hlasm;\n\n",
						"import java.util.HashMap;\n",
						"import javax.xml.bind.DatatypeConverter;\n",
						"public class Opcodes { \n"])
	fileout.writelines(["\n\npublic static HashMap<String,Opcode> opcodes = new HashMap<>();\n"])
	for line in filein:
		if line[0] == '#' or line[0] == ' ' or line[0] == '\n':
			continue
		
		params = re.findall("[^ \"\n]+|\".*?\"",line)
		print(params)
		if '$' in params[1] or '*' in params[1]:
			continue
		if params[1].upper() in mnemonic : 
			continue           #   temp 
		mnemonic.append(params[1].upper())
		opcodetypes.append(params[2].upper())
		fileout.writelines(["    public static final Opcode OP_{1} = new Opcode(DatatypeConverter.parseHexBinary(\"{0}\"),\"{1}\",OpcodeType.{2},{3},\"{4}\",\"{5}\");\n".format(params[0],params[1].upper(),params[2].upper(),params[3],params[4],params[5])])
		
	#for i in mnemonic:
	#	fileout.writelines(["    opcodes.put(\"{0}\",OP_{0});\n".format(i)])
		
	
	
	opcodetypes_set = set(opcodetypes)
	fileout.writelines(["\npublic static class Opcode{\n",
					   "    public byte[] opcode;\n",
					   "    public String mnemonic;\n",
					   "    public OpcodeType type;\n",
					   "    public String description;\n",
					   "    public String mf_since;\n",
					   "    public String arch;\n",
					   "    public Opcode(byte[] opcode,String mnemonic,OpcodeType type,String description,String mf_since,String arch){\n",
					   "        this.opcode = opcode;\n",
					   "        this.mnemonic = mnemonic;\n",
					   "        this.type = type;\n",
					   "        this.description = description;\n",
					   "        this.mf_since = mf_since;\n",
					   "        this.arch = arch;\n",
					   "        Opcodes.opcodes.put(mnemonic,this);",
					   "    }\n",
					   "}\n",
					   "public enum OpcodeType{\n"
					   ])
	for  i in opcodetypes_set:
		fileout.writelines(["    {},\n".format(i)])    
	
	fileout.writelines(["}}"])
	filein.close()
	fileout.close()
		
	