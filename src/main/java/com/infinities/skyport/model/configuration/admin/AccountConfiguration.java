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
package com.infinities.skyport.model.configuration.admin;

import java.io.Serializable;

import com.infinities.skyport.model.FunctionConfiguration;

public class AccountConfiguration implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FunctionConfiguration create = new FunctionConfiguration();
	private FunctionConfiguration listTimeZones = new FunctionConfiguration();
	private FunctionConfiguration delete = new FunctionConfiguration();
	private FunctionConfiguration listAccounts = new FunctionConfiguration();
	private FunctionConfiguration getAccount = new FunctionConfiguration();
	private FunctionConfiguration enable = new FunctionConfiguration();
	private FunctionConfiguration suspend = new FunctionConfiguration();
	private FunctionConfiguration update = new FunctionConfiguration();


	public FunctionConfiguration getCreate() {
		return create;
	}

	public void setCreate(FunctionConfiguration create) {
		this.create = create;
	}

	public FunctionConfiguration getListTimeZones() {
		return listTimeZones;
	}

	public void setListTimeZones(FunctionConfiguration listTimeZones) {
		this.listTimeZones = listTimeZones;
	}

	public FunctionConfiguration getDelete() {
		return delete;
	}

	public void setDelete(FunctionConfiguration delete) {
		this.delete = delete;
	}

	public FunctionConfiguration getListAccounts() {
		return listAccounts;
	}

	public void setListAccounts(FunctionConfiguration listAccounts) {
		this.listAccounts = listAccounts;
	}

	public FunctionConfiguration getGetAccount() {
		return getAccount;
	}

	public void setGetAccount(FunctionConfiguration getAccount) {
		this.getAccount = getAccount;
	}

	public FunctionConfiguration getEnable() {
		return enable;
	}

	public void setEnable(FunctionConfiguration enable) {
		this.enable = enable;
	}

	public FunctionConfiguration getSuspend() {
		return suspend;
	}

	public void setSuspend(FunctionConfiguration suspend) {
		this.suspend = suspend;
	}

	public FunctionConfiguration getUpdate() {
		return update;
	}

	public void setUpdate(FunctionConfiguration update) {
		this.update = update;
	}

	@Override
	public AccountConfiguration clone() {
		AccountConfiguration clone = new AccountConfiguration();
		clone.setCreate(getCreate().clone());
		clone.setDelete(getDelete().clone());
		clone.setEnable(getEnable().clone());
		clone.setGetAccount(getGetAccount().clone());
		clone.setListAccounts(getListAccounts().clone());
		clone.setListTimeZones(getListTimeZones().clone());
		clone.setSuspend(getSuspend().clone());
		clone.setUpdate(getUpdate().clone());
		return clone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((create == null) ? 0 : create.hashCode());
		result = prime * result + ((delete == null) ? 0 : delete.hashCode());
		result = prime * result + ((enable == null) ? 0 : enable.hashCode());
		result = prime * result + ((getAccount == null) ? 0 : getAccount.hashCode());
		result = prime * result + ((listAccounts == null) ? 0 : listAccounts.hashCode());
		result = prime * result + ((listTimeZones == null) ? 0 : listTimeZones.hashCode());
		result = prime * result + ((suspend == null) ? 0 : suspend.hashCode());
		result = prime * result + ((update == null) ? 0 : update.hashCode());
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
		AccountConfiguration other = (AccountConfiguration) obj;
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
		if (enable == null) {
			if (other.enable != null)
				return false;
		} else if (!enable.equals(other.enable))
			return false;
		if (getAccount == null) {
			if (other.getAccount != null)
				return false;
		} else if (!getAccount.equals(other.getAccount))
			return false;
		if (listAccounts == null) {
			if (other.listAccounts != null)
				return false;
		} else if (!listAccounts.equals(other.listAccounts))
			return false;
		if (listTimeZones == null) {
			if (other.listTimeZones != null)
				return false;
		} else if (!listTimeZones.equals(other.listTimeZones))
			return false;
		if (suspend == null) {
			if (other.suspend != null)
				return false;
		} else if (!suspend.equals(other.suspend))
			return false;
		if (update == null) {
			if (other.update != null)
				return false;
		} else if (!update.equals(other.update))
			return false;
		return true;
	}

}
