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
package com.infinities.skyport.async.service.compute;

import javax.annotation.Nonnull;

import org.dasein.cloud.AccessControlledService;
import org.dasein.cloud.CloudException;
import org.dasein.cloud.InternalException;
import org.dasein.cloud.compute.AffinityGroup;
import org.dasein.cloud.compute.AffinityGroupCreateOptions;
import org.dasein.cloud.compute.AffinityGroupFilterOptions;
import org.dasein.cloud.compute.AffinityGroupSupport;

import com.infinities.skyport.async.AsyncResult;

public interface AsyncAffinityGroupSupport extends AccessControlledService {

	/**
	 * Creates an affinity group in the cloud
	 * 
	 * @param options
	 *            the options used when creating the affinity group
	 * @return the provider ID of the affinity group
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud implementation
	 *             creating the affinity group
	 * @throws CloudException
	 *             an error occurred within the service provider creating the
	 *             affinity group
	 */
	public @Nonnull AsyncResult<AffinityGroup> create(@Nonnull AffinityGroupCreateOptions options) throws InternalException,
			CloudException;

	/**
	 * Deletes the affinity group from the cloud if the affinity group is not
	 * empty this method should error
	 * 
	 * @param affinityGroupId
	 *            the ID of the affinity group to be deleted
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud implementation
	 *             deleting the affinity group
	 * @throws CloudException
	 *             an error occurred within the service provider deleting the
	 *             affinity group
	 */
	public AsyncResult<Void> delete(@Nonnull String affinityGroupId) throws InternalException, CloudException;

	/**
	 * Retrieves the details of the specified Affinity Group from the cloud
	 * 
	 * @param affinityGroupId
	 *            the ID of the affinity group to be retrieved
	 * @return the Dasein AffinityGroup object
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud implementation
	 *             retrieving the affinity group
	 * @throws CloudException
	 *             an error occurred within the service provider retrieving the
	 *             affinity group
	 */
	public @Nonnull AsyncResult<AffinityGroup> get(@Nonnull String affinityGroupId) throws InternalException, CloudException;

	/**
	 * Lists all of the affinity groups visible to the current account
	 * 
	 * @param options
	 *            Filtering options for the list
	 * @return All the affinity groups visible to current account
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud implementation
	 *             listing the affinity groups
	 * @throws CloudException
	 *             an error occurred within the service provider listing the
	 *             affinity groups
	 */
	public @Nonnull AsyncResult<Iterable<AffinityGroup>> list(@Nonnull AffinityGroupFilterOptions options)
			throws InternalException, CloudException;

	/**
	 * Modifies details of the specified affinity group
	 * 
	 * @param affinityGroupId
	 *            the ID of the affinity group to be modified
	 * @param options
	 *            the options containing the modified data
	 * @return the newly modified Dasein AffinityGroup object
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud implementation
	 *             modifying the affinity group
	 * @throws CloudException
	 *             an error occurred within the service provider modifying the
	 *             affinity group
	 */
	public AsyncResult<AffinityGroup> modify(@Nonnull String affinityGroupId, @Nonnull AffinityGroupCreateOptions options)
			throws InternalException, CloudException;

	AffinityGroupSupport getSupport();
}
