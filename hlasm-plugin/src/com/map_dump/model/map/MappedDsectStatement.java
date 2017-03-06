package com.map_dump.model.map;

import com.map_dump.model.dsect.DsectStatement;

/**
 * Created by Roman Sofyin on 16.12.2016.
 */
public class MappedDsectStatement {
	private DsectStatement dsectStmt;
	private String stgField;

	public MappedDsectStatement(DsectStatement dsectStmt, String stgField) {
		this.dsectStmt = dsectStmt;
		this.stgField = stgField;
	}

	public String toString() {

		return dsectStmt.toString() + (stgField.equals("") ? "": "\t= " + stgField);
	}
}
