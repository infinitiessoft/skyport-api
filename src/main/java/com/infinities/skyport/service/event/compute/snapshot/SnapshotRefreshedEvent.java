package com.infinities.skyport.service.event.compute.snapshot;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;

import org.dasein.cloud.compute.Snapshot;

import com.infinities.skyport.service.event.RefreshedEvent;

public class SnapshotRefreshedEvent implements RefreshedEvent<Snapshot> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Date date;
	private final Collection<Snapshot> entries;
	private final String configid;


	public SnapshotRefreshedEvent(Collection<? extends Snapshot> entries, String configid) {
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
	public Collection<Snapshot> getNewEntries() {
		return entries;
	}

}
