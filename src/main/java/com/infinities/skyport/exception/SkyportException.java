package com.infinities.skyport.exception;


public class SkyportException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SkyportException() {
	}

	public SkyportException(String message) {
		super(message);
	}

	public SkyportException(Throwable cause) {
		super(cause);
	}

	public SkyportException(String message, Throwable cause) {
		super(message, cause);
	}

}
