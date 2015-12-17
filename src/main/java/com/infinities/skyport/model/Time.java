package com.infinities.skyport.model;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

public class Time implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long number;
	private TimeUnit unit = TimeUnit.SECONDS;


	public Time(long number, TimeUnit unit) {
		super();
		this.number = number;
		this.unit = unit;
	}

	public Time() {

	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public TimeUnit getUnit() {
		return unit;
	}

	public void setUnit(TimeUnit unit) {
		this.unit = unit;
	}

	@Override
	public Time clone() {
		Time clone = new Time();
		clone.setNumber(getNumber());
		clone.setUnit(getUnit());
		return clone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (number ^ (number >>> 32));
		result = prime * result + ((unit == null) ? 0 : unit.hashCode());
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
		Time other = (Time) obj;
		if (number != other.number)
			return false;
		if (unit != other.unit)
			return false;
		return true;
	}

}
