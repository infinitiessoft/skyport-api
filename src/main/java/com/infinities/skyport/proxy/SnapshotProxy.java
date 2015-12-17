package com.infinities.skyport.proxy;

import java.io.Serializable;
import java.util.Map;

import javax.annotation.Nonnull;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlTransient;

import org.dasein.cloud.Tag;
import org.dasein.cloud.VisibleScope;
import org.dasein.cloud.compute.Snapshot;
import org.dasein.cloud.compute.SnapshotState;

import com.infinities.skyport.distributed.DistributedAtomicLong;

public class SnapshotProxy extends Snapshot implements Serializable {

	private static final long serialVersionUID = 1L;
	@XmlTransient
	private volatile Snapshot snapshot;
	private String configName;
	private String configId;
	private final DistributedAtomicLong isLocked;


	public SnapshotProxy(Snapshot snapshot, String configName, String configId, DistributedAtomicLong isLocked) {
		super();
		this.snapshot = snapshot;
		this.configName = configName;
		this.configId = configId;
		this.isLocked = isLocked;
	}

	public Snapshot getSnapshot() {
		return snapshot;
	}

	public void setSnapshot(Snapshot snapshot) {
		this.snapshot = snapshot;
	}

	@Override
	public SnapshotState getCurrentState() {
		return getSnapshot().getCurrentState();
	}

	@Override
	public String getName() {
		return getSnapshot().getName();
	}

	@Override
	public String getOwner() {
		return getSnapshot().getOwner();
	}

	@Override
	public String getProviderSnapshotId() {
		return getSnapshot().getProviderSnapshotId();
	}

	@Override
	public String getRegionId() {
		return getSnapshot().getRegionId();
	}

	@Override
	public long getSnapshotTimestamp() {
		return getSnapshot().getSnapshotTimestamp();
	}

	@Override
	public String getVolumeId() {
		return getSnapshot().getVolumeId();
	}

	@Override
	public void setCurrentState(SnapshotState currentState) {
		getSnapshot().setCurrentState(currentState);
	}

	@Override
	public void setName(String name) {
		getSnapshot().setName(name);
	}

	@Override
	public void setOwner(String owner) {
		getSnapshot().setOwner(owner);
	}

	@Override
	public void setProviderSnapshotId(String providerSnapshotId) {
		getSnapshot().setProviderSnapshotId(providerSnapshotId);
	}

	@Override
	public void setRegionId(String regionId) {
		getSnapshot().setRegionId(regionId);
	}

	@Override
	public void setSnapshotTimestamp(long snapshotTimestamp) {
		getSnapshot().setSnapshotTimestamp(snapshotTimestamp);
	}

	@Override
	public void setVolumeId(String volumeId) {
		getSnapshot().setVolumeId(volumeId);
	}

	@Override
	public String getDescription() {
		return getSnapshot().getDescription();
	}

	@Override
	public String getProgress() {
		return getSnapshot().getProgress();
	}

	@Override
	public void setDescription(String description) {
		getSnapshot().setDescription(description);
	}

	@Override
	public void setProgress(String progress) {
		getSnapshot().setProgress(progress);
	}

	@Override
	public int getSizeInGb() {
		return getSnapshot().getSizeInGb();
	}

	@Override
	public void setSizeInGb(int sizeInGb) {
		getSnapshot().setSizeInGb(sizeInGb);
	}

	@Override
	public void addTag(Tag t) {
		getSnapshot().addTag(t.getKey(), t.getValue());
	}

	@Override
	public void addTag(String key, String value) {
		getSnapshot().getTags().put(key, value);
	}

	@Override
	public Object getTag(String tag) {
		return getSnapshot().getTags().get(tag);
	}

	@Override
	public synchronized @Nonnull Map<String, String> getTags() {
		return getSnapshot().getTags();
	}

	@Override
	public void setTag(@Nonnull String key, @Nonnull String value) {
		getSnapshot().getTags().put(key, value);
	}

	@Override
	public synchronized void setTags(Map<String, String> properties) {
		getSnapshot().setTags(properties);
	}

	@Override
	public void setVisibleScope(VisibleScope visibleScope) {
		getSnapshot().setVisibleScope(visibleScope);
	}

	@Override
	public VisibleScope getVisibleScope() {
		return getSnapshot().getVisibleScope();
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
		result = prime * result + ((snapshot == null) ? 0 : snapshot.hashCode());
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
		SnapshotProxy other = (SnapshotProxy) obj;
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
		if (snapshot == null) {
			if (other.snapshot != null)
				return false;
		} else if (!snapshot.equals(other.snapshot))
			return false;
		return true;
	}

}
