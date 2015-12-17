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
package com.infinities.skyport.async.service.network;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.dasein.cloud.AccessControlledService;
import org.dasein.cloud.CloudException;
import org.dasein.cloud.InternalException;
import org.dasein.cloud.OperationNotSupportedException;
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
import org.dasein.cloud.network.VLANSupport;
import org.dasein.cloud.network.VlanCreateOptions;

import com.infinities.skyport.async.AsyncResult;

public interface AsyncVLANSupport extends AccessControlledService {

	static public final ServiceAction ANY = new ServiceAction("NET:ANY");

	static public final ServiceAction ADD_ROUTE = new ServiceAction("NET:ADD_ROUTE");
	static public final ServiceAction ASSIGN_ROUTE_TO_SUBNET = new ServiceAction("NET:ASSIGN_ROUTE_TO_SUBNET");
	static public final ServiceAction ASSIGN_ROUTE_TO_VLAN = new ServiceAction("NET:ASSIGN_ROUTE_TO_VLAN");
	static public final ServiceAction ATTACH_INTERNET_GATEWAY = new ServiceAction("NET:ATTACH_INTERNET_GATEWAY");
	static public final ServiceAction CREATE_ROUTING_TABLE = new ServiceAction("NET:CREATE_ROUTING_TABLE");
	static public final ServiceAction CREATE_INTERNET_GATEWAY = new ServiceAction("NET:CREATE_INTERNET_GATEWAY");
	static public final ServiceAction GET_ROUTING_TABLE = new ServiceAction("NET:GET_ROUTING_TABLE");
	static public final ServiceAction LIST_ROUTING_TABLE = new ServiceAction("NET:LIST_ROUTING_TABLE");
	static public final ServiceAction REMOVE_INTERNET_GATEWAY = new ServiceAction("NET:REMOVE_INTERNET_GATEWAY");
	static public final ServiceAction REMOVE_ROUTE = new ServiceAction("NET:REMOVE_ROUTE");
	static public final ServiceAction REMOVE_ROUTING_TABLE = new ServiceAction("NET:REMOVE_ROUTING_TABLE");

	static public final ServiceAction ATTACH_NIC = new ServiceAction("NET:ATTACH_NIC");
	static public final ServiceAction CREATE_NIC = new ServiceAction("NET:CREATE_NIC");
	static public final ServiceAction DETACH_NIC = new ServiceAction("NET:DETACH_NIC");
	static public final ServiceAction GET_NIC = new ServiceAction("NET:GET_NIC");
	static public final ServiceAction LIST_NIC = new ServiceAction("NET:LIST_NIC");
	static public final ServiceAction REMOVE_NIC = new ServiceAction("NET:REMOVE_NIC");

	static public final ServiceAction CREATE_SUBNET = new ServiceAction("NET:CREATE_SUBNET");
	static public final ServiceAction CREATE_VLAN = new ServiceAction("NET:CREATE_VLAN");
	static public final ServiceAction GET_SUBNET = new ServiceAction("NET:GET_SUBNET");
	static public final ServiceAction GET_VLAN = new ServiceAction("NET:GET_VLAN");
	static public final ServiceAction LIST_SUBNET = new ServiceAction("NET:LIST_SUBNET");
	static public final ServiceAction LIST_VLAN = new ServiceAction("NET:LIST_VLAN");
	static public final ServiceAction REMOVE_SUBNET = new ServiceAction("NET:REMOVE_SUBNET");
	static public final ServiceAction REMOVE_VLAN = new ServiceAction("NET:REMOVE_VLAN");


	/**
	 * Adds the specified route to the specified routing table.
	 * 
	 * @param routingTableId
	 *            the routing table to which the route will be added
	 * @param version
	 *            ipv4 or ipv6
	 * @param destinationCidr
	 *            the destination IP address or CIDR, or null if setting the
	 *            default route
	 * @param address
	 *            the IP address to which the traffic is being routed
	 * @throws CloudException
	 *             an error occurred in the cloud while adding the route to the
	 *             routing table
	 * @throws InternalException
	 *             a local error occurred processing the request to add the
	 *             route
	 */
	public AsyncResult<Route> addRouteToAddress(@Nonnull String routingTableId, @Nonnull IPVersion version,
			@Nullable String destinationCidr, @Nonnull String address) throws CloudException, InternalException;

	/**
	 * Adds the specified route to the specified routing table.
	 * 
	 * @param routingTableId
	 *            the routing table to which the route will be added
	 * @param version
	 *            ipv4 or ipv6
	 * @param destinationCidr
	 *            the destination IP address or CIDR, or null if setting the
	 *            default route
	 * @param gatewayId
	 *            the ID of a known gateway
	 * @throws CloudException
	 *             an error occurred in the cloud while adding the route to the
	 *             routing table
	 * @throws InternalException
	 *             a local error occurred processing the request to add the
	 *             route
	 */
	public AsyncResult<Route> addRouteToGateway(@Nonnull String routingTableId, @Nonnull IPVersion version,
			@Nullable String destinationCidr, @Nonnull String gatewayId) throws CloudException, InternalException;

