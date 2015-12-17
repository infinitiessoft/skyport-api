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

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.io.BaseEncoding;
import com.infinities.skyport.util.PropertiesHolder;

public class XmlEncryptor extends XmlAdapter<String, String> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final static String KEY = "Key";
	private final static Logger logger = LoggerFactory.getLogger(XmlEncryptor.class);
	private byte[] keyBytes;


	public XmlEncryptor() {
		String key = PropertiesHolder.getProperty(PropertiesHolder.KEY);
		keyBytes = BaseEncoding.base64().decode(key);
	}

	// @Override
	// public String marshal(String arg0) throws Exception {
	// byte[] secretBytes = CodecSupport.toBytes(arg0);
	// ByteSource encrypted = cipher.encrypt(secretBytes, keyBytes);
	// String encryptedStr = encrypted.toBase64();
	//
	// return encryptedStr;
	// }
	//
	// @Override
	// public String unmarshal(String arg0) throws Exception {
	// byte[] encryptedBytes = Base64.decode(arg0);
	// ByteSource decrypted = cipher.decrypt(encryptedBytes, keyBytes);
	// String decryptedStr = CodecSupport.toString(decrypted.getBytes());
	//
	// return decryptedStr;
	// }

	@Override
	public String marshal(String arg0) throws Exception {
		SecretKeySpec skeySpec = new SecretKeySpec(keyBytes, "AES");
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
		String encrypted = BaseEncoding.base64().encode((cipher.doFinal(arg0.getBytes())));
		return encrypted;
	}

	@Override
	public String unmarshal(String arg0) throws Exception {
		SecretKeySpec skeySpec = new SecretKeySpec(keyBytes, "AES");
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.DECRYPT_MODE, skeySpec);
		byte[] decodedValue = BaseEncoding.base64().decode(arg0);
		byte[] decValue = cipher.doFinal(decodedValue);
		String decrypted = new String(decValue);
		logger.debug("decrypted: {}", decrypted);
		return decrypted;
	}

	public static String generateKey() throws NoSuchAlgorithmException {
		KeyGenerator kgen = KeyGenerator.getInstance("AES");
		kgen.init(128);
		SecretKey key = kgen.generateKey();
		byte[] keyBytes = key.getEncoded();
		String keyStr = BaseEncoding.base64().encode(keyBytes);

		return keyStr;
	}

	public static void main(String[] main) throws NoSuchAlgorithmException {
//		String key = generateKey();
	}

}
