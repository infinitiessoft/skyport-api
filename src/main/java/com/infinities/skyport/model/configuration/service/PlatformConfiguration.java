package com.infinities.skyport.model.configuration.service;

import java.io.Serializable;

import com.infinities.skyport.model.configuration.platform.CDNConfiguration;
import com.infinities.skyport.model.configuration.platform.DataWarehouseConfiguration;
import com.infinities.skyport.model.configuration.platform.KeyValueDatabaseConfiguration;
import com.infinities.skyport.model.configuration.platform.MessageQueueConfiguration;
import com.infinities.skyport.model.configuration.platform.MonitoringConfiguration;
import com.infinities.skyport.model.configuration.platform.PushNotificationConfiguration;
import com.infinities.skyport.model.configuration.platform.RelationalDatabaseConfiguration;

public class PlatformConfiguration implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CDNConfiguration cDNConfiguration = new CDNConfiguration();
	private DataWarehouseConfiguration dataWarehouseConfiguration = new DataWarehouseConfiguration();
	private KeyValueDatabaseConfiguration keyValueDatabaseConfiguration = new KeyValueDatabaseConfiguration();
	private MessageQueueConfiguration messageQueueConfiguration = new MessageQueueConfiguration();
	private PushNotificationConfiguration pushNotificationConfiguration = new PushNotificationConfiguration();
	private RelationalDatabaseConfiguration relationalDatabaseConfiguration = new RelationalDatabaseConfiguration();
	private MonitoringConfiguration monitoringConfiguration = new MonitoringConfiguration();


	public CDNConfiguration getcDNConfiguration() {
		return cDNConfiguration;
	}

	public void setcDNConfiguration(CDNConfiguration cDNConfiguration) {
		this.cDNConfiguration = cDNConfiguration;
	}

	public DataWarehouseConfiguration getDataWarehouseConfiguration() {
		return dataWarehouseConfiguration;
	}

	public void setDataWarehouseConfiguration(DataWarehouseConfiguration dataWarehouseConfiguration) {
		this.dataWarehouseConfiguration = dataWarehouseConfiguration;
	}

	public KeyValueDatabaseConfiguration getKeyValueDatabaseConfiguration() {
		return keyValueDatabaseConfiguration;
	}

	public void setKeyValueDatabaseConfiguration(KeyValueDatabaseConfiguration keyValueDatabaseConfiguration) {
		this.keyValueDatabaseConfiguration = keyValueDatabaseConfiguration;
	}

	public MessageQueueConfiguration getMessageQueueConfiguration() {
		return messageQueueConfiguration;
	}

	public void setMessageQueueConfiguration(MessageQueueConfiguration messageQueueConfiguration) {
		this.messageQueueConfiguration = messageQueueConfiguration;
	}

	public PushNotificationConfiguration getPushNotificationConfiguration() {
		return pushNotificationConfiguration;
	}

	public void setPushNotificationConfiguration(PushNotificationConfiguration pushNotificationConfiguration) {
		this.pushNotificationConfiguration = pushNotificationConfiguration;
	}

	public RelationalDatabaseConfiguration getRelationalDatabaseConfiguration() {
		return relationalDatabaseConfiguration;
	}

	public void setRelationalDatabaseConfiguration(RelationalDatabaseConfiguration relationalDatabaseConfiguration) {
		this.relationalDatabaseConfiguration = relationalDatabaseConfiguration;
	}

	public MonitoringConfiguration getMonitoringConfiguration() {
		return monitoringConfiguration;
	}

	public void setMonitoringConfiguration(MonitoringConfiguration monitoringConfiguration) {
		this.monitoringConfiguration = monitoringConfiguration;
	}

	@Override
	public PlatformConfiguration clone() {
		PlatformConfiguration clone = new PlatformConfiguration();
		clone.cDNConfiguration = cDNConfiguration.clone();
		clone.dataWarehouseConfiguration = dataWarehouseConfiguration.clone();
		clone.keyValueDatabaseConfiguration = keyValueDatabaseConfiguration.clone();
		clone.messageQueueConfiguration = messageQueueConfiguration.clone();
		clone.pushNotificationConfiguration = pushNotificationConfiguration.clone();
		clone.relationalDatabaseConfiguration = relationalDatabaseConfiguration.clone();
		clone.monitoringConfiguration = monitoringConfiguration.clone();
		return clone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cDNConfiguration == null) ? 0 : cDNConfiguration.hashCode());
		result = prime * result + ((dataWarehouseConfiguration == null) ? 0 : dataWarehouseConfiguration.hashCode());
		result = prime * result + ((keyValueDatabaseConfiguration == null) ? 0 : keyValueDatabaseConfiguration.hashCode());
		result = prime * result + ((messageQueueConfiguration == null) ? 0 : messageQueueConfiguration.hashCode());
		result = prime * result + ((monitoringConfiguration == null) ? 0 : monitoringConfiguration.hashCode());
		result = prime * result + ((pushNotificationConfiguration == null) ? 0 : pushNotificationConfiguration.hashCode());
		result = prime * result
				+ ((relationalDatabaseConfiguration == null) ? 0 : relationalDatabaseConfiguration.hashCode());
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
		PlatformConfiguration other = (PlatformConfiguration) obj;
		if (cDNConfiguration == null) {
			if (other.cDNConfiguration != null)
				return false;
		} else if (!cDNConfiguration.equals(other.cDNConfiguration))
			return false;
		if (dataWarehouseConfiguration == null) {
			if (other.dataWarehouseConfiguration != null)
				return false;
		} else if (!dataWarehouseConfiguration.equals(other.dataWarehouseConfiguration))
			return false;
		if (keyValueDatabaseConfiguration == null) {
			if (other.keyValueDatabaseConfiguration != null)
				return false;
		} else if (!keyValueDatabaseConfiguration.equals(other.keyValueDatabaseConfiguration))
			return false;
		if (messageQueueConfiguration == null) {
			if (other.messageQueueConfiguration != null)
				return false;
		} else if (!messageQueueConfiguration.equals(other.messageQueueConfiguration))
			return false;
		if (monitoringConfiguration == null) {
			if (other.monitoringConfiguration != null)
				return false;
		} else if (!monitoringConfiguration.equals(other.monitoringConfiguration))
			return false;
		if (pushNotificationConfiguration == null) {
			if (other.pushNotificationConfiguration != null)
				return false;
		} else if (!pushNotificationConfiguration.equals(other.pushNotificationConfiguration))
			return false;
		if (relationalDatabaseConfiguration == null) {
			if (other.relationalDatabaseConfiguration != null)
				return false;
		} else if (!relationalDatabaseConfiguration.equals(other.relationalDatabaseConfiguration))
			return false;
		return true;
	}

}
