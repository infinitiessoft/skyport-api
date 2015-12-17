package com.infinities.skyport.timeout.service.concurrent;

import java.util.concurrent.ExecutorService;

import org.apache.commons.lang3.concurrent.ConcurrentException;
import org.apache.commons.lang3.concurrent.LazyInitializer;
import org.dasein.cloud.identity.IdentityServices;

import com.infinities.skyport.ServiceProvider;
import com.infinities.skyport.exception.InitializationException;
import com.infinities.skyport.model.configuration.service.IdentityConfiguration;
import com.infinities.skyport.timeout.service.TimedIdentityServices;

public class TimedIdentityServicesLazyInitializer extends LazyInitializer<IdentityServices> {

	private ServiceProvider inner;
	private IdentityConfiguration computeConfiguration;
	private ExecutorService executor;


	public TimedIdentityServicesLazyInitializer(ServiceProvider inner, IdentityConfiguration computeConfiguration,
			ExecutorService executor) {
		super();
		this.inner = inner;
		this.computeConfiguration = computeConfiguration;
		this.executor = executor;
	}

	@Override
	protected IdentityServices initialize() throws ConcurrentException {
		try {
			if (inner.hasIdentityServices()) {
				return new TimedIdentityServices(inner.getIdentityServices(), computeConfiguration, executor);
			}
		} catch (InitializationException e) {
			throw new ConcurrentException(e);
		}
		return null;
	}

}
