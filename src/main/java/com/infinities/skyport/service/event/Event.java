package com.infinities.skyport.service.event;

import java.io.Serializable;
import java.util.Date;

public interface Event<T> extends Serializable {

	public enum Type implements Serializable {
		ADDED, MODIFIED, REMOVED, REFRESHED;
	}


	public Date getDate();

	public String getConfigid();

}
