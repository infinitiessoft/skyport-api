package com.infinities.skyport.timeout.service;

import java.util.concurrent.ExecutorService;

import org.dasein.cloud.ci.CIServices;
import org.dasein.cloud.ci.ConvergedHttpLoadBalancerSupport;
import org.dasein.cloud.ci.ConvergedInfrastructureSupport;
import org.dasein.cloud.ci.TopologySupport;

import com.infinities.skyport.exception.InitializationException;
import com.infinities.skyport.model.configuration.service.CIConfiguration;
import com.infinities.skyport.timeout.ServiceProviderTimeLimiter;

public class TimedCIServices implements CIServices {

	private final CIServices inner;
	private ConvergedInfrastructureSupport timedConvergedInfrastructureSupport;
	private ConvergedHttpLoadBalancerSupport timedConvergedHttpLoadBalancerSupport;
	private TopologySupport timedTopologySupport;


	public TimedCIServices(CIServices inner, CIConfiguration ciConfiguration, ExecutorService executor)
			throws InitializationException {
		this.inner = inner;
		ServiceProviderTimeLimiter timedLimiter = new ServiceProviderTimeLimiter(executor);
		if (inner.hasConvergedInfrastructureSupport()) {
			this.timedConvergedInfrastructureSupport =
					timedLimiter.newProxy(inner.getConvergedInfrastructureSupport(), ConvergedInfrastructureSupport.class,
							ciConfiguration.getConvergedInfrastructureConfiguration());
		}
		if (inner.hasConvergedHttpLoadBalancerSupport()) {
			this.timedConvergedHttpLoadBalancerSupport =
					timedLimiter.newProxy(inner.getConvergedHttpLoadBalancerSupport(),
							ConvergedHttpLoadBalancerSupport.class,
							ciConfiguration.getConvergedHttpLoadBalancerConfiguration());
		}
		if (inner.hasTopologySupport()) {
			this.timedTopologySupport =
					timedLimiter.newProxy(inner.getTopologySupport(), TopologySupport.class,
							ciConfiguration.getTopologyConfiguration());
		}
	}

	@Override
	public boolean hasConvergedInfrastructureSupport() {
		return inner.hasConvergedInfrastructureSupport();
	}

	@Override
	public ConvergedInfrastructureSupport getConvergedInfrastructureSupport() {
		return this.timedConvergedInfrastructureSupport;
	}

	@Override
	public boolean hasConvergedHttpLoadBalancerSupport() {
		return inner.hasConvergedHttpLoadBalancerSupport();
	}

	@Override
	public ConvergedHttpLoadBalancerSupport getConvergedHttpLoadBalancerSupport() {
		return this.timedConvergedHttpLoadBalancerSupport;
	}

	@Override
	public boolean hasTopologySupport() {
		return inner.hasTopologySupport();
	}

	@Override
	public TopologySupport getTopologySupport() {
		return this.timedTopologySupport;
	}

}