	/**
	 * Adds the specified route to the specified routing table.
	 * 
	 * @param routingTableId
	 *            the routing table to which the route will be added
	 * @param version
	 *            ipv4 or ipv6
	 * @param destinationCidr
	 *            the destination IP address or CIDR, or null if setting the
	 *            default route
	 * @param nicId
	 *            the ID of a known network interface
	 * @throws CloudException
	 *             an error occurred in the cloud while adding the route to the
	 *             routing table
	 * @throws InternalException
	 *             a local error occurred processing the request to add the
	 *             route
	 */
	public AsyncResult<Route> addRouteToNetworkInterface(@Nonnull String routingTableId, @Nonnull IPVersion version,
			@Nullable String destinationCidr, @Nonnull String nicId) throws CloudException, InternalException;

	/**
	 * Adds the specified route to the specified routing table.
	 * 
	 * @param routingTableId
	 *            the routing table to which the route will be added
	 * @param version
	 *            ipv4 or ipv6
	 * @param destinationCidr
	 *            the destination IP address or CIDR, or null if setting the
	 *            default route
	 * @param vmId
	 *            the unique ID of the virtual machine to which traffic is being
	 *            routed
	 * @throws CloudException
	 *             an error occurred in the cloud while adding the route to the
	 *             routing table
	 * @throws InternalException
	 *             a local error occurred processing the request to add the
	 *             route
	 */
	public AsyncResult<Route> addRouteToVirtualMachine(@Nonnull String routingTableId, @Nonnull IPVersion version,
			@Nullable String destinationCidr, @Nonnull String vmId) throws CloudException, InternalException;

	/**
	 * Assigns the specified routing table to the target subnet.
	 * 
	 * @param subnetId
	 *            the unique ID of the subnet being assigned the routing table
	 * @param routingTableId
	 *            the routing table to which the subnet is being assigned
	 * @throws CloudException
	 *             an error occurred with the cloud provider assigning the
	 *             routing table
	 * @throws InternalException
	 *             a local error occurred while processing the request
	 */
	public AsyncResult<Void> assignRoutingTableToSubnet(@Nonnull String subnetId, @Nonnull String routingTableId)
			throws CloudException, InternalException;

	/**
	 * Disassociates the specified routing table from the target subnet.
	 * 
	 * @param subnetId
	 *            the unique ID of the subnet being disassociated from the
	 *            routing table
	 * @param routingTableId
	 *            the routing table from which the subnet is being disassociated
	 * @throws CloudException
	 *             an error occurred with the cloud provider disassociating the
	 *             routing table
	 * @throws InternalException
	 *             a local error occurred while processing the request
	 */
	public AsyncResult<Void> disassociateRoutingTableFromSubnet(@Nonnull String subnetId, @Nonnull String routingTableId)
			throws CloudException, InternalException;

	/**
	 * Assigns the specified routing table to the target VLAN (or makes it the
	 * main routing table among the routing tables)
	 * 
	 * @param vlanId
	 *            the VLAN to which the routing table is being assigned
	 * @param routingTableId
	 *            the unique ID of the routing table being assigned
	 * @throws CloudException
	 *             an error occurred with the cloud provider assigning the
	 *             routing table
	 * @throws InternalException
	 *             a local error occurred while processing the request
	 */
	public AsyncResult<Void> assignRoutingTableToVlan(@Nonnull String vlanId, @Nonnull String routingTableId)
			throws CloudException, InternalException;

	/**
	 * Attaches a network interface to an existing virtual machine.
	 * 
	 * @param nicId
	 *            the unique ID of the network interface to attach
	 * @param vmId
	 *            the virtual machine to which the network interface should be
	 *            attached
	 * @param index
	 *            the 1-based index (-1 meaning at the end) for the attached
	 *            interface
	 * @throws CloudException
	 *             an error occurred with the cloud provider attaching the
	 *             interface
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud implementation
	 *             attaching the interface
	 */
	public AsyncResult<Void> attachNetworkInterface(@Nonnull String nicId, @Nonnull String vmId, int index)
			throws CloudException, InternalException;

	/**
	 * Creates an Internet gateway for the specified VLAN. This method makes
	 * sense only if the cloud supports enabling Internet routing from VLANs.
	 * 
	 * @param vlanId
	 *            the unique ID of the VLAN to create an Internet gateway for
	 * @return an ID of the newly created gateway in clouds that allow gateway
	 *         tracking, or null if gateways are not tracked
	 * @throws CloudException
	 *             an error occurred in the cloud while setting up the Internet
	 *             gateway
	 * @throws InternalException
	 *             a local error occurred while setting up the Internet gateway
	 * @throws OperationNotSupportedException
	 *             this cloud does not allow enabling Internet routing from
	 *             VLANs either because all VLANs are automatically routed or
	 *             are never routed
	 */
	public @Nullable AsyncResult<String> createInternetGateway(@Nonnull String vlanId) throws CloudException,
			InternalException;

