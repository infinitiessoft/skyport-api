package com.infinities.skyport.model.network;

import java.io.Serializable;

import org.dasein.cloud.CloudException;
import org.dasein.cloud.InternalException;
import org.dasein.cloud.ResourceStatus;
import org.dasein.cloud.Tag;
import org.dasein.cloud.identity.ServiceAction;
import org.dasein.cloud.network.HealthCheckFilterOptions;
import org.dasein.cloud.network.HealthCheckOptions;
import org.dasein.cloud.network.LbAttributesOptions;
import org.dasein.cloud.network.LbEndpointType;
import org.dasein.cloud.network.LbListener;
import org.dasein.cloud.network.LoadBalancer;
import org.dasein.cloud.network.LoadBalancerCapabilities;
import org.dasein.cloud.network.LoadBalancerCreateOptions;
import org.dasein.cloud.network.LoadBalancerEndpoint;
import org.dasein.cloud.network.LoadBalancerHealthCheck;
import org.dasein.cloud.network.LoadBalancerHealthCheck.HCProtocol;
import org.dasein.cloud.network.LoadBalancerSupport;
import org.dasein.cloud.network.SSLCertificate;
import org.dasein.cloud.network.SSLCertificateCreateOptions;
import org.dasein.cloud.network.SetLoadBalancerSSLCertificateOptions;

import com.infinities.skyport.async.AsyncResult;
import com.infinities.skyport.async.service.network.AsyncLoadBalancerSupport;

