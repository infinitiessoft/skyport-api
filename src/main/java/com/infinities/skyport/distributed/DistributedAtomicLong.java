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


/**
 * Since {@link java.util.concurrent.atomic.AtomicLong} is not an interface,
 * distributed implementations need to be wrapped and their operations
 * delegated. This is a universal interface for implementations of atomic longs.
 * 
 * @see HazelcastAtomicLong
 * 
 * @author vanessa.williams
 */
public interface DistributedAtomicLong extends DistributedObject, Serializable {

	/**
	 * @return name of this atomic long
	 */
	String getName();

	/**
	 * @see java.util.concurrent.atomic.AtomicLong#incrementAndGet()
	 */
	long incrementAndGet();

	/**
	 * @see java.util.concurrent.atomic.AtomicLong#getAndIncrement()
	 */
	long getAndIncrement();

	/**
	 * @see java.util.concurrent.atomic.AtomicLong#decrementAndGet()
	 */
	long decrementAndGet();

	/**
	 * @see java.util.concurrent.atomic.AtomicLong#addAndGet(long)
	 */
	long addAndGet(long delta);

	/**
	 * @see java.util.concurrent.atomic.AtomicLong#getAndAdd(long)
	 */
	long getAndAdd(long delta);

	/**
	 * @see java.util.concurrent.atomic.AtomicLong#compareAndSet(long, long)
	 */
	boolean compareAndSet(long expect, long update);

	/**
	 * @see java.util.concurrent.atomic.AtomicLong#getAndSet(long)
	 */
	long getAndSet(long newValue);

	/**
	 * @see java.util.concurrent.atomic.AtomicLong#get()
	 */
	long get();

	/**
	 * @see java.util.concurrent.atomic.AtomicLong#set(long)
	 */
	void set(long newValue);

}
