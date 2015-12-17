package com.infinities.skyport.model.configuration.compute;

import java.io.Serializable;

import com.infinities.skyport.model.FunctionConfiguration;
import com.infinities.skyport.model.Time;

public class SnapshotConfiguration implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final Time DEFAULT_SNAPSHOT_DELAY = new Time();
	static {
		DEFAULT_SNAPSHOT_DELAY.setNumber(300);
	}

	private FunctionConfiguration addSnapshotShare = new FunctionConfiguration();
	private FunctionConfiguration addPublicShare = new FunctionConfiguration();
	private FunctionConfiguration createSnapshot = new FunctionConfiguration();
	private FunctionConfiguration getSnapshot = new FunctionConfiguration();
	private FunctionConfiguration isPublic = new FunctionConfiguration();
	private FunctionConfiguration listShares = new FunctionConfiguration();
	private FunctionConfiguration listSnapshotStatus = new FunctionConfiguration();
	private FunctionConfiguration listSnapshots = new FunctionConfiguration();
	private FunctionConfiguration remove = new FunctionConfiguration();
	private FunctionConfiguration removeAllSnapshotShares = new FunctionConfiguration();
	private FunctionConfiguration removeSnapshotShare = new FunctionConfiguration();
	private FunctionConfiguration removePublicShare = new FunctionConfiguration();
	private FunctionConfiguration removeTags = new FunctionConfiguration();
	private FunctionConfiguration searchSnapshots = new FunctionConfiguration();
	private FunctionConfiguration updateTags = new FunctionConfiguration();
	private FunctionConfiguration setTags = new FunctionConfiguration();
	private FunctionConfiguration create = new FunctionConfiguration();
	private FunctionConfiguration shareSnapshot = new FunctionConfiguration();
	private FunctionConfiguration snapshot = new FunctionConfiguration();


	public SnapshotConfiguration() {
		this.listSnapshots.setDelay(DEFAULT_SNAPSHOT_DELAY);
	}

	public FunctionConfiguration getAddSnapshotShare() {
		return addSnapshotShare;
	}

	public void setAddSnapshotShare(FunctionConfiguration addSnapshotShare) {
		this.addSnapshotShare = addSnapshotShare;
	}

	public FunctionConfiguration getAddPublicShare() {
		return addPublicShare;
	}

	public void setAddPublicShare(FunctionConfiguration addPublicShare) {
		this.addPublicShare = addPublicShare;
	}

	public FunctionConfiguration getCreateSnapshot() {
		return createSnapshot;
	}

	public void setCreateSnapshot(FunctionConfiguration createSnapshot) {
		this.createSnapshot = createSnapshot;
	}

	public FunctionConfiguration getGetSnapshot() {
		return getSnapshot;
	}

	public void setGetSnapshot(FunctionConfiguration getSnapshot) {
		this.getSnapshot = getSnapshot;
	}

	public FunctionConfiguration getIsPublic() {
		return isPublic;
	}

	public void setIsPublic(FunctionConfiguration isPublic) {
		this.isPublic = isPublic;
	}

	public FunctionConfiguration getListShares() {
		return listShares;
	}

	public void setListShares(FunctionConfiguration listShares) {
		this.listShares = listShares;
	}

	public FunctionConfiguration getListSnapshotStatus() {
		return listSnapshotStatus;
	}

	public void setListSnapshotStatus(FunctionConfiguration listSnapshotStatus) {
		this.listSnapshotStatus = listSnapshotStatus;
	}

	public FunctionConfiguration getListSnapshots() {
		return listSnapshots;
	}

	public void setListSnapshots(FunctionConfiguration listSnapshots) {
		this.listSnapshots = listSnapshots;
	}

	public FunctionConfiguration getRemove() {
		return remove;
	}

	public void setRemove(FunctionConfiguration remove) {
		this.remove = remove;
	}

	public FunctionConfiguration getRemoveAllSnapshotShares() {
		return removeAllSnapshotShares;
	}

	public void setRemoveAllSnapshotShares(FunctionConfiguration removeAllSnapshotShares) {
		this.removeAllSnapshotShares = removeAllSnapshotShares;
	}

	public FunctionConfiguration getRemoveSnapshotShare() {
		return removeSnapshotShare;
	}

	public void setRemoveSnapshotShare(FunctionConfiguration removeSnapshotShare) {
		this.removeSnapshotShare = removeSnapshotShare;
	}

	public FunctionConfiguration getRemovePublicShare() {
		return removePublicShare;
	}

	public void setRemovePublicShare(FunctionConfiguration removePublicShare) {
		this.removePublicShare = removePublicShare;
	}

	public FunctionConfiguration getRemoveTags() {
		return removeTags;
	}

	public void setRemoveTags(FunctionConfiguration removeTags) {
		this.removeTags = removeTags;
	}

	public FunctionConfiguration getSearchSnapshots() {
		return searchSnapshots;
	}

	public void setSearchSnapshots(FunctionConfiguration searchSnapshots) {
		this.searchSnapshots = searchSnapshots;
	}

	public FunctionConfiguration getUpdateTags() {
		return updateTags;
	}

	public void setUpdateTags(FunctionConfiguration updateTags) {
		this.updateTags = updateTags;
	}

	public FunctionConfiguration getSetTags() {
		return setTags;
	}

	public void setSetTags(FunctionConfiguration setTags) {
		this.setTags = setTags;
	}

	public FunctionConfiguration getCreate() {
		return create;
	}

	public void setCreate(FunctionConfiguration create) {
		this.create = create;
	}

	public FunctionConfiguration getShareSnapshot() {
		return shareSnapshot;
	}

	public void setShareSnapshot(FunctionConfiguration shareSnapshot) {
		this.shareSnapshot = shareSnapshot;
	}

	public FunctionConfiguration getSnapshot() {
		return snapshot;
	}

	public void setSnapshot(FunctionConfiguration snapshot) {
		this.snapshot = snapshot;
	}

	@Override
	public SnapshotConfiguration clone() {
		SnapshotConfiguration clone = new SnapshotConfiguration();
		clone.addSnapshotShare = addSnapshotShare.clone();
		clone.addPublicShare = addPublicShare.clone();
		clone.createSnapshot = createSnapshot.clone();
		clone.getSnapshot = getSnapshot.clone();
		clone.isPublic = isPublic.clone();
		clone.listShares = listShares.clone();
		clone.listSnapshotStatus = listSnapshotStatus.clone();
		clone.listSnapshots = listSnapshots.clone();
		clone.remove = remove.clone();
		clone.removeAllSnapshotShares = removeAllSnapshotShares.clone();
		clone.removeSnapshotShare = removeSnapshotShare.clone();
		clone.removePublicShare = removePublicShare.clone();
		clone.removeTags = removeTags.clone();
		clone.searchSnapshots = searchSnapshots.clone();
		clone.updateTags = updateTags.clone();
		clone.setTags = setTags.clone();
		clone.create = create.clone();
		clone.shareSnapshot = shareSnapshot.clone();
		clone.snapshot = snapshot.clone();
		return clone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addPublicShare == null) ? 0 : addPublicShare.hashCode());
		result = prime * result + ((addSnapshotShare == null) ? 0 : addSnapshotShare.hashCode());
		result = prime * result + ((createSnapshot == null) ? 0 : createSnapshot.hashCode());
		result = prime * result + ((getSnapshot == null) ? 0 : getSnapshot.hashCode());
		result = prime * result + ((isPublic == null) ? 0 : isPublic.hashCode());
		result = prime * result + ((listShares == null) ? 0 : listShares.hashCode());
		result = prime * result + ((listSnapshotStatus == null) ? 0 : listSnapshotStatus.hashCode());
		result = prime * result + ((listSnapshots == null) ? 0 : listSnapshots.hashCode());
		result = prime * result + ((remove == null) ? 0 : remove.hashCode());
		result = prime * result + ((removeAllSnapshotShares == null) ? 0 : removeAllSnapshotShares.hashCode());
		result = prime * result + ((removePublicShare == null) ? 0 : removePublicShare.hashCode());
		result = prime * result + ((removeSnapshotShare == null) ? 0 : removeSnapshotShare.hashCode());
		result = prime * result + ((removeTags == null) ? 0 : removeTags.hashCode());
		result = prime * result + ((searchSnapshots == null) ? 0 : searchSnapshots.hashCode());
		result = prime * result + ((setTags == null) ? 0 : setTags.hashCode());
		result = prime * result + ((updateTags == null) ? 0 : updateTags.hashCode());
		result = prime * result + ((create == null) ? 0 : create.hashCode());
		result = prime * result + ((shareSnapshot == null) ? 0 : shareSnapshot.hashCode());
		result = prime * result + ((snapshot == null) ? 0 : snapshot.hashCode());
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
		SnapshotConfiguration other = (SnapshotConfiguration) obj;
		if (addPublicShare == null) {
			if (other.addPublicShare != null)
				return false;
		} else if (!addPublicShare.equals(other.addPublicShare))
			return false;
		if (addSnapshotShare == null) {
			if (other.addSnapshotShare != null)
				return false;
		} else if (!addSnapshotShare.equals(other.addSnapshotShare))
			return false;
		if (createSnapshot == null) {
			if (other.createSnapshot != null)
				return false;
		} else if (!createSnapshot.equals(other.createSnapshot))
			return false;
		if (getSnapshot == null) {
			if (other.getSnapshot != null)
				return false;
		} else if (!getSnapshot.equals(other.getSnapshot))
			return false;
		if (isPublic == null) {
			if (other.isPublic != null)
				return false;
		} else if (!isPublic.equals(other.isPublic))
			return false;
		if (listShares == null) {
			if (other.listShares != null)
				return false;
		} else if (!listShares.equals(other.listShares))
			return false;
		if (listSnapshotStatus == null) {
			if (other.listSnapshotStatus != null)
				return false;
		} else if (!listSnapshotStatus.equals(other.listSnapshotStatus))
			return false;
		if (listSnapshots == null) {
			if (other.listSnapshots != null)
				return false;
		} else if (!listSnapshots.equals(other.listSnapshots))
			return false;
		if (remove == null) {
			if (other.remove != null)
				return false;
		} else if (!remove.equals(other.remove))
			return false;
		if (removeAllSnapshotShares == null) {
			if (other.removeAllSnapshotShares != null)
				return false;
		} else if (!removeAllSnapshotShares.equals(other.removeAllSnapshotShares))
			return false;
		if (removePublicShare == null) {
			if (other.removePublicShare != null)
				return false;
		} else if (!removePublicShare.equals(other.removePublicShare))
			return false;
		if (removeSnapshotShare == null) {
			if (other.removeSnapshotShare != null)
				return false;
		} else if (!removeSnapshotShare.equals(other.removeSnapshotShare))
			return false;
		if (removeTags == null) {
			if (other.removeTags != null)
				return false;
		} else if (!removeTags.equals(other.removeTags))
			return false;
		if (searchSnapshots == null) {
			if (other.searchSnapshots != null)
				return false;
		} else if (!searchSnapshots.equals(other.searchSnapshots))
			return false;
		if (setTags == null) {
			if (other.setTags != null)
				return false;
		} else if (!setTags.equals(other.setTags))
			return false;
		if (updateTags == null) {
			if (other.updateTags != null)
				return false;
		} else if (!updateTags.equals(other.updateTags))
			return false;
		if (create == null) {
			if (other.create != null)
				return false;
		} else if (!create.equals(other.create))
			return false;
		if (shareSnapshot == null) {
			if (other.shareSnapshot != null)
				return false;
		} else if (!shareSnapshot.equals(other.shareSnapshot))
			return false;
		if (create == null) {
			if (other.create != null)
				return false;
		} else if (!create.equals(other.create))
			return false;
		return true;
	}

}
