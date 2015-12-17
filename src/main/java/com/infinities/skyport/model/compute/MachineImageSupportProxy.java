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
package com.infinities.skyport.model.compute;

import java.io.Serializable;

import org.dasein.cloud.AsynchronousTask;
import org.dasein.cloud.CloudException;
import org.dasein.cloud.InternalException;
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
import org.dasein.cloud.compute.Platform;
import org.dasein.cloud.identity.ServiceAction;

import com.infinities.skyport.async.AsyncResult;
import com.infinities.skyport.async.service.compute.AsyncMachineImageSupport;

public class MachineImageSupportProxy implements AsyncMachineImageSupport, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final AsyncMachineImageSupport support;


	public MachineImageSupportProxy(AsyncMachineImageSupport support) {
		this.support = support;
	}

	@Override
	public String[] mapServiceAction(ServiceAction action) {
		return support.mapServiceAction(action);
	}

	@Override
	public AsyncResult<Void> addImageShare(String providerImageId, String accountNumber) throws CloudException,
			InternalException {
		return support.addImageShare(providerImageId, accountNumber);
	}

	@Override
	public AsyncResult<Void> addPublicShare(String providerImageId) throws CloudException, InternalException {
		return support.addPublicShare(providerImageId);
	}

	@Override
	public AsyncResult<String> bundleVirtualMachine(String virtualMachineId, MachineImageFormat format, String bucket,
			String name) throws CloudException, InternalException {
		return support.bundleVirtualMachine(virtualMachineId, format, bucket, name);
	}

	@Override
	public AsyncResult<Void> bundleVirtualMachineAsync(String virtualMachineId, MachineImageFormat format, String bucket,
			String name, AsynchronousTask<String> trackingTask) throws CloudException, InternalException {
		return support.bundleVirtualMachineAsync(virtualMachineId, format, bucket, name, trackingTask);
	}

	@Override
	public AsyncResult<MachineImage> captureImage(ImageCreateOptions options) throws CloudException, InternalException {
		return support.captureImage(options);
	}

	@Override
	public AsyncResult<Void> captureImageAsync(ImageCreateOptions options, AsynchronousTask<MachineImage> taskTracker)
			throws CloudException, InternalException {
		return support.captureImageAsync(options, taskTracker);
	}

	@Override
	public AsyncResult<String> copyImage(ImageCopyOptions options) throws CloudException, InternalException {
		return support.copyImage(options);
	}

	@Override
	public ImageCapabilities getCapabilities() throws CloudException, InternalException {
		return support.getCapabilities();
	}

	@Override
	public AsyncResult<MachineImage> getImage(String providerImageId) throws CloudException, InternalException {
		return support.getImage(providerImageId);
	}

	@SuppressWarnings("deprecation")
	@Override
	public AsyncResult<MachineImage> getMachineImage(String providerImageId) throws CloudException, InternalException {
		return support.getMachineImage(providerImageId);
	}

	@SuppressWarnings("deprecation")
	@Override
	public AsyncResult<Boolean> hasPublicLibrary() {
		return support.hasPublicLibrary();
	}

	@SuppressWarnings("deprecation")
	@Override
	public AsyncResult<AsynchronousTask<String>> imageVirtualMachine(String vmId, String name, String description)
			throws CloudException, InternalException {
		return support.imageVirtualMachine(vmId, name, description);
	}

	@Override
	public AsyncResult<Boolean> isImageSharedWithPublic(String providerImageId) throws CloudException, InternalException {
		return support.isImageSharedWithPublic(providerImageId);
	}

	@Override
	public boolean isSubscribed() throws CloudException, InternalException {
		return support.isSubscribed();
	}

	@Override
	public AsyncResult<Iterable<ResourceStatus>> listImageStatus(ImageClass cls) throws CloudException, InternalException {
		return support.listImageStatus(cls);
	}

	@Override
	public AsyncResult<Iterable<MachineImage>> listImages(ImageFilterOptions options) throws CloudException,
			InternalException {
		return support.listImages(options);
	}

	@SuppressWarnings("deprecation")
	@Override
	public AsyncResult<Iterable<MachineImage>> listMachineImages() throws CloudException, InternalException {
		return support.listMachineImages();
	}

	@SuppressWarnings("deprecation")
	@Override
	public AsyncResult<Iterable<MachineImage>> listMachineImagesOwnedBy(String accountId) throws CloudException,
			InternalException {
		return support.listMachineImagesOwnedBy(accountId);
	}

	@Override
	public AsyncResult<Iterable<String>> listShares(String providerImageId) throws CloudException, InternalException {
		return support.listShares(providerImageId);
	}

	@Override
	public AsyncResult<MachineImage> registerImageBundle(ImageCreateOptions options) throws CloudException,
			InternalException {
		return support.registerImageBundle(options);
	}

	@Override
	public AsyncResult<Void> remove(String providerImageId) throws CloudException, InternalException {
		return support.remove(providerImageId);
	}

	@Override
	public AsyncResult<Void> remove(String providerImageId, boolean checkState) throws CloudException, InternalException {
		return support.remove(providerImageId, checkState);
	}

	@Override
	public AsyncResult<Void> removeAllImageShares(String providerImageId) throws CloudException, InternalException {
		return support.removeAllImageShares(providerImageId);
	}

	@Override
	public AsyncResult<Void> removeImageShare(String providerImageId, String accountNumber) throws CloudException,
			InternalException {
		return support.removeImageShare(providerImageId, accountNumber);
	}

	@Override
	public AsyncResult<Void> removePublicShare(String providerImageId) throws CloudException, InternalException {
		return support.removePublicShare(providerImageId);
	}

	@Override
	public AsyncResult<Iterable<MachineImage>> searchImages(String accountNumber, String keyword, Platform platform,
			Architecture architecture, ImageClass... imageClasses) throws CloudException, InternalException {
		return support.searchImages(accountNumber, keyword, platform, architecture, imageClasses);
	}

	@Override
	public AsyncResult<Iterable<MachineImage>> searchPublicImages(ImageFilterOptions options) throws InternalException,
			CloudException {
		return support.searchPublicImages(options);
	}

	@Override
	public AsyncResult<Iterable<MachineImage>> searchPublicImages(String keyword, Platform platform,
			Architecture architecture, ImageClass... imageClasses) throws CloudException, InternalException {
		return support.searchPublicImages(keyword, platform, architecture, imageClasses);
	}

	@SuppressWarnings("deprecation")
	@Override
	public AsyncResult<Void> shareMachineImage(String providerImageId, String withAccountId, boolean allow)
			throws CloudException, InternalException {
		return support.shareMachineImage(providerImageId, withAccountId, allow);
	}

	@SuppressWarnings("deprecation")
	@Override
	public AsyncResult<Boolean> supportsCustomImages() throws CloudException, InternalException {
		return support.supportsCustomImages();
	}

	@SuppressWarnings("deprecation")
	@Override
	public AsyncResult<Boolean> supportsImageSharing() throws CloudException, InternalException {
		return support.supportsImageSharing();
	}

	@Override
	public AsyncResult<Void> updateTags(String imageId, Tag... tags) throws CloudException, InternalException {
		return support.updateTags(imageId, tags);
	}

	@Override
	public AsyncResult<Void> updateTags(String[] imageIds, Tag... tags) throws CloudException, InternalException {
		return support.updateTags(imageIds, tags);
	}

	@Override
	public AsyncResult<Void> removeTags(String imageId, Tag... tags) throws CloudException, InternalException {
		return support.removeTags(imageId, tags);
	}

	@Override
	public AsyncResult<Void> removeTags(String[] imageIds, Tag... tags) throws CloudException, InternalException {
		return support.removeTags(imageIds, tags);
	}

	@Override
	public AsyncResult<Void> setTags(String imageId, Tag... tags) throws CloudException, InternalException {
		return support.setTags(imageId, tags);
	}

	@Override
	public AsyncResult<Void> setTags(String[] imageIds, Tag... tags) throws CloudException, InternalException {
		return support.setTags(imageIds, tags);
	}

	@Override
	public MachineImageSupport getSupport() {
		return support.getSupport();
	}

}
