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
