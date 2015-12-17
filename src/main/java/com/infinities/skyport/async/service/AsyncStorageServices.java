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

import com.infinities.skyport.async.service.storage.AsyncBlobStoreSupport;
import com.infinities.skyport.async.service.storage.AsyncOfflineStoreSupport;

public interface AsyncStorageServices {

	/**
	 * Offline storage is slower storage that is generally less expensive than
	 * online storage, but may take hours to fetch.
	 * 
	 * @return blob store support for the offline storage, if it exists
	 */
	public @Nullable AsyncOfflineStoreSupport getOfflineStorageSupport();

	/**
	 * @return true if the cloud supports offline storage
	 */
	public boolean hasOfflineStorageSupport();

	/**
	 * Online storage is a &quot;real-time&quot; object storage engine such as
	 * Riak CS or Amazon S3.
	 * 
	 * @return blob store support for the online storage, if it exists
	 */
	public @Nullable AsyncBlobStoreSupport getOnlineStorageSupport();

	/**
	 * @return true if the cloud supports online storage
	 */
	public boolean hasOnlineStorageSupport();

	void initialize() throws Exception;

	void close();
}
