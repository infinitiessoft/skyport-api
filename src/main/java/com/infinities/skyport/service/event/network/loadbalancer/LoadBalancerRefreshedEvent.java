package com.infinities.skyport.service.event.network.loadbalancer;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;

import org.dasein.cloud.network.LoadBalancer;
import com.infinities.skyport.service.event.RefreshedEvent;

public class LoadBalancerRefreshedEvent implements RefreshedEvent<LoadBalancer>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Date date;
	private final Collection<LoadBalancer> entries;
	private final String configid;

	public LoadBalancerRefreshedEvent(Collection<? extends LoadBalancer> entries, String configid) {
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
	public Collection<LoadBalancer> getNewEntries() {
		return entries;
	}

}
