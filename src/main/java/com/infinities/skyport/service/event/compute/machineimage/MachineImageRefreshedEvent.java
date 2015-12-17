package com.infinities.skyport.service.event.compute.machineimage;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;

import org.dasein.cloud.compute.MachineImage;

import com.infinities.skyport.service.event.RefreshedEvent;

public class MachineImageRefreshedEvent implements RefreshedEvent<MachineImage> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Date date;
	private final Collection<MachineImage> entries;
	private final String configid;


	public MachineImageRefreshedEvent(Collection<? extends MachineImage> entries, String configid) {
		this.date = new Date();
		this.configid = configid;
		this.entries = Collections.unmodifiableCollection(entries);
	}

	@Override
	public Date getDate() {
		return date;
	}

	@Override
	public String getConfigid() {
		return configid;
	}

	@Override
	public Collection<MachineImage> getNewEntries() {
		return entries;
	}
}
