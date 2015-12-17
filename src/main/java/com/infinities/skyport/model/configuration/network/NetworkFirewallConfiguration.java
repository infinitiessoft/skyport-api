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

public class NetworkFirewallConfiguration implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	private FunctionConfiguration associateWithSubnet = new FunctionConfiguration();
	private FunctionConfiguration authorize = new FunctionConfiguration();
	private FunctionConfiguration createFirewall = new FunctionConfiguration();
	private FunctionConfiguration getActiveConstraintsForFirewall = new FunctionConfiguration();
	private FunctionConfiguration getFirewall = new FunctionConfiguration();
	private FunctionConfiguration listFirewallStatus = new FunctionConfiguration();
	private FunctionConfiguration listFirewalls = new FunctionConfiguration();
	private FunctionConfiguration listRules = new FunctionConfiguration();
	private FunctionConfiguration removeFirewall = new FunctionConfiguration();
	private FunctionConfiguration removeTags = new FunctionConfiguration();
	private FunctionConfiguration revoke = new FunctionConfiguration();
	private FunctionConfiguration updateTags = new FunctionConfiguration();
	private FunctionConfiguration setTags = new FunctionConfiguration();


	public FunctionConfiguration getAssociateWithSubnet() {
		return associateWithSubnet;
	}

	public void setAssociateWithSubnet(FunctionConfiguration associateWithSubnet) {
		this.associateWithSubnet = associateWithSubnet;
	}

	public FunctionConfiguration getAuthorize() {
		return authorize;
	}

	public void setAuthorize(FunctionConfiguration authorize) {
		this.authorize = authorize;
	}

	public FunctionConfiguration getCreateFirewall() {
		return createFirewall;
	}

	public void setCreateFirewall(FunctionConfiguration createFirewall) {
		this.createFirewall = createFirewall;
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

	public FunctionConfiguration getListFirewallStatus() {
		return listFirewallStatus;
	}

	public void setListFirewallStatus(FunctionConfiguration listFirewallStatus) {
		this.listFirewallStatus = listFirewallStatus;
	}

	public FunctionConfiguration getListFirewalls() {
		return listFirewalls;
	}

	public void setListFirewalls(FunctionConfiguration listFirewalls) {
		this.listFirewalls = listFirewalls;
	}

	public FunctionConfiguration getListRules() {
		return listRules;
	}

	public void setListRules(FunctionConfiguration listRules) {
		this.listRules = listRules;
	}

	public FunctionConfiguration getRemoveFirewall() {
		return removeFirewall;
	}

	public void setRemoveFirewall(FunctionConfiguration removeFirewall) {
		this.removeFirewall = removeFirewall;
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
	public NetworkFirewallConfiguration clone() {
		NetworkFirewallConfiguration clone = new NetworkFirewallConfiguration();
		clone.associateWithSubnet = associateWithSubnet.clone();
		clone.authorize = authorize.clone();
		clone.createFirewall = createFirewall.clone();
		clone.getActiveConstraintsForFirewall = getActiveConstraintsForFirewall.clone();
		clone.getFirewall = getFirewall.clone();
		clone.listFirewallStatus = listFirewallStatus.clone();
		clone.listFirewalls = listFirewalls.clone();
		clone.listRules = listRules.clone();
		clone.removeFirewall = removeFirewall.clone();
		clone.removeTags = removeTags.clone();
		clone.revoke = revoke.clone();
		clone.updateTags = updateTags.clone();
		clone.setTags = setTags.clone();
		return clone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((associateWithSubnet == null) ? 0 : associateWithSubnet.hashCode());
		result = prime * result + ((authorize == null) ? 0 : authorize.hashCode());
		result = prime * result + ((createFirewall == null) ? 0 : createFirewall.hashCode());
		result = prime * result
				+ ((getActiveConstraintsForFirewall == null) ? 0 : getActiveConstraintsForFirewall.hashCode());
		result = prime * result + ((getFirewall == null) ? 0 : getFirewall.hashCode());
		result = prime * result + ((listFirewallStatus == null) ? 0 : listFirewallStatus.hashCode());
		result = prime * result + ((listFirewalls == null) ? 0 : listFirewalls.hashCode());
		result = prime * result + ((listRules == null) ? 0 : listRules.hashCode());
		result = prime * result + ((removeFirewall == null) ? 0 : removeFirewall.hashCode());
		result = prime * result + ((removeTags == null) ? 0 : removeTags.hashCode());
		result = prime * result + ((revoke == null) ? 0 : revoke.hashCode());
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
		NetworkFirewallConfiguration other = (NetworkFirewallConfiguration) obj;
		if (associateWithSubnet == null) {
			if (other.associateWithSubnet != null)
				return false;
		} else if (!associateWithSubnet.equals(other.associateWithSubnet))
			return false;
		if (authorize == null) {
			if (other.authorize != null)
				return false;
		} else if (!authorize.equals(other.authorize))
			return false;
		if (createFirewall == null) {
			if (other.createFirewall != null)
				return false;
		} else if (!createFirewall.equals(other.createFirewall))
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
		if (listFirewallStatus == null) {
			if (other.listFirewallStatus != null)
				return false;
		} else if (!listFirewallStatus.equals(other.listFirewallStatus))
			return false;
		if (listFirewalls == null) {
			if (other.listFirewalls != null)
				return false;
		} else if (!listFirewalls.equals(other.listFirewalls))
			return false;
		if (listRules == null) {
			if (other.listRules != null)
				return false;
		} else if (!listRules.equals(other.listRules))
			return false;
		if (removeFirewall == null) {
			if (other.removeFirewall != null)
				return false;
		} else if (!removeFirewall.equals(other.removeFirewall))
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
