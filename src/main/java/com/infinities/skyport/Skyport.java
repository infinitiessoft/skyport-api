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
