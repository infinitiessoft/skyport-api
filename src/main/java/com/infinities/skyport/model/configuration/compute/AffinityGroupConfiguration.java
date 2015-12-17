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
package com.infinities.skyport.model.configuration.compute;

import java.io.Serializable;

import com.infinities.skyport.model.FunctionConfiguration;

public class AffinityGroupConfiguration implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private FunctionConfiguration create = new FunctionConfiguration();
	private FunctionConfiguration delete = new FunctionConfiguration();
	private FunctionConfiguration get = new FunctionConfiguration();
	private FunctionConfiguration list = new FunctionConfiguration();
	private FunctionConfiguration modify = new FunctionConfiguration();


	public FunctionConfiguration getCreate() {
		return create;
	}

	public void setCreate(FunctionConfiguration create) {
		this.create = create;
	}

	public FunctionConfiguration getDelete() {
		return delete;
	}

	public void setDelete(FunctionConfiguration delete) {
		this.delete = delete;
	}

	public FunctionConfiguration getGet() {
		return get;
	}

	public void setGet(FunctionConfiguration get) {
		this.get = get;
	}

	public FunctionConfiguration getList() {
		return list;
	}

	public void setList(FunctionConfiguration list) {
		this.list = list;
	}

	public FunctionConfiguration getModify() {
		return modify;
	}

	public void setModify(FunctionConfiguration modify) {
		this.modify = modify;
	}

	@Override
	public AffinityGroupConfiguration clone() {
		AffinityGroupConfiguration clone = new AffinityGroupConfiguration();
		clone.setCreate(create.clone());
		clone.setDelete(delete.clone());
		clone.setGet(get.clone());
		clone.setList(list.clone());
		clone.setModify(modify.clone());
		return clone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((create == null) ? 0 : create.hashCode());
		result = prime * result + ((delete == null) ? 0 : delete.hashCode());
		result = prime * result + ((get == null) ? 0 : get.hashCode());
		result = prime * result + ((list == null) ? 0 : list.hashCode());
		result = prime * result + ((modify == null) ? 0 : modify.hashCode());
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
		AffinityGroupConfiguration other = (AffinityGroupConfiguration) obj;
		if (create == null) {
			if (other.create != null)
				return false;
		} else if (!create.equals(other.create))
			return false;
		if (delete == null) {
			if (other.delete != null)
				return false;
		} else if (!delete.equals(other.delete))
			return false;
		if (get == null) {
			if (other.get != null)
				return false;
		} else if (!get.equals(other.get))
			return false;
		if (list == null) {
			if (other.list != null)
				return false;
		} else if (!list.equals(other.list))
			return false;
		if (modify == null) {
			if (other.modify != null)
				return false;
		} else if (!modify.equals(other.modify))
			return false;
		return true;
	}

}
