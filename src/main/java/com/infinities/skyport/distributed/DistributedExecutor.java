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
