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
package com.infinities.skyport.model.configuration.service;

import java.io.Serializable;

import com.infinities.skyport.model.configuration.compute.AffinityGroupConfiguration;
import com.infinities.skyport.model.configuration.compute.AutoScalingConfiguration;
import com.infinities.skyport.model.configuration.compute.MachineImageConfiguration;
import com.infinities.skyport.model.configuration.compute.SnapshotConfiguration;
import com.infinities.skyport.model.configuration.compute.VirtualMachineConfiguration;
import com.infinities.skyport.model.configuration.compute.VolumeConfiguration;

public class ComputeConfiguration implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private VirtualMachineConfiguration virtualMachineConfiguration = new VirtualMachineConfiguration();
	private AffinityGroupConfiguration affinityGroupConfiguration = new AffinityGroupConfiguration();
	private AutoScalingConfiguration autoScalingConfiguration = new AutoScalingConfiguration();
	private MachineImageConfiguration machineImageConfiguration = new MachineImageConfiguration();
	private SnapshotConfiguration snapshotConfiguration = new SnapshotConfiguration();
	private VolumeConfiguration volumeConfiguration = new VolumeConfiguration();


	public VirtualMachineConfiguration getVirtualMachineConfiguration() {
		return virtualMachineConfiguration;
	}

	public void setVirtualMachineConfiguration(VirtualMachineConfiguration virtualMachineConfiguration) {
		this.virtualMachineConfiguration = virtualMachineConfiguration;
	}

	public AffinityGroupConfiguration getAffinityGroupConfiguration() {
		return affinityGroupConfiguration;
	}

	public void setAffinityGroupConfiguration(AffinityGroupConfiguration affinityGroupConfiguration) {
		this.affinityGroupConfiguration = affinityGroupConfiguration;
	}

	public AutoScalingConfiguration getAutoScalingConfiguration() {
		return autoScalingConfiguration;
	}

	public void setAutoScalingConfiguration(AutoScalingConfiguration autoScalingConfiguration) {
		this.autoScalingConfiguration = autoScalingConfiguration;
	}

	public MachineImageConfiguration getMachineImageConfiguration() {
		return machineImageConfiguration;
	}

	public void setMachineImageConfiguration(MachineImageConfiguration machineImageConfiguration) {
		this.machineImageConfiguration = machineImageConfiguration;
	}

	public SnapshotConfiguration getSnapshotConfiguration() {
		return snapshotConfiguration;
	}

	public void setSnapshotConfiguration(SnapshotConfiguration snapshotConfiguration) {
		this.snapshotConfiguration = snapshotConfiguration;
	}

	public VolumeConfiguration getVolumeConfiguration() {
		return volumeConfiguration;
	}

	public void setVolumeConfiguration(VolumeConfiguration volumeConfiguration) {
		this.volumeConfiguration = volumeConfiguration;
	}

	@Override
	public ComputeConfiguration clone() {
		ComputeConfiguration clone = new ComputeConfiguration();
		clone.setAffinityGroupConfiguration(getAffinityGroupConfiguration().clone());
		clone.setAutoScalingConfiguration(getAutoScalingConfiguration().clone());
		clone.setMachineImageConfiguration(getMachineImageConfiguration().clone());
		clone.setSnapshotConfiguration(getSnapshotConfiguration().clone());
		clone.setVirtualMachineConfiguration(getVirtualMachineConfiguration().clone());
		clone.setVolumeConfiguration(getVolumeConfiguration().clone());
		return clone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((affinityGroupConfiguration == null) ? 0 : affinityGroupConfiguration.hashCode());
		result = prime * result + ((autoScalingConfiguration == null) ? 0 : autoScalingConfiguration.hashCode());
		result = prime * result + ((machineImageConfiguration == null) ? 0 : machineImageConfiguration.hashCode());
		result = prime * result + ((snapshotConfiguration == null) ? 0 : snapshotConfiguration.hashCode());
		result = prime * result + ((virtualMachineConfiguration == null) ? 0 : virtualMachineConfiguration.hashCode());
		result = prime * result + ((volumeConfiguration == null) ? 0 : volumeConfiguration.hashCode());
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
		ComputeConfiguration other = (ComputeConfiguration) obj;
		if (affinityGroupConfiguration == null) {
			if (other.affinityGroupConfiguration != null)
				return false;
		} else if (!affinityGroupConfiguration.equals(other.affinityGroupConfiguration))
			return false;
		if (autoScalingConfiguration == null) {
			if (other.autoScalingConfiguration != null)
				return false;
		} else if (!autoScalingConfiguration.equals(other.autoScalingConfiguration))
			return false;
		if (machineImageConfiguration == null) {
			if (other.machineImageConfiguration != null)
				return false;
		} else if (!machineImageConfiguration.equals(other.machineImageConfiguration))
			return false;
		if (snapshotConfiguration == null) {
			if (other.snapshotConfiguration != null)
				return false;
		} else if (!snapshotConfiguration.equals(other.snapshotConfiguration))
			return false;
		if (virtualMachineConfiguration == null) {
			if (other.virtualMachineConfiguration != null)
				return false;
		} else if (!virtualMachineConfiguration.equals(other.virtualMachineConfiguration))
			return false;
		if (volumeConfiguration == null) {
			if (other.volumeConfiguration != null)
				return false;
		} else if (!volumeConfiguration.equals(other.volumeConfiguration))
			return false;
		return true;
	}

}
