package com.infinities.skyport.cache.service.compute;

import com.google.common.eventbus.Subscribe;
import com.infinities.skyport.async.service.compute.AsyncMachineImageSupport;
import com.infinities.skyport.service.EntityListener;
import com.infinities.skyport.service.event.compute.machineimage.MachineImageFailureEvent;
import com.infinities.skyport.service.event.compute.machineimage.MachineImageRefreshedEvent;

public interface CachedMachineImageSupport extends AsyncMachineImageSupport {

	public void addMachineImageListener(CachedMachineImageListener service);

	public void removeMachineImageListener(CachedMachineImageListener service);


	public interface CachedMachineImageListener extends EntityListener {

		@Subscribe
		public void onEntitiesRefreshed(MachineImageRefreshedEvent e) throws Exception;

		@Subscribe
		public void onFailure(MachineImageFailureEvent e);
	}
}
