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

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;

import com.infinities.skyport.distributed.DistributedDataStructureFactory;

/**
 * A factory for distributed locks.
 * 
 * @author vanessa.williams
 */
public class DistributedLockFactory {

	/**
	 * Constructor.
	 * 
	 * @param distributedDataStructureFactory
	 *            factory for creating distributed semaphores and atomic
	 *            primitives
	 */
	public DistributedLockFactory(DistributedDataStructureFactory distributedDataStructureFactory) {
		if (distributedDataStructureFactory == null) {
			throw new IllegalArgumentException("DistributedDataStructureFactory argument is required.");
		}
		this.distributedDataStructureFactory = distributedDataStructureFactory;
	}

	/**
	 * @param lockName
	 *            name of the lock
	 * @return a distributed readers-writer lock
	 */
	public ReadWriteLock getReadWriteLock(String lockName) {
		if (threadLocks.get().containsKey(lockName)) {
			return threadLocks.get().get(lockName);
		} else {
			DistributedReadWriteLockImpl lock = new DistributedReadWriteLockImpl(distributedDataStructureFactory, lockName);
			threadLocks.get().put(lockName, lock);
			return lock;
		}
	}

	public synchronized ReadWriteLock getReentrantReadWriteLock(String lockName) {
		if (threadReentrantLocks.get().containsKey(lockName)) {
			return threadReentrantLocks.get().get(lockName);
		} else {
			DistributedReentrantReadWriteLock lock = new DistributedReentrantReadWriteLock(distributedDataStructureFactory,
					lockName);
			threadReentrantLocks.get().put(lockName, lock);
			return lock;
		}

	}

	public synchronized void close() {
		Map<String, DistributedReentrantReadWriteLock> map = threadReentrantLocks.get();
		map.clear();
		threadReentrantLocks.remove();
	}


	static final ThreadLocal<Map<String, DistributedReadWriteLockImpl>> threadLocks = new ThreadLocal<Map<String, DistributedReadWriteLockImpl>>() {

		@Override
		protected Map<String, DistributedReadWriteLockImpl> initialValue() {
			return new HashMap<String, DistributedReadWriteLockImpl>();
		}
	};

	static final ThreadLocal<Map<String, DistributedReentrantReadWriteLock>> threadReentrantLocks = new ThreadLocal<Map<String, DistributedReentrantReadWriteLock>>() {

		@Override
		protected Map<String, DistributedReentrantReadWriteLock> initialValue() {
			return new HashMap<String, DistributedReentrantReadWriteLock>();
		}
	};

	final DistributedDataStructureFactory distributedDataStructureFactory;


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((distributedDataStructureFactory == null) ? 0 : distributedDataStructureFactory.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DistributedLockFactory other = (DistributedLockFactory) obj;
		if (distributedDataStructureFactory == null) {
			if (other.distributedDataStructureFactory != null)
				return false;
		} else if (!distributedDataStructureFactory.equals(other.distributedDataStructureFactory))
			return false;
		return true;
	}

}
