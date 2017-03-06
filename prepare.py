# prepare file for parsing

import sys

if __name__ == "__main__":
	if len(sys.argv) != 3:
		print ("error, there should be 2 arguments")
	
	filein = open(sys.argv[1],"r");
	fileout = open(sys.argv[2],"w");
	
	i=0
	for line in filein:
		if len(line) < 72:
			fileout.writelines([line])
		else :
			fileout.writelines([line[0:72]+'\n'])
		
		i += 1
#		if i>1000 :
#			break
	