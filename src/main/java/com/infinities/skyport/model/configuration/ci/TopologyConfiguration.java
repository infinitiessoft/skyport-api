package com.infinities.skyport.model.configuration.ci;

import java.io.Serializable;

import com.infinities.skyport.model.FunctionConfiguration;

public class TopologyConfiguration implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FunctionConfiguration getProviderTermForTopology = new FunctionConfiguration();
	private FunctionConfiguration getTopology = new FunctionConfiguration();
	private FunctionConfiguration listTopologies = new FunctionConfiguration();
	private FunctionConfiguration listTopologyStatus = new FunctionConfiguration();
	private FunctionConfiguration searchPublicTopologies = new FunctionConfiguration();
	private FunctionConfiguration supportsPublicLibrary = new FunctionConfiguration();
	private FunctionConfiguration updateTags = new FunctionConfiguration();
	private FunctionConfiguration removeTags = new FunctionConfiguration();
	private FunctionConfiguration createTopology = new FunctionConfiguration();
	private FunctionConfiguration removeTopologies = new FunctionConfiguration();


	public FunctionConfiguration getGetProviderTermForTopology() {
		return getProviderTermForTopology;
	}

	public void setGetProviderTermForTopology(FunctionConfiguration getProviderTermForTopology) {
		this.getProviderTermForTopology = getProviderTermForTopology;
	}

	public FunctionConfiguration getGetTopology() {
		return getTopology;
	}

	public void setGetTopology(FunctionConfiguration getTopology) {
		this.getTopology = getTopology;
	}

	public FunctionConfiguration getListTopologies() {
		return listTopologies;
	}

	public void setListTopologies(FunctionConfiguration listTopologies) {
		this.listTopologies = listTopologies;
	}

	public FunctionConfiguration getListTopologyStatus() {
		return listTopologyStatus;
	}

	public void setListTopologyStatus(FunctionConfiguration listTopologyStatus) {
		this.listTopologyStatus = listTopologyStatus;
	}

	public FunctionConfiguration getSearchPublicTopologies() {
		return searchPublicTopologies;
	}

	public void setSearchPublicTopologies(FunctionConfiguration searchPublicTopologies) {
		this.searchPublicTopologies = searchPublicTopologies;
	}

	public FunctionConfiguration getSupportsPublicLibrary() {
		return supportsPublicLibrary;
	}

	public void setSupportsPublicLibrary(FunctionConfiguration supportsPublicLibrary) {
		this.supportsPublicLibrary = supportsPublicLibrary;
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

	public FunctionConfiguration getCreateTopology() {
		return createTopology;
	}

	public void setCreateTopology(FunctionConfiguration createTopology) {
		this.createTopology = createTopology;
	}

	public FunctionConfiguration getRemoveTopologies() {
		return removeTopologies;
	}

	public void setRemoveTopologies(FunctionConfiguration removeTopologies) {
		this.removeTopologies = removeTopologies;
	}

	@Override
	public TopologyConfiguration clone() {
		TopologyConfiguration clone = new TopologyConfiguration();
		clone.setCreateTopology(getCreateTopology().clone());
		clone.setGetProviderTermForTopology(getGetProviderTermForTopology().clone());
		clone.setGetTopology(getGetTopology().clone());
		clone.setListTopologies(getListTopologies().clone());
		clone.setRemoveTags(getRemoveTags().clone());
		clone.setRemoveTopologies(getRemoveTopologies().clone());
		clone.setSearchPublicTopologies(getSearchPublicTopologies().clone());
		clone.setSupportsPublicLibrary(getSupportsPublicLibrary().clone());
		clone.setUpdateTags(getUpdateTags().clone());
		return clone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createTopology == null) ? 0 : createTopology.hashCode());
		result = prime * result + ((getProviderTermForTopology == null) ? 0 : getProviderTermForTopology.hashCode());
		result = prime * result + ((getTopology == null) ? 0 : getTopology.hashCode());
		result = prime * result + ((listTopologies == null) ? 0 : listTopologies.hashCode());
		result = prime * result + ((listTopologyStatus == null) ? 0 : listTopologyStatus.hashCode());
		result = prime * result + ((removeTags == null) ? 0 : removeTags.hashCode());
		result = prime * result + ((removeTopologies == null) ? 0 : removeTopologies.hashCode());
		result = prime * result + ((searchPublicTopologies == null) ? 0 : searchPublicTopologies.hashCode());
		result = prime * result + ((supportsPublicLibrary == null) ? 0 : supportsPublicLibrary.hashCode());
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
		TopologyConfiguration other = (TopologyConfiguration) obj;
		if (createTopology == null) {
			if (other.createTopology != null)
				return false;
		} else if (!createTopology.equals(other.createTopology))
			return false;
		if (getProviderTermForTopology == null) {
			if (other.getProviderTermForTopology != null)
				return false;
		} else if (!getProviderTermForTopology.equals(other.getProviderTermForTopology))
			return false;
		if (getTopology == null) {
			if (other.getTopology != null)
				return false;
		} else if (!getTopology.equals(other.getTopology))
			return false;
		if (listTopologies == null) {
			if (other.listTopologies != null)
				return false;
		} else if (!listTopologies.equals(other.listTopologies))
			return false;
		if (listTopologyStatus == null) {
			if (other.listTopologyStatus != null)
				return false;
		} else if (!listTopologyStatus.equals(other.listTopologyStatus))
			return false;
		if (removeTags == null) {
			if (other.removeTags != null)
				return false;
		} else if (!removeTags.equals(other.removeTags))
			return false;
		if (removeTopologies == null) {
			if (other.removeTopologies != null)
				return false;
		} else if (!removeTopologies.equals(other.removeTopologies))
			return false;
		if (searchPublicTopologies == null) {
			if (other.searchPublicTopologies != null)
				return false;
		} else if (!searchPublicTopologies.equals(other.searchPublicTopologies))
			return false;
		if (supportsPublicLibrary == null) {
			if (other.supportsPublicLibrary != null)
				return false;
		} else if (!supportsPublicLibrary.equals(other.supportsPublicLibrary))
			return false;
		if (updateTags == null) {
			if (other.updateTags != null)
				return false;
		} else if (!updateTags.equals(other.updateTags))
			return false;
		return true;
	}

}
