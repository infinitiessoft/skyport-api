package com.infinities.skyport.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.infinities.skyport.model.configuration.Configuration;

public class ConfigurationTest {

	Configuration configuration;


	@Before
	public void setUp() throws Exception {
		configuration = new Configuration();
		configuration.setCloudName("MyCloud");
		configuration.setAccount("Account");
		configuration.setEndpoint("Endpoint");
		configuration.setProviderName("Demo");
		configuration.setProviderClass("Mock");
		configuration.setRegionId("Taiwan");
		configuration.getProperties().setProperty("token", "MyCloudToken");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testClone() {
		Configuration clone = configuration.clone();
		assertTrue(clone.equalsTo(configuration));
	}

	@Test
	public void testCloneWithUpdateProperty() {
		Configuration clone = configuration.clone();
		clone.getProperties().setProperty("token", "token");
		assertFalse(clone.equalsTo(configuration));
	}

}
