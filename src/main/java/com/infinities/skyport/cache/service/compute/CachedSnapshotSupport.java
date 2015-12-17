package com.infinities.skyport.cache.service.compute;

import com.google.common.eventbus.Subscribe;
import com.infinities.skyport.async.service.compute.AsyncSnapshotSupport;
import com.infinities.skyport.service.EntityListener;
import com.infinities.skyport.service.event.compute.snapshot.SnapshotFailureEvent;
import com.infinities.skyport.service.event.compute.snapshot.SnapshotRefreshedEvent;

public interface CachedSnapshotSupport extends AsyncSnapshotSupport {

	void addSnapshotListener(CachedSnapshotListener service);

	void removeSnapshotListener(CachedSnapshotListener service);


	public interface CachedSnapshotListener extends EntityListener {

		@Subscribe
		public void onEntitiesRefreshed(SnapshotRefreshedEvent e) throws Exception;

		@Subscribe
		public void onFailure(SnapshotFailureEvent e);
	}

}