	/**
	 * Creates a new routing table for the target VLAN.
	 * 
	 * @param vlanId
	 *            the VLAN for which a routing table is being created
	 * @param name
	 *            the name of the new routing table
	 * @param description
	 *            a description for the new routing table
	 * @return a unique ID within the cloud for the specified routing table
	 * @throws CloudException
	 *             an error occurred with the cloud provider while creating the
	 *             routing table
	 * @throws InternalException
	 *             a local error occurred creating the routing table
	 */
	public @Nonnull AsyncResult<String> createRoutingTable(@Nonnull String vlanId, @Nonnull String name,
			@Nonnull String description) throws CloudException, InternalException;

	/**
	 * Provisions a new network interface in accordance with the specified
	 * create options.
	 * 
	 * @param options
	 *            the options to be used in creating the network interface
	 * @return the newly provisioned network interface
	 * @throws CloudException
	 *             an error occurred in the cloud while provisioning the
	 *             interface
	 * @throws InternalException
	 *             a local error occurred during the provisoning of the
	 *             interface
	 * @throws OperationNotSupportedException
	 *             if {@link #allowsNewNetworkInterfaceCreation()} is false
	 */
	public @Nonnull AsyncResult<NetworkInterface> createNetworkInterface(@Nonnull NICCreateOptions options)
			throws CloudException, InternalException;

	/**
	 * Provisions a subnet with the specified options for subnet creation.
	 * 
	 * @param options
	 *            the options to be used in provisioning the subnet
	 * @return a newly provisioned subnet
	 * @throws CloudException
	 *             an error occurred in the cloud while provisioning the subnet
	 * @throws InternalException
	 *             a local error occurred during the provisoning of the subnet
	 */
	public @Nonnull AsyncResult<Subnet> createSubnet(@Nonnull SubnetCreateOptions options) throws CloudException,
			InternalException;

	public @Nonnull AsyncResult<VLAN> createVlan(@Nonnull String cidr, @Nonnull String name, @Nonnull String description,
			@Nonnull String domainName, @Nonnull String[] dnsServers, @Nonnull String[] ntpServers) throws CloudException,
			InternalException;

	/**
	 * Creates a new vlan based on the specified creation options.
	 * 
	 * @param options
	 *            the options to be used in creating the vlan
	 * @return the unique provider ID identifying the newly created vlan
	 * @throws CloudException
	 *             an error occurred with the cloud provider while performing
	 *             the operation
	 * @throws InternalException
	 *             an error occurred locally independent of any events in the
	 *             cloud
	 * @throws UnsupportedOperationException
	 *             this cloud doesn't support vlan creation using the specified
	 *             options
	 */
	public @Nonnull AsyncResult<VLAN> createVlan(@Nonnull VlanCreateOptions options) throws InternalException,
			CloudException;

	/**
	 * Detaches the specified network interface from any virtual machine it
	 * might be attached to.
	 * 
	 * @param nicId
	 *            the unique ID of the network interface to be detached
	 * @throws CloudException
	 *             an error occurred with the cloud provider while detaching the
	 *             network interface
	 * @throws InternalException
	 *             a local error occurred while detaching the network interface
	 */
	public AsyncResult<Void> detachNetworkInterface(@Nonnull String nicId) throws CloudException, InternalException;

	/**
	 * Provides access to meta-data about VLAN capabilities in the current
	 * region of this cloud.
	 * 
	 * @return a description of the features supported by this region of this
	 *         cloud
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 */
	public VLANCapabilities getCapabilities() throws CloudException, InternalException;

	/**
	 * Fetches the network interfaced specified by the unique network interface
	 * ID.
	 * 
	 * @param nicId
	 *            the unique ID of the desired network interface
	 * @return the network interface that matches the specified ID
	 * @throws CloudException
	 *             an error occurred in the cloud provider fetching the desired
	 *             network interface
	 * @throws InternalException
	 *             a local error occurred while fetching the desired network
	 *             interface
	 */
	public @Nullable AsyncResult<NetworkInterface> getNetworkInterface(@Nonnull String nicId) throws CloudException,
			InternalException;

	/**
	 * Identifies the routing table that contains the routes for the subnet.
	 * 
	 * @param subnetId
	 *            the unique ID of the subnet for which you are attempting to
	 *            identify a routing table
	 * @return the matching routing table or <code>null</code> if the cloud
	 *         doesn't support routing tables
	 * @throws CloudException
	 *             an error occurred loading the routing table for the specified
	 *             subnet
	 * @throws InternalException
	 *             a local error occurred identifying the routing table
	 * @throws OperationNotSupportedException
	 *             the cloud does not support subnets
	 */
	public @Nullable AsyncResult<RoutingTable> getRoutingTableForSubnet(@Nonnull String subnetId) throws CloudException,
			InternalException;

	/**
	 * Identifies the routing table that supports the routes for the VLAN (when
	 * subnets are not supported) or the main/default routing table for subnets
	 * within the VLAN (when subnets are supported).
	 * 
	 * @param vlanId
	 *            the VLAN ID of the VLAN whose routing table is being sought
	 * @return the matching routing table or <code>null</code> if the cloud
	 *         doesn't support routing tables
	 * @throws CloudException
	 *             an error occurred loading the routing table for the specified
	 *             VLAN
	 * @throws InternalException
	 *             a local error occurred identifying the routing table
	 */
	public @Nullable AsyncResult<RoutingTable> getRoutingTableForVlan(@Nonnull String vlanId) throws CloudException,
			InternalException;

