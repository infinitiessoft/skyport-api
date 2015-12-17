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
package com.infinities.skyport.adapter;

import static org.junit.Assert.assertEquals;

import java.security.NoSuchAlgorithmException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.common.io.BaseEncoding;

public class XmlEncryptorTest {

	private XmlEncryptor encryptor;
	private String secret = "WG1KxLa4VsKO4LMfpW71Ng==";
	private String decoded = "mock";


	@Before
	public void setUp() throws Exception {
		encryptor = new XmlEncryptor();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMarshalString() throws Exception {
		String ret = encryptor.marshal(decoded);
		assertEquals(secret, ret);
	}

	@Test
	public void testUnmarshalString() throws Exception {
		String ret = encryptor.unmarshal(secret);
		assertEquals(decoded, ret);
	}

	@Test
	public void testGenerateKey() throws NoSuchAlgorithmException {
		String key = XmlEncryptor.generateKey();
		assertEquals(24, key.length());
		byte[] decodedValue = BaseEncoding.base64().decode(key);
		assertEquals(16, decodedValue.length);
	}

}
