package com.infinities.skyport.async.service.compute;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.dasein.cloud.AccessControlledService;
import org.dasein.cloud.AsynchronousTask;
import org.dasein.cloud.CloudException;
import org.dasein.cloud.InternalException;
import org.dasein.cloud.OperationNotSupportedException;
import org.dasein.cloud.ResourceStatus;
import org.dasein.cloud.Tag;
import org.dasein.cloud.compute.Architecture;
import org.dasein.cloud.compute.ImageCapabilities;
import org.dasein.cloud.compute.ImageClass;
import org.dasein.cloud.compute.ImageCopyOptions;
import org.dasein.cloud.compute.ImageCreateOptions;
import org.dasein.cloud.compute.ImageFilterOptions;
import org.dasein.cloud.compute.MachineImage;
import org.dasein.cloud.compute.MachineImageFormat;
import org.dasein.cloud.compute.MachineImageSupport;
import org.dasein.cloud.compute.MachineImageType;
import org.dasein.cloud.compute.Platform;
import org.dasein.cloud.compute.VmState;
import org.dasein.cloud.identity.ServiceAction;

import com.infinities.skyport.async.AsyncResult;

public interface AsyncMachineImageSupport extends AccessControlledService {

	static public final ServiceAction ANY = new ServiceAction("IMAGE:ANY");

	static public final ServiceAction DOWNLOAD_IMAGE = new ServiceAction("IMAGE:DOWNLOAD_IMAGE");
	static public final ServiceAction GET_IMAGE = new ServiceAction("IMAGE:GET_IMAGE");
	static public final ServiceAction IMAGE_VM = new ServiceAction("IMAGE:IMAGE_VM");
	static public final ServiceAction COPY_IMAGE = new ServiceAction("IMAGE:COPY_IMAGE");
	static public final ServiceAction LIST_IMAGE = new ServiceAction("IMAGE:LIST_IMAGE");
	static public final ServiceAction MAKE_PUBLIC = new ServiceAction("IMAGE:MAKE_PUBLIC");
	static public final ServiceAction REGISTER_IMAGE = new ServiceAction("IMAGE:REGISTER_IMAGE");
	static public final ServiceAction REMOVE_IMAGE = new ServiceAction("IMAGE:REMOVE_IMAGE");
	static public final ServiceAction SHARE_IMAGE = new ServiceAction("IMAGE:SHARE_IMAGE");
	static public final ServiceAction UPLOAD_IMAGE = new ServiceAction("IMAGE:UPLOAD_IMAGE");


	/**
	 * Adds the specified account number to the list of accounts with which this
	 * image is shared.
	 * 
	 * @param providerImageId
	 *            the unique ID of the image to be shared
	 * @param accountNumber
	 *            the account number with which the image will be shared
	 * @throws CloudException
	 *             an error occurred with the cloud provider
	 * @throws InternalException
	 *             a local error occurred in the Dasein Cloud implementation
	 * @throws OperationNotSupportedException
	 *             the cloud does not support sharing images with other accounts
	 */
	public AsyncResult<Void> addImageShare(@Nonnull String providerImageId, @Nonnull String accountNumber)
			throws CloudException, InternalException;

	/**
	 * Shares the specified image with the public.
	 * 
	 * @param providerImageId
	 *            the unique ID of the image to be made public
	 * @throws CloudException
	 *             an error occurred with the cloud provider
	 * @throws InternalException
	 *             a local error occurred in the Dasein Cloud implementation
	 * @throws OperationNotSupportedException
	 *             the cloud does not support sharing images with the public
	 */
	public AsyncResult<Void> addPublicShare(@Nonnull String providerImageId) throws CloudException, InternalException;

	/**
	 * Bundles the specified virtual machine to cloud storage so it may be
	 * registered as a machine image. Upon completion of this task, there should
	 * be a file or set of files that capture the target virtual machine in a
	 * file format that can later be registered into a machine image.
	 * 
	 * @param virtualMachineId
	 *            the virtual machine to be bundled
	 * @param format
	 *            the format in which the VM should be bundled
	 * @param bucket
	 *            the bucket to which the VM should be bundled
	 * @param name
	 *            the name of the object to be created or the prefix for the
	 *            name
	 * @return the location of the bundle file or a manifest to the bundle file
	 * @throws CloudException
	 *             an error occurred with the cloud provider
	 * @throws InternalException
	 *             a local error occurred in the Dasein Cloud implementation
	 */
	public @Nonnull AsyncResult<String> bundleVirtualMachine(@Nonnull String virtualMachineId,
			@Nonnull MachineImageFormat format, @Nonnull String bucket, @Nonnull String name) throws CloudException,
			InternalException;

