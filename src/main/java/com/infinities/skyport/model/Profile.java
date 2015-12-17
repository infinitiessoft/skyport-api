package com.infinities.skyport.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.infinities.skyport.model.configuration.Configuration;

@XmlRootElement(name = "profile")
@XmlAccessorType(XmlAccessType.FIELD)
public class Profile implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XmlElementWrapper(name = "configurations")
	@XmlElement(name = "configuration")
	private List<Configuration> Configurations = new ArrayList<Configuration>(0);


	public List<Configuration> getConfigurations() {
		return this.Configurations;
	}

	public void setConfigurations(List<Configuration> Configurations) {
		this.Configurations = Configurations;
	}
}
