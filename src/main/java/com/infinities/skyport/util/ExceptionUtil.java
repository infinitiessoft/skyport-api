package com.infinities.skyport.util;

public class ExceptionUtil {

	private ExceptionUtil() {

	}

	public static Throwable getRootCause(Throwable t) {
		Throwable result = t;

		while (result.getCause() != null) {
			result = result.getCause();
		}

		return result;
	}

}
