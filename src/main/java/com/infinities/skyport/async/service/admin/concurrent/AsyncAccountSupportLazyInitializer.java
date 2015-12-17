package com.infinities.skyport.async.service.admin.concurrent;

import org.apache.commons.lang3.concurrent.ConcurrentException;
import org.apache.commons.lang3.concurrent.LazyInitializer;

import com.infinities.skyport.async.service.admin.AsyncAccountSupport;

public class AsyncAccountSupportLazyInitializer extends LazyInitializer<AsyncAccountSupport>{

	
	
	@Override
	protected AsyncAccountSupport initialize() throws ConcurrentException {
		return null;
	}

}
