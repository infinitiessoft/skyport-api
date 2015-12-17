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
package com.infinities.skyport.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import com.infinities.skyport.model.console.ServerConfiguration;
import com.infinities.skyport.model.webserver.Connector;

@XmlAccessorType(XmlAccessType.FIELD)
public class SystemInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean ui;
	private String group;
	private String cluster;
	private String timeZone;
	private String title;
	private String version;
	private int poolActive;
	private int poolInactive;
	private int driverCount;
	private Set<ServerConfiguration> websockifyServerConnectors = new HashSet<ServerConfiguration>(0);
	private Set<Connector> webServerConnectors = new HashSet<Connector>(0);
	private Set<Member> members = new HashSet<Member>(0);


	public boolean isUi() {
		return ui;
	}

	public void setUi(boolean ui) {
		this.ui = ui;
	}

	public String getCluster() {
		return cluster;
	}

	public void setCluster(String cluster) {
		this.cluster = cluster;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public int getPoolActive() {
		return poolActive;
	}

	public void setPoolActive(int poolActive) {
		this.poolActive = poolActive;
	}

	public int getPoolInactive() {
		return poolInactive;
	}

	public void setPoolInactive(int poolInactive) {
		this.poolInactive = poolInactive;
	}

	public int getDriverCount() {
		return driverCount;
	}

	public void setDriverCount(int driverCount) {
		this.driverCount = driverCount;
	}

	public Set<ServerConfiguration> getWebsockifyServerConnectors() {
		return websockifyServerConnectors;
	}

	public void setWebsockifyServerConnectors(Set<ServerConfiguration> websockifyServerConnectors) {
		this.websockifyServerConnectors = websockifyServerConnectors;
	}

	public Set<Connector> getWebServerConnectors() {
		return webServerConnectors;
	}

	public void setWebServerConnectors(Set<Connector> webServerConnectors) {
		this.webServerConnectors = webServerConnectors;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public Set<Member> getMembers() {
		return members;
	}

	public void setMembers(Set<Member> members) {
		this.members = members;
	}

}
