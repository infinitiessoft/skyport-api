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
package com.infinities.skyport.timeout;

import java.util.concurrent.ExecutorService;

import org.apache.commons.lang3.concurrent.ConcurrentException;
import org.dasein.cloud.admin.AccountSupport;
import org.dasein.cloud.admin.AdminServices;
import org.dasein.cloud.admin.BillingSupport;
import org.dasein.cloud.admin.PrepaymentSupport;
import org.dasein.cloud.ci.CIServices;
import org.dasein.cloud.ci.ConvergedHttpLoadBalancerSupport;
import org.dasein.cloud.ci.ConvergedInfrastructureSupport;
import org.dasein.cloud.ci.TopologySupport;
import org.dasein.cloud.compute.AffinityGroupSupport;
import org.dasein.cloud.compute.AutoScalingSupport;
import org.dasein.cloud.compute.MachineImageSupport;
import org.dasein.cloud.compute.SnapshotSupport;
import org.dasein.cloud.compute.VolumeSupport;
import org.dasein.cloud.identity.IdentityAndAccessSupport;
import org.dasein.cloud.identity.IdentityServices;
import org.dasein.cloud.identity.ShellKeySupport;
import org.dasein.cloud.network.DNSSupport;
import org.dasein.cloud.network.FirewallSupport;
import org.dasein.cloud.network.IpAddressSupport;
import org.dasein.cloud.network.LoadBalancerSupport;
import org.dasein.cloud.network.NetworkFirewallSupport;
import org.dasein.cloud.network.VpnSupport;
import org.dasein.cloud.platform.CDNSupport;
import org.dasein.cloud.platform.KeyValueDatabaseSupport;
import org.dasein.cloud.platform.MQSupport;
import org.dasein.cloud.platform.MonitoringSupport;
import org.dasein.cloud.platform.PlatformServices;
import org.dasein.cloud.platform.PushNotificationSupport;
import org.dasein.cloud.platform.RelationalDatabaseSupport;
import org.dasein.cloud.platform.bigdata.DataWarehouseSupport;
import org.dasein.cloud.storage.BlobStoreSupport;
import org.dasein.cloud.storage.OfflineStoreSupport;
import org.dasein.cloud.storage.StorageServices;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.concurrent.Synchroniser;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.infinities.skyport.ServiceProvider;
import com.infinities.skyport.compute.SkyportComputeServices;
import com.infinities.skyport.compute.SkyportVirtualMachineSupport;
import com.infinities.skyport.dc.SkyportDataCenterServices;
import com.infinities.skyport.model.configuration.Configuration;
import com.infinities.skyport.network.SkyportNetworkServices;
import com.infinities.skyport.network.SkyportVLANSupport;

public class TimedServiceProviderTest {

	protected Mockery context = new JUnit4Mockery() {

		{
			setThreadingPolicy(new Synchroniser());
			setImposteriser(ClassImposteriser.INSTANCE);
		}
	};
	private ServiceProvider serviceProvider;
	private ExecutorService executorService;
	private Configuration configuration;

	private SkyportComputeServices computeServices;
	private SkyportNetworkServices networkServices;
	private AdminServices adminServices;
	private CIServices ciServices;
	private IdentityServices identityServices;
	private PlatformServices platformServices;
	private StorageServices storageServices;
	private SkyportDataCenterServices dataCenterServices;

	private AffinityGroupSupport affinityGroupSupport;
	private AutoScalingSupport autoScalingSupport;
	private MachineImageSupport machineImageSupport;
	private SnapshotSupport snapshotSupport;
	private SkyportVirtualMachineSupport virtualMachineSupport;
	private VolumeSupport volumeSupport;

	private DNSSupport dnsSupport;
	private FirewallSupport firewallSupport;
	private IpAddressSupport ipAddressSupport;
	private LoadBalancerSupport loadBalancerSupport;
	private NetworkFirewallSupport networkFirewallSupport;
	private SkyportVLANSupport vlanSupport;
	private VpnSupport vpnSupport;

	private PrepaymentSupport prepaymentSupport;
	private AccountSupport accountSupport;
	private BillingSupport billingSupport;

