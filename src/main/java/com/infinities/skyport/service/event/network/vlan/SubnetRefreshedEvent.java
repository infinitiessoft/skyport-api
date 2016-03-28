package com.infinities.skyport.service.event.network.vlan;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;

import org.dasein.cloud.network.Subnet;

import com.infinities.skyport.service.event.RefreshedEvent;

public class SubnetRefreshedEvent implements RefreshedEvent<Subnet>{

	
	private static final long serialVersionUID = 1L;
	private final Date date;
	private final Collection<Subnet> entries;
	private final String configid;

	public SubnetRefreshedEvent(Collection<? extends Subnet> entries, String configid) {
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
	public Collection<Subnet> getNewEntries() {
		return entries;
	}

}
