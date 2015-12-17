package com.infinities.skyport.async.service.compute;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.dasein.cloud.AccessControlledService;
import org.dasein.cloud.CloudException;
import org.dasein.cloud.InternalException;
import org.dasein.cloud.ResourceStatus;
import org.dasein.cloud.Tag;
import org.dasein.cloud.compute.Volume;
import org.dasein.cloud.compute.VolumeCapabilities;
import org.dasein.cloud.compute.VolumeCreateOptions;
import org.dasein.cloud.compute.VolumeFilterOptions;
import org.dasein.cloud.compute.VolumeProduct;
import org.dasein.cloud.compute.VolumeState;
import org.dasein.cloud.compute.VolumeSupport;
import org.dasein.cloud.identity.ServiceAction;

import com.infinities.skyport.async.AsyncResult;

public interface AsyncVolumeSupport extends AccessControlledService {

	static public final ServiceAction ANY = new ServiceAction("VOLUME:ANY");

	static public final ServiceAction ATTACH = new ServiceAction("VOLUME:ATTACH");
	static public final ServiceAction CREATE_VOLUME = new ServiceAction("VOLUME:CREATE_VOLUME");
	static public final ServiceAction DETACH = new ServiceAction("VOLUME:DETACH");
	static public final ServiceAction GET_VOLUME = new ServiceAction("VOLUME:GET_VOLUME");
	static public final ServiceAction LIST_VOLUME = new ServiceAction("VOLUME:LIST_VOLUME");
	static public final ServiceAction REMOVE_VOLUME = new ServiceAction("VOLUME:REMOVE_VOLUME");


	/**
	 * Attaches the specified volume to the target server using the specified
	 * device ID.
	 * 
	 * @param volumeId
	 *            the unique ID of the volume to attach
	 * @param toServer
	 *            the unique ID of the virtual machine to which the volume
	 *            should be attached
	 * @param deviceId
	 *            the operating system device ID that will identify the volume
	 *            to the guest operating system
	 * @throws InternalException
	 *             an error occurred in the Dasein Cloud implementation while
	 *             performing the attachment
	 * @throws CloudException
	 *             the attachment failed with the cloud provider
	 * @see VolumeCapabilities#getDeviceIdOnAttachRequirement()
	 */
	public AsyncResult<Void> attach(@Nonnull String volumeId, @Nonnull String toServer, @Nullable String deviceId)
			throws InternalException, CloudException;

	/**
	 * Creates a snapshot with the specified bare-bones options.
	 * 
	 * @param fromSnapshot
	 *            the snapshot (if any) from which the volume should be created
	 * @param sizeInGb
	 *            the size of the volume to be created
	 * @param inZone
	 *            the data center into which the volume should be provisioned
	 * @return the provider volume ID for the newly created volume
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud implementation
	 *             creating the volume
	 * @throws CloudException
	 *             an error occurred within the service provider creating the
	 *             volume
	 * @deprecated Use {@link #createVolume(VolumeCreateOptions)}
	 */
	@Deprecated
	public @Nonnull AsyncResult<String> create(@Nullable String fromSnapshot, @Nonnegative int sizeInGb,
			@Nonnull String inZone) throws InternalException, CloudException;

	/**
	 * Creates a new volume based on the specified options for creating a
	 * disk/block storage device.
	 * 
	 * @param options
	 *            the options to be used in creating the volume
	 * @return the provider volume ID that will identify the newly created
	 *         volume
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud implementation
	 *             creating the volume
	 * @throws CloudException
	 *             an error occurred within the service provider creating the
	 *             volume
	 */
	public @Nonnull AsyncResult<String> createVolume(@Nonnull VolumeCreateOptions options) throws InternalException,
			CloudException;

	/**
	 * Detaches the specified volume from any virtual machines to which it might
	 * be attached.
	 * 
	 * @param volumeId
	 *            the unique ID of the volume to be detached
	 * @throws InternalException
	 *             an error occurred in the Dasein Cloud implementation while
	 *             performing the detachment
	 * @throws CloudException
	 *             the detachment failed with the cloud provider
	 */
	public AsyncResult<Void> detach(@Nonnull String volumeId) throws InternalException, CloudException;

	/**
	 * Detaches the specified volume from any virtual machines to which it might
	 * be attached with the option to force the detachment when some cloud state
	 * is preventing it.
	 * 
	 * @param volumeId
	 *            the unique ID of the volume to be detached
	 * @param force
	 *            indicate whether or not the detach should be forced even if
	 *            the VM is not releasing it
	 * @throws InternalException
	 *             an error occurred in the Dasein Cloud implementation while
	 *             performing the detachment
	 * @throws CloudException
	 *             the detachment failed with the cloud provider
	 */
	public AsyncResult<Void> detach(@Nonnull String volumeId, boolean force) throws InternalException, CloudException;

	/**
	 * Provides access to meta-data about volume capabilities in the current
	 * region of this cloud.
	 * 
	 * @return a description of the features supported by this region of this
	 *         cloud
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 */
	public VolumeCapabilities getCapabilities() throws CloudException, InternalException;

	/**
	 * Fetches the volume with the specified volume ID.
	 * 
	 * @param volumeId
	 *            the ID of the desired volume
	 * @return the matching volume or <code>null</code> if no such volume exists
	 * @throws InternalException
	 *             an error in the Dasein Cloud implementation while fetching
	 *             the volume
	 * @throws CloudException
	 *             an error occurred with the cloud provider while fetching the
	 *             volume
	 */
	public @Nullable AsyncResult<Volume> getVolume(@Nonnull String volumeId) throws InternalException, CloudException;

