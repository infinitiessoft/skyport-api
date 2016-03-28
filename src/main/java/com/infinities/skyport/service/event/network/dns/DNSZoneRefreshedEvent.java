package com.infinities.skyport.service.event.network.dns;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;

import org.dasein.cloud.network.DNSZone;

import com.infinities.skyport.service.event.RefreshedEvent;

public class DNSZoneRefreshedEvent implements RefreshedEvent<DNSZone> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Date date;
	private final Collection<DNSZone> entries;
	private final String configid;


	public DNSZoneRefreshedEvent(Collection<? extends DNSZone> entries, String configid) {
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
	public Collection<DNSZone> getNewEntries() {
		return entries;
	}

}
