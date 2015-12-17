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

import java.util.concurrent.Future;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.dasein.cloud.CloudException;
import org.dasein.cloud.InternalException;
import org.dasein.cloud.OperationNotSupportedException;
import org.dasein.cloud.Requirement;
import org.dasein.cloud.ResourceStatus;
import org.dasein.cloud.Tag;
import org.dasein.cloud.identity.ServiceAction;
import org.dasein.cloud.network.AddressType;
import org.dasein.cloud.network.IPAddressCapabilities;
import org.dasein.cloud.network.IPVersion;
import org.dasein.cloud.network.IpAddress;
import org.dasein.cloud.network.IpAddressSupport;
import org.dasein.cloud.network.IpForwardingRule;
import org.dasein.cloud.network.Protocol;
import org.dasein.cloud.network.VLANSupport;

import com.infinities.skyport.async.AsyncResult;

public interface AsyncIpAddressSupport {

	static public final ServiceAction ANY = new ServiceAction("IPADDR:ANY");

	static public final ServiceAction ASSIGN = new ServiceAction("IPADDR:ASSIGN");
	static public final ServiceAction CREATE_IP_ADDRESS = new ServiceAction("IPADDR:CREATE_IP_ADDRESS");
	static public final ServiceAction FORWARD = new ServiceAction("IPADDR:FORWARD");
	static public final ServiceAction GET_IP_ADDRESS = new ServiceAction("IPADDR:GET_IP_ADDRESS");
	static public final ServiceAction LIST_IP_ADDRESS = new ServiceAction("IPADDR:LIST_IP_ADDRESS");
	static public final ServiceAction RELEASE = new ServiceAction("IPADDR:RELEASE");
	static public final ServiceAction REMOVE_IP_ADDRESS = new ServiceAction("IPADDR:REMOVE_IP_ADDRESS");
	static public final ServiceAction STOP_FORWARD = new ServiceAction("IPADDR:STOP_FORWARD");


	/**
	 * Assigns the specified address to the target server. This method should be
	 * called only if {@link #isAssigned(AddressType)} for the specified
	 * address's address type is <code>true</code>. If it is not, you will see
	 * the {@link RuntimeException}
	 * {@link org.dasein.cloud.OperationNotSupportedException} thrown.
	 * 
	 * @param addressId
	 *            the unique identifier of the address to be assigned
	 * @param serverId
	 *            the unique ID of the server to which the address is being
	 *            assigned
	 * @throws InternalException
	 *             an internal error occurred inside the Dasein Cloud
	 *             implementation
	 * @throws CloudException
	 *             an error occurred processing the request in the cloud
	 * @throws org.dasein.cloud.OperationNotSupportedException
	 *             this cloud provider does not support address assignment of
	 *             the specified address type
	 */
	public AsyncResult<Void> assign(@Nonnull String addressId, @Nonnull String serverId) throws InternalException,
			CloudException;

	/**
	 * Assigns the specified address to the specified network interface.
	 * 
	 * @param addressId
	 *            the unique ID of the IP address to assign
	 * @param nicId
	 *            the unique ID of the network interface to which the address is
	 *            being assigned
	 * @throws InternalException
	 *             an error occurred locally while performing the assignment
	 * @throws CloudException
	 *             an error occurred in the cloud provider while performing the
	 *             assignment
	 */
	public AsyncResult<Void> assignToNetworkInterface(@Nonnull String addressId, @Nonnull String nicId)
			throws InternalException, CloudException;

	/**
	 * Forwards the specified public IP address traffic on the specified public
	 * port over to the specified private port on the specified server. If the
	 * server goes away, you will generally still have traffic being forwarded
	 * to the private IP formally associated with the server, so it is best to
	 * stop forwarding before terminating a server.
	 * <p>
	 * You should check {@link #isForwarding()} before calling this method. The
	 * implementation should throw a
	 * {@link org.dasein.cloud.OperationNotSupportedException}
	 * {@link RuntimeException} if the underlying cloud does not support IP
	 * address forwarding.
	 * </p>
	 * 
	 * @param addressId
	 *            the unique ID of the public IP address to be forwarded
	 * @param publicPort
	 *            the public port of traffic to be forwarded
	 * @param protocol
	 *            the network protocol being forwarded (not all clouds support
	 *            ICMP)
	 * @param privatePort
	 *            the private port on the server to which traffic should be
	 *            forwarded
	 * @param onServerId
	 *            the unique ID of the server to which traffic is to be
	 *            forwarded
	 * @return the rule ID for the forwarding rule that is created
	 * @throws InternalException
	 *             an internal error occurred inside the Dasein Cloud
	 *             implementation
	 * @throws CloudException
	 *             an error occurred processing the request in the cloud
	 * @throws org.dasein.cloud.OperationNotSupportedException
	 *             this cloud provider does not support address forwarding
	 */
	public @Nonnull AsyncResult<String> forward(@Nonnull String addressId, int publicPort, @Nonnull Protocol protocol,
			int privatePort, @Nonnull String onServerId) throws InternalException, CloudException;

