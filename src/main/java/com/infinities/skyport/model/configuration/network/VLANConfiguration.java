package com.infinities.skyport.model.configuration.network;

import java.io.Serializable;

import com.infinities.skyport.model.FunctionConfiguration;

public class VLANConfiguration implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	private FunctionConfiguration addRouteToAddress = new FunctionConfiguration();
	private FunctionConfiguration addRouteToGateway = new FunctionConfiguration();
	private FunctionConfiguration addRouteToNetworkInterface = new FunctionConfiguration();
	private FunctionConfiguration addRouteToVirtualMachine = new FunctionConfiguration();
	private FunctionConfiguration assignRoutingTableToSubnet = new FunctionConfiguration();
	private FunctionConfiguration disassociateRoutingTableFromSubnet = new FunctionConfiguration();
	private FunctionConfiguration assignRoutingTableToVlan = new FunctionConfiguration();
	private FunctionConfiguration attachNetworkInterface = new FunctionConfiguration();
	private FunctionConfiguration createInternetGateway = new FunctionConfiguration();
	private FunctionConfiguration createRoutingTable = new FunctionConfiguration();
	private FunctionConfiguration createNetworkInterface = new FunctionConfiguration();
	private FunctionConfiguration createSubnet = new FunctionConfiguration();
	private FunctionConfiguration createVlan = new FunctionConfiguration();
	private FunctionConfiguration detachNetworkInterface = new FunctionConfiguration();
	private FunctionConfiguration getNetworkInterface = new FunctionConfiguration();
	private FunctionConfiguration getRoutingTableForSubnet = new FunctionConfiguration();
	private FunctionConfiguration getRoutingTableForVlan = new FunctionConfiguration();
	private FunctionConfiguration getRoutingTable = new FunctionConfiguration();
	private FunctionConfiguration getSubnet = new FunctionConfiguration();
	private FunctionConfiguration getVlan = new FunctionConfiguration();
	private FunctionConfiguration isConnectedViaInternetGateway = new FunctionConfiguration();
	private FunctionConfiguration getAttachedInternetGatewayId = new FunctionConfiguration();
	private FunctionConfiguration getInternetGatewayById = new FunctionConfiguration();
	private FunctionConfiguration isNetworkInterfaceSupportEnabled = new FunctionConfiguration();
	private FunctionConfiguration listFirewallIdsForNIC = new FunctionConfiguration();
	private FunctionConfiguration listInternetGateways = new FunctionConfiguration();
	private FunctionConfiguration listNetworkInterfaceStatus = new FunctionConfiguration();
	private FunctionConfiguration listNetworkInterfaces = new FunctionConfiguration();
	private FunctionConfiguration listNetworkInterfacesForVM = new FunctionConfiguration();
	private FunctionConfiguration listNetworkInterfacesInSubnet = new FunctionConfiguration();
	private FunctionConfiguration listNetworkInterfacesInVLAN = new FunctionConfiguration();
	private FunctionConfiguration listResources = new FunctionConfiguration();
	private FunctionConfiguration listRoutingTablesForSubnet = new FunctionConfiguration();
	private FunctionConfiguration listRoutingTablesForVlan = new FunctionConfiguration();
	private FunctionConfiguration listSubnets = new FunctionConfiguration();
	private FunctionConfiguration listVlanStatus = new FunctionConfiguration();
	private FunctionConfiguration listVlans = new FunctionConfiguration();
	private FunctionConfiguration removeInternetGateway = new FunctionConfiguration();
	private FunctionConfiguration removeInternetGatewayById = new FunctionConfiguration();
	private FunctionConfiguration removeInternetGatewayTags = new FunctionConfiguration();
	private FunctionConfiguration removeNetworkInterface = new FunctionConfiguration();
	private FunctionConfiguration removeRoute = new FunctionConfiguration();
	private FunctionConfiguration removeRoutingTable = new FunctionConfiguration();
	private FunctionConfiguration removeRoutingTableTags = new FunctionConfiguration();
	private FunctionConfiguration removeSubnet = new FunctionConfiguration();
	private FunctionConfiguration removeSubnetTags = new FunctionConfiguration();
	private FunctionConfiguration setSubnetTags = new FunctionConfiguration();
	private FunctionConfiguration removeVlan = new FunctionConfiguration();
	private FunctionConfiguration removeVLANTags = new FunctionConfiguration();
	private FunctionConfiguration updateSubnetTags = new FunctionConfiguration();
	private FunctionConfiguration updateRoutingTableTags = new FunctionConfiguration();
	private FunctionConfiguration setRoutingTableTags = new FunctionConfiguration();
	private FunctionConfiguration setVLANTags = new FunctionConfiguration();
	private FunctionConfiguration updateVLANTags = new FunctionConfiguration();
	private FunctionConfiguration updateInternetGatewayTags = new FunctionConfiguration();
	private FunctionConfiguration setInternetGatewayTags = new FunctionConfiguration();


	public FunctionConfiguration getAddRouteToAddress() {
		return addRouteToAddress;
	}

	public void setAddRouteToAddress(FunctionConfiguration addRouteToAddress) {
		this.addRouteToAddress = addRouteToAddress;
	}

	public FunctionConfiguration getAddRouteToGateway() {
		return addRouteToGateway;
	}

	public void setAddRouteToGateway(FunctionConfiguration addRouteToGateway) {
		this.addRouteToGateway = addRouteToGateway;
	}

	public FunctionConfiguration getAddRouteToNetworkInterface() {
		return addRouteToNetworkInterface;
	}

	public void setAddRouteToNetworkInterface(FunctionConfiguration addRouteToNetworkInterface) {
		this.addRouteToNetworkInterface = addRouteToNetworkInterface;
	}

	public FunctionConfiguration getAddRouteToVirtualMachine() {
		return addRouteToVirtualMachine;
	}

	public void setAddRouteToVirtualMachine(FunctionConfiguration addRouteToVirtualMachine) {
		this.addRouteToVirtualMachine = addRouteToVirtualMachine;
	}

	public FunctionConfiguration getAssignRoutingTableToSubnet() {
		return assignRoutingTableToSubnet;
	}

	public void setAssignRoutingTableToSubnet(FunctionConfiguration assignRoutingTableToSubnet) {
		this.assignRoutingTableToSubnet = assignRoutingTableToSubnet;
	}

	public FunctionConfiguration getDisassociateRoutingTableFromSubnet() {
		return disassociateRoutingTableFromSubnet;
	}

	public void setDisassociateRoutingTableFromSubnet(FunctionConfiguration disassociateRoutingTableFromSubnet) {
		this.disassociateRoutingTableFromSubnet = disassociateRoutingTableFromSubnet;
	}

	public FunctionConfiguration getAssignRoutingTableToVlan() {
		return assignRoutingTableToVlan;
	}

	public void setAssignRoutingTableToVlan(FunctionConfiguration assignRoutingTableToVlan) {
		this.assignRoutingTableToVlan = assignRoutingTableToVlan;
	}

	public FunctionConfiguration getAttachNetworkInterface() {
		return attachNetworkInterface;
	}

	public void setAttachNetworkInterface(FunctionConfiguration attachNetworkInterface) {
		this.attachNetworkInterface = attachNetworkInterface;
	}

	public FunctionConfiguration getCreateInternetGateway() {
		return createInternetGateway;
	}

	public void setCreateInternetGateway(FunctionConfiguration createInternetGateway) {
		this.createInternetGateway = createInternetGateway;
	}

	public FunctionConfiguration getCreateRoutingTable() {
		return createRoutingTable;
	}

	public void setCreateRoutingTable(FunctionConfiguration createRoutingTable) {
		this.createRoutingTable = createRoutingTable;
	}

	public FunctionConfiguration getCreateNetworkInterface() {
		return createNetworkInterface;
	}

	public void setCreateNetworkInterface(FunctionConfiguration createNetworkInterface) {
		this.createNetworkInterface = createNetworkInterface;
	}

	public FunctionConfiguration getCreateSubnet() {
		return createSubnet;
	}

	public void setCreateSubnet(FunctionConfiguration createSubnet) {
		this.createSubnet = createSubnet;
	}

	public FunctionConfiguration getCreateVlan() {
		return createVlan;
	}

	public void setCreateVlan(FunctionConfiguration createVlan) {
		this.createVlan = createVlan;
	}

	public FunctionConfiguration getDetachNetworkInterface() {
		return detachNetworkInterface;
	}

	public void setDetachNetworkInterface(FunctionConfiguration detachNetworkInterface) {
		this.detachNetworkInterface = detachNetworkInterface;
	}

	public FunctionConfiguration getGetNetworkInterface() {
		return getNetworkInterface;
	}

	public void setGetNetworkInterface(FunctionConfiguration getNetworkInterface) {
		this.getNetworkInterface = getNetworkInterface;
	}

	public FunctionConfiguration getGetRoutingTableForSubnet() {
		return getRoutingTableForSubnet;
	}

	public void setGetRoutingTableForSubnet(FunctionConfiguration getRoutingTableForSubnet) {
		this.getRoutingTableForSubnet = getRoutingTableForSubnet;
	}

	public FunctionConfiguration getGetRoutingTableForVlan() {
		return getRoutingTableForVlan;
	}

	public void setGetRoutingTableForVlan(FunctionConfiguration getRoutingTableForVlan) {
		this.getRoutingTableForVlan = getRoutingTableForVlan;
	}

	public FunctionConfiguration getGetRoutingTable() {
		return getRoutingTable;
	}

	public void setGetRoutingTable(FunctionConfiguration getRoutingTable) {
		this.getRoutingTable = getRoutingTable;
	}

	public FunctionConfiguration getGetSubnet() {
		return getSubnet;
	}

	public void setGetSubnet(FunctionConfiguration getSubnet) {
		this.getSubnet = getSubnet;
	}

	public FunctionConfiguration getGetVlan() {
		return getVlan;
	}

	public void setGetVlan(FunctionConfiguration getVlan) {
		this.getVlan = getVlan;
	}

	public FunctionConfiguration getIsConnectedViaInternetGateway() {
		return isConnectedViaInternetGateway;
	}

	public void setIsConnectedViaInternetGateway(FunctionConfiguration isConnectedViaInternetGateway) {
		this.isConnectedViaInternetGateway = isConnectedViaInternetGateway;
	}

	public FunctionConfiguration getGetAttachedInternetGatewayId() {
		return getAttachedInternetGatewayId;
	}

	public void setGetAttachedInternetGatewayId(FunctionConfiguration getAttachedInternetGatewayId) {
		this.getAttachedInternetGatewayId = getAttachedInternetGatewayId;
	}

	public FunctionConfiguration getGetInternetGatewayById() {
		return getInternetGatewayById;
	}

	public void setGetInternetGatewayById(FunctionConfiguration getInternetGatewayById) {
		this.getInternetGatewayById = getInternetGatewayById;
	}

	public FunctionConfiguration getIsNetworkInterfaceSupportEnabled() {
		return isNetworkInterfaceSupportEnabled;
	}

	public void setIsNetworkInterfaceSupportEnabled(FunctionConfiguration isNetworkInterfaceSupportEnabled) {
		this.isNetworkInterfaceSupportEnabled = isNetworkInterfaceSupportEnabled;
	}

	public FunctionConfiguration getListFirewallIdsForNIC() {
		return listFirewallIdsForNIC;
	}

	public void setListFirewallIdsForNIC(FunctionConfiguration listFirewallIdsForNIC) {
		this.listFirewallIdsForNIC = listFirewallIdsForNIC;
	}

	public FunctionConfiguration getListInternetGateways() {
		return listInternetGateways;
	}

	public void setListInternetGateways(FunctionConfiguration listInternetGateways) {
		this.listInternetGateways = listInternetGateways;
	}

	public FunctionConfiguration getListNetworkInterfaceStatus() {
		return listNetworkInterfaceStatus;
	}

	public void setListNetworkInterfaceStatus(FunctionConfiguration listNetworkInterfaceStatus) {
		this.listNetworkInterfaceStatus = listNetworkInterfaceStatus;
	}

	public FunctionConfiguration getListNetworkInterfaces() {
		return listNetworkInterfaces;
	}

	public void setListNetworkInterfaces(FunctionConfiguration listNetworkInterfaces) {
		this.listNetworkInterfaces = listNetworkInterfaces;
	}

	public FunctionConfiguration getListNetworkInterfacesForVM() {
		return listNetworkInterfacesForVM;
	}

	public void setListNetworkInterfacesForVM(FunctionConfiguration listNetworkInterfacesForVM) {
		this.listNetworkInterfacesForVM = listNetworkInterfacesForVM;
	}

	public FunctionConfiguration getListNetworkInterfacesInSubnet() {
		return listNetworkInterfacesInSubnet;
	}

	public void setListNetworkInterfacesInSubnet(FunctionConfiguration listNetworkInterfacesInSubnet) {
		this.listNetworkInterfacesInSubnet = listNetworkInterfacesInSubnet;
	}

	public FunctionConfiguration getListNetworkInterfacesInVLAN() {
		return listNetworkInterfacesInVLAN;
	}

	public void setListNetworkInterfacesInVLAN(FunctionConfiguration listNetworkInterfacesInVLAN) {
		this.listNetworkInterfacesInVLAN = listNetworkInterfacesInVLAN;
	}

	public FunctionConfiguration getListResources() {
		return listResources;
	}

	public void setListResources(FunctionConfiguration listResources) {
		this.listResources = listResources;
	}

	public FunctionConfiguration getListRoutingTablesForSubnet() {
		return listRoutingTablesForSubnet;
	}

	public void setListRoutingTablesForSubnet(FunctionConfiguration listRoutingTablesForSubnet) {
		this.listRoutingTablesForSubnet = listRoutingTablesForSubnet;
	}

	public FunctionConfiguration getListRoutingTablesForVlan() {
		return listRoutingTablesForVlan;
	}

	public void setListRoutingTablesForVlan(FunctionConfiguration listRoutingTablesForVlan) {
		this.listRoutingTablesForVlan = listRoutingTablesForVlan;
	}

	public FunctionConfiguration getListSubnets() {
		return listSubnets;
	}

	public void setListSubnets(FunctionConfiguration listSubnets) {
		this.listSubnets = listSubnets;
	}

	public FunctionConfiguration getListVlanStatus() {
		return listVlanStatus;
	}

	public void setListVlanStatus(FunctionConfiguration listVlanStatus) {
		this.listVlanStatus = listVlanStatus;
	}

	public FunctionConfiguration getListVlans() {
		return listVlans;
	}

	public void setListVlans(FunctionConfiguration listVlans) {
		this.listVlans = listVlans;
	}

	public FunctionConfiguration getRemoveInternetGateway() {
		return removeInternetGateway;
	}

	public void setRemoveInternetGateway(FunctionConfiguration removeInternetGateway) {
		this.removeInternetGateway = removeInternetGateway;
	}

	public FunctionConfiguration getRemoveInternetGatewayById() {
		return removeInternetGatewayById;
	}

	public void setRemoveInternetGatewayById(FunctionConfiguration removeInternetGatewayById) {
		this.removeInternetGatewayById = removeInternetGatewayById;
	}

	public FunctionConfiguration getRemoveInternetGatewayTags() {
		return removeInternetGatewayTags;
	}

	public void setRemoveInternetGatewayTags(FunctionConfiguration removeInternetGatewayTags) {
		this.removeInternetGatewayTags = removeInternetGatewayTags;
	}

	public FunctionConfiguration getRemoveNetworkInterface() {
		return removeNetworkInterface;
	}

	public void setRemoveNetworkInterface(FunctionConfiguration removeNetworkInterface) {
		this.removeNetworkInterface = removeNetworkInterface;
	}

	public FunctionConfiguration getRemoveRoute() {
		return removeRoute;
	}

	public void setRemoveRoute(FunctionConfiguration removeRoute) {
		this.removeRoute = removeRoute;
	}

	public FunctionConfiguration getRemoveRoutingTable() {
		return removeRoutingTable;
	}

	public void setRemoveRoutingTable(FunctionConfiguration removeRoutingTable) {
		this.removeRoutingTable = removeRoutingTable;
	}

	public FunctionConfiguration getRemoveRoutingTableTags() {
		return removeRoutingTableTags;
	}

	public void setRemoveRoutingTableTags(FunctionConfiguration removeRoutingTableTags) {
		this.removeRoutingTableTags = removeRoutingTableTags;
	}

	public FunctionConfiguration getRemoveSubnet() {
		return removeSubnet;
	}

	public void setRemoveSubnet(FunctionConfiguration removeSubnet) {
		this.removeSubnet = removeSubnet;
	}

	public FunctionConfiguration getRemoveSubnetTags() {
		return removeSubnetTags;
	}

	public void setRemoveSubnetTags(FunctionConfiguration removeSubnetTags) {
		this.removeSubnetTags = removeSubnetTags;
	}

	public FunctionConfiguration getSetSubnetTags() {
		return setSubnetTags;
	}

	public void setSetSubnetTags(FunctionConfiguration setSubnetTags) {
		this.setSubnetTags = setSubnetTags;
	}

	public FunctionConfiguration getRemoveVlan() {
		return removeVlan;
	}

	public void setRemoveVlan(FunctionConfiguration removeVlan) {
		this.removeVlan = removeVlan;
	}

	public FunctionConfiguration getRemoveVLANTags() {
		return removeVLANTags;
	}

	public void setRemoveVLANTags(FunctionConfiguration removeVLANTags) {
		this.removeVLANTags = removeVLANTags;
	}

	public FunctionConfiguration getUpdateSubnetTags() {
		return updateSubnetTags;
	}

	public void setUpdateSubnetTags(FunctionConfiguration updateSubnetTags) {
		this.updateSubnetTags = updateSubnetTags;
	}

	public FunctionConfiguration getUpdateRoutingTableTags() {
		return updateRoutingTableTags;
	}

	public void setUpdateRoutingTableTags(FunctionConfiguration updateRoutingTableTags) {
		this.updateRoutingTableTags = updateRoutingTableTags;
	}

	public FunctionConfiguration getSetRoutingTableTags() {
		return setRoutingTableTags;
	}

	public void setSetRoutingTableTags(FunctionConfiguration setRoutingTableTags) {
		this.setRoutingTableTags = setRoutingTableTags;
	}

	public FunctionConfiguration getSetVLANTags() {
		return setVLANTags;
	}

	public void setSetVLANTags(FunctionConfiguration setVLANTags) {
		this.setVLANTags = setVLANTags;
	}

	public FunctionConfiguration getUpdateVLANTags() {
		return updateVLANTags;
	}

	public void setUpdateVLANTags(FunctionConfiguration updateVLANTags) {
		this.updateVLANTags = updateVLANTags;
	}

	public FunctionConfiguration getUpdateInternetGatewayTags() {
		return updateInternetGatewayTags;
	}

	public void setUpdateInternetGatewayTags(FunctionConfiguration updateInternetGatewayTags) {
		this.updateInternetGatewayTags = updateInternetGatewayTags;
	}

	public FunctionConfiguration getSetInternetGatewayTags() {
		return setInternetGatewayTags;
	}

	public void setSetInternetGatewayTags(FunctionConfiguration setInternetGatewayTags) {
		this.setInternetGatewayTags = setInternetGatewayTags;
	}

	@Override
	public VLANConfiguration clone() {
		VLANConfiguration clone = new VLANConfiguration();
		clone.addRouteToAddress = addRouteToAddress.clone();
		clone.addRouteToGateway = addRouteToGateway.clone();
		clone.addRouteToNetworkInterface = addRouteToNetworkInterface.clone();
		clone.addRouteToVirtualMachine = addRouteToVirtualMachine.clone();
		clone.assignRoutingTableToSubnet = assignRoutingTableToSubnet.clone();
		clone.disassociateRoutingTableFromSubnet = disassociateRoutingTableFromSubnet.clone();
		clone.assignRoutingTableToVlan = assignRoutingTableToVlan.clone();
		clone.attachNetworkInterface = attachNetworkInterface.clone();
		clone.createInternetGateway = createInternetGateway.clone();
		clone.createRoutingTable = createRoutingTable.clone();
		clone.createNetworkInterface = createNetworkInterface.clone();
		clone.createSubnet = createSubnet.clone();
		clone.createVlan = createVlan.clone();
		clone.detachNetworkInterface = detachNetworkInterface.clone();
		clone.getNetworkInterface = getNetworkInterface.clone();
		clone.getRoutingTableForSubnet = getRoutingTableForSubnet.clone();
		clone.getRoutingTableForVlan = getRoutingTableForVlan.clone();
		clone.getRoutingTable = getRoutingTable.clone();
		clone.getSubnet = getSubnet.clone();
		clone.getVlan = getVlan.clone();
		clone.isConnectedViaInternetGateway = isConnectedViaInternetGateway.clone();
		clone.getAttachedInternetGatewayId = getAttachedInternetGatewayId.clone();
		clone.getInternetGatewayById = getInternetGatewayById.clone();
		clone.isNetworkInterfaceSupportEnabled = isNetworkInterfaceSupportEnabled.clone();
		clone.listFirewallIdsForNIC = listFirewallIdsForNIC.clone();
		clone.listInternetGateways = listInternetGateways.clone();
		clone.listNetworkInterfaceStatus = listNetworkInterfaceStatus.clone();
		clone.listNetworkInterfaces = listNetworkInterfaces.clone();
		clone.listNetworkInterfacesForVM = listNetworkInterfacesForVM.clone();
		clone.listNetworkInterfacesInSubnet = listNetworkInterfacesInSubnet.clone();
		clone.listNetworkInterfacesInVLAN = listNetworkInterfacesInVLAN.clone();
		clone.listResources = listResources.clone();
		clone.listRoutingTablesForSubnet = listRoutingTablesForSubnet.clone();
		clone.listRoutingTablesForVlan = listRoutingTablesForVlan.clone();
		clone.listSubnets = listSubnets.clone();
		clone.listVlanStatus = listVlanStatus.clone();
		clone.listVlans = listVlans.clone();
		clone.removeInternetGateway = removeInternetGateway.clone();
		clone.removeInternetGatewayById = removeInternetGatewayById.clone();
		clone.removeInternetGatewayTags = removeInternetGatewayTags.clone();
		clone.removeNetworkInterface = removeNetworkInterface.clone();
		clone.removeRoute = removeRoute.clone();
		clone.removeRoutingTable = removeRoutingTable.clone();
		clone.removeRoutingTableTags = removeRoutingTableTags.clone();
		clone.removeSubnet = removeSubnet.clone();
		clone.removeSubnetTags = removeSubnetTags.clone();
		clone.setSubnetTags = setSubnetTags.clone();
		clone.removeVlan = removeVlan.clone();
		clone.removeVLANTags = removeVLANTags.clone();
		clone.updateSubnetTags = updateSubnetTags.clone();
		clone.updateRoutingTableTags = updateRoutingTableTags.clone();
		clone.setRoutingTableTags = setRoutingTableTags.clone();
		clone.setVLANTags = setVLANTags.clone();
		clone.updateVLANTags = updateVLANTags.clone();
		clone.updateInternetGatewayTags = updateInternetGatewayTags.clone();
		clone.setInternetGatewayTags = setInternetGatewayTags.clone();
		return clone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addRouteToAddress == null) ? 0 : addRouteToAddress.hashCode());
		result = prime * result + ((addRouteToGateway == null) ? 0 : addRouteToGateway.hashCode());
		result = prime * result + ((addRouteToNetworkInterface == null) ? 0 : addRouteToNetworkInterface.hashCode());
		result = prime * result + ((addRouteToVirtualMachine == null) ? 0 : addRouteToVirtualMachine.hashCode());
		result = prime * result + ((assignRoutingTableToSubnet == null) ? 0 : assignRoutingTableToSubnet.hashCode());
		result = prime * result + ((assignRoutingTableToVlan == null) ? 0 : assignRoutingTableToVlan.hashCode());
		result = prime * result + ((attachNetworkInterface == null) ? 0 : attachNetworkInterface.hashCode());
		result = prime * result + ((createInternetGateway == null) ? 0 : createInternetGateway.hashCode());
		result = prime * result + ((createNetworkInterface == null) ? 0 : createNetworkInterface.hashCode());
		result = prime * result + ((createRoutingTable == null) ? 0 : createRoutingTable.hashCode());
		result = prime * result + ((createSubnet == null) ? 0 : createSubnet.hashCode());
		result = prime * result + ((createVlan == null) ? 0 : createVlan.hashCode());
		result = prime * result + ((detachNetworkInterface == null) ? 0 : detachNetworkInterface.hashCode());
		result = prime * result
				+ ((disassociateRoutingTableFromSubnet == null) ? 0 : disassociateRoutingTableFromSubnet.hashCode());
		result = prime * result + ((getAttachedInternetGatewayId == null) ? 0 : getAttachedInternetGatewayId.hashCode());
		result = prime * result + ((getInternetGatewayById == null) ? 0 : getInternetGatewayById.hashCode());
		result = prime * result + ((getNetworkInterface == null) ? 0 : getNetworkInterface.hashCode());
		result = prime * result + ((getRoutingTable == null) ? 0 : getRoutingTable.hashCode());
		result = prime * result + ((getRoutingTableForSubnet == null) ? 0 : getRoutingTableForSubnet.hashCode());
		result = prime * result + ((getRoutingTableForVlan == null) ? 0 : getRoutingTableForVlan.hashCode());
		result = prime * result + ((getSubnet == null) ? 0 : getSubnet.hashCode());
		result = prime * result + ((getVlan == null) ? 0 : getVlan.hashCode());
		result = prime * result + ((isConnectedViaInternetGateway == null) ? 0 : isConnectedViaInternetGateway.hashCode());
		result = prime * result
				+ ((isNetworkInterfaceSupportEnabled == null) ? 0 : isNetworkInterfaceSupportEnabled.hashCode());
		result = prime * result + ((listFirewallIdsForNIC == null) ? 0 : listFirewallIdsForNIC.hashCode());
		result = prime * result + ((listInternetGateways == null) ? 0 : listInternetGateways.hashCode());
		result = prime * result + ((listNetworkInterfaceStatus == null) ? 0 : listNetworkInterfaceStatus.hashCode());
		result = prime * result + ((listNetworkInterfaces == null) ? 0 : listNetworkInterfaces.hashCode());
		result = prime * result + ((listNetworkInterfacesForVM == null) ? 0 : listNetworkInterfacesForVM.hashCode());
		result = prime * result + ((listNetworkInterfacesInSubnet == null) ? 0 : listNetworkInterfacesInSubnet.hashCode());
		result = prime * result + ((listNetworkInterfacesInVLAN == null) ? 0 : listNetworkInterfacesInVLAN.hashCode());
		result = prime * result + ((listResources == null) ? 0 : listResources.hashCode());
		result = prime * result + ((listRoutingTablesForSubnet == null) ? 0 : listRoutingTablesForSubnet.hashCode());
		result = prime * result + ((listRoutingTablesForVlan == null) ? 0 : listRoutingTablesForVlan.hashCode());
		result = prime * result + ((listSubnets == null) ? 0 : listSubnets.hashCode());
		result = prime * result + ((listVlanStatus == null) ? 0 : listVlanStatus.hashCode());
		result = prime * result + ((listVlans == null) ? 0 : listVlans.hashCode());
		result = prime * result + ((removeInternetGateway == null) ? 0 : removeInternetGateway.hashCode());
		result = prime * result + ((removeInternetGatewayById == null) ? 0 : removeInternetGatewayById.hashCode());
		result = prime * result + ((removeInternetGatewayTags == null) ? 0 : removeInternetGatewayTags.hashCode());
		result = prime * result + ((removeNetworkInterface == null) ? 0 : removeNetworkInterface.hashCode());
		result = prime * result + ((removeRoute == null) ? 0 : removeRoute.hashCode());
		result = prime * result + ((removeRoutingTable == null) ? 0 : removeRoutingTable.hashCode());
		result = prime * result + ((removeRoutingTableTags == null) ? 0 : removeRoutingTableTags.hashCode());
		result = prime * result + ((removeSubnet == null) ? 0 : removeSubnet.hashCode());
		result = prime * result + ((removeSubnetTags == null) ? 0 : removeSubnetTags.hashCode());
		result = prime * result + ((removeVLANTags == null) ? 0 : removeVLANTags.hashCode());
		result = prime * result + ((removeVlan == null) ? 0 : removeVlan.hashCode());
		result = prime * result + ((setInternetGatewayTags == null) ? 0 : setInternetGatewayTags.hashCode());
		result = prime * result + ((setRoutingTableTags == null) ? 0 : setRoutingTableTags.hashCode());
		result = prime * result + ((setSubnetTags == null) ? 0 : setSubnetTags.hashCode());
		result = prime * result + ((setVLANTags == null) ? 0 : setVLANTags.hashCode());
		result = prime * result + ((updateInternetGatewayTags == null) ? 0 : updateInternetGatewayTags.hashCode());
		result = prime * result + ((updateRoutingTableTags == null) ? 0 : updateRoutingTableTags.hashCode());
		result = prime * result + ((updateSubnetTags == null) ? 0 : updateSubnetTags.hashCode());
		result = prime * result + ((updateVLANTags == null) ? 0 : updateVLANTags.hashCode());
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
		VLANConfiguration other = (VLANConfiguration) obj;
		if (addRouteToAddress == null) {
			if (other.addRouteToAddress != null)
				return false;
		} else if (!addRouteToAddress.equals(other.addRouteToAddress))
			return false;
		if (addRouteToGateway == null) {
			if (other.addRouteToGateway != null)
				return false;
		} else if (!addRouteToGateway.equals(other.addRouteToGateway))
			return false;
		if (addRouteToNetworkInterface == null) {
			if (other.addRouteToNetworkInterface != null)
				return false;
		} else if (!addRouteToNetworkInterface.equals(other.addRouteToNetworkInterface))
			return false;
		if (addRouteToVirtualMachine == null) {
			if (other.addRouteToVirtualMachine != null)
				return false;
		} else if (!addRouteToVirtualMachine.equals(other.addRouteToVirtualMachine))
			return false;
		if (assignRoutingTableToSubnet == null) {
			if (other.assignRoutingTableToSubnet != null)
				return false;
		} else if (!assignRoutingTableToSubnet.equals(other.assignRoutingTableToSubnet))
			return false;
		if (assignRoutingTableToVlan == null) {
			if (other.assignRoutingTableToVlan != null)
				return false;
		} else if (!assignRoutingTableToVlan.equals(other.assignRoutingTableToVlan))
			return false;
		if (attachNetworkInterface == null) {
			if (other.attachNetworkInterface != null)
				return false;
		} else if (!attachNetworkInterface.equals(other.attachNetworkInterface))
			return false;
		if (createInternetGateway == null) {
			if (other.createInternetGateway != null)
				return false;
		} else if (!createInternetGateway.equals(other.createInternetGateway))
			return false;
		if (createNetworkInterface == null) {
			if (other.createNetworkInterface != null)
				return false;
		} else if (!createNetworkInterface.equals(other.createNetworkInterface))
			return false;
		if (createRoutingTable == null) {
			if (other.createRoutingTable != null)
				return false;
		} else if (!createRoutingTable.equals(other.createRoutingTable))
			return false;
		if (createSubnet == null) {
			if (other.createSubnet != null)
				return false;
		} else if (!createSubnet.equals(other.createSubnet))
			return false;
		if (createVlan == null) {
			if (other.createVlan != null)
				return false;
		} else if (!createVlan.equals(other.createVlan))
			return false;
		if (detachNetworkInterface == null) {
			if (other.detachNetworkInterface != null)
				return false;
		} else if (!detachNetworkInterface.equals(other.detachNetworkInterface))
			return false;
		if (disassociateRoutingTableFromSubnet == null) {
			if (other.disassociateRoutingTableFromSubnet != null)
				return false;
		} else if (!disassociateRoutingTableFromSubnet.equals(other.disassociateRoutingTableFromSubnet))
			return false;
		if (getAttachedInternetGatewayId == null) {
			if (other.getAttachedInternetGatewayId != null)
				return false;
		} else if (!getAttachedInternetGatewayId.equals(other.getAttachedInternetGatewayId))
			return false;
		if (getInternetGatewayById == null) {
			if (other.getInternetGatewayById != null)
				return false;
		} else if (!getInternetGatewayById.equals(other.getInternetGatewayById))
			return false;
		if (getNetworkInterface == null) {
			if (other.getNetworkInterface != null)
				return false;
		} else if (!getNetworkInterface.equals(other.getNetworkInterface))
			return false;
		if (getRoutingTable == null) {
			if (other.getRoutingTable != null)
				return false;
		} else if (!getRoutingTable.equals(other.getRoutingTable))
			return false;
		if (getRoutingTableForSubnet == null) {
			if (other.getRoutingTableForSubnet != null)
				return false;
		} else if (!getRoutingTableForSubnet.equals(other.getRoutingTableForSubnet))
			return false;
		if (getRoutingTableForVlan == null) {
			if (other.getRoutingTableForVlan != null)
				return false;
		} else if (!getRoutingTableForVlan.equals(other.getRoutingTableForVlan))
			return false;
		if (getSubnet == null) {
			if (other.getSubnet != null)
				return false;
		} else if (!getSubnet.equals(other.getSubnet))
			return false;
		if (getVlan == null) {
			if (other.getVlan != null)
				return false;
		} else if (!getVlan.equals(other.getVlan))
			return false;
		if (isConnectedViaInternetGateway == null) {
			if (other.isConnectedViaInternetGateway != null)
				return false;
		} else if (!isConnectedViaInternetGateway.equals(other.isConnectedViaInternetGateway))
			return false;
		if (isNetworkInterfaceSupportEnabled == null) {
			if (other.isNetworkInterfaceSupportEnabled != null)
				return false;
		} else if (!isNetworkInterfaceSupportEnabled.equals(other.isNetworkInterfaceSupportEnabled))
			return false;
		if (listFirewallIdsForNIC == null) {
			if (other.listFirewallIdsForNIC != null)
				return false;
		} else if (!listFirewallIdsForNIC.equals(other.listFirewallIdsForNIC))
			return false;
		if (listInternetGateways == null) {
			if (other.listInternetGateways != null)
				return false;
		} else if (!listInternetGateways.equals(other.listInternetGateways))
			return false;
		if (listNetworkInterfaceStatus == null) {
			if (other.listNetworkInterfaceStatus != null)
				return false;
		} else if (!listNetworkInterfaceStatus.equals(other.listNetworkInterfaceStatus))
			return false;
		if (listNetworkInterfaces == null) {
			if (other.listNetworkInterfaces != null)
				return false;
		} else if (!listNetworkInterfaces.equals(other.listNetworkInterfaces))
			return false;
		if (listNetworkInterfacesForVM == null) {
			if (other.listNetworkInterfacesForVM != null)
				return false;
		} else if (!listNetworkInterfacesForVM.equals(other.listNetworkInterfacesForVM))
			return false;
		if (listNetworkInterfacesInSubnet == null) {
			if (other.listNetworkInterfacesInSubnet != null)
				return false;
		} else if (!listNetworkInterfacesInSubnet.equals(other.listNetworkInterfacesInSubnet))
			return false;
		if (listNetworkInterfacesInVLAN == null) {
			if (other.listNetworkInterfacesInVLAN != null)
				return false;
		} else if (!listNetworkInterfacesInVLAN.equals(other.listNetworkInterfacesInVLAN))
			return false;
		if (listResources == null) {
			if (other.listResources != null)
				return false;
		} else if (!listResources.equals(other.listResources))
			return false;
		if (listRoutingTablesForSubnet == null) {
			if (other.listRoutingTablesForSubnet != null)
				return false;
		} else if (!listRoutingTablesForSubnet.equals(other.listRoutingTablesForSubnet))
			return false;
		if (listRoutingTablesForVlan == null) {
			if (other.listRoutingTablesForVlan != null)
				return false;
		} else if (!listRoutingTablesForVlan.equals(other.listRoutingTablesForVlan))
			return false;
		if (listSubnets == null) {
			if (other.listSubnets != null)
				return false;
		} else if (!listSubnets.equals(other.listSubnets))
			return false;
		if (listVlanStatus == null) {
			if (other.listVlanStatus != null)
				return false;
		} else if (!listVlanStatus.equals(other.listVlanStatus))
			return false;
		if (listVlans == null) {
			if (other.listVlans != null)
				return false;
		} else if (!listVlans.equals(other.listVlans))
			return false;
		if (removeInternetGateway == null) {
			if (other.removeInternetGateway != null)
				return false;
		} else if (!removeInternetGateway.equals(other.removeInternetGateway))
			return false;
		if (removeInternetGatewayById == null) {
			if (other.removeInternetGatewayById != null)
				return false;
		} else if (!removeInternetGatewayById.equals(other.removeInternetGatewayById))
			return false;
		if (removeInternetGatewayTags == null) {
			if (other.removeInternetGatewayTags != null)
				return false;
		} else if (!removeInternetGatewayTags.equals(other.removeInternetGatewayTags))
			return false;
		if (removeNetworkInterface == null) {
			if (other.removeNetworkInterface != null)
				return false;
		} else if (!removeNetworkInterface.equals(other.removeNetworkInterface))
			return false;
		if (removeRoute == null) {
			if (other.removeRoute != null)
				return false;
		} else if (!removeRoute.equals(other.removeRoute))
			return false;
		if (removeRoutingTable == null) {
			if (other.removeRoutingTable != null)
				return false;
		} else if (!removeRoutingTable.equals(other.removeRoutingTable))
			return false;
		if (removeRoutingTableTags == null) {
			if (other.removeRoutingTableTags != null)
				return false;
		} else if (!removeRoutingTableTags.equals(other.removeRoutingTableTags))
			return false;
		if (removeSubnet == null) {
			if (other.removeSubnet != null)
				return false;
		} else if (!removeSubnet.equals(other.removeSubnet))
			return false;
		if (removeSubnetTags == null) {
			if (other.removeSubnetTags != null)
				return false;
		} else if (!removeSubnetTags.equals(other.removeSubnetTags))
			return false;
		if (removeVLANTags == null) {
			if (other.removeVLANTags != null)
				return false;
		} else if (!removeVLANTags.equals(other.removeVLANTags))
			return false;
		if (removeVlan == null) {
			if (other.removeVlan != null)
				return false;
		} else if (!removeVlan.equals(other.removeVlan))
			return false;
		if (setInternetGatewayTags == null) {
			if (other.setInternetGatewayTags != null)
				return false;
		} else if (!setInternetGatewayTags.equals(other.setInternetGatewayTags))
			return false;
		if (setRoutingTableTags == null) {
			if (other.setRoutingTableTags != null)
				return false;
		} else if (!setRoutingTableTags.equals(other.setRoutingTableTags))
			return false;
		if (setSubnetTags == null) {
			if (other.setSubnetTags != null)
				return false;
		} else if (!setSubnetTags.equals(other.setSubnetTags))
			return false;
		if (setVLANTags == null) {
			if (other.setVLANTags != null)
				return false;
		} else if (!setVLANTags.equals(other.setVLANTags))
			return false;
		if (updateInternetGatewayTags == null) {
			if (other.updateInternetGatewayTags != null)
				return false;
		} else if (!updateInternetGatewayTags.equals(other.updateInternetGatewayTags))
			return false;
		if (updateRoutingTableTags == null) {
			if (other.updateRoutingTableTags != null)
				return false;
		} else if (!updateRoutingTableTags.equals(other.updateRoutingTableTags))
			return false;
		if (updateSubnetTags == null) {
			if (other.updateSubnetTags != null)
				return false;
		} else if (!updateSubnetTags.equals(other.updateSubnetTags))
			return false;
		if (updateVLANTags == null) {
			if (other.updateVLANTags != null)
				return false;
		} else if (!updateVLANTags.equals(other.updateVLANTags))
			return false;
		return true;
	}

}
