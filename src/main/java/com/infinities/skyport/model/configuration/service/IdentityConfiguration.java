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
package com.infinities.skyport.model.configuration.service;

import java.io.Serializable;

import com.infinities.skyport.model.configuration.identity.IdentityAndAccessConfiguration;
import com.infinities.skyport.model.configuration.identity.ShellKeyConfiguration;

public class IdentityConfiguration implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IdentityAndAccessConfiguration identityAndAccessConfiguration = new IdentityAndAccessConfiguration();
	private ShellKeyConfiguration shellKeyConfiguration = new ShellKeyConfiguration();


	public IdentityAndAccessConfiguration getIdentityAndAccessConfiguration() {
		return identityAndAccessConfiguration;
	}

	public void setIdentityAndAccessConfiguration(IdentityAndAccessConfiguration identityAndAccessConfiguration) {
		this.identityAndAccessConfiguration = identityAndAccessConfiguration;
	}

	public ShellKeyConfiguration getShellKeyConfiguration() {
		return shellKeyConfiguration;
	}

	public void setShellKeyConfiguration(ShellKeyConfiguration shellKeyConfiguration) {
		this.shellKeyConfiguration = shellKeyConfiguration;
	}

	@Override
	public IdentityConfiguration clone() {
		IdentityConfiguration clone = new IdentityConfiguration();
		clone.identityAndAccessConfiguration = identityAndAccessConfiguration.clone();
		clone.shellKeyConfiguration = shellKeyConfiguration.clone();

		return clone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identityAndAccessConfiguration == null) ? 0 : identityAndAccessConfiguration.hashCode());
		result = prime * result + ((shellKeyConfiguration == null) ? 0 : shellKeyConfiguration.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IdentityConfiguration other = (IdentityConfiguration) obj;
		if (identityAndAccessConfiguration == null) {
			if (other.identityAndAccessConfiguration != null)
				return false;
		} else if (!identityAndAccessConfiguration.equals(other.identityAndAccessConfiguration))
			return false;
		if (shellKeyConfiguration == null) {
			if (other.shellKeyConfiguration != null)
				return false;
		} else if (!shellKeyConfiguration.equals(other.shellKeyConfiguration))
			return false;
		return true;
	}

}
