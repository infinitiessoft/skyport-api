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

public class LoadBalancerConfiguration implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	private FunctionConfiguration addListeners = new FunctionConfiguration();
	private FunctionConfiguration removeListeners = new FunctionConfiguration();
	private FunctionConfiguration addDataCenters = new FunctionConfiguration();
	private FunctionConfiguration addIPEndpoints = new FunctionConfiguration();
	private FunctionConfiguration addServers = new FunctionConfiguration();
	private FunctionConfiguration createLoadBalancer = new FunctionConfiguration();
	private FunctionConfiguration getLoadBalancer = new FunctionConfiguration();
	private FunctionConfiguration listEndpoints = new FunctionConfiguration();
	private FunctionConfiguration listLoadBalancers = new FunctionConfiguration();
	private FunctionConfiguration listLoadBalancerStatus = new FunctionConfiguration();
	private FunctionConfiguration removeDataCenters = new FunctionConfiguration();
	private FunctionConfiguration removeIPEndpoints = new FunctionConfiguration();
	private FunctionConfiguration removeLoadBalancer = new FunctionConfiguration();
	private FunctionConfiguration removeServers = new FunctionConfiguration();
	private FunctionConfiguration createLoadBalancerHealthCheck = new FunctionConfiguration();
	private FunctionConfiguration getLoadBalancerHealthCheck = new FunctionConfiguration();
	private FunctionConfiguration listLBHealthChecks = new FunctionConfiguration();
	private FunctionConfiguration attachHealthCheckToLoadBalancer = new FunctionConfiguration();
	private FunctionConfiguration detachHealthCheckFromLoadBalancer = new FunctionConfiguration();
	private FunctionConfiguration modifyHealthCheck = new FunctionConfiguration();
	private FunctionConfiguration removeLoadBalancerHealthCheck = new FunctionConfiguration();
	private FunctionConfiguration createSSLCertificate = new FunctionConfiguration();
	private FunctionConfiguration listSSLCertificates = new FunctionConfiguration();
	private FunctionConfiguration removeSSLCertificate = new FunctionConfiguration();
	private FunctionConfiguration setSSLCertificate = new FunctionConfiguration();
	private FunctionConfiguration getSSLCertificate = new FunctionConfiguration();
	private FunctionConfiguration setFirewalls = new FunctionConfiguration();
	private FunctionConfiguration attachLoadBalancerToSubnets = new FunctionConfiguration();
	private FunctionConfiguration detachLoadBalancerFromSubnets = new FunctionConfiguration();
	private FunctionConfiguration modifyLoadBalancerAttributes = new FunctionConfiguration();
	private FunctionConfiguration getLoadBalancerAttributes = new FunctionConfiguration();
	private FunctionConfiguration removeTags = new FunctionConfiguration();
	private FunctionConfiguration updateTags = new FunctionConfiguration();
	private FunctionConfiguration setTags = new FunctionConfiguration();


	public FunctionConfiguration getAddListeners() {
		return addListeners;
	}

	public void setAddListeners(FunctionConfiguration addListeners) {
		this.addListeners = addListeners;
	}

	public FunctionConfiguration getRemoveListeners() {
		return removeListeners;
	}

	public void setRemoveListeners(FunctionConfiguration removeListeners) {
		this.removeListeners = removeListeners;
	}

	public FunctionConfiguration getAddDataCenters() {
		return addDataCenters;
	}

	public void setAddDataCenters(FunctionConfiguration addDataCenters) {
		this.addDataCenters = addDataCenters;
	}

	public FunctionConfiguration getAddIPEndpoints() {
		return addIPEndpoints;
	}

	public void setAddIPEndpoints(FunctionConfiguration addIPEndpoints) {
		this.addIPEndpoints = addIPEndpoints;
	}

	public FunctionConfiguration getAddServers() {
		return addServers;
	}

	public void setAddServers(FunctionConfiguration addServers) {
		this.addServers = addServers;
	}

	public FunctionConfiguration getCreateLoadBalancer() {
		return createLoadBalancer;
	}

	public void setCreateLoadBalancer(FunctionConfiguration createLoadBalancer) {
		this.createLoadBalancer = createLoadBalancer;
	}

	public FunctionConfiguration getGetLoadBalancer() {
		return getLoadBalancer;
	}

	public void setGetLoadBalancer(FunctionConfiguration getLoadBalancer) {
		this.getLoadBalancer = getLoadBalancer;
	}

	public FunctionConfiguration getListEndpoints() {
		return listEndpoints;
	}

	public void setListEndpoints(FunctionConfiguration listEndpoints) {
		this.listEndpoints = listEndpoints;
	}

	public FunctionConfiguration getListLoadBalancers() {
		return listLoadBalancers;
	}

	public void setListLoadBalancers(FunctionConfiguration listLoadBalancers) {
		this.listLoadBalancers = listLoadBalancers;
	}

	public FunctionConfiguration getListLoadBalancerStatus() {
		return listLoadBalancerStatus;
	}

	public void setListLoadBalancerStatus(FunctionConfiguration listLoadBalancerStatus) {
		this.listLoadBalancerStatus = listLoadBalancerStatus;
	}

	public FunctionConfiguration getRemoveDataCenters() {
		return removeDataCenters;
	}

	public void setRemoveDataCenters(FunctionConfiguration removeDataCenters) {
		this.removeDataCenters = removeDataCenters;
	}

	public FunctionConfiguration getRemoveIPEndpoints() {
		return removeIPEndpoints;
	}

	public void setRemoveIPEndpoints(FunctionConfiguration removeIPEndpoints) {
		this.removeIPEndpoints = removeIPEndpoints;
	}

	public FunctionConfiguration getRemoveLoadBalancer() {
		return removeLoadBalancer;
	}

	public void setRemoveLoadBalancer(FunctionConfiguration removeLoadBalancer) {
		this.removeLoadBalancer = removeLoadBalancer;
	}

	public FunctionConfiguration getRemoveServers() {
		return removeServers;
	}

	public void setRemoveServers(FunctionConfiguration removeServers) {
		this.removeServers = removeServers;
	}

	public FunctionConfiguration getCreateLoadBalancerHealthCheck() {
		return createLoadBalancerHealthCheck;
	}

	public void setCreateLoadBalancerHealthCheck(FunctionConfiguration createLoadBalancerHealthCheck) {
		this.createLoadBalancerHealthCheck = createLoadBalancerHealthCheck;
	}

	public FunctionConfiguration getGetLoadBalancerHealthCheck() {
		return getLoadBalancerHealthCheck;
	}

	public void setGetLoadBalancerHealthCheck(FunctionConfiguration getLoadBalancerHealthCheck) {
		this.getLoadBalancerHealthCheck = getLoadBalancerHealthCheck;
	}

	public FunctionConfiguration getListLBHealthChecks() {
		return listLBHealthChecks;
	}

	public void setListLBHealthChecks(FunctionConfiguration listLBHealthChecks) {
		this.listLBHealthChecks = listLBHealthChecks;
	}

	public FunctionConfiguration getAttachHealthCheckToLoadBalancer() {
		return attachHealthCheckToLoadBalancer;
	}

	public void setAttachHealthCheckToLoadBalancer(FunctionConfiguration attachHealthCheckToLoadBalancer) {
		this.attachHealthCheckToLoadBalancer = attachHealthCheckToLoadBalancer;
	}

	public FunctionConfiguration getDetachHealthCheckFromLoadBalancer() {
		return detachHealthCheckFromLoadBalancer;
	}

	public void setDetachHealthCheckFromLoadBalancer(FunctionConfiguration detachHealthCheckFromLoadBalancer) {
		this.detachHealthCheckFromLoadBalancer = detachHealthCheckFromLoadBalancer;
	}

	public FunctionConfiguration getModifyHealthCheck() {
		return modifyHealthCheck;
	}

	public void setModifyHealthCheck(FunctionConfiguration modifyHealthCheck) {
		this.modifyHealthCheck = modifyHealthCheck;
	}

	public FunctionConfiguration getRemoveLoadBalancerHealthCheck() {
		return removeLoadBalancerHealthCheck;
	}

	public void setRemoveLoadBalancerHealthCheck(FunctionConfiguration removeLoadBalancerHealthCheck) {
		this.removeLoadBalancerHealthCheck = removeLoadBalancerHealthCheck;
	}

	public FunctionConfiguration getCreateSSLCertificate() {
		return createSSLCertificate;
	}

	public void setCreateSSLCertificate(FunctionConfiguration createSSLCertificate) {
		this.createSSLCertificate = createSSLCertificate;
	}

	public FunctionConfiguration getListSSLCertificates() {
		return listSSLCertificates;
	}

	public void setListSSLCertificates(FunctionConfiguration listSSLCertificates) {
		this.listSSLCertificates = listSSLCertificates;
	}

	public FunctionConfiguration getRemoveSSLCertificate() {
		return removeSSLCertificate;
	}

	public void setRemoveSSLCertificate(FunctionConfiguration removeSSLCertificate) {
		this.removeSSLCertificate = removeSSLCertificate;
	}

	public FunctionConfiguration getSetSSLCertificate() {
		return setSSLCertificate;
	}

	public void setSetSSLCertificate(FunctionConfiguration setSSLCertificate) {
		this.setSSLCertificate = setSSLCertificate;
	}

	public FunctionConfiguration getGetSSLCertificate() {
		return getSSLCertificate;
	}

	public void setGetSSLCertificate(FunctionConfiguration getSSLCertificate) {
		this.getSSLCertificate = getSSLCertificate;
	}

	public FunctionConfiguration getSetFirewalls() {
		return setFirewalls;
	}

	public void setSetFirewalls(FunctionConfiguration setFirewalls) {
		this.setFirewalls = setFirewalls;
	}

	public FunctionConfiguration getAttachLoadBalancerToSubnets() {
		return attachLoadBalancerToSubnets;
	}

	public void setAttachLoadBalancerToSubnets(FunctionConfiguration attachLoadBalancerToSubnets) {
		this.attachLoadBalancerToSubnets = attachLoadBalancerToSubnets;
	}

	public FunctionConfiguration getDetachLoadBalancerFromSubnets() {
		return detachLoadBalancerFromSubnets;
	}

	public void setDetachLoadBalancerFromSubnets(FunctionConfiguration detachLoadBalancerFromSubnets) {
		this.detachLoadBalancerFromSubnets = detachLoadBalancerFromSubnets;
	}

	public FunctionConfiguration getModifyLoadBalancerAttributes() {
		return modifyLoadBalancerAttributes;
	}

	public void setModifyLoadBalancerAttributes(FunctionConfiguration modifyLoadBalancerAttributes) {
		this.modifyLoadBalancerAttributes = modifyLoadBalancerAttributes;
	}

	public FunctionConfiguration getGetLoadBalancerAttributes() {
		return getLoadBalancerAttributes;
	}

	public void setGetLoadBalancerAttributes(FunctionConfiguration getLoadBalancerAttributes) {
		this.getLoadBalancerAttributes = getLoadBalancerAttributes;
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
	public LoadBalancerConfiguration clone() {
		LoadBalancerConfiguration clone = new LoadBalancerConfiguration();
		clone.addListeners = addListeners.clone();
		clone.removeListeners = removeListeners.clone();
		clone.addDataCenters = addDataCenters.clone();
		clone.addIPEndpoints = addIPEndpoints.clone();
		clone.addServers = addServers.clone();
		clone.createLoadBalancer = createLoadBalancer.clone();
		clone.getLoadBalancer = getLoadBalancer.clone();
		clone.listEndpoints = listEndpoints.clone();
		clone.listLoadBalancers = listLoadBalancers.clone();
		clone.listLoadBalancerStatus = listLoadBalancerStatus.clone();
		clone.removeDataCenters = removeDataCenters.clone();
		clone.removeIPEndpoints = removeIPEndpoints.clone();
		clone.removeLoadBalancer = removeLoadBalancer.clone();
		clone.removeServers = removeServers.clone();
		clone.createLoadBalancerHealthCheck = createLoadBalancerHealthCheck.clone();
		clone.getLoadBalancerHealthCheck = getLoadBalancerHealthCheck.clone();
		clone.listLBHealthChecks = listLBHealthChecks.clone();
		clone.attachHealthCheckToLoadBalancer = attachHealthCheckToLoadBalancer.clone();
		clone.detachHealthCheckFromLoadBalancer = detachHealthCheckFromLoadBalancer.clone();
		clone.modifyHealthCheck = modifyHealthCheck.clone();
		clone.removeLoadBalancerHealthCheck = removeLoadBalancerHealthCheck.clone();
		clone.createSSLCertificate = createSSLCertificate.clone();
		clone.listSSLCertificates = listSSLCertificates.clone();
		clone.removeSSLCertificate = removeSSLCertificate.clone();
		clone.setSSLCertificate = setSSLCertificate.clone();
		clone.getSSLCertificate = getSSLCertificate.clone();
		clone.setFirewalls = setFirewalls.clone();
		clone.attachLoadBalancerToSubnets = attachLoadBalancerToSubnets.clone();
		clone.detachLoadBalancerFromSubnets = detachLoadBalancerFromSubnets.clone();
		clone.modifyLoadBalancerAttributes = modifyLoadBalancerAttributes.clone();
		clone.getLoadBalancerAttributes = getLoadBalancerAttributes.clone();
		clone.removeTags = removeTags.clone();
		clone.updateTags = updateTags.clone();
		clone.setTags = setTags.clone();
		return clone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addDataCenters == null) ? 0 : addDataCenters.hashCode());
		result = prime * result + ((addIPEndpoints == null) ? 0 : addIPEndpoints.hashCode());
		result = prime * result + ((addListeners == null) ? 0 : addListeners.hashCode());
		result = prime * result + ((addServers == null) ? 0 : addServers.hashCode());
		result = prime * result
				+ ((attachHealthCheckToLoadBalancer == null) ? 0 : attachHealthCheckToLoadBalancer.hashCode());
		result = prime * result + ((attachLoadBalancerToSubnets == null) ? 0 : attachLoadBalancerToSubnets.hashCode());
		result = prime * result + ((createLoadBalancer == null) ? 0 : createLoadBalancer.hashCode());
		result = prime * result + ((createLoadBalancerHealthCheck == null) ? 0 : createLoadBalancerHealthCheck.hashCode());
		result = prime * result + ((createSSLCertificate == null) ? 0 : createSSLCertificate.hashCode());
		result = prime * result
				+ ((detachHealthCheckFromLoadBalancer == null) ? 0 : detachHealthCheckFromLoadBalancer.hashCode());
		result = prime * result + ((detachLoadBalancerFromSubnets == null) ? 0 : detachLoadBalancerFromSubnets.hashCode());
		result = prime * result + ((getLoadBalancer == null) ? 0 : getLoadBalancer.hashCode());
		result = prime * result + ((getLoadBalancerAttributes == null) ? 0 : getLoadBalancerAttributes.hashCode());
		result = prime * result + ((getLoadBalancerHealthCheck == null) ? 0 : getLoadBalancerHealthCheck.hashCode());
		result = prime * result + ((getSSLCertificate == null) ? 0 : getSSLCertificate.hashCode());
		result = prime * result + ((listEndpoints == null) ? 0 : listEndpoints.hashCode());
		result = prime * result + ((listLBHealthChecks == null) ? 0 : listLBHealthChecks.hashCode());
		result = prime * result + ((listLoadBalancerStatus == null) ? 0 : listLoadBalancerStatus.hashCode());
		result = prime * result + ((listLoadBalancers == null) ? 0 : listLoadBalancers.hashCode());
		result = prime * result + ((listSSLCertificates == null) ? 0 : listSSLCertificates.hashCode());
		result = prime * result + ((modifyHealthCheck == null) ? 0 : modifyHealthCheck.hashCode());
		result = prime * result + ((modifyLoadBalancerAttributes == null) ? 0 : modifyLoadBalancerAttributes.hashCode());
		result = prime * result + ((removeDataCenters == null) ? 0 : removeDataCenters.hashCode());
		result = prime * result + ((removeIPEndpoints == null) ? 0 : removeIPEndpoints.hashCode());
		result = prime * result + ((removeListeners == null) ? 0 : removeListeners.hashCode());
		result = prime * result + ((removeLoadBalancer == null) ? 0 : removeLoadBalancer.hashCode());
		result = prime * result + ((removeLoadBalancerHealthCheck == null) ? 0 : removeLoadBalancerHealthCheck.hashCode());
		result = prime * result + ((removeSSLCertificate == null) ? 0 : removeSSLCertificate.hashCode());
		result = prime * result + ((removeServers == null) ? 0 : removeServers.hashCode());
		result = prime * result + ((removeTags == null) ? 0 : removeTags.hashCode());
		result = prime * result + ((setFirewalls == null) ? 0 : setFirewalls.hashCode());
		result = prime * result + ((setSSLCertificate == null) ? 0 : setSSLCertificate.hashCode());
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
		LoadBalancerConfiguration other = (LoadBalancerConfiguration) obj;
		if (addDataCenters == null) {
			if (other.addDataCenters != null)
				return false;
		} else if (!addDataCenters.equals(other.addDataCenters))
			return false;
		if (addIPEndpoints == null) {
			if (other.addIPEndpoints != null)
				return false;
		} else if (!addIPEndpoints.equals(other.addIPEndpoints))
			return false;
		if (addListeners == null) {
			if (other.addListeners != null)
				return false;
		} else if (!addListeners.equals(other.addListeners))
			return false;
		if (addServers == null) {
			if (other.addServers != null)
				return false;
		} else if (!addServers.equals(other.addServers))
			return false;
		if (attachHealthCheckToLoadBalancer == null) {
			if (other.attachHealthCheckToLoadBalancer != null)
				return false;
		} else if (!attachHealthCheckToLoadBalancer.equals(other.attachHealthCheckToLoadBalancer))
			return false;
		if (attachLoadBalancerToSubnets == null) {
			if (other.attachLoadBalancerToSubnets != null)
				return false;
		} else if (!attachLoadBalancerToSubnets.equals(other.attachLoadBalancerToSubnets))
			return false;
		if (createLoadBalancer == null) {
			if (other.createLoadBalancer != null)
				return false;
		} else if (!createLoadBalancer.equals(other.createLoadBalancer))
			return false;
		if (createLoadBalancerHealthCheck == null) {
			if (other.createLoadBalancerHealthCheck != null)
				return false;
		} else if (!createLoadBalancerHealthCheck.equals(other.createLoadBalancerHealthCheck))
			return false;
		if (createSSLCertificate == null) {
			if (other.createSSLCertificate != null)
				return false;
		} else if (!createSSLCertificate.equals(other.createSSLCertificate))
			return false;
		if (detachHealthCheckFromLoadBalancer == null) {
			if (other.detachHealthCheckFromLoadBalancer != null)
				return false;
		} else if (!detachHealthCheckFromLoadBalancer.equals(other.detachHealthCheckFromLoadBalancer))
			return false;
		if (detachLoadBalancerFromSubnets == null) {
			if (other.detachLoadBalancerFromSubnets != null)
				return false;
		} else if (!detachLoadBalancerFromSubnets.equals(other.detachLoadBalancerFromSubnets))
			return false;
		if (getLoadBalancer == null) {
			if (other.getLoadBalancer != null)
				return false;
		} else if (!getLoadBalancer.equals(other.getLoadBalancer))
			return false;
		if (getLoadBalancerAttributes == null) {
			if (other.getLoadBalancerAttributes != null)
				return false;
		} else if (!getLoadBalancerAttributes.equals(other.getLoadBalancerAttributes))
			return false;
		if (getLoadBalancerHealthCheck == null) {
			if (other.getLoadBalancerHealthCheck != null)
				return false;
		} else if (!getLoadBalancerHealthCheck.equals(other.getLoadBalancerHealthCheck))
			return false;
		if (getSSLCertificate == null) {
			if (other.getSSLCertificate != null)
				return false;
		} else if (!getSSLCertificate.equals(other.getSSLCertificate))
			return false;
		if (listEndpoints == null) {
			if (other.listEndpoints != null)
				return false;
		} else if (!listEndpoints.equals(other.listEndpoints))
			return false;
		if (listLBHealthChecks == null) {
			if (other.listLBHealthChecks != null)
				return false;
		} else if (!listLBHealthChecks.equals(other.listLBHealthChecks))
			return false;
		if (listLoadBalancerStatus == null) {
			if (other.listLoadBalancerStatus != null)
				return false;
		} else if (!listLoadBalancerStatus.equals(other.listLoadBalancerStatus))
			return false;
		if (listLoadBalancers == null) {
			if (other.listLoadBalancers != null)
				return false;
		} else if (!listLoadBalancers.equals(other.listLoadBalancers))
			return false;
		if (listSSLCertificates == null) {
			if (other.listSSLCertificates != null)
				return false;
		} else if (!listSSLCertificates.equals(other.listSSLCertificates))
			return false;
		if (modifyHealthCheck == null) {
			if (other.modifyHealthCheck != null)
				return false;
		} else if (!modifyHealthCheck.equals(other.modifyHealthCheck))
			return false;
		if (modifyLoadBalancerAttributes == null) {
			if (other.modifyLoadBalancerAttributes != null)
				return false;
		} else if (!modifyLoadBalancerAttributes.equals(other.modifyLoadBalancerAttributes))
			return false;
		if (removeDataCenters == null) {
			if (other.removeDataCenters != null)
				return false;
		} else if (!removeDataCenters.equals(other.removeDataCenters))
			return false;
		if (removeIPEndpoints == null) {
			if (other.removeIPEndpoints != null)
				return false;
		} else if (!removeIPEndpoints.equals(other.removeIPEndpoints))
			return false;
		if (removeListeners == null) {
			if (other.removeListeners != null)
				return false;
		} else if (!removeListeners.equals(other.removeListeners))
			return false;
		if (removeLoadBalancer == null) {
			if (other.removeLoadBalancer != null)
				return false;
		} else if (!removeLoadBalancer.equals(other.removeLoadBalancer))
			return false;
		if (removeLoadBalancerHealthCheck == null) {
			if (other.removeLoadBalancerHealthCheck != null)
				return false;
		} else if (!removeLoadBalancerHealthCheck.equals(other.removeLoadBalancerHealthCheck))
			return false;
		if (removeSSLCertificate == null) {
			if (other.removeSSLCertificate != null)
				return false;
		} else if (!removeSSLCertificate.equals(other.removeSSLCertificate))
			return false;
		if (removeServers == null) {
			if (other.removeServers != null)
				return false;
		} else if (!removeServers.equals(other.removeServers))
			return false;
		if (removeTags == null) {
			if (other.removeTags != null)
				return false;
		} else if (!removeTags.equals(other.removeTags))
			return false;
		if (setFirewalls == null) {
			if (other.setFirewalls != null)
				return false;
		} else if (!setFirewalls.equals(other.setFirewalls))
			return false;
		if (setSSLCertificate == null) {
			if (other.setSSLCertificate != null)
				return false;
		} else if (!setSSLCertificate.equals(other.setSSLCertificate))
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
