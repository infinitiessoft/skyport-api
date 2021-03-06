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

import com.infinities.skyport.ServiceProvider;
import com.infinities.skyport.compute.SkyportComputeServices;
import com.infinities.skyport.exception.InitializationException;
import com.infinities.skyport.model.configuration.service.ComputeConfiguration;
import com.infinities.skyport.timeout.service.TimedComputeServices;

public class TimedComputeServicesLazyInitializer extends LazyInitializer<SkyportComputeServices> {

	private ServiceProvider inner;
	private ComputeConfiguration computeConfiguration;
	private ExecutorService executor;


	public TimedComputeServicesLazyInitializer(ServiceProvider inner, ComputeConfiguration computeConfiguration,
			ExecutorService executor) {
		super();
		this.inner = inner;
		this.computeConfiguration = computeConfiguration;
		this.executor = executor;
	}

	@Override
	protected SkyportComputeServices initialize() throws ConcurrentException {
		try {
			if (inner.hasComputeServices()) {
				return new TimedComputeServices(inner.getSkyportComputeServices(), computeConfiguration, executor);
			}
		} catch (InitializationException e) {
			throw new ConcurrentException(e);
		}
		return null;
	}

}
