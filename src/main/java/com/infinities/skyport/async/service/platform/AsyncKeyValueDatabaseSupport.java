package com.infinities.skyport.async.service.platform;

import java.util.Map;
import java.util.Set;

import javax.annotation.Nonnull;

import org.dasein.cloud.AccessControlledService;
import org.dasein.cloud.CloudException;
import org.dasein.cloud.InternalException;
import org.dasein.cloud.ResourceStatus;
import org.dasein.cloud.identity.ServiceAction;
import org.dasein.cloud.platform.KeyValueDatabase;
import org.dasein.cloud.platform.KeyValueDatabaseCapabilities;
import org.dasein.cloud.platform.KeyValueDatabaseSupport;
import org.dasein.cloud.platform.KeyValuePair;

import com.infinities.skyport.async.AsyncResult;

public interface AsyncKeyValueDatabaseSupport extends AccessControlledService {

	static public final ServiceAction ANY = new ServiceAction("KVDB:ANY");

	static public final ServiceAction CREATE_KVDB = new ServiceAction("KVDB:CREATE_KVDB");
	static public final ServiceAction DELETE = new ServiceAction("KVDB:DELETE");
	static public final ServiceAction GET_KVDB = new ServiceAction("KVDB:GET_KVDB");
	static public final ServiceAction LIST_KVDB = new ServiceAction("KVDB:LIST_KVDB");
	static public final ServiceAction PUT = new ServiceAction("KVDB:PUT");
	static public final ServiceAction REMOVE_KVDB = new ServiceAction("KVDB:REMOVE_KVDB");
	static public final ServiceAction SELECT = new ServiceAction("KVDB:SELECT");


	public AsyncResult<Void> addKeyValuePairs(String inDatabaseId, String itemId, KeyValuePair... pairs)
			throws CloudException, InternalException;

	public AsyncResult<String> createDatabase(String name, String description) throws CloudException, InternalException;

	/**
	 * Provides access to meta-data about KVDatabase capabilities in the current
	 * region of this cloud.
	 * 
	 * @return a description of the features supported by this region of this
	 *         cloud
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 */
	public @Nonnull KeyValueDatabaseCapabilities getCapabilities() throws InternalException, CloudException;

	public AsyncResult<Iterable<KeyValuePair>> getKeyValuePairs(String inDatabaseId, String itemId, boolean consistentRead)
			throws CloudException, InternalException;

	public AsyncResult<KeyValueDatabase> getDatabase(String databaseId) throws CloudException, InternalException;

	public boolean isSubscribed() throws CloudException, InternalException;

	public AsyncResult<Iterable<String>> list() throws CloudException, InternalException;

	public @Nonnull AsyncResult<Iterable<ResourceStatus>> listKeyValueDatabaseStatus() throws CloudException,
			InternalException;

	public AsyncResult<Map<String, Set<KeyValuePair>>> query(String queryString, boolean consistentRead)
			throws CloudException, InternalException;

	public AsyncResult<Void> removeKeyValuePairs(String inDatabaseId, String itemId, KeyValuePair... pairs)
			throws CloudException, InternalException;

	public AsyncResult<Void> removeKeyValuePairs(String inDatabaseId, String itemId, String... keys) throws CloudException,
			InternalException;

	public AsyncResult<Void> removeDatabase(String providerDatabaseId) throws CloudException, InternalException;

	public AsyncResult<Void> replaceKeyValuePairs(String inDatabaseId, String itemId, KeyValuePair... pairs)
			throws CloudException, InternalException;

	KeyValueDatabaseSupport getSupport();
}
