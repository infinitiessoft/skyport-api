package com.infinities.skyport.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlTransient;

public class ThrowableWrapper implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XmlTransient
	private Throwable t;


	public ThrowableWrapper(Throwable t) {
		this.t = t;
	}

	public String getMessage() {
		return t.getMessage();
	}

	// public StackTraceElement getStackTrace() {
	// if (t.getStackTrace().length > 0) {
	// return t.getStackTrace()[0];
	// }
	// return null;
	// }

	@XmlTransient
	public Throwable getThrowable() {
		return t;
	}
}
