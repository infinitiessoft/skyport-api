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
package com.infinities.skyport.async.service;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.dasein.cloud.CloudException;
import org.dasein.cloud.InternalException;
import org.dasein.cloud.dc.DataCenter;
import org.dasein.cloud.dc.DataCenterCapabilities;
import org.dasein.cloud.dc.Folder;
import org.dasein.cloud.dc.Region;
import org.dasein.cloud.dc.ResourcePool;
import org.dasein.cloud.dc.StoragePool;

import com.infinities.skyport.async.AsyncResult;

public interface AsyncDataCenterServices {

	/**
	 * Provides access to meta-data about region capabilities in this cloud.
	 *
	 * @return a description of the features supported by this region of this
	 *         cloud
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 */
	public @Nonnull DataCenterCapabilities getCapabilities() throws InternalException, CloudException;

	/**
	 * Provides access to the full data center information for the specified
	 * data center.
	 * 
	 * @param providerDataCenterId
	 *            the provider-specific identifier that the provider uses to
	 *            identify the data center
	 * @return the current state of the desired data center
	 * @throws InternalException
	 *             an error occurred locally in processing the request
	 * @throws CloudException
	 *             an error occurred within the cloud provider or the cloud
	 *             provider did not approve of the request
	 */
	public @Nullable AsyncResult<DataCenter> getDataCenter(@Nonnull String providerDataCenterId) throws InternalException,
			CloudException;

	/**
	 * Provides the region matching the specified region ID.
	 * 
	 * @param providerRegionId
	 *            the provider-specified unique ID that identifies a region for
	 *            the provider
	 * @return the current state of the desired region
	 * @throws InternalException
	 *             an error occurred locally in processing the request
	 * @throws CloudException
	 *             an error occurred within the cloud provider or the cloud
	 *             provider did not approve of the request
	 */
	public @Nullable AsyncResult<Region> getRegion(@Nonnull String providerRegionId) throws InternalException,
			CloudException;

	/**
	 * Lists all data centers, active and inactive, available and unavailable,
	 * for the specified region.
	 * 
	 * @param providerRegionId
	 *            the region in which you are searching for data centers
	 * @return the complete list of data centers for the region
	 * @throws InternalException
	 *             an error occurred locally in processing the request
	 * @throws CloudException
	 *             an error occurred within the cloud provider or the cloud
	 *             provider did not approve of the request
	 */
	public @Nonnull AsyncResult<Iterable<DataCenter>> listDataCenters(@Nonnull String providerRegionId)
			throws InternalException, CloudException;

	/**
	 * Lists all regions, active and inactive, available and unavailable.
	 * 
	 * @return all regions supported for this cloud in any context
	 * @throws InternalException
	 *             an error occurred locally in processing the request
	 * @throws CloudException
	 *             an error occurred within the cloud provider or the cloud
	 *             provider did not approve of the request
	 */
	public @Nonnull AsyncResult<Iterable<Region>> listRegions() throws InternalException, CloudException;

	/**
	 * Lists all resource pools
	 *
	 * @param providerDataCenterId
	 *            the datacenter in which you are searching for resource pools
	 * @return all resource pools supported for this cloud in the given
	 *         datacenter
	 * @throws InternalException
	 *             an error occurred locally in processing the request
	 * @throws CloudException
	 *             an error occurred within the cloud provider or the cloud
	 *             provider did not approve of the request
	 */
	public @Nonnull AsyncResult<Iterable<ResourcePool>> listResourcePools(@Nonnull String providerDataCenterId)
			throws InternalException, CloudException;

	/**
	 * Provides access to the full resource pool information for the specified
	 * resource pool.
	 * 
	 * @param providerResourcePoolId
	 *            the provider-specific identifier that the provider uses to
	 *            identify the resource pool
	 * @return the current state of the desired resource pool
	 * @throws InternalException
	 *             an error occurred locally in processing the request
	 * @throws CloudException
	 *             an error occurred within the cloud provider or the cloud
	 *             provider did not approve of the request
	 */
	public @Nullable AsyncResult<ResourcePool> getResourcePool(@Nonnull String providerResourcePoolId)
			throws InternalException, CloudException;

	/**
	 * Lists all storage pools
	 *
	 * @return all storage pools supported for this cloud in the context region
	 * @throws InternalException
	 *             an error occurred locally in processing the request
	 * @throws CloudException
	 *             an error occurred within the cloud provider or the cloud
	 *             provider did not approve of the request
	 */
	public @Nonnull AsyncResult<Iterable<StoragePool>> listStoragePools() throws InternalException, CloudException;

	/**
	 * Provides access to the full storage pool information for the specified
	 * storage pool
	 *
	 * @param providerStoragePoolId
	 *            the provider-specific identifier that the provider uses to
	 *            identify the storage pool
	 * @return the Storage Pool object with the specified id
	 * @throws InternalException
	 *             an error occurred locally in processing the request
	 * @throws CloudException
	 *             an error occurred within the cloud provider or the cloud
	 *             provider did not approve of the request
	 */
	public @Nullable AsyncResult<StoragePool> getStoragePool(@Nonnull String providerStoragePoolId)
			throws InternalException, CloudException;

	/**
	 * Lists all vm folders
	 *
	 * @return all vm folders supported for this cloud in the context region
	 * @throws InternalException
	 *             an error occurred locally in processing the request
	 * @throws CloudException
	 *             an error occurred within the cloud provider or the cloud
	 *             provider did not approve of the request
	 */
	public @Nonnull AsyncResult<Iterable<Folder>> listVMFolders() throws InternalException, CloudException;

	/**
	 * Provides access to the full vm folder information for the specified vm
	 * folder
	 *
	 * @param providerVMFolderId
	 *            the provider-specific identifier that the provider uses to
	 *            identify the vm folder
	 * @return the vm folder object with the specified id
	 * @throws InternalException
	 *             an error occurred locally in processing the request
	 * @throws CloudException
	 *             an error occurred within the cloud provider or the cloud
	 *             provider did not approve of the request
	 */
	public @Nullable AsyncResult<Folder> getVMFolder(@Nonnull String providerVMFolderId) throws InternalException,
			CloudException;
}
