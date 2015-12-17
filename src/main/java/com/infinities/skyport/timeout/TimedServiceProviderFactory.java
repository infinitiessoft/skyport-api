package com.infinities.skyport.timeout;

import java.util.concurrent.ExecutorService;

import com.infinities.skyport.ServiceProvider;
import com.infinities.skyport.model.configuration.Configuration;
import com.infinities.skyport.service.ConfigurationHome;

public class TimedServiceProviderFactory {

	public TimedServiceProviderFactory() {
	}

	public TimedServiceProvider getInstance(ConfigurationHome home, ServiceProvider inner, Configuration configuration,
			ExecutorService worker) throws Exception {
		TimedServiceProvider provider = new TimedServiceProvider(inner, configuration, worker);
		home.addLifeCycleListener(provider);
		return provider;
	}

}
