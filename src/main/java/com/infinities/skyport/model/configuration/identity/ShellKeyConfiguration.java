package com.infinities.skyport.model.configuration.identity;

import java.io.Serializable;

import com.infinities.skyport.model.FunctionConfiguration;

public class ShellKeyConfiguration implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	private FunctionConfiguration createKeypair = new FunctionConfiguration();
	private FunctionConfiguration deleteKeypair = new FunctionConfiguration();
	private FunctionConfiguration getFingerprint = new FunctionConfiguration();
	private FunctionConfiguration getKeypair = new FunctionConfiguration();
	private FunctionConfiguration importKeypair = new FunctionConfiguration();
	private FunctionConfiguration list = new FunctionConfiguration();


	public FunctionConfiguration getCreateKeypair() {
		return createKeypair;
	}

	public void setCreateKeypair(FunctionConfiguration createKeypair) {
		this.createKeypair = createKeypair;
	}

	public FunctionConfiguration getDeleteKeypair() {
		return deleteKeypair;
	}

	public void setDeleteKeypair(FunctionConfiguration deleteKeypair) {
		this.deleteKeypair = deleteKeypair;
	}

	public FunctionConfiguration getGetFingerprint() {
		return getFingerprint;
	}

	public void setGetFingerprint(FunctionConfiguration getFingerprint) {
		this.getFingerprint = getFingerprint;
	}

	public FunctionConfiguration getGetKeypair() {
		return getKeypair;
	}

	public void setGetKeypair(FunctionConfiguration getKeypair) {
		this.getKeypair = getKeypair;
	}

	public FunctionConfiguration getImportKeypair() {
		return importKeypair;
	}

	public void setImportKeypair(FunctionConfiguration importKeypair) {
		this.importKeypair = importKeypair;
	}

	public FunctionConfiguration getList() {
		return list;
	}

	public void setList(FunctionConfiguration list) {
		this.list = list;
	}

	@Override
	public ShellKeyConfiguration clone() {
		ShellKeyConfiguration clone = new ShellKeyConfiguration();
		clone.createKeypair = createKeypair.clone();
		clone.deleteKeypair = deleteKeypair.clone();
		clone.getFingerprint = getFingerprint.clone();
		clone.getKeypair = getKeypair.clone();
		clone.importKeypair = importKeypair.clone();
		clone.list = list.clone();
		return clone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createKeypair == null) ? 0 : createKeypair.hashCode());
		result = prime * result + ((deleteKeypair == null) ? 0 : deleteKeypair.hashCode());
		result = prime * result + ((getFingerprint == null) ? 0 : getFingerprint.hashCode());
		result = prime * result + ((getKeypair == null) ? 0 : getKeypair.hashCode());
		result = prime * result + ((importKeypair == null) ? 0 : importKeypair.hashCode());
		result = prime * result + ((list == null) ? 0 : list.hashCode());
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
		ShellKeyConfiguration other = (ShellKeyConfiguration) obj;
		if (createKeypair == null) {
			if (other.createKeypair != null)
				return false;
		} else if (!createKeypair.equals(other.createKeypair))
			return false;
		if (deleteKeypair == null) {
			if (other.deleteKeypair != null)
				return false;
		} else if (!deleteKeypair.equals(other.deleteKeypair))
			return false;
		if (getFingerprint == null) {
			if (other.getFingerprint != null)
				return false;
		} else if (!getFingerprint.equals(other.getFingerprint))
			return false;
		if (getKeypair == null) {
			if (other.getKeypair != null)
				return false;
		} else if (!getKeypair.equals(other.getKeypair))
			return false;
		if (importKeypair == null) {
			if (other.importKeypair != null)
				return false;
		} else if (!importKeypair.equals(other.importKeypair))
			return false;
		if (list == null) {
			if (other.list != null)
				return false;
		} else if (!list.equals(other.list))
			return false;
		return true;
	}

}
