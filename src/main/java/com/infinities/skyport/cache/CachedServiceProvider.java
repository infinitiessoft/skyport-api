package com.infinities.skyport.cache;

import javax.annotation.Nullable;

import org.apache.commons.lang3.concurrent.ConcurrentException;

import com.infinities.skyport.async.AsyncServiceProvider;
import com.infinities.skyport.cache.service.CachedComputeServices;

public interface CachedServiceProvider extends AsyncServiceProvider {

	@Override
	@Nullable
	CachedComputeServices getComputeServices() throws ConcurrentException;
}
