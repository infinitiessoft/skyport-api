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
