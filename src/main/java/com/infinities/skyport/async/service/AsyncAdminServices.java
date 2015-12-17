package com.infinities.skyport.async.service;

import javax.annotation.Nullable;

import com.infinities.skyport.async.service.admin.AsyncAccountSupport;
import com.infinities.skyport.async.service.admin.AsyncBillingSupport;
import com.infinities.skyport.async.service.admin.AsyncPrepaymentSupport;

public interface AsyncAdminServices {

	public @Nullable AsyncPrepaymentSupport getPrepaymentSupport();

	public boolean hasPrepaymentSupport();

	public @Nullable AsyncAccountSupport getAccountSupport();

	public boolean hasAccountSupport();

	public @Nullable AsyncBillingSupport getBillingSupport();

	public boolean hasBillingSupport();

	void initialize() throws Exception;

	void close();
}
