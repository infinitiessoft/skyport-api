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

import org.dasein.cloud.ci.CIServices;
import org.dasein.cloud.ci.ConvergedHttpLoadBalancerSupport;
import org.dasein.cloud.ci.ConvergedInfrastructureSupport;
import org.dasein.cloud.ci.TopologySupport;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.concurrent.Synchroniser;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.infinities.skyport.exception.InitializationException;
import com.infinities.skyport.model.configuration.service.CIConfiguration;

public class TimedCIServicesTest {

	protected Mockery context = new JUnit4Mockery() {

		{
			setThreadingPolicy(new Synchroniser());
			setImposteriser(ClassImposteriser.INSTANCE);
		}
	};
	private ExecutorService executorService;
	private CIServices ciServices;
	private CIConfiguration configuration;
	private ConvergedInfrastructureSupport convergedInfrastructureSupport;
	private ConvergedHttpLoadBalancerSupport convergedHttpLoadBalancerSupport;
	private TopologySupport topologySupport;


	@Before
	public void setUp() throws Exception {
		executorService = context.mock(ExecutorService.class);
		configuration = new CIConfiguration();
		ciServices = context.mock(CIServices.class);

		convergedInfrastructureSupport = context.mock(ConvergedInfrastructureSupport.class);
		convergedHttpLoadBalancerSupport = context.mock(ConvergedHttpLoadBalancerSupport.class);
		topologySupport = context.mock(TopologySupport.class);

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testTimedCIServices() throws InitializationException {
		context.checking(new Expectations() {

			{
				exactly(1).of(ciServices).getConvergedHttpLoadBalancerSupport();
				will(returnValue(convergedHttpLoadBalancerSupport));
				exactly(1).of(ciServices).getConvergedInfrastructureSupport();
				will(returnValue(convergedInfrastructureSupport));
				exactly(1).of(ciServices).getTopologySupport();
				will(returnValue(topologySupport));

			}
		});
		new TimedCIServices(ciServices, configuration, executorService);
	}

}
