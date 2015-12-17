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
package com.infinities.skyport.model.configuration.network;

import java.io.Serializable;

import com.infinities.skyport.model.FunctionConfiguration;

public class FirewallConfiguration implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	private FunctionConfiguration authorize = new FunctionConfiguration();
	private FunctionConfiguration create = new FunctionConfiguration();
	private FunctionConfiguration createInVLAN = new FunctionConfiguration();
	private FunctionConfiguration delete = new FunctionConfiguration();
	private FunctionConfiguration getActiveConstraintsForFirewall = new FunctionConfiguration();
	private FunctionConfiguration getFirewall = new FunctionConfiguration();
	private FunctionConfiguration getRules = new FunctionConfiguration();
	private FunctionConfiguration list = new FunctionConfiguration();
	private FunctionConfiguration listFirewallStatus = new FunctionConfiguration();
	private FunctionConfiguration removeTags = new FunctionConfiguration();
	private FunctionConfiguration revoke = new FunctionConfiguration();
	private FunctionConfiguration requiresRulesOnCreation = new FunctionConfiguration();
	private FunctionConfiguration supportsFirewallDeletion = new FunctionConfiguration();
	private FunctionConfiguration supportsFirewallSources = new FunctionConfiguration();
	private FunctionConfiguration updateTags = new FunctionConfiguration();
	private FunctionConfiguration setTags = new FunctionConfiguration();


	public FunctionConfiguration getAuthorize() {
		return authorize;
	}

	public void setAuthorize(FunctionConfiguration authorize) {
		this.authorize = authorize;
	}

	public FunctionConfiguration getCreate() {
		return create;
	}

	public void setCreate(FunctionConfiguration create) {
		this.create = create;
	}

	public FunctionConfiguration getCreateInVLAN() {
		return createInVLAN;
	}

	public void setCreateInVLAN(FunctionConfiguration createInVLAN) {
		this.createInVLAN = createInVLAN;
	}

	public FunctionConfiguration getDelete() {
		return delete;
	}

	public void setDelete(FunctionConfiguration delete) {
		this.delete = delete;
	}

	public FunctionConfiguration getGetActiveConstraintsForFirewall() {
		return getActiveConstraintsForFirewall;
	}

	public void setGetActiveConstraintsForFirewall(FunctionConfiguration getActiveConstraintsForFirewall) {
		this.getActiveConstraintsForFirewall = getActiveConstraintsForFirewall;
	}

	public FunctionConfiguration getGetFirewall() {
		return getFirewall;
	}

	public void setGetFirewall(FunctionConfiguration getFirewall) {
		this.getFirewall = getFirewall;
	}

	public FunctionConfiguration getGetRules() {
		return getRules;
	}

	public void setGetRules(FunctionConfiguration getRules) {
		this.getRules = getRules;
	}

	public FunctionConfiguration getList() {
		return list;
	}

	public void setList(FunctionConfiguration list) {
		this.list = list;
	}

	public FunctionConfiguration getListFirewallStatus() {
		return listFirewallStatus;
	}

	public void setListFirewallStatus(FunctionConfiguration listFirewallStatus) {
		this.listFirewallStatus = listFirewallStatus;
	}

	public FunctionConfiguration getRemoveTags() {
		return removeTags;
	}

	public void setRemoveTags(FunctionConfiguration removeTags) {
		this.removeTags = removeTags;
	}

	public FunctionConfiguration getRevoke() {
		return revoke;
	}

	public void setRevoke(FunctionConfiguration revoke) {
		this.revoke = revoke;
	}

	public FunctionConfiguration getRequiresRulesOnCreation() {
		return requiresRulesOnCreation;
	}

	public void setRequiresRulesOnCreation(FunctionConfiguration requiresRulesOnCreation) {
		this.requiresRulesOnCreation = requiresRulesOnCreation;
	}

	public FunctionConfiguration getSupportsFirewallDeletion() {
		return supportsFirewallDeletion;
	}

	public void setSupportsFirewallDeletion(FunctionConfiguration supportsFirewallDeletion) {
		this.supportsFirewallDeletion = supportsFirewallDeletion;
	}

	public FunctionConfiguration getSupportsFirewallSources() {
		return supportsFirewallSources;
	}

	public void setSupportsFirewallSources(FunctionConfiguration supportsFirewallSources) {
		this.supportsFirewallSources = supportsFirewallSources;
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
	public FirewallConfiguration clone() {
		FirewallConfiguration clone = new FirewallConfiguration();
		clone.authorize = authorize.clone();
		clone.create = create.clone();
		clone.createInVLAN = createInVLAN.clone();
		clone.delete = delete.clone();
		clone.getActiveConstraintsForFirewall = getActiveConstraintsForFirewall.clone();
		clone.getFirewall = getFirewall.clone();
		clone.getRules = getRules.clone();
		clone.list = list.clone();
		clone.listFirewallStatus = listFirewallStatus.clone();
		clone.removeTags = removeTags.clone();
		clone.revoke = revoke.clone();
		clone.requiresRulesOnCreation = requiresRulesOnCreation.clone();
		clone.supportsFirewallDeletion = supportsFirewallDeletion.clone();
		clone.supportsFirewallSources = supportsFirewallSources.clone();
		clone.updateTags = updateTags.clone();
		clone.setTags = setTags.clone();
		return clone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authorize == null) ? 0 : authorize.hashCode());
		result = prime * result + ((create == null) ? 0 : create.hashCode());
		result = prime * result + ((createInVLAN == null) ? 0 : createInVLAN.hashCode());
		result = prime * result + ((delete == null) ? 0 : delete.hashCode());
		result = prime * result
				+ ((getActiveConstraintsForFirewall == null) ? 0 : getActiveConstraintsForFirewall.hashCode());
		result = prime * result + ((getFirewall == null) ? 0 : getFirewall.hashCode());
		result = prime * result + ((getRules == null) ? 0 : getRules.hashCode());
		result = prime * result + ((list == null) ? 0 : list.hashCode());
		result = prime * result + ((listFirewallStatus == null) ? 0 : listFirewallStatus.hashCode());
		result = prime * result + ((removeTags == null) ? 0 : removeTags.hashCode());
		result = prime * result + ((revoke == null) ? 0 : revoke.hashCode());
		result = prime * result + ((requiresRulesOnCreation == null) ? 0 : requiresRulesOnCreation.hashCode());
		result = prime * result + ((supportsFirewallDeletion == null) ? 0 : supportsFirewallDeletion.hashCode());
		result = prime * result + ((supportsFirewallSources == null) ? 0 : supportsFirewallSources.hashCode());
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
		FirewallConfiguration other = (FirewallConfiguration) obj;
		if (authorize == null) {
			if (other.authorize != null)
				return false;
		} else if (!authorize.equals(other.authorize))
			return false;
		if (create == null) {
			if (other.create != null)
				return false;
		} else if (!create.equals(other.create))
			return false;
		if (createInVLAN == null) {
			if (other.createInVLAN != null)
				return false;
		} else if (!createInVLAN.equals(other.createInVLAN))
			return false;
		if (delete == null) {
			if (other.delete != null)
				return false;
		} else if (!delete.equals(other.delete))
			return false;
		if (getActiveConstraintsForFirewall == null) {
			if (other.getActiveConstraintsForFirewall != null)
				return false;
		} else if (!getActiveConstraintsForFirewall.equals(other.getActiveConstraintsForFirewall))
			return false;
		if (getFirewall == null) {
			if (other.getFirewall != null)
				return false;
		} else if (!getFirewall.equals(other.getFirewall))
			return false;
		if (getRules == null) {
			if (other.getRules != null)
				return false;
		} else if (!getRules.equals(other.getRules))
			return false;
		if (list == null) {
			if (other.list != null)
				return false;
		} else if (!list.equals(other.list))
			return false;
		if (listFirewallStatus == null) {
			if (other.listFirewallStatus != null)
				return false;
		} else if (!listFirewallStatus.equals(other.listFirewallStatus))
			return false;
		if (removeTags == null) {
			if (other.removeTags != null)
				return false;
		} else if (!removeTags.equals(other.removeTags))
			return false;
		if (revoke == null) {
			if (other.revoke != null)
				return false;
		} else if (!revoke.equals(other.revoke))
			return false;
		if (requiresRulesOnCreation == null) {
			if (other.requiresRulesOnCreation != null)
				return false;
		} else if (!requiresRulesOnCreation.equals(other.requiresRulesOnCreation))
			return false;
		if (supportsFirewallDeletion == null) {
			if (other.supportsFirewallDeletion != null)
				return false;
		} else if (!supportsFirewallDeletion.equals(other.supportsFirewallDeletion))
			return false;
		if (supportsFirewallSources == null) {
			if (other.supportsFirewallSources != null)
				return false;
		} else if (!supportsFirewallSources.equals(other.supportsFirewallSources))
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
