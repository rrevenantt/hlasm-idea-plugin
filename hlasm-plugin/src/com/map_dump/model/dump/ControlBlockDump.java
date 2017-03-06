package com.map_dump.model.dump;

import com.map_dump.model.dsect.Dsect;

/**
 * Created by Roman Sofyin on 17.12.2016.
 */
public class ControlBlockDump {
	Dsect controlBlock;
	public Dump dump;

	public ControlBlockDump(Dsect controlBlock, Dump dump) {
		this.controlBlock = controlBlock;
		this.dump = dump;
	}
}