	/**
	 * Bundles the specified virtual machine to cloud storage so it may be
	 * registered as a machine image. Upon completion of this task, there should
	 * be a file or set of files that capture the target virtual machine in a
	 * file format that can later be registered into a machine image.
	 * 
	 * @param virtualMachineId
	 *            the virtual machine to be bundled
	 * @param format
	 *            the format in which the VM should be bundled
	 * @param bucket
	 *            the bucket to which the VM should be bundled
	 * @param name
	 *            the name of the object to be created or the prefix for the
	 *            name
	 * @param trackingTask
	 *            the task against which progress for bundling will be tracked
	 * @throws CloudException
	 *             an error occurred with the cloud provider
	 * @throws InternalException
	 *             a local error occurred in the Dasein Cloud implementation
	 */
	public AsyncResult<Void> bundleVirtualMachineAsync(@Nonnull String virtualMachineId, @Nonnull MachineImageFormat format,
			@Nonnull String bucket, @Nonnull String name, @Nonnull AsynchronousTask<String> trackingTask)
			throws CloudException, InternalException;

	/**
	 * Captures a virtual machine as a machine image. If the underlying cloud
	 * requires the virtual machine to change state (a common example is that
	 * the VM must be {@link VmState#STOPPED}), then this method will make sure
	 * the VM is in that state. This method blocks until the cloud API has
	 * provided a reference to the machine image, regardless of what state it is
	 * in.
	 * 
	 * @param options
	 *            the options used in capturing the virtual machine
	 * @return a newly created machine image
	 * @throws CloudException
	 *             an error occurred with the cloud provider
	 * @throws InternalException
	 *             a local error occurred in the Dasein Cloud implementation
	 * @throws OperationNotSupportedException
	 *             the cloud does not support custom image creation
	 */
	public @Nonnull AsyncResult<MachineImage> captureImage(@Nonnull ImageCreateOptions options) throws CloudException,
			InternalException;

	/**
	 * Executes the process of {@link #captureImage(ImageCreateOptions)} as an
	 * asynchronous process tracked using an asynchronous task object. This
	 * method is expected to return immediately and provide feedback to a client
	 * on the progress of the machine image capture process.
	 * 
	 * @param options
	 *            the options to be used in capturing the virtual machine
	 * @param taskTracker
	 *            the asynchronous task for tracking the progress of this
	 *            operation
	 * @throws CloudException
	 *             an error occurred with the cloud provider
	 * @throws InternalException
	 *             a local error occurred in the Dasein Cloud implementation
	 * @throws OperationNotSupportedException
	 *             the cloud does not support custom image creation
	 */
	public AsyncResult<Void> captureImageAsync(@Nonnull ImageCreateOptions options,
			@Nonnull AsynchronousTask<MachineImage> taskTracker) throws CloudException, InternalException;

	/**
	 * Copies a machine image from current region of the user to another region.
	 *
	 * @param options
	 *            the options used to copy the machine image.
	 * @return ID of the new machine image created as a result of the copying.
	 * @throws CloudException
	 *             an error occurred with the cloud provider
	 * @throws InternalException
	 *             a local error occurred in the Dasein Cloud implementation
	 */
	public @Nonnull AsyncResult<String> copyImage(@Nonnull ImageCopyOptions options) throws CloudException,
			InternalException;

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
	public ImageCapabilities getCapabilities() throws CloudException, InternalException;

	/**
	 * Provides access to the current state of the specified image.
	 * 
	 * @param providerImageId
	 *            the cloud provider ID uniquely identifying the desired image
	 * @return the image matching the desired ID if it exists
	 * @throws CloudException
	 *             an error occurred with the cloud provider
	 * @throws InternalException
	 *             a local error occurred in the Dasein Cloud implementation
	 */
	public @Nullable AsyncResult<MachineImage> getImage(@Nonnull String providerImageId) throws CloudException,
			InternalException;

