package com.infinities.skyport.service;

import java.io.Serializable;
import java.util.Collection;

import com.infinities.skyport.cache.CachedServiceProvider;
import com.infinities.skyport.model.configuration.Configuration;

public interface ConfigurationHome extends Serializable {

	public final static String CONFIG = "config";
	public final static String CONFIG_LIST = "configs";


	void persist(Configuration transientInstance) throws Exception;

	void remove(String id) throws Exception;

	CachedServiceProvider merge(String id, Configuration detachedInstance) throws Exception;

	void initialize() throws Exception;

	void close() throws Exception;

	void addLifeCycleListener(ConfigurationLifeCycleListener service);

	void removeLifeCycleListener(ConfigurationLifeCycleListener service);

	CachedServiceProvider findById(String id);

	CachedServiceProvider findByName(String name);

	Collection<CachedServiceProvider> findAll();

	void setDriverHome(DriverHome driverHome);

	void setProfileHome(ProfileHome profileHome);

	String testContext(Configuration configuration) throws Exception;

}
