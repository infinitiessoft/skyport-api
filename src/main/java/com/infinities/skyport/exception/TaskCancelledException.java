package com.infinities.skyport.exception;


public class TaskCancelledException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TaskCancelledException() {
	}

	public TaskCancelledException(String message) {
		super(message);
	}

	public TaskCancelledException(Throwable cause) {
		super(cause);
	}

	public TaskCancelledException(String message, Throwable cause) {
		super(message, cause);
	}

}
