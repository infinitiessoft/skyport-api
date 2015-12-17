package com.infinities.skyport.model.configuration.ci;

import java.io.Serializable;

import com.infinities.skyport.model.FunctionConfiguration;

public class ConvergedHttpLoadBalancerConfiguration implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FunctionConfiguration getProviderTermForConvergedHttpLoadBalancer = new FunctionConfiguration();
	private FunctionConfiguration getConvergedHttpLoadBalancer = new FunctionConfiguration();
	private FunctionConfiguration listConvergedHttpLoadBalancers = new FunctionConfiguration();
	private FunctionConfiguration listConvergedHttpLoadBalancerStatus = new FunctionConfiguration();
	private FunctionConfiguration updateTags = new FunctionConfiguration();
	private FunctionConfiguration removeTags = new FunctionConfiguration();
	private FunctionConfiguration createConvergedHttpLoadBalancer = new FunctionConfiguration();
	private FunctionConfiguration removeConvergedHttpLoadBalancers = new FunctionConfiguration();


	public FunctionConfiguration getGetProviderTermForConvergedHttpLoadBalancer() {
		return getProviderTermForConvergedHttpLoadBalancer;
	}

	public void setGetProviderTermForConvergedHttpLoadBalancer(
			FunctionConfiguration getProviderTermForConvergedHttpLoadBalancer) {
		this.getProviderTermForConvergedHttpLoadBalancer = getProviderTermForConvergedHttpLoadBalancer;
	}

	public FunctionConfiguration getGetConvergedHttpLoadBalancer() {
		return getConvergedHttpLoadBalancer;
	}

	public void setGetConvergedHttpLoadBalancer(FunctionConfiguration getConvergedHttpLoadBalancer) {
		this.getConvergedHttpLoadBalancer = getConvergedHttpLoadBalancer;
	}

	public FunctionConfiguration getListConvergedHttpLoadBalancerStatus() {
		return listConvergedHttpLoadBalancerStatus;
	}

	public void setListConvergedHttpLoadBalancerStatus(FunctionConfiguration listConvergedHttpLoadBalancerStatus) {
		this.listConvergedHttpLoadBalancerStatus = listConvergedHttpLoadBalancerStatus;
	}

	public FunctionConfiguration getUpdateTags() {
		return updateTags;
	}

	public void setUpdateTags(FunctionConfiguration updateTags) {
		this.updateTags = updateTags;
	}

	public FunctionConfiguration getRemoveTags() {
		return removeTags;
	}

	public void setRemoveTags(FunctionConfiguration removeTags) {
		this.removeTags = removeTags;
	}

	public FunctionConfiguration getCreateConvergedHttpLoadBalancer() {
		return createConvergedHttpLoadBalancer;
	}

	public void setCreateConvergedHttpLoadBalancer(FunctionConfiguration createConvergedHttpLoadBalancer) {
		this.createConvergedHttpLoadBalancer = createConvergedHttpLoadBalancer;
	}

	public FunctionConfiguration getRemoveConvergedHttpLoadBalancers() {
		return removeConvergedHttpLoadBalancers;
	}

	public void setRemoveConvergedHttpLoadBalancers(FunctionConfiguration removeConvergedHttpLoadBalancers) {
		this.removeConvergedHttpLoadBalancers = removeConvergedHttpLoadBalancers;
	}

	public FunctionConfiguration getListConvergedHttpLoadBalancers() {
		return listConvergedHttpLoadBalancers;
	}

	public void setListConvergedHttpLoadBalancers(FunctionConfiguration listConvergedHttpLoadBalancers) {
		this.listConvergedHttpLoadBalancers = listConvergedHttpLoadBalancers;
	}

	@Override
	public ConvergedHttpLoadBalancerConfiguration clone() {
		ConvergedHttpLoadBalancerConfiguration clone = new ConvergedHttpLoadBalancerConfiguration();
		clone.setCreateConvergedHttpLoadBalancer(getCreateConvergedHttpLoadBalancer().clone());
		clone.setGetConvergedHttpLoadBalancer(getGetConvergedHttpLoadBalancer().clone());
		clone.setGetProviderTermForConvergedHttpLoadBalancer(getGetProviderTermForConvergedHttpLoadBalancer().clone());
		clone.setListConvergedHttpLoadBalancerStatus(getListConvergedHttpLoadBalancerStatus().clone());
		clone.setRemoveConvergedHttpLoadBalancers(getRemoveConvergedHttpLoadBalancers().clone());
		clone.setRemoveTags(getRemoveTags().clone());
		clone.setUpdateTags(getUpdateTags().clone());
		clone.setListConvergedHttpLoadBalancers(getListConvergedHttpLoadBalancers().clone());
		return clone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((createConvergedHttpLoadBalancer == null) ? 0 : createConvergedHttpLoadBalancer.hashCode());
		result = prime * result + ((getConvergedHttpLoadBalancer == null) ? 0 : getConvergedHttpLoadBalancer.hashCode());
		result = prime
				* result
				+ ((getProviderTermForConvergedHttpLoadBalancer == null) ? 0 : getProviderTermForConvergedHttpLoadBalancer
						.hashCode());
		result = prime * result
				+ ((listConvergedHttpLoadBalancerStatus == null) ? 0 : listConvergedHttpLoadBalancerStatus.hashCode());
		result = prime * result
				+ ((removeConvergedHttpLoadBalancers == null) ? 0 : removeConvergedHttpLoadBalancers.hashCode());
		result = prime * result + ((listConvergedHttpLoadBalancers == null) ? 0 : listConvergedHttpLoadBalancers.hashCode());
		result = prime * result + ((removeTags == null) ? 0 : removeTags.hashCode());
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
		ConvergedHttpLoadBalancerConfiguration other = (ConvergedHttpLoadBalancerConfiguration) obj;
		if (createConvergedHttpLoadBalancer == null) {
			if (other.createConvergedHttpLoadBalancer != null)
				return false;
		} else if (!createConvergedHttpLoadBalancer.equals(other.createConvergedHttpLoadBalancer))
			return false;
		if (getConvergedHttpLoadBalancer == null) {
			if (other.getConvergedHttpLoadBalancer != null)
				return false;
		} else if (!getConvergedHttpLoadBalancer.equals(other.getConvergedHttpLoadBalancer))
			return false;
		if (getProviderTermForConvergedHttpLoadBalancer == null) {
			if (other.getProviderTermForConvergedHttpLoadBalancer != null)
				return false;
		} else if (!getProviderTermForConvergedHttpLoadBalancer.equals(other.getProviderTermForConvergedHttpLoadBalancer))
			return false;
		if (listConvergedHttpLoadBalancerStatus == null) {
			if (other.listConvergedHttpLoadBalancerStatus != null)
				return false;
		} else if (!listConvergedHttpLoadBalancerStatus.equals(other.listConvergedHttpLoadBalancerStatus))
			return false;
		if (removeConvergedHttpLoadBalancers == null) {
			if (other.removeConvergedHttpLoadBalancers != null)
				return false;
		} else if (!removeConvergedHttpLoadBalancers.equals(other.removeConvergedHttpLoadBalancers))
			return false;
		if (removeTags == null) {
			if (other.removeTags != null)
				return false;
		} else if (!removeTags.equals(other.removeTags))
			return false;
		if (updateTags == null) {
			if (other.updateTags != null)
				return false;
		} else if (!updateTags.equals(other.updateTags))
			return false;
		if (listConvergedHttpLoadBalancers == null) {
			if (other.listConvergedHttpLoadBalancers != null)
				return false;
		} else if (!listConvergedHttpLoadBalancers.equals(other.listConvergedHttpLoadBalancers))
			return false;
		return true;
	}

}
