package com.infinities.skyport.cache.service.compute;

import com.google.common.eventbus.Subscribe;
import com.infinities.skyport.async.service.compute.AsyncVirtualMachineSupport;
import com.infinities.skyport.service.EntityListener;
import com.infinities.skyport.service.event.compute.virtualmachine.VirtualMachineFailureEvent;
import com.infinities.skyport.service.event.compute.virtualmachine.VirtualMachineRefreshedEvent;
import com.infinities.skyport.service.event.compute.virtualmachineproduct.VirtualMachineProductFailureEvent;
import com.infinities.skyport.service.event.compute.virtualmachineproduct.VirtualMachineProductRefreshedEvent;

public interface CachedVirtualMachineSupport extends AsyncVirtualMachineSupport {

	void addVirtualMachineListener(CachedVirtualMachineListener service);

	void removeVirtualMachineListener(CachedVirtualMachineListener service);

	void addVirtualMachineProductListener(CachedVirtualMachineProductListener service);

	void removeVirtualMachineProductListener(CachedVirtualMachineProductListener service);


	public interface CachedVirtualMachineListener extends EntityListener {

		@Subscribe
		public void onEntitiesRefreshed(VirtualMachineRefreshedEvent e) throws Exception;

		@Subscribe
		public void onFailure(VirtualMachineFailureEvent e);
	}

	public interface CachedVirtualMachineProductListener extends EntityListener {

		@Subscribe
		public void onEntitiesRefreshed(VirtualMachineProductRefreshedEvent e) throws Exception;

		@Subscribe
		public void onFailure(VirtualMachineProductFailureEvent e);
	}

}