	private ConvergedInfrastructureSupport convergedInfrastructureSupport;
	private ConvergedHttpLoadBalancerSupport convergedHttpLoadBalancerSupport;
	private TopologySupport topologySupport;

	private IdentityAndAccessSupport identityAndAccessSupport;
	private ShellKeySupport shellKeySupport;

	private CDNSupport cdnSupport;
	private DataWarehouseSupport dataWarehouseSupport;
	private KeyValueDatabaseSupport keyValueDatabaseSupport;
	private MQSupport mqSupport;
	private PushNotificationSupport pushNotificationSupport;
	private RelationalDatabaseSupport relationalDatabaseSupport;
	private MonitoringSupport monitoringSupport;

	private BlobStoreSupport blobStoreSupport;
	private OfflineStoreSupport offlineStoreSupport;

	private TimedServiceProvider provider;


	@Before
	public void setUp() throws Exception {
		configuration = new Configuration();
		configuration.setId("id");
		serviceProvider = context.mock(ServiceProvider.class);
		executorService = context.mock(ExecutorService.class);

		computeServices = context.mock(SkyportComputeServices.class);
		networkServices = context.mock(SkyportNetworkServices.class);
		adminServices = context.mock(AdminServices.class);
		ciServices = context.mock(CIServices.class);
		identityServices = context.mock(IdentityServices.class);
		platformServices = context.mock(PlatformServices.class);
		storageServices = context.mock(StorageServices.class);
		dataCenterServices = context.mock(SkyportDataCenterServices.class);

		affinityGroupSupport = context.mock(AffinityGroupSupport.class);
		autoScalingSupport = context.mock(AutoScalingSupport.class);
		machineImageSupport = context.mock(MachineImageSupport.class);
		snapshotSupport = context.mock(SnapshotSupport.class);
		virtualMachineSupport = context.mock(SkyportVirtualMachineSupport.class);
		volumeSupport = context.mock(VolumeSupport.class);

		dnsSupport = context.mock(DNSSupport.class);
		firewallSupport = context.mock(FirewallSupport.class);
		ipAddressSupport = context.mock(IpAddressSupport.class);
		loadBalancerSupport = context.mock(LoadBalancerSupport.class);
		networkFirewallSupport = context.mock(NetworkFirewallSupport.class);
		vlanSupport = context.mock(SkyportVLANSupport.class);
		vpnSupport = context.mock(VpnSupport.class);

		prepaymentSupport = context.mock(PrepaymentSupport.class);
		accountSupport = context.mock(AccountSupport.class);
		billingSupport = context.mock(BillingSupport.class);

		convergedInfrastructureSupport = context.mock(ConvergedInfrastructureSupport.class);
		convergedHttpLoadBalancerSupport = context.mock(ConvergedHttpLoadBalancerSupport.class);
		topologySupport = context.mock(TopologySupport.class);

		identityAndAccessSupport = context.mock(IdentityAndAccessSupport.class);
		shellKeySupport = context.mock(ShellKeySupport.class);

		cdnSupport = context.mock(CDNSupport.class);
		dataWarehouseSupport = context.mock(DataWarehouseSupport.class);
		keyValueDatabaseSupport = context.mock(KeyValueDatabaseSupport.class);
		mqSupport = context.mock(MQSupport.class);
		pushNotificationSupport = context.mock(PushNotificationSupport.class);
		relationalDatabaseSupport = context.mock(RelationalDatabaseSupport.class);
		monitoringSupport = context.mock(MonitoringSupport.class);

		blobStoreSupport = context.mock(BlobStoreSupport.class);
		offlineStoreSupport = context.mock(OfflineStoreSupport.class);
		context.checking(new Expectations() {

			{

				exactly(1).of(serviceProvider).initialize();
			}
		});

		provider = new TimedServiceProvider(serviceProvider, configuration, executorService);
		provider.initialize();
	}

	@After
	public void tearDown() throws Exception {
		context.assertIsSatisfied();
	}

	@Test
	public void testLightMerge() throws ConcurrentException {
		provider.lightMerge(configuration);
	}

