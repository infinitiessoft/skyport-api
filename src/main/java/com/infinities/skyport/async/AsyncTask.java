package com.infinities.skyport.async;

import java.io.Serializable;
import java.util.concurrent.Callable;

public interface AsyncTask<O> extends Serializable, Callable<O>, ServiceProviderAware {

	long getEventid();

	void setEventid(long eventid);

}
