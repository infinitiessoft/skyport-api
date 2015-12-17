package com.infinities.skyport.timeout.service.concurrent;

import java.util.concurrent.ExecutorService;

import org.apache.commons.lang3.concurrent.ConcurrentException;
import org.apache.commons.lang3.concurrent.LazyInitializer;
import org.dasein.cloud.ci.CIServices;

import com.infinities.skyport.ServiceProvider;
import com.infinities.skyport.exception.InitializationException;
import com.infinities.skyport.model.configuration.service.CIConfiguration;
import com.infinities.skyport.timeout.service.TimedCIServices;

public class TimedCIServicesLazyInitializer extends LazyInitializer<CIServices> {

	private ServiceProvider inner;
	private CIConfiguration computeConfiguration;
	private ExecutorService executor;


	public TimedCIServicesLazyInitializer(ServiceProvider inner, CIConfiguration computeConfiguration,
			ExecutorService executor) {
		super();
		this.inner = inner;
		this.computeConfiguration = computeConfiguration;
		this.executor = executor;
	}

	@Override
	protected CIServices initialize() throws ConcurrentException {
		try {
			if (inner.hasCIServices()) {
				return new TimedCIServices(inner.getCIServices(), computeConfiguration, executor);
			}
		} catch (InitializationException e) {
			throw new ConcurrentException(e);
		}
		return null;
	}

}
