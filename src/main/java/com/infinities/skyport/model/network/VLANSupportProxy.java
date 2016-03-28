package com.infinities.skyport.model.network;

import java.io.Serializable;

import org.dasein.cloud.CloudException;
import org.dasein.cloud.InternalException;
import org.dasein.cloud.ResourceStatus;
import org.dasein.cloud.Tag;
import org.dasein.cloud.identity.ServiceAction;
import org.dasein.cloud.network.IPVersion;
import org.dasein.cloud.network.InternetGateway;
import org.dasein.cloud.network.NICCreateOptions;
import org.dasein.cloud.network.NetworkInterface;
import org.dasein.cloud.network.Networkable;
import org.dasein.cloud.network.Route;
import org.dasein.cloud.network.RoutingTable;
import org.dasein.cloud.network.Subnet;
import org.dasein.cloud.network.SubnetCreateOptions;
import org.dasein.cloud.network.VLAN;
import org.dasein.cloud.network.VLANCapabilities;
import org.dasein.cloud.network.VlanCreateOptions;

import com.infinities.skyport.async.AsyncResult;
import com.infinities.skyport.async.service.network.AsyncVLANSupport;
import com.infinities.skyport.network.NICAttachOptions;
import com.infinities.skyport.network.NICDetachOptions;
import com.infinities.skyport.network.SkyportVLANSupport;

