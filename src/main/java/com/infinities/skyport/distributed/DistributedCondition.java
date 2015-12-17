package com.infinities.skyport.distributed;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

public interface DistributedCondition extends DistributedObject, Condition {

	/**
	 * {@inheritDoc}
	 */
	@Override
	void await() throws InterruptedException;

	/**
	 * {@inheritDoc}
	 */
	@Override
	void awaitUninterruptibly();

	/**
	 * {@inheritDoc}
	 */
	@Override
	long awaitNanos(long nanosTimeout) throws InterruptedException;

	/**
	 * {@inheritDoc}
	 */
	@Override
	boolean await(long time, TimeUnit unit) throws InterruptedException;

	/**
	 * {@inheritDoc}
	 */
	@Override
	boolean awaitUntil(Date deadline) throws InterruptedException;

	/**
	 * {@inheritDoc}
	 */
	@Override
	void signal();

	/**
	 * {@inheritDoc}
	 */
	@Override
	void signalAll();

}
