package com.infinities.skyport.service.event.storage;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;

import org.dasein.cloud.storage.Blob;

import com.infinities.skyport.service.event.RefreshedEvent;

public class BlobRefreshedEvent implements RefreshedEvent<Blob>{

	private static final long serialVersionUID = 1L;
	private final Date date;
	private final Collection<Blob> entries;
	private final String configid;

	public BlobRefreshedEvent(Collection<? extends Blob> entries, String configid) {
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
	public Collection<Blob> getNewEntries() {
		return entries;
	}
}