	/**
	 * Provides access to meta-data about IP Address capabilities in the current
	 * region of this cloud.
	 * 
	 * @return a description of the features supported by this region of this
	 *         cloud
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 */
	public @Nonnull IPAddressCapabilities getCapabilities() throws CloudException, InternalException;

	/**
	 * Provides the {@link IpAddress} identified by the specified unique address
	 * ID.
	 * 
	 * @param addressId
	 *            the unique ID of the IP address being requested
	 * @return the matching {@link IpAddress}
	 * @throws InternalException
	 *             an internal error occurred inside the Dasein Cloud
	 *             implementation
	 * @throws CloudException
	 *             an error occurred processing the request in the cloud
	 */
	public @Nullable AsyncResult<IpAddress> getIpAddress(@Nonnull String addressId) throws InternalException, CloudException;

	/**
	 * Indicates whether the underlying cloud supports the assignment of
	 * addresses of the specified type.
	 * 
	 * @param type
	 *            the type of address being checked (public or private)
	 * @return <code>true</code> if addresses of the specified type are
	 *         assignable to servers
	 * @deprecated use {@link #isAssigned(IPVersion)}
	 */
	@Deprecated
	public AsyncResult<Boolean> isAssigned(@Nonnull AddressType type);

	/**
	 * Indicates whether the underlying cloud supports the forwarding individual
	 * port traffic on public IP addresses to hosts private IPs. These addresses
	 * may also be used for load balancers in some clouds as well.
	 * 
	 * @return <code>true</code> if public IPs may be forwarded on to private
	 *         IPs
	 * @deprecated use {@link #isForwarding(IPVersion)}
	 */
	@Deprecated
	public AsyncResult<Boolean> isForwarding();

	/**
	 * Indicates whether the underlying cloud allows you to make programmatic
	 * requests for new IP addresses of the specified type
	 * 
	 * @param type
	 *            the type of address being checked (public or private)
	 * @return <code>true</code> if there are programmatic mechanisms for
	 *         allocating new IPs of the specified type
	 * @deprecated use {@link #isRequestable(IPVersion)}
	 */
	@Deprecated
	public AsyncResult<Boolean> isRequestable(@Nonnull AddressType type);

	/**
	 * Indicates whether this account is subscribed to leverage IP address
	 * services in the target cloud.
	 * 
	 * @return <code>true</code> if the account holder is subscribed
	 * @throws InternalException
	 *             an internal error occurred inside the Dasein Cloud
	 *             implementation
	 * @throws CloudException
	 *             an error occurred processing the request in the cloud
	 */
	public boolean isSubscribed() throws CloudException, InternalException;

	/**
	 * Lists all (or unassigned) private IP addresses from the account holder's
	 * private IP address pool. This method is safe to call even if private IP
	 * forwarding is not supported. It will simply return
	 * {@link java.util.Collections#emptyList()}.
	 * 
	 * @param unassignedOnly
	 *            indicates that only unassigned addresses are being sought
	 * @return all private IP addresses or the unassigned ones from the pool
	 * @throws InternalException
	 *             an internal error occurred inside the Dasein Cloud
	 *             implementation
	 * @throws CloudException
	 *             an error occurred processing the request in the cloud
	 * @throws OperationNotSupportedException
	 *             the requested version is not supported
	 * @deprecated private IP pools no longer make sense, use the
	 *             {@link VLANSupport} class
	 */
	@Deprecated
	public @Nonnull AsyncResult<Iterable<IpAddress>> listPrivateIpPool(boolean unassignedOnly) throws InternalException,
			CloudException;

