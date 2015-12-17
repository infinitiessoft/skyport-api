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
		VirtualMachineSupport, AffinityGroupSupport, MachineImageSupport, SnapshotSupport, VolumeSupport,
		AutoScalingSupport, PrepaymentSupport, AccountSupport, BillingSupport, ConvergedInfrastructureSupport,
		ConvergedHttpLoadBalancerSupport, TopologySupport, IdentityAndAccessSupport, ShellKeySupport, DNSSupport,
		FirewallSupport, IpAddressSupport, LoadBalancerSupport, NetworkFirewallSupport, VLANSupport, VpnSupport, CDNSupport,
		DataWarehouseSupport, KeyValueDatabaseSupport, MQSupport, PushNotificationSupport, RelationalDatabaseSupport,
		MonitoringSupport, OfflineStoreSupport, BlobStoreSupport, DataCenterServices;

		public static Object getSupport(TaskType type, ServiceProvider serviceProvider) throws ConcurrentException {
			switch (type) {
			case AccountSupport:
				return serviceProvider.getAdminServices().getAccountSupport();
			case AffinityGroupSupport:
				return serviceProvider.getComputeServices().getAffinityGroupSupport();
			case AutoScalingSupport:
				return serviceProvider.getComputeServices().getAutoScalingSupport();
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
				return serviceProvider.getNetworkServices().getDnsSupport();
			case DataCenterServices:
				return serviceProvider.getDataCenterServices();
			case DataWarehouseSupport:
				return serviceProvider.getPlatformServices().getDataWarehouseSupport();
			case FirewallSupport:
				return serviceProvider.getNetworkServices().getFirewallSupport();
			case IdentityAndAccessSupport:
				return serviceProvider.getIdentityServices().getIdentityAndAccessSupport();
			case IpAddressSupport:
				return serviceProvider.getNetworkServices().getIpAddressSupport();
			case KeyValueDatabaseSupport:
				return serviceProvider.getPlatformServices().getKeyValueDatabaseSupport();
			case LoadBalancerSupport:
				return serviceProvider.getNetworkServices().getLoadBalancerSupport();
			case MQSupport:
				return serviceProvider.getPlatformServices().getMessageQueueSupport();
			case MachineImageSupport:
				return serviceProvider.getComputeServices().getImageSupport();
			case MonitoringSupport:
				return serviceProvider.getPlatformServices().getMonitoringSupport();
			case NetworkFirewallSupport:
				return serviceProvider.getNetworkServices().getNetworkFirewallSupport();
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
				return serviceProvider.getComputeServices().getSnapshotSupport();
			case TopologySupport:
				return serviceProvider.getCIServices().getTopologySupport();
			case VLANSupport:
				return serviceProvider.getNetworkServices().getVlanSupport();
			case VpnSupport:
				return serviceProvider.getNetworkServices().getVpnSupport();
			case VirtualMachineSupport:
				return serviceProvider.getComputeServices().getVirtualMachineSupport();
			case VolumeSupport:
				return serviceProvider.getComputeServices().getVolumeSupport();
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
