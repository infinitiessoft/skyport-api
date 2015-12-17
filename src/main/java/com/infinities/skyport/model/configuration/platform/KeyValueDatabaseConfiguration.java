package com.infinities.skyport.model.configuration.platform;

import java.io.Serializable;

import com.infinities.skyport.model.FunctionConfiguration;

public class KeyValueDatabaseConfiguration implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	private FunctionConfiguration addKeyValuePairs = new FunctionConfiguration();
	private FunctionConfiguration createDatabase = new FunctionConfiguration();
	private FunctionConfiguration getKeyValuePairs = new FunctionConfiguration();
	private FunctionConfiguration getDatabase = new FunctionConfiguration();
	private FunctionConfiguration list = new FunctionConfiguration();
	private FunctionConfiguration listKeyValueDatabaseStatus = new FunctionConfiguration();
	private FunctionConfiguration query = new FunctionConfiguration();
	private FunctionConfiguration removeKeyValuePairs = new FunctionConfiguration();
	private FunctionConfiguration removeDatabase = new FunctionConfiguration();
	private FunctionConfiguration replaceKeyValuePairs = new FunctionConfiguration();


	public FunctionConfiguration getAddKeyValuePairs() {
		return addKeyValuePairs;
	}

	public void setAddKeyValuePairs(FunctionConfiguration addKeyValuePairs) {
		this.addKeyValuePairs = addKeyValuePairs;
	}

	public FunctionConfiguration getCreateDatabase() {
		return createDatabase;
	}

	public void setCreateDatabase(FunctionConfiguration createDatabase) {
		this.createDatabase = createDatabase;
	}

	public FunctionConfiguration getGetKeyValuePairs() {
		return getKeyValuePairs;
	}

	public void setGetKeyValuePairs(FunctionConfiguration getKeyValuePairs) {
		this.getKeyValuePairs = getKeyValuePairs;
	}

	public FunctionConfiguration getGetDatabase() {
		return getDatabase;
	}

	public void setGetDatabase(FunctionConfiguration getDatabase) {
		this.getDatabase = getDatabase;
	}

	public FunctionConfiguration getList() {
		return list;
	}

	public void setList(FunctionConfiguration list) {
		this.list = list;
	}

	public FunctionConfiguration getListKeyValueDatabaseStatus() {
		return listKeyValueDatabaseStatus;
	}

	public void setListKeyValueDatabaseStatus(FunctionConfiguration listKeyValueDatabaseStatus) {
		this.listKeyValueDatabaseStatus = listKeyValueDatabaseStatus;
	}

	public FunctionConfiguration getQuery() {
		return query;
	}

	public void setQuery(FunctionConfiguration query) {
		this.query = query;
	}

	public FunctionConfiguration getRemoveKeyValuePairs() {
		return removeKeyValuePairs;
	}

	public void setRemoveKeyValuePairs(FunctionConfiguration removeKeyValuePairs) {
		this.removeKeyValuePairs = removeKeyValuePairs;
	}

	public FunctionConfiguration getRemoveDatabase() {
		return removeDatabase;
	}

	public void setRemoveDatabase(FunctionConfiguration removeDatabase) {
		this.removeDatabase = removeDatabase;
	}

	public FunctionConfiguration getReplaceKeyValuePairs() {
		return replaceKeyValuePairs;
	}

	public void setReplaceKeyValuePairs(FunctionConfiguration replaceKeyValuePairs) {
		this.replaceKeyValuePairs = replaceKeyValuePairs;
	}

	@Override
	public KeyValueDatabaseConfiguration clone() {
		KeyValueDatabaseConfiguration clone = new KeyValueDatabaseConfiguration();
		clone.addKeyValuePairs = addKeyValuePairs.clone();
		clone.createDatabase = createDatabase.clone();
		clone.getKeyValuePairs = getKeyValuePairs.clone();
		clone.getDatabase = getDatabase.clone();
		clone.list = list.clone();
		clone.listKeyValueDatabaseStatus = listKeyValueDatabaseStatus.clone();
		clone.query = query.clone();
		clone.removeKeyValuePairs = removeKeyValuePairs.clone();
		clone.removeDatabase = removeDatabase.clone();
		clone.replaceKeyValuePairs = replaceKeyValuePairs.clone();
		return clone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addKeyValuePairs == null) ? 0 : addKeyValuePairs.hashCode());
		result = prime * result + ((createDatabase == null) ? 0 : createDatabase.hashCode());
		result = prime * result + ((getDatabase == null) ? 0 : getDatabase.hashCode());
		result = prime * result + ((getKeyValuePairs == null) ? 0 : getKeyValuePairs.hashCode());
		result = prime * result + ((list == null) ? 0 : list.hashCode());
		result = prime * result + ((listKeyValueDatabaseStatus == null) ? 0 : listKeyValueDatabaseStatus.hashCode());
		result = prime * result + ((query == null) ? 0 : query.hashCode());
		result = prime * result + ((removeDatabase == null) ? 0 : removeDatabase.hashCode());
		result = prime * result + ((removeKeyValuePairs == null) ? 0 : removeKeyValuePairs.hashCode());
		result = prime * result + ((replaceKeyValuePairs == null) ? 0 : replaceKeyValuePairs.hashCode());
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
		KeyValueDatabaseConfiguration other = (KeyValueDatabaseConfiguration) obj;
		if (addKeyValuePairs == null) {
			if (other.addKeyValuePairs != null)
				return false;
		} else if (!addKeyValuePairs.equals(other.addKeyValuePairs))
			return false;
		if (createDatabase == null) {
			if (other.createDatabase != null)
				return false;
		} else if (!createDatabase.equals(other.createDatabase))
			return false;
		if (getDatabase == null) {
			if (other.getDatabase != null)
				return false;
		} else if (!getDatabase.equals(other.getDatabase))
			return false;
		if (getKeyValuePairs == null) {
			if (other.getKeyValuePairs != null)
				return false;
		} else if (!getKeyValuePairs.equals(other.getKeyValuePairs))
			return false;
		if (list == null) {
			if (other.list != null)
				return false;
		} else if (!list.equals(other.list))
			return false;
		if (listKeyValueDatabaseStatus == null) {
			if (other.listKeyValueDatabaseStatus != null)
				return false;
		} else if (!listKeyValueDatabaseStatus.equals(other.listKeyValueDatabaseStatus))
			return false;
		if (query == null) {
			if (other.query != null)
				return false;
		} else if (!query.equals(other.query))
			return false;
		if (removeDatabase == null) {
			if (other.removeDatabase != null)
				return false;
		} else if (!removeDatabase.equals(other.removeDatabase))
			return false;
		if (removeKeyValuePairs == null) {
			if (other.removeKeyValuePairs != null)
				return false;
		} else if (!removeKeyValuePairs.equals(other.removeKeyValuePairs))
			return false;
		if (replaceKeyValuePairs == null) {
			if (other.replaceKeyValuePairs != null)
				return false;
		} else if (!replaceKeyValuePairs.equals(other.replaceKeyValuePairs))
			return false;
		return true;
	}

}
