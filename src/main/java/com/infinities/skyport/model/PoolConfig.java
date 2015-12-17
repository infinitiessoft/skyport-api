package com.infinities.skyport.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import com.infinities.skyport.exception.SkyportException;

@XmlAccessorType(XmlAccessType.FIELD)
public class PoolConfig implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int DEFAULT_SHORT_MIN = 15;
	public static final int DEFAULT_SHORT_MAX = 15;
	public static final int DEFAULT_SHORT_QUEUE = 70;

	public static final int DEFAULT_MEDIUM_MIN = 10;
	public static final int DEFAULT_MEDIUM_MAX = 10;
	public static final int DEFAULT_MEDIUM_QUEUE = 50;

	public static final int DEFAULT_LONG_MIN = 5;
	public static final int DEFAULT_LONG_MAX = 5;
	public static final int DEFAULT_LONG_QUEUE = 20;

	public static final int DEFAULT_IDLE = 120;

	private int coreSize;

	private int maxSize;

	private int keepAlive;

	private int queueCapacity;


	public PoolConfig() {

	}

	public PoolConfig(int coreSize, int maxSize, int keepAlive, int queueCapacity) {
		this.coreSize = coreSize;
		this.maxSize = maxSize;
		this.keepAlive = keepAlive;
		this.queueCapacity = queueCapacity;
	}

	public PoolConfig(int coreSize, int maxSize, int queueCapacity) {
		this(coreSize, maxSize, DEFAULT_IDLE, queueCapacity);
	}

	public PoolConfig(PoolSize poolSize) {
		switch (poolSize) {
		case SHORT:
			this.coreSize = DEFAULT_SHORT_MIN;
			this.maxSize = DEFAULT_SHORT_MAX;
			this.queueCapacity = DEFAULT_SHORT_QUEUE;
			break;
		case MEDIUM:
			this.coreSize = DEFAULT_MEDIUM_MIN;
			this.maxSize = DEFAULT_MEDIUM_MAX;
			this.queueCapacity = DEFAULT_MEDIUM_QUEUE;
			break;
		case LONG:
			this.coreSize = DEFAULT_LONG_MIN;
			this.maxSize = DEFAULT_LONG_MAX;
			this.queueCapacity = DEFAULT_LONG_QUEUE;
			break;
		default:
			throw new SkyportException("No thread pool with size: " + poolSize);
		}
		this.keepAlive = DEFAULT_IDLE;
	}

	public int getCoreSize() {
		return coreSize;
	}

	public void setCoreSize(int coreSize) {
		this.coreSize = coreSize;
	}

	public int getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}

	public int getKeepAlive() {
		return keepAlive;
	}

	public void setKeepAlive(int keepAlive) {
		this.keepAlive = keepAlive;
	}

	public int getQueueCapacity() {
		return queueCapacity;
	}

	public void setQueueCapacity(int queueCapacity) {
		this.queueCapacity = queueCapacity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + coreSize;
		result = prime * result + keepAlive;
		result = prime * result + maxSize;
		result = prime * result + queueCapacity;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		} else if (obj == null) {
			return false;
		} else if (getClass() != obj.getClass()) {
			return false;
		}
		PoolConfig other = (PoolConfig) obj;
		if (coreSize != other.coreSize) {
			return false;
		} else if (keepAlive != other.keepAlive) {
			return false;
		} else if (maxSize != other.maxSize) {
			return false;
		} else if (queueCapacity != other.queueCapacity) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "PoolConfig [coreSize=" + coreSize + ", maxSize=" + maxSize + ", keepAlive=" + keepAlive + ", queueCapacity="
				+ queueCapacity + "]";
	}

	@Override
	public PoolConfig clone() {
		PoolConfig clone = new PoolConfig();
		clone.coreSize = coreSize;
		clone.maxSize = maxSize;
		clone.keepAlive = keepAlive;
		clone.queueCapacity = queueCapacity;
		return clone;
	}

}
