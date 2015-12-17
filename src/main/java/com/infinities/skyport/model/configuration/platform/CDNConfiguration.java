package com.infinities.skyport.model.configuration.platform;

import java.io.Serializable;

import com.infinities.skyport.model.FunctionConfiguration;

public class CDNConfiguration implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	private FunctionConfiguration create = new FunctionConfiguration();
	private FunctionConfiguration delete = new FunctionConfiguration();
	private FunctionConfiguration getDistribution = new FunctionConfiguration();
	private FunctionConfiguration list = new FunctionConfiguration();
	private FunctionConfiguration listDistributionStatus = new FunctionConfiguration();
	private FunctionConfiguration update = new FunctionConfiguration();


	public FunctionConfiguration getCreate() {
		return create;
	}

	public void setCreate(FunctionConfiguration create) {
		this.create = create;
	}

	public FunctionConfiguration getDelete() {
		return delete;
	}

	public void setDelete(FunctionConfiguration delete) {
		this.delete = delete;
	}

	public FunctionConfiguration getGetDistribution() {
		return getDistribution;
	}

	public void setGetDistribution(FunctionConfiguration getDistribution) {
		this.getDistribution = getDistribution;
	}

	public FunctionConfiguration getList() {
		return list;
	}

	public void setList(FunctionConfiguration list) {
		this.list = list;
	}

	public FunctionConfiguration getListDistributionStatus() {
		return listDistributionStatus;
	}

	public void setListDistributionStatus(FunctionConfiguration listDistributionStatus) {
		this.listDistributionStatus = listDistributionStatus;
	}

	public FunctionConfiguration getUpdate() {
		return update;
	}

	public void setUpdate(FunctionConfiguration update) {
		this.update = update;
	}

	@Override
	public CDNConfiguration clone() {
		CDNConfiguration clone = new CDNConfiguration();
		clone.create = create.clone();
		clone.delete = delete.clone();
		clone.getDistribution = getDistribution.clone();
		clone.list = list.clone();
		clone.listDistributionStatus = listDistributionStatus.clone();
		clone.update = update.clone();
		return clone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((create == null) ? 0 : create.hashCode());
		result = prime * result + ((delete == null) ? 0 : delete.hashCode());
		result = prime * result + ((getDistribution == null) ? 0 : getDistribution.hashCode());
		result = prime * result + ((list == null) ? 0 : list.hashCode());
		result = prime * result + ((listDistributionStatus == null) ? 0 : listDistributionStatus.hashCode());
		result = prime * result + ((update == null) ? 0 : update.hashCode());
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
		CDNConfiguration other = (CDNConfiguration) obj;
		if (create == null) {
			if (other.create != null)
				return false;
		} else if (!create.equals(other.create))
			return false;
		if (delete == null) {
			if (other.delete != null)
				return false;
		} else if (!delete.equals(other.delete))
			return false;
		if (getDistribution == null) {
			if (other.getDistribution != null)
				return false;
		} else if (!getDistribution.equals(other.getDistribution))
			return false;
		if (list == null) {
			if (other.list != null)
				return false;
		} else if (!list.equals(other.list))
			return false;
		if (listDistributionStatus == null) {
			if (other.listDistributionStatus != null)
				return false;
		} else if (!listDistributionStatus.equals(other.listDistributionStatus))
			return false;
		if (update == null) {
			if (other.update != null)
				return false;
		} else if (!update.equals(other.update))
			return false;
		return true;
	}

}
