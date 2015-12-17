package com.infinities.skyport.timeout.service.concurrent;

import java.util.concurrent.ExecutorService;

import org.apache.commons.lang3.concurrent.ConcurrentException;
import org.apache.commons.lang3.concurrent.LazyInitializer;
import org.dasein.cloud.storage.StorageServices;

import com.infinities.skyport.ServiceProvider;
import com.infinities.skyport.exception.InitializationException;
import com.infinities.skyport.model.configuration.service.StorageConfiguration;
import com.infinities.skyport.timeout.service.TimedStorageServices;

public class TimedStorageServicesLazyInitializer extends LazyInitializer<StorageServices> {

	private ServiceProvider inner;
	private StorageConfiguration computeConfiguration;
	private ExecutorService executor;


	public TimedStorageServicesLazyInitializer(ServiceProvider inner, StorageConfiguration computeConfiguration,
			ExecutorService executor) {
		super();
		this.inner = inner;
		this.computeConfiguration = computeConfiguration;
		this.executor = executor;
	}

	@Override
	protected StorageServices initialize() throws ConcurrentException {
		try {
			if (inner.hasStorageServices()) {
				return new TimedStorageServices(inner.getStorageServices(), computeConfiguration, executor);
			}
		} catch (InitializationException e) {
			throw new ConcurrentException(e);
		}
		return null;
	}

}
