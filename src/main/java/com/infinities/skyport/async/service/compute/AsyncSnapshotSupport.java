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
package com.infinities.skyport.async.service.compute;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.dasein.cloud.AccessControlledService;
import org.dasein.cloud.CloudException;
import org.dasein.cloud.InternalException;
import org.dasein.cloud.OperationNotSupportedException;
import org.dasein.cloud.ResourceStatus;
import org.dasein.cloud.Tag;
import org.dasein.cloud.compute.Snapshot;
import org.dasein.cloud.compute.SnapshotCapabilities;
import org.dasein.cloud.compute.SnapshotCreateOptions;
import org.dasein.cloud.compute.SnapshotFilterOptions;
import org.dasein.cloud.compute.SnapshotSupport;
import org.dasein.cloud.identity.ServiceAction;

import com.infinities.skyport.async.AsyncResult;

public interface AsyncSnapshotSupport extends AccessControlledService {

	static public final ServiceAction ANY = new ServiceAction("SNAPSHOT:ANY");

	static public final ServiceAction CREATE_SNAPSHOT = new ServiceAction("SNAPSHOT:CREATE_SNAPSHOT");
	static public final ServiceAction GET_SNAPSHOT = new ServiceAction("SNAPSHOT:GET_SNAPSHOT");
	static public final ServiceAction LIST_SNAPSHOT = new ServiceAction("SNAPSHOT:LIST_SNAPSHOT");
	static public final ServiceAction MAKE_PUBLIC = new ServiceAction("SNAPSHOT:MAKE_PUBLIC");
	static public final ServiceAction REMOVE_SNAPSHOT = new ServiceAction("SNAPSHOT:REMOVE_SNAPSHOT");
	static public final ServiceAction SHARE_SNAPSHOT = new ServiceAction("SNAPSHOT:SHARE_SNAPSHOT");


	/**
	 * Adds the specified account number to the list of accounts with which this
	 * snapshot is shared.
	 * 
	 * @param providerSnapshotId
	 *            the unique ID of the snapshot to be shared
	 * @param accountNumber
	 *            the account number with which the snapshot will be shared
	 * @throws CloudException
	 *             an error occurred with the cloud provider
	 * @throws InternalException
	 *             a local error occurred in the Dasein Cloud implementation
	 * @throws OperationNotSupportedException
	 *             the cloud does not support sharing snapshots with other
	 *             accounts
	 */
	public AsyncResult<Void> addSnapshotShare(@Nonnull String providerSnapshotId, @Nonnull String accountNumber)
			throws CloudException, InternalException;

	/**
	 * Shares the specified snapshot with the public.
	 * 
	 * @param providerSnapshotId
	 *            the unique ID of the snapshot to be made public
	 * @throws CloudException
	 *             an error occurred with the cloud provider
	 * @throws InternalException
	 *             a local error occurred in the Dasein Cloud implementation
	 * @throws OperationNotSupportedException
	 *             the cloud does not support sharing snapshots with the public
	 */
	public AsyncResult<Void> addPublicShare(@Nonnull String providerSnapshotId) throws CloudException, InternalException;

	/**
	 * Creates a new snapshot based on the options specified. This method
	 * supports both the creation of snapshots from an existing volume or the
	 * creation of a snapshot as a copy of an existing snapshot in another
	 * region. Which approach is taken depends on the contents of the create
	 * options.
	 * 
	 * @param options
	 *            the options for creating the new snapshot
	 * @return the ID of the newly created snapshot (or <code>null</code> if a
	 *         create and no changes since last snapshot of volume)
	 * @throws CloudException
	 *             an error occurred with the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud implementation
	 * @throws OperationNotSupportedException
	 *             the cloud does not support the kind of creation desired
	 */
	public @Nullable AsyncResult<String> createSnapshot(@Nonnull SnapshotCreateOptions options) throws CloudException,
			InternalException;

