package com.infinities.skyport.model.compute;

import java.io.Serializable;

import org.dasein.cloud.CloudException;
import org.dasein.cloud.InternalException;
import org.dasein.cloud.ResourceStatus;
import org.dasein.cloud.Tag;
import org.dasein.cloud.compute.Volume;
import org.dasein.cloud.compute.VolumeCapabilities;
import org.dasein.cloud.compute.VolumeCreateOptions;
import org.dasein.cloud.compute.VolumeFilterOptions;
import org.dasein.cloud.compute.VolumeProduct;
import org.dasein.cloud.compute.VolumeSupport;
import org.dasein.cloud.identity.ServiceAction;

import com.infinities.skyport.async.AsyncResult;
import com.infinities.skyport.async.service.compute.AsyncVolumeSupport;

public class VolumeSupportProxy implements AsyncVolumeSupport, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final AsyncVolumeSupport support;


	public VolumeSupportProxy(AsyncVolumeSupport support) {
		this.support = support;
	}

	@Override
	public String[] mapServiceAction(ServiceAction action) {
		return support.mapServiceAction(action);
	}

	@Override
	public AsyncResult<Void> attach(String volumeId, String toServer, String deviceId) throws InternalException,
			CloudException {
		return support.attach(volumeId, toServer, deviceId);
	}

	@SuppressWarnings("deprecation")
	@Override
	public AsyncResult<String> create(String fromSnapshot, int sizeInGb, String inZone) throws InternalException,
			CloudException {
		return support.create(fromSnapshot, sizeInGb, inZone);
	}

	@Override
	public AsyncResult<String> createVolume(VolumeCreateOptions options) throws InternalException, CloudException {
		return support.createVolume(options);
	}

	@Override
	public AsyncResult<Void> detach(String volumeId) throws InternalException, CloudException {
		return support.detach(volumeId);
	}

	@Override
	public AsyncResult<Void> detach(String volumeId, boolean force) throws InternalException, CloudException {
		return support.detach(volumeId, force);
	}

	@Override
	public VolumeCapabilities getCapabilities() throws CloudException, InternalException {
		return support.getCapabilities();
	}

	@Override
	public AsyncResult<Volume> getVolume(String volumeId) throws InternalException, CloudException {
		return support.getVolume(volumeId);
	}

	@Override
	public AsyncResult<Iterable<VolumeProduct>> listVolumeProducts() throws InternalException, CloudException {
		return support.listVolumeProducts();
	}

	@Override
	public AsyncResult<Iterable<ResourceStatus>> listVolumeStatus() throws InternalException, CloudException {
		return support.listVolumeStatus();
	}

	@Override
	public AsyncResult<Iterable<Volume>> listVolumes() throws InternalException, CloudException {
		return support.listVolumes();
	}

	@Override
	public AsyncResult<Iterable<Volume>> listVolumes(VolumeFilterOptions options) throws InternalException, CloudException {
		return support.listVolumes(options);
	}

	@Override
	public boolean isSubscribed() throws CloudException, InternalException {
		return support.isSubscribed();
	}

	@Override
	public AsyncResult<Void> remove(String volumeId) throws InternalException, CloudException {
		return support.remove(volumeId);
	}

	@Override
	public AsyncResult<Void> removeTags(String volumeId, Tag... tags) throws CloudException, InternalException {
		return support.removeTags(volumeId, tags);
	}

	@Override
	public AsyncResult<Void> removeTags(String[] volumeIds, Tag... tags) throws CloudException, InternalException {
		return support.removeTags(volumeIds, tags);
	}

	@Override
	public AsyncResult<Void> updateTags(String volumeId, Tag... tags) throws CloudException, InternalException {
		return support.updateTags(volumeId, tags);
	}

	@Override
	public AsyncResult<Void> updateTags(String[] volumeIds, Tag... tags) throws CloudException, InternalException {
		return support.updateTags(volumeIds, tags);
	}

	@Override
	public AsyncResult<Void> setTags(String volumeId, Tag... tags) throws CloudException, InternalException {
		return support.setTags(volumeId, tags);
	}

	@Override
	public AsyncResult<Void> setTags(String[] volumeIds, Tag... tags) throws CloudException, InternalException {
		return support.setTags(volumeIds, tags);
	}

	@Override
	public VolumeSupport getSupport() {
		return support.getSupport();
	}

}
