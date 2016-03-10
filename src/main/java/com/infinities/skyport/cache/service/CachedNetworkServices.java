package com.infinities.skyport.cache.service;

import java.io.Serializable;
import java.util.concurrent.ScheduledFuture;

import javax.annotation.Nullable;

import com.infinities.skyport.async.service.AsyncNetworkServices;
import com.infinities.skyport.async.service.network.AsyncDNSSupport;
import com.infinities.skyport.async.service.network.AsyncFirewallSupport;
import com.infinities.skyport.async.service.network.AsyncIpAddressSupport;
import com.infinities.skyport.async.service.network.AsyncNetworkFirewallSupport;
import com.infinities.skyport.async.service.network.AsyncVpnSupport;
import com.infinities.skyport.cache.service.network.CachedLoadBalancerSupport;
import com.infinities.skyport.cache.service.network.CachedVLANSupport;

public interface CachedNetworkServices extends AsyncNetworkServices{
	
	public static enum NetworkQuartzType implements Serializable {
		VLAN, POOL, SUBNET, LOADBALANCER, DNSRECORD, DNSZONE;
	}
	
	public @Nullable AsyncDNSSupport getDnsSupport();

	public @Nullable AsyncFirewallSupport getFirewallSupport();

	public @Nullable AsyncIpAddressSupport getIpAddressSupport();

	public @Nullable CachedLoadBalancerSupport getLoadBalancerSupport();

	public @Nullable AsyncNetworkFirewallSupport getNetworkFirewallSupport();

	@Override
	public @Nullable CachedVLANSupport getVlanSupport();

	public @Nullable AsyncVpnSupport getVpnSupport();

	public ScheduledFuture<?> flushCache(NetworkQuartzType type);

}