	/**
	 * Creates a snapshot from the specified volume.
	 * 
	 * @param ofVolume
	 *            the unique ID of the volume to be snapshotted
	 * @param description
	 *            the description of the snapshot
	 * @return the unique ID of the snapshot created (or null if no changes
	 *         since last snapshot)
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud implementation
	 * @throws CloudException
	 *             an error occurred with the cloud provider
	 * @deprecated Use {@link #createSnapshot(SnapshotCreateOptions)}
	 */
	@Deprecated
	public @Nullable AsyncResult<String> create(@Nonnull String ofVolume, @Nonnull String description)
			throws InternalException, CloudException;

	/**
	 * Provides access to meta-data about virtual machine capabilities in the
	 * current region of this cloud.
	 * 
	 * @return a description of the features supported by this region of this
	 *         cloud
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 */
	public @Nonnull SnapshotCapabilities getCapabilities() throws CloudException, InternalException;

	/**
	 * Retrieves the full details of the specified snapshot as a Dasein Cloud
	 * snapshot object.
	 * 
	 * @param snapshotId
	 *            the unique ID of the snapshot being fetched
	 * @return the snapshot matching the target ID
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud implementation
	 * @throws CloudException
	 *             an error occurred with the cloud provide
	 */
	public @Nullable AsyncResult<Snapshot> getSnapshot(@Nonnull String snapshotId) throws InternalException, CloudException;

	/**
	 * Identifies whether or not the specified snapshot is shared with the
	 * general public. If public sharing is not allowed, this method will return
	 * false.
	 * 
	 * @param snapshotId
	 *            the unique ID of the snapshot being checked
	 * @return true if the snapshot in question is publicly shared
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud implementation
	 * @throws CloudException
	 *             an error occurred with the cloud provide
	 */
	public AsyncResult<Boolean> isPublic(@Nonnull String snapshotId) throws InternalException, CloudException;

	/**
	 * Validates that the current user credentials are subscribed to snapshot
	 * services in the target cloud/region.
	 * 
	 * @return true if the account is subscribed for snapshots
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud implementation
	 * @throws CloudException
	 *             an error occurred with the cloud provide
	 */
	public boolean isSubscribed() throws InternalException, CloudException;

	/**
	 * Lists all accounts with which this snapshot is shared. If snapshot
	 * sharing is not supported, this method will return an empty list.
	 * 
	 * @param snapshotId
	 *            the unique ID of the snapshot being checked
	 * @return a list of accounts with which the snapshot is shared
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud implementation
	 * @throws CloudException
	 *             an error occurred with the cloud provider
	 */
	public @Nonnull AsyncResult<Iterable<String>> listShares(@Nonnull String snapshotId) throws InternalException,
			CloudException;

	/**
	 * Lists the status for all snapshots belonging to me or explicitly shared
	 * with me in the current region. This status list should match the
	 * snapshots from {@link #listSnapshots()}.
	 * 
	 * @return the status for all snapshots in the current region
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud implementation
	 * @throws CloudException
	 *             an error occurred with the cloud provider
	 */
	public @Nonnull AsyncResult<Iterable<ResourceStatus>> listSnapshotStatus() throws InternalException, CloudException;

	/**
	 * Lists snapshots belonging to me or explicitly shared with me in the
	 * current region.
	 * 
	 * @return a list of snapshots in the current region
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud implementation
	 * @throws CloudException
	 *             an error occurred with the cloud provider
	 */
	public @Nonnull AsyncResult<Iterable<Snapshot>> listSnapshots() throws InternalException, CloudException;

	/**
	 * Lists all snapshots in the current region with the cloud provider
	 * matching the given {@link SnapshotFilterOptions} belonging either to the
	 * account owner currently in the cloud or to the account owner specified in
	 * the filter options. The filtering may be delegated to the cloud provider
	 * where possible. This method differs from
	 * {@link #searchSnapshots(SnapshotFilterOptions)} in that it is focused on
	 * a single account (whereas {@link #searchSnapshots(SnapshotFilterOptions)}
	 * searches all visible snapshots).
	 * 
	 * @param options
	 *            filter options
	 * @return a list of snapshots in the current region matching the filter
	 *         options
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud implementation
	 * @throws CloudException
	 *             an error occurred with the cloud provider
	 */
	public @Nonnull AsyncResult<Iterable<Snapshot>> listSnapshots(@Nullable SnapshotFilterOptions options)
			throws InternalException, CloudException;