	@Test
	public void testGetStorageServices() throws ConcurrentException {
		context.checking(new Expectations() {

			{
				exactly(1).of(serviceProvider).hasStorageServices();
				will(returnValue(true));
				exactly(1).of(serviceProvider).getStorageServices();
				will(returnValue(storageServices));

				exactly(1).of(storageServices).hasOnlineStorageSupport();
				will(returnValue(true));
				exactly(1).of(storageServices).hasOfflineStorageSupport();
				will(returnValue(true));

				exactly(1).of(storageServices).getOnlineStorageSupport();
				will(returnValue(blobStoreSupport));
				exactly(1).of(storageServices).getOfflineStorageSupport();
				will(returnValue(offlineStoreSupport));
			}
		});
		provider.getStorageServices();
	}

	@Test
	public void testGetAdminServices() throws ConcurrentException {
		context.checking(new Expectations() {

			{
				exactly(1).of(serviceProvider).hasAdminServices();
				will(returnValue(true));

				exactly(1).of(serviceProvider).getAdminServices();
				will(returnValue(adminServices));

				exactly(1).of(adminServices).hasPrepaymentSupport();
				will(returnValue(true));
				exactly(1).of(adminServices).hasAccountSupport();
				will(returnValue(true));
				exactly(1).of(adminServices).hasBillingSupport();
				will(returnValue(true));

				exactly(1).of(adminServices).getPrepaymentSupport();
				will(returnValue(prepaymentSupport));
				exactly(1).of(adminServices).getAccountSupport();
				will(returnValue(accountSupport));
				exactly(1).of(adminServices).getBillingSupport();
				will(returnValue(billingSupport));
			}
		});

		provider.getAdminServices();
	}

	@Test
	public void testGetDataCenterServices() throws ConcurrentException {
		context.checking(new Expectations() {

			{

				exactly(2).of(serviceProvider).getSkyportDataCenterServices();
				will(returnValue(dataCenterServices));

			}
		});

		provider.getSkyportDataCenterServices();
	}

	@Test
	public void testGetCIServices() throws ConcurrentException {
		context.checking(new Expectations() {

			{

				exactly(1).of(serviceProvider).hasCIServices();
				will(returnValue(true));

				exactly(1).of(serviceProvider).getCIServices();
				will(returnValue(ciServices));

				exactly(1).of(ciServices).hasConvergedHttpLoadBalancerSupport();
				will(returnValue(true));
				exactly(1).of(ciServices).hasConvergedInfrastructureSupport();
				will(returnValue(true));
				exactly(1).of(ciServices).hasTopologySupport();
				will(returnValue(true));

				exactly(1).of(ciServices).getConvergedHttpLoadBalancerSupport();
				will(returnValue(convergedHttpLoadBalancerSupport));
				exactly(1).of(ciServices).getConvergedInfrastructureSupport();
				will(returnValue(convergedInfrastructureSupport));
				exactly(1).of(ciServices).getTopologySupport();
				will(returnValue(topologySupport));

			}
		});

		provider.getCIServices();
	}

	@Test
	public void testGetComputeServices() throws ConcurrentException {
		context.checking(new Expectations() {

			{

				exactly(1).of(serviceProvider).hasComputeServices();
				will(returnValue(true));

				exactly(1).of(serviceProvider).getSkyportComputeServices();
				will(returnValue(computeServices));

				exactly(1).of(computeServices).hasAffinityGroupSupport();
				will(returnValue(true));
				exactly(1).of(computeServices).hasAutoScalingSupport();
				will(returnValue(true));
				exactly(1).of(computeServices).hasImageSupport();
				will(returnValue(true));
				exactly(1).of(computeServices).hasSnapshotSupport();
				will(returnValue(true));
				exactly(1).of(computeServices).hasVirtualMachineSupport();
				will(returnValue(true));
				exactly(1).of(computeServices).hasVolumeSupport();
				will(returnValue(true));

				exactly(1).of(computeServices).getAffinityGroupSupport();
				will(returnValue(affinityGroupSupport));
				exactly(1).of(computeServices).getAutoScalingSupport();
				will(returnValue(autoScalingSupport));
				exactly(1).of(computeServices).getImageSupport();
				will(returnValue(machineImageSupport));
				exactly(1).of(computeServices).getSnapshotSupport();
				will(returnValue(snapshotSupport));
				exactly(1).of(computeServices).getSkyportVirtualMachineSupport();
				will(returnValue(virtualMachineSupport));
				exactly(1).of(computeServices).getVolumeSupport();
				will(returnValue(volumeSupport));
			}
		});

		provider.getSkyportComputeServices();
	}