	/**
	 * Identifies the routing table that matches the provided id.
	 * 
	 * @param id
	 *            the id of the route table
	 * @return the matching routing table or <code>null</code> if the cloud
	 *         doesn't support routing tables or no routing table is found
	 * @throws CloudException
	 *             an error occurred loading the routing table
	 * @throws InternalException
	 *             a local error occurred identifying the routing table
	 */
	public @Nullable AsyncResult<RoutingTable> getRoutingTable(@Nonnull String id) throws CloudException, InternalException;

	public @Nullable AsyncResult<Subnet> getSubnet(@Nonnull String subnetId) throws CloudException, InternalException;

	public @Nullable AsyncResult<VLAN> getVlan(@Nonnull String vlanId) throws CloudException, InternalException;

	/**
	 * Indicates whether or not the specified VLAN is connected to the public
	 * Internet via an Internet Gateway. A false response does not mean that the
	 * VLAN is not connected to the public Internet, it just means that, if it
	 * is connected, it's not connected via an Internet Gateway.
	 * 
	 * @param vlanId
	 *            the VLAN you are checking
	 * @return <code>true</code> if the VLAN is connected to the public Internet
	 *         via an Internet Gateway
	 * @throws CloudException
	 *             an error occurred with the cloud provider
	 * @throws InternalException
	 *             a local error occurred
	 */
	public AsyncResult<Boolean> isConnectedViaInternetGateway(@Nonnull String vlanId) throws CloudException,
			InternalException;

	/**
	 * Gets an attached Internet Gateway ID for specified VLAN. If null then no
	 * gateway attached to VLAN.
	 * 
	 * @param vlanId
	 *            the VLAN to check for an attached internet gateway
	 * @return Id for the Internet Gateway
	 * @throws CloudException
	 *             an error occurred with the cloud provider
	 * @throws InternalException
	 *             a local error occurred
	 */
	public @Nullable AsyncResult<String> getAttachedInternetGatewayId(@Nonnull String vlanId) throws CloudException,
			InternalException;

	/**
	 * Gets the Internet Gateway by ID
	 * 
	 * @param gatewayId
	 *            the id of the gateway
	 * @return Internet Gateway object
	 * @throws CloudException
	 *             an error occurred with the cloud provider
	 * @throws InternalException
	 *             a local error occurred
	 */
	public @Nullable AsyncResult<InternetGateway> getInternetGatewayById(@Nonnull String gatewayId) throws CloudException,
			InternalException;

	/**
	 * Indicates whether or not this cloud included the concept of network
	 * interfaces in its networking support.
	 * 
	 * @return true if this cloud supports network interfaces as part of its
	 *         networking concepts
	 * @throws CloudException
	 *             an error occurred with the cloud provider determining support
	 *             for network interfaces
	 * @throws InternalException
	 *             a local error occurred determining support for network
	 *             interfaces
	 */
	public boolean isNetworkInterfaceSupportEnabled() throws CloudException, InternalException;

	public boolean isSubscribed() throws CloudException, InternalException;

	/**
	 * Lists the IDs of the firewalls protecting the specified network
	 * interface.
	 * 
	 * @param nicId
	 *            the network interface ID of the desired network interface
	 * @return the firewall/security group IDs of all firewalls supporting this
	 *         network interface
	 * @throws CloudException
	 *             an error occurred with the cloud providing fetching the
	 *             firewall IDs
	 * @throws InternalException
	 *             a local error occurred while attempting to communicate with
	 *             the cloud
	 */
	public @Nonnull AsyncResult<Iterable<String>> listFirewallIdsForNIC(@Nonnull String nicId) throws CloudException,
			InternalException;

	/**
	 * Lists all Internet Gateways for an account or optionally all Internet
	 * Gateways for a VLAN.
	 * 
	 * @param vlanId
	 *            the VLAN ID to search for internet gateways
	 * @return a list of internet gateways
	 * @throws CloudException
	 *             an error occurred fetching the internet gatewayss from the
	 *             cloud provider
	 * @throws InternalException
	 *             a local error occurred processing the internet gateways
	 */
	public @Nonnull AsyncResult<Iterable<InternetGateway>> listInternetGateways(@Nullable String vlanId)
			throws CloudException, InternalException;

	/**
	 * Lists the status of all network interfaces currently provisioned in the
	 * current region.
	 * 
	 * @return a list of status for all provisioned network interfaces in the
	 *         current region
	 * @throws CloudException
	 *             an error occurred with the cloud provider fetching the
	 *             network interfaces
	 * @throws InternalException
	 *             a local error occurred fetching the network interfaces
	 */
	public @Nonnull AsyncResult<Iterable<ResourceStatus>> listNetworkInterfaceStatus() throws CloudException,
			InternalException;

