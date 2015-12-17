package com.infinities.skyport.model.configuration.service;

import java.io.Serializable;

import com.infinities.skyport.model.configuration.storage.OfflineStoreConfiguration;
import com.infinities.skyport.model.configuration.storage.OnlineStorageConfiguration;

public class StorageConfiguration implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OfflineStoreConfiguration offlineStoreConfiguration = new OfflineStoreConfiguration();
	private OnlineStorageConfiguration onlineStorageConfiguration = new OnlineStorageConfiguration();


	public OfflineStoreConfiguration getOfflineStoreConfiguration() {
		return offlineStoreConfiguration;
	}

	public void setOfflineStoreConfiguration(OfflineStoreConfiguration offlineStoreConfiguration) {
		this.offlineStoreConfiguration = offlineStoreConfiguration;
	}

	public OnlineStorageConfiguration getOnlineStorageConfiguration() {
		return onlineStorageConfiguration;
	}

	public void setOnlineStorageConfiguration(OnlineStorageConfiguration onlineStorageConfiguration) {
		this.onlineStorageConfiguration = onlineStorageConfiguration;
	}

	@Override
	public StorageConfiguration clone() {
		StorageConfiguration clone = new StorageConfiguration();
		clone.setOfflineStoreConfiguration(offlineStoreConfiguration.clone());
		clone.setOnlineStorageConfiguration(onlineStorageConfiguration.clone());
		return clone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((offlineStoreConfiguration == null) ? 0 : offlineStoreConfiguration.hashCode());
		result = prime * result + ((onlineStorageConfiguration == null) ? 0 : onlineStorageConfiguration.hashCode());
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
		StorageConfiguration other = (StorageConfiguration) obj;
		if (offlineStoreConfiguration == null) {
			if (other.offlineStoreConfiguration != null)
				return false;
		} else if (!offlineStoreConfiguration.equals(other.offlineStoreConfiguration))
			return false;
		if (onlineStorageConfiguration == null) {
			if (other.onlineStorageConfiguration != null)
				return false;
		} else if (!onlineStorageConfiguration.equals(other.onlineStorageConfiguration))
			return false;
		return true;
	}

}
