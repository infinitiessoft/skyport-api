package com.infinities.skyport.proxy;

import java.util.Map;
import java.util.concurrent.Callable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlTransient;

import org.dasein.cloud.CloudException;
import org.dasein.cloud.CloudProvider;
import org.dasein.cloud.InternalException;
import org.dasein.cloud.VisibleScope;
import org.dasein.cloud.compute.Architecture;
import org.dasein.cloud.compute.Platform;
import org.dasein.cloud.compute.VirtualMachine;
import org.dasein.cloud.compute.VirtualMachineLifecycle;
import org.dasein.cloud.compute.VmState;
import org.dasein.cloud.compute.VmStatus;
import org.dasein.cloud.compute.Volume;
import org.dasein.cloud.network.RawAddress;

import com.infinities.skyport.distributed.DistributedAtomicLong;

public class VirtualMachineProxy extends VirtualMachine {

	@XmlTransient
	private volatile VirtualMachine virtualMachine;
	private String configName;
	private String configId;
	private String distributedKey;
	private final DistributedAtomicLong isLocked;


	public VirtualMachineProxy(VirtualMachine virtualMachine, String configName, String configId, String distributedKey,
			DistributedAtomicLong isLocked) {
		super();
		this.virtualMachine = virtualMachine;
		this.configName = configName;
		this.configId = configId;
		this.setDistributedKey(distributedKey);
		this.isLocked = isLocked;
	}

	public VirtualMachine getVirtualMachine() {
		return virtualMachine;
	}

	public void setVirtualMachine(VirtualMachine virtualMachine) {
		this.virtualMachine = virtualMachine;
	}

	@Override
	public String getRootPassword() {
		return getVirtualMachine().getRootPassword();
	}

	@Override
	public String getRootPassword(long timeoutInMilliseconds) throws InterruptedException {
		return getVirtualMachine().getRootPassword(timeoutInMilliseconds);
	}

	@Override
	public String fetchPassword() {
		return getVirtualMachine().fetchPassword();
	}

	@Override
	public String toString() {
		return getVirtualMachine().toString();
	}

	@Override
	public String getAffinityGroupId() {
		return getVirtualMachine().getAffinityGroupId();
	}

	@Override
	public Architecture getArchitecture() {
		return getVirtualMachine().getArchitecture();
	}

	@Override
	public boolean isClonable() {
		return getVirtualMachine().isClonable();
	}

	@Override
	public long getCreationTimestamp() {
		return getVirtualMachine().getCreationTimestamp();
	}

	@Override
	public VmState getCurrentState() {
		return isLocked.compareAndSet(1, 1) ? VmState.PENDING : getVirtualMachine().getCurrentState();
	}

	@Override
	public String getDescription() {
		return getVirtualMachine().getDescription();
	}

	@Override
	public boolean isImagable() {
		return getVirtualMachine().isImagable();
	}

	@Override
	public long getLastBootTimestamp() {
		return getVirtualMachine().getLastBootTimestamp();
	}

	@Override
	public long getLastPauseTimestamp() {
		return getVirtualMachine().getLastPauseTimestamp();
	}

	@Override
	public String getName() {
		return getVirtualMachine().getName();
	}

	@Override
	public boolean isPausable() {
		return getVirtualMachine().isPausable();
	}

	@Override
	public boolean isPersistent() {
		return getVirtualMachine().isPersistent();
	}

	@Override
	public Platform getPlatform() {
		return getVirtualMachine().getPlatform();
	}

	@Override
	public String getPrivateDnsAddress() {
		return getVirtualMachine().getPrivateDnsAddress();
	}

	@Override
	public @Nonnull RawAddress[] getPrivateAddresses() {
		return getVirtualMachine().getPrivateAddresses();
	}

	@Override
	public String getProviderAssignedIpAddressId() {
		return getVirtualMachine().getProviderAssignedIpAddressId();
	}

	@Override
	public String getProviderDataCenterId() {
		return getVirtualMachine().getProviderDataCenterId();
	}

	@Override
	public String getProviderMachineImageId() {
		return getVirtualMachine().getProviderMachineImageId();
	}

	@Override
	public String getProviderOwnerId() {
		return getVirtualMachine().getProviderOwnerId();
	}

	@Override
	public String getProviderRegionId() {
		return getVirtualMachine().getProviderRegionId();
	}

	@Override
	public String getProviderVirtualMachineId() {
		return getVirtualMachine().getProviderVirtualMachineId();
	}

	@Override
	public String getPublicDnsAddress() {
		return getVirtualMachine().getPublicDnsAddress();
	}

	@Override
	public @Nonnull RawAddress[] getPublicAddresses() {
		return getVirtualMachine().getPublicAddresses();
	}

	/**
	 * Creates an informal association under a group name for the launched VM
	 * with other virtual machines in the system. The underlying cloud may
	 * interpret this in any number of ways.
	 *
	 * @return the virtual machine group association
	 */
	@Override
	public @Nullable String getVirtualMachineGroup() {
		return getVirtualMachine().getVirtualMachineGroup();
	}

