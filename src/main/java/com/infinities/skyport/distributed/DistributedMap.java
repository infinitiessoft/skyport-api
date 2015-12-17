package com.infinities.skyport.distributed;

import java.util.Map;
import java.util.Set;

public interface DistributedMap<K, V> extends Map<K, V>, DistributedObject {

	boolean tryLock(K key);

	void lock(K key);

	void unlock(K key);

	void set(K key, V value);

	Set<K> localKeySet();

}
