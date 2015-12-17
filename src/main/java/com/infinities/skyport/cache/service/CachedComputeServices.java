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
package com.infinities.skyport.cache.service;

import java.io.Serializable;
import java.util.concurrent.ScheduledFuture;

import javax.annotation.Nullable;

import com.infinities.skyport.async.service.AsyncComputeServices;
import com.infinities.skyport.cache.service.compute.CachedMachineImageSupport;
import com.infinities.skyport.cache.service.compute.CachedSnapshotSupport;
import com.infinities.skyport.cache.service.compute.CachedVirtualMachineSupport;
import com.infinities.skyport.cache.service.compute.CachedVolumeSupport;

public interface CachedComputeServices extends AsyncComputeServices {

	public static enum ComputeQuartzType implements Serializable {
		VirtualMachine, VirtualMachineProduct, MachineImage, Snapshot, Volume, VolumeProduct;
	}


	@Override
	public @Nullable CachedVirtualMachineSupport getVirtualMachineSupport();

	@Override
	public @Nullable CachedMachineImageSupport getImageSupport();

	@Override
	public @Nullable CachedSnapshotSupport getSnapshotSupport();

	@Override
	public @Nullable CachedVolumeSupport getVolumeSupport();

	public ScheduledFuture<?> flushCache(ComputeQuartzType type);

}
