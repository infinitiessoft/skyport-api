package com.infinities.skyport.async.service.ci;

import java.util.Locale;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.dasein.cloud.AccessControlledService;
import org.dasein.cloud.CloudException;
import org.dasein.cloud.InternalException;
import org.dasein.cloud.ResourceStatus;
import org.dasein.cloud.Tag;
import org.dasein.cloud.ci.Topology;
import org.dasein.cloud.ci.TopologyCapabilities;
import org.dasein.cloud.ci.TopologyFilterOptions;
import org.dasein.cloud.ci.TopologyProvisionOptions;

import com.infinities.skyport.async.AsyncResult;

public interface AsyncTopologySupport extends AccessControlledService {

	/**
	 * Provides a localized term for topologies as the current cloud provider
	 * refers to them.
	 * 
	 * @param locale
	 *            the locale for which the term should be translated
	 * @return a localized term for topology in this cloud
	 */
	public @Nonnull AsyncResult<String> getProviderTermForTopology(@Nonnull Locale locale);

	/**
	 * Fetches the specified topology state from the cloud provider, if the
	 * specified topology exists.
	 * 
	 * @param topologyId
	 *            the unique provider ID for the desired topology
	 * @return the matching topology or <code>null</code> if no such topology
	 *         exists
	 * @throws CloudException
	 *             an error occurred with the cloud provider while fetching the
	 *             target topology
	 * @throws InternalException
	 *             an error occurred within Dasein Cloud while processing the
	 *             request
	 */
	public @Nullable AsyncResult<Topology> getTopology(@Nonnull String topologyId) throws CloudException, InternalException;

	/**
	 * Verifies that the current account context is subscribed for access to
	 * topology support in this cloud and region.
	 * 
	 * @return true if the account is subscribed in the current region for
	 *         topology support
	 * @throws CloudException
	 *             an error occurred with the cloud provider while checking the
	 *             subscription
	 * @throws InternalException
	 *             an error occurred within Dasein Cloud while processing the
	 *             request
	 */
	public boolean isSubscribed() throws CloudException, InternalException;

	/**
	 * Lists private topologies matching the specified filtering options.
	 * 
	 * @param options
	 *            the options on which you would like to filter
	 * @return a list of matching topologies from your private topology library
	 * @throws CloudException
	 *             an error occurred in the cloud provider while processing the
	 *             request
	 * @throws InternalException
	 *             an error occurred within Dasein Cloud while processing the
	 *             request
	 */
	public @Nonnull Iterable<Topology> listTopologies(@Nullable TopologyFilterOptions options) throws CloudException,
			InternalException;

	/**
	 * Lists the status for all topologies in the current region.
	 * 
	 * @return the status for all topologies in the current region
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud implementation
	 * @throws CloudException
	 *             an error occurred with the cloud provider
	 */
	public @Nonnull AsyncResult<Iterable<ResourceStatus>> listTopologyStatus() throws InternalException, CloudException;

	/**
	 * Searches through the public topology catalog to find topologies matching
	 * the specified filtering options.
	 * 
	 * @param options
	 *            the options on which you would like to filter
	 * @return a list of matching topologies from the public topology library
	 * @throws CloudException
	 *             an error occurred in the cloud provider while processing the
	 *             request
	 * @throws InternalException
	 *             an error occurred within Dasein Cloud while processing the
	 *             request
	 */
	public @Nonnull AsyncResult<Iterable<Topology>> searchPublicTopologies(@Nullable TopologyFilterOptions options)
			throws CloudException, InternalException;

	/**
	 * Indicates whether a library of public topologies should be expected. If
	 * true, {@link #searchPublicTopologies(TopologyFilterOptions)} should
	 * enable the searching of those topologies.
	 * 
	 * @return true if a public topology library exists
	 * @throws CloudException
	 *             an error occurred with the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein cloud implementation
	 */
	public AsyncResult<Boolean> supportsPublicLibrary() throws CloudException, InternalException;

	/**
	 * Updates meta-data for a topology with the new values. It will not
	 * overwrite any value that currently exists unless it appears in the tags
	 * you submit.
	 * 
	 * @param topologyId
	 *            the topology to update
	 * @param tags
	 *            the meta-data tags to set
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	public AsyncResult<Void> updateTags(@Nonnull String topologyId, @Nonnull Tag... tags) throws CloudException,
			InternalException;

	/**
	 * Updates meta-data for multiple topologies with the new values. It will
	 * not overwrite any value that currently exists unless it appears in the
	 * tags you submit.
	 * 
	 * @param topologyIds
	 *            the topologies to update
	 * @param tags
	 *            the meta-data tags to set
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	public AsyncResult<Void> updateTags(@Nonnull String[] topologyIds, @Nonnull Tag... tags) throws CloudException,
			InternalException;

	/**
	 * Removes meta-data from a topology. If tag values are set, their removal
	 * is dependent on underlying cloud provider behavior. They may be removed
	 * only if the tag value matches or they may be removed regardless of the
	 * value.
	 * 
	 * @param topologyId
	 *            the topology to update
	 * @param tags
	 *            the meta-data tags to remove
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	public AsyncResult<Void> removeTags(@Nonnull String topologyId, @Nonnull Tag... tags) throws CloudException,
			InternalException;

	/**
	 * Removes meta-data from multiple topologies. If tag values are set, their
	 * removal is dependent on underlying cloud provider behavior. They may be
	 * removed only if the tag value matches or they may be removed regardless
	 * of the value.
	 * 
	 * @param topologyIds
	 *            the topology to update
	 * @param tags
	 *            the meta-data tags to remove
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	public AsyncResult<Void> removeTags(@Nonnull String[] topologyIds, @Nonnull Tag... tags) throws CloudException,
			InternalException;

	/**
	 * Creates a private topology matching the specified options.
	 * 
	 * @param TBD
	 * @return true on success, false on failure
	 * @throws CloudException
	 *             an error occurred in the cloud provider while processing the
	 *             request
	 * @throws InternalException
	 *             an error occurred within Dasein Cloud while processing the
	 *             request
	 */
	public AsyncResult<Boolean> createTopology(@Nonnull TopologyProvisionOptions withTopologyOptions) throws CloudException,
			InternalException;

	/**
	 * Removes a private topology(s) matching the specified id's.
	 * 
	 * @param topologyIds
	 *            the list of topologies to be removed.
	 * @return true on success, false on failure
	 * @throws CloudException
	 *             an error occurred in the cloud provider while processing the
	 *             request
	 * @throws InternalException
	 *             an error occurred within Dasein Cloud while processing the
	 *             request
	 */
	public AsyncResult<Boolean> removeTopologies(@Nonnull String[] topologyIds) throws CloudException, InternalException;

	public TopologyCapabilities getCapabilities() throws CloudException, InternalException;

}
