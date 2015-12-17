package com.infinities.skyport.model.configuration.identity;

import java.io.Serializable;

import com.infinities.skyport.model.FunctionConfiguration;

public class IdentityAndAccessConfiguration implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	private FunctionConfiguration addUserToGroups = new FunctionConfiguration();
	private FunctionConfiguration createGroup = new FunctionConfiguration();
	private FunctionConfiguration createUser = new FunctionConfiguration();
	private FunctionConfiguration createAccessKey = new FunctionConfiguration();
	private FunctionConfiguration enableConsoleAccess = new FunctionConfiguration();
	private FunctionConfiguration updateConsoleAccess = new FunctionConfiguration();
	private FunctionConfiguration getConsoleUrl = new FunctionConfiguration();
	private FunctionConfiguration getGroup = new FunctionConfiguration();
	private FunctionConfiguration getPolicy = new FunctionConfiguration();
	private FunctionConfiguration getPolicyRules = new FunctionConfiguration();
	private FunctionConfiguration getUser = new FunctionConfiguration();
	private FunctionConfiguration listAccessKeys = new FunctionConfiguration();
	private FunctionConfiguration listGroups = new FunctionConfiguration();
	private FunctionConfiguration listGroupsForUser = new FunctionConfiguration();
	private FunctionConfiguration listPolicies = new FunctionConfiguration();
	private FunctionConfiguration listUsersInGroup = new FunctionConfiguration();
	private FunctionConfiguration listUsersInPath = new FunctionConfiguration();
	private FunctionConfiguration listUsersForPolicy = new FunctionConfiguration();
	private FunctionConfiguration listGroupsForPolicy = new FunctionConfiguration();
	private FunctionConfiguration removeAccessKey = new FunctionConfiguration();
	private FunctionConfiguration removeConsoleAccess = new FunctionConfiguration();
	private FunctionConfiguration removeGroup = new FunctionConfiguration();
	private FunctionConfiguration removeUser = new FunctionConfiguration();
	private FunctionConfiguration removeUserFromGroup = new FunctionConfiguration();
	private FunctionConfiguration modifyGroup = new FunctionConfiguration();
	private FunctionConfiguration createPolicy = new FunctionConfiguration();
	private FunctionConfiguration modifyPolicy = new FunctionConfiguration();
	private FunctionConfiguration removePolicy = new FunctionConfiguration();
	private FunctionConfiguration attachPolicyToUser = new FunctionConfiguration();
	private FunctionConfiguration detachPolicyFromUser = new FunctionConfiguration();
	private FunctionConfiguration attachPolicyToGroup = new FunctionConfiguration();
	private FunctionConfiguration detachPolicyFromGroup = new FunctionConfiguration();
	private FunctionConfiguration enableAccessKey = new FunctionConfiguration();
	private FunctionConfiguration disableAccessKey = new FunctionConfiguration();
	private FunctionConfiguration modifyUser = new FunctionConfiguration();
	private FunctionConfiguration listServices = new FunctionConfiguration();
	private FunctionConfiguration listServiceActions = new FunctionConfiguration();


	public FunctionConfiguration getAddUserToGroups() {
		return addUserToGroups;
	}

	public void setAddUserToGroups(FunctionConfiguration addUserToGroups) {
		this.addUserToGroups = addUserToGroups;
	}

	public FunctionConfiguration getCreateGroup() {
		return createGroup;
	}

	public void setCreateGroup(FunctionConfiguration createGroup) {
		this.createGroup = createGroup;
	}

	public FunctionConfiguration getCreateUser() {
		return createUser;
	}

	public void setCreateUser(FunctionConfiguration createUser) {
		this.createUser = createUser;
	}

	public FunctionConfiguration getCreateAccessKey() {
		return createAccessKey;
	}

	public void setCreateAccessKey(FunctionConfiguration createAccessKey) {
		this.createAccessKey = createAccessKey;
	}

	public FunctionConfiguration getEnableConsoleAccess() {
		return enableConsoleAccess;
	}

	public void setEnableConsoleAccess(FunctionConfiguration enableConsoleAccess) {
		this.enableConsoleAccess = enableConsoleAccess;
	}

	public FunctionConfiguration getUpdateConsoleAccess() {
		return updateConsoleAccess;
	}

	public void setUpdateConsoleAccess(FunctionConfiguration updateConsoleAccess) {
		this.updateConsoleAccess = updateConsoleAccess;
	}

	public FunctionConfiguration getGetConsoleUrl() {
		return getConsoleUrl;
	}

	public void setGetConsoleUrl(FunctionConfiguration getConsoleUrl) {
		this.getConsoleUrl = getConsoleUrl;
	}

	public FunctionConfiguration getGetGroup() {
		return getGroup;
	}

	public void setGetGroup(FunctionConfiguration getGroup) {
		this.getGroup = getGroup;
	}

	public FunctionConfiguration getGetPolicy() {
		return getPolicy;
	}

	public void setGetPolicy(FunctionConfiguration getPolicy) {
		this.getPolicy = getPolicy;
	}

	public FunctionConfiguration getGetPolicyRules() {
		return getPolicyRules;
	}

	public void setGetPolicyRules(FunctionConfiguration getPolicyRules) {
		this.getPolicyRules = getPolicyRules;
	}

	public FunctionConfiguration getGetUser() {
		return getUser;
	}

	public void setGetUser(FunctionConfiguration getUser) {
		this.getUser = getUser;
	}

	public FunctionConfiguration getListAccessKeys() {
		return listAccessKeys;
	}

	public void setListAccessKeys(FunctionConfiguration listAccessKeys) {
		this.listAccessKeys = listAccessKeys;
	}

	public FunctionConfiguration getListGroups() {
		return listGroups;
	}

	public void setListGroups(FunctionConfiguration listGroups) {
		this.listGroups = listGroups;
	}

	public FunctionConfiguration getListGroupsForUser() {
		return listGroupsForUser;
	}

	public void setListGroupsForUser(FunctionConfiguration listGroupsForUser) {
		this.listGroupsForUser = listGroupsForUser;
	}

	public FunctionConfiguration getListPolicies() {
		return listPolicies;
	}

	public void setListPolicies(FunctionConfiguration listPolicies) {
		this.listPolicies = listPolicies;
	}

	public FunctionConfiguration getListUsersInGroup() {
		return listUsersInGroup;
	}

	public void setListUsersInGroup(FunctionConfiguration listUsersInGroup) {
		this.listUsersInGroup = listUsersInGroup;
	}

	public FunctionConfiguration getListUsersInPath() {
		return listUsersInPath;
	}

	public void setListUsersInPath(FunctionConfiguration listUsersInPath) {
		this.listUsersInPath = listUsersInPath;
	}

	public FunctionConfiguration getListUsersForPolicy() {
		return listUsersForPolicy;
	}

	public void setListUsersForPolicy(FunctionConfiguration listUsersForPolicy) {
		this.listUsersForPolicy = listUsersForPolicy;
	}

	public FunctionConfiguration getListGroupsForPolicy() {
		return listGroupsForPolicy;
	}

	public void setListGroupsForPolicy(FunctionConfiguration listGroupsForPolicy) {
		this.listGroupsForPolicy = listGroupsForPolicy;
	}

	public FunctionConfiguration getRemoveAccessKey() {
		return removeAccessKey;
	}

	public void setRemoveAccessKey(FunctionConfiguration removeAccessKey) {
		this.removeAccessKey = removeAccessKey;
	}

	public FunctionConfiguration getRemoveConsoleAccess() {
		return removeConsoleAccess;
	}

	public void setRemoveConsoleAccess(FunctionConfiguration removeConsoleAccess) {
		this.removeConsoleAccess = removeConsoleAccess;
	}

	public FunctionConfiguration getRemoveGroup() {
		return removeGroup;
	}

	public void setRemoveGroup(FunctionConfiguration removeGroup) {
		this.removeGroup = removeGroup;
	}

	public FunctionConfiguration getRemoveUser() {
		return removeUser;
	}

	public void setRemoveUser(FunctionConfiguration removeUser) {
		this.removeUser = removeUser;
	}

	public FunctionConfiguration getRemoveUserFromGroup() {
		return removeUserFromGroup;
	}

	public void setRemoveUserFromGroup(FunctionConfiguration removeUserFromGroup) {
		this.removeUserFromGroup = removeUserFromGroup;
	}

	public FunctionConfiguration getModifyGroup() {
		return modifyGroup;
	}

	public void setModifyGroup(FunctionConfiguration modifyGroup) {
		this.modifyGroup = modifyGroup;
	}

	public FunctionConfiguration getCreatePolicy() {
		return createPolicy;
	}

	public void setCreatePolicy(FunctionConfiguration createPolicy) {
		this.createPolicy = createPolicy;
	}

	public FunctionConfiguration getModifyPolicy() {
		return modifyPolicy;
	}

	public void setModifyPolicy(FunctionConfiguration modifyPolicy) {
		this.modifyPolicy = modifyPolicy;
	}

	public FunctionConfiguration getRemovePolicy() {
		return removePolicy;
	}

	public void setRemovePolicy(FunctionConfiguration removePolicy) {
		this.removePolicy = removePolicy;
	}

	public FunctionConfiguration getAttachPolicyToUser() {
		return attachPolicyToUser;
	}

	public void setAttachPolicyToUser(FunctionConfiguration attachPolicyToUser) {
		this.attachPolicyToUser = attachPolicyToUser;
	}

	public FunctionConfiguration getDetachPolicyFromUser() {
		return detachPolicyFromUser;
	}

	public void setDetachPolicyFromUser(FunctionConfiguration detachPolicyFromUser) {
		this.detachPolicyFromUser = detachPolicyFromUser;
	}

	public FunctionConfiguration getAttachPolicyToGroup() {
		return attachPolicyToGroup;
	}

	public void setAttachPolicyToGroup(FunctionConfiguration attachPolicyToGroup) {
		this.attachPolicyToGroup = attachPolicyToGroup;
	}

	public FunctionConfiguration getDetachPolicyFromGroup() {
		return detachPolicyFromGroup;
	}

	public void setDetachPolicyFromGroup(FunctionConfiguration detachPolicyFromGroup) {
		this.detachPolicyFromGroup = detachPolicyFromGroup;
	}

	public FunctionConfiguration getEnableAccessKey() {
		return enableAccessKey;
	}

	public void setEnableAccessKey(FunctionConfiguration enableAccessKey) {
		this.enableAccessKey = enableAccessKey;
	}

	public FunctionConfiguration getDisableAccessKey() {
		return disableAccessKey;
	}

	public void setDisableAccessKey(FunctionConfiguration disableAccessKey) {
		this.disableAccessKey = disableAccessKey;
	}

	public FunctionConfiguration getModifyUser() {
		return modifyUser;
	}

	public void setModifyUser(FunctionConfiguration modifyUser) {
		this.modifyUser = modifyUser;
	}

	public FunctionConfiguration getListServices() {
		return listServices;
	}

	public void setListServices(FunctionConfiguration listServices) {
		this.listServices = listServices;
	}

	public FunctionConfiguration getListServiceActions() {
		return listServiceActions;
	}

	public void setListServiceActions(FunctionConfiguration listServiceActions) {
		this.listServiceActions = listServiceActions;
	}

	@Override
	public IdentityAndAccessConfiguration clone() {
		IdentityAndAccessConfiguration clone = new IdentityAndAccessConfiguration();
		clone.addUserToGroups = addUserToGroups.clone();
		clone.createGroup = createGroup.clone();
		clone.createUser = createUser.clone();
		clone.createAccessKey = createAccessKey.clone();
		clone.enableConsoleAccess = enableConsoleAccess.clone();
		clone.updateConsoleAccess = updateConsoleAccess.clone();
		clone.getConsoleUrl = getConsoleUrl.clone();
		clone.getGroup = getGroup.clone();
		clone.getPolicy = getPolicy.clone();
		clone.getPolicyRules = getPolicyRules.clone();
		clone.getUser = getUser.clone();
		clone.listAccessKeys = listAccessKeys.clone();
		clone.listGroups = listGroups.clone();
		clone.listGroupsForUser = listGroupsForUser.clone();
		clone.listPolicies = listPolicies.clone();
		clone.listUsersInGroup = listUsersInGroup.clone();
		clone.listUsersInPath = listUsersInPath.clone();
		clone.listUsersForPolicy = listUsersForPolicy.clone();
		clone.listGroupsForPolicy = listGroupsForPolicy.clone();
		clone.removeAccessKey = removeAccessKey.clone();
		clone.removeConsoleAccess = removeConsoleAccess.clone();
		clone.removeGroup = removeGroup.clone();
		clone.removeUser = removeUser.clone();
		clone.removeUserFromGroup = removeUserFromGroup.clone();
		clone.modifyGroup = modifyGroup.clone();
		clone.createPolicy = createPolicy.clone();
		clone.modifyPolicy = modifyPolicy.clone();
		clone.removePolicy = removePolicy.clone();
		clone.attachPolicyToUser = attachPolicyToUser.clone();
		clone.detachPolicyFromUser = detachPolicyFromUser.clone();
		clone.attachPolicyToGroup = attachPolicyToGroup.clone();
		clone.detachPolicyFromGroup = detachPolicyFromGroup.clone();
		clone.enableAccessKey = enableAccessKey.clone();
		clone.disableAccessKey = disableAccessKey.clone();
		clone.modifyUser = modifyUser.clone();
		clone.listServices = listServices.clone();
		clone.listServiceActions = listServiceActions.clone();
		return clone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addUserToGroups == null) ? 0 : addUserToGroups.hashCode());
		result = prime * result + ((createGroup == null) ? 0 : createGroup.hashCode());
		result = prime * result + ((createUser == null) ? 0 : createUser.hashCode());
		result = prime * result + ((createAccessKey == null) ? 0 : createAccessKey.hashCode());
		result = prime * result + ((enableConsoleAccess == null) ? 0 : enableConsoleAccess.hashCode());
		result = prime * result + ((updateConsoleAccess == null) ? 0 : updateConsoleAccess.hashCode());
		result = prime * result + ((getConsoleUrl == null) ? 0 : getConsoleUrl.hashCode());
		result = prime * result + ((getGroup == null) ? 0 : getGroup.hashCode());
		result = prime * result + ((getPolicy == null) ? 0 : getPolicy.hashCode());
		result = prime * result + ((getPolicyRules == null) ? 0 : getPolicyRules.hashCode());
		result = prime * result + ((getUser == null) ? 0 : getUser.hashCode());
		result = prime * result + ((listAccessKeys == null) ? 0 : listAccessKeys.hashCode());
		result = prime * result + ((listGroups == null) ? 0 : listGroups.hashCode());
		result = prime * result + ((listGroupsForUser == null) ? 0 : listGroupsForUser.hashCode());
		result = prime * result + ((listPolicies == null) ? 0 : listPolicies.hashCode());
		result = prime * result + ((listUsersInGroup == null) ? 0 : listUsersInGroup.hashCode());
		result = prime * result + ((listUsersInPath == null) ? 0 : listUsersInPath.hashCode());
		result = prime * result + ((listUsersForPolicy == null) ? 0 : listUsersForPolicy.hashCode());
		result = prime * result + ((listGroupsForPolicy == null) ? 0 : listGroupsForPolicy.hashCode());
		result = prime * result + ((removeAccessKey == null) ? 0 : removeAccessKey.hashCode());
		result = prime * result + ((removeConsoleAccess == null) ? 0 : removeConsoleAccess.hashCode());
		result = prime * result + ((removeGroup == null) ? 0 : removeGroup.hashCode());
		result = prime * result + ((removeUser == null) ? 0 : removeUser.hashCode());
		result = prime * result + ((removeUserFromGroup == null) ? 0 : removeUserFromGroup.hashCode());
		result = prime * result + ((modifyGroup == null) ? 0 : modifyGroup.hashCode());
		result = prime * result + ((createPolicy == null) ? 0 : createPolicy.hashCode());
		result = prime * result + ((modifyPolicy == null) ? 0 : modifyPolicy.hashCode());
		result = prime * result + ((removePolicy == null) ? 0 : removePolicy.hashCode());
		result = prime * result + ((attachPolicyToUser == null) ? 0 : attachPolicyToUser.hashCode());
		result = prime * result + ((detachPolicyFromUser == null) ? 0 : detachPolicyFromUser.hashCode());
		result = prime * result + ((attachPolicyToGroup == null) ? 0 : attachPolicyToGroup.hashCode());
		result = prime * result + ((detachPolicyFromGroup == null) ? 0 : detachPolicyFromGroup.hashCode());
		result = prime * result + ((enableAccessKey == null) ? 0 : enableAccessKey.hashCode());
		result = prime * result + ((disableAccessKey == null) ? 0 : disableAccessKey.hashCode());
		result = prime * result + ((modifyUser == null) ? 0 : modifyUser.hashCode());
		result = prime * result + ((listServices == null) ? 0 : listServices.hashCode());
		result = prime * result + ((listServiceActions == null) ? 0 : listServiceActions.hashCode());
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
		IdentityAndAccessConfiguration other = (IdentityAndAccessConfiguration) obj;
		if (addUserToGroups == null) {
			if (other.addUserToGroups != null)
				return false;
		} else if (!addUserToGroups.equals(other.addUserToGroups))
			return false;
		if (createGroup == null) {
			if (other.createGroup != null)
				return false;
		} else if (!createGroup.equals(other.createGroup))
			return false;
		if (createUser == null) {
			if (other.createUser != null)
				return false;
		} else if (!createUser.equals(other.createUser))
			return false;
		if (createAccessKey == null) {
			if (other.createAccessKey != null)
				return false;
		} else if (!createAccessKey.equals(other.createAccessKey))
			return false;
		if (enableConsoleAccess == null) {
			if (other.enableConsoleAccess != null)
				return false;
		} else if (!enableConsoleAccess.equals(other.enableConsoleAccess))
			return false;
		if (updateConsoleAccess == null) {
			if (other.updateConsoleAccess != null)
				return false;
		} else if (!updateConsoleAccess.equals(other.updateConsoleAccess))
			return false;
		if (getConsoleUrl == null) {
			if (other.getConsoleUrl != null)
				return false;
		} else if (!getConsoleUrl.equals(other.getConsoleUrl))
			return false;
		if (getGroup == null) {
			if (other.getGroup != null)
				return false;
		} else if (!getGroup.equals(other.getGroup))
			return false;
		if (getPolicy == null) {
			if (other.getPolicy != null)
				return false;
		} else if (!getPolicy.equals(other.getPolicy))
			return false;
		if (getPolicyRules == null) {
			if (other.getPolicyRules != null)
				return false;
		} else if (!getPolicyRules.equals(other.getPolicyRules))
			return false;
		if (getUser == null) {
			if (other.getUser != null)
				return false;
		} else if (!getUser.equals(other.getUser))
			return false;
		if (listAccessKeys == null) {
			if (other.listAccessKeys != null)
				return false;
		} else if (!listAccessKeys.equals(other.listAccessKeys))
			return false;
		if (listGroups == null) {
			if (other.listGroups != null)
				return false;
		} else if (!listGroups.equals(other.listGroups))
			return false;
		if (listGroupsForUser == null) {
			if (other.listGroupsForUser != null)
				return false;
		} else if (!listGroupsForUser.equals(other.listGroupsForUser))
			return false;
		if (listPolicies == null) {
			if (other.listPolicies != null)
				return false;
		} else if (!listPolicies.equals(other.listPolicies))
			return false;
		if (listUsersInGroup == null) {
			if (other.listUsersInGroup != null)
				return false;
		} else if (!listUsersInGroup.equals(other.listUsersInGroup))
			return false;
		if (listUsersInPath == null) {
			if (other.listUsersInPath != null)
				return false;
		} else if (!listUsersInPath.equals(other.listUsersInPath))
			return false;
		if (listUsersForPolicy == null) {
			if (other.listUsersForPolicy != null)
				return false;
		} else if (!listUsersForPolicy.equals(other.listUsersForPolicy))
			return false;
		if (listGroupsForPolicy == null) {
			if (other.listGroupsForPolicy != null)
				return false;
		} else if (!listGroupsForPolicy.equals(other.listGroupsForPolicy))
			return false;
		if (removeAccessKey == null) {
			if (other.removeAccessKey != null)
				return false;
		} else if (!removeAccessKey.equals(other.removeAccessKey))
			return false;
		if (removeConsoleAccess == null) {
			if (other.removeConsoleAccess != null)
				return false;
		} else if (!removeConsoleAccess.equals(other.removeConsoleAccess))
			return false;
		if (removeGroup == null) {
			if (other.removeGroup != null)
				return false;
		} else if (!removeGroup.equals(other.removeGroup))
			return false;
		if (removeUser == null) {
			if (other.removeUser != null)
				return false;
		} else if (!removeUser.equals(other.removeUser))
			return false;
		if (removeUserFromGroup == null) {
			if (other.removeUserFromGroup != null)
				return false;
		} else if (!removeUserFromGroup.equals(other.removeUserFromGroup))
			return false;
		if (modifyGroup == null) {
			if (other.modifyGroup != null)
				return false;
		} else if (!modifyGroup.equals(other.modifyGroup))
			return false;
		if (createPolicy == null) {
			if (other.createPolicy != null)
				return false;
		} else if (!createPolicy.equals(other.createPolicy))
			return false;
		if (modifyPolicy == null) {
			if (other.modifyPolicy != null)
				return false;
		} else if (!modifyPolicy.equals(other.modifyPolicy))
			return false;
		if (removePolicy == null) {
			if (other.removePolicy != null)
				return false;
		} else if (!removePolicy.equals(other.removePolicy))
			return false;
		if (attachPolicyToUser == null) {
			if (other.attachPolicyToUser != null)
				return false;
		} else if (!attachPolicyToUser.equals(other.attachPolicyToUser))
			return false;

		if (detachPolicyFromUser == null) {
			if (other.detachPolicyFromUser != null)
				return false;
		} else if (!detachPolicyFromUser.equals(other.detachPolicyFromUser))
			return false;
		if (attachPolicyToGroup == null) {
			if (other.attachPolicyToGroup != null)
				return false;
		} else if (!attachPolicyToGroup.equals(other.attachPolicyToGroup))
			return false;
		if (detachPolicyFromGroup == null) {
			if (other.detachPolicyFromGroup != null)
				return false;
		} else if (!detachPolicyFromGroup.equals(other.detachPolicyFromGroup))
			return false;
		if (enableAccessKey == null) {
			if (other.enableAccessKey != null)
				return false;
		} else if (!enableAccessKey.equals(other.enableAccessKey))
			return false;
		if (disableAccessKey == null) {
			if (other.disableAccessKey != null)
				return false;
		} else if (!disableAccessKey.equals(other.disableAccessKey))
			return false;
		if (modifyUser == null) {
			if (other.modifyUser != null)
				return false;
		} else if (!modifyUser.equals(other.modifyUser))
			return false;
		if (listServices == null) {
			if (other.listServices != null)
				return false;
		} else if (!listServices.equals(other.listServices))
			return false;
		if (listServiceActions == null) {
			if (other.listServiceActions != null)
				return false;
		} else if (!listServiceActions.equals(other.listServiceActions))
			return false;
		return true;
	}

}
