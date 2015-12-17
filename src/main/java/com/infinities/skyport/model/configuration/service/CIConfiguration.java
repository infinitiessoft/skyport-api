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
package com.infinities.skyport.model.configuration.service;

import java.io.Serializable;

import com.infinities.skyport.model.configuration.ci.ConvergedHttpLoadBalancerConfiguration;
import com.infinities.skyport.model.configuration.ci.ConvergedInfrastructureConfiguration;
import com.infinities.skyport.model.configuration.ci.TopologyConfiguration;

public class CIConfiguration implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ConvergedInfrastructureConfiguration convergedInfrastructureConfiguration = new ConvergedInfrastructureConfiguration();
	private ConvergedHttpLoadBalancerConfiguration convergedHttpLoadBalancerConfiguration = new ConvergedHttpLoadBalancerConfiguration();
	private TopologyConfiguration topologyConfiguration = new TopologyConfiguration();


	public ConvergedInfrastructureConfiguration getConvergedInfrastructureConfiguration() {
		return convergedInfrastructureConfiguration;
	}

	public void setConvergedInfrastructureConfiguration(
			ConvergedInfrastructureConfiguration convergedInfrastructureConfiguration) {
		this.convergedInfrastructureConfiguration = convergedInfrastructureConfiguration;
	}

	public ConvergedHttpLoadBalancerConfiguration getConvergedHttpLoadBalancerConfiguration() {
		return convergedHttpLoadBalancerConfiguration;
	}

	public void setConvergedHttpLoadBalancerConfiguration(
			ConvergedHttpLoadBalancerConfiguration convergedHttpLoadBalancerConfiguration) {
		this.convergedHttpLoadBalancerConfiguration = convergedHttpLoadBalancerConfiguration;
	}

	public TopologyConfiguration getTopologyConfiguration() {
		return topologyConfiguration;
	}

	public void setTopologyConfiguration(TopologyConfiguration topologyConfiguration) {
		this.topologyConfiguration = topologyConfiguration;
	}

	@Override
	public CIConfiguration clone() {
		CIConfiguration clone = new CIConfiguration();
		clone.setConvergedHttpLoadBalancerConfiguration(getConvergedHttpLoadBalancerConfiguration().clone());
		clone.setConvergedInfrastructureConfiguration(getConvergedInfrastructureConfiguration().clone());
		clone.setTopologyConfiguration(getTopologyConfiguration().clone());
		return clone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((convergedHttpLoadBalancerConfiguration == null) ? 0 : convergedHttpLoadBalancerConfiguration.hashCode());
		result = prime * result
				+ ((convergedInfrastructureConfiguration == null) ? 0 : convergedInfrastructureConfiguration.hashCode());
		result = prime * result + ((topologyConfiguration == null) ? 0 : topologyConfiguration.hashCode());
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
		CIConfiguration other = (CIConfiguration) obj;
		if (convergedHttpLoadBalancerConfiguration == null) {
			if (other.convergedHttpLoadBalancerConfiguration != null)
				return false;
		} else if (!convergedHttpLoadBalancerConfiguration.equals(other.convergedHttpLoadBalancerConfiguration))
			return false;
		if (convergedInfrastructureConfiguration == null) {
			if (other.convergedInfrastructureConfiguration != null)
				return false;
		} else if (!convergedInfrastructureConfiguration.equals(other.convergedInfrastructureConfiguration))
			return false;
		if (topologyConfiguration == null) {
			if (other.topologyConfiguration != null)
				return false;
		} else if (!topologyConfiguration.equals(other.topologyConfiguration))
			return false;
		return true;
	}

}
