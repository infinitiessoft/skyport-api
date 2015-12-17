package com.infinities.skyport.service.event;

import java.util.Collection;
import java.util.Map;

import org.apache.commons.lang3.builder.DiffResult;

public interface SuccessEvent<T> extends Event<T> {

	public Type getType();

	public Collection<T> getEntries();

	public Map<String, DiffResult> getPatchs();
}
