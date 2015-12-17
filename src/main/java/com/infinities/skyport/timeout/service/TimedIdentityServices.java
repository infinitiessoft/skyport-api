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
package com.infinities.skyport.timeout.service;

import java.util.concurrent.ExecutorService;

import org.dasein.cloud.identity.IdentityAndAccessSupport;
import org.dasein.cloud.identity.IdentityServices;
import org.dasein.cloud.identity.ShellKeySupport;

import com.infinities.skyport.exception.InitializationException;
import com.infinities.skyport.model.configuration.service.IdentityConfiguration;
import com.infinities.skyport.timeout.ServiceProviderTimeLimiter;

public class TimedIdentityServices implements IdentityServices {

	private final IdentityServices inner;
	private IdentityAndAccessSupport timedIdentityAndAccessSupport;
	private ShellKeySupport timedShellKeySupport;


	public TimedIdentityServices(IdentityServices inner, IdentityConfiguration identityConfiguration,
			ExecutorService executor) throws InitializationException {
		this.inner = inner;
		ServiceProviderTimeLimiter timedLimiter = new ServiceProviderTimeLimiter(executor);
		if (inner.hasIdentityAndAccessSupport()) {
			this.timedIdentityAndAccessSupport =
					timedLimiter.newProxy(inner.getIdentityAndAccessSupport(), IdentityAndAccessSupport.class,
							identityConfiguration.getIdentityAndAccessConfiguration());
		}
		if (inner.hasShellKeySupport()) {
			this.timedShellKeySupport =
					timedLimiter.newProxy(inner.getShellKeySupport(), ShellKeySupport.class,
							identityConfiguration.getShellKeyConfiguration());
		}
	}

	@Override
	public IdentityAndAccessSupport getIdentityAndAccessSupport() {
		return this.timedIdentityAndAccessSupport;
	}

	@Override
	public ShellKeySupport getShellKeySupport() {
		return this.timedShellKeySupport;
	}

	@Override
	public boolean hasIdentityAndAccessSupport() {
		return inner.hasIdentityAndAccessSupport();
	}

	@Override
	public boolean hasShellKeySupport() {
		return inner.hasShellKeySupport();
	}

}
