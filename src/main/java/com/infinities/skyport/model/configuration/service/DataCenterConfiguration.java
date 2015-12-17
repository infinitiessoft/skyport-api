package com.infinities.skyport.model.configuration.service;

import java.io.Serializable;

import com.infinities.skyport.model.FunctionConfiguration;

public class DataCenterConfiguration implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private FunctionConfiguration getDataCenter = new FunctionConfiguration();
	private FunctionConfiguration getRegion = new FunctionConfiguration();
	private FunctionConfiguration listDataCenters = new FunctionConfiguration();
	private FunctionConfiguration listRegions = new FunctionConfiguration();
	private FunctionConfiguration listResourcePools = new FunctionConfiguration();
	private FunctionConfiguration getResourcePool = new FunctionConfiguration();
	private FunctionConfiguration listStoragePools = new FunctionConfiguration();
	private FunctionConfiguration getStoragePool = new FunctionConfiguration();
	private FunctionConfiguration listVMFolders = new FunctionConfiguration();
	private FunctionConfiguration getVMFolder = new FunctionConfiguration();


	public FunctionConfiguration getGetDataCenter() {
		return getDataCenter;
	}

	public void setGetDataCenter(FunctionConfiguration getDataCenter) {
		this.getDataCenter = getDataCenter;
	}

	public FunctionConfiguration getGetRegion() {
		return getRegion;
	}

	public void setGetRegion(FunctionConfiguration getRegion) {
		this.getRegion = getRegion;
	}

	public FunctionConfiguration getListDataCenters() {
		return listDataCenters;
	}

	public void setListDataCenters(FunctionConfiguration listDataCenters) {
		this.listDataCenters = listDataCenters;
	}

	public FunctionConfiguration getListRegions() {
		return listRegions;
	}

	public void setListRegions(FunctionConfiguration listRegions) {
		this.listRegions = listRegions;
	}

	public FunctionConfiguration getListResourcePools() {
		return listResourcePools;
	}

	public void setListResourcePools(FunctionConfiguration listResourcePools) {
		this.listResourcePools = listResourcePools;
	}

	public FunctionConfiguration getGetResourcePool() {
		return getResourcePool;
	}

	public void setGetResourcePool(FunctionConfiguration getResourcePool) {
		this.getResourcePool = getResourcePool;
	}

	public FunctionConfiguration getListStoragePools() {
		return listStoragePools;
	}

	public void setListStoragePools(FunctionConfiguration listStoragePools) {
		this.listStoragePools = listStoragePools;
	}

	public FunctionConfiguration getGetStoragePool() {
		return getStoragePool;
	}

	public void setGetStoragePool(FunctionConfiguration getStoragePool) {
		this.getStoragePool = getStoragePool;
	}

	public FunctionConfiguration getListVMFolders() {
		return listVMFolders;
	}

	public void setListVMFolders(FunctionConfiguration listVMFolders) {
		this.listVMFolders = listVMFolders;
	}

	public FunctionConfiguration getGetVMFolder() {
		return getVMFolder;
	}

	public void setGetVMFolder(FunctionConfiguration getVMFolder) {
		this.getVMFolder = getVMFolder;
	}

	@Override
	public DataCenterConfiguration clone() {
		DataCenterConfiguration clone = new DataCenterConfiguration();
		clone.getDataCenter = getDataCenter.clone();
		clone.getRegion = getRegion.clone();
		clone.listDataCenters = listDataCenters.clone();
		clone.listRegions = listRegions.clone();
		clone.listResourcePools = listResourcePools.clone();
		clone.getResourcePool = getResourcePool.clone();
		clone.listStoragePools = listStoragePools.clone();
		clone.getStoragePool = getStoragePool.clone();
		clone.listVMFolders = listVMFolders.clone();
		clone.getVMFolder = getVMFolder.clone();
		return clone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getDataCenter == null) ? 0 : getDataCenter.hashCode());
		result = prime * result + ((getRegion == null) ? 0 : getRegion.hashCode());
		result = prime * result + ((getResourcePool == null) ? 0 : getResourcePool.hashCode());
		result = prime * result + ((getStoragePool == null) ? 0 : getStoragePool.hashCode());
		result = prime * result + ((getVMFolder == null) ? 0 : getVMFolder.hashCode());
		result = prime * result + ((listDataCenters == null) ? 0 : listDataCenters.hashCode());
		result = prime * result + ((listRegions == null) ? 0 : listRegions.hashCode());
		result = prime * result + ((listResourcePools == null) ? 0 : listResourcePools.hashCode());
		result = prime * result + ((listStoragePools == null) ? 0 : listStoragePools.hashCode());
		result = prime * result + ((listVMFolders == null) ? 0 : listVMFolders.hashCode());
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
		DataCenterConfiguration other = (DataCenterConfiguration) obj;
		if (getDataCenter == null) {
			if (other.getDataCenter != null)
				return false;
		} else if (!getDataCenter.equals(other.getDataCenter))
			return false;
		if (getRegion == null) {
			if (other.getRegion != null)
				return false;
		} else if (!getRegion.equals(other.getRegion))
			return false;
		if (getResourcePool == null) {
			if (other.getResourcePool != null)
				return false;
		} else if (!getResourcePool.equals(other.getResourcePool))
			return false;
		if (getStoragePool == null) {
			if (other.getStoragePool != null)
				return false;
		} else if (!getStoragePool.equals(other.getStoragePool))
			return false;
		if (getVMFolder == null) {
			if (other.getVMFolder != null)
				return false;
		} else if (!getVMFolder.equals(other.getVMFolder))
			return false;
		if (listDataCenters == null) {
			if (other.listDataCenters != null)
				return false;
		} else if (!listDataCenters.equals(other.listDataCenters))
			return false;
		if (listRegions == null) {
			if (other.listRegions != null)
				return false;
		} else if (!listRegions.equals(other.listRegions))
			return false;
		if (listResourcePools == null) {
			if (other.listResourcePools != null)
				return false;
		} else if (!listResourcePools.equals(other.listResourcePools))
			return false;
		if (listStoragePools == null) {
			if (other.listStoragePools != null)
				return false;
		} else if (!listStoragePools.equals(other.listStoragePools))
			return false;
		if (listVMFolders == null) {
			if (other.listVMFolders != null)
				return false;
		} else if (!listVMFolders.equals(other.listVMFolders))
			return false;
		return true;
	}

}
