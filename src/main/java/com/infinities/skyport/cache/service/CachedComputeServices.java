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