	/**
	 * Removes the specified snapshot permanently from the cloud.
	 * 
	 * @param snapshotId
	 *            the unique ID of the snapshot to be removed
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud implementation
	 * @throws CloudException
	 *             an error occurred with the cloud provider
	 */
	public AsyncResult<Void> remove(@Nonnull String snapshotId) throws InternalException, CloudException;

	/**
	 * Removes ALL specific account shares for the specified snapshot. NOTE THAT
	 * THIS METHOD WILL NOT THROW AN EXCEPTION WHEN SNAPSHOT SHARING IS NOT
	 * SUPPORTED. IT IS A NO-OP IN THAT SCENARIO.
	 * 
	 * @param providerSnapshotId
	 *            the unique ID of the snapshot to be unshared
	 * @throws CloudException
	 *             an error occurred with the cloud provider
	 * @throws InternalException
	 *             a local error occurred in the Dasein Cloud implementation
	 */
	public AsyncResult<Void> removeAllSnapshotShares(@Nonnull String providerSnapshotId) throws CloudException,
			InternalException;

	/**
	 * Removes the specified account number from the list of accounts with which
	 * this snapshot is shared.
	 * 
	 * @param providerSnapshotId
	 *            the unique ID of the snapshot to be unshared
	 * @param accountNumber
	 *            the account number with which the snapshot will be unshared
	 * @throws CloudException
	 *             an error occurred with the cloud provider
	 * @throws InternalException
	 *             a local error occurred in the Dasein Cloud implementation
	 * @throws OperationNotSupportedException
	 *             the cloud does not support sharing snapshots with other
	 *             accounts
	 */
	public AsyncResult<Void> removeSnapshotShare(@Nonnull String providerSnapshotId, @Nonnull String accountNumber)
			throws CloudException, InternalException;

	/**
	 * Unshares the specified snapshot with the public. This method may be
	 * safely called even if sharing is not supported.
	 * 
	 * @param providerSnapshotId
	 *            the unique ID of the snapshot to be removed from public
	 *            sharing
	 * @throws CloudException
	 *             an error occurred with the cloud provider
	 * @throws InternalException
	 *             a local error occurred in the Dasein Cloud implementation
	 */
	public AsyncResult<Void> removePublicShare(@Nonnull String providerSnapshotId) throws CloudException, InternalException;

	/**
	 * Removes meta-data from a snapshot. If tag values are set, their removal
	 * is dependent on underlying cloud provider behavior. They may be removed
	 * only if the tag value matches or they may be removed regardless of the
	 * value.
	 * 
	 * @param snapshotId
	 *            the snapshot to update
	 * @param tags
	 *            the meta-data tags to remove
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	public AsyncResult<Void> removeTags(@Nonnull String snapshotId, @Nonnull Tag... tags) throws CloudException,
			InternalException;

	/**
	 * Removes meta-data from multiple snapshots. If tag values are set, their
	 * removal is dependent on underlying cloud provider behavior. They may be
	 * removed only if the tag value matches or they may be removed regardless
	 * of the value.
	 * 
	 * @param snapshotIds
	 *            the snapshot to update
	 * @param tags
	 *            the meta-data tags to remove
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	public AsyncResult<Void> removeTags(@Nonnull String[] snapshotIds, @Nonnull Tag... tags) throws CloudException,
			InternalException;

	/**
	 * Searches all snapshots visible to the current account owner (whether
	 * owned by the account owner or someone else) for all snapshots matching
	 * the specified snapshot filter options. This differs from the
	 * {@link #listSnapshots(SnapshotFilterOptions)} method in that it covers
	 * all snapshots, not just ones belonging to a specific account.
	 * 
	 * @return all snapshots in the current region matching the specified filter
	 *         options
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud implementation
	 * @throws CloudException
	 *             an error occurred with the cloud provider
	 */
	public @Nonnull AsyncResult<Iterable<Snapshot>> searchSnapshots(@Nonnull SnapshotFilterOptions options)
			throws InternalException, CloudException;

