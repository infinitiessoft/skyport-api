package com.infinities.skyport.service;

import java.io.Serializable;
import java.util.SortedMap;

import com.infinities.skyport.ServiceProvider;

public interface DriverHome extends Serializable {

	void initialize();

	void close();

	SortedMap<String, Class<? extends ServiceProvider>> findAll();

	Class<? extends ServiceProvider> findByName(String name);

}
