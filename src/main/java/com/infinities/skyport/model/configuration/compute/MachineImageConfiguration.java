package com.infinities.skyport.model.configuration.compute;

import java.io.Serializable;

import com.infinities.skyport.model.FunctionConfiguration;
import com.infinities.skyport.model.Time;

public class MachineImageConfiguration implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final Time DEFAULT_MACHINEIMAGE_DELAY = new Time();
	static {
		DEFAULT_MACHINEIMAGE_DELAY.setNumber(300);
	}

	private FunctionConfiguration addImageShare = new FunctionConfiguration();

	private FunctionConfiguration addPublicShare = new FunctionConfiguration();

	private FunctionConfiguration bundleVirtualMachine = new FunctionConfiguration();

	private FunctionConfiguration bundleVirtualMachineAsync = new FunctionConfiguration();

	private FunctionConfiguration captureImage = new FunctionConfiguration();

	private FunctionConfiguration captureImageAsync = new FunctionConfiguration();

	private FunctionConfiguration copyImage = new FunctionConfiguration();

	private FunctionConfiguration getImage = new FunctionConfiguration();

	private FunctionConfiguration getMachineImage = new FunctionConfiguration();

	private FunctionConfiguration hasPublicLibrary = new FunctionConfiguration();

	private FunctionConfiguration imageVirtualMachine = new FunctionConfiguration();

	private FunctionConfiguration isImageSharedWithPublic = new FunctionConfiguration();

	private FunctionConfiguration listImageStatus = new FunctionConfiguration();

	private FunctionConfiguration listImages = new FunctionConfiguration();

	private FunctionConfiguration listMachineImages = new FunctionConfiguration();

	private FunctionConfiguration listMachineImagesOwnedBy = new FunctionConfiguration();

	private FunctionConfiguration listShares = new FunctionConfiguration();

	private FunctionConfiguration registerImageBundle = new FunctionConfiguration();

	private FunctionConfiguration remove = new FunctionConfiguration();

	private FunctionConfiguration removeAllImageShares = new FunctionConfiguration();

	private FunctionConfiguration removeImageShare = new FunctionConfiguration();

	private FunctionConfiguration removePublicShare = new FunctionConfiguration();

	private FunctionConfiguration searchImages = new FunctionConfiguration();

	private FunctionConfiguration searchPublicImages = new FunctionConfiguration();

	private FunctionConfiguration shareMachineImage = new FunctionConfiguration();

	private FunctionConfiguration supportsCustomImages = new FunctionConfiguration();

	private FunctionConfiguration supportsImageSharing = new FunctionConfiguration();

	private FunctionConfiguration updateTags = new FunctionConfiguration();

	private FunctionConfiguration removeTags = new FunctionConfiguration();

	private FunctionConfiguration setTags = new FunctionConfiguration();


	public MachineImageConfiguration() {
		listImages.setDelay(DEFAULT_MACHINEIMAGE_DELAY);
	}

	public FunctionConfiguration getAddImageShare() {
		return addImageShare;
	}

	public void setAddImageShare(FunctionConfiguration addImageShare) {
		this.addImageShare = addImageShare;
	}

	public FunctionConfiguration getAddPublicShare() {
		return addPublicShare;
	}

	public void setAddPublicShare(FunctionConfiguration addPublicShare) {
		this.addPublicShare = addPublicShare;
	}

	public FunctionConfiguration getBundleVirtualMachine() {
		return bundleVirtualMachine;
	}

	public void setBundleVirtualMachine(FunctionConfiguration bundleVirtualMachine) {
		this.bundleVirtualMachine = bundleVirtualMachine;
	}

	public FunctionConfiguration getBundleVirtualMachineAsync() {
		return bundleVirtualMachineAsync;
	}

	public void setBundleVirtualMachineAsync(FunctionConfiguration bundleVirtualMachineAsync) {
		this.bundleVirtualMachineAsync = bundleVirtualMachineAsync;
	}

	public FunctionConfiguration getCaptureImage() {
		return captureImage;
	}

	public void setCaptureImage(FunctionConfiguration captureImage) {
		this.captureImage = captureImage;
	}

	public FunctionConfiguration getCaptureImageAsync() {
		return captureImageAsync;
	}

	public void setCaptureImageAsync(FunctionConfiguration captureImageAsync) {
		this.captureImageAsync = captureImageAsync;
	}

	public FunctionConfiguration getCopyImage() {
		return copyImage;
	}

	public void setCopyImage(FunctionConfiguration copyImage) {
		this.copyImage = copyImage;
	}

	public FunctionConfiguration getGetImage() {
		return getImage;
	}

	public void setGetImage(FunctionConfiguration getImage) {
		this.getImage = getImage;
	}

	public FunctionConfiguration getGetMachineImage() {
		return getMachineImage;
	}

	public void setGetMachineImage(FunctionConfiguration getMachineImage) {
		this.getMachineImage = getMachineImage;
	}

	public FunctionConfiguration getHasPublicLibrary() {
		return hasPublicLibrary;
	}

	public void setHasPublicLibrary(FunctionConfiguration hasPublicLibrary) {
		this.hasPublicLibrary = hasPublicLibrary;
	}

	public FunctionConfiguration getImageVirtualMachine() {
		return imageVirtualMachine;
	}

	public void setImageVirtualMachine(FunctionConfiguration imageVirtualMachine) {
		this.imageVirtualMachine = imageVirtualMachine;
	}

	public FunctionConfiguration getIsImageSharedWithPublic() {
		return isImageSharedWithPublic;
	}

	public void setIsImageSharedWithPublic(FunctionConfiguration isImageSharedWithPublic) {
		this.isImageSharedWithPublic = isImageSharedWithPublic;
	}

	public FunctionConfiguration getListImageStatus() {
		return listImageStatus;
	}

	public void setListImageStatus(FunctionConfiguration listImageStatus) {
		this.listImageStatus = listImageStatus;
	}

	public FunctionConfiguration getListImages() {
		return listImages;
	}

	public void setListImages(FunctionConfiguration listImages) {
		this.listImages = listImages;
	}

	public FunctionConfiguration getListMachineImages() {
		return listMachineImages;
	}

	public void setListMachineImages(FunctionConfiguration listMachineImages) {
		this.listMachineImages = listMachineImages;
	}

	public FunctionConfiguration getListMachineImagesOwnedBy() {
		return listMachineImagesOwnedBy;
	}

	public void setListMachineImagesOwnedBy(FunctionConfiguration listMachineImagesOwnedBy) {
		this.listMachineImagesOwnedBy = listMachineImagesOwnedBy;
	}

	public FunctionConfiguration getListShares() {
		return listShares;
	}

	public void setListShares(FunctionConfiguration listShares) {
		this.listShares = listShares;
	}

	public FunctionConfiguration getRegisterImageBundle() {
		return registerImageBundle;
	}

	public void setRegisterImageBundle(FunctionConfiguration registerImageBundle) {
		this.registerImageBundle = registerImageBundle;
	}

	public FunctionConfiguration getRemove() {
		return remove;
	}

	public void setRemove(FunctionConfiguration remove) {
		this.remove = remove;
	}

	public FunctionConfiguration getRemoveAllImageShares() {
		return removeAllImageShares;
	}

	public void setRemoveAllImageShares(FunctionConfiguration removeAllImageShares) {
		this.removeAllImageShares = removeAllImageShares;
	}

	public FunctionConfiguration getRemoveImageShare() {
		return removeImageShare;
	}

	public void setRemoveImageShare(FunctionConfiguration removeImageShare) {
		this.removeImageShare = removeImageShare;
	}

	public FunctionConfiguration getRemovePublicShare() {
		return removePublicShare;
	}

	public void setRemovePublicShare(FunctionConfiguration removePublicShare) {
		this.removePublicShare = removePublicShare;
	}

	public FunctionConfiguration getSearchImages() {
		return searchImages;
	}

	public void setSearchImages(FunctionConfiguration searchImages) {
		this.searchImages = searchImages;
	}

	public FunctionConfiguration getSearchPublicImages() {
		return searchPublicImages;
	}

	public void setSearchPublicImages(FunctionConfiguration searchPublicImages) {
		this.searchPublicImages = searchPublicImages;
	}

	public FunctionConfiguration getShareMachineImage() {
		return shareMachineImage;
	}

	public void setShareMachineImage(FunctionConfiguration shareMachineImage) {
		this.shareMachineImage = shareMachineImage;
	}

	public FunctionConfiguration getSupportsCustomImages() {
		return supportsCustomImages;
	}

	public void setSupportsCustomImages(FunctionConfiguration supportsCustomImages) {
		this.supportsCustomImages = supportsCustomImages;
	}

	public FunctionConfiguration getSupportsImageSharing() {
		return supportsImageSharing;
	}

	public void setSupportsImageSharing(FunctionConfiguration supportsImageSharing) {
		this.supportsImageSharing = supportsImageSharing;
	}

	public FunctionConfiguration getUpdateTags() {
		return updateTags;
	}

	public void setUpdateTags(FunctionConfiguration updateTags) {
		this.updateTags = updateTags;
	}

	public FunctionConfiguration getRemoveTags() {
		return removeTags;
	}

	public void setRemoveTags(FunctionConfiguration removeTags) {
		this.removeTags = removeTags;
	}

	public FunctionConfiguration getSetTags() {
		return setTags;
	}

	public void setSetTags(FunctionConfiguration setTags) {
		this.setTags = setTags;
	}

	@Override
	public MachineImageConfiguration clone() {
		MachineImageConfiguration clone = new MachineImageConfiguration();
		clone.addImageShare = addImageShare.clone();
		clone.addPublicShare = addPublicShare.clone();
		clone.bundleVirtualMachine = bundleVirtualMachine.clone();
		clone.bundleVirtualMachineAsync = bundleVirtualMachineAsync.clone();
		clone.captureImage = captureImage.clone();
		clone.captureImageAsync = captureImageAsync.clone();
		clone.copyImage = copyImage.clone();
		clone.getImage = getImage.clone();
		clone.getMachineImage = getMachineImage.clone();
		clone.hasPublicLibrary = hasPublicLibrary.clone();
		clone.imageVirtualMachine = imageVirtualMachine.clone();
		clone.isImageSharedWithPublic = isImageSharedWithPublic.clone();
		clone.listImageStatus = listImageStatus.clone();
		clone.listImages = listImages.clone();
		clone.listMachineImages = listMachineImages.clone();
		clone.listMachineImagesOwnedBy = listMachineImagesOwnedBy.clone();
		clone.listShares = listShares.clone();
		clone.registerImageBundle = registerImageBundle.clone();
		clone.remove = remove.clone();
		clone.removeAllImageShares = removeAllImageShares.clone();
		clone.removeImageShare = removeImageShare.clone();
		clone.removePublicShare = removePublicShare.clone();
		clone.searchImages = searchImages.clone();
		clone.searchPublicImages = searchPublicImages.clone();
		clone.shareMachineImage = shareMachineImage.clone();
		clone.supportsCustomImages = supportsCustomImages.clone();
		clone.supportsImageSharing = supportsImageSharing.clone();
		clone.updateTags = updateTags.clone();
		clone.removeTags = removeTags.clone();
		clone.setTags = setTags.clone();
		return clone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addImageShare == null) ? 0 : addImageShare.hashCode());
		result = prime * result + ((addPublicShare == null) ? 0 : addPublicShare.hashCode());
		result = prime * result + ((bundleVirtualMachine == null) ? 0 : bundleVirtualMachine.hashCode());
		result = prime * result + ((bundleVirtualMachineAsync == null) ? 0 : bundleVirtualMachineAsync.hashCode());
		result = prime * result + ((captureImage == null) ? 0 : captureImage.hashCode());
		result = prime * result + ((captureImageAsync == null) ? 0 : captureImageAsync.hashCode());
		result = prime * result + ((copyImage == null) ? 0 : copyImage.hashCode());
		result = prime * result + ((getImage == null) ? 0 : getImage.hashCode());
		result = prime * result + ((getMachineImage == null) ? 0 : getMachineImage.hashCode());
		result = prime * result + ((hasPublicLibrary == null) ? 0 : hasPublicLibrary.hashCode());
		result = prime * result + ((imageVirtualMachine == null) ? 0 : imageVirtualMachine.hashCode());
		result = prime * result + ((isImageSharedWithPublic == null) ? 0 : isImageSharedWithPublic.hashCode());
		result = prime * result + ((listImageStatus == null) ? 0 : listImageStatus.hashCode());
		result = prime * result + ((listImages == null) ? 0 : listImages.hashCode());
		result = prime * result + ((listMachineImages == null) ? 0 : listMachineImages.hashCode());
		result = prime * result + ((listMachineImagesOwnedBy == null) ? 0 : listMachineImagesOwnedBy.hashCode());
		result = prime * result + ((listShares == null) ? 0 : listShares.hashCode());
		result = prime * result + ((registerImageBundle == null) ? 0 : registerImageBundle.hashCode());
		result = prime * result + ((remove == null) ? 0 : remove.hashCode());
		result = prime * result + ((removeAllImageShares == null) ? 0 : removeAllImageShares.hashCode());
		result = prime * result + ((removeImageShare == null) ? 0 : removeImageShare.hashCode());
		result = prime * result + ((removePublicShare == null) ? 0 : removePublicShare.hashCode());
		result = prime * result + ((searchImages == null) ? 0 : searchImages.hashCode());
		result = prime * result + ((searchPublicImages == null) ? 0 : searchPublicImages.hashCode());
		result = prime * result + ((shareMachineImage == null) ? 0 : shareMachineImage.hashCode());
		result = prime * result + ((supportsCustomImages == null) ? 0 : supportsCustomImages.hashCode());
		result = prime * result + ((supportsImageSharing == null) ? 0 : supportsImageSharing.hashCode());
		result = prime * result + ((removeTags == null) ? 0 : removeTags.hashCode());
		result = prime * result + ((setTags == null) ? 0 : setTags.hashCode());
		result = prime * result + ((updateTags == null) ? 0 : updateTags.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MachineImageConfiguration other = (MachineImageConfiguration) obj;
		if (addImageShare == null) {
			if (other.addImageShare != null)
				return false;
		} else if (!addImageShare.equals(other.addImageShare))
			return false;
		if (addPublicShare == null) {
			if (other.addPublicShare != null)
				return false;
		} else if (!addPublicShare.equals(other.addPublicShare))
			return false;
		if (bundleVirtualMachine == null) {
			if (other.bundleVirtualMachine != null)
				return false;
		} else if (!bundleVirtualMachine.equals(other.bundleVirtualMachine))
			return false;
		if (bundleVirtualMachineAsync == null) {
			if (other.bundleVirtualMachineAsync != null)
				return false;
		} else if (!bundleVirtualMachineAsync.equals(other.bundleVirtualMachineAsync))
			return false;
		if (captureImage == null) {
			if (other.captureImage != null)
				return false;
		} else if (!captureImage.equals(other.captureImage))
			return false;
		if (captureImageAsync == null) {
			if (other.captureImageAsync != null)
				return false;
		} else if (!captureImageAsync.equals(other.captureImageAsync))
			return false;
		if (copyImage == null) {
			if (other.copyImage != null)
				return false;
		} else if (!copyImage.equals(other.copyImage))
			return false;
		if (getImage == null) {
			if (other.getImage != null)
				return false;
		} else if (!getImage.equals(other.getImage))
			return false;
		if (getMachineImage == null) {
			if (other.getMachineImage != null)
				return false;
		} else if (!getMachineImage.equals(other.getMachineImage))
			return false;
		if (hasPublicLibrary == null) {
			if (other.hasPublicLibrary != null)
				return false;
		} else if (!hasPublicLibrary.equals(other.hasPublicLibrary))
			return false;
		if (imageVirtualMachine == null) {
			if (other.imageVirtualMachine != null)
				return false;
		} else if (!imageVirtualMachine.equals(other.imageVirtualMachine))
			return false;
		if (isImageSharedWithPublic == null) {
			if (other.isImageSharedWithPublic != null)
				return false;
		} else if (!isImageSharedWithPublic.equals(other.isImageSharedWithPublic))
			return false;
		if (listImageStatus == null) {
			if (other.listImageStatus != null)
				return false;
		} else if (!listImageStatus.equals(other.listImageStatus))
			return false;
		if (listImages == null) {
			if (other.listImages != null)
				return false;
		} else if (!listImages.equals(other.listImages))
			return false;
		if (listMachineImages == null) {
			if (other.listMachineImages != null)
				return false;
		} else if (!listMachineImages.equals(other.listMachineImages))
			return false;
		if (listMachineImagesOwnedBy == null) {
			if (other.listMachineImagesOwnedBy != null)
				return false;
		} else if (!listMachineImagesOwnedBy.equals(other.listMachineImagesOwnedBy))
			return false;
		if (listShares == null) {
			if (other.listShares != null)
				return false;
		} else if (!listShares.equals(other.listShares))
			return false;
		if (registerImageBundle == null) {
			if (other.registerImageBundle != null)
				return false;
		} else if (!registerImageBundle.equals(other.registerImageBundle))
			return false;
		if (remove == null) {
			if (other.remove != null)
				return false;
		} else if (!remove.equals(other.remove))
			return false;
		if (removeAllImageShares == null) {
			if (other.removeAllImageShares != null)
				return false;
		} else if (!removeAllImageShares.equals(other.removeAllImageShares))
			return false;
		if (removeImageShare == null) {
			if (other.removeImageShare != null)
				return false;
		} else if (!removeImageShare.equals(other.removeImageShare))
			return false;
		if (removePublicShare == null) {
			if (other.removePublicShare != null)
				return false;
		} else if (!removePublicShare.equals(other.removePublicShare))
			return false;
		if (removeTags == null) {
			if (other.removeTags != null)
				return false;
		} else if (!removeTags.equals(other.removeTags))
			return false;
		if (searchImages == null) {
			if (other.searchImages != null)
				return false;
		} else if (!searchImages.equals(other.searchImages))
			return false;
		if (searchPublicImages == null) {
			if (other.searchPublicImages != null)
				return false;
		} else if (!searchPublicImages.equals(other.searchPublicImages))
			return false;
		if (shareMachineImage == null) {
			if (other.shareMachineImage != null)
				return false;
		} else if (!shareMachineImage.equals(other.shareMachineImage))
			return false;
		if (supportsCustomImages == null) {
			if (other.supportsCustomImages != null)
				return false;
		} else if (!supportsCustomImages.equals(other.supportsCustomImages))
			return false;
		if (supportsImageSharing == null) {
			if (other.supportsImageSharing != null)
				return false;
		} else if (!supportsImageSharing.equals(other.supportsImageSharing))
			return false;
		if (setTags == null) {
			if (other.setTags != null)
				return false;
		} else if (!setTags.equals(other.setTags))
			return false;
		if (updateTags == null) {
			if (other.updateTags != null)
				return false;
		} else if (!updateTags.equals(other.updateTags))
			return false;
		return true;
	}

}
