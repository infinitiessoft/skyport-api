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
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;

import com.infinities.skyport.ServiceProvider;
import com.infinities.skyport.distributed.shiro.DistributedCacheManager;
import com.infinities.skyport.model.Member;
import com.infinities.skyport.model.PoolConfig;

public interface DistributedObjectFactory extends Serializable {

	public static final String INITIALIZING = "initializing...";
	public static final String DEFAULT_UNIT_NAME = "com.infinities.skyport.default";


	public enum Delegate {
		hazelcast, disabled;
	}


	// DistributedExecutor getExecutor(String name, PoolConfig poolConfig);

	<K, V> DistributedMap<K, V> getMap(String name);

	<K, V> DistributedCache<K, V> getCache(String name, Map<K, V> map);

	<K, V> DistributedCache<K, V> getCache(String name, Throwable e);

	<K, V> DistributedCache<K, V> getCache(String name);

	DistributedAtomicLong getAtomicLong(String name);

	DistributedThreadPool getThreadPool(String name, PoolConfig longPoolConfig, PoolConfig mediumPoolConfig,
			PoolConfig shortPoolConfig, ScheduledExecutorService scheduler, ServiceProvider serviceProvider);

	<K> DistributedAtomicReference<K> getAtomicReference(String name);

	DistributedLock getLock(String name);

	DistributedCacheManager getDistributedCacheManager();

	String getGroup();

	public Set<Member> getMembers();

	void close();

}