	@Test
	public void testGetIdentityServices() throws ConcurrentException {
		context.checking(new Expectations() {

			{

				exactly(1).of(serviceProvider).hasIdentityServices();
				will(returnValue(true));

				exactly(1).of(serviceProvider).getIdentityServices();
				will(returnValue(identityServices));

				exactly(1).of(identityServices).hasIdentityAndAccessSupport();
				will(returnValue(true));
				exactly(1).of(identityServices).hasShellKeySupport();
				will(returnValue(true));

				exactly(1).of(identityServices).getIdentityAndAccessSupport();
				will(returnValue(identityAndAccessSupport));
				exactly(1).of(identityServices).getShellKeySupport();
				will(returnValue(shellKeySupport));

			}
		});
		provider.getIdentityServices();
	}

	@Test
	public void testGetNetworkServices() throws ConcurrentException {
		context.checking(new Expectations() {

			{
				exactly(1).of(serviceProvider).hasNetworkServices();
				will(returnValue(true));

				exactly(1).of(serviceProvider).getSkyportNetworkServices();
				will(returnValue(networkServices));

				exactly(1).of(networkServices).hasDnsSupport();
				will(returnValue(true));
				exactly(1).of(networkServices).hasFirewallSupport();
				will(returnValue(true));
				exactly(1).of(networkServices).hasIpAddressSupport();
				will(returnValue(true));
				exactly(1).of(networkServices).hasLoadBalancerSupport();
				will(returnValue(true));
				exactly(1).of(networkServices).hasNetworkFirewallSupport();
				will(returnValue(true));
				exactly(1).of(networkServices).hasVlanSupport();
				will(returnValue(true));
				exactly(1).of(networkServices).hasVpnSupport();
				will(returnValue(true));

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
				exactly(1).of(networkServices).getSkyportVlanSupport();
				will(returnValue(vlanSupport));
				exactly(1).of(networkServices).getVpnSupport();
				will(returnValue(vpnSupport));
			}
		});
		provider.getSkyportNetworkServices();
	}

	@Test
	public void testGetPlatformServices() throws ConcurrentException {
		context.checking(new Expectations() {

			{

				exactly(1).of(serviceProvider).hasPlatformServices();
				will(returnValue(true));

				exactly(1).of(serviceProvider).getPlatformServices();
				will(returnValue(platformServices));

				exactly(1).of(platformServices).hasCDNSupport();
				will(returnValue(true));
				exactly(1).of(platformServices).hasDataWarehouseSupport();
				will(returnValue(true));
				exactly(1).of(platformServices).hasKeyValueDatabaseSupport();
				will(returnValue(true));
				exactly(1).of(platformServices).hasMessageQueueSupport();
				will(returnValue(true));
				exactly(1).of(platformServices).hasPushNotificationSupport();
				will(returnValue(true));
				exactly(1).of(platformServices).hasRelationalDatabaseSupport();
				will(returnValue(true));
				exactly(1).of(platformServices).hasMonitoringSupport();
				will(returnValue(true));

				exactly(1).of(platformServices).getCDNSupport();
				will(returnValue(cdnSupport));
				exactly(1).of(platformServices).getDataWarehouseSupport();
				will(returnValue(dataWarehouseSupport));
				exactly(1).of(platformServices).getKeyValueDatabaseSupport();
				will(returnValue(keyValueDatabaseSupport));
				exactly(1).of(platformServices).getMessageQueueSupport();
				will(returnValue(mqSupport));
				exactly(1).of(platformServices).getPushNotificationSupport();
				will(returnValue(pushNotificationSupport));
				exactly(1).of(platformServices).getRelationalDatabaseSupport();
				will(returnValue(relationalDatabaseSupport));
				exactly(1).of(platformServices).getMonitoringSupport();
				will(returnValue(monitoringSupport));

			}
		});
		provider.getPlatformServices();
	}
}
