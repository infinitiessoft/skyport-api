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

import org.dasein.cloud.admin.AccountSupport;
import org.dasein.cloud.admin.AdminServices;
import org.dasein.cloud.admin.BillingSupport;
import org.dasein.cloud.admin.PrepaymentSupport;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.concurrent.Synchroniser;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.infinities.skyport.exception.InitializationException;
import com.infinities.skyport.model.configuration.service.AdminConfiguration;

public class TimedAdminServicesTest {

	protected Mockery context = new JUnit4Mockery() {

		{
			setThreadingPolicy(new Synchroniser());
			setImposteriser(ClassImposteriser.INSTANCE);
		}
	};
	private ExecutorService executorService;
	private AdminConfiguration adminConfiguration;
	private AdminServices adminServices;

	private PrepaymentSupport prepaymentSupport;
	private AccountSupport accountSupport;
	private BillingSupport billingSupport;


	@Before
	public void setUp() throws Exception {
		adminServices = context.mock(AdminServices.class);
		executorService = context.mock(ExecutorService.class);
		adminConfiguration = new AdminConfiguration();

		prepaymentSupport = context.mock(PrepaymentSupport.class);
		accountSupport = context.mock(AccountSupport.class);
		billingSupport = context.mock(BillingSupport.class);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testTimedAdminServices() throws InitializationException {
		context.checking(new Expectations() {

			{
				exactly(1).of(adminServices).getPrepaymentSupport();
				will(returnValue(prepaymentSupport));
				exactly(1).of(adminServices).getAccountSupport();
				will(returnValue(accountSupport));
				exactly(1).of(adminServices).getBillingSupport();
				will(returnValue(billingSupport));

			}
		});
		new TimedAdminServices(adminServices, adminConfiguration, executorService);
	}

}