public class VLANSupportProxy implements AsyncVLANSupport, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final AsyncVLANSupport support;


	public VLANSupportProxy(AsyncVLANSupport support) {
		this.support = support;
	}

	@Override
	public String[] mapServiceAction(ServiceAction action) {
		return support.mapServiceAction(action);
	}

	@Override
	public AsyncResult<Route> addRouteToAddress(String routingTableId, IPVersion version, String destinationCidr,
			String address) throws CloudException, InternalException {
		return support.addRouteToAddress(routingTableId, version, destinationCidr, address);
	}

	@Override
	public AsyncResult<Route> addRouteToGateway(String routingTableId, IPVersion version, String destinationCidr,
			String gatewayId) throws CloudException, InternalException {
		return support.addRouteToGateway(routingTableId, version, destinationCidr, gatewayId);
	}

	@Override
	public AsyncResult<Route> addRouteToNetworkInterface(String routingTableId, IPVersion version,
			String destinationCidr, String nicId) throws CloudException, InternalException {
		return support.addRouteToNetworkInterface(routingTableId, version, destinationCidr, nicId);
	}

	@Override
	public AsyncResult<Route> addRouteToVirtualMachine(String routingTableId, IPVersion version, String destinationCidr,
			String vmId) throws CloudException, InternalException {
		return support.addRouteToVirtualMachine(routingTableId, version, destinationCidr, vmId);
	}

	@Override
	public AsyncResult<Void> assignRoutingTableToSubnet(String subnetId, String routingTableId)
			throws CloudException, InternalException {
		return support.assignRoutingTableToSubnet(subnetId, routingTableId);
	}

	@Override
	public AsyncResult<Void> disassociateRoutingTableFromSubnet(String subnetId, String routingTableId)
			throws CloudException, InternalException {
		return support.disassociateRoutingTableFromSubnet(subnetId, routingTableId);
	}

	@Override
	public AsyncResult<Void> assignRoutingTableToVlan(String vlanId, String routingTableId)
			throws CloudException, InternalException {
		return support.assignRoutingTableToVlan(vlanId, routingTableId);
	}

	@Override
	public AsyncResult<String> createInternetGateway(String vlanId) throws CloudException, InternalException {
		return support.createInternetGateway(vlanId);
	}

	@Override
	public AsyncResult<String> createRoutingTable(String vlanId, String name, String description)
			throws CloudException, InternalException {
		return support.createRoutingTable(vlanId, name, description);
	}

	@Override
	public AsyncResult<NetworkInterface> createNetworkInterface(NICCreateOptions options)
			throws CloudException, InternalException {
		return support.createNetworkInterface(options);
	}

	@Override
	public AsyncResult<Subnet> createSubnet(SubnetCreateOptions options) throws CloudException, InternalException {
		return support.createSubnet(options);
	}

	@Override
	public AsyncResult<VLAN> createVlan(String cidr, String name, String description, String domainName,
			String[] dnsServers, String[] ntpServers) throws CloudException, InternalException {
		return support.createVlan(cidr, name, description, domainName, dnsServers, ntpServers);
	}

	@Override
	public AsyncResult<VLAN> createVlan(VlanCreateOptions options) throws InternalException, CloudException {
		return support.createVlan(options);
	}

	@Override
	public VLANCapabilities getCapabilities() throws CloudException, InternalException {
		return support.getCapabilities();
	}

	@Override
	public AsyncResult<NetworkInterface> getNetworkInterface(String nicId) throws CloudException, InternalException {
		return support.getNetworkInterface(nicId);
	}

	@Override
	public AsyncResult<RoutingTable> getRoutingTableForSubnet(String subnetId)
			throws CloudException, InternalException {
		return support.getRoutingTableForSubnet(subnetId);
	}

	@Override
	public AsyncResult<RoutingTable> getRoutingTableForVlan(String vlanId) throws CloudException, InternalException {
		return support.getRoutingTableForVlan(vlanId);
	}

	@Override
	public AsyncResult<RoutingTable> getRoutingTable(String id) throws CloudException, InternalException {
		return support.getRoutingTable(id);
	}

	@Override
	public AsyncResult<Subnet> getSubnet(String subnetId) throws CloudException, InternalException {
		return support.getSubnet(subnetId);
	}

	@Override
	public AsyncResult<VLAN> getVlan(String vlanId) throws CloudException, InternalException {
		return support.getVlan(vlanId);
	}

	@Override
	public AsyncResult<Boolean> isConnectedViaInternetGateway(String vlanId) throws CloudException, InternalException {
		return support.isConnectedViaInternetGateway(vlanId);
	}

	@Override
	public AsyncResult<String> getAttachedInternetGatewayId(String vlanId) throws CloudException, InternalException {
		return support.getAttachedInternetGatewayId(vlanId);
	}

	@Override
	public AsyncResult<InternetGateway> getInternetGatewayById(String gatewayId)
			throws CloudException, InternalException {
		return support.getInternetGatewayById(gatewayId);
	}

	@Override
	public boolean isNetworkInterfaceSupportEnabled() throws CloudException, InternalException {
		return support.isNetworkInterfaceSupportEnabled();
	}

	@Override
	public boolean isSubscribed() throws CloudException, InternalException {
		return support.isSubscribed();
	}

	@Override
	public AsyncResult<Iterable<String>> listFirewallIdsForNIC(String nicId) throws CloudException, InternalException {
		return support.listFirewallIdsForNIC(nicId);
	}

	@Override
	public AsyncResult<Iterable<InternetGateway>> listInternetGateways(String vlanId)
			throws CloudException, InternalException {
		return support.listInternetGateways(vlanId);
	}

	@Override
	public AsyncResult<Iterable<ResourceStatus>> listNetworkInterfaceStatus() throws CloudException, InternalException {
		return support.listNetworkInterfaceStatus();
	}

	@Override
	public AsyncResult<Iterable<NetworkInterface>> listNetworkInterfaces() throws CloudException, InternalException {
		return support.listNetworkInterfaces();
	}

	@Override
	public AsyncResult<Iterable<NetworkInterface>> listNetworkInterfacesForVM(String forVmId)
			throws CloudException, InternalException {
		return support.listNetworkInterfacesForVM(forVmId);
	}

	@Override
	public AsyncResult<Iterable<NetworkInterface>> listNetworkInterfacesInSubnet(String subnetId)
			throws CloudException, InternalException {
		return support.listNetworkInterfacesInSubnet(subnetId);
	}

	@Override
	public AsyncResult<Iterable<NetworkInterface>> listNetworkInterfacesInVLAN(String vlanId)
			throws CloudException, InternalException {
		return support.listNetworkInterfacesInVLAN(vlanId);
	}

	@Override
	public AsyncResult<Iterable<Networkable>> listResources(String vlanId) throws CloudException, InternalException {
		return support.listResources(vlanId);
	}

	@Override
	public AsyncResult<Iterable<RoutingTable>> listRoutingTablesForSubnet(String subnetId)
			throws CloudException, InternalException {
		return support.listRoutingTablesForSubnet(subnetId);
	}

	@Override
	public AsyncResult<Iterable<RoutingTable>> listRoutingTablesForVlan(String vlanId)
			throws CloudException, InternalException {
		return support.listRoutingTablesForVlan(vlanId);
	}

	@Override
	public AsyncResult<Iterable<Subnet>> listSubnets(String vlanId) throws CloudException, InternalException {
		return support.listSubnets(vlanId);
	}

	@Override
	public AsyncResult<Iterable<ResourceStatus>> listVlanStatus() throws CloudException, InternalException {
		return support.listVlanStatus();
	}

	@Override
	public AsyncResult<Iterable<VLAN>> listVlans() throws CloudException, InternalException {
		return support.listVlans();
	}

	@Override
	public AsyncResult<Void> removeInternetGateway(String forVlanId) throws CloudException, InternalException {
		return support.removeInternetGateway(forVlanId);
	}

	@Override
	public AsyncResult<Void> removeInternetGatewayById(String id) throws CloudException, InternalException {
		return support.removeInternetGatewayById(id);
	}

	@Override
	public AsyncResult<Void> removeInternetGatewayTags(String internetGatewayId, Tag... tags)
			throws CloudException, InternalException {
		return support.removeInternetGatewayTags(internetGatewayId, tags);
	}

	@Override
	public AsyncResult<Void> removeInternetGatewayTags(String[] internetGatewayIds, Tag... tags)
			throws CloudException, InternalException {
		return support.removeInternetGatewayTags(internetGatewayIds, tags);
	}

	@Override
	public AsyncResult<Void> removeNetworkInterface(String nicId) throws CloudException, InternalException {
		return support.removeNetworkInterface(nicId);
	}

	@Override
	public AsyncResult<Void> removeRoute(String routingTableId, String destinationCidr)
			throws CloudException, InternalException {
		return support.removeRoute(routingTableId, destinationCidr);
	}

	@Override
	public AsyncResult<Void> removeRoutingTable(String routingTableId) throws CloudException, InternalException {
		return support.removeRoutingTable(routingTableId);
	}

	@Override
	public AsyncResult<Void> removeRoutingTableTags(String routingTableId, Tag... tags)
			throws CloudException, InternalException {
		return support.removeRoutingTableTags(routingTableId, tags);
	}

	@Override
	public AsyncResult<Void> removeRoutingTableTags(String[] routingTableIds, Tag... tags)
			throws CloudException, InternalException {
		return support.removeRoutingTableTags(routingTableIds, tags);
	}

	@Override
	public AsyncResult<Void> removeSubnet(String providerSubnetId) throws CloudException, InternalException {
		return support.removeSubnet(providerSubnetId);
	}

	@Override
	public AsyncResult<Void> removeSubnetTags(String subnetId, Tag... tags) throws CloudException, InternalException {
		return support.removeSubnetTags(subnetId, tags);
	}

	@Override
	public AsyncResult<Void> removeSubnetTags(String[] subnetIds, Tag... tags)
			throws CloudException, InternalException {
		return support.removeSubnetTags(subnetIds, tags);
	}

	@Override
	public AsyncResult<Void> setSubnetTags(String subnetId, Tag... tags) throws CloudException, InternalException {
		return support.setSubnetTags(subnetId, tags);
	}

	@Override
	public AsyncResult<Void> setSubnetTags(String[] subnetIds, Tag... tags) throws CloudException, InternalException {
		return support.setSubnetTags(subnetIds, tags);
	}

	@Override
	public AsyncResult<Void> removeVlan(String vlanId) throws CloudException, InternalException {
		return support.removeVlan(vlanId);
	}

	@Override
	public AsyncResult<Void> removeVLANTags(String vlanId, Tag... tags) throws CloudException, InternalException {
		return support.removeVLANTags(vlanId, tags);
	}

	@Override
	public AsyncResult<Void> removeVLANTags(String[] vlanIds, Tag... tags) throws CloudException, InternalException {
		return support.removeVLANTags(vlanIds, tags);
	}

	@Override
	public AsyncResult<Void> updateSubnetTags(String subnetId, Tag... tags) throws CloudException, InternalException {
		return support.updateSubnetTags(subnetId, tags);
	}

	@Override
	public AsyncResult<Void> updateSubnetTags(String[] subnetIds, Tag... tags)
			throws CloudException, InternalException {
		return support.updateSubnetTags(subnetIds, tags);
	}

	@Override
	public AsyncResult<Void> updateRoutingTableTags(String routingTableId, Tag... tags)
			throws CloudException, InternalException {
		return support.updateRoutingTableTags(routingTableId, tags);
	}

	@Override
	public AsyncResult<Void> updateRoutingTableTags(String[] routingTableIds, Tag... tags)
			throws CloudException, InternalException {
		return support.updateRoutingTableTags(routingTableIds, tags);
	}

	@Override
	public AsyncResult<Void> setRoutingTableTags(String routingTableId, Tag... tags)
			throws CloudException, InternalException {
		return support.setRoutingTableTags(routingTableId, tags);
	}

	@Override
	public AsyncResult<Void> setRoutingTableTags(String[] routingTableIds, Tag... tags)
			throws CloudException, InternalException {
		return support.setRoutingTableTags(routingTableIds, tags);
	}

	@Override
	public AsyncResult<Void> setVLANTags(String vlanId, Tag... tags) throws CloudException, InternalException {
		return support.setVLANTags(vlanId, tags);
	}

	@Override
	public AsyncResult<Void> setVLANTags(String[] vlanIds, Tag... tags) throws CloudException, InternalException {
		return support.setVLANTags(vlanIds, tags);
	}

	@Override
	public AsyncResult<Void> updateVLANTags(String vlanId, Tag... tags) throws CloudException, InternalException {
		return support.updateVLANTags(vlanId, tags);
	}

	@Override
	public AsyncResult<Void> updateVLANTags(String[] vlanIds, Tag... tags) throws CloudException, InternalException {
		return support.updateVLANTags(vlanIds, tags);
	}

	@Override
	public AsyncResult<Void> updateInternetGatewayTags(String internetGatewayId, Tag... tags)
			throws CloudException, InternalException {
		return support.updateInternetGatewayTags(internetGatewayId, tags);
	}

	@Override
	public AsyncResult<Void> updateInternetGatewayTags(String[] internetGatewayIds, Tag... tags)
			throws CloudException, InternalException {
		return support.updateInternetGatewayTags(internetGatewayIds, tags);
	}

	@Override
	public AsyncResult<Void> setInternetGatewayTags(String internetGatewayId, Tag... tags)
			throws CloudException, InternalException {
		return support.setInternetGatewayTags(internetGatewayId, tags);
	}

	@Override
	public AsyncResult<Void> setInternetGatewayTags(String[] internetGatewayIds, Tag... tags)
			throws CloudException, InternalException {
		return support.setInternetGatewayTags(internetGatewayIds, tags);
	}

	@Override
	public SkyportVLANSupport getSupport() {
		return support.getSupport();
	}

	@Override
	public AsyncResult<String> attachNetworkInterface(NICAttachOptions options)
			throws CloudException, InternalException {
		return support.attachNetworkInterface(options);
	}

	@Override
	public AsyncResult<Void> detachNetworkInterface(NICDetachOptions options) throws CloudException, InternalException {
		return support.detachNetworkInterface(options);
	}

}
