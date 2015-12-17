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
package com.infinities.skyport.model.configuration;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Properties;

import com.infinities.skyport.model.PoolConfig;
import com.infinities.skyport.model.PoolSize;
import com.infinities.skyport.model.configuration.service.AdminConfiguration;
import com.infinities.skyport.model.configuration.service.CIConfiguration;
import com.infinities.skyport.model.configuration.service.ComputeConfiguration;
import com.infinities.skyport.model.configuration.service.DataCenterConfiguration;
import com.infinities.skyport.model.configuration.service.IdentityConfiguration;
import com.infinities.skyport.model.configuration.service.NetworkConfiguration;
import com.infinities.skyport.model.configuration.service.PlatformConfiguration;
import com.infinities.skyport.model.configuration.service.StorageConfiguration;

public class Configuration implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	private String endpoint;
	private String regionId;
	private String cloudName;
	private String providerName;
	private String account;
	private Properties properties = new Properties();
	private String providerClass;
	private Calendar modifiedDate;
	private Boolean status = false;
	private Boolean timeoutable = true;
	private Boolean cacheable = false;
	private PoolConfig shortPoolConfig = new PoolConfig(PoolSize.SHORT);
	private PoolConfig mediumPoolConfig = new PoolConfig(PoolSize.MEDIUM);
	private PoolConfig longPoolConfig = new PoolConfig(PoolSize.LONG);

	private AdminConfiguration adminConfiguration = new AdminConfiguration();
	private CIConfiguration cIConfiguration = new CIConfiguration();
	private ComputeConfiguration computeConfiguration = new ComputeConfiguration();
	private IdentityConfiguration identityConfiguration = new IdentityConfiguration();
	private NetworkConfiguration networkConfiguration = new NetworkConfiguration();
	private PlatformConfiguration platformConfiguration = new PlatformConfiguration();
	private StorageConfiguration storageConfiguration = new StorageConfiguration();
	private DataCenterConfiguration dataCenterConfiguration = new DataCenterConfiguration();


	public String getEndpoint() {
		return endpoint;
	}

	public String getRegionId() {
		return regionId;
	}

	public String getCloudName() {
		return cloudName;
	}

	public String getProviderName() {
		return providerName;
	}

	public String getAccount() {
		return account;
	}

	public Properties getProperties() {
		return properties;
	}

	public String getProviderClass() {
		return providerClass;
	}

	public Boolean getStatus() {
		return status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setModifiedDate(Calendar modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public PoolConfig getLongPoolConfig() {
		return longPoolConfig;
	}

	public PoolConfig getMediumPoolConfig() {
		return mediumPoolConfig;
	}

	public PoolConfig getShortPoolConfig() {
		return shortPoolConfig;
	}

	public Calendar getModifiedDate() {
		return modifiedDate;
	}

	// public AdminConfiguration getAdminServices() {
	// return adminConfiguration;
	// }
	//
	// public CIConfiguration getCIServices() {
	// return cIConfiguration;
	// }
	//
	// public ComputeConfiguration getComputeServices() {
	// return computeConfiguration;
	// }
	//
	// public DataCenterConfiguration getDataCenterServices() {
	// return dataCenterConfiguration;
	// }
	//
	// public IdentityConfiguration getIdentityServices() {
	// return identityConfiguration;
	// }
	//
	// public NetworkConfiguration getNetworkServices() {
	// return networkConfiguration;
	// }
	//
	// public PlatformConfiguration getPlatformServices() {
	// return platformConfiguration;
	// }
	//
	// public StorageConfiguration getStorageServices() {
	// return storageConfiguration;
	// }

	public Boolean getTimeoutable() {
		return timeoutable;
	}

	public void setTimeoutable(Boolean timeoutable) {
		this.timeoutable = timeoutable;
	}

	public Boolean getCacheable() {
		return cacheable;
	}

	public void setCacheable(Boolean cacheable) {
		this.cacheable = cacheable;
	}

	public AdminConfiguration getAdminConfiguration() {
		return adminConfiguration;
	}

	public void setAdminConfiguration(AdminConfiguration adminConfiguration) {
		this.adminConfiguration = adminConfiguration;
	}

	public CIConfiguration getcIConfiguration() {
		return cIConfiguration;
	}

	public void setcIConfiguration(CIConfiguration cIConfiguration) {
		this.cIConfiguration = cIConfiguration;
	}

	public ComputeConfiguration getComputeConfiguration() {
		return computeConfiguration;
	}

	public void setComputeConfiguration(ComputeConfiguration computeConfiguration) {
		this.computeConfiguration = computeConfiguration;
	}

	public IdentityConfiguration getIdentityConfiguration() {
		return identityConfiguration;
	}

	public void setIdentityConfiguration(IdentityConfiguration identityConfiguration) {
		this.identityConfiguration = identityConfiguration;
	}

	public NetworkConfiguration getNetworkConfiguration() {
		return networkConfiguration;
	}

	public void setNetworkConfiguration(NetworkConfiguration networkConfiguration) {
		this.networkConfiguration = networkConfiguration;
	}

	public PlatformConfiguration getPlatformConfiguration() {
		return platformConfiguration;
	}

	public void setPlatformConfiguration(PlatformConfiguration platformConfiguration) {
		this.platformConfiguration = platformConfiguration;
	}

	public StorageConfiguration getStorageConfiguration() {
		return storageConfiguration;
	}

	public void setStorageConfiguration(StorageConfiguration storageConfiguration) {
		this.storageConfiguration = storageConfiguration;
	}

	public DataCenterConfiguration getDataCenterConfiguration() {
		return dataCenterConfiguration;
	}

	public void setDataCenterConfiguration(DataCenterConfiguration dataCenterConfiguration) {
		this.dataCenterConfiguration = dataCenterConfiguration;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}

	public void setCloudName(String cloudName) {
		this.cloudName = cloudName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public void setProviderClass(String providerClass) {
		this.providerClass = providerClass;
	}

	public void setShortPoolConfig(PoolConfig shortPoolConfig) {
		this.shortPoolConfig = shortPoolConfig;
	}

	public void setMediumPoolConfig(PoolConfig mediumPoolConfig) {
		this.mediumPoolConfig = mediumPoolConfig;
	}

	public void setLongPoolConfig(PoolConfig longPoolConfig) {
		this.longPoolConfig = longPoolConfig;
	}

	@Override
	public Configuration clone() {
		Configuration clone = new Configuration();
		clone.endpoint = endpoint;
		clone.regionId = regionId;
		clone.cloudName = cloudName;
		clone.providerName = providerName;
		clone.account = account;
		clone.properties = (Properties) properties.clone();
		clone.providerClass = providerClass;
		clone.status = status == null ? null : status.booleanValue();
		clone.id = id;
		clone.modifiedDate = modifiedDate == null ? null : (Calendar) modifiedDate.clone();
		clone.shortPoolConfig = shortPoolConfig.clone();
		clone.mediumPoolConfig = mediumPoolConfig.clone();
		clone.longPoolConfig = longPoolConfig.clone();
		clone.timeoutable = timeoutable == null ? null : timeoutable.booleanValue();
		clone.cacheable = cacheable == null ? null : cacheable.booleanValue();
		clone.adminConfiguration = adminConfiguration.clone();
		clone.cIConfiguration = cIConfiguration.clone();
		clone.computeConfiguration = computeConfiguration.clone();
		clone.identityConfiguration = identityConfiguration.clone();
		clone.networkConfiguration = networkConfiguration.clone();
		clone.platformConfiguration = platformConfiguration.clone();
		clone.storageConfiguration = storageConfiguration.clone();
		clone.dataCenterConfiguration = dataCenterConfiguration.clone();
		return clone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Configuration other = (Configuration) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public boolean equalsTo(Configuration other) {
		if (this == other)
			return true;
		if (other == null)
			return false;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (adminConfiguration == null) {
			if (other.adminConfiguration != null)
				return false;
		} else if (!adminConfiguration.equals(other.adminConfiguration))
			return false;
		if (cIConfiguration == null) {
			if (other.cIConfiguration != null)
				return false;
		} else if (!cIConfiguration.equals(other.cIConfiguration))
			return false;
		if (cacheable == null) {
			if (other.cacheable != null)
				return false;
		} else if (!cacheable.equals(other.cacheable))
			return false;
		if (cloudName == null) {
			if (other.cloudName != null)
				return false;
		} else if (!cloudName.equals(other.cloudName))
			return false;
		if (computeConfiguration == null) {
			if (other.computeConfiguration != null)
				return false;
		} else if (!computeConfiguration.equals(other.computeConfiguration))
			return false;
		if (dataCenterConfiguration == null) {
			if (other.dataCenterConfiguration != null)
				return false;
		} else if (!dataCenterConfiguration.equals(other.dataCenterConfiguration))
			return false;
		if (endpoint == null) {
			if (other.endpoint != null)
				return false;
		} else if (!endpoint.equals(other.endpoint))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (identityConfiguration == null) {
			if (other.identityConfiguration != null)
				return false;
		} else if (!identityConfiguration.equals(other.identityConfiguration))
			return false;
		if (longPoolConfig == null) {
			if (other.longPoolConfig != null)
				return false;
		} else if (!longPoolConfig.equals(other.longPoolConfig))
			return false;
		if (mediumPoolConfig == null) {
			if (other.mediumPoolConfig != null)
				return false;
		} else if (!mediumPoolConfig.equals(other.mediumPoolConfig))
			return false;
		if (modifiedDate == null) {
			if (other.modifiedDate != null)
				return false;
		} else if (!modifiedDate.equals(other.modifiedDate))
			return false;
		if (networkConfiguration == null) {
			if (other.networkConfiguration != null)
				return false;
		} else if (!networkConfiguration.equals(other.networkConfiguration))
			return false;
		if (platformConfiguration == null) {
			if (other.platformConfiguration != null)
				return false;
		} else if (!platformConfiguration.equals(other.platformConfiguration))
			return false;
		if (properties == null) {
			if (other.properties != null)
				return false;
		} else if (!properties.equals(other.properties))
			return false;
		if (providerClass == null) {
			if (other.providerClass != null)
				return false;
		} else if (!providerClass.equals(other.providerClass))
			return false;
		if (providerName == null) {
			if (other.providerName != null)
				return false;
		} else if (!providerName.equals(other.providerName))
			return false;
		if (regionId == null) {
			if (other.regionId != null)
				return false;
		} else if (!regionId.equals(other.regionId))
			return false;
		if (shortPoolConfig == null) {
			if (other.shortPoolConfig != null)
				return false;
		} else if (!shortPoolConfig.equals(other.shortPoolConfig))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (storageConfiguration == null) {
			if (other.storageConfiguration != null)
				return false;
		} else if (!storageConfiguration.equals(other.storageConfiguration))
			return false;
		if (timeoutable == null) {
			if (other.timeoutable != null)
				return false;
		} else if (!timeoutable.equals(other.timeoutable))
			return false;
		return true;
	}

}
