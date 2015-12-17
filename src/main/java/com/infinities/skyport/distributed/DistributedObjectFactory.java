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
