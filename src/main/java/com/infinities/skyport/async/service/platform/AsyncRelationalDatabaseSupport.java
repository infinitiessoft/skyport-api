package com.infinities.skyport.async.service.platform;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.dasein.cloud.AccessControlledService;
import org.dasein.cloud.CloudException;
import org.dasein.cloud.InternalException;
import org.dasein.cloud.ResourceStatus;
import org.dasein.cloud.Tag;
import org.dasein.cloud.TimeWindow;
import org.dasein.cloud.identity.ServiceAction;
import org.dasein.cloud.platform.ConfigurationParameter;
import org.dasein.cloud.platform.Database;
import org.dasein.cloud.platform.DatabaseBackup;
import org.dasein.cloud.platform.DatabaseConfiguration;
import org.dasein.cloud.platform.DatabaseEngine;
import org.dasein.cloud.platform.DatabaseProduct;
import org.dasein.cloud.platform.DatabaseSnapshot;
import org.dasein.cloud.platform.RelationalDatabaseCapabilities;
import org.dasein.cloud.platform.RelationalDatabaseSupport;

import com.infinities.skyport.async.AsyncResult;

public interface AsyncRelationalDatabaseSupport extends AccessControlledService {

	static public final ServiceAction ANY = new ServiceAction("RDBMS:ANY");

	static public final ServiceAction ALTER_DB = new ServiceAction("RDBMS:ALTER_DB");
	static public final ServiceAction CREATE_RDBMS = new ServiceAction("RDBMS:CREATE_RDBMS");
	static public final ServiceAction CREATE_RDBMS_SNAP = new ServiceAction("RDBMS:CREATE_RDBMS_SNAP");
	static public final ServiceAction CREATE_RDBMS_FROM_SNAP = new ServiceAction("RDBMS:CREATE_RDBMS_FROM_SNAP");
	static public final ServiceAction GET_RDBMS = new ServiceAction("RDBMS:GET_RDBMS");
	static public final ServiceAction GET_RDBMS_SNAP = new ServiceAction("RDBMS:GET_RDBMS_SNAP");
	static public final ServiceAction LIST_RDBMS = new ServiceAction("RDBMS:LIST_RDBMS");
	static public final ServiceAction LIST_RDBMS_SNAP = new ServiceAction("RDBMS:LIST_RDBMS_SNAP");
	static public final ServiceAction REMOVE_RDBMS = new ServiceAction("RDBMS:REMOVE_RDBMS");
	static public final ServiceAction REMOVE_RDBMS_SNAP = new ServiceAction("RDBMS:REMOVE_RDBMS_SNAP");
	static public final ServiceAction RESTART = new ServiceAction("RDBMS:RESTART");
	static public final ServiceAction UPDATE_RDBMS_FIREWALL = new ServiceAction("RDBMS:UPDATE_FIREWALL");


	public AsyncResult<Void> addAccess(String providerDatabaseId, String sourceCidr) throws CloudException,
			InternalException;

	public AsyncResult<Void> alterDatabase(String providerDatabaseId, boolean applyImmediately, String productSize,
			int storageInGigabytes, String configurationId, String newAdminUser, String newAdminPassword, int newPort,
			int snapshotRetentionInDays, TimeWindow preferredMaintenanceWindow, TimeWindow preferredBackupWindow)
			throws CloudException, InternalException;

	public @Nonnull AsyncResult<String> createFromScratch(String dataSourceName, DatabaseProduct product,
			String databaseVersion, String withAdminUser, String withAdminPassword, int hostPort) throws CloudException,
			InternalException;

	public @Nonnull AsyncResult<String> createFromLatest(String dataSourceName, String providerDatabaseId,
			String productSize, String providerDataCenterId, int hostPort) throws InternalException, CloudException;

	public @Nonnull AsyncResult<String> createFromSnapshot(String dataSourceName, String providerDatabaseId,
			String providerDbSnapshotId, String productSize, String providerDataCenterId, int hostPort)
			throws CloudException, InternalException;

