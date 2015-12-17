package com.infinities.skyport.model.configuration.admin;

import java.io.Serializable;

import com.infinities.skyport.model.FunctionConfiguration;

public class PrepaymentConfiguration implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	private FunctionConfiguration getOffering = new FunctionConfiguration();
	private FunctionConfiguration getPrepayment = new FunctionConfiguration();
	private FunctionConfiguration getProviderTermForOffering = new FunctionConfiguration();
	private FunctionConfiguration getProviderTermForPrepayment = new FunctionConfiguration();
	private FunctionConfiguration listOfferings = new FunctionConfiguration();
	private FunctionConfiguration listPrepayments = new FunctionConfiguration();
	private FunctionConfiguration prepay = new FunctionConfiguration();


	public FunctionConfiguration getGetOffering() {
		return getOffering;
	}

	public void setGetOffering(FunctionConfiguration getOffering) {
		this.getOffering = getOffering;
	}

	public FunctionConfiguration getGetPrepayment() {
		return getPrepayment;
	}

	public void setGetPrepayment(FunctionConfiguration getPrepayment) {
		this.getPrepayment = getPrepayment;
	}

	public FunctionConfiguration getGetProviderTermForOffering() {
		return getProviderTermForOffering;
	}

	public void setGetProviderTermForOffering(FunctionConfiguration getProviderTermForOffering) {
		this.getProviderTermForOffering = getProviderTermForOffering;
	}

	public FunctionConfiguration getGetProviderTermForPrepayment() {
		return getProviderTermForPrepayment;
	}

	public void setGetProviderTermForPrepayment(FunctionConfiguration getProviderTermForPrepayment) {
		this.getProviderTermForPrepayment = getProviderTermForPrepayment;
	}

	public FunctionConfiguration getListOfferings() {
		return listOfferings;
	}

	public void setListOfferings(FunctionConfiguration listOfferings) {
		this.listOfferings = listOfferings;
	}

	public FunctionConfiguration getListPrepayments() {
		return listPrepayments;
	}

	public void setListPrepayments(FunctionConfiguration listPrepayments) {
		this.listPrepayments = listPrepayments;
	}

	public FunctionConfiguration getPrepay() {
		return prepay;
	}

	public void setPrepay(FunctionConfiguration prepay) {
		this.prepay = prepay;
	}

	@Override
	public PrepaymentConfiguration clone() {
		PrepaymentConfiguration clone = new PrepaymentConfiguration();
		clone.setGetOffering(getGetOffering().clone());
		clone.setGetPrepayment(getGetPrepayment().clone());
		clone.setGetProviderTermForOffering(getGetProviderTermForOffering().clone());
		clone.setGetProviderTermForPrepayment(getGetProviderTermForPrepayment().clone());
		clone.setListOfferings(getListOfferings().clone());
		clone.setListPrepayments(getListPrepayments().clone());
		clone.setPrepay(getGetPrepayment().clone());
		return clone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getOffering == null) ? 0 : getOffering.hashCode());
		result = prime * result + ((getPrepayment == null) ? 0 : getPrepayment.hashCode());
		result = prime * result + ((getProviderTermForOffering == null) ? 0 : getProviderTermForOffering.hashCode());
		result = prime * result + ((getProviderTermForPrepayment == null) ? 0 : getProviderTermForPrepayment.hashCode());
		result = prime * result + ((listOfferings == null) ? 0 : listOfferings.hashCode());
		result = prime * result + ((listPrepayments == null) ? 0 : listPrepayments.hashCode());
		result = prime * result + ((prepay == null) ? 0 : prepay.hashCode());
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
		PrepaymentConfiguration other = (PrepaymentConfiguration) obj;
		if (getOffering == null) {
			if (other.getOffering != null)
				return false;
		} else if (!getOffering.equals(other.getOffering))
			return false;
		if (getPrepayment == null) {
			if (other.getPrepayment != null)
				return false;
		} else if (!getPrepayment.equals(other.getPrepayment))
			return false;
		if (getProviderTermForOffering == null) {
			if (other.getProviderTermForOffering != null)
				return false;
		} else if (!getProviderTermForOffering.equals(other.getProviderTermForOffering))
			return false;
		if (getProviderTermForPrepayment == null) {
			if (other.getProviderTermForPrepayment != null)
				return false;
		} else if (!getProviderTermForPrepayment.equals(other.getProviderTermForPrepayment))
			return false;
		if (listOfferings == null) {
			if (other.listOfferings != null)
				return false;
		} else if (!listOfferings.equals(other.listOfferings))
			return false;
		if (listPrepayments == null) {
			if (other.listPrepayments != null)
				return false;
		} else if (!listPrepayments.equals(other.listPrepayments))
			return false;
		if (prepay == null) {
			if (other.prepay != null)
				return false;
		} else if (!prepay.equals(other.prepay))
			return false;
		return true;
	}

}
