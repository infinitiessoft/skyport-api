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
package com.infinities.skyport;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.dasein.cloud.Cloud;
import org.dasein.cloud.CloudException;
import org.dasein.cloud.CloudProvider;
import org.dasein.cloud.ContextRequirements;
import org.dasein.cloud.InternalException;
import org.dasein.cloud.ProviderContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.infinities.skyport.model.configuration.Configuration;

public class ServiceProviderBuilder {

	private static final Logger logger = LoggerFactory.getLogger(ServiceProviderBuilder.class);


	private ServiceProviderBuilder() {

	}

	public static ServiceProvider build(Class<? extends ServiceProvider> c, Configuration configuration)
			throws ClassNotFoundException, IllegalAccessException, InstantiationException, CloudException,
			InternalException, UnsupportedEncodingException {
		String endpoint = configuration.getEndpoint();
		String regionId = configuration.getRegionId();
		String cloudName = configuration.getCloudName();
		String providerName = configuration.getProviderName();
		String account = configuration.getAccount();

		// Use that information to register the cloud
		@SuppressWarnings("unchecked")
		Cloud cloud = Cloud.register(providerName, cloudName, endpoint, (Class<? extends CloudProvider>) c);

		// Find what additional fields are necessary to connect to the cloud
		ContextRequirements requirements = cloud.buildProvider().getContextRequirements();
		List<ContextRequirements.Field> fields = requirements.getConfigurableValues();

		// Load the values for the required fields from the system properties
		@SuppressWarnings("rawtypes")
		ProviderContext.Value[] values = new ProviderContext.Value[fields.size()];
		int i = 0;

		StringBuilder requireds = new StringBuilder();
		requireds.append("Required fields:");
		for (ContextRequirements.Field f : fields) {
			if (f.required) {
				requireds.append("\t" + f.name + "(" + f.type + "): " + f.description);
			}
		}
		logger.debug("{}", requireds.toString());
		StringBuilder optionals = new StringBuilder();
		optionals.append("Optional fields:");
		for (ContextRequirements.Field f : fields) {
			if (!f.required) {
				optionals.append("\t" + f.name + "(" + f.type + "): " + f.description);
			}
		}
		logger.debug("{}", optionals.toString());
		for (ContextRequirements.Field f : fields) {
			StringBuilder field = new StringBuilder();
			field.append("Loading '" + f.name + "' from ");
			if (f.type.equals(ContextRequirements.FieldType.KEYPAIR)) {
				field.append("'" + f.name + "_SHARED' and '" + f.name + "_SECRET'");
				String shared = configuration.getProperties().getProperty(f.name + "_SHARED");
				String secret = configuration.getProperties().getProperty(f.name + "_SECRET");
				logger.debug("shared:{}, secret:{}", new Object[] { shared, secret });
				if (shared != null && secret != null) {
					values[i] = ProviderContext.Value.parseValue(f, shared, secret);
				} else if (f.required) {
					throw new IllegalArgumentException("Missing required field: " + f.name);
				}
			} else {
				field.append("'" + f.name + "'");
				String value = configuration.getProperties().getProperty(f.name);
				logger.debug("value:{}", new Object[] { value });
				if (value != null) {
					values[i] = ProviderContext.Value.parseValue(f, value);
				} else if (f.required) {
					throw new IllegalArgumentException("Missing required field: " + f.name);
				}
			}
			i++;
			logger.debug("{}", field.toString());
		}

		ProviderContext ctx = cloud.createContext(account, regionId, values);
		CloudProvider provider = ctx.connect();
		return (ServiceProvider) provider;
	}
}
