package com.infinities.skyport.service.event.compute.volume;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;

import org.dasein.cloud.compute.Volume;

import com.infinities.skyport.service.event.RefreshedEvent;

public class VolumeRefreshedEvent implements RefreshedEvent<Volume> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Date date;
	private final Collection<Volume> entries;
	private final String configid;


	public VolumeRefreshedEvent(Collection<? extends Volume> entries, String configid) {
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
	public Collection<Volume> getNewEntries() {
		return entries;
	}

}
