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
import org.dasein.cloud.compute.ComputeServices;
import org.dasein.cloud.compute.MachineImageSupport;
import org.dasein.cloud.compute.SnapshotSupport;
import org.dasein.cloud.compute.VirtualMachineSupport;
import org.dasein.cloud.compute.VolumeSupport;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.concurrent.Synchroniser;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.infinities.skyport.exception.InitializationException;
import com.infinities.skyport.model.configuration.service.ComputeConfiguration;

public class TimedComputeServicesTest {

	protected Mockery context = new JUnit4Mockery() {

		{
			setThreadingPolicy(new Synchroniser());
			setImposteriser(ClassImposteriser.INSTANCE);
		}
	};

	private ExecutorService executorService;
	private ComputeServices computeServices;
	private ComputeConfiguration configuration;

	private AffinityGroupSupport affinityGroupSupport;
	private AutoScalingSupport autoScalingSupport;
	private MachineImageSupport machineImageSupport;
	private SnapshotSupport snapshotSupport;
	private VirtualMachineSupport virtualMachineSupport;
	private VolumeSupport volumeSupport;


	@Before
	public void setUp() {
		computeServices = context.mock(ComputeServices.class);
		executorService = context.mock(ExecutorService.class);
		configuration = new ComputeConfiguration();

		affinityGroupSupport = context.mock(AffinityGroupSupport.class);
		autoScalingSupport = context.mock(AutoScalingSupport.class);
		machineImageSupport = context.mock(MachineImageSupport.class);
		snapshotSupport = context.mock(SnapshotSupport.class);
		virtualMachineSupport = context.mock(VirtualMachineSupport.class);
		volumeSupport = context.mock(VolumeSupport.class);
	}

	@After
	public void tearDown() {
	}

	@Test
	public void testTimedComputeServices() throws InitializationException {
		context.checking(new Expectations() {

			{
				exactly(1).of(computeServices).hasAffinityGroupSupport();
				will(returnValue(true));
				exactly(1).of(computeServices).hasAutoScalingSupport();
				will(returnValue(true));
				exactly(1).of(computeServices).hasImageSupport();
				will(returnValue(true));
				exactly(1).of(computeServices).hasSnapshotSupport();
				will(returnValue(true));
				exactly(1).of(computeServices).hasVirtualMachineSupport();
				will(returnValue(true));
				exactly(1).of(computeServices).hasVolumeSupport();
				will(returnValue(true));

				exactly(1).of(computeServices).getAffinityGroupSupport();
				will(returnValue(affinityGroupSupport));
				exactly(1).of(computeServices).getAutoScalingSupport();
				will(returnValue(autoScalingSupport));
				exactly(1).of(computeServices).getImageSupport();
				will(returnValue(machineImageSupport));
				exactly(1).of(computeServices).getSnapshotSupport();
				will(returnValue(snapshotSupport));
				exactly(1).of(computeServices).getVirtualMachineSupport();
				will(returnValue(virtualMachineSupport));
				exactly(1).of(computeServices).getVolumeSupport();
				will(returnValue(volumeSupport));
			}
		});
		new TimedComputeServices(computeServices, configuration, executorService);
	}
}
