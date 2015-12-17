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
