package com.map_dump.controller;

import com.map_dump.model.dsect.Dsect;
import com.map_dump.model.dsect.DsectStatement;
import com.map_dump.model.map.MappedDsect;
import com.map_dump.model.map.MappedDsectStatement;

import java.util.*;

/**
 * Created by Roman Sofyin on 16.12.2016.
 */
public class HexStringDumpMapper implements IDumpMapper {

	@Override
	public MappedDsect map(Dsect dsect, String hexStr) {
		List<MappedDsectStatement> mdsList = new ArrayList<MappedDsectStatement>(); // return value
		
		List<DsectStatement> dsList = dsect.getDsectStmts();
		String stgField;
		
		for (int i = 0, stgStart = 0, stgEnd = 0; i < dsList.size(); i++) {
			DsectStatement ds = dsList.get(i);
			stgEnd = stgStart + (ds.getRep() * ds.getLen());
			if(stgEnd*2 > hexStr.length())
				break;
			stgField = hexStr.substring(stgStart*2, stgEnd*2);
			mdsList.add(new MappedDsectStatement(ds, stgField));
			stgStart = stgEnd;
		}
		
		return new MappedDsect(mdsList);
	}
}
