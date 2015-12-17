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