	/**
	 * Shares the specified snapshot with the specified account.
	 * 
	 * @param snapshotId
	 *            the unique ID of the snapshot to be shared
	 * @param withAccountId
	 *            the account number with which it is being shared
	 * @param affirmative
	 *            true if sharing is being enabled, false if being unshared
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud implementation
	 * @throws CloudException
	 *             an error occurred with the cloud provider
	 * @deprecated Use {@link #addPublicShare(String)},
	 *             {@link #addSnapshotShare(String, String)},
	 *             {@link #removePublicShare(String)}, or
	 *             {@link #removeSnapshotShare(String, String)}
	 */
	@Deprecated
	public AsyncResult<Void> shareSnapshot(@Nonnull String snapshotId, @Nullable String withAccountId, boolean affirmative)
			throws InternalException, CloudException;

	/**
	 * Snapshots the specified volume with the resulting snapshot having the
	 * specified meta-data. Some clouds may not execute a snapshot if the most
	 * recent snapshot on the volume is synchronized with the volume (in other
	 * words, if nothing has changed). In such a case, this method should return
	 * null.
	 * 
	 * @param volumeId
	 *            the unique ID of the volume to be snapshotted
	 * @param name
	 *            the name of the new snapshot
	 * @param description
	 *            a description for the new snapshot
	 * @param tags
	 *            any tags to associated with the new snapshot
	 * @return the snapshot resulting from the attempt or null if no changes
	 *         have occurred and thus no snapshot is needed
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud implementation
	 * @throws CloudException
	 *             an error occurred with the cloud provider
	 * @deprecated Use {@link #createSnapshot(SnapshotCreateOptions)}
	 */
	@Deprecated
	public @Nullable AsyncResult<Snapshot> snapshot(@Nonnull String volumeId, @Nonnull String name,
			@Nonnull String description, @Nullable Tag... tags) throws InternalException, CloudException;

	/**
	 * Updates meta-data for a snapshot with the new values. It will not
	 * overwrite any value that currently exists unless it appears in the tags
	 * you submit.
	 * 
	 * @param snapshotId
	 *            the snapshot to update
	 * @param tags
	 *            the meta-data tags to set
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	public AsyncResult<Void> updateTags(@Nonnull String snapshotId, @Nonnull Tag... tags) throws CloudException,
			InternalException;

	/**
	 * Updates meta-data for multiple snapshots with the new values. It will not
	 * overwrite any value that currently exists unless it appears in the tags
	 * you submit.
	 * 
	 * @param snapshotIds
	 *            the snapshots to update
	 * @param tags
	 *            the meta-data tags to set
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	public AsyncResult<Void> updateTags(@Nonnull String[] snapshotIds, @Nonnull Tag... tags) throws CloudException,
			InternalException;

	/**
	 * Set meta-data for a snapshot. Remove any tags that were not provided by
	 * the incoming tags, and add or overwrite any new or pre-existing tags.
	 *
	 * @param snapshotId
	 *            the snapshot to set
	 * @param tags
	 *            the meta-data tags to set
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	public AsyncResult<Void> setTags(@Nonnull String snapshotId, @Nonnull Tag... tags) throws CloudException,
			InternalException;

	/**
	 * Set meta-data for multiple snapshots. Remove any tags that were not
	 * provided by the incoming tags, and add or overwrite any new or
	 * pre-existing tags.
	 *
	 * @param snapshotIds
	 *            the snapshots to set
	 * @param tags
	 *            the meta-data tags to set
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	public AsyncResult<Void> setTags(@Nonnull String[] snapshotIds, @Nonnull Tag... tags) throws CloudException,
			InternalException;

	SnapshotSupport getSupport();
}
