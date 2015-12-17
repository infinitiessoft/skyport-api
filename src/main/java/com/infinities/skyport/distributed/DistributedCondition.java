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
