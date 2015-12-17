package com.infinities.skyport.timeout.service.concurrent;

import java.util.concurrent.ExecutorService;

import org.apache.commons.lang3.concurrent.ConcurrentException;
import org.apache.commons.lang3.concurrent.LazyInitializer;
import org.dasein.cloud.network.NetworkServices;

import com.infinities.skyport.ServiceProvider;
import com.infinities.skyport.exception.InitializationException;
import com.infinities.skyport.model.configuration.service.NetworkConfiguration;
import com.infinities.skyport.timeout.service.TimedNetworkServices;

public class TimedNetworkServicesLazyInitializer extends LazyInitializer<NetworkServices> {

	private ServiceProvider inner;
	private NetworkConfiguration computeConfiguration;
	private ExecutorService executor;


	public TimedNetworkServicesLazyInitializer(ServiceProvider inner, NetworkConfiguration computeConfiguration,
			ExecutorService executor) {
		super();
		this.inner = inner;
		this.computeConfiguration = computeConfiguration;
		this.executor = executor;
	}

	@Override
	protected NetworkServices initialize() throws ConcurrentException {
		try {
			if (inner.hasNetworkServices()) {
				return new TimedNetworkServices(inner.getNetworkServices(), computeConfiguration, executor);
			}
		} catch (InitializationException e) {
			throw new ConcurrentException(e);
		}
		return null;
	}

}
