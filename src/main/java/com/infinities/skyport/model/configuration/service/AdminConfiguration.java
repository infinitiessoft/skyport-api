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
package com.infinities.skyport.model.configuration.service;

import java.io.Serializable;

import com.infinities.skyport.model.configuration.admin.AccountConfiguration;
import com.infinities.skyport.model.configuration.admin.BillingConfiguration;
import com.infinities.skyport.model.configuration.admin.PrepaymentConfiguration;

public class AdminConfiguration implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PrepaymentConfiguration prepaymentConfiguration = new PrepaymentConfiguration();
	private AccountConfiguration accountConfiguration = new AccountConfiguration();
	private BillingConfiguration billingConfiguration = new BillingConfiguration();


	public PrepaymentConfiguration getPrepaymentConfiguration() {
		return prepaymentConfiguration;
	}

	public void setPrepaymentConfiguration(PrepaymentConfiguration prepaymentConfiguration) {
		this.prepaymentConfiguration = prepaymentConfiguration;
	}

	public AccountConfiguration getAccountConfiguration() {
		return accountConfiguration;
	}

	public void setAccountConfiguration(AccountConfiguration accountConfiguration) {
		this.accountConfiguration = accountConfiguration;
	}

	public BillingConfiguration getBillingConfiguration() {
		return billingConfiguration;
	}

	public void setBillingConfiguration(BillingConfiguration billingConfiguration) {
		this.billingConfiguration = billingConfiguration;
	}

	@Override
	public AdminConfiguration clone() {
		AdminConfiguration clone = new AdminConfiguration();
		clone.setAccountConfiguration(this.getAccountConfiguration().clone());
		clone.setBillingConfiguration(this.getBillingConfiguration().clone());
		clone.setPrepaymentConfiguration(prepaymentConfiguration.clone());
		return clone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountConfiguration == null) ? 0 : accountConfiguration.hashCode());
		result = prime * result + ((billingConfiguration == null) ? 0 : billingConfiguration.hashCode());
		result = prime * result + ((prepaymentConfiguration == null) ? 0 : prepaymentConfiguration.hashCode());
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
		AdminConfiguration other = (AdminConfiguration) obj;
		if (accountConfiguration == null) {
			if (other.accountConfiguration != null)
				return false;
		} else if (!accountConfiguration.equals(other.accountConfiguration))
			return false;
		if (billingConfiguration == null) {
			if (other.billingConfiguration != null)
				return false;
		} else if (!billingConfiguration.equals(other.billingConfiguration))
			return false;
		if (prepaymentConfiguration == null) {
			if (other.prepaymentConfiguration != null)
				return false;
		} else if (!prepaymentConfiguration.equals(other.prepaymentConfiguration))
			return false;
		return true;
	}

}
