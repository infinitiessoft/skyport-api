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

public class AutoScalingConfiguration implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private FunctionConfiguration createAutoScalingGroup = new FunctionConfiguration();
	private FunctionConfiguration updateAutoScalingGroup = new FunctionConfiguration();
	private FunctionConfiguration createLaunchConfiguration = new FunctionConfiguration();
	private FunctionConfiguration deleteAutoScalingGroup = new FunctionConfiguration();
	private FunctionConfiguration deleteLaunchConfiguration = new FunctionConfiguration();
	private FunctionConfiguration getLaunchConfiguration = new FunctionConfiguration();
	private FunctionConfiguration getScalingGroup = new FunctionConfiguration();
	private FunctionConfiguration suspendAutoScaling = new FunctionConfiguration();
	private FunctionConfiguration resumeAutoScaling = new FunctionConfiguration();
	private FunctionConfiguration updateScalingPolicy = new FunctionConfiguration();
	private FunctionConfiguration deleteScalingPolicy = new FunctionConfiguration();
	private FunctionConfiguration listScalingPolicies = new FunctionConfiguration();
	private FunctionConfiguration getScalingPolicy = new FunctionConfiguration();
	private FunctionConfiguration listScalingGroupStatus = new FunctionConfiguration();
	private FunctionConfiguration listScalingGroups = new FunctionConfiguration();
	private FunctionConfiguration listLaunchConfigurationStatus = new FunctionConfiguration();
	private FunctionConfiguration listLaunchConfigurations = new FunctionConfiguration();
	private FunctionConfiguration setDesiredCapacity = new FunctionConfiguration();
	private FunctionConfiguration setTrigger = new FunctionConfiguration();
	private FunctionConfiguration setNotificationConfig = new FunctionConfiguration();
	private FunctionConfiguration listNotificationConfigs = new FunctionConfiguration();
	private FunctionConfiguration updateTags = new FunctionConfiguration();
	private FunctionConfiguration removeTags = new FunctionConfiguration();
	private FunctionConfiguration setTags = new FunctionConfiguration();


	public FunctionConfiguration getCreateAutoScalingGroup() {
		return createAutoScalingGroup;
	}

	public void setCreateAutoScalingGroup(FunctionConfiguration createAutoScalingGroup) {
		this.createAutoScalingGroup = createAutoScalingGroup;
	}

	public FunctionConfiguration getUpdateAutoScalingGroup() {
		return updateAutoScalingGroup;
	}

	public void setUpdateAutoScalingGroup(FunctionConfiguration updateAutoScalingGroup) {
		this.updateAutoScalingGroup = updateAutoScalingGroup;
	}

	public FunctionConfiguration getCreateLaunchConfiguration() {
		return createLaunchConfiguration;
	}

	public void setCreateLaunchConfiguration(FunctionConfiguration createLaunchConfiguration) {
		this.createLaunchConfiguration = createLaunchConfiguration;
	}

	public FunctionConfiguration getDeleteAutoScalingGroup() {
		return deleteAutoScalingGroup;
	}

	public void setDeleteAutoScalingGroup(FunctionConfiguration deleteAutoScalingGroup) {
		this.deleteAutoScalingGroup = deleteAutoScalingGroup;
	}

	public FunctionConfiguration getDeleteLaunchConfiguration() {
		return deleteLaunchConfiguration;
	}

	public void setDeleteLaunchConfiguration(FunctionConfiguration deleteLaunchConfiguration) {
		this.deleteLaunchConfiguration = deleteLaunchConfiguration;
	}

	public FunctionConfiguration getGetLaunchConfiguration() {
		return getLaunchConfiguration;
	}

	public void setGetLaunchConfiguration(FunctionConfiguration getLaunchConfiguration) {
		this.getLaunchConfiguration = getLaunchConfiguration;
	}

	public FunctionConfiguration getGetScalingGroup() {
		return getScalingGroup;
	}

	public void setGetScalingGroup(FunctionConfiguration getScalingGroup) {
		this.getScalingGroup = getScalingGroup;
	}

	public FunctionConfiguration getSuspendAutoScaling() {
		return suspendAutoScaling;
	}

	public void setSuspendAutoScaling(FunctionConfiguration suspendAutoScaling) {
		this.suspendAutoScaling = suspendAutoScaling;
	}

	public FunctionConfiguration getResumeAutoScaling() {
		return resumeAutoScaling;
	}

	public void setResumeAutoScaling(FunctionConfiguration resumeAutoScaling) {
		this.resumeAutoScaling = resumeAutoScaling;
	}

	public FunctionConfiguration getUpdateScalingPolicy() {
		return updateScalingPolicy;
	}

	public void setUpdateScalingPolicy(FunctionConfiguration updateScalingPolicy) {
		this.updateScalingPolicy = updateScalingPolicy;
	}

	public FunctionConfiguration getDeleteScalingPolicy() {
		return deleteScalingPolicy;
	}

	public void setDeleteScalingPolicy(FunctionConfiguration deleteScalingPolicy) {
		this.deleteScalingPolicy = deleteScalingPolicy;
	}

	public FunctionConfiguration getListScalingPolicies() {
		return listScalingPolicies;
	}

	public void setListScalingPolicies(FunctionConfiguration listScalingPolicies) {
		this.listScalingPolicies = listScalingPolicies;
	}

	public FunctionConfiguration getGetScalingPolicy() {
		return getScalingPolicy;
	}

	public void setGetScalingPolicy(FunctionConfiguration getScalingPolicy) {
		this.getScalingPolicy = getScalingPolicy;
	}

	public FunctionConfiguration getListScalingGroupStatus() {
		return listScalingGroupStatus;
	}

	public void setListScalingGroupStatus(FunctionConfiguration listScalingGroupStatus) {
		this.listScalingGroupStatus = listScalingGroupStatus;
	}

	public FunctionConfiguration getListScalingGroups() {
		return listScalingGroups;
	}

	public void setListScalingGroups(FunctionConfiguration listScalingGroups) {
		this.listScalingGroups = listScalingGroups;
	}

	public FunctionConfiguration getListLaunchConfigurationStatus() {
		return listLaunchConfigurationStatus;
	}

	public void setListLaunchConfigurationStatus(FunctionConfiguration listLaunchConfigurationStatus) {
		this.listLaunchConfigurationStatus = listLaunchConfigurationStatus;
	}

	public FunctionConfiguration getListLaunchConfigurations() {
		return listLaunchConfigurations;
	}

	public void setListLaunchConfigurations(FunctionConfiguration listLaunchConfigurations) {
		this.listLaunchConfigurations = listLaunchConfigurations;
	}

	public FunctionConfiguration getSetDesiredCapacity() {
		return setDesiredCapacity;
	}

	public void setSetDesiredCapacity(FunctionConfiguration setDesiredCapacity) {
		this.setDesiredCapacity = setDesiredCapacity;
	}

	public FunctionConfiguration getSetTrigger() {
		return setTrigger;
	}

	public void setSetTrigger(FunctionConfiguration setTrigger) {
		this.setTrigger = setTrigger;
	}

	public FunctionConfiguration getSetNotificationConfig() {
		return setNotificationConfig;
	}

	public void setSetNotificationConfig(FunctionConfiguration setNotificationConfig) {
		this.setNotificationConfig = setNotificationConfig;
	}

	public FunctionConfiguration getListNotificationConfigs() {
		return listNotificationConfigs;
	}

	public void setListNotificationConfigs(FunctionConfiguration listNotificationConfigs) {
		this.listNotificationConfigs = listNotificationConfigs;
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

	public FunctionConfiguration getSetTags() {
		return setTags;
	}

	public void setSetTags(FunctionConfiguration setTags) {
		this.setTags = setTags;
	}

	@Override
	public AutoScalingConfiguration clone() {
		AutoScalingConfiguration clone = new AutoScalingConfiguration();
		clone.setCreateAutoScalingGroup(createAutoScalingGroup.clone());
		clone.setCreateLaunchConfiguration(createLaunchConfiguration.clone());
		clone.setDeleteAutoScalingGroup(deleteAutoScalingGroup.clone());
		clone.setDeleteLaunchConfiguration(deleteLaunchConfiguration.clone());
		clone.setDeleteScalingPolicy(deleteScalingPolicy.clone());
		clone.setGetLaunchConfiguration(getLaunchConfiguration.clone());
		clone.setGetScalingGroup(getScalingGroup.clone());
		clone.setGetScalingPolicy(getScalingPolicy.clone());
		clone.setListLaunchConfigurations(listLaunchConfigurationStatus.clone());
		clone.setListLaunchConfigurationStatus(listLaunchConfigurationStatus.clone());
		clone.setListNotificationConfigs(listNotificationConfigs.clone());
		clone.setListScalingGroups(listScalingGroupStatus.clone());
		clone.setListScalingGroupStatus(listScalingGroupStatus.clone());
		clone.setListScalingPolicies(listScalingPolicies.clone());
		clone.setRemoveTags(removeTags.clone());
		clone.setResumeAutoScaling(resumeAutoScaling.clone());
		clone.setSetDesiredCapacity(setDesiredCapacity.clone());
		clone.setSetNotificationConfig(setNotificationConfig.clone());
		clone.setSetTags(setTags.clone());
		clone.setSetTrigger(setTrigger.clone());
		clone.setSuspendAutoScaling(suspendAutoScaling.clone());
		clone.setUpdateAutoScalingGroup(updateAutoScalingGroup.clone());
		clone.setUpdateScalingPolicy(updateScalingPolicy.clone());
		clone.setUpdateTags(updateTags.clone());
		return clone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createAutoScalingGroup == null) ? 0 : createAutoScalingGroup.hashCode());
		result = prime * result + ((createLaunchConfiguration == null) ? 0 : createLaunchConfiguration.hashCode());
		result = prime * result + ((deleteAutoScalingGroup == null) ? 0 : deleteAutoScalingGroup.hashCode());
		result = prime * result + ((deleteLaunchConfiguration == null) ? 0 : deleteLaunchConfiguration.hashCode());
		result = prime * result + ((deleteScalingPolicy == null) ? 0 : deleteScalingPolicy.hashCode());
		result = prime * result + ((getLaunchConfiguration == null) ? 0 : getLaunchConfiguration.hashCode());
		result = prime * result + ((getScalingGroup == null) ? 0 : getScalingGroup.hashCode());
		result = prime * result + ((getScalingPolicy == null) ? 0 : getScalingPolicy.hashCode());
		result = prime * result + ((listLaunchConfigurationStatus == null) ? 0 : listLaunchConfigurationStatus.hashCode());
		result = prime * result + ((listLaunchConfigurations == null) ? 0 : listLaunchConfigurations.hashCode());
		result = prime * result + ((listNotificationConfigs == null) ? 0 : listNotificationConfigs.hashCode());
		result = prime * result + ((listScalingGroupStatus == null) ? 0 : listScalingGroupStatus.hashCode());
		result = prime * result + ((listScalingGroups == null) ? 0 : listScalingGroups.hashCode());
		result = prime * result + ((listScalingPolicies == null) ? 0 : listScalingPolicies.hashCode());
		result = prime * result + ((removeTags == null) ? 0 : removeTags.hashCode());
		result = prime * result + ((resumeAutoScaling == null) ? 0 : resumeAutoScaling.hashCode());
		result = prime * result + ((setDesiredCapacity == null) ? 0 : setDesiredCapacity.hashCode());
		result = prime * result + ((setNotificationConfig == null) ? 0 : setNotificationConfig.hashCode());
		result = prime * result + ((setTags == null) ? 0 : setTags.hashCode());
		result = prime * result + ((setTrigger == null) ? 0 : setTrigger.hashCode());
		result = prime * result + ((suspendAutoScaling == null) ? 0 : suspendAutoScaling.hashCode());
		result = prime * result + ((updateAutoScalingGroup == null) ? 0 : updateAutoScalingGroup.hashCode());
		result = prime * result + ((updateScalingPolicy == null) ? 0 : updateScalingPolicy.hashCode());
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
		AutoScalingConfiguration other = (AutoScalingConfiguration) obj;
		if (createAutoScalingGroup == null) {
			if (other.createAutoScalingGroup != null)
				return false;
		} else if (!createAutoScalingGroup.equals(other.createAutoScalingGroup))
			return false;
		if (createLaunchConfiguration == null) {
			if (other.createLaunchConfiguration != null)
				return false;
		} else if (!createLaunchConfiguration.equals(other.createLaunchConfiguration))
			return false;
		if (deleteAutoScalingGroup == null) {
			if (other.deleteAutoScalingGroup != null)
				return false;
		} else if (!deleteAutoScalingGroup.equals(other.deleteAutoScalingGroup))
			return false;
		if (deleteLaunchConfiguration == null) {
			if (other.deleteLaunchConfiguration != null)
				return false;
		} else if (!deleteLaunchConfiguration.equals(other.deleteLaunchConfiguration))
			return false;
		if (deleteScalingPolicy == null) {
			if (other.deleteScalingPolicy != null)
				return false;
		} else if (!deleteScalingPolicy.equals(other.deleteScalingPolicy))
			return false;
		if (getLaunchConfiguration == null) {
			if (other.getLaunchConfiguration != null)
				return false;
		} else if (!getLaunchConfiguration.equals(other.getLaunchConfiguration))
			return false;
		if (getScalingGroup == null) {
			if (other.getScalingGroup != null)
				return false;
		} else if (!getScalingGroup.equals(other.getScalingGroup))
			return false;
		if (getScalingPolicy == null) {
			if (other.getScalingPolicy != null)
				return false;
		} else if (!getScalingPolicy.equals(other.getScalingPolicy))
			return false;
		if (listLaunchConfigurationStatus == null) {
			if (other.listLaunchConfigurationStatus != null)
				return false;
		} else if (!listLaunchConfigurationStatus.equals(other.listLaunchConfigurationStatus))
			return false;
		if (listLaunchConfigurations == null) {
			if (other.listLaunchConfigurations != null)
				return false;
		} else if (!listLaunchConfigurations.equals(other.listLaunchConfigurations))
			return false;
		if (listNotificationConfigs == null) {
			if (other.listNotificationConfigs != null)
				return false;
		} else if (!listNotificationConfigs.equals(other.listNotificationConfigs))
			return false;
		if (listScalingGroupStatus == null) {
			if (other.listScalingGroupStatus != null)
				return false;
		} else if (!listScalingGroupStatus.equals(other.listScalingGroupStatus))
			return false;
		if (listScalingGroups == null) {
			if (other.listScalingGroups != null)
				return false;
		} else if (!listScalingGroups.equals(other.listScalingGroups))
			return false;
		if (listScalingPolicies == null) {
			if (other.listScalingPolicies != null)
				return false;
		} else if (!listScalingPolicies.equals(other.listScalingPolicies))
			return false;
		if (removeTags == null) {
			if (other.removeTags != null)
				return false;
		} else if (!removeTags.equals(other.removeTags))
			return false;
		if (resumeAutoScaling == null) {
			if (other.resumeAutoScaling != null)
				return false;
		} else if (!resumeAutoScaling.equals(other.resumeAutoScaling))
			return false;
		if (setDesiredCapacity == null) {
			if (other.setDesiredCapacity != null)
				return false;
		} else if (!setDesiredCapacity.equals(other.setDesiredCapacity))
			return false;
		if (setNotificationConfig == null) {
			if (other.setNotificationConfig != null)
				return false;
		} else if (!setNotificationConfig.equals(other.setNotificationConfig))
			return false;
		if (setTags == null) {
			if (other.setTags != null)
				return false;
		} else if (!setTags.equals(other.setTags))
			return false;
		if (setTrigger == null) {
			if (other.setTrigger != null)
				return false;
		} else if (!setTrigger.equals(other.setTrigger))
			return false;
		if (suspendAutoScaling == null) {
			if (other.suspendAutoScaling != null)
				return false;
		} else if (!suspendAutoScaling.equals(other.suspendAutoScaling))
			return false;
		if (updateAutoScalingGroup == null) {
			if (other.updateAutoScalingGroup != null)
				return false;
		} else if (!updateAutoScalingGroup.equals(other.updateAutoScalingGroup))
			return false;
		if (updateScalingPolicy == null) {
			if (other.updateScalingPolicy != null)
				return false;
		} else if (!updateScalingPolicy.equals(other.updateScalingPolicy))
			return false;
		if (updateTags == null) {
			if (other.updateTags != null)
				return false;
		} else if (!updateTags.equals(other.updateTags))
			return false;
		return true;
	}

}
