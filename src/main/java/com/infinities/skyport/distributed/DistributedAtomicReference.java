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

public interface DistributedAtomicReference<E> extends DistributedObject {

	/**
	 * Atomically sets the value to the given updated value only if the current
	 * value {@code ==} the expected value.
	 * 
	 * @param expect
	 *            the expected value
	 * @param update
	 *            the new value
	 * @return true if successful; or false if the actual value was not equal to
	 *         the expected value.
	 */
	boolean compareAndSet(E expect, E update);

	/**
	 * Gets the current value.
	 * 
	 * @return the current value
	 */
	E get();

	/**
	 * Atomically sets the given value.
	 * 
	 * @param newValue
	 *            the new value
	 */
	void set(E newValue);

	/**
	 * Gets the value and sets the new value.
	 * 
	 * @param newValue
	 *            the new value.
	 * @return the old value.
	 */
	E getAndSet(E newValue);

	/**
	 * Sets and gets the value.
	 * 
	 * @param update
	 *            the new value
	 * @return the new value
	 */
	E setAndGet(E update);

	/**
	 * Checks if the stored reference is null.
	 * 
	 * @return true if null, false otherwise.
	 */
	boolean isNull();

	/**
	 * Clears the current stored reference.
	 */
	void clear();

	/**
	 * Checks if the reference contains the value.
	 * 
	 * @param value
	 *            the value to check (is allowed to be null).
	 * @return if the value is found, false otherwise.
	 */
	boolean contains(E value);
	
	void alter(DistributedFunction<E,E> function);

}
