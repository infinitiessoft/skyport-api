package com.infinities.skyport.service.event.compute.snapshot;

import java.util.Date;

import org.dasein.cloud.compute.Snapshot;

import com.infinities.skyport.service.event.FailureEvent;

public class SnapshotFailureEvent implements FailureEvent<Snapshot> {

	private static final long serialVersionUID = 1L;
	private final Date date;
	private final String configid;
	private final Throwable t;


	public SnapshotFailureEvent(String configid, Throwable t) {
		this.date = new Date();
		this.t = t;
		this.configid = configid;
	}

	@Override
	public Date getDate() {
		return date;
	}

	@Override
	public Throwable getThrowable() {
		return t;
	}

	@Override
	public String getConfigid() {
		return configid;
	}

}
