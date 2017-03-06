package com.map_dump.model.dsect;

/**
 * Created by Roman Sofyin on 16.12.2016.
 */
public class DsectStatement {
	public int locCntr;
	public String label;
	public String cmd;
	public int rep;
	public char type;
	public int len;
	public String value;


	public int getLocCntr() {
		return locCntr;
	}

	public void setLocCntr(int locCntr) {
		this.locCntr = locCntr;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public int getRep() {
		return rep;
	}

	public void setRep(int rep) {
		this.rep = rep;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	public int getLen() {
		return len;
	}

	public void setLen(int len) {
		this.len = len;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public DsectStatement(int locCntr, String label, String cmd, int rep, char type, int len, String value) {
		this.locCntr = locCntr;
		this.label = label;
		this.cmd = cmd;
		this.rep = rep;
		this.type = type;
		this.len = len;
		this.value = value;
	}

	public String toString() {
		return  Integer.toString(locCntr) + "\t" +
				(label == null ? "" : label) +
				"\t" + cmd + "\t" +
				( rep == 1 ? "" : Integer.toString(rep)) +
				type + "L" + len +
				( value == null ? "" : "'"+value+"'");
	}
}