public class LoadBalancerSupportProxy implements AsyncLoadBalancerSupport, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final AsyncLoadBalancerSupport support;
	
	public LoadBalancerSupportProxy(AsyncLoadBalancerSupport support) {
		this.support = support;
	}

	@Override
	public String[] mapServiceAction(ServiceAction action) {
		return support.mapServiceAction(action);
	}

	@Override
	public AsyncResult<Void> addListeners(String toLoadBalancerId, LbListener[] listeners)
			throws CloudException, InternalException {
		return support.addListeners(toLoadBalancerId, listeners);
	}

	@Override
	public AsyncResult<Void> removeListeners(String toLoadBalancerId, LbListener[] listeners)
			throws CloudException, InternalException {
		return support.removeListeners(toLoadBalancerId, listeners);
	}

	@Override
	public AsyncResult<Void> addDataCenters(String toLoadBalancerId, String... dataCenterIdsToAdd)
			throws CloudException, InternalException {
		return support.addDataCenters(toLoadBalancerId, dataCenterIdsToAdd);
	}

	@Override
	public AsyncResult<Void> addIPEndpoints(String toLoadBalancerId, String... ipAddresses)
			throws CloudException, InternalException {
		return support.addIPEndpoints(toLoadBalancerId, ipAddresses);
	}

	@Override
	public AsyncResult<Void> addServers(String toLoadBalancerId, String... serverIdsToAdd)
			throws CloudException, InternalException {
		return support.addServers(toLoadBalancerId, serverIdsToAdd);
	}

	@Override
	public AsyncResult<String> createLoadBalancer(LoadBalancerCreateOptions options)
			throws CloudException, InternalException {
		return support.createLoadBalancer(options);
	}

	@Override
	public LoadBalancerCapabilities getCapabilities() throws CloudException, InternalException {
		return support.getCapabilities();
	}

	@Override
	public AsyncResult<LoadBalancer> getLoadBalancer(String loadBalancerId) throws CloudException, InternalException {
		return support.getLoadBalancer(loadBalancerId);
	}

	@Override
	public boolean isSubscribed() throws CloudException, InternalException {
		return support.isSubscribed();
	}

	@Override
	public AsyncResult<Iterable<LoadBalancerEndpoint>> listEndpoints(String forLoadBalancerId)
			throws CloudException, InternalException {
		return support.listEndpoints(forLoadBalancerId);
	}

	@Override
	public AsyncResult<Iterable<LoadBalancerEndpoint>> listEndpoints(String forLoadBalancerId, LbEndpointType type,
			String... endpoints) throws CloudException, InternalException {
		return support.listEndpoints(forLoadBalancerId, type, endpoints);
	}

	@Override
	public AsyncResult<Iterable<LoadBalancer>> listLoadBalancers() throws CloudException, InternalException {
		return support.listLoadBalancers();
	}

	@Override
	public AsyncResult<Iterable<ResourceStatus>> listLoadBalancerStatus() throws CloudException, InternalException {
		return support.listLoadBalancerStatus();
	}

	@Override
	public AsyncResult<Void> removeDataCenters(String fromLoadBalancerId, String... dataCenterIdsToRemove)
			throws CloudException, InternalException {
		return support.removeDataCenters(fromLoadBalancerId, dataCenterIdsToRemove);
	}

	@Override
	public AsyncResult<Void> removeIPEndpoints(String fromLoadBalancerId, String... addresses)
			throws CloudException, InternalException {
		return support.removeIPEndpoints(fromLoadBalancerId, addresses);
	}

	@Override
	public AsyncResult<Void> removeLoadBalancer(String loadBalancerId) throws CloudException, InternalException {
		return support.removeLoadBalancer(loadBalancerId);
	}

	@Override
	public AsyncResult<Void> removeServers(String fromLoadBalancerId, String... serverIdsToRemove)
			throws CloudException, InternalException {
		return support.removeServers(fromLoadBalancerId, serverIdsToRemove);
	}

	@Override
	public AsyncResult<LoadBalancerHealthCheck> createLoadBalancerHealthCheck(String name, String description,
			String host, HCProtocol protocol, int port, String path, int interval, int timeout, int healthyCount,
			int unhealthyCount) throws CloudException, InternalException {
		return support.createLoadBalancerHealthCheck(name, description, host, protocol, port, path, interval, timeout, healthyCount, unhealthyCount);
	}

	@Override
	public AsyncResult<LoadBalancerHealthCheck> createLoadBalancerHealthCheck(HealthCheckOptions options)
			throws CloudException, InternalException {
		return support.createLoadBalancerHealthCheck(options);
	}

	@Override
	public AsyncResult<LoadBalancerHealthCheck> getLoadBalancerHealthCheck(String providerLBHealthCheckId,
			String providerLoadBalancerId) throws CloudException, InternalException {
		return support.getLoadBalancerHealthCheck(providerLBHealthCheckId, providerLoadBalancerId);
	}

	@Override
	public AsyncResult<Iterable<LoadBalancerHealthCheck>> listLBHealthChecks(HealthCheckFilterOptions options)
			throws CloudException, InternalException {
		return support.listLBHealthChecks(options);
	}

	@Override
	public AsyncResult<Void> attachHealthCheckToLoadBalancer(String providerLoadBalancerId,
			String providerLBHealthCheckId) throws CloudException, InternalException {
		return support.attachHealthCheckToLoadBalancer(providerLoadBalancerId, providerLBHealthCheckId);
	}

	@Override
	public AsyncResult<Void> detachHealthCheckFromLoadBalancer(String providerLoadBalancerId,
			String providerLBHeathCheckId) throws CloudException, InternalException {
		return support.detachHealthCheckFromLoadBalancer(providerLoadBalancerId, providerLBHeathCheckId);
	}

	@Override
	public AsyncResult<LoadBalancerHealthCheck> modifyHealthCheck(String providerLBHealthCheckId,
			HealthCheckOptions options) throws InternalException, CloudException {
		return support.modifyHealthCheck(providerLBHealthCheckId, options);
	}

	@Override
	public AsyncResult<Void> removeLoadBalancerHealthCheck(String providerLoadBalancerId)
			throws CloudException, InternalException {
		return support.removeLoadBalancerHealthCheck(providerLoadBalancerId);
	}

	@Override
	public AsyncResult<SSLCertificate> createSSLCertificate(SSLCertificateCreateOptions options)
			throws CloudException, InternalException {
		return support.createSSLCertificate(options);
	}

	@Override
	public AsyncResult<Iterable<SSLCertificate>> listSSLCertificates() throws CloudException, InternalException {
		return support.listSSLCertificates();
	}

	@Override
	public AsyncResult<Void> removeSSLCertificate(String certificateName) throws CloudException, InternalException {
		return support.removeSSLCertificate(certificateName);
	}

	@Override
	public AsyncResult<Void> setSSLCertificate(SetLoadBalancerSSLCertificateOptions options)
			throws CloudException, InternalException {
		return support.setSSLCertificate(options);
	}

	@Override
	public AsyncResult<SSLCertificate> getSSLCertificate(String certificateName)
			throws CloudException, InternalException {
		return support.getSSLCertificate(certificateName);
	}

	@Override
	public AsyncResult<Void> setFirewalls(String providerLoadBalancerId, String... firewallIds)
			throws CloudException, InternalException {
		return support.setFirewalls(providerLoadBalancerId, firewallIds);
	}

	@Override
	public AsyncResult<Void> attachLoadBalancerToSubnets(String toLoadBalancerId, String... subnetIdsToAdd)
			throws CloudException, InternalException {
		return support.attachLoadBalancerToSubnets(toLoadBalancerId, subnetIdsToAdd);
	}

	@Override
	public AsyncResult<Void> detachLoadBalancerFromSubnets(String fromLoadBalancerId, String... subnetIdsToDelete)
			throws CloudException, InternalException {
		return support.detachLoadBalancerFromSubnets(fromLoadBalancerId, subnetIdsToDelete);
	}

	@Override
	public AsyncResult<Void> modifyLoadBalancerAttributes(String id, LbAttributesOptions options)
			throws CloudException, InternalException {
		return support.modifyLoadBalancerAttributes(id, options);
	}

	@Override
	public AsyncResult<LbAttributesOptions> getLoadBalancerAttributes(String id)
			throws CloudException, InternalException {
		return support.getLoadBalancerAttributes(id);
	}

	@Override
	public AsyncResult<Void> removeTags(String loadBalancerId, Tag... tags) throws CloudException, InternalException {
		return support.removeTags(loadBalancerId, tags);
	}

	@Override
	public AsyncResult<Void> removeTags(String[] loadBalancerIds, Tag... tags)
			throws CloudException, InternalException {
		return support.removeTags(loadBalancerIds, tags);
	}

	@Override
	public AsyncResult<Void> updateTags(String loadBalancerId, Tag... tags) throws CloudException, InternalException {
		return support.updateTags(loadBalancerId, tags);
	}

	@Override
	public AsyncResult<Void> updateTags(String[] loadBalancerIds, Tag... tags)
			throws CloudException, InternalException {
		return support.updateTags(loadBalancerIds, tags);
	}

	@Override
	public AsyncResult<Void> setTags(String loadBalancerId, Tag... tags) throws CloudException, InternalException {
		return support.setTags(loadBalancerId, tags);
	}

	@Override
	public AsyncResult<Void> setTags(String[] loadBalancerIds, Tag... tags) throws CloudException, InternalException {
		return support.setTags(loadBalancerIds, tags);
	}

	@Override
	public LoadBalancerSupport getSupport() {
		return support.getSupport();
	}

}
