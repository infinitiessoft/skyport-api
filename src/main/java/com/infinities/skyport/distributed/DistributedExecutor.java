package com.infinities.skyport.distributed;

import java.io.Serializable;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.ListenableFuture;
import com.infinities.skyport.async.AsyncTask;

public interface DistributedExecutor extends ExecutorService, Serializable, DistributedObject {

	@Override
	<T> ListenableFuture<T> submit(Callable<T> task);

	@Override
	<T> ListenableFuture<T> submit(Runnable task, T result);

	@Override
	ListenableFuture<?> submit(Runnable task);

	<T> ListenableFuture<T> submit(AsyncTask<T> task);

	String getName();

	void setCorePoolSize(int corePoolSize);

	void setKeepAliveTime(int time, TimeUnit unit);

	void setMaximumPoolSize(int maximumPoolSize);
}
