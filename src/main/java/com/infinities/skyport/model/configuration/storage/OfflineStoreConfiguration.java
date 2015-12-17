package com.infinities.skyport.model.configuration.storage;

import java.io.Serializable;

import com.infinities.skyport.model.FunctionConfiguration;

public class OfflineStoreConfiguration extends OnlineStorageConfiguration implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	private FunctionConfiguration listRequests = new FunctionConfiguration();
	private FunctionConfiguration getRequest = new FunctionConfiguration();
	private FunctionConfiguration createListRequest = new FunctionConfiguration();
	private FunctionConfiguration createDownloadRequest = new FunctionConfiguration();
	private FunctionConfiguration getListRequestResult = new FunctionConfiguration();
	private FunctionConfiguration getDownloadRequestResult = new FunctionConfiguration();


	public FunctionConfiguration getListRequests() {
		return listRequests;
	}

	public void setListRequests(FunctionConfiguration listRequests) {
		this.listRequests = listRequests;
	}

	public FunctionConfiguration getGetRequest() {
		return getRequest;
	}

	public void setGetRequest(FunctionConfiguration getRequest) {
		this.getRequest = getRequest;
	}

	public FunctionConfiguration getCreateListRequest() {
		return createListRequest;
	}

	public void setCreateListRequest(FunctionConfiguration createListRequest) {
		this.createListRequest = createListRequest;
	}

	public FunctionConfiguration getCreateDownloadRequest() {
		return createDownloadRequest;
	}

	public void setCreateDownloadRequest(FunctionConfiguration createDownloadRequest) {
		this.createDownloadRequest = createDownloadRequest;
	}

	public FunctionConfiguration getGetListRequestResult() {
		return getListRequestResult;
	}

	public void setGetListRequestResult(FunctionConfiguration getListRequestResult) {
		this.getListRequestResult = getListRequestResult;
	}

	public FunctionConfiguration getGetDownloadRequestResult() {
		return getDownloadRequestResult;
	}

	public void setGetDownloadRequestResult(FunctionConfiguration getDownloadRequestResult) {
		this.getDownloadRequestResult = getDownloadRequestResult;
	}

	@Override
	public OfflineStoreConfiguration clone() {
		OfflineStoreConfiguration clone = new OfflineStoreConfiguration();
		clone.listRequests = listRequests.clone();
		clone.getRequest = getRequest.clone();
		clone.createListRequest = createListRequest.clone();
		clone.createDownloadRequest = createDownloadRequest.clone();
		clone.getListRequestResult = getListRequestResult.clone();
		clone.getDownloadRequestResult = getDownloadRequestResult.clone();
		return clone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createDownloadRequest == null) ? 0 : createDownloadRequest.hashCode());
		result = prime * result + ((createListRequest == null) ? 0 : createListRequest.hashCode());
		result = prime * result + ((getDownloadRequestResult == null) ? 0 : getDownloadRequestResult.hashCode());
		result = prime * result + ((getListRequestResult == null) ? 0 : getListRequestResult.hashCode());
		result = prime * result + ((getRequest == null) ? 0 : getRequest.hashCode());
		result = prime * result + ((listRequests == null) ? 0 : listRequests.hashCode());
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
		OfflineStoreConfiguration other = (OfflineStoreConfiguration) obj;
		if (createDownloadRequest == null) {
			if (other.createDownloadRequest != null)
				return false;
		} else if (!createDownloadRequest.equals(other.createDownloadRequest))
			return false;
		if (createListRequest == null) {
			if (other.createListRequest != null)
				return false;
		} else if (!createListRequest.equals(other.createListRequest))
			return false;
		if (getDownloadRequestResult == null) {
			if (other.getDownloadRequestResult != null)
				return false;
		} else if (!getDownloadRequestResult.equals(other.getDownloadRequestResult))
			return false;
		if (getListRequestResult == null) {
			if (other.getListRequestResult != null)
				return false;
		} else if (!getListRequestResult.equals(other.getListRequestResult))
			return false;
		if (getRequest == null) {
			if (other.getRequest != null)
				return false;
		} else if (!getRequest.equals(other.getRequest))
			return false;
		if (listRequests == null) {
			if (other.listRequests != null)
				return false;
		} else if (!listRequests.equals(other.listRequests))
			return false;
		return true;
	}

}
