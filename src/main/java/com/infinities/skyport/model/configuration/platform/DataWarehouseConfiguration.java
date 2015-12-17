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
package com.infinities.skyport.model.configuration.platform;

import java.io.Serializable;

import com.infinities.skyport.model.FunctionConfiguration;

public class DataWarehouseConfiguration implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	private FunctionConfiguration addSnapshotShare = new FunctionConfiguration();
	private FunctionConfiguration authorizeComputeFirewalls = new FunctionConfiguration();
	private FunctionConfiguration authorizeIPs = new FunctionConfiguration();
	private FunctionConfiguration createCluster = new FunctionConfiguration();
	private FunctionConfiguration createClusterFirewall = new FunctionConfiguration();
	private FunctionConfiguration createClusterParameterGroup = new FunctionConfiguration();
	private FunctionConfiguration createClusterSnapshot = new FunctionConfiguration();
	private FunctionConfiguration disableLogging = new FunctionConfiguration();
	private FunctionConfiguration enableLogging = new FunctionConfiguration();
	private FunctionConfiguration getCluster = new FunctionConfiguration();
	private FunctionConfiguration getClusterFirewall = new FunctionConfiguration();
	private FunctionConfiguration getClusterLoggingStatus = new FunctionConfiguration();
	private FunctionConfiguration getClusterParameterGroup = new FunctionConfiguration();
	private FunctionConfiguration getClusterProduct = new FunctionConfiguration();
	private FunctionConfiguration getClusterSnapshot = new FunctionConfiguration();
	private FunctionConfiguration getDataCenterConstraintRequirement = new FunctionConfiguration();
	private FunctionConfiguration listClusterFirewalls = new FunctionConfiguration();
	private FunctionConfiguration listClusterParameterGroups = new FunctionConfiguration();
	private FunctionConfiguration listClusterProducts = new FunctionConfiguration();
	private FunctionConfiguration listClusterSnapshots = new FunctionConfiguration();
	private FunctionConfiguration listClusterVersions = new FunctionConfiguration();
	private FunctionConfiguration listClusters = new FunctionConfiguration();
	private FunctionConfiguration rebootCluster = new FunctionConfiguration();
	private FunctionConfiguration removeAllSnapshotShares = new FunctionConfiguration();
	private FunctionConfiguration removeCluster = new FunctionConfiguration();
	private FunctionConfiguration removeClusterFirewall = new FunctionConfiguration();
	private FunctionConfiguration removeClusterParameterGroup = new FunctionConfiguration();
	private FunctionConfiguration removeClusterSnapshot = new FunctionConfiguration();
	private FunctionConfiguration removeSnapshotShare = new FunctionConfiguration();
	private FunctionConfiguration resizeCluster = new FunctionConfiguration();
	private FunctionConfiguration revokeComputeFirewalls = new FunctionConfiguration();
	private FunctionConfiguration revokeIPs = new FunctionConfiguration();
	private FunctionConfiguration rotateEncryptionKeys = new FunctionConfiguration();
	private FunctionConfiguration supportsAuthorizingComputeFirewalls = new FunctionConfiguration();
	private FunctionConfiguration supportsCloudStorageLogging = new FunctionConfiguration();
	private FunctionConfiguration supportsClusterFirewalls = new FunctionConfiguration();
	private FunctionConfiguration supportsClusterSnapshots = new FunctionConfiguration();
	private FunctionConfiguration supportsEncryptionAtRest = new FunctionConfiguration();
	private FunctionConfiguration updateParameters = new FunctionConfiguration();
	private FunctionConfiguration supportsSnapshotSharing = new FunctionConfiguration();
	private FunctionConfiguration updateClusterTags = new FunctionConfiguration();
	private FunctionConfiguration updateSnapshotTags = new FunctionConfiguration();


	public FunctionConfiguration getAddSnapshotShare() {
		return addSnapshotShare;
	}

	public void setAddSnapshotShare(FunctionConfiguration addSnapshotShare) {
		this.addSnapshotShare = addSnapshotShare;
	}

	public FunctionConfiguration getAuthorizeComputeFirewalls() {
		return authorizeComputeFirewalls;
	}

	public void setAuthorizeComputeFirewalls(FunctionConfiguration authorizeComputeFirewalls) {
		this.authorizeComputeFirewalls = authorizeComputeFirewalls;
	}

	public FunctionConfiguration getAuthorizeIPs() {
		return authorizeIPs;
	}

	public void setAuthorizeIPs(FunctionConfiguration authorizeIPs) {
		this.authorizeIPs = authorizeIPs;
	}

	public FunctionConfiguration getCreateCluster() {
		return createCluster;
	}

	public void setCreateCluster(FunctionConfiguration createCluster) {
		this.createCluster = createCluster;
	}

	public FunctionConfiguration getCreateClusterFirewall() {
		return createClusterFirewall;
	}

	public void setCreateClusterFirewall(FunctionConfiguration createClusterFirewall) {
		this.createClusterFirewall = createClusterFirewall;
	}

	public FunctionConfiguration getCreateClusterParameterGroup() {
		return createClusterParameterGroup;
	}

	public void setCreateClusterParameterGroup(FunctionConfiguration createClusterParameterGroup) {
		this.createClusterParameterGroup = createClusterParameterGroup;
	}

	public FunctionConfiguration getCreateClusterSnapshot() {
		return createClusterSnapshot;
	}

	public void setCreateClusterSnapshot(FunctionConfiguration createClusterSnapshot) {
		this.createClusterSnapshot = createClusterSnapshot;
	}

	public FunctionConfiguration getDisableLogging() {
		return disableLogging;
	}

	public void setDisableLogging(FunctionConfiguration disableLogging) {
		this.disableLogging = disableLogging;
	}

	public FunctionConfiguration getEnableLogging() {
		return enableLogging;
	}

	public void setEnableLogging(FunctionConfiguration enableLogging) {
		this.enableLogging = enableLogging;
	}

	public FunctionConfiguration getGetCluster() {
		return getCluster;
	}

	public void setGetCluster(FunctionConfiguration getCluster) {
		this.getCluster = getCluster;
	}

	public FunctionConfiguration getGetClusterFirewall() {
		return getClusterFirewall;
	}

	public void setGetClusterFirewall(FunctionConfiguration getClusterFirewall) {
		this.getClusterFirewall = getClusterFirewall;
	}

	public FunctionConfiguration getGetClusterLoggingStatus() {
		return getClusterLoggingStatus;
	}

	public void setGetClusterLoggingStatus(FunctionConfiguration getClusterLoggingStatus) {
		this.getClusterLoggingStatus = getClusterLoggingStatus;
	}

	public FunctionConfiguration getGetClusterParameterGroup() {
		return getClusterParameterGroup;
	}

	public void setGetClusterParameterGroup(FunctionConfiguration getClusterParameterGroup) {
		this.getClusterParameterGroup = getClusterParameterGroup;
	}

	public FunctionConfiguration getGetClusterProduct() {
		return getClusterProduct;
	}

	public void setGetClusterProduct(FunctionConfiguration getClusterProduct) {
		this.getClusterProduct = getClusterProduct;
	}

	public FunctionConfiguration getGetClusterSnapshot() {
		return getClusterSnapshot;
	}

	public void setGetClusterSnapshot(FunctionConfiguration getClusterSnapshot) {
		this.getClusterSnapshot = getClusterSnapshot;
	}

	public FunctionConfiguration getGetDataCenterConstraintRequirement() {
		return getDataCenterConstraintRequirement;
	}

	public void setGetDataCenterConstraintRequirement(FunctionConfiguration getDataCenterConstraintRequirement) {
		this.getDataCenterConstraintRequirement = getDataCenterConstraintRequirement;
	}

	public FunctionConfiguration getListClusterFirewalls() {
		return listClusterFirewalls;
	}

	public void setListClusterFirewalls(FunctionConfiguration listClusterFirewalls) {
		this.listClusterFirewalls = listClusterFirewalls;
	}

	public FunctionConfiguration getListClusterParameterGroups() {
		return listClusterParameterGroups;
	}

	public void setListClusterParameterGroups(FunctionConfiguration listClusterParameterGroups) {
		this.listClusterParameterGroups = listClusterParameterGroups;
	}

	public FunctionConfiguration getListClusterProducts() {
		return listClusterProducts;
	}

	public void setListClusterProducts(FunctionConfiguration listClusterProducts) {
		this.listClusterProducts = listClusterProducts;
	}

	public FunctionConfiguration getListClusterSnapshots() {
		return listClusterSnapshots;
	}

	public void setListClusterSnapshots(FunctionConfiguration listClusterSnapshots) {
		this.listClusterSnapshots = listClusterSnapshots;
	}

	public FunctionConfiguration getListClusterVersions() {
		return listClusterVersions;
	}

	public void setListClusterVersions(FunctionConfiguration listClusterVersions) {
		this.listClusterVersions = listClusterVersions;
	}

	public FunctionConfiguration getListClusters() {
		return listClusters;
	}

	public void setListClusters(FunctionConfiguration listClusters) {
		this.listClusters = listClusters;
	}

	public FunctionConfiguration getRebootCluster() {
		return rebootCluster;
	}

	public void setRebootCluster(FunctionConfiguration rebootCluster) {
		this.rebootCluster = rebootCluster;
	}

	public FunctionConfiguration getRemoveAllSnapshotShares() {
		return removeAllSnapshotShares;
	}

	public void setRemoveAllSnapshotShares(FunctionConfiguration removeAllSnapshotShares) {
		this.removeAllSnapshotShares = removeAllSnapshotShares;
	}

	public FunctionConfiguration getRemoveCluster() {
		return removeCluster;
	}

	public void setRemoveCluster(FunctionConfiguration removeCluster) {
		this.removeCluster = removeCluster;
	}

	public FunctionConfiguration getRemoveClusterFirewall() {
		return removeClusterFirewall;
	}

	public void setRemoveClusterFirewall(FunctionConfiguration removeClusterFirewall) {
		this.removeClusterFirewall = removeClusterFirewall;
	}

	public FunctionConfiguration getRemoveClusterParameterGroup() {
		return removeClusterParameterGroup;
	}

	public void setRemoveClusterParameterGroup(FunctionConfiguration removeClusterParameterGroup) {
		this.removeClusterParameterGroup = removeClusterParameterGroup;
	}

	public FunctionConfiguration getRemoveClusterSnapshot() {
		return removeClusterSnapshot;
	}

	public void setRemoveClusterSnapshot(FunctionConfiguration removeClusterSnapshot) {
		this.removeClusterSnapshot = removeClusterSnapshot;
	}

	public FunctionConfiguration getRemoveSnapshotShare() {
		return removeSnapshotShare;
	}

	public void setRemoveSnapshotShare(FunctionConfiguration removeSnapshotShare) {
		this.removeSnapshotShare = removeSnapshotShare;
	}

	public FunctionConfiguration getResizeCluster() {
		return resizeCluster;
	}

	public void setResizeCluster(FunctionConfiguration resizeCluster) {
		this.resizeCluster = resizeCluster;
	}

	public FunctionConfiguration getRevokeComputeFirewalls() {
		return revokeComputeFirewalls;
	}

	public void setRevokeComputeFirewalls(FunctionConfiguration revokeComputeFirewalls) {
		this.revokeComputeFirewalls = revokeComputeFirewalls;
	}

	public FunctionConfiguration getRevokeIPs() {
		return revokeIPs;
	}

	public void setRevokeIPs(FunctionConfiguration revokeIPs) {
		this.revokeIPs = revokeIPs;
	}

	public FunctionConfiguration getRotateEncryptionKeys() {
		return rotateEncryptionKeys;
	}

	public void setRotateEncryptionKeys(FunctionConfiguration rotateEncryptionKeys) {
		this.rotateEncryptionKeys = rotateEncryptionKeys;
	}

	public FunctionConfiguration getSupportsAuthorizingComputeFirewalls() {
		return supportsAuthorizingComputeFirewalls;
	}

	public void setSupportsAuthorizingComputeFirewalls(FunctionConfiguration supportsAuthorizingComputeFirewalls) {
		this.supportsAuthorizingComputeFirewalls = supportsAuthorizingComputeFirewalls;
	}

	public FunctionConfiguration getSupportsCloudStorageLogging() {
		return supportsCloudStorageLogging;
	}

	public void setSupportsCloudStorageLogging(FunctionConfiguration supportsCloudStorageLogging) {
		this.supportsCloudStorageLogging = supportsCloudStorageLogging;
	}

	public FunctionConfiguration getSupportsClusterFirewalls() {
		return supportsClusterFirewalls;
	}

	public void setSupportsClusterFirewalls(FunctionConfiguration supportsClusterFirewalls) {
		this.supportsClusterFirewalls = supportsClusterFirewalls;
	}

	public FunctionConfiguration getSupportsClusterSnapshots() {
		return supportsClusterSnapshots;
	}

	public void setSupportsClusterSnapshots(FunctionConfiguration supportsClusterSnapshots) {
		this.supportsClusterSnapshots = supportsClusterSnapshots;
	}

	public FunctionConfiguration getSupportsEncryptionAtRest() {
		return supportsEncryptionAtRest;
	}

	public void setSupportsEncryptionAtRest(FunctionConfiguration supportsEncryptionAtRest) {
		this.supportsEncryptionAtRest = supportsEncryptionAtRest;
	}

	public FunctionConfiguration getUpdateParameters() {
		return updateParameters;
	}

	public void setUpdateParameters(FunctionConfiguration updateParameters) {
		this.updateParameters = updateParameters;
	}

	public FunctionConfiguration getSupportsSnapshotSharing() {
		return supportsSnapshotSharing;
	}

	public void setSupportsSnapshotSharing(FunctionConfiguration supportsSnapshotSharing) {
		this.supportsSnapshotSharing = supportsSnapshotSharing;
	}

	public FunctionConfiguration getUpdateClusterTags() {
		return updateClusterTags;
	}

	public void setUpdateClusterTags(FunctionConfiguration updateClusterTags) {
		this.updateClusterTags = updateClusterTags;
	}

	public FunctionConfiguration getUpdateSnapshotTags() {
		return updateSnapshotTags;
	}

	public void setUpdateSnapshotTags(FunctionConfiguration updateSnapshotTags) {
		this.updateSnapshotTags = updateSnapshotTags;
	}

	@Override
	public DataWarehouseConfiguration clone() {
		DataWarehouseConfiguration clone = new DataWarehouseConfiguration();
		clone.addSnapshotShare = addSnapshotShare.clone();
		clone.authorizeComputeFirewalls = authorizeComputeFirewalls.clone();
		clone.authorizeIPs = authorizeIPs.clone();
		clone.createCluster = createCluster.clone();
		clone.createClusterFirewall = createClusterFirewall.clone();
		clone.createClusterParameterGroup = createClusterParameterGroup.clone();
		clone.createClusterSnapshot = createClusterSnapshot.clone();
		clone.disableLogging = disableLogging.clone();
		clone.enableLogging = enableLogging.clone();
		clone.getCluster = getCluster.clone();
		clone.getClusterFirewall = getClusterFirewall.clone();
		clone.getClusterLoggingStatus = getClusterLoggingStatus.clone();
		clone.getClusterParameterGroup = getClusterParameterGroup.clone();
		clone.getClusterProduct = getClusterProduct.clone();
		clone.getClusterSnapshot = getClusterSnapshot.clone();
		clone.getDataCenterConstraintRequirement = getDataCenterConstraintRequirement.clone();
		clone.listClusterFirewalls = listClusterFirewalls.clone();
		clone.listClusterParameterGroups = listClusterParameterGroups.clone();
		clone.listClusterProducts = listClusterProducts.clone();
		clone.listClusterSnapshots = listClusterSnapshots.clone();
		clone.listClusterVersions = listClusterVersions.clone();
		clone.listClusters = listClusters.clone();
		clone.rebootCluster = rebootCluster.clone();
		clone.removeAllSnapshotShares = removeAllSnapshotShares.clone();
		clone.removeCluster = removeCluster.clone();
		clone.removeClusterFirewall = removeClusterFirewall.clone();
		clone.removeClusterParameterGroup = removeClusterParameterGroup.clone();
		clone.removeClusterSnapshot = removeClusterSnapshot.clone();
		clone.removeSnapshotShare = removeSnapshotShare.clone();
		clone.resizeCluster = resizeCluster.clone();
		clone.revokeComputeFirewalls = revokeComputeFirewalls.clone();
		clone.revokeIPs = revokeIPs.clone();
		clone.rotateEncryptionKeys = rotateEncryptionKeys.clone();
		clone.supportsAuthorizingComputeFirewalls = supportsAuthorizingComputeFirewalls.clone();
		clone.supportsCloudStorageLogging = supportsCloudStorageLogging.clone();
		clone.supportsClusterFirewalls = supportsClusterFirewalls.clone();
		clone.supportsClusterSnapshots = supportsClusterSnapshots.clone();
		clone.supportsEncryptionAtRest = supportsEncryptionAtRest.clone();
		clone.updateParameters = updateParameters.clone();
		clone.supportsSnapshotSharing = supportsSnapshotSharing.clone();
		clone.updateClusterTags = updateClusterTags.clone();
		clone.updateSnapshotTags = updateSnapshotTags.clone();
		return clone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addSnapshotShare == null) ? 0 : addSnapshotShare.hashCode());
		result = prime * result + ((authorizeComputeFirewalls == null) ? 0 : authorizeComputeFirewalls.hashCode());
		result = prime * result + ((authorizeIPs == null) ? 0 : authorizeIPs.hashCode());
		result = prime * result + ((createCluster == null) ? 0 : createCluster.hashCode());
		result = prime * result + ((createClusterFirewall == null) ? 0 : createClusterFirewall.hashCode());
		result = prime * result + ((createClusterParameterGroup == null) ? 0 : createClusterParameterGroup.hashCode());
		result = prime * result + ((createClusterSnapshot == null) ? 0 : createClusterSnapshot.hashCode());
		result = prime * result + ((disableLogging == null) ? 0 : disableLogging.hashCode());
		result = prime * result + ((enableLogging == null) ? 0 : enableLogging.hashCode());
		result = prime * result + ((getCluster == null) ? 0 : getCluster.hashCode());
		result = prime * result + ((getClusterFirewall == null) ? 0 : getClusterFirewall.hashCode());
		result = prime * result + ((getClusterLoggingStatus == null) ? 0 : getClusterLoggingStatus.hashCode());
		result = prime * result + ((getClusterParameterGroup == null) ? 0 : getClusterParameterGroup.hashCode());
		result = prime * result + ((getClusterProduct == null) ? 0 : getClusterProduct.hashCode());
		result = prime * result + ((getClusterSnapshot == null) ? 0 : getClusterSnapshot.hashCode());
		result = prime * result
				+ ((getDataCenterConstraintRequirement == null) ? 0 : getDataCenterConstraintRequirement.hashCode());
		result = prime * result + ((listClusterFirewalls == null) ? 0 : listClusterFirewalls.hashCode());
		result = prime * result + ((listClusterParameterGroups == null) ? 0 : listClusterParameterGroups.hashCode());
		result = prime * result + ((listClusterProducts == null) ? 0 : listClusterProducts.hashCode());
		result = prime * result + ((listClusterSnapshots == null) ? 0 : listClusterSnapshots.hashCode());
		result = prime * result + ((listClusterVersions == null) ? 0 : listClusterVersions.hashCode());
		result = prime * result + ((listClusters == null) ? 0 : listClusters.hashCode());
		result = prime * result + ((rebootCluster == null) ? 0 : rebootCluster.hashCode());
		result = prime * result + ((removeAllSnapshotShares == null) ? 0 : removeAllSnapshotShares.hashCode());
		result = prime * result + ((removeCluster == null) ? 0 : removeCluster.hashCode());
		result = prime * result + ((removeClusterFirewall == null) ? 0 : removeClusterFirewall.hashCode());
		result = prime * result + ((removeClusterParameterGroup == null) ? 0 : removeClusterParameterGroup.hashCode());
		result = prime * result + ((removeClusterSnapshot == null) ? 0 : removeClusterSnapshot.hashCode());
		result = prime * result + ((removeSnapshotShare == null) ? 0 : removeSnapshotShare.hashCode());
		result = prime * result + ((resizeCluster == null) ? 0 : resizeCluster.hashCode());
		result = prime * result + ((revokeComputeFirewalls == null) ? 0 : revokeComputeFirewalls.hashCode());
		result = prime * result + ((revokeIPs == null) ? 0 : revokeIPs.hashCode());
		result = prime * result + ((rotateEncryptionKeys == null) ? 0 : rotateEncryptionKeys.hashCode());
		result = prime * result
				+ ((supportsAuthorizingComputeFirewalls == null) ? 0 : supportsAuthorizingComputeFirewalls.hashCode());
		result = prime * result + ((supportsCloudStorageLogging == null) ? 0 : supportsCloudStorageLogging.hashCode());
		result = prime * result + ((supportsClusterFirewalls == null) ? 0 : supportsClusterFirewalls.hashCode());
		result = prime * result + ((supportsClusterSnapshots == null) ? 0 : supportsClusterSnapshots.hashCode());
		result = prime * result + ((supportsEncryptionAtRest == null) ? 0 : supportsEncryptionAtRest.hashCode());
		result = prime * result + ((supportsSnapshotSharing == null) ? 0 : supportsSnapshotSharing.hashCode());
		result = prime * result + ((updateClusterTags == null) ? 0 : updateClusterTags.hashCode());
		result = prime * result + ((updateParameters == null) ? 0 : updateParameters.hashCode());
		result = prime * result + ((updateSnapshotTags == null) ? 0 : updateSnapshotTags.hashCode());
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
		DataWarehouseConfiguration other = (DataWarehouseConfiguration) obj;
		if (addSnapshotShare == null) {
			if (other.addSnapshotShare != null)
				return false;
		} else if (!addSnapshotShare.equals(other.addSnapshotShare))
			return false;
		if (authorizeComputeFirewalls == null) {
			if (other.authorizeComputeFirewalls != null)
				return false;
		} else if (!authorizeComputeFirewalls.equals(other.authorizeComputeFirewalls))
			return false;
		if (authorizeIPs == null) {
			if (other.authorizeIPs != null)
				return false;
		} else if (!authorizeIPs.equals(other.authorizeIPs))
			return false;
		if (createCluster == null) {
			if (other.createCluster != null)
				return false;
		} else if (!createCluster.equals(other.createCluster))
			return false;
		if (createClusterFirewall == null) {
			if (other.createClusterFirewall != null)
				return false;
		} else if (!createClusterFirewall.equals(other.createClusterFirewall))
			return false;
		if (createClusterParameterGroup == null) {
			if (other.createClusterParameterGroup != null)
				return false;
		} else if (!createClusterParameterGroup.equals(other.createClusterParameterGroup))
			return false;
		if (createClusterSnapshot == null) {
			if (other.createClusterSnapshot != null)
				return false;
		} else if (!createClusterSnapshot.equals(other.createClusterSnapshot))
			return false;
		if (disableLogging == null) {
			if (other.disableLogging != null)
				return false;
		} else if (!disableLogging.equals(other.disableLogging))
			return false;
		if (enableLogging == null) {
			if (other.enableLogging != null)
				return false;
		} else if (!enableLogging.equals(other.enableLogging))
			return false;
		if (getCluster == null) {
			if (other.getCluster != null)
				return false;
		} else if (!getCluster.equals(other.getCluster))
			return false;
		if (getClusterFirewall == null) {
			if (other.getClusterFirewall != null)
				return false;
		} else if (!getClusterFirewall.equals(other.getClusterFirewall))
			return false;
		if (getClusterLoggingStatus == null) {
			if (other.getClusterLoggingStatus != null)
				return false;
		} else if (!getClusterLoggingStatus.equals(other.getClusterLoggingStatus))
			return false;
		if (getClusterParameterGroup == null) {
			if (other.getClusterParameterGroup != null)
				return false;
		} else if (!getClusterParameterGroup.equals(other.getClusterParameterGroup))
			return false;
		if (getClusterProduct == null) {
			if (other.getClusterProduct != null)
				return false;
		} else if (!getClusterProduct.equals(other.getClusterProduct))
			return false;
		if (getClusterSnapshot == null) {
			if (other.getClusterSnapshot != null)
				return false;
		} else if (!getClusterSnapshot.equals(other.getClusterSnapshot))
			return false;
		if (getDataCenterConstraintRequirement == null) {
			if (other.getDataCenterConstraintRequirement != null)
				return false;
		} else if (!getDataCenterConstraintRequirement.equals(other.getDataCenterConstraintRequirement))
			return false;
		if (listClusterFirewalls == null) {
			if (other.listClusterFirewalls != null)
				return false;
		} else if (!listClusterFirewalls.equals(other.listClusterFirewalls))
			return false;
		if (listClusterParameterGroups == null) {
			if (other.listClusterParameterGroups != null)
				return false;
		} else if (!listClusterParameterGroups.equals(other.listClusterParameterGroups))
			return false;
		if (listClusterProducts == null) {
			if (other.listClusterProducts != null)
				return false;
		} else if (!listClusterProducts.equals(other.listClusterProducts))
			return false;
		if (listClusterSnapshots == null) {
			if (other.listClusterSnapshots != null)
				return false;
		} else if (!listClusterSnapshots.equals(other.listClusterSnapshots))
			return false;
		if (listClusterVersions == null) {
			if (other.listClusterVersions != null)
				return false;
		} else if (!listClusterVersions.equals(other.listClusterVersions))
			return false;
		if (listClusters == null) {
			if (other.listClusters != null)
				return false;
		} else if (!listClusters.equals(other.listClusters))
			return false;
		if (rebootCluster == null) {
			if (other.rebootCluster != null)
				return false;
		} else if (!rebootCluster.equals(other.rebootCluster))
			return false;
		if (removeAllSnapshotShares == null) {
			if (other.removeAllSnapshotShares != null)
				return false;
		} else if (!removeAllSnapshotShares.equals(other.removeAllSnapshotShares))
			return false;
		if (removeCluster == null) {
			if (other.removeCluster != null)
				return false;
		} else if (!removeCluster.equals(other.removeCluster))
			return false;
		if (removeClusterFirewall == null) {
			if (other.removeClusterFirewall != null)
				return false;
		} else if (!removeClusterFirewall.equals(other.removeClusterFirewall))
			return false;
		if (removeClusterParameterGroup == null) {
			if (other.removeClusterParameterGroup != null)
				return false;
		} else if (!removeClusterParameterGroup.equals(other.removeClusterParameterGroup))
			return false;
		if (removeClusterSnapshot == null) {
			if (other.removeClusterSnapshot != null)
				return false;
		} else if (!removeClusterSnapshot.equals(other.removeClusterSnapshot))
			return false;
		if (removeSnapshotShare == null) {
			if (other.removeSnapshotShare != null)
				return false;
		} else if (!removeSnapshotShare.equals(other.removeSnapshotShare))
			return false;
		if (resizeCluster == null) {
			if (other.resizeCluster != null)
				return false;
		} else if (!resizeCluster.equals(other.resizeCluster))
			return false;
		if (revokeComputeFirewalls == null) {
			if (other.revokeComputeFirewalls != null)
				return false;
		} else if (!revokeComputeFirewalls.equals(other.revokeComputeFirewalls))
			return false;
		if (revokeIPs == null) {
			if (other.revokeIPs != null)
				return false;
		} else if (!revokeIPs.equals(other.revokeIPs))
			return false;
		if (rotateEncryptionKeys == null) {
			if (other.rotateEncryptionKeys != null)
				return false;
		} else if (!rotateEncryptionKeys.equals(other.rotateEncryptionKeys))
			return false;
		if (supportsAuthorizingComputeFirewalls == null) {
			if (other.supportsAuthorizingComputeFirewalls != null)
				return false;
		} else if (!supportsAuthorizingComputeFirewalls.equals(other.supportsAuthorizingComputeFirewalls))
			return false;
		if (supportsCloudStorageLogging == null) {
			if (other.supportsCloudStorageLogging != null)
				return false;
		} else if (!supportsCloudStorageLogging.equals(other.supportsCloudStorageLogging))
			return false;
		if (supportsClusterFirewalls == null) {
			if (other.supportsClusterFirewalls != null)
				return false;
		} else if (!supportsClusterFirewalls.equals(other.supportsClusterFirewalls))
			return false;
		if (supportsClusterSnapshots == null) {
			if (other.supportsClusterSnapshots != null)
				return false;
		} else if (!supportsClusterSnapshots.equals(other.supportsClusterSnapshots))
			return false;
		if (supportsEncryptionAtRest == null) {
			if (other.supportsEncryptionAtRest != null)
				return false;
		} else if (!supportsEncryptionAtRest.equals(other.supportsEncryptionAtRest))
			return false;
		if (supportsSnapshotSharing == null) {
			if (other.supportsSnapshotSharing != null)
				return false;
		} else if (!supportsSnapshotSharing.equals(other.supportsSnapshotSharing))
			return false;
		if (updateClusterTags == null) {
			if (other.updateClusterTags != null)
				return false;
		} else if (!updateClusterTags.equals(other.updateClusterTags))
			return false;
		if (updateParameters == null) {
			if (other.updateParameters != null)
				return false;
		} else if (!updateParameters.equals(other.updateParameters))
			return false;
		if (updateSnapshotTags == null) {
			if (other.updateSnapshotTags != null)
				return false;
		} else if (!updateSnapshotTags.equals(other.updateSnapshotTags))
			return false;
		return true;
	}

}
