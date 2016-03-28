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
import com.infinities.skyport.model.Time;

public class VirtualMachineConfiguration implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final Time DEFAULT_VIRTUALMACHINE_DELAY = new Time();
	public static final Time DEFAULT_VIRTUALMACHINEPRODUCT_DELAY = new Time();
	static {
		DEFAULT_VIRTUALMACHINE_DELAY.setNumber(60);
		DEFAULT_VIRTUALMACHINEPRODUCT_DELAY.setNumber(300);
	}
	private FunctionConfiguration alterVirtualMachineProduct = new FunctionConfiguration();
	private FunctionConfiguration alterVirtualMachineSize = new FunctionConfiguration();
	private FunctionConfiguration alterVirtualMachineFirewalls = new FunctionConfiguration();
	private FunctionConfiguration cancelSpotDataFeedSubscription = new FunctionConfiguration();
	private FunctionConfiguration cancelSpotVirtualMachineRequest = new FunctionConfiguration();
	private FunctionConfiguration clone = new FunctionConfiguration();
	private FunctionConfiguration createSpotVirtualMachineRequest = new FunctionConfiguration();
	private FunctionConfiguration disableAnalytics = new FunctionConfiguration();
	private FunctionConfiguration enableAnalytics = new FunctionConfiguration();
	private FunctionConfiguration enableSpotDataFeedSubscription = new FunctionConfiguration();
	private FunctionConfiguration getPassword = new FunctionConfiguration();
	private FunctionConfiguration getUserData = new FunctionConfiguration();
	private FunctionConfiguration getConsoleOutput = new FunctionConfiguration();
	private FunctionConfiguration getProduct = new FunctionConfiguration();
	private FunctionConfiguration getVirtualMachine = new FunctionConfiguration();
	private FunctionConfiguration getVMStatistics = new FunctionConfiguration();
	private FunctionConfiguration getVMStatisticsForPeriod = new FunctionConfiguration();
	private FunctionConfiguration getVMStatus = new FunctionConfiguration();
	private FunctionConfiguration launch = new FunctionConfiguration();
	private FunctionConfiguration launchMany = new FunctionConfiguration();
	private FunctionConfiguration listFirewalls = new FunctionConfiguration();
	private FunctionConfiguration listProducts = new FunctionConfiguration();
	private FunctionConfiguration listAllProducts = new FunctionConfiguration();
	private FunctionConfiguration listSpotPriceHistories = new FunctionConfiguration();
	private FunctionConfiguration listSpotVirtualMachineRequests = new FunctionConfiguration();
	private FunctionConfiguration listVirtualMachineStatus = new FunctionConfiguration();
	private FunctionConfiguration listVirtualMachines = new FunctionConfiguration();
	private FunctionConfiguration pause = new FunctionConfiguration();
	private FunctionConfiguration reboot = new FunctionConfiguration();
	private FunctionConfiguration resume = new FunctionConfiguration();
	private FunctionConfiguration start = new FunctionConfiguration();
	private FunctionConfiguration stop = new FunctionConfiguration();
	private FunctionConfiguration suspend = new FunctionConfiguration();
	private FunctionConfiguration terminate = new FunctionConfiguration();
	private FunctionConfiguration unpause = new FunctionConfiguration();
	private FunctionConfiguration updateTags = new FunctionConfiguration();
	private FunctionConfiguration setTags = new FunctionConfiguration();
	private FunctionConfiguration removeTags = new FunctionConfiguration();
	private FunctionConfiguration listNovaStyleVirtualMachines = new FunctionConfiguration();
	private FunctionConfiguration getNovaStyleVirtualMachine = new FunctionConfiguration();
	private FunctionConfiguration listMinimalVirtualMachines = new FunctionConfiguration();
	private FunctionConfiguration updateVirtualMachine = new FunctionConfiguration();


	public VirtualMachineConfiguration() {
		listVirtualMachines.setDelay(DEFAULT_VIRTUALMACHINE_DELAY);
		listAllProducts.setDelay(DEFAULT_VIRTUALMACHINEPRODUCT_DELAY);
	}

	public FunctionConfiguration getAlterVirtualMachineProduct() {
		return alterVirtualMachineProduct;
	}

	public void setAlterVirtualMachineProduct(FunctionConfiguration alterVirtualMachineProduct) {
		this.alterVirtualMachineProduct = alterVirtualMachineProduct;
	}

	public FunctionConfiguration getAlterVirtualMachineSize() {
		return alterVirtualMachineSize;
	}

	public void setAlterVirtualMachineSize(FunctionConfiguration alterVirtualMachineSize) {
		this.alterVirtualMachineSize = alterVirtualMachineSize;
	}

	public FunctionConfiguration getAlterVirtualMachineFirewalls() {
		return alterVirtualMachineFirewalls;
	}

	public void setAlterVirtualMachineFirewalls(FunctionConfiguration alterVirtualMachineFirewalls) {
		this.alterVirtualMachineFirewalls = alterVirtualMachineFirewalls;
	}

	public FunctionConfiguration getCancelSpotDataFeedSubscription() {
		return cancelSpotDataFeedSubscription;
	}

	public void setCancelSpotDataFeedSubscription(FunctionConfiguration cancelSpotDataFeedSubscription) {
		this.cancelSpotDataFeedSubscription = cancelSpotDataFeedSubscription;
	}

	public FunctionConfiguration getCancelSpotVirtualMachineRequest() {
		return cancelSpotVirtualMachineRequest;
	}

	public void setCancelSpotVirtualMachineRequest(FunctionConfiguration cancelSpotVirtualMachineRequest) {
		this.cancelSpotVirtualMachineRequest = cancelSpotVirtualMachineRequest;
	}

	public FunctionConfiguration getClone() {
		return clone;
	}

	public void setClone(FunctionConfiguration clone) {
		this.clone = clone;
	}

	public FunctionConfiguration getCreateSpotVirtualMachineRequest() {
		return createSpotVirtualMachineRequest;
	}

	public void setCreateSpotVirtualMachineRequest(FunctionConfiguration createSpotVirtualMachineRequest) {
		this.createSpotVirtualMachineRequest = createSpotVirtualMachineRequest;
	}

	public FunctionConfiguration getDisableAnalytics() {
		return disableAnalytics;
	}

	public void setDisableAnalytics(FunctionConfiguration disableAnalytics) {
		this.disableAnalytics = disableAnalytics;
	}

	public FunctionConfiguration getEnableAnalytics() {
		return enableAnalytics;
	}

	public void setEnableAnalytics(FunctionConfiguration enableAnalytics) {
		this.enableAnalytics = enableAnalytics;
	}

	public FunctionConfiguration getEnableSpotDataFeedSubscription() {
		return enableSpotDataFeedSubscription;
	}

	public void setEnableSpotDataFeedSubscription(FunctionConfiguration enableSpotDataFeedSubscription) {
		this.enableSpotDataFeedSubscription = enableSpotDataFeedSubscription;
	}

	public FunctionConfiguration getGetPassword() {
		return getPassword;
	}

	public void setGetPassword(FunctionConfiguration getPassword) {
		this.getPassword = getPassword;
	}

	public FunctionConfiguration getGetUserData() {
		return getUserData;
	}

	public void setGetUserData(FunctionConfiguration getUserData) {
		this.getUserData = getUserData;
	}

	public FunctionConfiguration getGetConsoleOutput() {
		return getConsoleOutput;
	}

	public void setGetConsoleOutput(FunctionConfiguration getConsoleOutput) {
		this.getConsoleOutput = getConsoleOutput;
	}

	public FunctionConfiguration getGetProduct() {
		return getProduct;
	}

	public void setGetProduct(FunctionConfiguration getProduct) {
		this.getProduct = getProduct;
	}

	public FunctionConfiguration getGetVirtualMachine() {
		return getVirtualMachine;
	}

	public void setGetVirtualMachine(FunctionConfiguration getVirtualMachine) {
		this.getVirtualMachine = getVirtualMachine;
	}

	public FunctionConfiguration getGetVMStatistics() {
		return getVMStatistics;
	}

	public void setGetVMStatistics(FunctionConfiguration getVMStatistics) {
		this.getVMStatistics = getVMStatistics;
	}

	public FunctionConfiguration getGetVMStatisticsForPeriod() {
		return getVMStatisticsForPeriod;
	}

	public void setGetVMStatisticsForPeriod(FunctionConfiguration getVMStatisticsForPeriod) {
		this.getVMStatisticsForPeriod = getVMStatisticsForPeriod;
	}

	public FunctionConfiguration getGetVMStatus() {
		return getVMStatus;
	}

	public void setGetVMStatus(FunctionConfiguration getVMStatus) {
		this.getVMStatus = getVMStatus;
	}

	public FunctionConfiguration getLaunch() {
		return launch;
	}

	public void setLaunch(FunctionConfiguration launch) {
		this.launch = launch;
	}

	public FunctionConfiguration getLaunchMany() {
		return launchMany;
	}

	public void setLaunchMany(FunctionConfiguration launchMany) {
		this.launchMany = launchMany;
	}

	public FunctionConfiguration getListFirewalls() {
		return listFirewalls;
	}

	public void setListFirewalls(FunctionConfiguration listFirewalls) {
		this.listFirewalls = listFirewalls;
	}

	public FunctionConfiguration getListProducts() {
		return listProducts;
	}

	public void setListProducts(FunctionConfiguration listProducts) {
		this.listProducts = listProducts;
	}

	public FunctionConfiguration getListAllProducts() {
		return listAllProducts;
	}

	public void setListAllProducts(FunctionConfiguration listAllProducts) {
		this.listAllProducts = listAllProducts;
	}

	public FunctionConfiguration getListSpotPriceHistories() {
		return listSpotPriceHistories;
	}

	public void setListSpotPriceHistories(FunctionConfiguration listSpotPriceHistories) {
		this.listSpotPriceHistories = listSpotPriceHistories;
	}

	public FunctionConfiguration getListSpotVirtualMachineRequests() {
		return listSpotVirtualMachineRequests;
	}

	public void setListSpotVirtualMachineRequests(FunctionConfiguration listSpotVirtualMachineRequests) {
		this.listSpotVirtualMachineRequests = listSpotVirtualMachineRequests;
	}

	public FunctionConfiguration getListVirtualMachineStatus() {
		return listVirtualMachineStatus;
	}

	public void setListVirtualMachineStatus(FunctionConfiguration listVirtualMachineStatus) {
		this.listVirtualMachineStatus = listVirtualMachineStatus;
	}

	public FunctionConfiguration getListVirtualMachines() {
		return listVirtualMachines;
	}

	public void setListVirtualMachines(FunctionConfiguration listVirtualMachines) {
		this.listVirtualMachines = listVirtualMachines;
	}

	public FunctionConfiguration getPause() {
		return pause;
	}

	public void setPause(FunctionConfiguration pause) {
		this.pause = pause;
	}

	public FunctionConfiguration getReboot() {
		return reboot;
	}

	public void setReboot(FunctionConfiguration reboot) {
		this.reboot = reboot;
	}

	public FunctionConfiguration getResume() {
		return resume;
	}

	public void setResume(FunctionConfiguration resume) {
		this.resume = resume;
	}

	public FunctionConfiguration getStart() {
		return start;
	}

	public void setStart(FunctionConfiguration start) {
		this.start = start;
	}

	public FunctionConfiguration getStop() {
		return stop;
	}

	public void setStop(FunctionConfiguration stop) {
		this.stop = stop;
	}

	public FunctionConfiguration getSuspend() {
		return suspend;
	}

	public void setSuspend(FunctionConfiguration suspend) {
		this.suspend = suspend;
	}

	public FunctionConfiguration getTerminate() {
		return terminate;
	}

	public void setTerminate(FunctionConfiguration terminate) {
		this.terminate = terminate;
	}

	public FunctionConfiguration getUnpause() {
		return unpause;
	}

	public void setUnpause(FunctionConfiguration unpause) {
		this.unpause = unpause;
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

	public FunctionConfiguration getRemoveTags() {
		return removeTags;
	}

	public void setRemoveTags(FunctionConfiguration removeTags) {
		this.removeTags = removeTags;
	}

	/**
	 * @return the listNovaStyleVirtualMachines
	 */
	public FunctionConfiguration getListNovaStyleVirtualMachines() {
		return listNovaStyleVirtualMachines;
	}

	/**
	 * @param listNovaStyleVirtualMachines
	 *            the listNovaStyleVirtualMachines to set
	 */
	public void setListNovaStyleVirtualMachines(FunctionConfiguration listNovaStyleVirtualMachines) {
		this.listNovaStyleVirtualMachines = listNovaStyleVirtualMachines;
	}

	/**
	 * @return the listMinimalVirtualMachines
	 */
	public FunctionConfiguration getListMinimalVirtualMachines() {
		return listMinimalVirtualMachines;
	}

	/**
	 * @param listMinimalVirtualMachines
	 *            the listMinimalVirtualMachines to set
	 */
	public void setListMinimalVirtualMachines(FunctionConfiguration listMinimalVirtualMachines) {
		this.listMinimalVirtualMachines = listMinimalVirtualMachines;
	}

	/**
	 * @return the getNovaStyleVirtualMachine
	 */
	public FunctionConfiguration getGetNovaStyleVirtualMachine() {
		return getNovaStyleVirtualMachine;
	}

	/**
	 * @param getNovaStyleVirtualMachine
	 *            the getNovaStyleVirtualMachine to set
	 */
	public void setGetNovaStyleVirtualMachine(FunctionConfiguration getNovaStyleVirtualMachine) {
		this.getNovaStyleVirtualMachine = getNovaStyleVirtualMachine;
	}

	@Override
	public VirtualMachineConfiguration clone() {
		VirtualMachineConfiguration clone = new VirtualMachineConfiguration();

		clone.setAlterVirtualMachineProduct(alterVirtualMachineProduct.clone());
		clone.setAlterVirtualMachineSize(alterVirtualMachineSize.clone());
		clone.setAlterVirtualMachineFirewalls(alterVirtualMachineFirewalls.clone());
		clone.setCancelSpotDataFeedSubscription(cancelSpotDataFeedSubscription.clone());
		clone.setCancelSpotVirtualMachineRequest(cancelSpotVirtualMachineRequest.clone());
		clone.setClone(this.clone.clone());
		clone.setCreateSpotVirtualMachineRequest(createSpotVirtualMachineRequest.clone());
		clone.setDisableAnalytics(disableAnalytics.clone());
		clone.setEnableAnalytics(enableAnalytics.clone());
		clone.setEnableSpotDataFeedSubscription(enableSpotDataFeedSubscription.clone());
		clone.setGetPassword(getPassword.clone());
		clone.setGetUserData(getUserData.clone());
		clone.setGetConsoleOutput(getConsoleOutput.clone());
		clone.setGetProduct(getProduct.clone());
		clone.setGetVirtualMachine(getVirtualMachine.clone());
		clone.setGetVMStatistics(getVMStatistics.clone());
		clone.setGetVMStatisticsForPeriod(getVMStatisticsForPeriod.clone());
		clone.setGetVMStatus(getVMStatus.clone());
		clone.setLaunch(launch.clone());
		clone.setLaunchMany(launchMany.clone());
		clone.setListFirewalls(listFirewalls.clone());
		clone.setListProducts(listProducts.clone());
		clone.setListAllProducts(listAllProducts.clone());
		clone.setListSpotPriceHistories(listSpotPriceHistories.clone());
		clone.setListSpotVirtualMachineRequests(listSpotVirtualMachineRequests.clone());
		clone.setListVirtualMachineStatus(listVirtualMachineStatus.clone());
		clone.setListVirtualMachines(listVirtualMachines.clone());
		clone.setPause(pause.clone());
		clone.setReboot(reboot.clone());
		clone.setResume(resume.clone());
		clone.setStart(start.clone());
		clone.setStop(stop.clone());
		clone.setSuspend(suspend.clone());
		clone.setTerminate(terminate.clone());
		clone.setUnpause(unpause.clone());
		clone.setUpdateTags(updateTags.clone());
		clone.setSetTags(setTags.clone());
		clone.setRemoveTags(removeTags.clone());
		clone.setListMinimalVirtualMachines(listMinimalVirtualMachines.clone());
		clone.setListNovaStyleVirtualMachines(listNovaStyleVirtualMachines.clone());
		clone.setUpdateVirtualMachine(updateVirtualMachine.clone());
		clone.setGetNovaStyleVirtualMachine(getNovaStyleVirtualMachine.clone());
		return clone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alterVirtualMachineFirewalls == null) ? 0 : alterVirtualMachineFirewalls.hashCode());
		result = prime * result + ((alterVirtualMachineProduct == null) ? 0 : alterVirtualMachineProduct.hashCode());
		result = prime * result + ((alterVirtualMachineSize == null) ? 0 : alterVirtualMachineSize.hashCode());
		result = prime * result + ((cancelSpotDataFeedSubscription == null) ? 0 : cancelSpotDataFeedSubscription.hashCode());
		result =
				prime * result
						+ ((cancelSpotVirtualMachineRequest == null) ? 0 : cancelSpotVirtualMachineRequest.hashCode());
		result = prime * result + ((clone == null) ? 0 : clone.hashCode());
		result =
				prime * result
						+ ((createSpotVirtualMachineRequest == null) ? 0 : createSpotVirtualMachineRequest.hashCode());
		result = prime * result + ((disableAnalytics == null) ? 0 : disableAnalytics.hashCode());
		result = prime * result + ((enableAnalytics == null) ? 0 : enableAnalytics.hashCode());
		result = prime * result + ((enableSpotDataFeedSubscription == null) ? 0 : enableSpotDataFeedSubscription.hashCode());
		result = prime * result + ((getConsoleOutput == null) ? 0 : getConsoleOutput.hashCode());
		result = prime * result + ((getPassword == null) ? 0 : getPassword.hashCode());
		result = prime * result + ((getProduct == null) ? 0 : getProduct.hashCode());
		result = prime * result + ((getUserData == null) ? 0 : getUserData.hashCode());
		result = prime * result + ((getVMStatistics == null) ? 0 : getVMStatistics.hashCode());
		result = prime * result + ((getVMStatisticsForPeriod == null) ? 0 : getVMStatisticsForPeriod.hashCode());
		result = prime * result + ((getVMStatus == null) ? 0 : getVMStatus.hashCode());
		result = prime * result + ((getVirtualMachine == null) ? 0 : getVirtualMachine.hashCode());
		result = prime * result + ((launch == null) ? 0 : launch.hashCode());
		result = prime * result + ((launchMany == null) ? 0 : launchMany.hashCode());
		result = prime * result + ((listFirewalls == null) ? 0 : listFirewalls.hashCode());
		result = prime * result + ((listProducts == null) ? 0 : listProducts.hashCode());
		result = prime * result + ((listAllProducts == null) ? 0 : listAllProducts.hashCode());
		result = prime * result + ((listSpotPriceHistories == null) ? 0 : listSpotPriceHistories.hashCode());
		result = prime * result + ((listSpotVirtualMachineRequests == null) ? 0 : listSpotVirtualMachineRequests.hashCode());
		result = prime * result + ((listVirtualMachineStatus == null) ? 0 : listVirtualMachineStatus.hashCode());
		result = prime * result + ((listVirtualMachines == null) ? 0 : listVirtualMachines.hashCode());
		result = prime * result + ((pause == null) ? 0 : pause.hashCode());
		result = prime * result + ((reboot == null) ? 0 : reboot.hashCode());
		result = prime * result + ((removeTags == null) ? 0 : removeTags.hashCode());
		result = prime * result + ((resume == null) ? 0 : resume.hashCode());
		result = prime * result + ((setTags == null) ? 0 : setTags.hashCode());
		result = prime * result + ((start == null) ? 0 : start.hashCode());
		result = prime * result + ((stop == null) ? 0 : stop.hashCode());
		result = prime * result + ((suspend == null) ? 0 : suspend.hashCode());
		result = prime * result + ((terminate == null) ? 0 : terminate.hashCode());
		result = prime * result + ((unpause == null) ? 0 : unpause.hashCode());
		result = prime * result + ((updateTags == null) ? 0 : updateTags.hashCode());
		result = prime * result + ((listMinimalVirtualMachines == null) ? 0 : listMinimalVirtualMachines.hashCode());
		result = prime * result + ((listNovaStyleVirtualMachines == null) ? 0 : listNovaStyleVirtualMachines.hashCode());
		result = prime * result + ((updateVirtualMachine == null) ? 0 : updateVirtualMachine.hashCode());
		result = prime * result + ((getNovaStyleVirtualMachine == null) ? 0 : getNovaStyleVirtualMachine.hashCode());
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
		VirtualMachineConfiguration other = (VirtualMachineConfiguration) obj;
		if (alterVirtualMachineFirewalls == null) {
			if (other.alterVirtualMachineFirewalls != null)
				return false;
		} else if (!alterVirtualMachineFirewalls.equals(other.alterVirtualMachineFirewalls))
			return false;
		if (alterVirtualMachineProduct == null) {
			if (other.alterVirtualMachineProduct != null)
				return false;
		} else if (!alterVirtualMachineProduct.equals(other.alterVirtualMachineProduct))
			return false;
		if (alterVirtualMachineSize == null) {
			if (other.alterVirtualMachineSize != null)
				return false;
		} else if (!alterVirtualMachineSize.equals(other.alterVirtualMachineSize))
			return false;
		if (cancelSpotDataFeedSubscription == null) {
			if (other.cancelSpotDataFeedSubscription != null)
				return false;
		} else if (!cancelSpotDataFeedSubscription.equals(other.cancelSpotDataFeedSubscription))
			return false;
		if (cancelSpotVirtualMachineRequest == null) {
			if (other.cancelSpotVirtualMachineRequest != null)
				return false;
		} else if (!cancelSpotVirtualMachineRequest.equals(other.cancelSpotVirtualMachineRequest))
			return false;
		if (clone == null) {
			if (other.clone != null)
				return false;
		} else if (!clone.equals(other.clone))
			return false;
		if (createSpotVirtualMachineRequest == null) {
			if (other.createSpotVirtualMachineRequest != null)
				return false;
		} else if (!createSpotVirtualMachineRequest.equals(other.createSpotVirtualMachineRequest))
			return false;
		if (disableAnalytics == null) {
			if (other.disableAnalytics != null)
				return false;
		} else if (!disableAnalytics.equals(other.disableAnalytics))
			return false;
		if (enableAnalytics == null) {
			if (other.enableAnalytics != null)
				return false;
		} else if (!enableAnalytics.equals(other.enableAnalytics))
			return false;
		if (enableSpotDataFeedSubscription == null) {
			if (other.enableSpotDataFeedSubscription != null)
				return false;
		} else if (!enableSpotDataFeedSubscription.equals(other.enableSpotDataFeedSubscription))
			return false;
		if (getConsoleOutput == null) {
			if (other.getConsoleOutput != null)
				return false;
		} else if (!getConsoleOutput.equals(other.getConsoleOutput))
			return false;
		if (getPassword == null) {
			if (other.getPassword != null)
				return false;
		} else if (!getPassword.equals(other.getPassword))
			return false;
		if (getProduct == null) {
			if (other.getProduct != null)
				return false;
		} else if (!getProduct.equals(other.getProduct))
			return false;
		if (getUserData == null) {
			if (other.getUserData != null)
				return false;
		} else if (!getUserData.equals(other.getUserData))
			return false;
		if (getVMStatistics == null) {
			if (other.getVMStatistics != null)
				return false;
		} else if (!getVMStatistics.equals(other.getVMStatistics))
			return false;
		if (getVMStatisticsForPeriod == null) {
			if (other.getVMStatisticsForPeriod != null)
				return false;
		} else if (!getVMStatisticsForPeriod.equals(other.getVMStatisticsForPeriod))
			return false;
		if (getVMStatus == null) {
			if (other.getVMStatus != null)
				return false;
		} else if (!getVMStatus.equals(other.getVMStatus))
			return false;
		if (getVirtualMachine == null) {
			if (other.getVirtualMachine != null)
				return false;
		} else if (!getVirtualMachine.equals(other.getVirtualMachine))
			return false;
		if (launch == null) {
			if (other.launch != null)
				return false;
		} else if (!launch.equals(other.launch))
			return false;
		if (launchMany == null) {
			if (other.launchMany != null)
				return false;
		} else if (!launchMany.equals(other.launchMany))
			return false;
		if (listFirewalls == null) {
			if (other.listFirewalls != null)
				return false;
		} else if (!listFirewalls.equals(other.listFirewalls))
			return false;
		if (listProducts == null) {
			if (other.listProducts != null)
				return false;
		} else if (!listProducts.equals(other.listProducts))
			return false;
		if (listAllProducts == null) {
			if (other.listAllProducts != null)
				return false;
		} else if (!listAllProducts.equals(other.listAllProducts))
			return false;
		if (listSpotPriceHistories == null) {
			if (other.listSpotPriceHistories != null)
				return false;
		} else if (!listSpotPriceHistories.equals(other.listSpotPriceHistories))
			return false;
		if (listSpotVirtualMachineRequests == null) {
			if (other.listSpotVirtualMachineRequests != null)
				return false;
		} else if (!listSpotVirtualMachineRequests.equals(other.listSpotVirtualMachineRequests))
			return false;
		if (listVirtualMachineStatus == null) {
			if (other.listVirtualMachineStatus != null)
				return false;
		} else if (!listVirtualMachineStatus.equals(other.listVirtualMachineStatus))
			return false;
		if (listVirtualMachines == null) {
			if (other.listVirtualMachines != null)
				return false;
		} else if (!listVirtualMachines.equals(other.listVirtualMachines))
			return false;
		if (pause == null) {
			if (other.pause != null)
				return false;
		} else if (!pause.equals(other.pause))
			return false;
		if (reboot == null) {
			if (other.reboot != null)
				return false;
		} else if (!reboot.equals(other.reboot))
			return false;
		if (removeTags == null) {
			if (other.removeTags != null)
				return false;
		} else if (!removeTags.equals(other.removeTags))
			return false;
		if (resume == null) {
			if (other.resume != null)
				return false;
		} else if (!resume.equals(other.resume))
			return false;
		if (setTags == null) {
			if (other.setTags != null)
				return false;
		} else if (!setTags.equals(other.setTags))
			return false;
		if (start == null) {
			if (other.start != null)
				return false;
		} else if (!start.equals(other.start))
			return false;
		if (stop == null) {
			if (other.stop != null)
				return false;
		} else if (!stop.equals(other.stop))
			return false;
		if (suspend == null) {
			if (other.suspend != null)
				return false;
		} else if (!suspend.equals(other.suspend))
			return false;
		if (terminate == null) {
			if (other.terminate != null)
				return false;
		} else if (!terminate.equals(other.terminate))
			return false;
		if (unpause == null) {
			if (other.unpause != null)
				return false;
		} else if (!unpause.equals(other.unpause))
			return false;
		if (updateTags == null) {
			if (other.updateTags != null)
				return false;
		} else if (!updateTags.equals(other.updateTags))
			return false;
		if (listMinimalVirtualMachines == null) {
			if (other.listMinimalVirtualMachines != null)
				return false;
		} else if (!listMinimalVirtualMachines.equals(other.listMinimalVirtualMachines))
			return false;
		if (listNovaStyleVirtualMachines == null) {
			if (other.listNovaStyleVirtualMachines != null)
				return false;
		} else if (!listNovaStyleVirtualMachines.equals(other.listNovaStyleVirtualMachines))
			return false;
		if (updateVirtualMachine == null) {
			if (other.updateVirtualMachine != null)
				return false;
		} else if (!updateVirtualMachine.equals(other.updateVirtualMachine))
			return false;
		if (getNovaStyleVirtualMachine == null) {
			if (other.getNovaStyleVirtualMachine != null)
				return false;
		} else if (!getNovaStyleVirtualMachine.equals(other.getNovaStyleVirtualMachine))
			return false;
		return true;
	}

	/**
	 * @return the updateVirtualMachine
	 */
	public FunctionConfiguration getUpdateVirtualMachine() {
		return updateVirtualMachine;
	}

	/**
	 * @param updateVirtualMachine
	 *            the updateVirtualMachine to set
	 */
	public void setUpdateVirtualMachine(FunctionConfiguration updateVirtualMachine) {
		this.updateVirtualMachine = updateVirtualMachine;
	}

}
