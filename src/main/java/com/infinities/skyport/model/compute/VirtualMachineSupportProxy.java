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
package com.infinities.skyport.model.compute;

import java.io.Serializable;

import org.dasein.cloud.CloudException;
import org.dasein.cloud.InternalException;
import org.dasein.cloud.ResourceStatus;
import org.dasein.cloud.Tag;
import org.dasein.cloud.compute.SpotPriceHistory;
import org.dasein.cloud.compute.SpotPriceHistoryFilterOptions;
import org.dasein.cloud.compute.SpotVirtualMachineRequest;
import org.dasein.cloud.compute.SpotVirtualMachineRequestCreateOptions;
import org.dasein.cloud.compute.SpotVirtualMachineRequestFilterOptions;
import org.dasein.cloud.compute.VMFilterOptions;
import org.dasein.cloud.compute.VMLaunchOptions;
import org.dasein.cloud.compute.VirtualMachine;
import org.dasein.cloud.compute.VirtualMachineCapabilities;
import org.dasein.cloud.compute.VirtualMachineProduct;
import org.dasein.cloud.compute.VirtualMachineProductFilterOptions;
import org.dasein.cloud.compute.VirtualMachineStatus;
import org.dasein.cloud.compute.VmStatistics;
import org.dasein.cloud.compute.VmStatusFilterOptions;
import org.dasein.cloud.identity.ServiceAction;

import com.infinities.skyport.async.AsyncResult;
import com.infinities.skyport.async.service.compute.AsyncVirtualMachineSupport;
import com.infinities.skyport.compute.SkyportVirtualMachineSupport;
import com.infinities.skyport.compute.VMUpdateOptions;
import com.infinities.skyport.compute.entity.MinimalResource;
import com.infinities.skyport.compute.entity.NovaStyleVirtualMachine;

