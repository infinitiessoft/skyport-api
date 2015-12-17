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
package com.infinities.skyport.model.configuration.compute;

import java.io.Serializable;

import com.infinities.skyport.model.FunctionConfiguration;
import com.infinities.skyport.model.Time;

public class VolumeConfiguration implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final Time DEFAULT_VOLUME_DELAY = new Time();
	public static final Time DEFAULT_VOLUMEPRODUCT_DELAY = new Time();
	static {
		DEFAULT_VOLUME_DELAY.setNumber(60);
		DEFAULT_VOLUMEPRODUCT_DELAY.setNumber(300);
	}

	private FunctionConfiguration attach = new FunctionConfiguration();
	private FunctionConfiguration create = new FunctionConfiguration();
	private FunctionConfiguration createVolume = new FunctionConfiguration();
	private FunctionConfiguration detach = new FunctionConfiguration();
	private FunctionConfiguration getVolume = new FunctionConfiguration();
	private FunctionConfiguration listVolumeProducts = new FunctionConfiguration();
	private FunctionConfiguration listVolumeStatus = new FunctionConfiguration();
	private FunctionConfiguration listVolumes = new FunctionConfiguration();
	private FunctionConfiguration remove = new FunctionConfiguration();
	private FunctionConfiguration removeTags = new FunctionConfiguration();
	private FunctionConfiguration updateTags = new FunctionConfiguration();
	private FunctionConfiguration setTags = new FunctionConfiguration();


	public VolumeConfiguration() {
		listVolumeProducts.setDelay(DEFAULT_VOLUMEPRODUCT_DELAY);
		listVolumes.setDelay(DEFAULT_VOLUME_DELAY);
	}

	public FunctionConfiguration getAttach() {
		return attach;
	}

	public void setAttach(FunctionConfiguration attach) {
		this.attach = attach;
	}

	public FunctionConfiguration getCreate() {
		return create;
	}

	public void setCreate(FunctionConfiguration create) {
		this.create = create;
	}

	public FunctionConfiguration getCreateVolume() {
		return createVolume;
	}

	public void setCreateVolume(FunctionConfiguration createVolume) {
		this.createVolume = createVolume;
	}

	public FunctionConfiguration getDetach() {
		return detach;
	}

	public void setDetach(FunctionConfiguration detach) {
		this.detach = detach;
	}

	public FunctionConfiguration getGetVolume() {
		return getVolume;
	}

	public void setGetVolume(FunctionConfiguration getVolume) {
		this.getVolume = getVolume;
	}

	public FunctionConfiguration getListVolumeProducts() {
		return listVolumeProducts;
	}

	public void setListVolumeProducts(FunctionConfiguration listVolumeProducts) {
		this.listVolumeProducts = listVolumeProducts;
	}

	public FunctionConfiguration getListVolumeStatus() {
		return listVolumeStatus;
	}

	public void setListVolumeStatus(FunctionConfiguration listVolumeStatus) {
		this.listVolumeStatus = listVolumeStatus;
	}

	public FunctionConfiguration getListVolumes() {
		return listVolumes;
	}

	public void setListVolumes(FunctionConfiguration listVolumes) {
		this.listVolumes = listVolumes;
	}

	public FunctionConfiguration getRemove() {
		return remove;
	}

	public void setRemove(FunctionConfiguration remove) {
		this.remove = remove;
	}

	public FunctionConfiguration getRemoveTags() {
		return removeTags;
	}

	public void setRemoveTags(FunctionConfiguration removeTags) {
		this.removeTags = removeTags;
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

	@Override
	public VolumeConfiguration clone() {
		VolumeConfiguration clone = new VolumeConfiguration();
		clone.attach = attach.clone();
		clone.create = create.clone();
		clone.createVolume = createVolume.clone();
		clone.detach = detach.clone();
		clone.getVolume = getVolume.clone();
		clone.listVolumeProducts = listVolumeProducts.clone();
		clone.listVolumeStatus = listVolumeStatus.clone();
		clone.listVolumes = listVolumes.clone();
		clone.remove = remove.clone();
		clone.removeTags = removeTags.clone();
		clone.updateTags = updateTags.clone();
		clone.setTags = setTags.clone();
		return clone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attach == null) ? 0 : attach.hashCode());
		result = prime * result + ((create == null) ? 0 : create.hashCode());
		result = prime * result + ((createVolume == null) ? 0 : createVolume.hashCode());
		result = prime * result + ((detach == null) ? 0 : detach.hashCode());
		result = prime * result + ((getVolume == null) ? 0 : getVolume.hashCode());
		result = prime * result + ((listVolumeProducts == null) ? 0 : listVolumeProducts.hashCode());
		result = prime * result + ((listVolumeStatus == null) ? 0 : listVolumeStatus.hashCode());
		result = prime * result + ((listVolumes == null) ? 0 : listVolumes.hashCode());
		result = prime * result + ((remove == null) ? 0 : remove.hashCode());
		result = prime * result + ((removeTags == null) ? 0 : removeTags.hashCode());
		result = prime * result + ((setTags == null) ? 0 : setTags.hashCode());
		result = prime * result + ((updateTags == null) ? 0 : updateTags.hashCode());
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
		VolumeConfiguration other = (VolumeConfiguration) obj;
		if (attach == null) {
			if (other.attach != null)
				return false;
		} else if (!attach.equals(other.attach))
			return false;
		if (create == null) {
			if (other.create != null)
				return false;
		} else if (!create.equals(other.create))
			return false;
		if (createVolume == null) {
			if (other.createVolume != null)
				return false;
		} else if (!createVolume.equals(other.createVolume))
			return false;
		if (detach == null) {
			if (other.detach != null)
				return false;
		} else if (!detach.equals(other.detach))
			return false;
		if (getVolume == null) {
			if (other.getVolume != null)
				return false;
		} else if (!getVolume.equals(other.getVolume))
			return false;
		if (listVolumeProducts == null) {
			if (other.listVolumeProducts != null)
				return false;
		} else if (!listVolumeProducts.equals(other.listVolumeProducts))
			return false;
		if (listVolumeStatus == null) {
			if (other.listVolumeStatus != null)
				return false;
		} else if (!listVolumeStatus.equals(other.listVolumeStatus))
			return false;
		if (listVolumes == null) {
			if (other.listVolumes != null)
				return false;
		} else if (!listVolumes.equals(other.listVolumes))
			return false;
		if (remove == null) {
			if (other.remove != null)
				return false;
		} else if (!remove.equals(other.remove))
			return false;
		if (removeTags == null) {
			if (other.removeTags != null)
				return false;
		} else if (!removeTags.equals(other.removeTags))
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
		return true;
	}

}
