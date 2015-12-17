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

import java.util.concurrent.TimeUnit;

/**
 * Since {@link java.util.concurrent.Semaphore} is not an interface, distributed
 * implementations need to be wrapped and their operations delegated. This is a
 * universal interface for implementations of semaphores.
 * 
 * @see HazelcastSemaphore
 * 
 * @author vanessa.williams
 **/
public interface DistributedSemaphore {

	/**
	 * @return name of the semaphore
	 */
	String getName();

	/**
	 * @see java.util.concurrent.Semaphore#tryAcquire()
	 */
	boolean tryAcquire();

	/**
	 * @see java.util.concurrent.Semaphore#tryAcquire(long,
	 *      java.util.concurrent.TimeUnit)
	 */
	boolean tryAcquire(long l, TimeUnit timeUnit) throws InterruptedException;

	/**
	 * @see java.util.concurrent.Semaphore#acquire()
	 * @throws InterruptedException
	 */
	void acquire() throws InterruptedException;

	/**
	 * @see java.util.concurrent.Semaphore#release()
	 */
	void release();

	/**
	 * @see java.util.concurrent.Semaphore#availablePermits()
	 */
	int availablePermits();
}
