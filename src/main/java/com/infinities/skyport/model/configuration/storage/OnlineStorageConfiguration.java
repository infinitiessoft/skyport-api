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
package com.infinities.skyport.model.configuration.storage;

import java.io.Serializable;

import com.infinities.skyport.model.FunctionConfiguration;

public class OnlineStorageConfiguration implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	private FunctionConfiguration clearBucket = new FunctionConfiguration();
	private FunctionConfiguration createBucket = new FunctionConfiguration();
	private FunctionConfiguration download = new FunctionConfiguration();
	private FunctionConfiguration exists = new FunctionConfiguration();
	private FunctionConfiguration getBucket = new FunctionConfiguration();
	private FunctionConfiguration getObject = new FunctionConfiguration();
	private FunctionConfiguration getSignedObjectUrl = new FunctionConfiguration();
	private FunctionConfiguration getObjectSize = new FunctionConfiguration();
	private FunctionConfiguration isPublic = new FunctionConfiguration();
	private FunctionConfiguration list = new FunctionConfiguration();
	private FunctionConfiguration makePublic = new FunctionConfiguration();
	private FunctionConfiguration move = new FunctionConfiguration();
	private FunctionConfiguration removeBucket = new FunctionConfiguration();
	private FunctionConfiguration removeObject = new FunctionConfiguration();
	private FunctionConfiguration renameBucket = new FunctionConfiguration();
	private FunctionConfiguration renameObject = new FunctionConfiguration();
	private FunctionConfiguration upload = new FunctionConfiguration();
	private FunctionConfiguration updateTags = new FunctionConfiguration();
	private FunctionConfiguration removeTags = new FunctionConfiguration();
	private FunctionConfiguration setTags = new FunctionConfiguration();


	public FunctionConfiguration getClearBucket() {
		return clearBucket;
	}

	public void setClearBucket(FunctionConfiguration clearBucket) {
		this.clearBucket = clearBucket;
	}

	public FunctionConfiguration getCreateBucket() {
		return createBucket;
	}

	public void setCreateBucket(FunctionConfiguration createBucket) {
		this.createBucket = createBucket;
	}

	public FunctionConfiguration getDownload() {
		return download;
	}

	public void setDownload(FunctionConfiguration download) {
		this.download = download;
	}

	public FunctionConfiguration getExists() {
		return exists;
	}

	public void setExists(FunctionConfiguration exists) {
		this.exists = exists;
	}

	public FunctionConfiguration getGetBucket() {
		return getBucket;
	}

	public void setGetBucket(FunctionConfiguration getBucket) {
		this.getBucket = getBucket;
	}

	public FunctionConfiguration getGetObject() {
		return getObject;
	}

	public void setGetObject(FunctionConfiguration getObject) {
		this.getObject = getObject;
	}

	public FunctionConfiguration getGetSignedObjectUrl() {
		return getSignedObjectUrl;
	}

	public void setGetSignedObjectUrl(FunctionConfiguration getSignedObjectUrl) {
		this.getSignedObjectUrl = getSignedObjectUrl;
	}

	public FunctionConfiguration getGetObjectSize() {
		return getObjectSize;
	}

	public void setGetObjectSize(FunctionConfiguration getObjectSize) {
		this.getObjectSize = getObjectSize;
	}

	public FunctionConfiguration getIsPublic() {
		return isPublic;
	}

	public void setIsPublic(FunctionConfiguration isPublic) {
		this.isPublic = isPublic;
	}

	public FunctionConfiguration getList() {
		return list;
	}

	public void setList(FunctionConfiguration list) {
		this.list = list;
	}

	public FunctionConfiguration getMakePublic() {
		return makePublic;
	}

	public void setMakePublic(FunctionConfiguration makePublic) {
		this.makePublic = makePublic;
	}

	public FunctionConfiguration getMove() {
		return move;
	}

	public void setMove(FunctionConfiguration move) {
		this.move = move;
	}

	public FunctionConfiguration getRemoveBucket() {
		return removeBucket;
	}

	public void setRemoveBucket(FunctionConfiguration removeBucket) {
		this.removeBucket = removeBucket;
	}

	public FunctionConfiguration getRemoveObject() {
		return removeObject;
	}

	public void setRemoveObject(FunctionConfiguration removeObject) {
		this.removeObject = removeObject;
	}

	public FunctionConfiguration getRenameBucket() {
		return renameBucket;
	}

	public void setRenameBucket(FunctionConfiguration renameBucket) {
		this.renameBucket = renameBucket;
	}

	public FunctionConfiguration getRenameObject() {
		return renameObject;
	}

	public void setRenameObject(FunctionConfiguration renameObject) {
		this.renameObject = renameObject;
	}

	public FunctionConfiguration getUpload() {
		return upload;
	}

	public void setUpload(FunctionConfiguration upload) {
		this.upload = upload;
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
	public OnlineStorageConfiguration clone() {
		try {
			super.clone();
		} catch (CloneNotSupportedException e) {
			// ignore
		}
		OnlineStorageConfiguration clone = new OnlineStorageConfiguration();
		clone.clearBucket = clearBucket.clone();
		clone.createBucket = createBucket.clone();
		clone.download = download.clone();
		clone.exists = exists.clone();
		clone.getBucket = getBucket.clone();
		clone.getObject = getObject.clone();
		clone.getSignedObjectUrl = getSignedObjectUrl.clone();
		clone.getObjectSize = getObjectSize.clone();
		clone.isPublic = isPublic.clone();
		clone.list = list.clone();
		clone.makePublic = makePublic.clone();
		clone.move = move.clone();
		clone.removeBucket = removeBucket.clone();
		clone.removeObject = removeObject.clone();
		clone.renameBucket = renameBucket.clone();
		clone.renameObject = renameObject.clone();
		clone.upload = upload.clone();
		clone.updateTags = updateTags.clone();
		clone.removeTags = removeTags.clone();
		clone.setTags = setTags.clone();
		return clone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clearBucket == null) ? 0 : clearBucket.hashCode());
		result = prime * result + ((createBucket == null) ? 0 : createBucket.hashCode());
		result = prime * result + ((download == null) ? 0 : download.hashCode());
		result = prime * result + ((exists == null) ? 0 : exists.hashCode());
		result = prime * result + ((getBucket == null) ? 0 : getBucket.hashCode());
		result = prime * result + ((getObject == null) ? 0 : getObject.hashCode());
		result = prime * result + ((getObjectSize == null) ? 0 : getObjectSize.hashCode());
		result = prime * result + ((getSignedObjectUrl == null) ? 0 : getSignedObjectUrl.hashCode());
		result = prime * result + ((isPublic == null) ? 0 : isPublic.hashCode());
		result = prime * result + ((list == null) ? 0 : list.hashCode());
		result = prime * result + ((makePublic == null) ? 0 : makePublic.hashCode());
		result = prime * result + ((move == null) ? 0 : move.hashCode());
		result = prime * result + ((removeBucket == null) ? 0 : removeBucket.hashCode());
		result = prime * result + ((removeObject == null) ? 0 : removeObject.hashCode());
		result = prime * result + ((removeTags == null) ? 0 : removeTags.hashCode());
		result = prime * result + ((renameBucket == null) ? 0 : renameBucket.hashCode());
		result = prime * result + ((renameObject == null) ? 0 : renameObject.hashCode());
		result = prime * result + ((setTags == null) ? 0 : setTags.hashCode());
		result = prime * result + ((updateTags == null) ? 0 : updateTags.hashCode());
		result = prime * result + ((upload == null) ? 0 : upload.hashCode());
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
		OnlineStorageConfiguration other = (OnlineStorageConfiguration) obj;
		if (clearBucket == null) {
			if (other.clearBucket != null)
				return false;
		} else if (!clearBucket.equals(other.clearBucket))
			return false;
		if (createBucket == null) {
			if (other.createBucket != null)
				return false;
		} else if (!createBucket.equals(other.createBucket))
			return false;
		if (download == null) {
			if (other.download != null)
				return false;
		} else if (!download.equals(other.download))
			return false;
		if (exists == null) {
			if (other.exists != null)
				return false;
		} else if (!exists.equals(other.exists))
			return false;
		if (getBucket == null) {
			if (other.getBucket != null)
				return false;
		} else if (!getBucket.equals(other.getBucket))
			return false;
		if (getObject == null) {
			if (other.getObject != null)
				return false;
		} else if (!getObject.equals(other.getObject))
			return false;
		if (getObjectSize == null) {
			if (other.getObjectSize != null)
				return false;
		} else if (!getObjectSize.equals(other.getObjectSize))
			return false;
		if (getSignedObjectUrl == null) {
			if (other.getSignedObjectUrl != null)
				return false;
		} else if (!getSignedObjectUrl.equals(other.getSignedObjectUrl))
			return false;
		if (isPublic == null) {
			if (other.isPublic != null)
				return false;
		} else if (!isPublic.equals(other.isPublic))
			return false;
		if (list == null) {
			if (other.list != null)
				return false;
		} else if (!list.equals(other.list))
			return false;
		if (makePublic == null) {
			if (other.makePublic != null)
				return false;
		} else if (!makePublic.equals(other.makePublic))
			return false;
		if (move == null) {
			if (other.move != null)
				return false;
		} else if (!move.equals(other.move))
			return false;
		if (removeBucket == null) {
			if (other.removeBucket != null)
				return false;
		} else if (!removeBucket.equals(other.removeBucket))
			return false;
		if (removeObject == null) {
			if (other.removeObject != null)
				return false;
		} else if (!removeObject.equals(other.removeObject))
			return false;
		if (removeTags == null) {
			if (other.removeTags != null)
				return false;
		} else if (!removeTags.equals(other.removeTags))
			return false;
		if (renameBucket == null) {
			if (other.renameBucket != null)
				return false;
		} else if (!renameBucket.equals(other.renameBucket))
			return false;
		if (renameObject == null) {
			if (other.renameObject != null)
				return false;
		} else if (!renameObject.equals(other.renameObject))
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
		if (upload == null) {
			if (other.upload != null)
				return false;
		} else if (!upload.equals(other.upload))
			return false;
		return true;
	}

}
