package com.infinities.skyport.model.configuration.network;

import java.io.Serializable;

import com.infinities.skyport.model.FunctionConfiguration;

public class DNSConfiguration implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	private FunctionConfiguration addDnsRecord = new FunctionConfiguration();
	private FunctionConfiguration createDnsZone = new FunctionConfiguration();
	private FunctionConfiguration deleteDnsRecords = new FunctionConfiguration();
	private FunctionConfiguration deleteDnsZone = new FunctionConfiguration();
	private FunctionConfiguration getDnsZone = new FunctionConfiguration();
	private FunctionConfiguration getProviderTermForRecord = new FunctionConfiguration();
	private FunctionConfiguration getProviderTermForZone = new FunctionConfiguration();
	private FunctionConfiguration listDnsRecords = new FunctionConfiguration();
	private FunctionConfiguration listDnsZoneStatus = new FunctionConfiguration();
	private FunctionConfiguration listDnsZones = new FunctionConfiguration();


	public FunctionConfiguration getAddDnsRecord() {
		return addDnsRecord;
	}

	public void setAddDnsRecord(FunctionConfiguration addDnsRecord) {
		this.addDnsRecord = addDnsRecord;
	}

	public FunctionConfiguration getCreateDnsZone() {
		return createDnsZone;
	}

	public void setCreateDnsZone(FunctionConfiguration createDnsZone) {
		this.createDnsZone = createDnsZone;
	}

	public FunctionConfiguration getDeleteDnsRecords() {
		return deleteDnsRecords;
	}

	public void setDeleteDnsRecords(FunctionConfiguration deleteDnsRecords) {
		this.deleteDnsRecords = deleteDnsRecords;
	}

	public FunctionConfiguration getDeleteDnsZone() {
		return deleteDnsZone;
	}

	public void setDeleteDnsZone(FunctionConfiguration deleteDnsZone) {
		this.deleteDnsZone = deleteDnsZone;
	}

	public FunctionConfiguration getGetDnsZone() {
		return getDnsZone;
	}

	public void setGetDnsZone(FunctionConfiguration getDnsZone) {
		this.getDnsZone = getDnsZone;
	}

	public FunctionConfiguration getGetProviderTermForRecord() {
		return getProviderTermForRecord;
	}

	public void setGetProviderTermForRecord(FunctionConfiguration getProviderTermForRecord) {
		this.getProviderTermForRecord = getProviderTermForRecord;
	}

	public FunctionConfiguration getGetProviderTermForZone() {
		return getProviderTermForZone;
	}

	public void setGetProviderTermForZone(FunctionConfiguration getProviderTermForZone) {
		this.getProviderTermForZone = getProviderTermForZone;
	}

	public FunctionConfiguration getListDnsRecords() {
		return listDnsRecords;
	}

	public void setListDnsRecords(FunctionConfiguration listDnsRecords) {
		this.listDnsRecords = listDnsRecords;
	}

	public FunctionConfiguration getListDnsZoneStatus() {
		return listDnsZoneStatus;
	}

	public void setListDnsZoneStatus(FunctionConfiguration listDnsZoneStatus) {
		this.listDnsZoneStatus = listDnsZoneStatus;
	}

	public FunctionConfiguration getListDnsZones() {
		return listDnsZones;
	}

	public void setListDnsZones(FunctionConfiguration listDnsZones) {
		this.listDnsZones = listDnsZones;
	}

	@Override
	public DNSConfiguration clone() {
		DNSConfiguration clone = new DNSConfiguration();
		clone.addDnsRecord = addDnsRecord.clone();
		clone.createDnsZone = createDnsZone.clone();
		clone.deleteDnsRecords = deleteDnsRecords.clone();
		clone.deleteDnsZone = deleteDnsZone.clone();
		clone.getDnsZone = getDnsZone.clone();
		clone.getProviderTermForRecord = getProviderTermForRecord.clone();
		clone.getProviderTermForZone = getProviderTermForZone.clone();
		clone.listDnsRecords = listDnsRecords.clone();
		clone.listDnsZoneStatus = listDnsZoneStatus.clone();
		clone.listDnsZones = listDnsZones.clone();
		return clone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addDnsRecord == null) ? 0 : addDnsRecord.hashCode());
		result = prime * result + ((createDnsZone == null) ? 0 : createDnsZone.hashCode());
		result = prime * result + ((deleteDnsRecords == null) ? 0 : deleteDnsRecords.hashCode());
		result = prime * result + ((deleteDnsZone == null) ? 0 : deleteDnsZone.hashCode());
		result = prime * result + ((getDnsZone == null) ? 0 : getDnsZone.hashCode());
		result = prime * result + ((getProviderTermForRecord == null) ? 0 : getProviderTermForRecord.hashCode());
		result = prime * result + ((getProviderTermForZone == null) ? 0 : getProviderTermForZone.hashCode());
		result = prime * result + ((listDnsRecords == null) ? 0 : listDnsRecords.hashCode());
		result = prime * result + ((listDnsZoneStatus == null) ? 0 : listDnsZoneStatus.hashCode());
		result = prime * result + ((listDnsZones == null) ? 0 : listDnsZones.hashCode());
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
		DNSConfiguration other = (DNSConfiguration) obj;
		if (addDnsRecord == null) {
			if (other.addDnsRecord != null)
				return false;
		} else if (!addDnsRecord.equals(other.addDnsRecord))
			return false;
		if (createDnsZone == null) {
			if (other.createDnsZone != null)
				return false;
		} else if (!createDnsZone.equals(other.createDnsZone))
			return false;
		if (deleteDnsRecords == null) {
			if (other.deleteDnsRecords != null)
				return false;
		} else if (!deleteDnsRecords.equals(other.deleteDnsRecords))
			return false;
		if (deleteDnsZone == null) {
			if (other.deleteDnsZone != null)
				return false;
		} else if (!deleteDnsZone.equals(other.deleteDnsZone))
			return false;
		if (getDnsZone == null) {
			if (other.getDnsZone != null)
				return false;
		} else if (!getDnsZone.equals(other.getDnsZone))
			return false;
		if (getProviderTermForRecord == null) {
			if (other.getProviderTermForRecord != null)
				return false;
		} else if (!getProviderTermForRecord.equals(other.getProviderTermForRecord))
			return false;
		if (getProviderTermForZone == null) {
			if (other.getProviderTermForZone != null)
				return false;
		} else if (!getProviderTermForZone.equals(other.getProviderTermForZone))
			return false;
		if (listDnsRecords == null) {
			if (other.listDnsRecords != null)
				return false;
		} else if (!listDnsRecords.equals(other.listDnsRecords))
			return false;
		if (listDnsZoneStatus == null) {
			if (other.listDnsZoneStatus != null)
				return false;
		} else if (!listDnsZoneStatus.equals(other.listDnsZoneStatus))
			return false;
		if (listDnsZones == null) {
			if (other.listDnsZones != null)
				return false;
		} else if (!listDnsZones.equals(other.listDnsZones))
			return false;
		return true;
	}

}
