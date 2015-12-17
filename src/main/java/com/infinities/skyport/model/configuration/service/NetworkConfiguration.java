/*******************************************************************************
 * Copyright 2015 InfinitiesSoft Solutions Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *******************************************************************************/
package com.infinities.skyport.model.configuration.service;

import java.io.Serializable;

import com.infinities.skyport.model.configuration.network.DNSConfiguration;
import com.infinities.skyport.model.configuration.network.FirewallConfiguration;
import com.infinities.skyport.model.configuration.network.IpAddressConfiguration;
import com.infinities.skyport.model.configuration.network.LoadBalancerConfiguration;
import com.infinities.skyport.model.configuration.network.NetworkFirewallConfiguration;
import com.infinities.skyport.model.configuration.network.VLANConfiguration;
import com.infinities.skyport.model.configuration.network.VpnConfiguration;

public class NetworkConfiguration implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DNSConfiguration dNSConfiguration = new DNSConfiguration();
	private FirewallConfiguration firewallConfiguration = new FirewallConfiguration();
	private IpAddressConfiguration ipAddressConfiguration = new IpAddressConfiguration();
	private LoadBalancerConfiguration loadBalancerConfiguration = new LoadBalancerConfiguration();
	private NetworkFirewallConfiguration networkFirewallConfiguration = new NetworkFirewallConfiguration();
	private VLANConfiguration vLANConfiguration = new VLANConfiguration();
	private VpnConfiguration vpnConfiguration = new VpnConfiguration();


	public DNSConfiguration getdNSConfiguration() {
		return dNSConfiguration;
	}

	public void setdNSConfiguration(DNSConfiguration dNSConfiguration) {
		this.dNSConfiguration = dNSConfiguration;
	}

	public FirewallConfiguration getFirewallConfiguration() {
		return firewallConfiguration;
	}

	public void setFirewallConfiguration(FirewallConfiguration firewallConfiguration) {
		this.firewallConfiguration = firewallConfiguration;
	}

	public IpAddressConfiguration getIpAddressConfiguration() {
		return ipAddressConfiguration;
	}

	public void setIpAddressConfiguration(IpAddressConfiguration ipAddressConfiguration) {
		this.ipAddressConfiguration = ipAddressConfiguration;
	}

	public LoadBalancerConfiguration getLoadBalancerConfiguration() {
		return loadBalancerConfiguration;
	}

	public void setLoadBalancerConfiguration(LoadBalancerConfiguration loadBalancerConfiguration) {
		this.loadBalancerConfiguration = loadBalancerConfiguration;
	}

	public NetworkFirewallConfiguration getNetworkFirewallConfiguration() {
		return networkFirewallConfiguration;
	}

	public void setNetworkFirewallConfiguration(NetworkFirewallConfiguration networkFirewallConfiguration) {
		this.networkFirewallConfiguration = networkFirewallConfiguration;
	}

	public VLANConfiguration getvLANConfiguration() {
		return vLANConfiguration;
	}

	public void setvLANConfiguration(VLANConfiguration vLANConfiguration) {
		this.vLANConfiguration = vLANConfiguration;
	}

	public VpnConfiguration getVpnConfiguration() {
		return vpnConfiguration;
	}

	public void setVpnConfiguration(VpnConfiguration vpnConfiguration) {
		this.vpnConfiguration = vpnConfiguration;
	}

	@Override
	public NetworkConfiguration clone() {
		NetworkConfiguration clone = new NetworkConfiguration();
		clone.dNSConfiguration = dNSConfiguration.clone();
		clone.firewallConfiguration = firewallConfiguration.clone();
		clone.ipAddressConfiguration = ipAddressConfiguration.clone();
		clone.loadBalancerConfiguration = loadBalancerConfiguration.clone();
		clone.networkFirewallConfiguration = networkFirewallConfiguration.clone();
		clone.vLANConfiguration = vLANConfiguration.clone();
		clone.vpnConfiguration = vpnConfiguration.clone();

		return clone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dNSConfiguration == null) ? 0 : dNSConfiguration.hashCode());
		result = prime * result + ((firewallConfiguration == null) ? 0 : firewallConfiguration.hashCode());
		result = prime * result + ((ipAddressConfiguration == null) ? 0 : ipAddressConfiguration.hashCode());
		result = prime * result + ((loadBalancerConfiguration == null) ? 0 : loadBalancerConfiguration.hashCode());
		result = prime * result + ((networkFirewallConfiguration == null) ? 0 : networkFirewallConfiguration.hashCode());
		result = prime * result + ((vLANConfiguration == null) ? 0 : vLANConfiguration.hashCode());
		result = prime * result + ((vpnConfiguration == null) ? 0 : vpnConfiguration.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NetworkConfiguration other = (NetworkConfiguration) obj;
		if (dNSConfiguration == null) {
			if (other.dNSConfiguration != null)
				return false;
		} else if (!dNSConfiguration.equals(other.dNSConfiguration))
			return false;
		if (firewallConfiguration == null) {
			if (other.firewallConfiguration != null)
				return false;
		} else if (!firewallConfiguration.equals(other.firewallConfiguration))
			return false;
		if (ipAddressConfiguration == null) {
			if (other.ipAddressConfiguration != null)
				return false;
		} else if (!ipAddressConfiguration.equals(other.ipAddressConfiguration))
			return false;
		if (loadBalancerConfiguration == null) {
			if (other.loadBalancerConfiguration != null)
				return false;
		} else if (!loadBalancerConfiguration.equals(other.loadBalancerConfiguration))
			return false;
		if (networkFirewallConfiguration == null) {
			if (other.networkFirewallConfiguration != null)
				return false;
		} else if (!networkFirewallConfiguration.equals(other.networkFirewallConfiguration))
			return false;
		if (vLANConfiguration == null) {
			if (other.vLANConfiguration != null)
				return false;
		} else if (!vLANConfiguration.equals(other.vLANConfiguration))
			return false;
		if (vpnConfiguration == null) {
			if (other.vpnConfiguration != null)
				return false;
		} else if (!vpnConfiguration.equals(other.vpnConfiguration))
			return false;
		return true;
	}

}
