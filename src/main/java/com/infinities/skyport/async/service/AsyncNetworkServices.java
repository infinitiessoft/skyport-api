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
