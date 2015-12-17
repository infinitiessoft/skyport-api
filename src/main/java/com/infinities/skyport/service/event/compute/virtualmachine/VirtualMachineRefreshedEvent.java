package com.infinities.skyport.service.event.compute.virtualmachine;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;

import org.dasein.cloud.compute.VirtualMachine;

import com.infinities.skyport.service.event.RefreshedEvent;

public class VirtualMachineRefreshedEvent implements RefreshedEvent<VirtualMachine> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Date date;
	private final Collection<VirtualMachine> entries;
	private final String configid;


	public VirtualMachineRefreshedEvent(Collection<? extends VirtualMachine> entries, String configid) {
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
	public Collection<VirtualMachine> getNewEntries() {
		return entries;
	}

}
