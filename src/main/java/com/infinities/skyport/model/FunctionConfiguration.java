package com.infinities.skyport.model;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

public class FunctionConfiguration implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PoolSize poolSize = PoolSize.SHORT;
	private Time delay = new Time(0, TimeUnit.SECONDS);
	private Time timeout = new Time(0, TimeUnit.SECONDS);


	public PoolSize getPoolSize() {
		return poolSize;
	}

	public void setPoolSize(PoolSize poolSize) {
		this.poolSize = poolSize;
	}

	public Time getDelay() {
		return delay;
	}

	public void setDelay(Time delay) {
		this.delay = delay;
	}

	public Time getTimeout() {
		return timeout;
	}

	public void setTimeout(Time timeout) {
		this.timeout = timeout;
	}

	@Override
	public FunctionConfiguration clone() {
		FunctionConfiguration clone = new FunctionConfiguration();
		clone.setPoolSize(getPoolSize());
		clone.setDelay(delay.clone());
		clone.setTimeout(timeout.clone());
		return clone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((delay == null) ? 0 : delay.hashCode());
		result = prime * result + ((poolSize == null) ? 0 : poolSize.hashCode());
		result = prime * result + ((timeout == null) ? 0 : timeout.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FunctionConfiguration other = (FunctionConfiguration) obj;
		if (delay == null) {
			if (other.delay != null)
				return false;
		} else if (!delay.equals(other.delay))
			return false;
		if (poolSize != other.poolSize)
			return false;
		if (timeout == null) {
			if (other.timeout != null)
				return false;
		} else if (!timeout.equals(other.timeout))
			return false;
		return true;
	}

}
