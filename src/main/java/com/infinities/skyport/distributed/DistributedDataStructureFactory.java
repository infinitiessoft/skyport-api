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

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Interface for creating distributed data structures.
 * 
 * @author vanessa.williams
 */
public interface DistributedDataStructureFactory {

	/**
	 * @param name
	 *            the semaphore name
	 * @param initPermits
	 *            the number of initial permits
	 * @return a named semaphore, created & initialized with requested permits
	 *         if necessary.
	 */
	DistributedSemaphore getSemaphore(String name, int initPermits);

	/**
	 * @param name
	 *            the atomic long name
	 * @return a named atomic long
	 */
	DistributedAtomicLong getAtomicLong(String name);

	/**
	 * @param name
	 *            the lock name
	 * @return a named lock
	 */
	Lock getLock(String name);

	/**
	 * @param lock
	 *            a lock
	 * @param conditionName
	 *            a name for the condition
	 * @return a new condition
	 */
	Condition getCondition(Lock lock, String conditionName);

}