	/**
	 * Lists all (or unassigned) public IP addresses from the account holder's
	 * public IP address pool. This method is safe to call even if public IP
	 * forwarding is not supported. It will simply return
	 * {@link java.util.Collections#emptyList()}.
	 * 
	 * @param unassignedOnly
	 *            indicates that only unassigned addresses are being sought
	 * @return all public IP addresses or the unassigned ones from the pool
	 * @throws InternalException
	 *             an internal error occurred inside the Dasein Cloud
	 *             implementation
	 * @throws CloudException
	 *             an error occurred processing the request in the cloud
	 * @throws OperationNotSupportedException
	 *             the requested version is not supported
	 * @deprecated use {@link #listIpPool(IPVersion, boolean)}
	 */
	@Deprecated
	public @Nonnull AsyncResult<Iterable<IpAddress>> listPublicIpPool(boolean unassignedOnly) throws InternalException,
			CloudException;

	/**
	 * Lists all IP addresses of the specified IP version that are allocated to
	 * the account holder's IP address pool. If the specified version is not
	 * supported, an empty list should be returned.
	 * 
	 * @param version
	 *            the version of the IP protocol for which you are looking for
	 *            IP addresses
	 * @param unassignedOnly
	 *            show only IP addresses that have yet to be assigned to cloud
	 *            resources
	 * @return all matching IP addresses from the IP address pool
	 * @throws InternalException
	 *             a local error occurred loading the IP addresses
	 * @throws CloudException
	 *             an error occurred with the cloud provider while requesting
	 *             the IP addresses
	 */
	public @Nonnull AsyncResult<Iterable<IpAddress>> listIpPool(@Nonnull IPVersion version, boolean unassignedOnly)
			throws InternalException, CloudException;

	/**
	 * Lists all IP addresses of the specified IP version that are allocated to
	 * the account holder's IP address pool. If the specified version is not
	 * supported, an empty list should be returned. This method implements a
	 * callable so it can be called concurrently.
	 * 
	 * @param version
	 *            the version of the IP protocol for which you are looking for
	 *            IP addresses
	 * @param unassignedOnly
	 *            show only IP addresses that have yet to be assigned to cloud
	 *            resources
	 * @return all matching IP addresses from the IP address pool
	 * @throws InternalException
	 *             a local error occurred loading the IP addresses
	 * @throws CloudException
	 *             an error occurred with the cloud provider while requesting
	 *             the IP addresses
	 */
	public @Nonnull AsyncResult<Future<Iterable<IpAddress>>> listIpPoolConcurrently(@Nonnull IPVersion version,
			boolean unassignedOnly) throws InternalException, CloudException;

	/**
	 * Lists the status of all IP addresses of the specified IP version that are
	 * allocated to the account holder's IP address pool. If the specified
	 * version is not supported, an empty list should be returned.
	 * 
	 * @param version
	 *            the version of the IP protocol for which you are looking for
	 *            IP addresses
	 * @return the status of all matching IP addresses from the IP address pool
	 * @throws InternalException
	 *             a local error occurred loading the IP addresses
	 * @throws CloudException
	 *             an error occurred with the cloud provider while requesting
	 *             the IP addresses
	 */
	public @Nonnull AsyncResult<Iterable<ResourceStatus>> listIpPoolStatus(@Nonnull IPVersion version)
			throws InternalException, CloudException;

	/**
	 * Lists the IP forwarding rules associated with the specified public IP
	 * address. This method is safe to call even when requested on a private IP
	 * address or when IP forwarding is not supported. In those situations,
	 * {@link java.util.Collections#emptyList()} will be returned.
	 * 
	 * @param addressId
	 *            the unique ID of the public address whose forwarding rules
	 *            will be sought
	 * @return all IP forwarding rules for the specified IP address
	 * @throws InternalException
	 *             an internal error occurred inside the Dasein Cloud
	 *             implementation
	 * @throws CloudException
	 *             an error occurred processing the request in the cloud
	 */
	public @Nonnull AsyncResult<Iterable<IpForwardingRule>> listRules(@Nonnull String addressId) throws InternalException,
			CloudException;

