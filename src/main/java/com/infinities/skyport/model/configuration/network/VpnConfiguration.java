package com.infinities.skyport.model.configuration.network;

import java.io.Serializable;

import com.infinities.skyport.model.FunctionConfiguration;

public class VpnConfiguration implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	private FunctionConfiguration attachToVlan = new FunctionConfiguration();
	private FunctionConfiguration connectToGateway = new FunctionConfiguration();
	private FunctionConfiguration createVpn = new FunctionConfiguration();
	private FunctionConfiguration createVpnGateway = new FunctionConfiguration();
	private FunctionConfiguration deleteVpn = new FunctionConfiguration();
	private FunctionConfiguration deleteVpnGateway = new FunctionConfiguration();
	private FunctionConfiguration detachFromVlan = new FunctionConfiguration();
	private FunctionConfiguration disconnectFromGateway = new FunctionConfiguration();
	private FunctionConfiguration getGateway = new FunctionConfiguration();
	private FunctionConfiguration getVpn = new FunctionConfiguration();
	private FunctionConfiguration listGatewayConnections = new FunctionConfiguration();
	private FunctionConfiguration listGatewayStatus = new FunctionConfiguration();
	private FunctionConfiguration listGateways = new FunctionConfiguration();
	private FunctionConfiguration listGatewaysWithBgpAsn = new FunctionConfiguration();
	private FunctionConfiguration listVpnConnections = new FunctionConfiguration();
	private FunctionConfiguration listVpnStatus = new FunctionConfiguration();
	private FunctionConfiguration listVpns = new FunctionConfiguration();


	public FunctionConfiguration getAttachToVlan() {
		return attachToVlan;
	}

	public void setAttachToVlan(FunctionConfiguration attachToVlan) {
		this.attachToVlan = attachToVlan;
	}

	public FunctionConfiguration getConnectToGateway() {
		return connectToGateway;
	}

	public void setConnectToGateway(FunctionConfiguration connectToGateway) {
		this.connectToGateway = connectToGateway;
	}

	public FunctionConfiguration getCreateVpn() {
		return createVpn;
	}

	public void setCreateVpn(FunctionConfiguration createVpn) {
		this.createVpn = createVpn;
	}

	public FunctionConfiguration getCreateVpnGateway() {
		return createVpnGateway;
	}

	public void setCreateVpnGateway(FunctionConfiguration createVpnGateway) {
		this.createVpnGateway = createVpnGateway;
	}

	public FunctionConfiguration getDeleteVpn() {
		return deleteVpn;
	}

	public void setDeleteVpn(FunctionConfiguration deleteVpn) {
		this.deleteVpn = deleteVpn;
	}

	public FunctionConfiguration getDeleteVpnGateway() {
		return deleteVpnGateway;
	}

	public void setDeleteVpnGateway(FunctionConfiguration deleteVpnGateway) {
		this.deleteVpnGateway = deleteVpnGateway;
	}

	public FunctionConfiguration getDetachFromVlan() {
		return detachFromVlan;
	}

	public void setDetachFromVlan(FunctionConfiguration detachFromVlan) {
		this.detachFromVlan = detachFromVlan;
	}

	public FunctionConfiguration getDisconnectFromGateway() {
		return disconnectFromGateway;
	}

	public void setDisconnectFromGateway(FunctionConfiguration disconnectFromGateway) {
		this.disconnectFromGateway = disconnectFromGateway;
	}

	public FunctionConfiguration getGetGateway() {
		return getGateway;
	}

	public void setGetGateway(FunctionConfiguration getGateway) {
		this.getGateway = getGateway;
	}

	public FunctionConfiguration getGetVpn() {
		return getVpn;
	}

	public void setGetVpn(FunctionConfiguration getVpn) {
		this.getVpn = getVpn;
	}

	public FunctionConfiguration getListGatewayConnections() {
		return listGatewayConnections;
	}

	public void setListGatewayConnections(FunctionConfiguration listGatewayConnections) {
		this.listGatewayConnections = listGatewayConnections;
	}

	public FunctionConfiguration getListGatewayStatus() {
		return listGatewayStatus;
	}

	public void setListGatewayStatus(FunctionConfiguration listGatewayStatus) {
		this.listGatewayStatus = listGatewayStatus;
	}

	public FunctionConfiguration getListGateways() {
		return listGateways;
	}

	public void setListGateways(FunctionConfiguration listGateways) {
		this.listGateways = listGateways;
	}

	public FunctionConfiguration getListGatewaysWithBgpAsn() {
		return listGatewaysWithBgpAsn;
	}

	public void setListGatewaysWithBgpAsn(FunctionConfiguration listGatewaysWithBgpAsn) {
		this.listGatewaysWithBgpAsn = listGatewaysWithBgpAsn;
	}

	public FunctionConfiguration getListVpnConnections() {
		return listVpnConnections;
	}

	public void setListVpnConnections(FunctionConfiguration listVpnConnections) {
		this.listVpnConnections = listVpnConnections;
	}

	public FunctionConfiguration getListVpnStatus() {
		return listVpnStatus;
	}

	public void setListVpnStatus(FunctionConfiguration listVpnStatus) {
		this.listVpnStatus = listVpnStatus;
	}

	public FunctionConfiguration getListVpns() {
		return listVpns;
	}

	public void setListVpns(FunctionConfiguration listVpns) {
		this.listVpns = listVpns;
	}

	@Override
	public VpnConfiguration clone() {
		VpnConfiguration clone = new VpnConfiguration();
		clone.attachToVlan = attachToVlan.clone();
		clone.connectToGateway = connectToGateway.clone();
		clone.createVpn = createVpn.clone();
		clone.createVpnGateway = createVpnGateway.clone();
		clone.deleteVpn = deleteVpn.clone();
		clone.deleteVpnGateway = deleteVpnGateway.clone();
		clone.detachFromVlan = detachFromVlan.clone();
		clone.disconnectFromGateway = disconnectFromGateway.clone();
		clone.getGateway = getGateway.clone();
		clone.getVpn = getVpn.clone();
		clone.listGatewayConnections = listGatewayConnections.clone();
		clone.listGatewayStatus = listGatewayStatus.clone();
		clone.listGateways = listGateways.clone();
		clone.listGatewaysWithBgpAsn = listGatewaysWithBgpAsn.clone();
		clone.listVpnConnections = listVpnConnections.clone();
		clone.listVpnStatus = listVpnStatus.clone();
		clone.listVpns = listVpns.clone();
		return clone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attachToVlan == null) ? 0 : attachToVlan.hashCode());
		result = prime * result + ((connectToGateway == null) ? 0 : connectToGateway.hashCode());
		result = prime * result + ((createVpn == null) ? 0 : createVpn.hashCode());
		result = prime * result + ((createVpnGateway == null) ? 0 : createVpnGateway.hashCode());
		result = prime * result + ((deleteVpn == null) ? 0 : deleteVpn.hashCode());
		result = prime * result + ((deleteVpnGateway == null) ? 0 : deleteVpnGateway.hashCode());
		result = prime * result + ((detachFromVlan == null) ? 0 : detachFromVlan.hashCode());
		result = prime * result + ((disconnectFromGateway == null) ? 0 : disconnectFromGateway.hashCode());
		result = prime * result + ((getGateway == null) ? 0 : getGateway.hashCode());
		result = prime * result + ((getVpn == null) ? 0 : getVpn.hashCode());
		result = prime * result + ((listGatewayConnections == null) ? 0 : listGatewayConnections.hashCode());
		result = prime * result + ((listGatewayStatus == null) ? 0 : listGatewayStatus.hashCode());
		result = prime * result + ((listGateways == null) ? 0 : listGateways.hashCode());
		result = prime * result + ((listGatewaysWithBgpAsn == null) ? 0 : listGatewaysWithBgpAsn.hashCode());
		result = prime * result + ((listVpnConnections == null) ? 0 : listVpnConnections.hashCode());
		result = prime * result + ((listVpnStatus == null) ? 0 : listVpnStatus.hashCode());
		result = prime * result + ((listVpns == null) ? 0 : listVpns.hashCode());
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
		VpnConfiguration other = (VpnConfiguration) obj;
		if (attachToVlan == null) {
			if (other.attachToVlan != null)
				return false;
		} else if (!attachToVlan.equals(other.attachToVlan))
			return false;
		if (connectToGateway == null) {
			if (other.connectToGateway != null)
				return false;
		} else if (!connectToGateway.equals(other.connectToGateway))
			return false;
		if (createVpn == null) {
			if (other.createVpn != null)
				return false;
		} else if (!createVpn.equals(other.createVpn))
			return false;
		if (createVpnGateway == null) {
			if (other.createVpnGateway != null)
				return false;
		} else if (!createVpnGateway.equals(other.createVpnGateway))
			return false;
		if (deleteVpn == null) {
			if (other.deleteVpn != null)
				return false;
		} else if (!deleteVpn.equals(other.deleteVpn))
			return false;
		if (deleteVpnGateway == null) {
			if (other.deleteVpnGateway != null)
				return false;
		} else if (!deleteVpnGateway.equals(other.deleteVpnGateway))
			return false;
		if (detachFromVlan == null) {
			if (other.detachFromVlan != null)
				return false;
		} else if (!detachFromVlan.equals(other.detachFromVlan))
			return false;
		if (disconnectFromGateway == null) {
			if (other.disconnectFromGateway != null)
				return false;
		} else if (!disconnectFromGateway.equals(other.disconnectFromGateway))
			return false;
		if (getGateway == null) {
			if (other.getGateway != null)
				return false;
		} else if (!getGateway.equals(other.getGateway))
			return false;
		if (getVpn == null) {
			if (other.getVpn != null)
				return false;
		} else if (!getVpn.equals(other.getVpn))
			return false;
		if (listGatewayConnections == null) {
			if (other.listGatewayConnections != null)
				return false;
		} else if (!listGatewayConnections.equals(other.listGatewayConnections))
			return false;
		if (listGatewayStatus == null) {
			if (other.listGatewayStatus != null)
				return false;
		} else if (!listGatewayStatus.equals(other.listGatewayStatus))
			return false;
		if (listGateways == null) {
			if (other.listGateways != null)
				return false;
		} else if (!listGateways.equals(other.listGateways))
			return false;
		if (listGatewaysWithBgpAsn == null) {
			if (other.listGatewaysWithBgpAsn != null)
				return false;
		} else if (!listGatewaysWithBgpAsn.equals(other.listGatewaysWithBgpAsn))
			return false;
		if (listVpnConnections == null) {
			if (other.listVpnConnections != null)
				return false;
		} else if (!listVpnConnections.equals(other.listVpnConnections))
			return false;
		if (listVpnStatus == null) {
			if (other.listVpnStatus != null)
				return false;
		} else if (!listVpnStatus.equals(other.listVpnStatus))
			return false;
		if (listVpns == null) {
			if (other.listVpns != null)
				return false;
		} else if (!listVpns.equals(other.listVpns))
			return false;
		return true;
	}

}
