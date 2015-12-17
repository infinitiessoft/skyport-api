/*******************************************************************************
 * Copyright 2015 InfinitiesSoft Solutions Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *******************************************************************************/
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
