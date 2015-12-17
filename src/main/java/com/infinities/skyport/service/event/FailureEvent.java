package com.infinities.skyport.service.event;

public interface FailureEvent<T> extends Event<T> {

	Throwable getThrowable();
}
