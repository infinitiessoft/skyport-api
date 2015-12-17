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
