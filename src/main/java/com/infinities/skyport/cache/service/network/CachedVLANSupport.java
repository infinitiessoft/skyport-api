package com.infinities.skyport.cache.service.network;

import com.google.common.eventbus.Subscribe;
import com.infinities.skyport.async.service.network.AsyncVLANSupport;
import com.infinities.skyport.service.EntityListener;
import com.infinities.skyport.service.event.network.vlan.SubnetFailureEvent;
import com.infinities.skyport.service.event.network.vlan.SubnetRefreshedEvent;
import com.infinities.skyport.service.event.network.vlan.VLANFailureEvent;
import com.infinities.skyport.service.event.network.vlan.VLANRefreshedEvent;

public interface CachedVLANSupport extends AsyncVLANSupport{
	
	public void addVLANListener(CachedVLANListener service);

	public void removeVLANListener(CachedVLANListener service);
	
	public void addSubnetListener(CachedSubnetListener service);

	public void removeSubnetListener(CachedSubnetListener service);
	
	public interface CachedVLANListener extends EntityListener {
		
		@Subscribe
		public void onEntitiesRefreshed(VLANRefreshedEvent e) throws Exception;

		@Subscribe
		public void onFailure(VLANFailureEvent e);
	}
	
	public interface CachedSubnetListener extends EntityListener {
		
		@Subscribe
		public void onEntitiesRefreshed(SubnetRefreshedEvent e) throws Exception;

		@Subscribe
		public void onFailure(SubnetFailureEvent e);
	}


}
