package com.infinities.skyport.async.service;

import javax.annotation.Nullable;

import com.infinities.skyport.async.service.identity.AsyncIdentityAndAccessSupport;
import com.infinities.skyport.async.service.identity.AsyncShellKeySupport;

public interface AsyncIdentityServices {

	public @Nullable AsyncIdentityAndAccessSupport getIdentityAndAccessSupport();

	public @Nullable AsyncShellKeySupport getShellKeySupport();

	public boolean hasIdentityAndAccessSupport();

	public boolean hasShellKeySupport();

	void initialize() throws Exception;

	void close();
}
