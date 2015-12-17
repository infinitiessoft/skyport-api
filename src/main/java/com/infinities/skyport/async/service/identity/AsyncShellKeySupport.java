package com.infinities.skyport.async.service.identity;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.dasein.cloud.AccessControlledService;
import org.dasein.cloud.CloudException;
import org.dasein.cloud.InternalException;
import org.dasein.cloud.identity.SSHKeypair;
import org.dasein.cloud.identity.ServiceAction;
import org.dasein.cloud.identity.ShellKeyCapabilities;
import org.dasein.cloud.identity.ShellKeySupport;

import com.infinities.skyport.async.AsyncResult;

public interface AsyncShellKeySupport extends AccessControlledService {

	static public final ServiceAction ANY = new ServiceAction("SSH:ANY");

	static public final ServiceAction CREATE_KEYPAIR = new ServiceAction("SSH:CREATE_KEYPAIR");
	static public final ServiceAction GET_KEYPAIR = new ServiceAction("SSH:GET_KEYPAIR");
	static public final ServiceAction LIST_KEYPAIR = new ServiceAction("SSH:LIST_KEYPAIR");
	static public final ServiceAction REMOVE_KEYPAIR = new ServiceAction("SSH:REMOVE_KEYPAIR");


	/**
	 * Creates an SSH keypair having the specified name.
	 * 
	 * @param name
	 *            the name of the SSH keypair
	 * @return a new SSH keypair
	 * @throws InternalException
	 *             an error occurred within Dasein Cloud while processing the
	 *             request
	 * @throws CloudException
	 *             an error occurred in the cloud provider executing the keypair
	 *             creation
	 */
	public @Nonnull AsyncResult<SSHKeypair> createKeypair(@Nonnull String name) throws InternalException, CloudException;

	/**
	 * Deletes the specified keypair having the specified name.
	 * 
	 * @param providerId
	 *            the provider ID of the keypair to be deleted
	 * @throws InternalException
	 *             an error occurred within Dasein Cloud while performing the
	 *             deletion
	 * @throws CloudException
	 *             an error occurred with the cloud provider while performing
	 *             the deletion
	 */
	public AsyncResult<Void> deleteKeypair(@Nonnull String providerId) throws InternalException, CloudException;

	/**
	 * Fetches the fingerprint of the specified key so you can validate it
	 * against the one you have.
	 * 
	 * @param providerId
	 *            the provider ID of the keypair
	 * @return the fingerprint for the specified keypair
	 * @throws InternalException
	 *             an error occurred within Dasein Cloud while fetching the
	 *             fingerprint
	 * @throws CloudException
	 *             an error occurred with the cloud provider while fetching the
	 *             fingerprint
	 */
	public @Nullable AsyncResult<String> getFingerprint(@Nonnull String providerId) throws InternalException, CloudException;

	/**
	 * Fetches the specified keypair from the cloud provider. The cloud provider
	 * may or may not know about the public key at this time, so be prepared for
	 * a null {@link SSHKeypair#getPublicKey()}.
	 * 
	 * @param providerId
	 *            the unique ID of the target keypair
	 * @return the keypair matching the specified provider ID or
	 *         <code>null</code> if no such key exists
	 * @throws InternalException
	 *             an error occurred in the Dasein Cloud implementation while
	 *             fetching the keypair
	 * @throws CloudException
	 *             an error occurred with the cloud provider while fetching the
	 *             keypair
	 */
	public @Nullable AsyncResult<SSHKeypair> getKeypair(@Nonnull String providerId) throws InternalException, CloudException;

	/**
	 * Provides access to meta-data about shell key capabilities in the current
	 * region of this cloud.
	 * 
	 * @return a description of the features supported by this region of this
	 *         cloud
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 */
	public @Nonnull ShellKeyCapabilities getCapabilities() throws CloudException, InternalException;

	/**
	 * Imports the specified public key into your store of keys with the cloud
	 * provider under the specified name.
	 * 
	 * @param name
	 *            the name of the key to be imported
	 * @param publicKey
	 *            the MD5 public key fingerprint as specified in section 4 of
	 *            RFC4716
	 * @return the unique ID of the key as it is stored with the cloud provider
	 * @throws InternalException
	 *             a local error occurred assembling the request
	 * @throws CloudException
	 *             an error occurred with the cloud provider while importing the
	 *             keys
	 */
	public @Nonnull AsyncResult<SSHKeypair> importKeypair(@Nonnull String name, @Nonnull String publicKey)
			throws InternalException, CloudException;

	/**
	 * @return true if the cloud provider supports shell keypairs in the current
	 *         region and the current account can use them
	 * @throws CloudException
	 *             an error occurred with the cloud provider while determining
	 *             subscription status
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud implementation
	 *             determining subscription status
	 */
	public boolean isSubscribed() throws CloudException, InternalException;

	/**
	 * @return a list of all available SSH keypairs (private key is null)
	 * @throws InternalException
	 *             an error occurred within Dasein Cloud listing the keypairs
	 * @throws CloudException
	 *             an error occurred with the cloud provider listing the
	 *             keyspairs
	 */
	public @Nonnull AsyncResult<Iterable<SSHKeypair>> list() throws InternalException, CloudException;

	ShellKeySupport getSupport();
}
