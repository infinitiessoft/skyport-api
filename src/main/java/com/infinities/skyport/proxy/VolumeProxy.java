package com.infinities.skyport.proxy;

import java.io.Serializable;
import java.util.Map;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlTransient;

import org.dasein.cloud.compute.Platform;
import org.dasein.cloud.compute.Volume;
import org.dasein.cloud.compute.VolumeFormat;
import org.dasein.cloud.compute.VolumeState;
import org.dasein.cloud.compute.VolumeType;
import org.dasein.util.uom.storage.Gigabyte;
import org.dasein.util.uom.storage.Storage;

import com.infinities.skyport.distributed.DistributedAtomicLong;

public class VolumeProxy extends Volume implements Serializable {

	private static final long serialVersionUID = 1L;
	@XmlTransient
	private volatile Volume volume;
	private String configName;
	private String configId;
	private final DistributedAtomicLong isLocked;


	public VolumeProxy(Volume volume, String configName, String configId, DistributedAtomicLong isLocked) {
		this.volume = volume;
		this.configName = configName;
		this.configId = configId;
		this.isLocked = isLocked;

	}

	public Volume getVolume() {
		return volume;
	}

	public void setVolume(Volume volume) {
		this.volume = volume;
	}

	@Override
	public String getSnapshotId() {
		return getProviderSnapshotId();
	}

	@Override
	public String getProviderSnapshotId() {
		return getVolume().getProviderSnapshotId();
	}

	@Override
	public void setProviderSnapshotId(String snapshotId) {
		getVolume().setProviderSnapshotId(snapshotId);
	}

	@Override
	public VolumeState getCurrentState() {
		return getVolume().getCurrentState();
	}

	@Override
	public String getProviderDataCenterId() {
		return getVolume().getProviderDataCenterId();
	}

	@Override
	public String getDeviceId() {
		return getVolume().getDeviceId();
	}

	@Override
	public String getName() {
		return getVolume().getName();
	}

	@Override
	public String getProviderVolumeId() {
		return getVolume().getProviderVolumeId();
	}

	@Override
	public String getProviderRegionId() {
		return getVolume().getProviderRegionId();
	}

	@Override
	public String getProviderVirtualMachineId() {
		return getVolume().getProviderVirtualMachineId();
	}

	@Override
	public Storage<Gigabyte> getSize() {
		return getVolume().getSize();
	}

	@Override
	public void setSize(Storage<?> size) {
		getVolume().setSize(size);
	}

	@Override
	public int getSizeInGigabytes() {
		return getVolume().getSizeInGigabytes();
	}

	@Override
	public void setCurrentState(VolumeState currentState) {
		getVolume().setCurrentState(currentState);
	}

	@Override
	public void setProviderDataCenterId(String dataCenterId) {
		getVolume().setProviderDataCenterId(dataCenterId);
	}

	@Override
	public void setDeviceId(String deviceId) {
		getVolume().setDeviceId(deviceId);
	}

	@Override
	public void setName(String name) {
		getVolume().setName(name);
	}

	@Override
	public void setProviderVolumeId(String providerVolumeId) {
		getVolume().setProviderVolumeId(providerVolumeId);
	}

	@Override
	public void setProviderRegionId(String regionId) {
		getVolume().setProviderRegionId(regionId);
	}

	@Override
	public void setProviderVirtualMachineId(String serverId) {
		getVolume().setProviderVirtualMachineId(serverId);
	}

	@Override
	public long getCreationTimestamp() {
		return getVolume().getCreationTimestamp();
	}

	@Override
	public void setCreationTimestamp(long creationTimestamp) {
		getVolume().setCreationTimestamp(creationTimestamp);
	}

	@Override
	public VolumeType getType() {
		return getVolume().getType();
	}

	@Override
	public void setType(VolumeType t) {
		getVolume().setType(t);
	}

	@Override
	public String getProviderProductId() {
		return getVolume().getProviderProductId();
	}

	@Override
	public void setProviderProductId(String providerProductId) {
		getVolume().setProviderProductId(providerProductId);
	}

	@Override
	public String getDescription() {
		return getVolume().getDescription();
	}

	@Override
	public void setDescription(String description) {
		getVolume().setDescription(description);
	}

	@Override
	public boolean isRootVolume() {
		return getVolume().isRootVolume();
	}

	@Override
	public void setRootVolume(boolean rootVolume) {
		getVolume().setRootVolume(rootVolume);
	}

	@Override
	public String getMediaLink() {
		return getVolume().getMediaLink();
	}

	@Override
	public void setMediaLink(String mediaLink) {
		getVolume().setMediaLink(mediaLink);
	}

	@Override
	public Platform getGuestOperatingSystem() {
		return getVolume().getGuestOperatingSystem();
	}

	@Override
	public void setGuestOperatingSystem(Platform guestOperatingSystem) {
		getVolume().setGuestOperatingSystem(guestOperatingSystem);
	}

	@Override
	public int getIops() {
		return getVolume().getIops();
	}

	@Override
	public void setIops(int iops) {
		getVolume().setIops(iops);
	}

	@Override
	public boolean isAttached() {
		return getVolume().isAttached();
	}

	@Override
	public @Nonnull VolumeFormat getFormat() {
		return getVolume().getFormat();
	}

	@Override
	public void setFormat(@Nonnull VolumeFormat format) {
		getVolume().setFormat(format);
	}

	@Override
	public String getProviderVlanId() {
		return getVolume().getProviderVlanId();
	}

	@Override
	public void setProviderVlanId(String providerVlanId) {
		getVolume().setProviderVlanId(providerVlanId);
	}

	@Override
	public synchronized void setTags(Map<String, String> properties) {
		getVolume().setTags(properties);
	}

	@Override
	public @Nullable synchronized String getTag(@Nonnull String key) {
		return getVolume().getTag(key);
	}

	@Override
	public @Nonnull synchronized Map<String, String> getTags() {
		return getVolume().getTags();
	}

	@Override
	public void setTag(@Nonnull String key, @Nonnull String value) {
		getVolume().setTag(key, value);
		;
	}

	@Override
	public Boolean isDeleteOnVirtualMachineTermination() {
		return getVolume().isDeleteOnVirtualMachineTermination();
	}

	@Override
	public void setDeleteOnVirtualMachineTermination(Boolean deleteOnVirtualMachineTermination) {
		getVolume().setDeleteOnVirtualMachineTermination(deleteOnVirtualMachineTermination);
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
		result = prime * result + ((configName == null) ? 0 : configName.hashCode());
		result = prime * result + ((volume == null) ? 0 : volume.hashCode());
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
		VolumeProxy other = (VolumeProxy) obj;
		if (configId == null) {
			if (other.configId != null)
				return false;
		} else if (!configId.equals(other.configId))
			return false;
		if (configName == null) {
			if (other.configName != null)
				return false;
		} else if (!configName.equals(other.configName))
			return false;
		if (volume == null) {
			if (other.volume != null)
				return false;
		} else if (!volume.equals(other.volume))
			return false;
		return true;
	}

}
