package com.infinities.skyport.timeout.service.concurrent;

import java.util.concurrent.ExecutorService;

import org.apache.commons.lang3.concurrent.ConcurrentException;
import org.apache.commons.lang3.concurrent.LazyInitializer;
import org.dasein.cloud.compute.ComputeServices;

import com.infinities.skyport.ServiceProvider;
import com.infinities.skyport.exception.InitializationException;
import com.infinities.skyport.model.configuration.service.ComputeConfiguration;
import com.infinities.skyport.timeout.service.TimedComputeServices;

public class TimedComputeServicesLazyInitializer extends LazyInitializer<ComputeServices> {

	private ServiceProvider inner;
	private ComputeConfiguration computeConfiguration;
	private ExecutorService executor;


	public TimedComputeServicesLazyInitializer(ServiceProvider inner, ComputeConfiguration computeConfiguration,
			ExecutorService executor) {
		super();
		this.inner = inner;
		this.computeConfiguration = computeConfiguration;
		this.executor = executor;
	}

	@Override
	protected ComputeServices initialize() throws ConcurrentException {
		try {
			if (inner.hasComputeServices()) {
				return new TimedComputeServices(inner.getComputeServices(), computeConfiguration, executor);
			}
		} catch (InitializationException e) {
			throw new ConcurrentException(e);
		}
		return null;
	}

}
