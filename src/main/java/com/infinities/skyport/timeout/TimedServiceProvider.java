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
package com.infinities.skyport.timeout;

import java.util.concurrent.ExecutorService;

import org.apache.commons.lang3.concurrent.ConcurrentException;
import org.dasein.cloud.CloudException;
import org.dasein.cloud.CloudProvider;
import org.dasein.cloud.ContextRequirements;
import org.dasein.cloud.InternalException;
import org.dasein.cloud.ProviderContext;
import org.dasein.cloud.admin.AdminServices;
import org.dasein.cloud.ci.CIServices;
import org.dasein.cloud.dc.DataCenterServices;
import org.dasein.cloud.identity.IdentityServices;
import org.dasein.cloud.network.NetworkServices;
import org.dasein.cloud.platform.PlatformServices;
import org.dasein.cloud.storage.StorageServices;
import org.dasein.cloud.util.NamingConstraints;
import org.dasein.cloud.util.ResourceNamespace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.infinities.skyport.ServiceProvider;
import com.infinities.skyport.compute.SkyportComputeServices;
import com.infinities.skyport.model.configuration.Configuration;
import com.infinities.skyport.service.ConfigurationLifeCycleListener;
import com.infinities.skyport.timeout.service.concurrent.TimedAdminServicesLazyInitializer;
import com.infinities.skyport.timeout.service.concurrent.TimedCIServicesLazyInitializer;
import com.infinities.skyport.timeout.service.concurrent.TimedComputeServicesLazyInitializer;
import com.infinities.skyport.timeout.service.concurrent.TimedDataCenterServicesLazyInitializer;
import com.infinities.skyport.timeout.service.concurrent.TimedIdentityServicesLazyInitializer;
import com.infinities.skyport.timeout.service.concurrent.TimedNetworkServicesLazyInitializer;
import com.infinities.skyport.timeout.service.concurrent.TimedPlatformServicesLazyInitializer;
import com.infinities.skyport.timeout.service.concurrent.TimedStorageServicesLazyInitializer;

public class TimedServiceProvider implements ServiceProvider, ConfigurationLifeCycleListener {

	private static final Logger logger = LoggerFactory.getLogger(TimedServiceProvider.class);
	private final ServiceProvider inner;
	private Configuration configuration;
	private ExecutorService worker;
	private TimedComputeServicesLazyInitializer timedComputeServices;
	private TimedNetworkServicesLazyInitializer timedNetworkServices;
	private TimedStorageServicesLazyInitializer timedStorageServices;
	private TimedIdentityServicesLazyInitializer timedIdentityServices;
	private TimedAdminServicesLazyInitializer timedAdminServices;
	private TimedCIServicesLazyInitializer timedCIServices;
	private TimedPlatformServicesLazyInitializer timedPlatformServices;
	private TimedDataCenterServicesLazyInitializer timedDataCenterServices;


	public TimedServiceProvider(ServiceProvider inner, Configuration configuration, ExecutorService worker)
			throws ConcurrentException {
		this.inner = inner;
		this.configuration = configuration;
		this.worker = worker;
		setUpServices(configuration);
	}

	private void setUpServices(Configuration configuration) throws ConcurrentException {
		this.timedComputeServices = new TimedComputeServicesLazyInitializer(inner, configuration.getComputeConfiguration(),
				worker);

		this.timedNetworkServices = new TimedNetworkServicesLazyInitializer(inner, configuration.getNetworkConfiguration(),
				worker);

		this.timedStorageServices = new TimedStorageServicesLazyInitializer(inner, configuration.getStorageConfiguration(),
				worker);

		this.timedIdentityServices = new TimedIdentityServicesLazyInitializer(inner,
				configuration.getIdentityConfiguration(), worker);

		this.timedAdminServices = new TimedAdminServicesLazyInitializer(inner, configuration.getAdminConfiguration(), worker);
		this.timedCIServices = new TimedCIServicesLazyInitializer(inner, configuration.getcIConfiguration(), worker);

		this.timedPlatformServices = new TimedPlatformServicesLazyInitializer(inner,
				configuration.getPlatformConfiguration(), worker);
		this.timedDataCenterServices = new TimedDataCenterServicesLazyInitializer(inner,
				configuration.getDataCenterConfiguration(), worker);
	}

	@Override
	public void close() {
		inner.close();
	}

	@Override
	public String testContext() {
		return inner.testContext();
	}

	@Override
	public boolean isConnected() {
		return inner.isConnected();
	}

	@Override
	public boolean hasAdminServices() {
		return inner.hasAdminServices();
	}

	@Override
	public boolean hasCIServices() {
		return inner.hasCIServices();
	}

	@Override
	public boolean hasComputeServices() {
		return inner.hasComputeServices();
	}

	@Override
	public boolean hasIdentityServices() {
		return inner.hasIdentityServices();
	}

	@Override
	public boolean hasNetworkServices() {
		return inner.hasNetworkServices();
	}

	@Override
	public boolean hasPlatformServices() {
		return inner.hasPlatformServices();
	}

	@Override
	public boolean hasStorageServices() {
		return inner.hasStorageServices();
	}

	@Override
	public StorageServices getStorageServices() throws ConcurrentException {
		return timedStorageServices.get();
	}

	@Override
	public AdminServices getAdminServices() throws ConcurrentException {
		return timedAdminServices.get();
	}

	@Override
	public CloudProvider getComputeCloud() {
		return inner.getComputeCloud();
	}

	@Override
	public ProviderContext getContext() {
		return inner.getContext();
	}

	@Override
	public ContextRequirements getContextRequirements() {
		return inner.getContextRequirements();
	}

	@Override
	public String getCloudName() {
		return inner.getCloudName();
	}

	@Override
	public DataCenterServices getDataCenterServices() throws ConcurrentException {
		return timedDataCenterServices.get();
	}

	@Override
	public CIServices getCIServices() throws ConcurrentException {
		return timedCIServices.get();
	}

	@Override
	public SkyportComputeServices getSkyportComputeServices() throws ConcurrentException {
		return timedComputeServices.get();
	}

	@Override
	public IdentityServices getIdentityServices() throws ConcurrentException {
		return timedIdentityServices.get();
	}

	@Override
	public NetworkServices getNetworkServices() throws ConcurrentException {
		return timedNetworkServices.get();
	}

	@Override
	public PlatformServices getPlatformServices() throws ConcurrentException {
		return timedPlatformServices.get();
	}

	@Override
	public String getProviderName() {
		return inner.getProviderName();
	}

	@Override
	public String findUniqueName(String baseName, NamingConstraints constraints, ResourceNamespace namespace)
			throws CloudException, InternalException {
		return inner.findUniqueName(baseName, constraints, namespace);
	}

	@Override
	public void initialize() throws ConcurrentException {
		inner.initialize();
	}

	public Configuration getConfiguration() {
		return configuration;
	}

	@Override
	public void persist(Configuration configuration) {
		// ignore
	}

	@Override
	public void lightMerge(Configuration configuration) {
		if (configuration.getId().equals(this.configuration.getId())) {
			try {
				this.configuration = configuration;
				setUpServices(configuration);
			} catch (Exception e) {
				logger.error("set up TimedServiceProvider failed", e);
			}
		}

	}

	@Override
	public void heavyMerge(Configuration configuration) {
		// ignore
	}

	@Override
	public void remove(Configuration configuration) {
		// ignore
	}

	@Override
	public void clear() {
		// ignore
	}

}
