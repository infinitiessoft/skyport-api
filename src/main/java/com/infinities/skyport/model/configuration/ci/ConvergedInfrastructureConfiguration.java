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
package com.infinities.skyport.model.configuration.ci;

import java.io.Serializable;

import com.infinities.skyport.model.FunctionConfiguration;

public class ConvergedInfrastructureConfiguration implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	private FunctionConfiguration getConvergedInfrastructure = new FunctionConfiguration();
	private FunctionConfiguration listConvergedInfrastructures = new FunctionConfiguration();
	private FunctionConfiguration listConvergedInfrastructureStatus = new FunctionConfiguration();
	private FunctionConfiguration listVirtualMachines = new FunctionConfiguration();
	private FunctionConfiguration listVLANs = new FunctionConfiguration();
	private FunctionConfiguration provision = new FunctionConfiguration();
	private FunctionConfiguration terminate = new FunctionConfiguration();
	private FunctionConfiguration updateTags = new FunctionConfiguration();
	private FunctionConfiguration removeTags = new FunctionConfiguration();


	public FunctionConfiguration getGetConvergedInfrastructure() {
		return getConvergedInfrastructure;
	}

	public void setGetConvergedInfrastructure(FunctionConfiguration getConvergedInfrastructure) {
		this.getConvergedInfrastructure = getConvergedInfrastructure;
	}

	public FunctionConfiguration getListConvergedInfrastructures() {
		return listConvergedInfrastructures;
	}

	public void setListConvergedInfrastructures(FunctionConfiguration listConvergedInfrastructures) {
		this.listConvergedInfrastructures = listConvergedInfrastructures;
	}

	public FunctionConfiguration getListConvergedInfrastructureStatus() {
		return listConvergedInfrastructureStatus;
	}

	public void setListConvergedInfrastructureStatus(FunctionConfiguration listConvergedInfrastructureStatus) {
		this.listConvergedInfrastructureStatus = listConvergedInfrastructureStatus;
	}

	public FunctionConfiguration getListVirtualMachines() {
		return listVirtualMachines;
	}

	public void setListVirtualMachines(FunctionConfiguration listVirtualMachines) {
		this.listVirtualMachines = listVirtualMachines;
	}

	public FunctionConfiguration getListVLANs() {
		return listVLANs;
	}

	public void setListVLANs(FunctionConfiguration listVLANs) {
		this.listVLANs = listVLANs;
	}

	public FunctionConfiguration getProvision() {
		return provision;
	}

	public void setProvision(FunctionConfiguration provision) {
		this.provision = provision;
	}

	public FunctionConfiguration getTerminate() {
		return terminate;
	}

	public void setTerminate(FunctionConfiguration terminate) {
		this.terminate = terminate;
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

	@Override
	public ConvergedInfrastructureConfiguration clone() {
		ConvergedInfrastructureConfiguration clone = new ConvergedInfrastructureConfiguration();
		clone.setGetConvergedInfrastructure(getGetConvergedInfrastructure().clone());
		clone.setListConvergedInfrastructures(getListConvergedInfrastructureStatus().clone());
		clone.setListConvergedInfrastructureStatus(getListConvergedInfrastructureStatus().clone());
		clone.setListVirtualMachines(getListVirtualMachines().clone());
		clone.setListVLANs(getListVLANs().clone());
		clone.setProvision(getProvision().clone());
		clone.setRemoveTags(getRemoveTags().clone());
		clone.setTerminate(getTerminate().clone());
		clone.setUpdateTags(getUpdateTags().clone());
		return clone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getConvergedInfrastructure == null) ? 0 : getConvergedInfrastructure.hashCode());
		result = prime * result
				+ ((listConvergedInfrastructureStatus == null) ? 0 : listConvergedInfrastructureStatus.hashCode());
		result = prime * result + ((listConvergedInfrastructures == null) ? 0 : listConvergedInfrastructures.hashCode());
		result = prime * result + ((listVLANs == null) ? 0 : listVLANs.hashCode());
		result = prime * result + ((listVirtualMachines == null) ? 0 : listVirtualMachines.hashCode());
		result = prime * result + ((provision == null) ? 0 : provision.hashCode());
		result = prime * result + ((removeTags == null) ? 0 : removeTags.hashCode());
		result = prime * result + ((terminate == null) ? 0 : terminate.hashCode());
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
		ConvergedInfrastructureConfiguration other = (ConvergedInfrastructureConfiguration) obj;
		if (getConvergedInfrastructure == null) {
			if (other.getConvergedInfrastructure != null)
				return false;
		} else if (!getConvergedInfrastructure.equals(other.getConvergedInfrastructure))
			return false;
		if (listConvergedInfrastructureStatus == null) {
			if (other.listConvergedInfrastructureStatus != null)
				return false;
		} else if (!listConvergedInfrastructureStatus.equals(other.listConvergedInfrastructureStatus))
			return false;
		if (listConvergedInfrastructures == null) {
			if (other.listConvergedInfrastructures != null)
				return false;
		} else if (!listConvergedInfrastructures.equals(other.listConvergedInfrastructures))
			return false;
		if (listVLANs == null) {
			if (other.listVLANs != null)
				return false;
		} else if (!listVLANs.equals(other.listVLANs))
			return false;
		if (listVirtualMachines == null) {
			if (other.listVirtualMachines != null)
				return false;
		} else if (!listVirtualMachines.equals(other.listVirtualMachines))
			return false;
		if (provision == null) {
			if (other.provision != null)
				return false;
		} else if (!provision.equals(other.provision))
			return false;
		if (removeTags == null) {
			if (other.removeTags != null)
				return false;
		} else if (!removeTags.equals(other.removeTags))
			return false;
		if (terminate == null) {
			if (other.terminate != null)
				return false;
		} else if (!terminate.equals(other.terminate))
			return false;
		if (updateTags == null) {
			if (other.updateTags != null)
				return false;
		} else if (!updateTags.equals(other.updateTags))
			return false;
		return true;
	}

}
