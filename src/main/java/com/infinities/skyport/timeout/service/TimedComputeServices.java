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
package com.infinities.skyport.timeout.service;

import java.util.concurrent.ExecutorService;

import org.dasein.cloud.compute.AffinityGroupSupport;
import org.dasein.cloud.compute.AutoScalingSupport;
import org.dasein.cloud.compute.MachineImageSupport;
import org.dasein.cloud.compute.SnapshotSupport;
import org.dasein.cloud.compute.VolumeSupport;

import com.infinities.skyport.compute.SkyportComputeServices;
import com.infinities.skyport.compute.SkyportVirtualMachineSupport;
import com.infinities.skyport.exception.InitializationException;
import com.infinities.skyport.model.configuration.service.ComputeConfiguration;
import com.infinities.skyport.timeout.ServiceProviderTimeLimiter;

public class TimedComputeServices implements SkyportComputeServices {

	private SkyportComputeServices inner;
	private AffinityGroupSupport timedAffinityGroupSupport;
	private AutoScalingSupport timedAutoScalingSupport;
	private MachineImageSupport timedMachineImageSupport;
	private SnapshotSupport timedSnapshotSupport;
	private SkyportVirtualMachineSupport timedVirtualMachineSupport;
	private VolumeSupport timedVolumeSupport;


	public TimedComputeServices(SkyportComputeServices inner, ComputeConfiguration computeConfiguration,
			ExecutorService executor) throws InitializationException {
		this.inner = inner;
		ServiceProviderTimeLimiter timedLimiter = new ServiceProviderTimeLimiter(executor);
		if (inner.hasAffinityGroupSupport()) {
			this.timedAffinityGroupSupport = timedLimiter.newProxy(inner.getAffinityGroupSupport(),
					AffinityGroupSupport.class, computeConfiguration.getAffinityGroupConfiguration());
		}
		if (inner.hasAutoScalingSupport()) {
			this.timedAutoScalingSupport = timedLimiter.newProxy(inner.getAutoScalingSupport(), AutoScalingSupport.class,
					computeConfiguration.getAutoScalingConfiguration());
		}
		if (inner.hasImageSupport()) {
			this.timedMachineImageSupport = timedLimiter.newProxy(inner.getImageSupport(), MachineImageSupport.class,
					computeConfiguration.getMachineImageConfiguration());
		}
		if (inner.hasSnapshotSupport()) {
			this.timedSnapshotSupport = timedLimiter.newProxy(inner.getSnapshotSupport(), SnapshotSupport.class,
					computeConfiguration.getSnapshotConfiguration());
		}
		if (inner.hasVirtualMachineSupport()) {
			this.timedVirtualMachineSupport = timedLimiter.newProxy(inner.getSkyportVirtualMachineSupport(),
					SkyportVirtualMachineSupport.class, computeConfiguration.getVirtualMachineConfiguration());
		}
		if (inner.hasVolumeSupport()) {
			this.timedVolumeSupport = timedLimiter.newProxy(inner.getVolumeSupport(), VolumeSupport.class,
					computeConfiguration.getVolumeConfiguration());
		}
	}

	@Override
	public AffinityGroupSupport getAffinityGroupSupport() {
		return this.timedAffinityGroupSupport;
	}

	@Override
	public AutoScalingSupport getAutoScalingSupport() {
		return this.timedAutoScalingSupport;
	}

	@Override
	public MachineImageSupport getImageSupport() {
		return this.timedMachineImageSupport;
	}

	@Override
	public SnapshotSupport getSnapshotSupport() {
		return this.timedSnapshotSupport;
	}

	@Override
	public SkyportVirtualMachineSupport getSkyportVirtualMachineSupport() {
		return this.timedVirtualMachineSupport;
	}

	@Override
	public VolumeSupport getVolumeSupport() {
		return this.timedVolumeSupport;
	}

	@Override
	public boolean hasAffinityGroupSupport() {
		return inner.hasAffinityGroupSupport();
	}

	@Override
	public boolean hasAutoScalingSupport() {
		return inner.hasAutoScalingSupport();
	}

	@Override
	public boolean hasImageSupport() {
		return inner.hasImageSupport();
	}

	@Override
	public boolean hasSnapshotSupport() {
		return inner.hasSnapshotSupport();
	}

	@Override
	public boolean hasVirtualMachineSupport() {
		return inner.hasVirtualMachineSupport();
	}

	@Override
	public boolean hasVolumeSupport() {
		return inner.hasVolumeSupport();
	}

}
