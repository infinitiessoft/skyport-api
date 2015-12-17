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
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.concurrent.Synchroniser;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.infinities.skyport.exception.InitializationException;
import com.infinities.skyport.model.configuration.service.NetworkConfiguration;

public class TimedNetworkServicesTest {

	protected Mockery context = new JUnit4Mockery() {

		{
			setThreadingPolicy(new Synchroniser());
			setImposteriser(ClassImposteriser.INSTANCE);
		}
	};

	private ExecutorService executorService;
	private NetworkServices networkServices;
	private NetworkConfiguration networkConfiguration;

	private DNSSupport dnsSupport;
	private FirewallSupport firewallSupport;
	private IpAddressSupport ipAddressSupport;
	private LoadBalancerSupport loadBalancerSupport;
	private NetworkFirewallSupport networkFirewallSupport;
	private VLANSupport vlanSupport;
	private VpnSupport vpnSupport;


	@Before
	public void setUp() throws Exception {
		networkServices = context.mock(NetworkServices.class);
		executorService = context.mock(ExecutorService.class);
		networkConfiguration = new NetworkConfiguration();

		dnsSupport = context.mock(DNSSupport.class);
		firewallSupport = context.mock(FirewallSupport.class);
		ipAddressSupport = context.mock(IpAddressSupport.class);
		loadBalancerSupport = context.mock(LoadBalancerSupport.class);
		networkFirewallSupport = context.mock(NetworkFirewallSupport.class);
		vlanSupport = context.mock(VLANSupport.class);
		vpnSupport = context.mock(VpnSupport.class);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testTimedNetworkServices() throws InitializationException {
		context.checking(new Expectations() {

			{
				exactly(1).of(networkServices).getDnsSupport();
				will(returnValue(dnsSupport));
				exactly(1).of(networkServices).getFirewallSupport();
				will(returnValue(firewallSupport));
				exactly(1).of(networkServices).getIpAddressSupport();
				will(returnValue(ipAddressSupport));
				exactly(1).of(networkServices).getLoadBalancerSupport();
				will(returnValue(loadBalancerSupport));
				exactly(1).of(networkServices).getNetworkFirewallSupport();
				will(returnValue(networkFirewallSupport));
				exactly(1).of(networkServices).getVlanSupport();
				will(returnValue(vlanSupport));
				exactly(1).of(networkServices).getVpnSupport();
				will(returnValue(vpnSupport));

			}
		});
		new TimedNetworkServices(networkServices, networkConfiguration, executorService);
	}
}