	/**
	 * Lists the IP forwarding rules associated with the specified virtual
	 * machine. This method is safe to call even when IP forwarding is not
	 * supported. In those situations, {@link java.util.Collections#emptyList()}
	 * will be returned.
	 * 
	 * @param serverId
	 *            the unique ID of the virtual machine whose forwarding rules
	 *            will be sought
	 * @return all IP forwarding rules for the specified IP address
	 * @throws InternalException
	 *             an internal error occurred inside the Dasein Cloud
	 *             implementation
	 * @throws CloudException
	 *             an error occurred processing the request in the cloud
	 */
	public @Nonnull AsyncResult<Iterable<IpForwardingRule>> listRulesForServer(@Nonnull String serverId)
			throws InternalException, CloudException;

	/**
	 * When a cloud allows for programmatic requesting of new IP addresses, you
	 * may also programmaticall release them (
	 * {@link #isRequestable(AddressType)}). This method will release the
	 * specified IP address from your pool and you will no longer be able to use
	 * it for assignment or forwarding.
	 * 
	 * @param addressId
	 *            the unique ID of the address to be release
	 * @throws InternalException
	 *             an internal error occurred inside the Dasein Cloud
	 *             implementation
	 * @throws CloudException
	 *             an error occurred processing the request in the cloud
	 * @throws org.dasein.cloud.OperationNotSupportedException
	 *             this cloud provider does not support address requests
	 */
	public AsyncResult<Void> releaseFromPool(@Nonnull String addressId) throws InternalException, CloudException;

	/**
	 * Releases an IP address assigned to a server so that it is unassigned in
	 * the address pool. You should call this method only when
	 * {@link #isAssigned(AddressType)} is <code>true</code> for addresses of
	 * the target address's type.
	 * 
	 * @param addressId
	 *            the address ID to release from its server assignment
	 * @throws InternalException
	 *             an internal error occurred inside the Dasein Cloud
	 *             implementation
	 * @throws CloudException
	 *             an error occurred processing the request in the cloud
	 * @throws org.dasein.cloud.OperationNotSupportedException
	 *             this cloud provider does not support address assignment for
	 *             addresses of the specified type
	 */
	public AsyncResult<Void> releaseFromServer(@Nonnull String addressId) throws InternalException, CloudException;

	/**
	 * Requests an IP address of the specified version for the flat (non-VLAN)
	 * network space.
	 * 
	 * @param version
	 *            the IP version of the address to be requested
	 * @return the unique ID of the newly provisioned static IP address
	 * @throws InternalException
	 *             a local error occurred while preparing the request
	 * @throws CloudException
	 *             an error occurred with the cloud while provisioning the new
	 *             address
	 */
	public @Nonnull AsyncResult<String> request(@Nonnull IPVersion version) throws InternalException, CloudException;

	/**
	 * Requests a public IP address that may be used with a VLAN. This version
	 * may be used only when {@link #identifyVlanForVlanIPRequirement()} is not
	 * {@link Requirement#REQUIRED}.
	 * 
	 * @param version
	 *            the IP version of the address to be requested
	 * @return the unique ID of a newly provisioned public IP address
	 * @throws InternalException
	 *             an error occurred locally while attempting to provision the
	 *             IP address
	 * @throws CloudException
	 *             an error occurred in the cloud provider while provisioning
	 *             the IP address
	 * @throws OperationNotSupportedException
	 *             either VLAN IPs are not supported or they must be explicitly
	 *             associated with a VLAN
	 */
	public @Nonnull AsyncResult<String> requestForVLAN(@Nonnull IPVersion version) throws InternalException, CloudException;

	/**
	 * Requests a public IP address that must be used with a specific VLAN. This
	 * version may be used only when {@link #identifyVlanForVlanIPRequirement()}
	 * is not {@link Requirement#NONE}.
	 * 
	 * @param version
	 *            the IP version of the address to be requested
	 * @param vlanId
	 *            the unique ID of the VLAN to which the IP address will be
	 *            assigned
	 * @return the unique ID of a newly provisioned public IP address
	 * @throws InternalException
	 *             an error occurred locally while attempting to provision the
	 *             IP address
	 * @throws CloudException
	 *             an error occurred in the cloud provider while provisioning
	 *             the IP address
	 * @throws OperationNotSupportedException
	 *             either VLAN IPs are not supported or they cannot be
	 *             explicitly associated with a VLAN
	 */
	public @Nonnull AsyncResult<String> requestForVLAN(@Nonnull IPVersion version, @Nonnull String vlanId)
			throws InternalException, CloudException;

