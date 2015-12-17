package com.infinities.skyport.timeout.service;

import java.util.concurrent.ExecutorService;

import org.dasein.cloud.platform.CDNSupport;
import org.dasein.cloud.platform.KeyValueDatabaseSupport;
import org.dasein.cloud.platform.MQSupport;
import org.dasein.cloud.platform.MonitoringSupport;
import org.dasein.cloud.platform.PlatformServices;
import org.dasein.cloud.platform.PushNotificationSupport;
import org.dasein.cloud.platform.RelationalDatabaseSupport;
import org.dasein.cloud.platform.bigdata.DataWarehouseSupport;

import com.infinities.skyport.exception.InitializationException;
import com.infinities.skyport.model.configuration.service.PlatformConfiguration;
import com.infinities.skyport.timeout.ServiceProviderTimeLimiter;

public class TimedPlatformServices implements PlatformServices {

	private PlatformServices inner;
	private CDNSupport timedCDNSupport;
	private DataWarehouseSupport timedDataWarehouseSupport;
	private KeyValueDatabaseSupport timedKeyValueDatabaseSupport;
	private MQSupport timedMQSupport;
	private PushNotificationSupport timedPushNotificationSupport;
	private RelationalDatabaseSupport timedRelationalDatabaseSupport;
	private MonitoringSupport timedMonitoringSupport;


	public TimedPlatformServices(PlatformServices inner, PlatformConfiguration platformConfiguration,
			ExecutorService executor) throws InitializationException {
		this.inner = inner;
		ServiceProviderTimeLimiter timedLimiter = new ServiceProviderTimeLimiter(executor);
		if (inner.hasCDNSupport()) {
			this.timedCDNSupport =
					timedLimiter.newProxy(inner.getCDNSupport(), CDNSupport.class,
							platformConfiguration.getcDNConfiguration());
		}
		if (inner.hasDataWarehouseSupport()) {
			this.timedDataWarehouseSupport =
					timedLimiter.newProxy(inner.getDataWarehouseSupport(), DataWarehouseSupport.class,
							platformConfiguration.getDataWarehouseConfiguration());
		}
		if (inner.hasKeyValueDatabaseSupport()) {
			this.timedKeyValueDatabaseSupport =
					timedLimiter.newProxy(inner.getKeyValueDatabaseSupport(), KeyValueDatabaseSupport.class,
							platformConfiguration.getKeyValueDatabaseConfiguration());
		}
		if (inner.hasMessageQueueSupport()) {
			this.timedMQSupport =
					timedLimiter.newProxy(inner.getMessageQueueSupport(), MQSupport.class,
							platformConfiguration.getMessageQueueConfiguration());
		}
		if (inner.hasPushNotificationSupport()) {
			this.timedPushNotificationSupport =
					timedLimiter.newProxy(inner.getPushNotificationSupport(), PushNotificationSupport.class,
							platformConfiguration.getPushNotificationConfiguration());
		}
		if (inner.hasRelationalDatabaseSupport()) {
			this.timedRelationalDatabaseSupport =
					timedLimiter.newProxy(inner.getRelationalDatabaseSupport(), RelationalDatabaseSupport.class,
							platformConfiguration.getRelationalDatabaseConfiguration());
		}
		if (inner.hasMonitoringSupport()) {
			this.timedMonitoringSupport =
					timedLimiter.newProxy(inner.getMonitoringSupport(), MonitoringSupport.class,
							platformConfiguration.getMonitoringConfiguration());
		}
	}

	@Override
	public CDNSupport getCDNSupport() {
		return timedCDNSupport;
	}

	@Override
	public DataWarehouseSupport getDataWarehouseSupport() {
		return timedDataWarehouseSupport;
	}

	@Override
	public KeyValueDatabaseSupport getKeyValueDatabaseSupport() {
		return timedKeyValueDatabaseSupport;
	}

	@Override
	public MQSupport getMessageQueueSupport() {
		return timedMQSupport;
	}

	@Override
	public PushNotificationSupport getPushNotificationSupport() {
		return timedPushNotificationSupport;
	}

	@Override
	public RelationalDatabaseSupport getRelationalDatabaseSupport() {
		return timedRelationalDatabaseSupport;
	}

	@Override
	public MonitoringSupport getMonitoringSupport() {
		return timedMonitoringSupport;
	}

	@Override
	public boolean hasCDNSupport() {
		return inner.hasCDNSupport();
	}

	@Override
	public boolean hasDataWarehouseSupport() {
		return inner.hasDataWarehouseSupport();
	}

	@Override
	public boolean hasKeyValueDatabaseSupport() {
		return inner.hasKeyValueDatabaseSupport();
	}

	@Override
	public boolean hasMessageQueueSupport() {
		return inner.hasMessageQueueSupport();
	}

	@Override
	public boolean hasPushNotificationSupport() {
		return inner.hasPushNotificationSupport();
	}

	@Override
	public boolean hasRelationalDatabaseSupport() {
		return inner.hasRelationalDatabaseSupport();
	}

	@Override
	public boolean hasMonitoringSupport() {
		return inner.hasMonitoringSupport();
	}

}
