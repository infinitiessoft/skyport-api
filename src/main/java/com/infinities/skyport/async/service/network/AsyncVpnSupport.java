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
import org.dasein.cloud.ResourceStatus;
import org.dasein.cloud.identity.ServiceAction;
import org.dasein.cloud.network.Vpn;
import org.dasein.cloud.network.VpnCapabilities;
import org.dasein.cloud.network.VpnConnection;
import org.dasein.cloud.network.VpnCreateOptions;
import org.dasein.cloud.network.VpnGateway;
import org.dasein.cloud.network.VpnGatewayCreateOptions;
import org.dasein.cloud.network.VpnSupport;

import com.infinities.skyport.async.AsyncResult;

public interface AsyncVpnSupport extends AccessControlledService {

	static public final ServiceAction ANY = new ServiceAction("VPN:ANY");

	static public final ServiceAction ATTACH = new ServiceAction("VPN:ATTACH");
	static public final ServiceAction CONNECT_GATEWAY = new ServiceAction("VPN:CONNECT_GATEWAY");
	static public final ServiceAction CREATE_GATEWAY = new ServiceAction("VPN:CREATE_GATEWAY");
	static public final ServiceAction CREATE_VPN = new ServiceAction("VPN:CREATE_VPN");
	static public final ServiceAction DETACH = new ServiceAction("VPN:DETACH");
	static public final ServiceAction DISCONNECT_GATEWAY = new ServiceAction("VPN:DISCONNECT_GATEWAY");
	static public final ServiceAction GET_GATEWAY = new ServiceAction("VPN:GET_GATEWAY");
	static public final ServiceAction GET_VPN = new ServiceAction("VPN:GET_VPN");
	static public final ServiceAction LIST_GATEWAY = new ServiceAction("VPN:LIST_GATEWAY");
	static public final ServiceAction LIST_VPN = new ServiceAction("VPN:LIST_VPN");
	static public final ServiceAction REMOVE_GATEWAY = new ServiceAction("VPN:REMOVE_GATEWAY");
	static public final ServiceAction REMOVE_VPN = new ServiceAction("VPN:REMOVE_VPN");


	AsyncResult<Void> attachToVlan(@Nonnull String providerVpnId, @Nonnull String providerVlanId) throws CloudException,
			InternalException;

	AsyncResult<Void> connectToGateway(@Nonnull String providerVpnId, @Nonnull String toGatewayId) throws CloudException,
			InternalException;

	@Nonnull
	AsyncResult<Vpn> createVpn(@Nonnull VpnCreateOptions vpnLaunchOptions) throws CloudException, InternalException;

	@Nonnull
	AsyncResult<VpnGateway> createVpnGateway(@Nonnull VpnGatewayCreateOptions vpnGatewayCreateOptions)
			throws CloudException, InternalException;

	AsyncResult<Void> deleteVpn(@Nonnull String providerVpnId) throws CloudException, InternalException;

	AsyncResult<Void> deleteVpnGateway(@Nonnull String providerVpnGatewayId) throws CloudException, InternalException;

	AsyncResult<Void> detachFromVlan(@Nonnull String providerVpnId, @Nonnull String providerVlanId) throws CloudException,
			InternalException;

	AsyncResult<Void> disconnectFromGateway(@Nonnull String providerVpnId, @Nonnull String fromGatewayId)
			throws CloudException, InternalException;

	@Nonnull
	VpnCapabilities getCapabilities() throws CloudException, InternalException;

	@Nullable
	AsyncResult<VpnGateway> getGateway(@Nonnull String gatewayId) throws CloudException, InternalException;

	@Nullable
	AsyncResult<Vpn> getVpn(@Nonnull String providerVpnId) throws CloudException, InternalException;

	@Nonnull
	AsyncResult<Iterable<VpnConnection>> listGatewayConnections(@Nonnull String toGatewayId) throws CloudException,
			InternalException;

	@Nonnull
	AsyncResult<Iterable<ResourceStatus>> listGatewayStatus() throws CloudException, InternalException;

	@Nonnull
	AsyncResult<Iterable<VpnGateway>> listGateways() throws CloudException, InternalException;

	@Nonnull
	AsyncResult<Iterable<VpnGateway>> listGatewaysWithBgpAsn(@Nonnull String bgpAsn) throws CloudException,
			InternalException;

	@Nonnull
	AsyncResult<Iterable<VpnConnection>> listVpnConnections(@Nonnull String toVpnId) throws CloudException,
			InternalException;

	@Nonnull
	AsyncResult<Iterable<ResourceStatus>> listVpnStatus() throws CloudException, InternalException;

	@Nonnull
	AsyncResult<Iterable<Vpn>> listVpns() throws CloudException, InternalException;

	public boolean isSubscribed() throws CloudException, InternalException;

	VpnSupport getSupport();
}
