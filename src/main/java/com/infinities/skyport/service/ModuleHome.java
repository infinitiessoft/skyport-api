package com.infinities.skyport.service;

import java.io.Serializable;
import java.util.SortedMap;

import com.infinities.skyport.Module;

public interface ModuleHome extends Serializable {

	void initialize();

	void close();

	SortedMap<String, Module> findAll();

	Module findByName(String name) throws Exception;

}