	/**
	 * Provides access to the current state of the specified image.
	 * 
	 * @param providerImageId
	 *            the cloud provider ID uniquely identifying the desired image
	 * @return the image matching the desired ID if it exists
	 * @throws CloudException
	 *             an error occurred with the cloud provider
	 * @throws InternalException
	 *             a local error occurred in the Dasein Cloud implementation
	 * @deprecated Use {@link #getImage(String)}
	 */
	@Deprecated
	public @Nullable AsyncResult<MachineImage> getMachineImage(@Nonnull String providerImageId) throws CloudException,
			InternalException;

	/**
	 * Indicates whether or not a public image library of
	 * {@link ImageClass#MACHINE} is supported.
	 * 
	 * @return true if there is a public library
	 * @deprecated Use {@link #supportsPublicLibrary(ImageClass)}
	 */
	@Deprecated
	public AsyncResult<Boolean> hasPublicLibrary();

	/**
	 * Creates a machine image from a virtual machine. This method simply calls
	 * {@link #captureImageAsync(ImageCreateOptions, AsynchronousTask)} using
	 * the task it returns to you.
	 * 
	 * @param vmId
	 *            the unique ID of the virtual machine to be imaged
	 * @param name
	 *            the name to give the new image
	 * @param description
	 *            the description to give the new image
	 * @return an asynchronous task for tracking the progress of the imaging
	 * @throws CloudException
	 *             an error occurred with the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein cloud implementation
	 * @throws OperationNotSupportedException
	 *             the cloud does not support custom image creation
	 * @deprecated Use {@link #captureImage(ImageCreateOptions)} or
	 *             {@link #captureImageAsync(ImageCreateOptions, AsynchronousTask)}
	 */
	@Deprecated
	public @Nonnull AsyncResult<AsynchronousTask<String>> imageVirtualMachine(String vmId, String name, String description)
			throws CloudException, InternalException;

	/**
	 * Indicates whether or not the specified image is shared publicly. It
	 * should return false when public image sharing simply isn't supported by
	 * the underlying cloud.
	 * 
	 * @param providerImageId
	 *            the machine image being checked for public status
	 * @return true if the target machine image is shared with the general
	 *         public
	 * @throws CloudException
	 *             an error occurred with the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein cloud implementation
	 */
	public AsyncResult<Boolean> isImageSharedWithPublic(@Nonnull String providerImageId) throws CloudException,
			InternalException;

	/**
	 * Indicates whether or not this account has access to any image services
	 * that might exist in this cloud.
	 * 
	 * @return true if the account is subscribed
	 * @throws CloudException
	 *             an error occurred with the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein cloud implementation
	 */
	public boolean isSubscribed() throws CloudException, InternalException;

	/**
	 * Lists the current status for all images in my library. The images
	 * returned should be the same list provided by
	 * {@link #listImages(ImageClass)}, except that this method returns a list
	 * of {@link ResourceStatus} objects.
	 * 
	 * @param cls
	 *            the image class of the target images
	 * @return a list of status objects for the images in the library
	 * @throws CloudException
	 *             an error occurred with the cloud provider
	 * @throws InternalException
	 *             a local error occurred in the Dasein Cloud implementation
	 */
	public @Nonnull AsyncResult<Iterable<ResourceStatus>> listImageStatus(@Nonnull ImageClass cls) throws CloudException,
			InternalException;

	/**
	 * Lists all images in a specific library based on the given filter options.
	 * With no filter options specified, this generally includes all images
	 * belonging to the current account as well any explicitly shared with me.
	 * In clouds without a public library, it's all images I can see. The
	 * filtering functionality may be wholly or partially delegated to the cloud
	 * provider for efficiency.
	 * 
	 * @param options
	 *            filter options
	 * @return the list of images in my image library of the specified image
	 *         class
	 * @throws CloudException
	 *             an error occurred with the cloud provider
	 * @throws InternalException
	 *             a local error occurred in the Dasein Cloud implementation
	 */
	public @Nonnull AsyncResult<Iterable<MachineImage>> listImages(@Nullable ImageFilterOptions options)
			throws CloudException, InternalException;

