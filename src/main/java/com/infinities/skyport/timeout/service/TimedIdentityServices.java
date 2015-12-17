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