	public @Nonnull AsyncResult<String> createFromTimestamp(String dataSourceName, String providerDatabaseId,
			long beforeTimestamp, String productSize, String providerDataCenterId, int hostPort) throws InternalException,
			CloudException;

	/**
	 * Provides access to meta-data about RDS capabilities in the current region
	 * of this cloud.
	 *
	 * @return a description of the features supported by this region of this
	 *         cloud
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 */
	public @Nonnull RelationalDatabaseCapabilities getCapabilities() throws InternalException, CloudException;

	public @Nullable AsyncResult<DatabaseConfiguration> getConfiguration(String providerConfigurationId)
			throws CloudException, InternalException;

	public @Nullable AsyncResult<Database> getDatabase(String providerDatabaseId) throws CloudException, InternalException;

	public @Nonnull AsyncResult<Iterable<DatabaseEngine>> getDatabaseEngines() throws CloudException, InternalException;

	public @Nullable AsyncResult<String> getDefaultVersion(@Nonnull DatabaseEngine forEngine) throws CloudException,
			InternalException;

	public @Nonnull AsyncResult<Iterable<String>> getSupportedVersions(@Nonnull DatabaseEngine forEngine)
			throws CloudException, InternalException;

	/**
	 * List supported database products
	 * 
	 * @param forEngine
	 *            database engine, e.g. MySQL, SQL Server EE, etc.
	 * @return iteration of the database products supported by the engine
	 * @throws CloudException
	 * @throws InternalException
	 * @since 2014.08 for consistency
	 */
	public @Nonnull AsyncResult<Iterable<DatabaseProduct>> listDatabaseProducts(@Nonnull DatabaseEngine forEngine)
			throws CloudException, InternalException;

	public @Nullable AsyncResult<DatabaseSnapshot> getSnapshot(String providerDbSnapshotId) throws CloudException,
			InternalException;

	public boolean isSubscribed() throws CloudException, InternalException;

	public @Nonnull AsyncResult<Iterable<String>> listAccess(String toProviderDatabaseId) throws CloudException,
			InternalException;

	public @Nonnull AsyncResult<Iterable<DatabaseConfiguration>> listConfigurations() throws CloudException,
			InternalException;

	public @Nonnull AsyncResult<Iterable<ResourceStatus>> listDatabaseStatus() throws CloudException, InternalException;

	public @Nonnull AsyncResult<Iterable<Database>> listDatabases() throws CloudException, InternalException;

	public @Nonnull AsyncResult<Iterable<ConfigurationParameter>> listParameters(String forProviderConfigurationId)
			throws CloudException, InternalException;

	public @Nonnull AsyncResult<Iterable<DatabaseSnapshot>> listSnapshots(String forOptionalProviderDatabaseId)
			throws CloudException, InternalException;

	public AsyncResult<Void> removeConfiguration(String providerConfigurationId) throws CloudException, InternalException;

	public AsyncResult<Void> removeDatabase(String providerDatabaseId) throws CloudException, InternalException;

	public AsyncResult<Void> removeSnapshot(String providerSnapshotId) throws CloudException, InternalException;

	public AsyncResult<Void> resetConfiguration(String providerConfigurationId, String... parameters) throws CloudException,
			InternalException;

	public AsyncResult<Void> restart(String providerDatabaseId, boolean blockUntilDone) throws CloudException,
			InternalException;

	public AsyncResult<Void> revokeAccess(String providerDatabaseId, String sourceCide) throws CloudException,
			InternalException;

	public AsyncResult<Void> updateConfiguration(String providerConfigurationId, ConfigurationParameter... parameters)
			throws CloudException, InternalException;

	public @Nonnull AsyncResult<DatabaseSnapshot> snapshot(String providerDatabaseId, String name) throws CloudException,
			InternalException;

	//
	// New Backup section
	//

	/*
	 * Obtain a valid DatabaseBackup object for the given database instance
	 * where the backup was taken prior to the given time.
	 * 
	 * Throws CloudException on failure
	 */
	public @Nullable AsyncResult<DatabaseBackup> getUsableBackup(String providerDbId, String beforeTimestamp)
			throws CloudException, InternalException;

