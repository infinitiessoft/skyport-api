package com.infinities.skyport.distributed.shiro;

import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.util.Destroyable;
import org.apache.shiro.util.Initializable;

public interface DistributedCacheManager extends CacheManager, Initializable, Destroyable {

	public void setCacheManagerConfigFile(String classpathLocation);
	
	public boolean getSchedulerEnabled();
}
