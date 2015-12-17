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
