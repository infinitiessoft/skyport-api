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
package com.infinities.skyport.async;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.apache.commons.lang3.concurrent.ConcurrentException;
import org.dasein.cloud.CloudException;
import org.dasein.cloud.ContextRequirements;
import org.dasein.cloud.InternalException;
import org.dasein.cloud.ProviderContext;
import org.dasein.cloud.util.NamingConstraints;
import org.dasein.cloud.util.ResourceNamespace;

import com.infinities.skyport.ServiceProvider;
import com.infinities.skyport.async.service.AsyncAdminServices;
import com.infinities.skyport.async.service.AsyncCIServices;
import com.infinities.skyport.async.service.AsyncComputeServices;
import com.infinities.skyport.async.service.AsyncDataCenterServices;
import com.infinities.skyport.async.service.AsyncIdentityServices;
import com.infinities.skyport.async.service.AsyncNetworkServices;
import com.infinities.skyport.async.service.AsyncPlatformServices;
import com.infinities.skyport.async.service.AsyncStorageServices;
import com.infinities.skyport.model.configuration.Configuration;

public interface AsyncServiceProvider {

	public enum TaskType {
		VirtualMachineSupport, AffinityGroupSupport, MachineImageSupport, SnapshotSupport, VolumeSupport, AutoScalingSupport, PrepaymentSupport, AccountSupport, BillingSupport, ConvergedInfrastructureSupport, ConvergedHttpLoadBalancerSupport, TopologySupport, IdentityAndAccessSupport, ShellKeySupport, DNSSupport, FirewallSupport, IpAddressSupport, LoadBalancerSupport, NetworkFirewallSupport, VLANSupport, VpnSupport, CDNSupport, DataWarehouseSupport, KeyValueDatabaseSupport, MQSupport, PushNotificationSupport, RelationalDatabaseSupport, MonitoringSupport, OfflineStoreSupport, BlobStoreSupport, DataCenterServices;

		public static Object getSupport(TaskType type, ServiceProvider serviceProvider) throws ConcurrentException {
			switch (type) {
			case AccountSupport:
				return serviceProvider.getAdminServices().getAccountSupport();
			case AffinityGroupSupport:
				return serviceProvider.getSkyportComputeServices().getAffinityGroupSupport();
			case AutoScalingSupport:
				return serviceProvider.getSkyportComputeServices().getAutoScalingSupport();
			case BillingSupport:
				return serviceProvider.getAdminServices().getBillingSupport();
			case BlobStoreSupport:
				return serviceProvider.getStorageServices().getOnlineStorageSupport();
			case CDNSupport:
				return serviceProvider.getPlatformServices().getCDNSupport();
			case ConvergedHttpLoadBalancerSupport:
				return serviceProvider.getCIServices().getConvergedHttpLoadBalancerSupport();
			case ConvergedInfrastructureSupport:
				return serviceProvider.getCIServices().getConvergedInfrastructureSupport();
			case DNSSupport:
				return serviceProvider.getSkyportNetworkServices().getDnsSupport();
			case DataCenterServices:
				return serviceProvider.getSkyportDataCenterServices();
			case DataWarehouseSupport:
				return serviceProvider.getPlatformServices().getDataWarehouseSupport();
			case FirewallSupport:
				return serviceProvider.getSkyportNetworkServices().getFirewallSupport();
			case IdentityAndAccessSupport:
				return serviceProvider.getIdentityServices().getIdentityAndAccessSupport();
			case IpAddressSupport:
				return serviceProvider.getSkyportNetworkServices().getIpAddressSupport();
			case KeyValueDatabaseSupport:
				return serviceProvider.getPlatformServices().getKeyValueDatabaseSupport();
			case LoadBalancerSupport:
				return serviceProvider.getSkyportNetworkServices().getLoadBalancerSupport();
			case MQSupport:
				return serviceProvider.getPlatformServices().getMessageQueueSupport();
			case MachineImageSupport:
				return serviceProvider.getSkyportComputeServices().getImageSupport();
			case MonitoringSupport:
				return serviceProvider.getPlatformServices().getMonitoringSupport();
			case NetworkFirewallSupport:
				return serviceProvider.getSkyportNetworkServices().getNetworkFirewallSupport();
			case OfflineStoreSupport:
				return serviceProvider.getStorageServices().getOfflineStorageSupport();
			case PrepaymentSupport:
				return serviceProvider.getAdminServices().getPrepaymentSupport();
			case PushNotificationSupport:
				return serviceProvider.getPlatformServices().getPushNotificationSupport();
			case RelationalDatabaseSupport:
				return serviceProvider.getPlatformServices().getRelationalDatabaseSupport();
			case ShellKeySupport:
				return serviceProvider.getIdentityServices().getShellKeySupport();
			case SnapshotSupport:
				return serviceProvider.getSkyportComputeServices().getSnapshotSupport();
			case TopologySupport:
				return serviceProvider.getCIServices().getTopologySupport();
			case VLANSupport:
				return serviceProvider.getSkyportNetworkServices().getSkyportVlanSupport();
			case VpnSupport:
				return serviceProvider.getSkyportNetworkServices().getVpnSupport();
			case VirtualMachineSupport:
				return serviceProvider.getSkyportComputeServices().getSkyportVirtualMachineSupport();
			case VolumeSupport:
				return serviceProvider.getSkyportComputeServices().getVolumeSupport();
			default:
				throw new IllegalArgumentException("Unknown TaskType:" + type);

			}
		}
	}


	void initialize() throws Exception;

	String testContext();

	boolean isConnected();

	boolean hasAdminServices();

	boolean hasCIServices();

	boolean hasComputeServices();

	boolean hasIdentityServices();

	boolean hasNetworkServices();

	boolean hasPlatformServices();

	boolean hasStorageServices();

	AsyncStorageServices getStorageServices() throws ConcurrentException;

	@Nullable
	AsyncAdminServices getAdminServices() throws ConcurrentException;

	@Nullable
	ProviderContext getContext();

	@Nonnull
	ContextRequirements getContextRequirements();

	@Nonnull
	AsyncDataCenterServices getDataCenterServices() throws ConcurrentException;

	@Nullable
	AsyncCIServices getCIServices() throws ConcurrentException;

	@Nullable
	AsyncComputeServices getComputeServices() throws ConcurrentException;

	@Nullable
	AsyncIdentityServices getIdentityServices() throws ConcurrentException;

	@Nullable
	AsyncNetworkServices getNetworkServices() throws ConcurrentException;

	@Nullable
	AsyncPlatformServices getPlatformServices() throws ConcurrentException;

	@Nonnull
	Configuration getConfiguration();

	@Nullable
	String findUniqueName(@Nonnull String baseName, @Nonnull NamingConstraints constraints,
			@Nonnull ResourceNamespace namespace) throws CloudException, InternalException;

	void close() throws ConcurrentException;

}
