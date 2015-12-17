/*******************************************************************************
 * Copyright 2015 InfinitiesSoft Solutions Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *******************************************************************************/
package com.infinities.skyport;

import java.io.Serializable;

public class AccessConfigConstants implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private AccessConfigConstants() {
	}


	public static final String CONFIGS = "configs";
	public static final String CONFIG = "config";
	public static final String STATUS = "status";
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String DRIVER = "driver";
	public static final String SERVER = "server";
	public static final String JKS = "jks";
	public static final String USERNAME = "username";
	public static final String PASSWORD = "password";
	public static final String DOMAIN = "domain";
	public static final String MODIFIED_DATE = "modifieddate";
	public static final String SHORT_CORE = "shortcore";
	public static final String SHORT_MAX = "shortmax";
	public static final String SHORT_CAPACITY = "shortcapacity";
	public static final String MEDIUM_CORE = "midcore";
	public static final String MEDIUM_MAX = "midmax";
	public static final String MEDIUM_CAPACITY = "midcapacity";
	public static final String LONG_CORE = "longcore";
	public static final String LONG_MAX = "longmax";
	public static final String LONG_CAPACITY = "longcapacity";
	public static final String DELAY = "delay";
	public static final String TIMEOUT = "timeout";
}
