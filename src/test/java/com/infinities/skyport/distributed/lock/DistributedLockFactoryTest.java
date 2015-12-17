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
package com.infinities.skyport.distributed.lock;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.concurrent.locks.ReadWriteLock;

import org.junit.Before;
import org.junit.Test;

import com.infinities.skyport.distributed.lock.DistributedLockFactory;
import com.infinities.skyport.distributed.lock.DistributedLockUtils.LocalDistributedDataStructureFactory;

/**
 * @author vanessa.williams
 */
public class DistributedLockFactoryTest {

	@Before
	public void setUp() {
		this.lockFactory = new DistributedLockFactory(new LocalDistributedDataStructureFactory());
	}

	/**
	 * One lock per name per thread.
	 */
	@Test
	public void oneLockObjectPerNamePerThread() {
		ReadWriteLock lock1 = lockFactory.getReadWriteLock("testLock");
		ReadWriteLock lock2 = lockFactory.getReadWriteLock("testLock");
		assertTrue(lock1 == lock2);

		lock1.readLock().lock();
		try {
			lock2.readLock().lock();
			fail("Thread should throw IllegalThreadStateException");
		} catch (IllegalThreadStateException success) {
		} finally {
			lock1.readLock().unlock();
		}
	}

	/**
	 * Two factories return the same lock.
	 */
	@Test
	public void testMultipleFactories() {
		DistributedLockFactory lockFactory2 = new DistributedLockFactory(new LocalDistributedDataStructureFactory());

		ReadWriteLock lock1 = lockFactory.getReadWriteLock("testLock");
		ReadWriteLock lock2 = lockFactory2.getReadWriteLock("testLock");
		assertTrue(lock1 == lock2);
		lock1.readLock().lock();
		try {
			lock2.readLock().lock();
			fail("Thread should throw IllegalThreadStateException");
		} catch (IllegalThreadStateException success) {
		} finally {
			lock1.readLock().unlock();
		}
	}


	DistributedLockFactory lockFactory;
}
