package com.infinities.skyport.async.service;

import javax.annotation.Nullable;

import com.infinities.skyport.async.service.network.AsyncDNSSupport;
import com.infinities.skyport.async.service.network.AsyncFirewallSupport;
import com.infinities.skyport.async.service.network.AsyncIpAddressSupport;
import com.infinities.skyport.async.service.network.AsyncLoadBalancerSupport;
import com.infinities.skyport.async.service.network.AsyncNetworkFirewallSupport;
import com.infinities.skyport.async.service.network.AsyncVLANSupport;
import com.infinities.skyport.async.service.network.AsyncVpnSupport;

public interface AsyncNetworkServices {

	public @Nullable AsyncDNSSupport getDnsSupport();

	public @Nullable AsyncFirewallSupport getFirewallSupport();

	public @Nullable AsyncIpAddressSupport getIpAddressSupport();

	public @Nullable AsyncLoadBalancerSupport getLoadBalancerSupport();

	public @Nullable AsyncNetworkFirewallSupport getNetworkFirewallSupport();

	public @Nullable AsyncVLANSupport getVlanSupport();

	public @Nullable AsyncVpnSupport getVpnSupport();

	public boolean hasDnsSupport();

	public boolean hasFirewallSupport();

	public boolean hasIpAddressSupport();

	public boolean hasLoadBalancerSupport();

	public boolean hasNetworkFirewallSupport();

	public boolean hasVlanSupport();

	public boolean hasVpnSupport();

	void initialize() throws Exception;

	void close();
}
