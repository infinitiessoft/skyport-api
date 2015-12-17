package com.infinities.skyport.model.webserver;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Server")
@XmlAccessorType(XmlAccessType.FIELD)
public class Server implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XmlElement(name = "Service")
	private Set<Service> services = new HashSet<Service>(0);


	public Set<Service> getServices() {
		return services;
	}

	public void setServices(Set<Service> services) {
		this.services = services;
	}

}
