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

import javax.annotation.Nullable;

import com.infinities.skyport.async.service.compute.AsyncAffinityGroupSupport;
import com.infinities.skyport.async.service.compute.AsyncAutoScalingSupport;
import com.infinities.skyport.async.service.compute.AsyncMachineImageSupport;
import com.infinities.skyport.async.service.compute.AsyncSnapshotSupport;
import com.infinities.skyport.async.service.compute.AsyncVirtualMachineSupport;
import com.infinities.skyport.async.service.compute.AsyncVolumeSupport;

public interface AsyncComputeServices {

	/**
	 * @return access to support for affinity groups in the cloud provider
	 */
	public @Nullable AsyncAffinityGroupSupport getAffinityGroupSupport();

	/**
	 * @return access to support for auto-scaling capabilities native to the
	 *         cloud provider
	 */
	public @Nullable AsyncAutoScalingSupport getAutoScalingSupport();

	/**
	 * @return access to support for images/templates in the cloud provider
	 */
	public @Nullable AsyncMachineImageSupport getImageSupport();

	/**
	 * @return access to support for volume snapshots in the cloud provider
	 */
	public @Nullable AsyncSnapshotSupport getSnapshotSupport();

	/**
	 * @return access to support for virtual machines in the cloud provider
	 */
	public @Nullable AsyncVirtualMachineSupport getVirtualMachineSupport();

	/**
	 * @return access to support for volumes in the cloud provider
	 */
	public @Nullable AsyncVolumeSupport getVolumeSupport();

	/**
	 * @return indicates whether or not the cloud provider supports affinity
	 *         groups
	 */
	public boolean hasAffinityGroupSupport();

	/**
	 * @return indicates whether or not the cloud provider supports native
	 *         auto-scaling capabilities
	 */
	public boolean hasAutoScalingSupport();

	/**
	 * @return indicates whether or not the cloud provider supports
	 *         images/templates
	 */
	public boolean hasImageSupport();

	/**
	 * @return indicates whether or not the cloud provider supports snapshotting
	 *         volumes
	 */
	public boolean hasSnapshotSupport();

	/**
	 * @return indicates whether or not the cloud provider supports virtual
	 *         machines
	 */
	public boolean hasVirtualMachineSupport();

	/**
	 * @return indicates whether or not the cloud provider supports block or
	 *         network volumes
	 */
	public boolean hasVolumeSupport();

	void initialize() throws Exception;

	void close();
}
