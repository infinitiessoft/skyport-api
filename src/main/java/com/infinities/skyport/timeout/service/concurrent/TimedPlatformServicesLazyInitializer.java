package com.infinities.skyport.timeout.service.concurrent;

import java.util.concurrent.ExecutorService;

import org.apache.commons.lang3.concurrent.ConcurrentException;
import org.apache.commons.lang3.concurrent.LazyInitializer;
import org.dasein.cloud.platform.PlatformServices;

import com.infinities.skyport.ServiceProvider;
import com.infinities.skyport.exception.InitializationException;
import com.infinities.skyport.model.configuration.service.PlatformConfiguration;
import com.infinities.skyport.timeout.service.TimedPlatformServices;

public class TimedPlatformServicesLazyInitializer extends LazyInitializer<PlatformServices> {

	private ServiceProvider inner;
	private PlatformConfiguration computeConfiguration;
	private ExecutorService executor;


	public TimedPlatformServicesLazyInitializer(ServiceProvider inner, PlatformConfiguration computeConfiguration,
			ExecutorService executor) {
		super();
		this.inner = inner;
		this.computeConfiguration = computeConfiguration;
		this.executor = executor;
	}

	@Override
	protected PlatformServices initialize() throws ConcurrentException {
		try {
			if (inner.hasPlatformServices()) {
				return new TimedPlatformServices(inner.getPlatformServices(), computeConfiguration, executor);
			}
		} catch (InitializationException e) {
			throw new ConcurrentException(e);
		}
		return null;
	}

}
