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

import org.dasein.cloud.storage.OfflineStoreSupport;

import com.infinities.skyport.exception.InitializationException;
import com.infinities.skyport.model.configuration.service.StorageConfiguration;
import com.infinities.skyport.storage.SkyportBlobStoreSupport;
import com.infinities.skyport.storage.SkyportStorageServices;
import com.infinities.skyport.timeout.ServiceProviderTimeLimiter;

public class TimedStorageServices implements SkyportStorageServices {

	private final SkyportStorageServices inner;
	private OfflineStoreSupport timedOfflineStoreSupport;
	private SkyportBlobStoreSupport timedOnlineStorageSupport;


	public TimedStorageServices(SkyportStorageServices inner, StorageConfiguration storageConfiguration, ExecutorService executor)
			throws InitializationException {
		this.inner = inner;
		ServiceProviderTimeLimiter timedLimiter = new ServiceProviderTimeLimiter(executor);
		if (inner.hasOfflineStorageSupport()) {
			this.timedOfflineStoreSupport =
					timedLimiter.newProxy(inner.getOfflineStorageSupport(), OfflineStoreSupport.class,
							storageConfiguration.getOfflineStoreConfiguration());
		}
		if (inner.hasOnlineStorageSupport()) {
			this.timedOnlineStorageSupport =
					timedLimiter.newProxy(inner.getSkyportOnlineStorageSupport(), SkyportBlobStoreSupport.class,
							storageConfiguration.getOnlineStorageConfiguration());
		}
	}

	@Override
	public OfflineStoreSupport getOfflineStorageSupport() {
		return this.timedOfflineStoreSupport;
	}

	@Override
	public boolean hasOfflineStorageSupport() {
		return inner.hasOfflineStorageSupport();
	}

	@Override
	public SkyportBlobStoreSupport getSkyportOnlineStorageSupport() {
		return this.timedOnlineStorageSupport;
	}

	@Override
	public boolean hasOnlineStorageSupport() {
		return inner.hasOnlineStorageSupport();
	}

}
