package com.infinities.skyport.cache.service.network;

import com.google.common.eventbus.Subscribe;
import com.infinities.skyport.async.service.network.AsyncDNSSupport;
import com.infinities.skyport.service.EntityListener;
import com.infinities.skyport.service.event.network.dns.DNSRecordFailureEvent;
import com.infinities.skyport.service.event.network.dns.DNSRecordRefreshedEvent;
import com.infinities.skyport.service.event.network.dns.DNSZoneFailureEvent;
import com.infinities.skyport.service.event.network.dns.DNSZoneRefreshedEvent;

public interface CachedDNSSupport extends AsyncDNSSupport {

	void addDNSRecordListener(CachedDNSRecordListener service);

	void removeDNSRecordListener(CachedDNSRecordListener service);

	void addDNSZoneListener(CachedDNSZoneListener service);

	void removeDNSZoneListener(CachedDNSZoneListener service);

	public interface CachedDNSRecordListener extends EntityListener {

		@Subscribe
		public void onEntitiesRefreshed(DNSRecordRefreshedEvent e) throws Exception;

		@Subscribe
		public void onFailure(DNSRecordFailureEvent e);
	}

	public interface CachedDNSZoneListener extends EntityListener {

		@Subscribe
		public void onEntitiesRefreshed(DNSZoneRefreshedEvent e) throws Exception;

		@Subscribe
		public void onFailure(DNSZoneFailureEvent e);
	}

}
