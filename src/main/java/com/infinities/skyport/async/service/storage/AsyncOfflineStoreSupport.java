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
package com.infinities.skyport.async.service.storage;

import java.io.File;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.dasein.cloud.CloudException;
import org.dasein.cloud.InternalException;
import org.dasein.cloud.identity.ServiceAction;
import org.dasein.cloud.storage.Blob;
import org.dasein.cloud.storage.BlobStoreSupport;
import org.dasein.cloud.storage.FileTransfer;
import org.dasein.cloud.storage.OfflineStoreRequest;

import com.infinities.skyport.async.AsyncResult;

public interface AsyncOfflineStoreSupport extends AsyncBlobStoreSupport {

	static public final ServiceAction CREATE_REQUEST = new ServiceAction("OFFLINESTORE:CREATE_REQUEST");
	static public final ServiceAction GET_REQUEST = new ServiceAction("OFFLINESTORE:GET_REQUEST");
	static public final ServiceAction LIST_REQUEST = new ServiceAction("OFFLINESTORE:LIST_REQUEST");
	static public final ServiceAction GET_REQUEST_RESULT = new ServiceAction("OFFLINESTORE:GET_REQUEST_RESULT");


	/**
	 * List current offline storage requests. Completed jobs may remain in this
	 * list for a provider-specific amount of time.
	 * 
	 * @param bucket
	 *            name of bucket to list requests for
	 * @return iterable of current known requests
	 * @throws CloudException
	 * @throws InternalException
	 */
	public @Nonnull AsyncResult<Iterable<OfflineStoreRequest>> listRequests(@Nonnull String bucket) throws CloudException,
			InternalException;

	/**
	 * Get a specific offline storage request
	 * 
	 * @param bucket
	 *            name of bucket for request
	 * @param requestId
	 *            provider-specific identifier of request
	 * @return a representation of the request, or null if it is not found
	 * @throws CloudException
	 * @throws InternalException
	 */
	public @Nullable AsyncResult<OfflineStoreRequest> getRequest(@Nonnull String bucket, @Nonnull String requestId)
			throws CloudException, InternalException;

	/**
	 * Create a new bucket list request
	 * 
	 * @param bucket
	 *            name of bucket to list
	 * @return representation of the request
	 * @throws CloudException
	 * @throws InternalException
	 */
	public @Nonnull AsyncResult<OfflineStoreRequest> createListRequest(@Nonnull String bucket) throws CloudException,
			InternalException;

	/**
	 * Create a new object download request
	 * 
	 * @param bucket
	 *            name of bucket containing object
	 * @param object
	 *            name of object to download
	 * @return representation of the request
	 * @throws CloudException
	 * @throws InternalException
	 */
	public @Nonnull AsyncResult<OfflineStoreRequest> createDownloadRequest(@Nonnull String bucket, @Nonnull String object)
			throws CloudException, InternalException;

	/**
	 * Retrieve the results of a completed list request. Will fail if the
	 * request is not complete.
	 * 
	 * @param bucket
	 *            name of bucket for request
	 * @param requestId
	 *            provider-specific identifier of request
	 * @return iterable of found objects
	 * @throws InternalException
	 * @throws CloudException
	 */
	public @Nonnull AsyncResult<Iterable<Blob>> getListRequestResult(@Nonnull String bucket, @Nonnull String requestId)
			throws InternalException, CloudException;

	/**
	 * Initiate the download for a request. Will fail if the request is not
	 * complete.
	 * 
	 * @param bucket
	 *            name of bucket for request
	 * @param requestId
	 *            provider-specific identifier of request
	 * @param toFile
	 *            destination file for download results
	 * @return FileTransfer asynchronous object to track the progress of the
	 *         download
	 * @throws InternalException
	 * @throws CloudException
	 */
	public @Nonnull AsyncResult<FileTransfer> getDownloadRequestResult(@Nonnull String bucket, @Nonnull String requestId,
			@Nonnull File toFile) throws InternalException, CloudException;

	@Override
	BlobStoreSupport getSupport();
}
