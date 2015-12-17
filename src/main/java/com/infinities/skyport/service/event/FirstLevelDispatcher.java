package com.infinities.skyport.service.event;

import java.io.Serializable;

import com.infinities.skyport.service.EntityListener;

public interface FirstLevelDispatcher extends Serializable {

	public void fireRefreshedEvent(RefreshedEvent<?> e);

	public void fireFaiureEvent(FailureEvent<?> e);

	public void addListener(EntityListener l);

	public void removeListener(EntityListener l);
}