	/**
	 * Lists all network interfaces currently provisioned in the current region.
	 * 
	 * @return a list of all provisioned network interfaces in the current
	 *         region
	 * @throws CloudException
	 *             an error occurred with the cloud provider fetching the
	 *             network interfaces
	 * @throws InternalException
	 *             a local error occurred fetching the network interfaces
	 */
	public @Nonnull AsyncResult<Iterable<NetworkInterface>> listNetworkInterfaces() throws CloudException, InternalException;

	/**
	 * Lists all network interfaces attached to a specific virtual machine.
	 * 
	 * @param forVmId
	 *            the virtual machine whose network interfaces you want listed
	 * @return the network interfaces attached to the specified virtual machine
	 * @throws CloudException
	 *             an error occurred with the cloud provider determining the
	 *             attached network interfaces
	 * @throws InternalException
	 *             a local error occurred listing the network interfaces
	 *             attached to the specified virtual machine
	 */
	public @Nonnull AsyncResult<Iterable<NetworkInterface>> listNetworkInterfacesForVM(@Nonnull String forVmId)
			throws CloudException, InternalException;

	/**
	 * Lists all network interfaces connected to a specific subnet. Valid only
	 * if the cloud provider supports subnets.
	 * 
	 * @param subnetId
	 *            the subnet ID for the subnet in which you are searching
	 * @return all interfaces within the specified subnet
	 * @throws CloudException
	 *             an error occurred in the cloud identifying the matching
	 *             network interfaces
	 * @throws InternalException
	 *             a local error occurred constructing the cloud query
	 */
	public @Nonnull AsyncResult<Iterable<NetworkInterface>> listNetworkInterfacesInSubnet(@Nonnull String subnetId)
			throws CloudException, InternalException;

	/**
	 * Lists all network interfaces connected to a specific VLAN. Valid only if
	 * the cloud provider supports VLANs.
	 * 
	 * @param vlanId
	 *            the VLAN ID for the VLAN in which you are searching
	 * @return all interfaces within the specified VLAN
	 * @throws CloudException
	 *             an error occurred in the cloud identifying the matching
	 *             network interfaces
	 * @throws InternalException
	 *             a local error occurred constructing the cloud query
	 */
	public @Nonnull AsyncResult<Iterable<NetworkInterface>> listNetworkInterfacesInVLAN(@Nonnull String vlanId)
			throws CloudException, InternalException;

	/**
	 * Lists all resources associated with the specified VLAN. In many clouds,
	 * this is a very expensive operation. So call this method with care.
	 * 
	 * @param vlanId
	 *            the VLAN for whom you are seeking the resource list
	 * @return a list of resources associated with the specified VLAN
	 * @throws CloudException
	 *             an error occurred in the cloud identifying the matching
	 *             resources
	 * @throws InternalException
	 *             a local error occurred constructing the cloud query
	 */
	public @Nonnull AsyncResult<Iterable<Networkable>> listResources(@Nonnull String vlanId) throws CloudException,
			InternalException;

	/**
	 * Lists all routing tables associated with the specified Subnet.
	 * 
	 * @param subnetId
	 *            the subnet ID whose routing tables are being sought
	 * @return a list of routing tables for the specified Subnet
	 * @throws CloudException
	 *             an error occurred fetching the routing tables from the cloud
	 *             provider
	 * @throws InternalException
	 *             a local error occurred processing the routing tables
	 */
	public @Nonnull AsyncResult<Iterable<RoutingTable>> listRoutingTablesForSubnet(@Nonnull String subnetId)
			throws CloudException, InternalException;

	/**
	 * Lists all routing tables associated with the specified VLAN.
	 * 
	 * @param vlanId
	 *            the VLAN ID whose routing tables are being sought
	 * @return a list of routing tables for the specified VLAN
	 * @throws CloudException
	 *             an error occurred fetching the routing tables from the cloud
	 *             provider
	 * @throws InternalException
	 *             a local error occurred processing the routing tables
	 */
	public @Nonnull AsyncResult<Iterable<RoutingTable>> listRoutingTablesForVlan(@Nonnull String vlanId)
			throws CloudException, InternalException;

	/**
	 * Lists all subnets associated with the specified VLAN.
	 * 
	 * @param vlanId
	 *            the VLAN ID whose subnets are being sought
	 * @return a list of subnets for the specified VLAN
	 * @throws CloudException
	 *             an error occurred fetching the subnets from the cloud
	 *             provider
	 * @throws InternalException
	 *             a local error occurred processing the subnets
	 */
	public @Nonnull AsyncResult<Iterable<Subnet>> listSubnets(@Nullable String vlanId) throws CloudException,
			InternalException;

	/**
	 * Lists the status of all VLANs in the current region.
	 * 
	 * @return the status of all VLANs in the current region
	 * @throws CloudException
	 *             an error occurred communicating with the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud implementation
	 */
	public @Nonnull AsyncResult<Iterable<ResourceStatus>> listVlanStatus() throws CloudException, InternalException;

	/**
	 * Lists all VLANs in the current region.
	 * 
	 * @return all VLANs in the current region
	 * @throws CloudException
	 *             an error occurred communicating with the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud implementation
	 */
	public @Nonnull AsyncResult<Iterable<VLAN>> listVlans() throws CloudException, InternalException;