	@Override
	public boolean isRebootable() {
		return getVirtualMachine().isRebootable();
	}

	@Override
	public String getRootUser() {
		return getVirtualMachine().getRootUser();
	}

	@Override
	public String getStateReasonMessage() {
		return getVirtualMachine().getStateReasonMessage();
	}

	@Override
	public long getTerminationTimestamp() {
		return getVirtualMachine().getTerminationTimestamp();
	}

	@Override
	public Callable<String> getPasswordCallback() {
		return getVirtualMachine().getPasswordCallback();
	}

	@Override
	public String getProductId() {
		return getVirtualMachine().getProductId();
	}

	@Override
	public String[] getLabels() {
		return getVirtualMachine().getLabels();
	}

	@Override
	public Object getTag(String tag) {
		return getTags().get(tag);
	}

	@Override
	public synchronized @Nonnull Map<String, String> getTags() {
		return getVirtualMachine().getTags();
	}

	@Override
	public String getProviderSubnetId() {
		return getVirtualMachine().getProviderSubnetId();
	}

	@Override
	public String getProviderVlanId() {
		return getVirtualMachine().getProviderVlanId();
	}

	@Override
	public String getProviderKeypairId() {
		return getVirtualMachine().getProviderKeypairId();
	}

	@Override
	public String[] getProviderFirewallIds() {
		return getVirtualMachine().getProviderFirewallIds();
	}

	@Override
	public String[] getProviderNetworkInterfaceIds() {
		return getVirtualMachine().getProviderNetworkInterfaceIds();
	}

	@Override
	public @Nullable String getProviderKernelImageId() {
		return getVirtualMachine().getProviderKernelImageId();
	}

	@Override
	public @Nullable String getProviderRamdiskImageId() {
		return getVirtualMachine().getProviderRamdiskImageId();
	}

	@Override
	public @Nonnull String[] getProviderShellKeyIds() {
		return getVirtualMachine().getProviderShellKeyIds();
	}

	@Override
	public @Nonnull String[] getProviderVolumeIds(@Nonnull CloudProvider provider) throws CloudException, InternalException {
		return getVirtualMachine().getProviderVolumeIds(provider);
	}

	@Override
	public @Nullable Volume[] getVolumes() {
		return getVirtualMachine().getVolumes();
	}

	@Override
	public boolean isIoOptimized() {
		return getVirtualMachine().isIoOptimized();
	}

	@Override
	public boolean isIpForwardingAllowed() {
		return getVirtualMachine().isIpForwardingAllowed();
	}

	@Override
	public String getProviderRoleId() {
		return getVirtualMachine().getProviderRoleId();
	}

	@Override
	public VmStatus getProviderVmStatus() {
		return getVirtualMachine().getProviderVmStatus();
	}

	@Override
	public VmStatus getProviderHostStatus() {
		return getVirtualMachine().getProviderHostStatus();
	}

	@Override
	public VisibleScope getVisibleScope() {
		return getVirtualMachine().getVisibleScope();
	}

	@Override
	public VirtualMachineLifecycle getLifecycle() {
		return getVirtualMachine().getLifecycle();
	}

	@Override
	public String getSpotRequestId() {
		return getVirtualMachine().getSpotRequestId();
	}

	@Override
	public String getResourcePoolId() {
		return getVirtualMachine().getResourcePoolId();
	}

	@Override
	public String getClientRequestToken() {
		return getVirtualMachine().getClientRequestToken();
	}

	@Override
	public void setTag(String key, String value) {
		getVirtualMachine().setTag(key, value);
	}

	public String getConfigName() {
		return configName;
	}

	public void setConfigName(String configName) {
		this.configName = configName;
	}

	public String getConfigId() {
		return configId;
	}

	public void setConfigId(String configId) {
		this.configId = configId;
	}

	@XmlTransient
	@Transient
	public boolean lock() {
		return isLocked.compareAndSet(0, 1);
	}

	@XmlTransient
	@Transient
	public boolean unlock() {
		return isLocked.compareAndSet(1, 0);
	}

	@XmlTransient
	@Transient
	public boolean isLocked() {
		return isLocked.compareAndSet(1, 1);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((configId == null) ? 0 : configId.hashCode());
		result = prime * result + ((virtualMachine == null) ? 0 : virtualMachine.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		VirtualMachineProxy other = (VirtualMachineProxy) obj;
		if (configId == null) {
			if (other.configId != null)
				return false;
		} else if (!configId.equals(other.configId))
			return false;
		if (virtualMachine == null) {
			if (other.virtualMachine != null)
				return false;
		} else if (!virtualMachine.equals(other.virtualMachine))
			return false;
		return true;
	}

	public String getDistributedKey() {
		return distributedKey;
	}

	public void setDistributedKey(String distributedKey) {
		this.distributedKey = distributedKey;
	}

}
