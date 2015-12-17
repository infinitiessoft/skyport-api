package com.infinities.skyport.service.event;

import java.util.Collection;


public interface RefreshedEvent<T> extends Event<T> {
	
	public Collection<T> getNewEntries();

}
