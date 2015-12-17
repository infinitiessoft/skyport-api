package com.infinities.skyport.model.compute;

import java.io.Serializable;

import org.dasein.cloud.CloudException;
import org.dasein.cloud.InternalException;
import org.dasein.cloud.ResourceStatus;
import org.dasein.cloud.Tag;
import org.dasein.cloud.compute.Snapshot;
import org.dasein.cloud.compute.SnapshotCapabilities;
import org.dasein.cloud.compute.SnapshotCreateOptions;
import org.dasein.cloud.compute.SnapshotFilterOptions;
import org.dasein.cloud.compute.SnapshotSupport;
import org.dasein.cloud.identity.ServiceAction;

import com.infinities.skyport.async.AsyncResult;
import com.infinities.skyport.async.service.compute.AsyncSnapshotSupport;

public class SnapshotSupportProxy implements AsyncSnapshotSupport, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final AsyncSnapshotSupport support;


	public SnapshotSupportProxy(AsyncSnapshotSupport support) {
		this.support = support;
	}

	@Override
	public String[] mapServiceAction(ServiceAction action) {
		return support.mapServiceAction(action);
	}

	@Override
	public AsyncResult<Void> addSnapshotShare(String providerSnapshotId, String accountNumber) throws CloudException,
			InternalException {
		return support.addSnapshotShare(providerSnapshotId, accountNumber);
	}

	@Override
	public AsyncResult<Void> addPublicShare(String providerSnapshotId) throws CloudException, InternalException {
		return support.addPublicShare(providerSnapshotId);
	}

	@Override
	public AsyncResult<String> createSnapshot(SnapshotCreateOptions options) throws CloudException, InternalException {
		return support.createSnapshot(options);
	}

	@Override
	public SnapshotCapabilities getCapabilities() throws CloudException, InternalException {
		return support.getCapabilities();
	}

	@Override
	public AsyncResult<Snapshot> getSnapshot(String snapshotId) throws InternalException, CloudException {
		return support.getSnapshot(snapshotId);
	}

	@Override
	public AsyncResult<Boolean> isPublic(String snapshotId) throws InternalException, CloudException {
		return support.isPublic(snapshotId);
	}

	@Override
	public boolean isSubscribed() throws InternalException, CloudException {
		return support.isSubscribed();
	}

	@Override
	public AsyncResult<Iterable<String>> listShares(String snapshotId) throws InternalException, CloudException {
		return support.listShares(snapshotId);
	}

	@Override
	public AsyncResult<Iterable<ResourceStatus>> listSnapshotStatus() throws InternalException, CloudException {
		return support.listSnapshotStatus();
	}

	@Override
	public AsyncResult<Iterable<Snapshot>> listSnapshots() throws InternalException, CloudException {
		return support.listSnapshots();
	}

	@Override
	public AsyncResult<Iterable<Snapshot>> listSnapshots(SnapshotFilterOptions options) throws InternalException,
			CloudException {
		return support.listSnapshots(options);
	}

	@Override
	public AsyncResult<Void> remove(String snapshotId) throws InternalException, CloudException {
		return support.remove(snapshotId);
	}

	@Override
	public AsyncResult<Void> removeAllSnapshotShares(String providerSnapshotId) throws CloudException, InternalException {
		return support.removeAllSnapshotShares(providerSnapshotId);
	}

	@Override
	public AsyncResult<Void> removeSnapshotShare(String providerSnapshotId, String accountNumber) throws CloudException,
			InternalException {
		return support.removeSnapshotShare(providerSnapshotId, accountNumber);
	}

	@Override
	public AsyncResult<Void> removePublicShare(String providerSnapshotId) throws CloudException, InternalException {
		return support.removePublicShare(providerSnapshotId);
	}

	@Override
	public AsyncResult<Void> removeTags(String snapshotId, Tag... tags) throws CloudException, InternalException {
		return support.removeTags(snapshotId, tags);
	}

	@Override
	public AsyncResult<Void> removeTags(String[] snapshotIds, Tag... tags) throws CloudException, InternalException {
		return support.removeTags(snapshotIds, tags);
	}

	@Override
	public AsyncResult<Iterable<Snapshot>> searchSnapshots(SnapshotFilterOptions options) throws InternalException,
			CloudException {
		return support.searchSnapshots(options);
	}

	@Override
	public AsyncResult<Void> updateTags(String snapshotId, Tag... tags) throws CloudException, InternalException {
		return support.updateTags(snapshotId, tags);
	}

	@Override
	public AsyncResult<Void> updateTags(String[] snapshotIds, Tag... tags) throws CloudException, InternalException {
		return support.updateTags(snapshotIds, tags);
	}

	@Override
	public AsyncResult<Void> setTags(String snapshotId, Tag... tags) throws CloudException, InternalException {
		return support.setTags(snapshotId, tags);
	}

	@Override
	public AsyncResult<Void> setTags(String[] snapshotIds, Tag... tags) throws CloudException, InternalException {
		return support.setTags(snapshotIds, tags);
	}

	@SuppressWarnings("deprecation")
	@Override
	public AsyncResult<String> create(String ofVolume, String description) throws InternalException, CloudException {
		return support.create(ofVolume, description);
	}

	@SuppressWarnings("deprecation")
	@Override
	public AsyncResult<Void> shareSnapshot(String snapshotId, String withAccountId, boolean affirmative)
			throws InternalException, CloudException {
		return support.shareSnapshot(snapshotId, withAccountId, affirmative);
	}

	@SuppressWarnings("deprecation")
	@Override
	public AsyncResult<Snapshot> snapshot(String volumeId, String name, String description, Tag... tags)
			throws InternalException, CloudException {
		return support.snapshot(volumeId, name, description, tags);
	}

	@Override
	public SnapshotSupport getSupport() {
		return support.getSupport();
	}

}
