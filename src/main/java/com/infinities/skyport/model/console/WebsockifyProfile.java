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
package com.infinities.skyport.model.console;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.UnexpectedException;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Strings;
import com.infinities.skyport.compute.entity.VncConnection;
import com.infinities.skyport.entity.Connection;

public class WebsockifyProfile implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(WebsockifyProfile.class);
	private static final String SEPARATOR = ":";
	private int sourcePort = 10900;
	private int targetPort = 5900;
	private String targetHost = "127.0.0.1";
	private boolean requireSSL = false;
	private boolean internalSSL = false;
	private String token;
	private String password;
	private ConsoleType consoleType;
	private String host = "127.0.0.1";
	private String path = "/vnc/vnc_auto.html";
	private int port = 8085;
	private String username;
	private String key;


	public WebsockifyProfile() {
	}

	public WebsockifyProfile(int sourcePort, int targetPort, String targetHost, boolean requireSSL, String token,
			String password, ConsoleType consoleType, String host, String path, int port, boolean internalSSL,
			String username, String key) {
		super();
		this.sourcePort = sourcePort;
		this.targetPort = targetPort;
		this.targetHost = targetHost;
		this.requireSSL = requireSSL;
		this.token = token;
		this.setConsoleType(consoleType);
		this.setPassword(password);
		this.host = host;
		this.path = path;
		this.port = port;
		this.internalSSL = internalSSL;
		this.username = username;
		this.key = key;
	}

	public int getSourcePort() {
		return sourcePort;
	}

	public void setSourcePort(int sourcePort) {
		this.sourcePort = sourcePort;
	}

	public int getTargetPort() {
		return targetPort;
	}

	public void setTargetPort(int targetPort) {
		this.targetPort = targetPort;
	}

	public String getTargetHost() {
		return targetHost;
	}

	public void setTargetHost(String targetHost) {
		this.targetHost = targetHost;
	}

	public boolean isRequireSSL() {
		return requireSSL;
	}

	public void setRequireSSL(boolean requireSSL) {
		this.requireSSL = requireSSL;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ConsoleType getConsoleType() {
		return consoleType;
	}

	public void setConsoleType(ConsoleType consoleType) {
		this.consoleType = consoleType;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public boolean isInternalSSL() {
		return internalSSL;
	}

	public void setInternalSSL(boolean internalSSL) {
		this.internalSSL = internalSSL;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return "WebsockifyProfile [sourcePort=" + sourcePort + ", targetPort=" + targetPort + ", targetHost=" + targetHost
				+ ", requireSSL=" + requireSSL + ", internalSSL=" + internalSSL + ", token=" + token + ", password="
				+ password + ", consoleType=" + consoleType + ", host=" + host + ", path=" + path + ", port=" + port
				+ ", username=" + username + ", key=" + key + "]";
	}

	public static WebsockifyProfile vncConnectionToWebsockifyProfile(VncConnection args, String config, String vmid)
			throws UnexpectedException, MalformedURLException {
		Connection connection = vncConnectionToConnection(args, config, vmid);
		WebsockifyProfile profile = new WebsockifyProfile();
		profile.setTargetHost(connection.getIp());
		profile.setTargetPort(Integer.parseInt(connection.getPort()));
		boolean ssl = connection.isSsl();
		profile.setInternalSSL(ssl);
		profile.setToken(connection.getToken());
		profile.setPassword(connection.getTicket());
		profile.setConsoleType(ConsoleType.valueOf(connection.getType()));
		profile.setUsername(args.getUsername());
		profile.setKey(connection.getKey());

		if (Strings.isNullOrEmpty(profile.getUsername())) {
			if (ConsoleType.RDP.name().equals(args.getType())) {
				profile.setUsername("Administrator");
			} else {
				profile.setUsername("root");
			}
		}

		return profile;
	}

	public static Connection vncConnectionToConnection(VncConnection args, String config, String vmid)
			throws UnexpectedException, MalformedURLException {
		Connection connection = null;
		// generate a random uuid as public key
		final String vncId = UUID.randomUUID().toString();
		connection = new Connection();
		connection.setConfig(config);
		connection.setDesc(vmid);
		connection.setKey(args.getKey());
		connection.setTicket(args.getTicket()); // true password
		connection.setType(args.getType());
		connection.setConnection(args.getInfo());
		connection.setInstanceid(vmid);
		connection.setSsl(args.isSsl());
		// connection.setToken(ret)

		// if (Strings.isNullOrEmpty(connection.getTicket())) {
		// connection.setTicket(vncPass);
		// }

		if (Strings.isNullOrEmpty(connection.getType())) {
			connection.setType(ConsoleType.VNC.name());
		}

		logger.debug("Connection info:{}, token:{}", new Object[] { connection.getInfo(), connection.getToken() });

		if (Strings.isNullOrEmpty(connection.getToken())) {
			connection.setToken(vncId); // fake password
		}

		if (Strings.isNullOrEmpty(connection.getIp()) || Strings.isNullOrEmpty(connection.getPort())) {
			throw new UnexpectedException("connect fail, please check vm's:" + vmid + " status.");
		}

		return connection;
	}

	public static String getNomarlNovncURL(WebsockifyProfile profile) {
		String protocol = profile.isRequireSSL() ? "https://" : "http://";
		String ip = profile.getHost();
		int port = profile.getPort();
		String path = profile.getPath();

		String url = protocol + ip + SEPARATOR + port + path + "?host=" + ip + "&port=" + profile.getSourcePort()
				+ "&token=" + profile.getToken();
		return url;
	}

}
