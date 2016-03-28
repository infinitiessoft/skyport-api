package com.infinities.skyport.cache.service.storage;

import com.google.common.eventbus.Subscribe;
import com.infinities.skyport.async.service.storage.AsyncBlobStoreSupport;
import com.infinities.skyport.service.EntityListener;
import com.infinities.skyport.service.event.storage.BlobFailureEvent;
import com.infinities.skyport.service.event.storage.BlobRefreshedEvent;

public interface CachedBlobStoreSupport extends AsyncBlobStoreSupport{

	public void addBlobListener(CachedBlobListener service);

	public void removeBlobListener(CachedBlobListener service);
	
	public interface CachedBlobListener extends EntityListener {
		
		@Subscribe
		public void onEntitiesRefreshed(BlobRefreshedEvent e) throws Exception;

		@Subscribe
		public void onFailure(BlobFailureEvent e);
	}
}
