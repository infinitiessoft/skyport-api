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
