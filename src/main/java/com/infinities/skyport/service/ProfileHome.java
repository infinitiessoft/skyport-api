package com.infinities.skyport.service;

import javax.xml.bind.JAXBException;

import com.infinities.skyport.model.Profile;

public interface ProfileHome {

	Profile get();

	void save() throws JAXBException;

}
