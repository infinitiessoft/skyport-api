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

import org.dasein.cloud.platform.CDNSupport;
import org.dasein.cloud.platform.KeyValueDatabaseSupport;
import org.dasein.cloud.platform.MQSupport;
import org.dasein.cloud.platform.MonitoringSupport;
import org.dasein.cloud.platform.PlatformServices;
import org.dasein.cloud.platform.PushNotificationSupport;
import org.dasein.cloud.platform.RelationalDatabaseSupport;
import org.dasein.cloud.platform.bigdata.DataWarehouseSupport;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.concurrent.Synchroniser;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.infinities.skyport.exception.InitializationException;
import com.infinities.skyport.model.configuration.service.PlatformConfiguration;


public class TimedPlatformServicesTest {

	protected Mockery context = new JUnit4Mockery() {

		{
			setThreadingPolicy(new Synchroniser());
			setImposteriser(ClassImposteriser.INSTANCE);
		}
	};
	private ExecutorService executorService;
	private PlatformConfiguration platformConfiguration;
	private PlatformServices platformServices;

	private CDNSupport cdnSupport;
	private DataWarehouseSupport dataWarehouseSupport;
	private KeyValueDatabaseSupport keyValueDatabaseSupport;
	private MQSupport mqSupport;
	private PushNotificationSupport pushNotificationSupport;
	private RelationalDatabaseSupport relationalDatabaseSupport;
	private MonitoringSupport monitoringSupport;
	
	@Before
	public void setUp() throws Exception {
		platformServices = context.mock(PlatformServices.class);
		executorService = context.mock(ExecutorService.class);
		platformConfiguration = new PlatformConfiguration();

		cdnSupport = context.mock(CDNSupport.class);
		dataWarehouseSupport = context.mock(DataWarehouseSupport.class);
		keyValueDatabaseSupport = context.mock(KeyValueDatabaseSupport.class);
		mqSupport = context.mock(MQSupport.class);
		pushNotificationSupport = context.mock(PushNotificationSupport.class);
		relationalDatabaseSupport = context.mock(RelationalDatabaseSupport.class);
		monitoringSupport = context.mock(MonitoringSupport.class);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testTimedPlatformServices() throws InitializationException {
		context.checking(new Expectations() {

			{
				exactly(1).of(platformServices).getCDNSupport();
				will(returnValue(cdnSupport));
				exactly(1).of(platformServices).getDataWarehouseSupport();
				will(returnValue(dataWarehouseSupport));
				exactly(1).of(platformServices).getKeyValueDatabaseSupport();
				will(returnValue(keyValueDatabaseSupport));
				exactly(1).of(platformServices).getMessageQueueSupport();
				will(returnValue(mqSupport));
				exactly(1).of(platformServices).getPushNotificationSupport();
				will(returnValue(pushNotificationSupport));
				exactly(1).of(platformServices).getRelationalDatabaseSupport();
				will(returnValue(relationalDatabaseSupport));
				exactly(1).of(platformServices).getMonitoringSupport();
				will(returnValue(monitoringSupport));

			}
		});
		new TimedPlatformServices(platformServices, platformConfiguration, executorService);
	}
}
