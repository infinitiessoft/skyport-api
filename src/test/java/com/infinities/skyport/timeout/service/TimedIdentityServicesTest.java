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

import org.dasein.cloud.identity.IdentityAndAccessSupport;
import org.dasein.cloud.identity.IdentityServices;
import org.dasein.cloud.identity.ShellKeySupport;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.concurrent.Synchroniser;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.infinities.skyport.exception.InitializationException;
import com.infinities.skyport.model.configuration.service.IdentityConfiguration;

public class TimedIdentityServicesTest {

	protected Mockery context = new JUnit4Mockery() {

		{
			setThreadingPolicy(new Synchroniser());
			setImposteriser(ClassImposteriser.INSTANCE);
		}
	};

	private ExecutorService executorService;
	private IdentityConfiguration identityConfiguration;
	private IdentityServices identityServices;

	private IdentityAndAccessSupport identityAndAccessSupport;
	private ShellKeySupport shellKeySupport;


	@Before
	public void setUp() {
		identityServices = context.mock(IdentityServices.class);
		executorService = context.mock(ExecutorService.class);
		identityConfiguration = new IdentityConfiguration();

		identityAndAccessSupport = context.mock(IdentityAndAccessSupport.class);
		shellKeySupport = context.mock(ShellKeySupport.class);
	}

	@After
	public void tearDown() {

	}

	@Test
	public void testTimedIdentityServices() throws InitializationException {
		context.checking(new Expectations() {

			{
				exactly(1).of(identityServices).hasIdentityAndAccessSupport();
				will(returnValue(true));
				exactly(1).of(identityServices).hasShellKeySupport();
				will(returnValue(true));

				exactly(1).of(identityServices).getIdentityAndAccessSupport();
				will(returnValue(identityAndAccessSupport));
				exactly(1).of(identityServices).getShellKeySupport();
				will(returnValue(shellKeySupport));
			}
		});
		new TimedIdentityServices(identityServices, identityConfiguration, executorService);
	}
}
