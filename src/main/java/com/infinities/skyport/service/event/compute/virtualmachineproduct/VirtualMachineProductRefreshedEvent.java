package com.infinities.skyport.service.event.compute.virtualmachineproduct;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;

import org.dasein.cloud.compute.VirtualMachineProduct;

import com.infinities.skyport.service.event.RefreshedEvent;

public class VirtualMachineProductRefreshedEvent implements RefreshedEvent<VirtualMachineProduct> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Date date;
	private final Collection<VirtualMachineProduct> entries;
	private final String configid;


	public VirtualMachineProductRefreshedEvent(Collection<? extends VirtualMachineProduct> entries, String configid) {
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
	public Collection<VirtualMachineProduct> getNewEntries() {
		return entries;
	}

}
