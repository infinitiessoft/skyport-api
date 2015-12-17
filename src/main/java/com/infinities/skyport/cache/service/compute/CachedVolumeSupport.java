package com.infinities.skyport.cache.service.compute;

import com.google.common.eventbus.Subscribe;
import com.infinities.skyport.async.service.compute.AsyncVolumeSupport;
import com.infinities.skyport.service.EntityListener;
import com.infinities.skyport.service.event.compute.volume.VolumeFailureEvent;
import com.infinities.skyport.service.event.compute.volume.VolumeRefreshedEvent;
import com.infinities.skyport.service.event.compute.volumeproduct.VolumeProductFailureEvent;
import com.infinities.skyport.service.event.compute.volumeproduct.VolumeProductRefreshedEvent;

public interface CachedVolumeSupport extends AsyncVolumeSupport {

	void addVolumeListener(CachedVolumeListener service);

	void removeVolumeListener(CachedVolumeListener service);

	void addVolumeProductListener(CachedVolumeProductListener service);

	void removeVolumeProductListener(CachedVolumeProductListener service);


	public interface CachedVolumeListener extends EntityListener {

		@Subscribe
		public void onEntitiesRefreshed(VolumeRefreshedEvent e) throws Exception;

		@Subscribe
		public void onFailure(VolumeFailureEvent e);
	}

	public interface CachedVolumeProductListener extends EntityListener {

		@Subscribe
		public void onEntitiesRefreshed(VolumeProductRefreshedEvent e) throws Exception;

		@Subscribe
		public void onFailure(VolumeProductFailureEvent e);
	}

}
