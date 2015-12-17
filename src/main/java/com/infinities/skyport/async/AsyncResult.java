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
package com.infinities.skyport.async;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.google.common.util.concurrent.ListenableFuture;

public class AsyncResult<E> implements ListenableFuture<E> {

	private ListenableFuture<E> inner;


	public AsyncResult(ListenableFuture<E> inner) {
		this.inner = inner;
	}

	@Override
	public boolean cancel(boolean mayInterruptIfRunning) {
		return inner.cancel(mayInterruptIfRunning);
	}

	@Override
	public boolean isCancelled() {
		return inner.isCancelled();
	}

	@Override
	public boolean isDone() {
		return inner.isDone();
	}

	@Override
	public E get() throws InterruptedException, ExecutionException {
		return inner.get();
	}

	@Override
	public E get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
		return inner.get(timeout, unit);
	}

	@Override
	public void addListener(Runnable listener, Executor executor) {
		inner.addListener(listener, executor);
	}
}
