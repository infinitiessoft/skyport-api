package com.infinities.skyport.timeout.service;

import java.util.concurrent.ExecutorService;

import org.dasein.cloud.compute.AffinityGroupSupport;
import org.dasein.cloud.compute.AutoScalingSupport;
import org.dasein.cloud.compute.ComputeServices;
import org.dasein.cloud.compute.MachineImageSupport;
import org.dasein.cloud.compute.SnapshotSupport;
import org.dasein.cloud.compute.VirtualMachineSupport;
import org.dasein.cloud.compute.VolumeSupport;

import com.infinities.skyport.exception.InitializationException;
import com.infinities.skyport.model.configuration.service.ComputeConfiguration;
import com.infinities.skyport.timeout.ServiceProviderTimeLimiter;

public class TimedComputeServices implements ComputeServices {

	private ComputeServices inner;
	private AffinityGroupSupport timedAffinityGroupSupport;
	private AutoScalingSupport timedAutoScalingSupport;
	private MachineImageSupport timedMachineImageSupport;
	private SnapshotSupport timedSnapshotSupport;
	private VirtualMachineSupport timedVirtualMachineSupport;
	private VolumeSupport timedVolumeSupport;


	public TimedComputeServices(ComputeServices inner, ComputeConfiguration computeConfiguration, ExecutorService executor)
			throws InitializationException {
		this.inner = inner;
		ServiceProviderTimeLimiter timedLimiter = new ServiceProviderTimeLimiter(executor);
		if (inner.hasAffinityGroupSupport()) {
			this.timedAffinityGroupSupport =
					timedLimiter.newProxy(inner.getAffinityGroupSupport(), AffinityGroupSupport.class,
							computeConfiguration.getAffinityGroupConfiguration());
		}
		if (inner.hasAutoScalingSupport()) {
			this.timedAutoScalingSupport =
					timedLimiter.newProxy(inner.getAutoScalingSupport(), AutoScalingSupport.class,
							computeConfiguration.getAutoScalingConfiguration());
		}
		if (inner.hasImageSupport()) {
			this.timedMachineImageSupport =
					timedLimiter.newProxy(inner.getImageSupport(), MachineImageSupport.class,
							computeConfiguration.getMachineImageConfiguration());
		}
		if (inner.hasSnapshotSupport()) {
			this.timedSnapshotSupport =
					timedLimiter.newProxy(inner.getSnapshotSupport(), SnapshotSupport.class,
							computeConfiguration.getSnapshotConfiguration());
		}
		if (inner.hasVirtualMachineSupport()) {
			this.timedVirtualMachineSupport =
					timedLimiter.newProxy(inner.getVirtualMachineSupport(), VirtualMachineSupport.class,
							computeConfiguration.getVirtualMachineConfiguration());
		}
		if (inner.hasVolumeSupport()) {
			this.timedVolumeSupport =
					timedLimiter.newProxy(inner.getVolumeSupport(), VolumeSupport.class,
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
	public VirtualMachineSupport getVirtualMachineSupport() {
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
