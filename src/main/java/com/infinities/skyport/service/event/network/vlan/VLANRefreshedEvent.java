package com.infinities.skyport.service.event.network.vlan;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;

import org.dasein.cloud.network.VLAN;
import com.infinities.skyport.service.event.RefreshedEvent;

public class VLANRefreshedEvent implements RefreshedEvent<VLAN>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Date date;
	private final Collection<VLAN> entries;
	private final String configid;

	public VLANRefreshedEvent(Collection<? extends VLAN> entries, String configid) {
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
	public Collection<VLAN> getNewEntries() {
		return entries;
	}

}
