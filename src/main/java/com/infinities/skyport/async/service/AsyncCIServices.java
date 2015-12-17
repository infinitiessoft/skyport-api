package com.infinities.skyport.async.service;

import javax.annotation.Nullable;

import com.infinities.skyport.async.service.ci.AsyncConvergedHttpLoadBalancerSupport;
import com.infinities.skyport.async.service.ci.AsyncConvergedInfrastructureSupport;
import com.infinities.skyport.async.service.ci.AsyncTopologySupport;

public interface AsyncCIServices {

	public boolean hasConvergedInfrastructureSupport(); // replica pools

	public @Nullable AsyncConvergedInfrastructureSupport getConvergedInfrastructureSupport();

	public boolean hasConvergedHttpLoadBalancerSupport();

	public @Nullable AsyncConvergedHttpLoadBalancerSupport getConvergedHttpLoadBalancerSupport();

	/**
	 * @return indicates whether or not the cloud provider supports complex
	 *         resource topologies
	 */
	public boolean hasTopologySupport(); // templates

	public @Nullable AsyncTopologySupport getTopologySupport();

	void initialize() throws Exception;

	void close();

}
