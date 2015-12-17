package com.infinities.skyport.distributed;

import java.io.Serializable;

import com.infinities.skyport.model.PoolSize;

public interface DistributedThreadPool extends Serializable, DistributedObject {

	DistributedExecutor getThreadPool(PoolSize poolSize);

	void shutdown();

}
