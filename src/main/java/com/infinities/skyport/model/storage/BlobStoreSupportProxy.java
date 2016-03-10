package com.infinities.skyport.model.storage;

import java.io.File;
import java.io.Serializable;
import java.util.Map;

import org.dasein.cloud.CloudException;
import org.dasein.cloud.InternalException;
import org.dasein.cloud.Tag;
import org.dasein.cloud.identity.ServiceAction;
import org.dasein.cloud.storage.Blob;
import org.dasein.cloud.storage.BlobStoreCapabilities;
import org.dasein.cloud.storage.FileTransfer;
import org.dasein.util.uom.storage.Byte;
import org.dasein.util.uom.storage.Storage;

import com.infinities.skyport.async.AsyncResult;
import com.infinities.skyport.async.service.storage.AsyncBlobStoreSupport;
import com.infinities.skyport.storage.SkyportBlobStoreSupport;

public class BlobStoreSupportProxy implements AsyncBlobStoreSupport, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final AsyncBlobStoreSupport support;


	public BlobStoreSupportProxy(AsyncBlobStoreSupport support) {
		this.support = support;
	}

	@Override
	public String[] mapServiceAction(ServiceAction action) {
		return support.mapServiceAction(action);
	}

	@Override
	public BlobStoreCapabilities getCapabilities() throws CloudException, InternalException {
		return support.getCapabilities();
	}

	@Override
	public AsyncResult<Void> clearBucket(String bucket) throws CloudException, InternalException {
		return support.clearBucket(bucket);
	}

	@Override
	public AsyncResult<Blob> createBucket(String bucket, boolean findFreeName)
			throws InternalException, CloudException {
		return support.createBucket(bucket, findFreeName);
	}

	@Override
	public AsyncResult<FileTransfer> download(String bucket, String objectName, File toFile)
			throws InternalException, CloudException {
		return support.download(bucket, objectName, toFile);
	}

	@Override
	public AsyncResult<Boolean> exists(String bucket) throws InternalException, CloudException {
		return support.exists(bucket);
	}

	@Override
	public AsyncResult<Blob> getBucket(String bucketName) throws InternalException, CloudException {
		return support.getBucket(bucketName);
	}

	@Override
	public AsyncResult<Blob> getObject(String bucketName, String objectName) throws InternalException, CloudException {
		return support.getObject(bucketName, objectName);
	}

	@Override
	public AsyncResult<String> getSignedObjectUrl(String bucket, String object, String expiresEpochInSeconds)
			throws InternalException, CloudException {
		return support.getSignedObjectUrl(bucket, object, expiresEpochInSeconds);
	}

	@Override
	public AsyncResult<Storage<Byte>> getObjectSize(String bucketName, String objectName)
			throws InternalException, CloudException {
		return support.getObjectSize(bucketName, objectName);
	}

	@Override
	public AsyncResult<Boolean> isPublic(String bucket, String object) throws CloudException, InternalException {
		return support.isPublic(bucket, object);
	}

	@Override
	public boolean isSubscribed() throws CloudException, InternalException {
		return support.isSubscribed();
	}

	@Override
	public AsyncResult<Iterable<Blob>> list(String bucket) throws CloudException, InternalException {
		return support.list(bucket);
	}

	@Override
	public AsyncResult<Void> makePublic(String bucket) throws InternalException, CloudException {
		return support.makePublic(bucket);
	}

	@Override
	public AsyncResult<Void> makePublic(String bucket, String object) throws InternalException, CloudException {
		return support.makePublic(bucket, object);
	}

	@Override
	public AsyncResult<Void> move(String fromBucket, String objectName, String toBucket)
			throws InternalException, CloudException {
		return support.move(fromBucket, objectName, toBucket);
	}

	@Override
	public AsyncResult<Void> removeBucket(String bucket) throws CloudException, InternalException {
		return support.removeBucket(bucket);
	}

	@Override
	public AsyncResult<Void> removeObject(String bucket, String object) throws CloudException, InternalException {
		return support.removeObject(bucket, object);
	}

	@Override
	public AsyncResult<String> renameBucket(String oldName, String newName, boolean findFreeName)
			throws CloudException, InternalException {
		return support.renameBucket(oldName, newName, findFreeName);
	}

	@Override
	public AsyncResult<Void> renameObject(String bucket, String oldName, String newName)
			throws CloudException, InternalException {
		return support.renameObject(bucket, oldName, newName);
	}

	@Override
	public AsyncResult<Blob> upload(File sourceFile, String bucket, String objectName)
			throws CloudException, InternalException {
		return support.upload(sourceFile, bucket, objectName);
	}

	@Override
	public AsyncResult<Void> updateTags(String bucket, Tag... tags) throws CloudException, InternalException {
		return support.updateTags(bucket, tags);
	}

	@Override
	public AsyncResult<Void> updateTags(String[] buckets, Tag... tags) throws CloudException, InternalException {
		return support.updateTags(buckets, tags);
	}

	@Override
	public AsyncResult<Void> removeTags(String bucket, Tag... tags) throws CloudException, InternalException {
		return support.removeTags(bucket, tags);
	}

	@Override
	public AsyncResult<Void> removeTags(String[] buckets, Tag... tags) throws CloudException, InternalException {
		return support.removeTags(buckets, tags);
	}

	@Override
	public AsyncResult<Void> setTags(String bucket, Tag... tags) throws CloudException, InternalException {
		return support.setTags(bucket, tags);
	}

	@Override
	public AsyncResult<Void> setTags(String[] buckets, Tag... tags) throws CloudException, InternalException {
		return support.setTags(buckets, tags);
	}

	@Override
	public SkyportBlobStoreSupport getSupport() {
		return support.getSupport();
	}

	@Override
	public AsyncResult<Void> copy(String sourceBucket, String sourceObject, String targetBucket, String targetObject)
			throws InternalException, CloudException {
		return support.copy(sourceBucket, sourceObject, targetBucket, targetObject);
	}

	@Override
	public AsyncResult<Map<String, String>> getMetadata(String... strs) throws CloudException, InternalException {
		return support.getMetadata(strs);
	}

	@Override
	public AsyncResult<Void> setObjectTags(String bucketName, String objectName, Tag... tags)
			throws CloudException, InternalException {
		return support.setObjectTags(bucketName, objectName, tags);
	}

	@Override
	public AsyncResult<Void> setObjectTags(String bucketName, String[] objectNames, Tag... tags)
			throws CloudException, InternalException {
		return support.setObjectTags(bucketName, objectNames, tags);
	}

	@Override
	public AsyncResult<Void> updateObjectTags(String bucketName, String objectName, Tag... tags)
			throws CloudException, InternalException {
		return support.updateObjectTags(bucketName, objectName, tags);
	}

	@Override
	public AsyncResult<Void> updateObjectTags(String bucketName, String[] objectNames, Tag... tags)
			throws CloudException, InternalException {
		return support.updateObjectTags(bucketName, objectNames, tags);
	}

	@Override
	public AsyncResult<Void> removeObjectTags(String bucketName, String objectName, Tag... tags)
			throws CloudException, InternalException {
		return support.removeObjectTags(bucketName, objectName, tags);
	}

	@Override
	public AsyncResult<Void> removeObjectTags(String bucketName, String[] objectNames, Tag... tags)
			throws CloudException, InternalException {
		return support.removeObjectTags(bucketName, objectNames, tags);
	}

}
