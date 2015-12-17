package com.infinities.skyport.async.service.ci;

import java.util.Locale;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.dasein.cloud.AccessControlledService;
import org.dasein.cloud.CloudException;
import org.dasein.cloud.InternalException;
import org.dasein.cloud.ResourceStatus;
import org.dasein.cloud.Tag;
import org.dasein.cloud.ci.ConvergedHttpLoadBalancer;
import org.dasein.cloud.ci.HttpLoadBalancerCapabilities;

import com.infinities.skyport.async.AsyncResult;

public interface AsyncConvergedHttpLoadBalancerSupport extends AccessControlledService {

	public @Nonnull AsyncResult<String> getProviderTermForConvergedHttpLoadBalancer(@Nonnull Locale locale);

	public @Nullable AsyncResult<ConvergedHttpLoadBalancer> getConvergedHttpLoadBalancer(
			@Nonnull String convergedHttpLoadbalancerId) throws CloudException, InternalException;

	public boolean isSubscribed() throws CloudException, InternalException;

	public @Nonnull AsyncResult<Iterable<String>> listConvergedHttpLoadBalancers() throws CloudException, InternalException;

	public @Nonnull AsyncResult<Iterable<ResourceStatus>> listConvergedHttpLoadBalancerStatus() throws InternalException,
			CloudException;

	public AsyncResult<Void> updateTags(@Nonnull String convergedHttpLoadbalancerId, @Nonnull Tag... tags)
			throws CloudException, InternalException;

	public AsyncResult<Void> updateTags(@Nonnull String[] convergedHttpLoadbalancerIds, @Nonnull Tag... tags)
			throws CloudException, InternalException;

	public AsyncResult<Void> removeTags(@Nonnull String convergedHttpLoadbalancerId, @Nonnull Tag... tags)
			throws CloudException, InternalException;

	public AsyncResult<Void> removeTags(@Nonnull String[] convergedHttpLoadbalancerIds, @Nonnull Tag... tags)
			throws CloudException, InternalException;

	public AsyncResult<String> createConvergedHttpLoadBalancer(
			@Nonnull ConvergedHttpLoadBalancer withConvergedHttpLoadbalancerOptions) throws CloudException,
			InternalException;

	public AsyncResult<Void> removeConvergedHttpLoadBalancers(@Nonnull String globalForwardingRuleName)
			throws CloudException, InternalException;

	public HttpLoadBalancerCapabilities getCapabilities();

}
