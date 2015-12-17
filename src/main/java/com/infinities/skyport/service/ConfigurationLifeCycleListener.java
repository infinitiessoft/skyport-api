package com.infinities.skyport.service;

import com.infinities.skyport.model.configuration.Configuration;

public interface ConfigurationLifeCycleListener {

	void persist(Configuration configuration);

	// update non-essential data
	void lightMerge(Configuration configuration);

	// update essential data, service provider will close and all
	// LifeCycleListener will be removed
	void heavyMerge(Configuration configuration);

	void remove(Configuration configuration);

	void clear();
}
