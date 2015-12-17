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
package com.infinities.skyport.async.service;

import javax.annotation.Nullable;

import com.infinities.skyport.async.service.platform.AsyncCDNSupport;
import com.infinities.skyport.async.service.platform.AsyncDataWarehouseSupport;
import com.infinities.skyport.async.service.platform.AsyncKeyValueDatabaseSupport;
import com.infinities.skyport.async.service.platform.AsyncMQSupport;
import com.infinities.skyport.async.service.platform.AsyncMonitoringSupport;
import com.infinities.skyport.async.service.platform.AsyncPushNotificationSupport;
import com.infinities.skyport.async.service.platform.AsyncRelationalDatabaseSupport;

public interface AsyncPlatformServices {

	public @Nullable AsyncCDNSupport getCDNSupport();

	/**
	 * @return access to any support for data warehousing functionality, or
	 *         <code>null</code> if no support exists
	 */
	public @Nullable AsyncDataWarehouseSupport getDataWarehouseSupport();

	public @Nullable AsyncKeyValueDatabaseSupport getKeyValueDatabaseSupport();

	public @Nullable AsyncMQSupport getMessageQueueSupport();

	public @Nullable AsyncPushNotificationSupport getPushNotificationSupport();

	public @Nullable AsyncRelationalDatabaseSupport getRelationalDatabaseSupport();

	public @Nullable AsyncMonitoringSupport getMonitoringSupport();

	public boolean hasCDNSupport();

	/**
	 * @return true if this cloud supports data warehousing functionality in
	 *         this region
	 */
	public boolean hasDataWarehouseSupport();

	public boolean hasKeyValueDatabaseSupport();

	public boolean hasMessageQueueSupport();

	public boolean hasPushNotificationSupport();

	public boolean hasRelationalDatabaseSupport();

	public boolean hasMonitoringSupport();

	void initialize() throws Exception;

	void close();
}
