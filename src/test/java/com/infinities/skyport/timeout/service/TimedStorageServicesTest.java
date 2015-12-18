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

import org.dasein.cloud.storage.BlobStoreSupport;
import org.dasein.cloud.storage.OfflineStoreSupport;
import org.dasein.cloud.storage.StorageServices;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.concurrent.Synchroniser;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.infinities.skyport.exception.InitializationException;
import com.infinities.skyport.model.configuration.service.StorageConfiguration;

public class TimedStorageServicesTest {

	protected Mockery context = new JUnit4Mockery() {

		{
			setThreadingPolicy(new Synchroniser());
			setImposteriser(ClassImposteriser.INSTANCE);
		}
	};
	private ExecutorService executorService;
	private StorageConfiguration storageConfiguration;
	private StorageServices storageServices;

	private BlobStoreSupport blobStoreSupport;
	private OfflineStoreSupport offlineStoreSupport;


	@Before
	public void setUp() throws Exception {
		storageServices = context.mock(StorageServices.class);
		executorService = context.mock(ExecutorService.class);
		storageConfiguration = new StorageConfiguration();

		blobStoreSupport = context.mock(BlobStoreSupport.class);
		offlineStoreSupport = context.mock(OfflineStoreSupport.class);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testTimedStorageServices() throws InitializationException {
		context.checking(new Expectations() {

			{
				exactly(1).of(storageServices).hasOnlineStorageSupport();
				will(returnValue(true));
				exactly(1).of(storageServices).hasOfflineStorageSupport();
				will(returnValue(true));

				exactly(1).of(storageServices).getOnlineStorageSupport();
				will(returnValue(blobStoreSupport));
				exactly(1).of(storageServices).getOfflineStorageSupport();
				will(returnValue(offlineStoreSupport));

			}
		});
		new TimedStorageServices(storageServices, storageConfiguration, executorService);
	}
}
