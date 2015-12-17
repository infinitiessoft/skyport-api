package com.infinities.skyport;

public interface Module {

	void initialize(Skyport skyport) throws Exception;

	void close() throws Exception;

	String getAlias();
}