	/**
	 * Lists all images of class {@link ImageClass#MACHINE} in my library.
	 * 
	 * @return the list of machine machine images
	 * @throws CloudException
	 *             an error occurred with the cloud provider
	 * @throws InternalException
	 *             a local error occurred in the Dasein Cloud implementation
	 * @deprecated Use {@link #listImages(ImageClass)} with
	 *             {@link ImageClass#MACHINE}
	 */
	@Deprecated
	public @Nonnull AsyncResult<Iterable<MachineImage>> listMachineImages() throws CloudException, InternalException;

	/**
	 * Lists all images of class {@link ImageClass#MACHINE} that I can see
	 * belonging to the specified account owner. These images may either be
	 * public or explicitly shared with me. You may specify no accountId to
	 * indicate you are looking for the public library.
	 * 
	 * @param accountId
	 *            the accountId of the owner of the target images or
	 *            <code>null</code> indicating you want the public library
	 * @return the list of machine machine images belonging to the specified
	 *         account owner
	 * @throws CloudException
	 *             an error occurred with the cloud provider
	 * @throws InternalException
	 *             a local error occurred in the Dasein Cloud implementation
	 * @deprecated Use {@link #listImages(ImageClass,String)}
	 */
	@Deprecated
	public @Nonnull AsyncResult<Iterable<MachineImage>> listMachineImagesOwnedBy(String accountId) throws CloudException,
			InternalException;

	/**
	 * Provides the account numbers for all accounts which which the specified
	 * machine image has been shared. This method should return an empty list
	 * when sharing is unsupported.
	 * 
	 * @param providerImageId
	 *            the unique ID of the image being checked
	 * @return a list of account numbers with which the target image has been
	 *         shared
	 * @throws CloudException
	 *             an error occurred with the cloud provider
	 * @throws InternalException
	 *             a local error occurred in the Dasein Cloud implementation
	 */
	public @Nonnull AsyncResult<Iterable<String>> listShares(@Nonnull String providerImageId) throws CloudException,
			InternalException;

	/**
	 * Registers the bundled virtual machine stored in object storage as a
	 * machine image in the cloud.
	 * 
	 * @param options
	 *            the options used in registering the machine image
	 * @return a newly created machine image
	 * @throws CloudException
	 *             an error occurred with the cloud provider
	 * @throws InternalException
	 *             a local error occurred in the Dasein Cloud implementation
	 * @throws OperationNotSupportedException
	 *             the cloud does not support registering image from object
	 *             store bundles
	 */
	public @Nonnull AsyncResult<MachineImage> registerImageBundle(@Nonnull ImageCreateOptions options)
			throws CloudException, InternalException;

	/**
	 * Permanently removes all traces of the target image. This method should
	 * remove both the image record in the cloud and any cloud storage location
	 * in which the image resides for staging.
	 * 
	 * @param providerImageId
	 *            the unique ID of the image to be removed
	 * @throws CloudException
	 *             an error occurred with the cloud provider
	 * @throws InternalException
	 *             a local error occurred in the Dasein Cloud implementation
	 */
	public AsyncResult<Void> remove(@Nonnull String providerImageId) throws CloudException, InternalException;

	/**
	 * Permanently removes all traces of the target image. This method should
	 * remove both the image record in the cloud and any cloud storage location
	 * in which the image resides for staging.
	 * 
	 * @param providerImageId
	 *            the unique ID of the image to be removed
	 * @param checkState
	 *            if the state of the machine image should be checked first
	 * @throws CloudException
	 *             an error occurred with the cloud provider
	 * @throws InternalException
	 *             a local error occurred in the Dasein Cloud implementation
	 */
	public AsyncResult<Void> remove(@Nonnull String providerImageId, boolean checkState) throws CloudException,
			InternalException;

	/**
	 * Removes ALL specific account shares for the specified image. NOTE THAT
	 * THIS METHOD WILL NOT THROW AN EXCEPTION WHEN IMAGE SHARING IS NOT
	 * SUPPORTED. IT IS A NO-OP IN THAT SCENARIO.
	 * 
	 * @param providerImageId
	 *            the unique ID of the image to be unshared
	 * @throws CloudException
	 *             an error occurred with the cloud provider
	 * @throws InternalException
	 *             a local error occurred in the Dasein Cloud implementation
	 */
	public AsyncResult<Void> removeAllImageShares(@Nonnull String providerImageId) throws CloudException, InternalException;

