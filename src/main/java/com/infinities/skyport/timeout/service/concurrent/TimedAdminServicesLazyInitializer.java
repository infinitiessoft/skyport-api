package com.infinities.skyport.timeout.service.concurrent;

import java.util.concurrent.ExecutorService;

import org.apache.commons.lang3.concurrent.ConcurrentException;
import org.apache.commons.lang3.concurrent.LazyInitializer;
import org.dasein.cloud.admin.AdminServices;

import com.infinities.skyport.ServiceProvider;
import com.infinities.skyport.exception.InitializationException;
import com.infinities.skyport.model.configuration.service.AdminConfiguration;
import com.infinities.skyport.timeout.service.TimedAdminServices;

public class TimedAdminServicesLazyInitializer extends LazyInitializer<AdminServices> {

	private ServiceProvider inner;
	private AdminConfiguration computeConfiguration;
	private ExecutorService executor;


	public TimedAdminServicesLazyInitializer(ServiceProvider inner, AdminConfiguration computeConfiguration,
			ExecutorService executor) {
		super();
		this.inner = inner;
		this.computeConfiguration = computeConfiguration;
		this.executor = executor;
	}

	@Override
	protected AdminServices initialize() throws ConcurrentException {
		try {
			if (inner.hasAdminServices()) {
				return new TimedAdminServices(inner.getAdminServices(), computeConfiguration, executor);
			}
		} catch (InitializationException e) {
			throw new ConcurrentException(e);
		}
		return null;
	}

}
