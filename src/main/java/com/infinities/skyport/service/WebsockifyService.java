package com.infinities.skyport.service;

import java.io.Closeable;
import java.io.Serializable;

import com.infinities.skyport.model.console.WebsockifyProfile;
import com.infinities.skyport.websockify.WebsockifyServer;

public interface WebsockifyService extends Closeable, Serializable {


	void initialize() throws Exception;

	public WebsockifyProfile sockify(WebsockifyProfile profile) throws Exception;

	public WebsockifyProfile release(WebsockifyProfile profile) throws Exception;

	public void setSecurityManager(Object securityManager);

	public void setWebsockifyServer(WebsockifyServer websockifyServer);

}
