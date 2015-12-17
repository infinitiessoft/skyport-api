package com.infinities.skyport.distributed.shiro;

import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DistributedSessionManager extends DefaultWebSessionManager {

	private final static Logger logger = LoggerFactory.getLogger(DistributedSessionManager.class);


	public void setSchedulerEnabled(DistributedCacheManager manager) {
		logger.debug("SessionValidationSchedulerEnabled? {}", manager.getSchedulerEnabled());
		this.setSessionValidationSchedulerEnabled(manager.getSchedulerEnabled());
	}

}