	/**
	 * Removes the specified account number from the list of accounts with which
	 * this image is shared.
	 * 
	 * @param providerImageId
	 *            the unique ID of the image to be unshared
	 * @param accountNumber
	 *            the account number to be removed
	 * @throws CloudException
	 *             an error occurred with the cloud provider
	 * @throws InternalException
	 *             a local error occurred in the Dasein Cloud implementation
	 * @throws OperationNotSupportedException
	 *             the cloud does not support sharing images with other accounts
	 */
	public AsyncResult<Void> removeImageShare(@Nonnull String providerImageId, @Nonnull String accountNumber)
			throws CloudException, InternalException;

	/**
	 * Removes the public share (if shared) for this image. Safe to call even if
	 * the image is not shared or sharing is not supported.
	 * 
	 * @param providerImageId
	 *            the unique ID of the image to be unshared
	 * @throws CloudException
	 *             an error occurred with the cloud provider
	 * @throws InternalException
	 *             a local error occurred in the Dasein Cloud implementation
	 */
	public AsyncResult<Void> removePublicShare(@Nonnull String providerImageId) throws CloudException, InternalException;

	/**
	 * Searches images owned by the specified account number (if null, all
	 * visible images are searched). It will match against the specified
	 * parameters. Any null parameter does not constrain the search.
	 * 
	 * @param accountNumber
	 *            the account number to search against or null for searching all
	 *            visible images
	 * @param keyword
	 *            a keyword on which to search
	 * @param platform
	 *            the platform to match
	 * @param architecture
	 *            the architecture to match
	 * @param imageClasses
	 *            the image classes to search for (null or empty list for all)
	 * @return all matching machine images
	 * @throws CloudException
	 *             an error occurred with the cloud provider
	 * @throws InternalException
	 *             a local error occurred in the Dasein Cloud implementation
	 */
	public @Nonnull AsyncResult<Iterable<MachineImage>> searchImages(@Nullable String accountNumber,
			@Nullable String keyword, @Nullable Platform platform, @Nullable Architecture architecture,
			@Nullable ImageClass... imageClasses) throws CloudException, InternalException;

	/**
	 * Searches all snapshots visible to the current account owner (whether
	 * owned by the account owner or someone else) for all images matching the
	 * specified image filter options. This differs from the
	 * {@link #listImages(ImageFilterOptions)} method in that it covers all
	 * images, not just ones belonging to a specific account.
	 * 
	 * @return all images in the current region matching the specified filter
	 *         options
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud implementation
	 * @throws CloudException
	 *             an error occurred with the cloud provider
	 */
	public @Nonnull AsyncResult<Iterable<MachineImage>> searchPublicImages(@Nonnull ImageFilterOptions options)
			throws InternalException, CloudException;

	/**
	 * Searches the public machine image library. It will match against the
	 * specified parameters. Any null parameter does not constrain the search.
	 * 
	 * @param keyword
	 *            a keyword on which to search
	 * @param platform
	 *            the platform to match
	 * @param architecture
	 *            the architecture to match
	 * @param imageClasses
	 *            the image classes to search for (null or empty list for all)
	 * @return all matching machine images
	 * @throws CloudException
	 *             an error occurred with the cloud provider
	 * @throws InternalException
	 *             a local error occurred in the Dasein Cloud implementation
	 */
	public @Nonnull AsyncResult<Iterable<MachineImage>> searchPublicImages(@Nullable String keyword,
			@Nullable Platform platform, @Nullable Architecture architecture, @Nullable ImageClass... imageClasses)
			throws CloudException, InternalException;

	/**
	 * Adds or removes sharing for the specified image with the specified
	 * account or the public. This method simply delegates to the newer
	 * {@link #addImageShare(String, String)},
	 * {@link #removeImageShare(String, String)},
	 * {@link #addPublicShare(String)}, or {@link #removePublicShare(String)}
	 * methods.
	 * 
	 * @param providerImageId
	 *            the image to be shared/unshared
	 * @param withAccountId
	 *            the account with which the image is to be shared/unshared
	 *            (null if the operation is for a public share)
	 * @param allow
	 *            true if the image is to be shared, false if it is to be
	 *            unshared
	 * @throws CloudException
	 *             an error occurred with the cloud provider
	 * @throws InternalException
	 *             a local error occurred in the Dasein Cloud implementation
	 * @throws OperationNotSupportedException
	 *             the cloud does not support sharing images with other accounts
	 * @deprecated Use {@link #addImageShare(String, String)},
	 *             {@link #removeImageShare(String, String)},
	 *             {@link #addPublicShare(String)}, or
	 *             {@link #removePublicShare(String)}
	 */
	@Deprecated
	public AsyncResult<Void>
			shareMachineImage(@Nonnull String providerImageId, @Nullable String withAccountId, boolean allow)
					throws CloudException, InternalException;

