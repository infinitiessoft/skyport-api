package com.infinities.skyport.proxy.storage;

import java.io.Serializable;
import java.util.Map;

import org.dasein.cloud.storage.Blob;
import org.dasein.util.uom.storage.Storage;


public class BlobProxy implements Serializable {

	private static final long serialVersionUID = 1L;
	private String configName;
	private String configId;
	private long                                      creationTimestamp;
    private String                                    bucketName;
    private String                                    location;
    private String                                    objectName;
    private String                                    providerRegionId;
    private Storage<org.dasein.util.uom.storage.Byte> size;
    private Map<String, String>                       tags;

	public BlobProxy(Blob blob, String configName, String configId) {
		this.configId = configId;
		this.configName = configName;
		this.creationTimestamp = blob.getCreationTimestamp();
		this.bucketName = blob.getBucketName();
		this.location = blob.getLocation();
		this.objectName = blob.getObjectName();
		this.providerRegionId = blob.getProviderRegionId();
		this.size = blob.getSize();
		this.tags = blob.getTags();
	}
	
	public Blob getBlob() {
		return Blob.getInstance(providerRegionId, location, bucketName, objectName, creationTimestamp, size);
	}

	public String getConfigName() {
		return this.configName;
	}

	public void setConfigName(String configName) {
		this.configName = configName;
	}

	public String getConfigId() {
		return this.configId;
	}

	public void setConfigId(String configId) {
		this.configId = configId;
	}

	public long getCreationTimestamp() {
		return this.creationTimestamp;
	}

	public void setCreationTimestamp(long creationTimestamp) {
		this.creationTimestamp = creationTimestamp;
	}

	public String getBucketName() {
		return this.bucketName;
	}

	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getObjectName() {
		return this.objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	public String getProviderRegionId() {
		return this.providerRegionId;
	}

	public void setProviderRegionId(String providerRegionId) {
		this.providerRegionId = providerRegionId;
	}

	public Storage<org.dasein.util.uom.storage.Byte> getSize() {
		return this.size;
	}

	public void setSize(Storage<org.dasein.util.uom.storage.Byte> size) {
		this.size = size;
	}

	public Map<String, String> getTags() {
		return this.tags;
	}

	public void setTags(Map<String, String> tags) {
		this.tags = tags;
	}

}
