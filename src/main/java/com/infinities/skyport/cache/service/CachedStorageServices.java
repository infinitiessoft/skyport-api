package com.infinities.skyport.cache.service;

import java.io.Serializable;
import java.util.concurrent.ScheduledFuture;

import javax.annotation.Nullable;

import com.infinities.skyport.async.service.AsyncStorageServices;
import com.infinities.skyport.async.service.storage.AsyncOfflineStoreSupport;
import com.infinities.skyport.cache.service.storage.CachedBlobStoreSupport;

public interface CachedStorageServices extends AsyncStorageServices{
	
	public static enum StorageQuartzType implements Serializable {
		BLOB;
	}
	
	/**
	 * Offline storage is slower storage that is generally less expensive than
	 * online storage, but may take hours to fetch.
	 * 
	 * @return blob store support for the offline storage, if it exists
	 */
	public @Nullable AsyncOfflineStoreSupport getOfflineStorageSupport();

	/**
	 * Online storage is a &quot;real-time&quot; object storage engine such as
	 * Riak CS or Amazon S3.
	 * 
	 * @return blob store support for the online storage, if it exists
	 */
	public @Nullable CachedBlobStoreSupport getOnlineStorageSupport();

	public ScheduledFuture<?> flushCache(StorageQuartzType type);
}
