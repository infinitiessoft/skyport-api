package com.infinities.skyport.service.event.network.dns;

import java.util.Date;

import org.dasein.cloud.network.DNSRecord;

import com.infinities.skyport.service.event.FailureEvent;

public class DNSRecordFailureEvent implements FailureEvent<DNSRecord> {

	private static final long serialVersionUID = 1L;
	private final Date date;
	private final String configid;
	private final Throwable t;


	public DNSRecordFailureEvent(String configid, Throwable t) {
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
