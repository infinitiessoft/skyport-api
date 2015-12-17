package com.infinities.skyport.model.configuration.admin;

import java.io.Serializable;

import com.infinities.skyport.model.FunctionConfiguration;

public class BillingConfiguration implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FunctionConfiguration listBillingHistory = new FunctionConfiguration();
	private FunctionConfiguration getInvoice = new FunctionConfiguration();
	private FunctionConfiguration getAccountEstimates = new FunctionConfiguration();
	private FunctionConfiguration getBillingCycleDay = new FunctionConfiguration();
	private FunctionConfiguration getBalance = new FunctionConfiguration();


	public FunctionConfiguration getListBillingHistory() {
		return listBillingHistory;
	}

	public void setListBillingHistory(FunctionConfiguration listBillingHistory) {
		this.listBillingHistory = listBillingHistory;
	}

	public FunctionConfiguration getGetInvoice() {
		return getInvoice;
	}

	public void setGetInvoice(FunctionConfiguration getInvoice) {
		this.getInvoice = getInvoice;
	}

	public FunctionConfiguration getGetAccountEstimates() {
		return getAccountEstimates;
	}

	public void setGetAccountEstimates(FunctionConfiguration getAccountEstimates) {
		this.getAccountEstimates = getAccountEstimates;
	}

	public FunctionConfiguration getGetBillingCycleDay() {
		return getBillingCycleDay;
	}

	public void setGetBillingCycleDay(FunctionConfiguration getBillingCycleDay) {
		this.getBillingCycleDay = getBillingCycleDay;
	}

	public FunctionConfiguration getGetBalance() {
		return getBalance;
	}

	public void setGetBalance(FunctionConfiguration getBalance) {
		this.getBalance = getBalance;
	}

	@Override
	public BillingConfiguration clone() {
		BillingConfiguration clone = new BillingConfiguration();
		clone.setGetAccountEstimates(getGetAccountEstimates().clone());
		clone.setGetBalance(getGetBalance().clone());
		clone.setGetBillingCycleDay(getGetBillingCycleDay().clone());
		clone.setGetInvoice(getGetInvoice().clone());
		clone.setListBillingHistory(getListBillingHistory().clone());
		return clone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getAccountEstimates == null) ? 0 : getAccountEstimates.hashCode());
		result = prime * result + ((getBalance == null) ? 0 : getBalance.hashCode());
		result = prime * result + ((getBillingCycleDay == null) ? 0 : getBillingCycleDay.hashCode());
		result = prime * result + ((getInvoice == null) ? 0 : getInvoice.hashCode());
		result = prime * result + ((listBillingHistory == null) ? 0 : listBillingHistory.hashCode());
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
		BillingConfiguration other = (BillingConfiguration) obj;
		if (getAccountEstimates == null) {
			if (other.getAccountEstimates != null)
				return false;
		} else if (!getAccountEstimates.equals(other.getAccountEstimates))
			return false;
		if (getBalance == null) {
			if (other.getBalance != null)
				return false;
		} else if (!getBalance.equals(other.getBalance))
			return false;
		if (getBillingCycleDay == null) {
			if (other.getBillingCycleDay != null)
				return false;
		} else if (!getBillingCycleDay.equals(other.getBillingCycleDay))
			return false;
		if (getInvoice == null) {
			if (other.getInvoice != null)
				return false;
		} else if (!getInvoice.equals(other.getInvoice))
			return false;
		if (listBillingHistory == null) {
			if (other.listBillingHistory != null)
				return false;
		} else if (!listBillingHistory.equals(other.listBillingHistory))
			return false;
		return true;
	}

}