public class VirtualMachineSupportProxy implements AsyncVirtualMachineSupport, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final AsyncVirtualMachineSupport support;


	public VirtualMachineSupportProxy(AsyncVirtualMachineSupport support) {
		this.support = support;
	}

	@Override
	public String[] mapServiceAction(ServiceAction action) {
		return support.mapServiceAction(action);
	}

	@Override
	public AsyncResult<VirtualMachine> alterVirtualMachineProduct(String virtualMachineId, String productId)
			throws InternalException, CloudException {
		return support.alterVirtualMachineProduct(virtualMachineId, productId);
	}

	@Override
	public AsyncResult<VirtualMachine> alterVirtualMachineSize(String virtualMachineId, String cpuCount, String ramInMB)
			throws InternalException, CloudException {
		return support.alterVirtualMachineSize(virtualMachineId, cpuCount, ramInMB);
	}

	@Override
	public AsyncResult<VirtualMachine> alterVirtualMachineFirewalls(String virtualMachineId, String[] firewalls)
			throws InternalException, CloudException {
		return support.alterVirtualMachineFirewalls(virtualMachineId, firewalls);
	}

	@Override
	public AsyncResult<Void> cancelSpotDataFeedSubscription() throws CloudException, InternalException {
		return support.cancelSpotDataFeedSubscription();
	}

	@Override
	public AsyncResult<Void> cancelSpotVirtualMachineRequest(String providerSpotVirtualMachineRequestID)
			throws CloudException, InternalException {
		return support.cancelSpotVirtualMachineRequest(providerSpotVirtualMachineRequestID);
	}

	@Override
	public AsyncResult<VirtualMachine> clone(String vmId, String intoDcId, String name, String description, boolean powerOn,
			String... firewallIds) throws InternalException, CloudException {
		return support.clone(vmId, intoDcId, name, description, powerOn, firewallIds);
	}

	@Override
	public AsyncResult<SpotVirtualMachineRequest> createSpotVirtualMachineRequest(
			SpotVirtualMachineRequestCreateOptions options) throws CloudException, InternalException {
		return support.createSpotVirtualMachineRequest(options);
	}

	@Override
	public AsyncResult<Void> disableAnalytics(String vmId) throws InternalException, CloudException {
		return support.disableAnalytics(vmId);
	}

	@Override
	public AsyncResult<Void> enableAnalytics(String vmId) throws InternalException, CloudException {
		return support.enableAnalytics(vmId);
	}

	@Override
	public AsyncResult<Void> enableSpotDataFeedSubscription(String bucketName) throws CloudException, InternalException {
		return support.enableSpotDataFeedSubscription(bucketName);
	}

	@Override
	public VirtualMachineCapabilities getCapabilities() throws InternalException, CloudException {
		return support.getCapabilities();
	}

	@Override
	public AsyncResult<String> getPassword(String vmId) throws InternalException, CloudException {
		return support.getPassword(vmId);
	}

	@Override
	public AsyncResult<String> getUserData(String vmId) throws InternalException, CloudException {
		return support.getUserData(vmId);
	}

	@Override
	public AsyncResult<String> getConsoleOutput(String vmId) throws InternalException, CloudException {
		return support.getConsoleOutput(vmId);
	}

	@Override
	public AsyncResult<VirtualMachineProduct> getProduct(String productId) throws InternalException, CloudException {
		return support.getProduct(productId);
	}

	@Override
	public AsyncResult<VirtualMachine> getVirtualMachine(String vmId) throws InternalException, CloudException {
		return support.getVirtualMachine(vmId);
	}

	@Override
	public AsyncResult<VmStatistics> getVMStatistics(String vmId, long from, long to) throws InternalException,
			CloudException {
		return support.getVMStatistics(vmId, from, to);
	}

	@Override
	public AsyncResult<Iterable<VmStatistics>> getVMStatisticsForPeriod(String vmId, long from, long to)
			throws InternalException, CloudException {
		return support.getVMStatisticsForPeriod(vmId, from, to);
	}

	@Override
	public AsyncResult<Iterable<VirtualMachineStatus>> getVMStatus(String... vmIds) throws InternalException, CloudException {
		return support.getVMStatus(vmIds);
	}

	@Override
	public AsyncResult<Iterable<VirtualMachineStatus>> getVMStatus(VmStatusFilterOptions filterOptions)
			throws InternalException, CloudException {
		return support.getVMStatus(filterOptions);
	}

	@Override
	public boolean isSubscribed() throws CloudException, InternalException {
		return support.isSubscribed();
	}

	@Override
	public AsyncResult<VirtualMachine> launch(VMLaunchOptions withLaunchOptions) throws CloudException, InternalException {
		return support.launch(withLaunchOptions);
	}

	@Override
	public AsyncResult<Iterable<String>> launchMany(VMLaunchOptions withLaunchOptions, int count) throws CloudException,
			InternalException {
		return support.launchMany(withLaunchOptions, count);
	}

	@Override
	public AsyncResult<Iterable<String>> listFirewalls(String vmId) throws InternalException, CloudException {
		return support.listFirewalls(vmId);
	}

	@Override
	public AsyncResult<Iterable<VirtualMachineProduct>> listProducts(String machineImageId) throws InternalException,
			CloudException {
		return support.listProducts(machineImageId);
	}

	@Override
	public AsyncResult<Iterable<VirtualMachineProduct>> listProducts(String machineImageId,
			VirtualMachineProductFilterOptions options) throws InternalException, CloudException {
		return support.listProducts(machineImageId, options);
	}

	@Override
	public AsyncResult<Iterable<VirtualMachineProduct>> listProducts(VirtualMachineProductFilterOptions options)
			throws InternalException, CloudException {
		return support.listProducts(options);
	}

	@Override
	public AsyncResult<Iterable<VirtualMachineProduct>> listAllProducts() throws InternalException, CloudException {
		return support.listAllProducts();
	}

	@Override
	public AsyncResult<Iterable<SpotPriceHistory>> listSpotPriceHistories(SpotPriceHistoryFilterOptions options)
			throws CloudException, InternalException {
		return support.listSpotPriceHistories(options);
	}

	@Override
	public AsyncResult<Iterable<SpotVirtualMachineRequest>> listSpotVirtualMachineRequests(
			SpotVirtualMachineRequestFilterOptions options) throws CloudException, InternalException {
		return support.listSpotVirtualMachineRequests(options);
	}

	@Override
	public AsyncResult<Iterable<ResourceStatus>> listVirtualMachineStatus() throws InternalException, CloudException {
		return support.listVirtualMachineStatus();
	}

	@Override
	public AsyncResult<Iterable<VirtualMachine>> listVirtualMachines() throws InternalException, CloudException {
		return support.listVirtualMachines();
	}

	@Override
	public AsyncResult<Iterable<VirtualMachine>> listVirtualMachines(VMFilterOptions options) throws InternalException,
			CloudException {
		return support.listVirtualMachines(options);
	}

	@Override
	public AsyncResult<Void> pause(String vmId) throws InternalException, CloudException {
		return support.pause(vmId);
	}

	@Override
	public AsyncResult<Void> reboot(String vmId) throws CloudException, InternalException {
		return support.reboot(vmId);
	}

	@Override
	public AsyncResult<Void> resume(String vmId) throws CloudException, InternalException {
		return support.resume(vmId);
	}

	@Override
	public AsyncResult<Void> start(String vmId) throws InternalException, CloudException {
		return support.start(vmId);
	}

	@Override
	public AsyncResult<Void> stop(String vmId) throws InternalException, CloudException {
		return support.stop(vmId);
	}

	@Override
	public AsyncResult<Void> stop(String vmId, boolean force) throws InternalException, CloudException {
		return support.stop(vmId, force);
	}

	@Override
	public AsyncResult<Void> suspend(String vmId) throws CloudException, InternalException {
		return support.suspend(vmId);
	}

	@Override
	public AsyncResult<Void> terminate(String vmId) throws InternalException, CloudException {
		return support.terminate(vmId);
	}

	@Override
	public AsyncResult<Void> terminate(String vmId, String explanation) throws InternalException, CloudException {
		return support.terminate(vmId, explanation);
	}

	@Override
	public AsyncResult<Void> unpause(String vmId) throws CloudException, InternalException {
		return support.unpause(vmId);
	}

	@Override
	public AsyncResult<Void> updateTags(String vmId, Tag... tags) throws CloudException, InternalException {
		return support.updateTags(vmId, tags);
	}

	@Override
	public AsyncResult<Void> updateTags(String[] vmIds, Tag... tags) throws CloudException, InternalException {
		return support.updateTags(vmIds, tags);
	}

	@Override
	public AsyncResult<Void> setTags(String vmId, Tag... tags) throws CloudException, InternalException {
		return support.setTags(vmId, tags);
	}

	@Override
	public AsyncResult<Void> setTags(String[] vmIds, Tag... tags) throws CloudException, InternalException {
		return support.setTags(vmIds, tags);
	}

	@Override
	public AsyncResult<Void> removeTags(String vmId, Tag... tags) throws CloudException, InternalException {
		return support.removeTags(vmId, tags);
	}

	@Override
	public AsyncResult<Void> removeTags(String[] vmIds, Tag... tags) throws CloudException, InternalException {
		return support.removeTags(vmIds, tags);
	}

	@Override
	public SkyportVirtualMachineSupport getSupport() {
		return support.getSupport();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.infinities.skyport.async.service.compute.AsyncVirtualMachineSupport
	 * #listNovaStyleVirtualMachines()
	 */
	@Override
	public AsyncResult<Iterable<NovaStyleVirtualMachine>> listNovaStyleVirtualMachines() throws InternalException,
			CloudException {
		return support.listNovaStyleVirtualMachines();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.infinities.skyport.async.service.compute.AsyncVirtualMachineSupport
	 * #listMinimalVirtualMachines()
	 */
	@Override
	public AsyncResult<Iterable<MinimalResource>> listMinimalVirtualMachines() throws InternalException, CloudException {
		return support.listMinimalVirtualMachines();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.infinities.skyport.async.service.compute.AsyncVirtualMachineSupport
	 * #updateVirtualMachine(java.lang.String,
	 * com.infinities.skyport.compute.VMUpdateOptions)
	 */
	@Override
	public AsyncResult<VirtualMachine> updateVirtualMachine(String virtualMachineId, VMUpdateOptions options)
			throws InternalException, CloudException {
		return support.updateVirtualMachine(virtualMachineId, options);
	}

}