	/**
	 * Disconnects the specified VLAN from it's gateway and deletes it if no
	 * other VLANs are attached to it.
	 * 
	 * @param forVlanId
	 *            the VLAN to disconnect
	 * @throws CloudException
	 *             an error occurred with the cloud provider while removing the
	 *             gateway
	 * @throws InternalException
	 *             a local error occurred while removing the gateway
	 * @throws OperationNotSupportedException
	 *             internet gateway creation/removal is not supported in this
	 *             cloud
	 */
	public AsyncResult<Void> removeInternetGateway(@Nonnull String forVlanId) throws CloudException, InternalException;

	/**
	 * Disconnects the specified gateway from it's VLAN and deletes it.
	 * 
	 * @param id
	 *            the gateway id to delete
	 * @throws CloudException
	 *             an error occurred with the cloud provider while removing the
	 *             gateway
	 * @throws InternalException
	 *             a local error occurred while removing the gateway
	 * @throws OperationNotSupportedException
	 *             internet gateway creation/removal is not supported in this
	 *             cloud
	 */
	public AsyncResult<Void> removeInternetGatewayById(@Nonnull String id) throws CloudException, InternalException;

	/**
	 * Removes meta-data from a internet gateway. If tag values are set, their
	 * removal is dependent on underlying cloud provider behavior. They may be
	 * removed only if the tag value matches or they may be removed regardless
	 * of the value.
	 * 
	 * @param internetGatewayId
	 *            the unique ID of the internet gateway to update
	 * @param tags
	 *            the meta-data tags to remove
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	public abstract AsyncResult<Void> removeInternetGatewayTags(@Nonnull String internetGatewayId, @Nonnull Tag... tags)
			throws CloudException, InternalException;

	/**
	 * Removes meta-data from multiply internet gateways. If tag values are set,
	 * their removal is dependent on underlying cloud provider behavior. They
	 * may be removed only if the tag value matches or they may be removed
	 * regardless of the value.
	 * 
	 * @param internetGatewayIds
	 *            the internet gateways to update
	 * @param tags
	 *            the meta-data tags to remove
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	public abstract AsyncResult<Void> removeInternetGatewayTags(@Nonnull String[] internetGatewayIds, @Nonnull Tag... tags)
			throws CloudException, InternalException;

	/**
	 * De-provisions the specified network interface.
	 * 
	 * @param nicId
	 *            the network interface to be de-provisioned
	 * @throws CloudException
	 *             an error occurred with the cloud provider while
	 *             de-provisioning the network interface
	 * @throws InternalException
	 *             a local error occurred while de-provisioning the network
	 *             interface
	 * @throws OperationNotSupportedException
	 *             NIC creation/removal is not supported in this cloud
	 */
	public AsyncResult<Void> removeNetworkInterface(@Nonnull String nicId) throws CloudException, InternalException;

	/**
	 * Removes any routing to the specified destination from the specified
	 * routing table.
	 * 
	 * @param routingTableId
	 *            the routing table from which the route is being removed
	 * @param destinationCidr
	 *            the destination CIDR for the traffic being routed
	 * @throws CloudException
	 *             an error occurred in the cloud while removing the route
	 * @throws InternalException
	 *             a local error occurred processing the request to remove the
	 *             route
	 * @throws OperationNotSupportedException
	 *             route creation/removal is not supported in this cloud
	 */
	public AsyncResult<Void> removeRoute(@Nonnull String routingTableId, @Nonnull String destinationCidr)
			throws CloudException, InternalException;

	/**
	 * Removes the specified routing table from the cloud.
	 * 
	 * @param routingTableId
	 *            the unique ID of the routing table to be removed
	 * @throws CloudException
	 *             an error occurred in the cloud removing the routing table
	 * @throws InternalException
	 *             a local error occurred while processing the request to remove
	 *             the routing table
	 * @throws OperationNotSupportedException
	 *             routing table creation/removal is not supported in this cloud
	 */
	public AsyncResult<Void> removeRoutingTable(@Nonnull String routingTableId) throws CloudException, InternalException;

	/**
	 * Removes meta-data from a routing table. If tag values are set, their
	 * removal is dependent on underlying cloud provider behavior. They may be
	 * removed only if the tag value matches or they may be removed regardless
	 * of the value.
	 * 
	 * @param routingTableId
	 *            the unique ID of the routing table to update
	 * @param tags
	 *            the meta-data tags to remove
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	public abstract AsyncResult<Void> removeRoutingTableTags(@Nonnull String routingTableId, @Nonnull Tag... tags)
			throws CloudException, InternalException;

	/**
	 * Removes meta-data from multiple routing table. If tag values are set,
	 * their removal is dependent on underlying cloud provider behavior. They
	 * may be removed only if the tag value matches or they may be removed
	 * regardless of the value.
	 * 
	 * @param routingTableIds
	 *            the routing tables to update
	 * @param tags
	 *            the meta-data tags to remove
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	public abstract AsyncResult<Void> removeRoutingTableTags(@Nonnull String[] routingTableIds, @Nonnull Tag... tags)
			throws CloudException, InternalException;

	/**
	 * Removes the specified subnet from the cloud.
	 * 
	 * @param providerSubnetId
	 *            the subnet to be removed
	 * @throws CloudException
	 *             an error occurred with the cloud provider while removing the
	 *             subnet
	 * @throws InternalException
	 *             a local error occurred while processing the request
	 * @throws OperationNotSupportedException
	 *             subnet creation/removal is not supported in this cloud
	 */
	public AsyncResult<Void> removeSubnet(String providerSubnetId) throws CloudException, InternalException;

