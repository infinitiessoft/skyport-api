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
