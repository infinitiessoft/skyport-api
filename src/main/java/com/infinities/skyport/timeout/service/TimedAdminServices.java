package com.infinities.skyport.timeout.service;

import java.util.concurrent.ExecutorService;

import org.dasein.cloud.admin.AccountSupport;
import org.dasein.cloud.admin.AdminServices;
import org.dasein.cloud.admin.BillingSupport;
import org.dasein.cloud.admin.PrepaymentSupport;

import com.infinities.skyport.exception.InitializationException;
import com.infinities.skyport.model.configuration.service.AdminConfiguration;
import com.infinities.skyport.timeout.ServiceProviderTimeLimiter;

public class TimedAdminServices implements AdminServices {

	private final AdminServices inner;
	private PrepaymentSupport timedPrepaymentSupport;
	private AccountSupport timedAccountSupport;
	private BillingSupport timedBillingSupport;


	public TimedAdminServices(AdminServices inner, AdminConfiguration adminConfiguration, ExecutorService executor)
			throws InitializationException {
		this.inner = inner;
		ServiceProviderTimeLimiter timedLimiter = new ServiceProviderTimeLimiter(executor);
		if (inner.hasPrepaymentSupport()) {
			this.timedPrepaymentSupport =
					timedLimiter.newProxy(inner.getPrepaymentSupport(), PrepaymentSupport.class,
							adminConfiguration.getPrepaymentConfiguration());
		}
		if (inner.hasAccountSupport()) {
			this.timedAccountSupport =
					timedLimiter.newProxy(inner.getAccountSupport(), AccountSupport.class,
							adminConfiguration.getAccountConfiguration());
		}
		if (inner.hasBillingSupport()) {
			this.timedBillingSupport =
					timedLimiter.newProxy(inner.getBillingSupport(), BillingSupport.class,
							adminConfiguration.getBillingConfiguration());
		}
	}

	@Override
	public PrepaymentSupport getPrepaymentSupport() {
		return timedPrepaymentSupport;
	}

	@Override
	public boolean hasPrepaymentSupport() {
		return inner.hasPrepaymentSupport();
	}

	@Override
	public AccountSupport getAccountSupport() {
		return timedAccountSupport;
	}

	@Override
	public boolean hasAccountSupport() {
		return inner.hasAccountSupport();
	}

	@Override
	public BillingSupport getBillingSupport() {
		return timedBillingSupport;
	}

	@Override
	public boolean hasBillingSupport() {
		return inner.hasBillingSupport();
	}

}
