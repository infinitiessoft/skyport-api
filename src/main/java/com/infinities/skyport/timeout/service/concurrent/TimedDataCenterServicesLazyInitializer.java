package com.infinities.skyport.timeout.service.concurrent;

import java.util.concurrent.ExecutorService;

import org.apache.commons.lang3.concurrent.ConcurrentException;
import org.apache.commons.lang3.concurrent.LazyInitializer;
import org.dasein.cloud.dc.DataCenterServices;

import com.infinities.skyport.ServiceProvider;
import com.infinities.skyport.exception.InitializationException;
import com.infinities.skyport.model.configuration.service.DataCenterConfiguration;
import com.infinities.skyport.timeout.ServiceProviderTimeLimiter;

public class TimedDataCenterServicesLazyInitializer extends LazyInitializer<DataCenterServices> {

	private ServiceProvider inner;
	private DataCenterConfiguration dataCenterConfiguration;
	private ExecutorService executor;


	public TimedDataCenterServicesLazyInitializer(ServiceProvider inner, DataCenterConfiguration computeConfiguration,
			ExecutorService executor) {
		super();
		this.inner = inner;
		this.dataCenterConfiguration = computeConfiguration;
		this.executor = executor;
	}

	@Override
	protected DataCenterServices initialize() throws ConcurrentException {
		try {
			if (inner.getDataCenterServices() != null) {
				ServiceProviderTimeLimiter timedLimiter = new ServiceProviderTimeLimiter(executor);
				return timedLimiter.newProxy(inner.getDataCenterServices(), DataCenterServices.class,
						dataCenterConfiguration);
			}
		} catch (InitializationException e) {
			throw new ConcurrentException(e);
		}
		return null;
	}

}
