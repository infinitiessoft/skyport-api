package com.infinities.skyport.service.event.network.dns;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;

import org.dasein.cloud.network.DNSRecord;

import com.infinities.skyport.service.event.RefreshedEvent;

public class DNSRecordRefreshedEvent implements RefreshedEvent<DNSRecord>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final Date date;
	private final Collection<DNSRecord> entries;
	private final String configid;


	public DNSRecordRefreshedEvent(Collection<? extends DNSRecord> entries, String configid) {
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
	public Collection<DNSRecord> getNewEntries() {
		return entries;
	}

}
