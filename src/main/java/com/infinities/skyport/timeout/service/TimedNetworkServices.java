package com.infinities.skyport.timeout.service;

import java.util.concurrent.ExecutorService;

import org.dasein.cloud.network.DNSSupport;
import org.dasein.cloud.network.FirewallSupport;
import org.dasein.cloud.network.IpAddressSupport;
import org.dasein.cloud.network.LoadBalancerSupport;
import org.dasein.cloud.network.NetworkFirewallSupport;
import org.dasein.cloud.network.NetworkServices;
import org.dasein.cloud.network.VLANSupport;
import org.dasein.cloud.network.VpnSupport;

import com.infinities.skyport.exception.InitializationException;
import com.infinities.skyport.model.configuration.service.NetworkConfiguration;
import com.infinities.skyport.timeout.ServiceProviderTimeLimiter;

public class TimedNetworkServices implements NetworkServices {

	private NetworkServices inner;
	private DNSSupport timedDnsSupport;
	private FirewallSupport timedFirewallSupport;
	private IpAddressSupport timedIpAddressSupport;
	private LoadBalancerSupport timedLoadBalancerSupport;
	private NetworkFirewallSupport timedNetworkFirewallSupport;
	private VLANSupport timedVLANSupport;
	private VpnSupport timeVpnSupport;


	public TimedNetworkServices(NetworkServices inner, NetworkConfiguration networkConfiguration, ExecutorService executor)
			throws InitializationException {
		this.inner = inner;
		ServiceProviderTimeLimiter timedLimiter = new ServiceProviderTimeLimiter(executor);
		if (inner.hasDnsSupport()) {
			this.timedDnsSupport =
					timedLimiter.newProxy(inner.getDnsSupport(), DNSSupport.class,
							networkConfiguration.getdNSConfiguration());
		}
		if (inner.hasFirewallSupport()) {
			this.timedFirewallSupport =
					timedLimiter.newProxy(inner.getFirewallSupport(), FirewallSupport.class,
							networkConfiguration.getFirewallConfiguration());
		}
		if (inner.hasIpAddressSupport()) {
			this.timedIpAddressSupport =
					timedLimiter.newProxy(inner.getIpAddressSupport(), IpAddressSupport.class,
							networkConfiguration.getIpAddressConfiguration());
		}
		if (inner.hasLoadBalancerSupport()) {
			this.timedLoadBalancerSupport =
					timedLimiter.newProxy(inner.getLoadBalancerSupport(), LoadBalancerSupport.class,
							networkConfiguration.getLoadBalancerConfiguration());
		}
		if (inner.hasNetworkFirewallSupport()) {
			this.timedNetworkFirewallSupport =
					timedLimiter.newProxy(inner.getNetworkFirewallSupport(), NetworkFirewallSupport.class,
							networkConfiguration.getNetworkFirewallConfiguration());
		}
		if (inner.hasVlanSupport()) {
			this.timedVLANSupport =
					timedLimiter.newProxy(inner.getVlanSupport(), VLANSupport.class,
							networkConfiguration.getvLANConfiguration());
		}
		if (inner.hasVpnSupport()) {
			this.timeVpnSupport =
					timedLimiter.newProxy(inner.getVpnSupport(), VpnSupport.class,
							networkConfiguration.getVpnConfiguration());
		}
	}

	@Override
	public DNSSupport getDnsSupport() {
		return this.timedDnsSupport;
	}

	@Override
	public FirewallSupport getFirewallSupport() {
		return this.timedFirewallSupport;
	}

	@Override
	public IpAddressSupport getIpAddressSupport() {
		return this.timedIpAddressSupport;
	}

	@Override
	public LoadBalancerSupport getLoadBalancerSupport() {
		return this.timedLoadBalancerSupport;
	}

	@Override
	public NetworkFirewallSupport getNetworkFirewallSupport() {
		return this.timedNetworkFirewallSupport;
	}

	@Override
	public VLANSupport getVlanSupport() {
		return this.timedVLANSupport;
	}

	@Override
	public VpnSupport getVpnSupport() {
		return this.timeVpnSupport;
	}

	@Override
	public boolean hasDnsSupport() {
		return inner.hasDnsSupport();
	}

	@Override
	public boolean hasFirewallSupport() {
		return inner.hasFirewallSupport();
	}

	@Override
	public boolean hasIpAddressSupport() {
		return inner.hasIpAddressSupport();
	}

	@Override
	public boolean hasLoadBalancerSupport() {
		return inner.hasLoadBalancerSupport();
	}

	@Override
	public boolean hasNetworkFirewallSupport() {
		return inner.hasNetworkFirewallSupport();
	}

	@Override
	public boolean hasVlanSupport() {
		return inner.hasVlanSupport();
	}

	@Override
	public boolean hasVpnSupport() {
		return inner.hasVpnSupport();
	}

}