	/**
	 * Removes the specified forwarding rule from the address with which it is
	 * associated.
	 * 
	 * @param ruleId
	 *            the rule to be removed
	 * @throws InternalException
	 *             an internal error occurred inside the Dasein Cloud
	 *             implementation
	 * @throws CloudException
	 *             an error occurred processing the request in the cloud
	 * @throws org.dasein.cloud.OperationNotSupportedException
	 *             this cloud provider does not support address forwarding
	 */
	public AsyncResult<Void> stopForward(@Nonnull String ruleId) throws InternalException, CloudException;

	/**
	 * Removes the forwarding rule directed to the specified virtual machine
	 * 
	 * @param ruleId
	 *            the rule to be removed
	 * @param serverId
	 *            the server to which the forwarding rule currently directs
	 * @throws InternalException
	 *             an internal error occurred inside the Dasein Cloud
	 *             implementation
	 * @throws CloudException
	 *             an error occurred processing the request in the cloud
	 * @throws org.dasein.cloud.OperationNotSupportedException
	 *             this cloud provider does not support address forwarding
	 */
	public AsyncResult<Void> stopForwardToServer(@Nonnull String ruleId, @Nonnull String serverId) throws InternalException,
			CloudException;

	/**
	 * Removes meta-data from a IP address. If tag values are set, their removal
	 * is dependent on underlying cloud provider behavior. They may be removed
	 * only if the tag value matches or they may be removed regardless of the
	 * value.
	 * 
	 * @param addressId
	 *            the IP address to update
	 * @param tags
	 *            the meta-data tags to remove
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	public AsyncResult<Void> removeTags(@Nonnull String addressId, @Nonnull Tag... tags) throws CloudException,
			InternalException;

	/**
	 * Removes meta-data from multiple IP addresses. If tag values are set,
	 * their removal is dependent on underlying cloud provider behavior. They
	 * may be removed only if the tag value matches or they may be removed
	 * regardless of the value.
	 * 
	 * @param addressIds
	 *            the IP addresses to update
	 * @param tags
	 *            the meta-data tags to remove
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	public AsyncResult<Void> removeTags(@Nonnull String[] addressIds, @Nonnull Tag... tags) throws CloudException,
			InternalException;

	/**
	 * Updates meta-data for a IP address with the new values. It will not
	 * overwrite any value that currently exists unless it appears in the tags
	 * you submit.
	 * 
	 * @param addressId
	 *            the IP address to update
	 * @param tags
	 *            the meta-data tags to set
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	public AsyncResult<Void> updateTags(@Nonnull String addressId, @Nonnull Tag... tags) throws CloudException,
			InternalException;

	/**
	 * Updates meta-data for multiple IP addresses with the new values. It will
	 * not overwrite any value that currently exists unless it appears in the
	 * tags you submit.
	 * 
	 * @param addressIds
	 *            the IP addresses to update
	 * @param tags
	 *            the meta-data tags to set
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	public AsyncResult<Void> updateTags(@Nonnull String[] addressIds, @Nonnull Tag... tags) throws CloudException,
			InternalException;

	/**
	 * Set meta-data for a IP address. Remove any tags that were not provided by
	 * the incoming tags, and add or overwrite any new or pre-existing tags.
	 *
	 * @param addressId
	 *            the IP address to update
	 * @param tags
	 *            the meta-data tags to set
	 * @throws CloudException
	 * @throws InternalException
	 */
	public AsyncResult<Void> setTags(@Nonnull String addressId, @Nonnull Tag... tags) throws CloudException,
			InternalException;

	/**
	 * Set meta-data for multiple IP addresses. Remove any tags that were not
	 * provided by the incoming tags, and add or overwrite any new or
	 * pre-existing tags.
	 *
	 * @param addressIds
	 *            the IP addresses to update
	 * @param tags
	 *            the meta-data tags to set
	 * @throws CloudException
	 * @throws InternalException
	 */
	public AsyncResult<Void> setTags(@Nonnull String[] addressIds, @Nonnull Tag... tags) throws CloudException,
			InternalException;

	IpAddressSupport getSupport();
}
