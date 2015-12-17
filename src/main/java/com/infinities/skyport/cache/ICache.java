package com.infinities.skyport.cache;

import java.io.Serializable;
import java.util.Map;

public interface ICache<K, V> extends Map<K, V>, Serializable {
	
//	boolean tryLock(K key);

//	void unlock(K key);
	
	void set(K key, V value);

}