	/**
	 * Removes meta-data from a subnet. If tag values are set, their removal is
	 * dependent on underlying cloud provider behavior. They may be removed only
	 * if the tag value matches or they may be removed regardless of the value.
	 * 
	 * @param subnetId
	 *            the subnet to update
	 * @param tags
	 *            the meta-data tags to remove
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	public AsyncResult<Void> removeSubnetTags(@Nonnull String subnetId, @Nonnull Tag... tags) throws CloudException,
			InternalException;

	/**
	 * Removes meta-data from multiple subnets. If tag values are set, their
	 * removal is dependent on underlying cloud provider behavior. They may be
	 * removed only if the tag value matches or they may be removed regardless
	 * of the value.
	 * 
	 * @param subnetIds
	 *            the subnets to update
	 * @param tags
	 *            the meta-data tags to remove
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	public AsyncResult<Void> removeSubnetTags(@Nonnull String[] subnetIds, @Nonnull Tag... tags) throws CloudException,
			InternalException;

	/**
	 * Set meta-data for a subnet. Remove any tags that were not provided by the
	 * incoming tags, and add or overwrite any new or pre-existing tags.
	 *
	 * @param subnetId
	 *            the subnet to set
	 * @param tags
	 *            the meta-data tags to set
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	public AsyncResult<Void> setSubnetTags(@Nonnull String subnetId, @Nonnull Tag... tags) throws CloudException,
			InternalException;

	/**
	 * Set meta-data for multiple subnet. Remove any tags that were not provided
	 * by the incoming tags, and add or overwrite any new or pre-existing tags.
	 *
	 * @param subnetIds
	 *            the subnets to set
	 * @param tags
	 *            the meta-data tags to set
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	public AsyncResult<Void> setSubnetTags(@Nonnull String[] subnetIds, @Nonnull Tag... tags) throws CloudException,
			InternalException;

	/**
	 * Removes the specified VLAN from the cloud.
	 * 
	 * @param vlanId
	 *            the unique ID of the VLAN to be removed
	 * @throws CloudException
	 *             an error occurred removing the target VLAN
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 * @throws OperationNotSupportedException
	 *             VLAN removal is not supported
	 */
	public AsyncResult<Void> removeVlan(String vlanId) throws CloudException, InternalException;

