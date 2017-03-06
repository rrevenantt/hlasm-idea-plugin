package com.map_dump.model.map;

import java.util.List;

/**
 * Created by Roman Sofyin on 16.12.2016.
 */
public class MappedDsect {
	private String dsectName;
	private List<MappedDsectStatement> mappedDsectStmts;

	public MappedDsect(List<MappedDsectStatement> list) {
		this.mappedDsectStmts = list;
	}

	public String toString() {
		String result = "";
		result += "DSECT " + this.dsectName + " {\n";
		for (int i = 0; i < this.mappedDsectStmts.size(); i++) {
			result += (mappedDsectStmts.get(i).toString() + "\n");
		}
		result += "}\n";
		return result;
	}
}
