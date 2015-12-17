package com.infinities.skyport.model.console;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ConnectorSet")
@XmlAccessorType(XmlAccessType.FIELD)
public class ConnectorSet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XmlElement(name = "Connector")
	private Set<ServerConfiguration> connectors = new HashSet<ServerConfiguration>(0);


	public Set<ServerConfiguration> getConnectors() {
		return connectors;
	}

	public void setConnectors(Set<ServerConfiguration> connectors) {
		this.connectors = connectors;
	}

}
