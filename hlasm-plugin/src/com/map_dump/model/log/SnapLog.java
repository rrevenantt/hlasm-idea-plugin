package com.map_dump.model.log;

import com.map_dump.model.dsect.Dsect;
import com.map_dump.model.dump.ControlBlockDump;
import com.map_dump.model.dump.Dump;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Roman Sofyin on 17.12.2016.
 */
public class SnapLog {
	//List<ControlBlockDump> controlBlockDumpList = new ArrayList<ControlBlockDump>();
	public static final String regex = "(\\+\\sDUMP\\s\\+)\\s(?:([\\@\\$]{0,7}[A-Z]{1,8}\\sSTORAGE - ((STORAGE)|(END STORAGE)))|(([0-F]){5}\\s\\-\\s([0-F]){5}\\sSAME)|(([0-F]){5}((\\s([0-9,A-F]){1,8}){1,4}\\s){1,2}))";
	public static final String beginStgControlBlockDumpToken = "- STORAGE";
	public static final String endStgControlBlockDumpToken = "- END STORAGE";
	public static final String sameAsAboveControlBlockDumpToken = " SAME";
	
	
	
	private String log = "";
	private List<Integer> iStartList = null;   // ControlBlockDumps start line numbers
	private List<Integer> iEndList = null;     // ControlBlockDumps end line numbers
	int iStart, iEnd;
	

	public SnapLog() {
		
	}

	
	public SnapLog(String log, List<Integer> iStartList, List<Integer> iEndList) {
		this.log = log;
		this.iStartList = iStartList;
		this.iEndList = iEndList;
	}

	public SnapLog(String log) {
		this.log = log;
	}

	public List<ControlBlockDump> getControlBlockDumpList() {
		List<ControlBlockDump> cbdList = new ArrayList<ControlBlockDump>();
		
		//String [] strs = this.log.split(regex);
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(log);
		List<String> strs = new ArrayList<String>();
				
		while(m.find()) {
			strs.add(m.toMatchResult().group(0));
		}
				
				
		
		for(iStart = 0, iEnd = strs.size()-1; iStart < strs.size()-1;) {
			
			cbdList.add(getNextControlBlockDump(strs));
		}
		
		return cbdList;
	}
	
	private ControlBlockDump getNextControlBlockDump(List<String> strs) {
		String str = null;
		for(; iStart < iEnd; iStart++) {
			str = strs.get(iStart);
			int len = str.length();
			if(beginStgControlBlockDumpToken.compareTo(str.substring(len-beginStgControlBlockDumpToken.length(), len)) == 0)
				break;
		}
		//We have got iStart index
		if(iStart >= iEnd)
			return null;
		
		List<String> strControlBlockDump = new ArrayList<String>();
		String controlBlockName = "";
		
		// this way we get controlBlockName
		str = str.substring(9, 18);
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ')
				break;
			controlBlockName += str.charAt(i);
		}

		String hexStr = "";
		int index;
		for (index = 1; iStart+index <= iEnd; index++) {
			str = strs.get(iStart+index);
			int len = str.length();

			if (beginStgControlBlockDumpToken.compareTo(str.substring(len-beginStgControlBlockDumpToken.length(), len)) == 0) {
				// If begin of control block dump. It means that dump records are unmatched
				return null;
			} else if (endStgControlBlockDumpToken.compareTo(str.substring(len-endStgControlBlockDumpToken.length(), len)) == 0) {
				// If end of control block dump	
				
				//make sure that control block name are matched at the beginning and in the end
				if (str.substring(9, 9+controlBlockName.length()).compareTo(controlBlockName) != 0)
					return null;
				break;
			} else if (sameAsAboveControlBlockDumpToken.compareTo(str.substring(len-sameAsAboveControlBlockDumpToken.length(), len)) == 0) {
				//If 'SAME AS ABOVE' dump record
				int begin = Integer.parseInt(str.substring(9,14), 16);
				int end= Integer.parseInt(str.substring(17,22), 16);
				for (int count = (end-begin)/32; count > 0; count--)
					hexStr += hexStr.substring(hexStr.length()-32, hexStr.length());
			} else {
				//If usual dump record
				int l = " ".compareTo(str.substring(str.length()-1, str.length())) == 0 ? str.length()-1 : str.length();
				hexStr += str.substring(15,l).replaceAll("\\s", "");
			}
		}
		iStart += index;
		return new ControlBlockDump(new Dsect(controlBlockName, null), new Dump(hexStr));
	}
}
