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

import com.infinities.skyport.exception.InitializationException;
import com.infinities.skyport.model.configuration.service.StorageConfiguration;
import com.infinities.skyport.timeout.ServiceProviderTimeLimiter;

public class TimedStorageServices implements StorageServices {

	private final StorageServices inner;
	private OfflineStoreSupport timedOfflineStoreSupport;
	private BlobStoreSupport timedOnlineStorageSupport;


	public TimedStorageServices(StorageServices inner, StorageConfiguration storageConfiguration, ExecutorService executor)
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
					timedLimiter.newProxy(inner.getOnlineStorageSupport(), BlobStoreSupport.class,
							storageConfiguration.getOnlineStorageConfiguration());
		}
	}

	@Deprecated
	@Override
	public BlobStoreSupport getBlobStoreSupport() {
		return inner.getBlobStoreSupport();
	}

	@Deprecated
	@Override
	public boolean hasBlobStoreSupport() {
		return inner.hasBlobStoreSupport();
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
	public BlobStoreSupport getOnlineStorageSupport() {
		return this.timedOnlineStorageSupport;
	}

	@Override
	public boolean hasOnlineStorageSupport() {
		return inner.hasOnlineStorageSupport();
	}

}
