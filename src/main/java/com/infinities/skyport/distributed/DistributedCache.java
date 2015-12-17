package com.infinities.skyport.distributed;

import java.util.Map;

import com.infinities.skyport.cache.ICache;

public interface DistributedCache<K, V> extends ICache<K, V>, DistributedObject {

	void reload(Map<K, V> map);

	void reload(Throwable e);

	void refresh();

//	void lock(K key);

	void delete(K key);

}
