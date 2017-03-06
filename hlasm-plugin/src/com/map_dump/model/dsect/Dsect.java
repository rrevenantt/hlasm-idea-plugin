package com.map_dump.model.dsect;

import java.util.*;

/**
 * Created by Roman Sofyin on 16.12.2016.
 */
public class Dsect {
	private String name;
	private List<DsectStatement> dsectStmts = new ArrayList<DsectStatement>();

	public Dsect(String name) {
		this.name = name;
	}

	public Dsect(String name, List<DsectStatement> dsectStmts) {
		this.name = name;
		this.dsectStmts = dsectStmts;
	}

	public List<DsectStatement> getDsectStmts() {
		return dsectStmts;
	}

	public void setDsectStmts(List<DsectStatement> dsectStmts) {
		this.dsectStmts = dsectStmts;
	}
	
	public void addStatement(DsectStatement dsectStmt) {
		dsectStmts.add(dsectStmt);
	}

}
