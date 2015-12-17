package com.infinities.skyport.async.service.storage;

import java.io.File;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.dasein.cloud.AccessControlledService;
import org.dasein.cloud.CloudException;
import org.dasein.cloud.InternalException;
import org.dasein.cloud.Tag;
import org.dasein.cloud.identity.ServiceAction;
import org.dasein.cloud.storage.Blob;
import org.dasein.cloud.storage.BlobStoreCapabilities;
import org.dasein.cloud.storage.BlobStoreSupport;
import org.dasein.cloud.storage.FileTransfer;
import org.dasein.util.uom.storage.Storage;

import com.infinities.skyport.async.AsyncResult;

public interface AsyncBlobStoreSupport extends AccessControlledService {

	static public final ServiceAction ANY = new ServiceAction("BLOB:ANY");

	static public final ServiceAction CREATE_BUCKET = new ServiceAction("BLOB:CREATE_BUCKET");
	static public final ServiceAction DOWNLOAD = new ServiceAction("BLOB:DOWNLOAD");
	static public final ServiceAction GET_BUCKET = new ServiceAction("BLOB:GET_BUCKET");
	static public final ServiceAction LIST_BUCKET = new ServiceAction("BLOB:LIST_BUCKET");
	static public final ServiceAction LIST_BUCKET_CONTENTS = new ServiceAction("BLOB:LIST_BUCKET_CONTENTS");
	static public final ServiceAction MAKE_PUBLIC = new ServiceAction("BLOB:MAKE_PUBLIC");
	static public final ServiceAction REMOVE_BUCKET = new ServiceAction("BLOB:REMOVE_BUCKET");
	static public final ServiceAction UPLOAD = new ServiceAction("BLOB:UPLOAD");


	@Nonnull
	BlobStoreCapabilities getCapabilities() throws CloudException, InternalException;

	AsyncResult<Void> clearBucket(@Nonnull String bucket) throws CloudException, InternalException;

	@Nonnull
	AsyncResult<Blob> createBucket(@Nonnull String bucket, boolean findFreeName) throws InternalException, CloudException;

	AsyncResult<FileTransfer> download(@Nullable String bucket, @Nonnull String objectName, @Nonnull File toFile)
			throws InternalException, CloudException;

	AsyncResult<Boolean> exists(@Nonnull String bucket) throws InternalException, CloudException;

	AsyncResult<Blob> getBucket(@Nonnull String bucketName) throws InternalException, CloudException;

	AsyncResult<Blob> getObject(@Nullable String bucketName, @Nonnull String objectName) throws InternalException,
			CloudException;

	@Nullable
	AsyncResult<String> getSignedObjectUrl(@Nonnull String bucket, @Nonnull String object,
			@Nonnull String expiresEpochInSeconds) throws InternalException, CloudException;

	@Nullable
	AsyncResult<Storage<org.dasein.util.uom.storage.Byte>> getObjectSize(@Nullable String bucketName,
			@Nullable String objectName) throws InternalException, CloudException;

	AsyncResult<Boolean> isPublic(@Nullable String bucket, @Nullable String object) throws CloudException, InternalException;

	boolean isSubscribed() throws CloudException, InternalException;

	@Nonnull
	AsyncResult<Iterable<Blob>> list(@Nullable String bucket) throws CloudException, InternalException;

	AsyncResult<Void> makePublic(@Nonnull String bucket) throws InternalException, CloudException;

	AsyncResult<Void> makePublic(@Nullable String bucket, @Nonnull String object) throws InternalException, CloudException;

	AsyncResult<Void> move(@Nullable String fromBucket, @Nullable String objectName, @Nullable String toBucket)
			throws InternalException, CloudException;

	AsyncResult<Void> removeBucket(@Nonnull String bucket) throws CloudException, InternalException;

	AsyncResult<Void> removeObject(@Nullable String bucket, @Nonnull String object) throws CloudException, InternalException;

	@Nonnull
	AsyncResult<String> renameBucket(@Nonnull String oldName, @Nonnull String newName, boolean findFreeName)
			throws CloudException, InternalException;

	AsyncResult<Void> renameObject(@Nullable String bucket, @Nonnull String oldName, @Nonnull String newName)
			throws CloudException, InternalException;

	@Nonnull
	AsyncResult<Blob> upload(@Nonnull File sourceFile, @Nullable String bucket, @Nonnull String objectName)
			throws CloudException, InternalException;

	/**
	 * Updates meta-data for a bucket with the new values. It will not overwrite
	 * any value that currently exists unless it appears in the tags you submit.
	 *
	 * @param bucket
	 *            the bucket to update
	 * @param tags
	 *            the meta-data tags to set
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	AsyncResult<Void> updateTags(@Nonnull String bucket, @Nonnull Tag... tags) throws CloudException, InternalException;

	/**
	 * Updates meta-data for multiple buckets with the new values. It will not
	 * overwrite any value that currently exists unless it appears in the tags
	 * you submit.
	 *
	 * @param buckets
	 *            the buckets to update
	 * @param tags
	 *            the meta-data tags to set
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	AsyncResult<Void> updateTags(@Nonnull String[] buckets, @Nonnull Tag... tags) throws CloudException, InternalException;

	/**
	 * Removes meta-data from an bucket. If tag values are set, their removal is
	 * dependent on underlying cloud provider behavior. They may be removed only
	 * if the tag value matches or they may be removed regardless of the value.
	 *
	 * @param bucket
	 *            the bucket to update
	 * @param tags
	 *            the meta-data tags to remove
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	AsyncResult<Void> removeTags(@Nonnull String bucket, @Nonnull Tag... tags) throws CloudException, InternalException;

	/**
	 * Removes meta-data from multiple buckets. If tag values are set, their
	 * removal is dependent on underlying cloud provider behavior. They may be
	 * removed only if the tag value matches or they may be removed regardless
	 * of the value.
	 *
	 * @param buckets
	 *            the bucket to update
	 * @param tags
	 *            the meta-data tags to remove
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	AsyncResult<Void> removeTags(@Nonnull String[] buckets, @Nonnull Tag... tags) throws CloudException, InternalException;

	/**
	 * Set meta-data for an bucket. Remove any tags that were not provided by
	 * the incoming tags, and add or overwrite any new or pre-existing tags.
	 *
	 * @param bucket
	 *            the bucket to update
	 * @param tags
	 *            the meta-data tags to remove
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	AsyncResult<Void> setTags(@Nonnull String bucket, @Nonnull Tag... tags) throws CloudException, InternalException;

	/**
	 * Set meta-data for multiple buckets. Remove any tags that were not
	 * provided by the incoming tags, and add or overwrite any new or
	 * pre-existing tags.
	 *
	 * @param buckets
	 *            the buckets to update
	 * @param tags
	 *            the meta-data tags to remove
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	AsyncResult<Void> setTags(@Nonnull String[] buckets, @Nonnull Tag... tags) throws CloudException, InternalException;

	BlobStoreSupport getSupport();
}
