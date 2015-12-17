package com.infinities.skyport.model.webserver;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Service implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XmlElement(name = "Connector")
	private Set<Connector> connectors = new HashSet<Connector>(0);

	@XmlAttribute(name = "default")
	private boolean defaultService;


	public Set<Connector> getConnectors() {
		return connectors;
	}

	public void setConnectors(Set<Connector> connectors) {
		this.connectors = connectors;
	}

	public boolean isDefaultService() {
		return defaultService;
	}

	public void setDefaultService(boolean defaultService) {
		this.defaultService = defaultService;
	}

}
