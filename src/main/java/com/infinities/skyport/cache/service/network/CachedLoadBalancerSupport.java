package com.infinities.skyport.cache.service.network;

import com.google.common.eventbus.Subscribe;
import com.infinities.skyport.async.service.network.AsyncLoadBalancerSupport;
import com.infinities.skyport.service.EntityListener;
import com.infinities.skyport.service.event.network.loadbalancer.LoadBalancerFailureEvent;
import com.infinities.skyport.service.event.network.loadbalancer.LoadBalancerRefreshedEvent;

public interface CachedLoadBalancerSupport extends AsyncLoadBalancerSupport{

	public void addLoadBalancerListener(CachedLoadBalancerListener service);

	public void removeLoadBalancerListener(CachedLoadBalancerListener service);
	
	public interface CachedLoadBalancerListener extends EntityListener {
		
		@Subscribe
		public void onEntitiesRefreshed(LoadBalancerRefreshedEvent e) throws Exception;

		@Subscribe
		public void onFailure(LoadBalancerFailureEvent e);
	}
}