	/*
	 * Obtain a list of DatabaseBackup objects for a given database, or for all
	 * databases if null.
	 * 
	 * Throws CloudException on failure
	 */
	public @Nonnull AsyncResult<Iterable<DatabaseBackup>> listBackups(String forOptionalProviderDatabaseId)
			throws CloudException, InternalException;

	/*
	 * Create a new database from the passed in backup object
	 * 
	 * Throws CloudException on failure
	 */
	public AsyncResult<Void> createFromBackup(DatabaseBackup backup, String databaseCloneToName) throws CloudException,
			InternalException;

	/*
	 * Remove specified database backup
	 * 
	 * Throws CloudException on failure
	 */
	public AsyncResult<Void> removeBackup(DatabaseBackup backup) throws CloudException, InternalException;

	/*
	 * Restore the passed in DatabaseBackup to its current database instance.
	 * 
	 * Throws CloudException on failure
	 */
	public AsyncResult<Void> restoreBackup(DatabaseBackup backup) throws CloudException, InternalException;

	/**
	 * Removes meta-data from a providerDatabaseId. If tag values are set, their
	 * removal is dependent on underlying cloud provider behavior. They may be
	 * removed only if the tag value matches or they may be removed regardless
	 * of the value.
	 * 
	 * @param providerDatabaseId
	 *            the Database to update
	 * @param tags
	 *            the meta-data tags to remove
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	public AsyncResult<Void> removeTags(@Nonnull String providerDatabaseId, @Nonnull Tag... tags) throws CloudException,
			InternalException;

	/**
	 * Removes meta-data from multiple providerDatabaseIds. If tag values are
	 * set, their removal is dependent on underlying cloud provider behavior.
	 * They may be removed only if the tag value matches or they may be removed
	 * regardless of the value.
	 * 
	 * @param providerDatabaseIds
	 *            the Databases to update
	 * @param tags
	 *            the meta-data tags to remove
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	public AsyncResult<Void> removeTags(@Nonnull String[] providerDatabaseIds, @Nonnull Tag... tags) throws CloudException,
			InternalException;

	/**
	 * Updates meta-data for a providerDatabaseId with the new values. It will
	 * not overwrite any value that currently exists unless it appears in the
	 * tags you submit.
	 * 
	 * @param providerDatabaseId
	 *            the Database to update
	 * @param tags
	 *            the meta-data tags to set
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	public AsyncResult<Void> updateTags(@Nonnull String providerDatabaseId, @Nonnull Tag... tags) throws CloudException,
			InternalException;

	/**
	 * Updates meta-data for multiple providerDatabaseIds with the new values.
	 * It will not overwrite any value that currently exists unless it appears
	 * in the tags you submit.
	 * 
	 * @param providerDatabaseIds
	 *            the Databases to update
	 * @param tags
	 *            the meta-data tags to set
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	public AsyncResult<Void> updateTags(@Nonnull String[] providerDatabaseIds, @Nonnull Tag... tags) throws CloudException,
			InternalException;

	/**
	 * Set meta-data for a providerDatabaseId. Remove any tags that were not
	 * provided by the incoming tags, and add or overwrite any new or
	 * pre-existing tags.
	 *
	 * @param providerDatabaseId
	 *            the Database to set
	 * @param tags
	 *            the meta-data tags to set
	 * @throws CloudException
	 * @throws InternalException
	 */
	public AsyncResult<Void> setTags(@Nonnull String providerDatabaseId, @Nonnull Tag... tags) throws CloudException,
			InternalException;

	/**
	 * Set meta-data for multiple providerDatabaseIds. Remove any tags that were
	 * not provided by the incoming tags, and add or overwrite any new or
	 * pre-existing tags.
	 *
	 * @param providerDatabaseIds
	 *            the Databases to set
	 * @param tags
	 *            the meta-data tags to set
	 * @throws CloudException
	 * @throws InternalException
	 */
	public AsyncResult<Void> setTags(@Nonnull String[] providerDatabaseIds, @Nonnull Tag... tags) throws CloudException,
			InternalException;

	RelationalDatabaseSupport getSupport();
}