	/**
	 * Lists the set of volume products that may be used in provisioning a block
	 * storage volume. Because not all clouds support the concept of volume
	 * products (as indicated by {@link #getVolumeProductRequirement()}, this
	 * method should return an empty list in such clouds.
	 * 
	 * @return the list of products that may be used to provision volumes
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud implementation
	 *             assembling the list
	 * @throws CloudException
	 *             an error occurred fetching the product list from the cloud
	 *             provider
	 */
	public @Nonnull AsyncResult<Iterable<VolumeProduct>> listVolumeProducts() throws InternalException, CloudException;

	/**
	 * Lists the status for all volumes in the current region.
	 * 
	 * @return the status for all volumes in the current region
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud implementation
	 * @throws CloudException
	 *             an error occurred with the cloud provider
	 */
	public @Nonnull AsyncResult<Iterable<ResourceStatus>> listVolumeStatus() throws InternalException, CloudException;

	/**
	 * Lists all volumes in the current region with the cloud provider.
	 * 
	 * @return the volumes in the current region for this cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud implementation
	 * @throws CloudException
	 *             an error occurred with the cloud provider
	 */
	public @Nonnull AsyncResult<Iterable<Volume>> listVolumes() throws InternalException, CloudException;

	/**
	 * Lists all volumes in the current region with the cloud provider matching
	 * the given VolumeFilterOptions belonging to the account owner currently in
	 * the cloud. The filtering functionality is delegated to the cloud
	 * provider.
	 * 
	 * @param options
	 *            filter options
	 * @return the volumes in the current region for this cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud implementation
	 * @throws CloudException
	 *             an error occurred with the cloud provider
	 */
	public @Nonnull AsyncResult<Iterable<Volume>> listVolumes(@Nullable VolumeFilterOptions options)
			throws InternalException, CloudException;

	/**
	 * Identifies whether or not the current account has access to volumes in
	 * the current region.
	 * 
	 * @return true if the current account has access to volumes in the current
	 *         region
	 * @throws CloudException
	 *             an error occurred with the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud implementation
	 */
	public boolean isSubscribed() throws CloudException, InternalException;

	/**
	 * De-provisions the specified volume. This method should block until the
	 * volume is in a {@link VolumeState#DELETED} state.
	 * 
	 * @param volumeId
	 *            the unique ID of the volume to be de-provisioned
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud implementation
	 * @throws CloudException
	 *             an error occurred with the cloud provider
	 */
	public AsyncResult<Void> remove(@Nonnull String volumeId) throws InternalException, CloudException;

	/**
	 * Removes meta-data from a volume. If tag values are set, their removal is
	 * dependent on underlying cloud provider behavior. They may be removed only
	 * if the tag value matches or they may be removed regardless of the value.
	 * 
	 * @param volumeId
	 *            the volume to update
	 * @param tags
	 *            the meta-data tags to remove
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	public AsyncResult<Void> removeTags(@Nonnull String volumeId, @Nonnull Tag... tags) throws CloudException,
			InternalException;

	/**
	 * Removes meta-data from multiple volumes. If tag values are set, their
	 * removal is dependent on underlying cloud provider behavior. They may be
	 * removed only if the tag value matches or they may be removed regardless
	 * of the value.
	 * 
	 * @param volumeIds
	 *            the volume to update
	 * @param tags
	 *            the meta-data tags to remove
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	public AsyncResult<Void> removeTags(@Nonnull String[] volumeIds, @Nonnull Tag... tags) throws CloudException,
			InternalException;

	/**
	 * Updates meta-data for a volume with the new values. It will not overwrite
	 * any value that currently exists unless it appears in the tags you submit.
	 * 
	 * @param volumeId
	 *            the volume to update
	 * @param tags
	 *            the meta-data tags to set
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	public AsyncResult<Void> updateTags(@Nonnull String volumeId, @Nonnull Tag... tags) throws CloudException,
			InternalException;

	/**
	 * Updates meta-data for multiple volumes with the new values. It will not
	 * overwrite any value that currently exists unless it appears in the tags
	 * you submit.
	 * 
	 * @param volumeIds
	 *            the volumes to update
	 * @param tags
	 *            the meta-data tags to set
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	public AsyncResult<Void> updateTags(@Nonnull String[] volumeIds, @Nonnull Tag... tags) throws CloudException,
			InternalException;

	/**
	 * Set meta-data for a volume. Remove any tags that were not provided by the
	 * incoming tags, and add or overwrite any new or pre-existing tags.
	 *
	 * @param volumeId
	 *            the volume to set
	 * @param tags
	 *            the meta-data tags to set
	 * @throws CloudException
	 * @throws InternalException
	 */
	public AsyncResult<Void> setTags(@Nonnull String volumeId, @Nonnull Tag... tags) throws CloudException,
			InternalException;

	/**
	 * Set meta-data for multiple volumes. Remove any tags that were not
	 * provided by the incoming tags, and add or overwrite any new or
	 * pre-existing tags.
	 *
	 * @param volumeIds
	 *            the volumes to set
	 * @param tags
	 *            the meta-data tags to set
	 * @throws CloudException
	 * @throws InternalException
	 */
	public AsyncResult<Void> setTags(@Nonnull String[] volumeIds, @Nonnull Tag... tags) throws CloudException,
			InternalException;

	VolumeSupport getSupport();
}
