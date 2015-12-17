package com.infinities.skyport.proxy;

import java.io.Serializable;
import java.util.Map;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.xml.bind.annotation.XmlTransient;

import org.dasein.cloud.VisibleScope;
import org.dasein.cloud.compute.Architecture;
import org.dasein.cloud.compute.ImageClass;
import org.dasein.cloud.compute.MachineImage;
import org.dasein.cloud.compute.MachineImageFormat;
import org.dasein.cloud.compute.MachineImageState;
import org.dasein.cloud.compute.MachineImageType;
import org.dasein.cloud.compute.MachineImageVolume;
import org.dasein.cloud.compute.Platform;

public class MachineImageProxy extends MachineImage implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlTransient
	private volatile MachineImage machineImage;
	private String configName;
	private String configId;


	@SuppressWarnings("deprecation")
	public MachineImageProxy(MachineImage machineImage, String configName, String configId) {
		super();
		this.machineImage = machineImage;
		this.configName = configName;
		this.configId = configId;
	}

	public MachineImage getMachineImage() {
		return machineImage;
	}

	public void setMachineImage(MachineImage machineImage) {
		this.machineImage = machineImage;
	}

	public String getConfigName() {
		return configName;
	}

	public void setConfigName(String configName) {
		this.configName = configName;
	}

	public String getConfigId() {
		return configId;
	}

	public void setConfigId(String configId) {
		this.configId = configId;
	}

	/**
	 * @return the architecture associated with this image
	 */
	@Override
	public @Nonnull Architecture getArchitecture() {
		return getMachineImage().getArchitecture();
	}

	/**
	 * Note: this value will return 0L for clouds that don't track creation
	 * times.
	 * 
	 * @return a Unix timestamp in milliseconds indicating when this image was
	 *         initially created
	 */
	@Override
	public @Nonnegative long getCreationTimestamp() {
		return getMachineImage().getCreationTimestamp();
	}

	/**
	 * @return the current state of the image as described by the cloud provider
	 */
	@Override
	public @Nonnull MachineImageState getCurrentState() {
		return getMachineImage().getCurrentState();
	}

	/**
	 * @return a long description describing this image
	 */
	@Override
	public @Nonnull String getDescription() {
		return getMachineImage().getDescription();
	}

	/**
	 * @return the image class of this image
	 */
	@Override
	public @Nonnull ImageClass getImageClass() {
		return getMachineImage().getImageClass();
	}

	/**
	 * @return the kernel image associated with this machine image (this is a
	 *         machine image if it is associated with a kernel image)
	 */
	@Override
	public @Nullable String getKernelImageId() {
		return getMachineImage().getKernelImageId();
	}

	/**
	 * @return the name of the image
	 */
	@Override
	public @Nonnull String getName() {
		return getMachineImage().getName();
	}

	/**
	 * @return the platform embedded in the image
	 */
	@Override
	public @Nonnull Platform getPlatform() {
		return getMachineImage().getPlatform();
	}

	/**
	 * In most clouds, images/templates are not constrained at the data
	 * center/availability zone level. In those cases (for example, AWS), this
	 * value will always be <code>null</code>. If, however, the images/templates
	 * you use can only be launched into a single data center/availability zone,
	 * this will return the ID of that data center/availability zone.
	 * 
	 * @return the data center into which you can launch VMs (<code>null</code>
	 *         means you can launch into any data center)
	 */
	@Override
	public @Nullable String getProviderDataCenterId() {
		return getMachineImage().getProviderDataCenterId();
	}

	/**
	 * @return the unique ID for this image as it is identified with the cloud
	 *         provider
	 */
	@Override
	public @Nonnull String getProviderMachineImageId() {
		return getMachineImage().getProviderMachineImageId();
	}

	/**
	 * @return the account number for the account that owns this image
	 */
	@Override
	public @Nonnull String getProviderOwnerId() {
		return getMachineImage().getProviderOwnerId();
	}

	/**
	 * @return the provider ID of the region to which this image is constrained
	 */
	@Override
	public @Nonnull String getProviderRegionId() {
		return getMachineImage().getProviderRegionId();
	}

	/**
	 * @return a string indicating the software embedded in this image (an empty
	 *         string indicates no specific software)
	 */
	@Override
	public @Nonnull String getSoftware() {
		return getMachineImage().getSoftware();
	}

	/**
	 * @return for object store-backed images, the format in which the object(s)
	 *         are stored
	 */
	@Override
	public @Nullable MachineImageFormat getStorageFormat() {
		return getMachineImage().getStorageFormat();
	}

	/**
	 * Fetches the value of the specified tag key.
	 * 
	 * @param tag
	 *            the key of the tag to be fetched
	 * @return the value associated with the specified key, if any
	 */
	@Override
	public @Nullable Object getTag(@Nonnull String tag) {
		return getMachineImage().getTag(tag);
	}

	@Override
	public @Nonnull Map<String, String> getTags() {
		return getMachineImage().getTags();
	}

	/**
	 * There are two types of images in Dasein Cloud: storage images and volume
	 * images. A storage image is one that is accessible via objects in object
	 * storage. You can directly download and optionally upload the image into
	 * this object storage. Volume images, on the other hand, are sitting on
	 * block storage devices in the cloud.
	 * 
	 * @return the type of image represented by this image
	 */
	@Override
	public @Nonnull MachineImageType getType() {
		return getMachineImage().getType();
	}

	/**
	 * @return visible scope of the image
	 */
	@Override
	public @Nullable VisibleScope getVisibleScope() {
		return getMachineImage().getVisibleScope();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((configId == null) ? 0 : configId.hashCode());
		result = prime * result + ((configName == null) ? 0 : configName.hashCode());
		result = prime * result + ((machineImage == null) ? 0 : machineImage.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		MachineImageProxy other = (MachineImageProxy) obj;
		if (configId == null) {
			if (other.configId != null)
				return false;
		} else if (!configId.equals(other.configId))
			return false;
		if (configName == null) {
			if (other.configName != null)
				return false;
		} else if (!configName.equals(other.configName))
			return false;
		if (machineImage == null) {
			if (other.machineImage != null)
				return false;
		} else if (!machineImage.equals(other.machineImage))
			return false;
		return true;
	}

	/**
	 * @return volumes of the image
	 */
	@Override
	public @Nullable Iterable<MachineImageVolume> getVolumes() {
		return getMachineImage().getVolumes();
	}

	@Override
	public String toString() {
		return getMachineImage().toString();
	}

	/**
	 * Indicates whether the image is available to public
	 * 
	 * @return true if available to public
	 */
	@Override
	public boolean isPublic() {
		return getMachineImage().isPublic();
	}

	/**
	 * Cloud-specific metadata that drivers may or may not use for matching
	 * products with machine images. This is considered driver-internal.
	 * 
	 * @return product metadata
	 */
	@Override
	public @Nonnull Map<String, String> getProviderMetadata() {
		return getMachineImage().getProviderMetadata();
	}

	@Override
	public long getMinimumDiskSizeGb() {
		return getMachineImage().getMinimumDiskSizeGb();
	}
}
