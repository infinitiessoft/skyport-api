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

import java.io.Closeable;

import com.infinities.skyport.model.SystemInfo;
import com.infinities.skyport.service.ConfigurationHome;
import com.infinities.skyport.service.DriverHome;
import com.infinities.skyport.service.ModuleHome;
import com.infinities.skyport.service.WebsockifyService;

public interface Skyport extends Closeable {

	void initialize() throws Throwable;

	@Override
	void close();

	ConfigurationHome getConfigurationHome();

	DriverHome getDriverHome();

	ModuleHome getModuleHome();

	SystemInfo getSystemInfo() throws Exception;

	WebsockifyService getWebsockifyService();

}
