package com.infinities.skyport.websockify;

import java.io.Serializable;

import org.jboss.netty.channel.Channel;

import com.infinities.skyport.model.console.ServerConfiguration;
import com.infinities.skyport.model.console.WebsockifyProfile;

public interface WebsockifyServer extends Serializable {

	public Channel connect(WebsockifyProfile profile, SSLSetting sslSetting, ServerConfiguration configuration,
			Object securityManager);

	public void close(Channel serverChannel);

	public void activate();

	public void deactivate();

}
