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

public class IpAddressConfiguration implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	private FunctionConfiguration assign = new FunctionConfiguration();
	private FunctionConfiguration assignToNetworkInterface = new FunctionConfiguration();
	private FunctionConfiguration forward = new FunctionConfiguration();
	private FunctionConfiguration getIpAddress = new FunctionConfiguration();
	private FunctionConfiguration isAssigned = new FunctionConfiguration();
	private FunctionConfiguration isForwarding = new FunctionConfiguration();
	private FunctionConfiguration isRequestable = new FunctionConfiguration();
	private FunctionConfiguration listPrivateIpPool = new FunctionConfiguration();
	private FunctionConfiguration listPublicIpPool = new FunctionConfiguration();
	private FunctionConfiguration listIpPool = new FunctionConfiguration();
	private FunctionConfiguration listIpPoolConcurrently = new FunctionConfiguration();
	private FunctionConfiguration listIpPoolStatus = new FunctionConfiguration();
	private FunctionConfiguration listRules = new FunctionConfiguration();
	private FunctionConfiguration listRulesForServer = new FunctionConfiguration();
	private FunctionConfiguration releaseFromPool = new FunctionConfiguration();
	private FunctionConfiguration releaseFromServer = new FunctionConfiguration();
	private FunctionConfiguration request = new FunctionConfiguration();
	private FunctionConfiguration requestForVLAN = new FunctionConfiguration();
	private FunctionConfiguration stopForward = new FunctionConfiguration();
	private FunctionConfiguration stopForwardToServer = new FunctionConfiguration();
	private FunctionConfiguration removeTags = new FunctionConfiguration();
	private FunctionConfiguration updateTags = new FunctionConfiguration();
	private FunctionConfiguration setTags = new FunctionConfiguration();


	public FunctionConfiguration getAssign() {
		return assign;
	}

	public void setAssign(FunctionConfiguration assign) {
		this.assign = assign;
	}

	public FunctionConfiguration getAssignToNetworkInterface() {
		return assignToNetworkInterface;
	}

	public void setAssignToNetworkInterface(FunctionConfiguration assignToNetworkInterface) {
		this.assignToNetworkInterface = assignToNetworkInterface;
	}

	public FunctionConfiguration getForward() {
		return forward;
	}

	public void setForward(FunctionConfiguration forward) {
		this.forward = forward;
	}

	public FunctionConfiguration getGetIpAddress() {
		return getIpAddress;
	}

	public void setGetIpAddress(FunctionConfiguration getIpAddress) {
		this.getIpAddress = getIpAddress;
	}

	public FunctionConfiguration getIsAssigned() {
		return isAssigned;
	}

	public void setIsAssigned(FunctionConfiguration isAssigned) {
		this.isAssigned = isAssigned;
	}

	public FunctionConfiguration getIsForwarding() {
		return isForwarding;
	}

	public void setIsForwarding(FunctionConfiguration isForwarding) {
		this.isForwarding = isForwarding;
	}

	public FunctionConfiguration getIsRequestable() {
		return isRequestable;
	}

	public void setIsRequestable(FunctionConfiguration isRequestable) {
		this.isRequestable = isRequestable;
	}

	public FunctionConfiguration getListPrivateIpPool() {
		return listPrivateIpPool;
	}

	public void setListPrivateIpPool(FunctionConfiguration listPrivateIpPool) {
		this.listPrivateIpPool = listPrivateIpPool;
	}

	public FunctionConfiguration getListPublicIpPool() {
		return listPublicIpPool;
	}

	public void setListPublicIpPool(FunctionConfiguration listPublicIpPool) {
		this.listPublicIpPool = listPublicIpPool;
	}

	public FunctionConfiguration getListIpPool() {
		return listIpPool;
	}

	public void setListIpPool(FunctionConfiguration listIpPool) {
		this.listIpPool = listIpPool;
	}

	public FunctionConfiguration getListIpPoolConcurrently() {
		return listIpPoolConcurrently;
	}

	public void setListIpPoolConcurrently(FunctionConfiguration listIpPoolConcurrently) {
		this.listIpPoolConcurrently = listIpPoolConcurrently;
	}

	public FunctionConfiguration getListIpPoolStatus() {
		return listIpPoolStatus;
	}

	public void setListIpPoolStatus(FunctionConfiguration listIpPoolStatus) {
		this.listIpPoolStatus = listIpPoolStatus;
	}

	public FunctionConfiguration getListRules() {
		return listRules;
	}

	public void setListRules(FunctionConfiguration listRules) {
		this.listRules = listRules;
	}

	public FunctionConfiguration getListRulesForServer() {
		return listRulesForServer;
	}

	public void setListRulesForServer(FunctionConfiguration listRulesForServer) {
		this.listRulesForServer = listRulesForServer;
	}

	public FunctionConfiguration getReleaseFromPool() {
		return releaseFromPool;
	}

	public void setReleaseFromPool(FunctionConfiguration releaseFromPool) {
		this.releaseFromPool = releaseFromPool;
	}

	public FunctionConfiguration getReleaseFromServer() {
		return releaseFromServer;
	}

	public void setReleaseFromServer(FunctionConfiguration releaseFromServer) {
		this.releaseFromServer = releaseFromServer;
	}

	public FunctionConfiguration getRequest() {
		return request;
	}

	public void setRequest(FunctionConfiguration request) {
		this.request = request;
	}

	public FunctionConfiguration getRequestForVLAN() {
		return requestForVLAN;
	}

	public void setRequestForVLAN(FunctionConfiguration requestForVLAN) {
		this.requestForVLAN = requestForVLAN;
	}

	public FunctionConfiguration getStopForward() {
		return stopForward;
	}

	public void setStopForward(FunctionConfiguration stopForward) {
		this.stopForward = stopForward;
	}

	public FunctionConfiguration getStopForwardToServer() {
		return stopForwardToServer;
	}

	public void setStopForwardToServer(FunctionConfiguration stopForwardToServer) {
		this.stopForwardToServer = stopForwardToServer;
	}

	public FunctionConfiguration getRemoveTags() {
		return removeTags;
	}

	public void setRemoveTags(FunctionConfiguration removeTags) {
		this.removeTags = removeTags;
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
	public IpAddressConfiguration clone() {
		IpAddressConfiguration clone = new IpAddressConfiguration();
		clone.assign = assign.clone();
		clone.assignToNetworkInterface = assignToNetworkInterface.clone();
		clone.forward = forward.clone();
		clone.getIpAddress = getIpAddress.clone();
		clone.isAssigned = isAssigned.clone();
		clone.isForwarding = isForwarding.clone();
		clone.isRequestable = isRequestable.clone();
		clone.listPrivateIpPool = listPrivateIpPool.clone();
		clone.listPublicIpPool = listPublicIpPool.clone();
		clone.listIpPool = listIpPool.clone();
		clone.listIpPoolConcurrently = listIpPoolConcurrently.clone();
		clone.listIpPoolStatus = listIpPoolStatus.clone();
		clone.listRules = listRules.clone();
		clone.listRulesForServer = listRulesForServer.clone();
		clone.releaseFromPool = releaseFromPool.clone();
		clone.releaseFromServer = releaseFromServer.clone();
		clone.request = request.clone();
		clone.requestForVLAN = requestForVLAN.clone();
		clone.stopForward = stopForward.clone();
		clone.stopForwardToServer = stopForwardToServer.clone();
		clone.removeTags = removeTags.clone();
		clone.updateTags = updateTags.clone();
		clone.setTags = setTags.clone();
		return clone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assign == null) ? 0 : assign.hashCode());
		result = prime * result + ((assignToNetworkInterface == null) ? 0 : assignToNetworkInterface.hashCode());
		result = prime * result + ((forward == null) ? 0 : forward.hashCode());
		result = prime * result + ((getIpAddress == null) ? 0 : getIpAddress.hashCode());
		result = prime * result + ((isAssigned == null) ? 0 : isAssigned.hashCode());
		result = prime * result + ((isForwarding == null) ? 0 : isForwarding.hashCode());
		result = prime * result + ((isRequestable == null) ? 0 : isRequestable.hashCode());
		result = prime * result + ((listPrivateIpPool == null) ? 0 : listPrivateIpPool.hashCode());
		result = prime * result + ((listPublicIpPool == null) ? 0 : listPublicIpPool.hashCode());
		result = prime * result + ((listIpPool == null) ? 0 : listIpPool.hashCode());
		result = prime * result + ((listIpPoolConcurrently == null) ? 0 : listIpPoolConcurrently.hashCode());
		result = prime * result + ((listIpPoolStatus == null) ? 0 : listIpPoolStatus.hashCode());
		result = prime * result + ((listRules == null) ? 0 : listRules.hashCode());
		result = prime * result + ((listRulesForServer == null) ? 0 : listRulesForServer.hashCode());
		result = prime * result + ((releaseFromPool == null) ? 0 : releaseFromPool.hashCode());
		result = prime * result + ((releaseFromServer == null) ? 0 : releaseFromServer.hashCode());
		result = prime * result + ((removeTags == null) ? 0 : removeTags.hashCode());
		result = prime * result + ((request == null) ? 0 : request.hashCode());
		result = prime * result + ((requestForVLAN == null) ? 0 : requestForVLAN.hashCode());
		result = prime * result + ((setTags == null) ? 0 : setTags.hashCode());
		result = prime * result + ((stopForward == null) ? 0 : stopForward.hashCode());
		result = prime * result + ((stopForwardToServer == null) ? 0 : stopForwardToServer.hashCode());
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
		IpAddressConfiguration other = (IpAddressConfiguration) obj;
		if (assign == null) {
			if (other.assign != null)
				return false;
		} else if (!assign.equals(other.assign))
			return false;
		if (assignToNetworkInterface == null) {
			if (other.assignToNetworkInterface != null)
				return false;
		} else if (!assignToNetworkInterface.equals(other.assignToNetworkInterface))
			return false;
		if (forward == null) {
			if (other.forward != null)
				return false;
		} else if (!forward.equals(other.forward))
			return false;
		if (getIpAddress == null) {
			if (other.getIpAddress != null)
				return false;
		} else if (!getIpAddress.equals(other.getIpAddress))
			return false;
		if (isAssigned == null) {
			if (other.isAssigned != null)
				return false;
		} else if (!isAssigned.equals(other.isAssigned))
			return false;
		if (isForwarding == null) {
			if (other.isForwarding != null)
				return false;
		} else if (!isForwarding.equals(other.isForwarding))
			return false;
		if (isRequestable == null) {
			if (other.isRequestable != null)
				return false;
		} else if (!isRequestable.equals(other.isRequestable))
			return false;
		if (listPrivateIpPool == null) {
			if (other.listPrivateIpPool != null)
				return false;
		} else if (!listPrivateIpPool.equals(other.listPrivateIpPool))
			return false;
		if (listPublicIpPool == null) {
			if (other.listPublicIpPool != null)
				return false;
		} else if (!listPublicIpPool.equals(other.listPublicIpPool))
			return false;
		if (listIpPool == null) {
			if (other.listIpPool != null)
				return false;
		} else if (!listIpPool.equals(other.listIpPool))
			return false;
		if (listIpPoolConcurrently == null) {
			if (other.listIpPoolConcurrently != null)
				return false;
		} else if (!listIpPoolConcurrently.equals(other.listIpPoolConcurrently))
			return false;
		if (listIpPoolStatus == null) {
			if (other.listIpPoolStatus != null)
				return false;
		} else if (!listIpPoolStatus.equals(other.listIpPoolStatus))
			return false;
		if (listRules == null) {
			if (other.listRules != null)
				return false;
		} else if (!listRules.equals(other.listRules))
			return false;
		if (listRulesForServer == null) {
			if (other.listRulesForServer != null)
				return false;
		} else if (!listRulesForServer.equals(other.listRulesForServer))
			return false;
		if (releaseFromPool == null) {
			if (other.releaseFromPool != null)
				return false;
		} else if (!releaseFromPool.equals(other.releaseFromPool))
			return false;
		if (releaseFromServer == null) {
			if (other.releaseFromServer != null)
				return false;
		} else if (!releaseFromServer.equals(other.releaseFromServer))
			return false;
		if (removeTags == null) {
			if (other.removeTags != null)
				return false;
		} else if (!removeTags.equals(other.removeTags))
			return false;
		if (request == null) {
			if (other.request != null)
				return false;
		} else if (!request.equals(other.request))
			return false;
		if (requestForVLAN == null) {
			if (other.requestForVLAN != null)
				return false;
		} else if (!requestForVLAN.equals(other.requestForVLAN))
			return false;
		if (setTags == null) {
			if (other.setTags != null)
				return false;
		} else if (!setTags.equals(other.setTags))
			return false;
		if (stopForward == null) {
			if (other.stopForward != null)
				return false;
		} else if (!stopForward.equals(other.stopForward))
			return false;
		if (stopForwardToServer == null) {
			if (other.stopForwardToServer != null)
				return false;
		} else if (!stopForwardToServer.equals(other.stopForwardToServer))
			return false;
		if (updateTags == null) {
			if (other.updateTags != null)
				return false;
		} else if (!updateTags.equals(other.updateTags))
			return false;
		return true;
	}

}