	/**
	 * Indicates whether or not the cloud supports the ability to capture custom
	 * images.
	 * 
	 * @return true if you can capture custom images in this cloud
	 * @throws CloudException
	 *             an error occurred with the cloud provider when checking this
	 *             capability
	 * @throws InternalException
	 *             an error occurred within the Dasein cloud implementation
	 *             while check this capability
	 * @deprecated Use {@link #supportsImageCapture(MachineImageType)}
	 */
	@Deprecated
	public AsyncResult<Boolean> supportsCustomImages() throws CloudException, InternalException;

	/**
	 * Indicates whether or not this cloud supports sharing images with specific
	 * accounts.
	 * 
	 * @return true if you can share your images with another account
	 * @throws CloudException
	 *             an error occurred with the cloud provider when checking this
	 *             capability
	 * @throws InternalException
	 *             an error occurred within the Dasein cloud implementation
	 *             while check this capability
	 * @deprecated use {@link ImageCapabilities#supportsImageSharing()}
	 */
	@Deprecated
	public AsyncResult<Boolean> supportsImageSharing() throws CloudException, InternalException;

	/**
	 * Updates meta-data for a image with the new values. It will not overwrite
	 * any value that currently exists unless it appears in the tags you submit.
	 *
	 * @param imageId
	 *            the image to update
	 * @param tags
	 *            the meta-data tags to set
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	public AsyncResult<Void> updateTags(@Nonnull String imageId, @Nonnull Tag... tags) throws CloudException,
			InternalException;

	/**
	 * Updates meta-data for multiple images with the new values. It will not
	 * overwrite any value that currently exists unless it appears in the tags
	 * you submit.
	 *
	 * @param imageIds
	 *            the images to update
	 * @param tags
	 *            the meta-data tags to set
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	public AsyncResult<Void> updateTags(@Nonnull String[] imageIds, @Nonnull Tag... tags) throws CloudException,
			InternalException;

	/**
	 * Removes meta-data from an image. If tag values are set, their removal is
	 * dependent on underlying cloud provider behavior. They may be removed only
	 * if the tag value matches or they may be removed regardless of the value.
	 *
	 * @param imageId
	 *            the image to update
	 * @param tags
	 *            the meta-data tags to remove
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	public AsyncResult<Void> removeTags(@Nonnull String imageId, @Nonnull Tag... tags) throws CloudException,
			InternalException;

	/**
	 * Removes meta-data from multiple images. If tag values are set, their
	 * removal is dependent on underlying cloud provider behavior. They may be
	 * removed only if the tag value matches or they may be removed regardless
	 * of the value.
	 *
	 * @param imageIds
	 *            the image to update
	 * @param tags
	 *            the meta-data tags to remove
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	public AsyncResult<Void> removeTags(@Nonnull String[] imageIds, @Nonnull Tag... tags) throws CloudException,
			InternalException;

	/**
	 * Set meta-data for an image. Remove any tags that were not provided by the
	 * incoming tags, and add or overwrite any new or pre-existing tags.
	 *
	 * @param imageId
	 *            the image to update
	 * @param tags
	 *            the meta-data tags to remove
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	public AsyncResult<Void> setTags(@Nonnull String imageId, @Nonnull Tag... tags) throws CloudException, InternalException;

	/**
	 * Set meta-data for multiple images. Remove any tags that were not provided
	 * by the incoming tags, and add or overwrite any new or pre-existing tags.
	 *
	 * @param imageIds
	 *            the images to update
	 * @param tags
	 *            the meta-data tags to remove
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	public AsyncResult<Void> setTags(@Nonnull String[] imageIds, @Nonnull Tag... tags) throws CloudException,
			InternalException;

	MachineImageSupport getSupport();
}