	/**
	 * Removes meta-data from a VLAN. If tag values are set, their removal is
	 * dependent on underlying cloud provider behavior. They may be removed only
	 * if the tag value matches or they may be removed regardless of the value.
	 * 
	 * @param vlanId
	 *            the VLAN to update
	 * @param tags
	 *            the meta-data tags to remove
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	public AsyncResult<Void> removeVLANTags(@Nonnull String vlanId, @Nonnull Tag... tags) throws CloudException,
			InternalException;

	/**
	 * Removes meta-data from multiple VLANs. If tag values are set, their
	 * removal is dependent on underlying cloud provider behavior. They may be
	 * removed only if the tag value matches or they may be removed regardless
	 * of the value.
	 * 
	 * @param vlanIds
	 *            the VLANs to update
	 * @param tags
	 *            the meta-data tags to remove
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	public AsyncResult<Void> removeVLANTags(@Nonnull String[] vlanIds, @Nonnull Tag... tags) throws CloudException,
			InternalException;

	/**
	 * Updates meta-data for a subnet with the new values. It will not overwrite
	 * any value that currently exists unless it appears in the tags you submit.
	 * 
	 * @param subnetId
	 *            the subnet to update
	 * @param tags
	 *            the meta-data tags to set
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	public AsyncResult<Void> updateSubnetTags(@Nonnull String subnetId, @Nonnull Tag... tags) throws CloudException,
			InternalException;

	/**
	 * Updates meta-data for multiple subnets with the new values. It will not
	 * overwrite any value that currently exists unless it appears in the tags
	 * you submit.
	 * 
	 * @param subnetIds
	 *            the subnets to update
	 * @param tags
	 *            the meta-data tags to set
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	public AsyncResult<Void> updateSubnetTags(@Nonnull String[] subnetIds, @Nonnull Tag... tags) throws CloudException,
			InternalException;

	/**
	 * Updates meta-data for a routing table with the new values. It will not
	 * overwrite any value that currently exists unless it appears in the tags
	 * you submit.
	 * 
	 * @param routingTableId
	 *            the routing table to update
	 * @param tags
	 *            the meta-data tags to set
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	public abstract AsyncResult<Void> updateRoutingTableTags(@Nonnull String routingTableId, @Nonnull Tag... tags)
			throws CloudException, InternalException;

	/**
	 * Updates meta-data for multiple routing tables with the new values. It
	 * will not overwrite any value that currently exists unless it appears in
	 * the tags you submit.
	 * 
	 * @param routingTableIds
	 *            the routing tables to update
	 * @param tags
	 *            the meta-data tags to set
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	public abstract AsyncResult<Void> updateRoutingTableTags(@Nonnull String[] routingTableIds, @Nonnull Tag... tags)
			throws CloudException, InternalException;

	/**
	 * Set meta-data for a routing table. Remove any tags that were not provided
	 * by the incoming tags, and add or overwrite any new or pre-existing tags.
	 *
	 * @param routingTableId
	 *            the routing table to update
	 * @param tags
	 *            the meta-data tags to set
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	public AsyncResult<Void> setRoutingTableTags(@Nonnull String routingTableId, @Nonnull Tag... tags)
			throws CloudException, InternalException;

	/**
	 * Set meta-data for multiple routing tables. Remove any tags that were not
	 * provided by the incoming tags, and add or overwrite any new or
	 * pre-existing tags.
	 *
	 * @param routingTableIds
	 *            the routing tables to update
	 * @param tags
	 *            the meta-data tags to set
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	public AsyncResult<Void> setRoutingTableTags(@Nonnull String[] routingTableIds, @Nonnull Tag... tags)
			throws CloudException, InternalException;

	/**
	 * Set meta-data for a VLAN. Remove any tags that were not provided by the
	 * incoming tags, and add or overwrite any new or pre-existing tags.
	 *
	 * @param vlanId
	 *            the VLAN to update
	 * @param tags
	 *            the meta-data tags to set
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	public AsyncResult<Void> setVLANTags(@Nonnull String vlanId, @Nonnull Tag... tags) throws CloudException,
			InternalException;

	/**
	 * Set meta-data for multiple VLAN. Remove any tags that were not provided
	 * by the incoming tags, and add or overwrite any new or pre-existing tags.
	 *
	 * @param vlanIds
	 *            the VLAN to update
	 * @param tags
	 *            the meta-data tags to set
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	public AsyncResult<Void> setVLANTags(@Nonnull String[] vlanIds, @Nonnull Tag... tags) throws CloudException,
			InternalException;

	/**
	 * Updates meta-data for a VLAN with the new values. It will not overwrite
	 * any value that currently exists unless it appears in the tags you submit.
	 * 
	 * @param vlanId
	 *            the VLAN to update
	 * @param tags
	 *            the meta-data tags to set
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	public AsyncResult<Void> updateVLANTags(@Nonnull String vlanId, @Nonnull Tag... tags) throws CloudException,
			InternalException;

	/**
	 * Updates meta-data for multiple VLANs with the new values. It will not
	 * overwrite any value that currently exists unless it appears in the tags
	 * you submit.
	 * 
	 * @param vlanIds
	 *            the VLANs to update
	 * @param tags
	 *            the meta-data tags to set
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	public abstract AsyncResult<Void> updateVLANTags(@Nonnull String[] vlanIds, @Nonnull Tag... tags) throws CloudException,
			InternalException;

	/**
	 * Updates meta-data for an internet gateway with the new values. It will
	 * not overwrite any value that currently exists unless it appears in the
	 * tags you submit.
	 * 
	 * @param internetGatewayId
	 *            the internet gateway to update
	 * @param tags
	 *            the meta-data tags to set
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	public abstract AsyncResult<Void> updateInternetGatewayTags(@Nonnull String internetGatewayId, @Nonnull Tag... tags)
			throws CloudException, InternalException;

	/**
	 * Updates meta-data for multiple internet gateways with the new values. It
	 * will not overwrite any value that currently exists unless it appears in
	 * the tags you submit.
	 * 
	 * @param internetGatewayIds
	 *            the internet gateways to update
	 * @param tags
	 *            the meta-data tags to set
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	public abstract AsyncResult<Void> updateInternetGatewayTags(@Nonnull String[] internetGatewayIds, @Nonnull Tag... tags)
			throws CloudException, InternalException;

	/**
	 * Set meta-data for a internet gateway. Remove any tags that were not
	 * provided by the incoming tags, and add or overwrite any new or
	 * pre-existing tags.
	 *
	 * @param internetGatewayId
	 *            the internet gateway to update
	 * @param tags
	 *            the meta-data tags to set
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	public AsyncResult<Void> setInternetGatewayTags(@Nonnull String internetGatewayId, @Nonnull Tag... tags)
			throws CloudException, InternalException;

	/**
	 * Set meta-data for multiple internet gateways. Remove any tags that were
	 * not provided by the incoming tags, and add or overwrite any new or
	 * pre-existing tags.
	 *
	 * @param internetGatewayIds
	 *            the internet gateways to update
	 * @param tags
	 *            the meta-data tags to set
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	public AsyncResult<Void> setInternetGatewayTags(@Nonnull String[] internetGatewayIds, @Nonnull Tag... tags)
			throws CloudException, InternalException;

	VLANSupport getSupport();
}
