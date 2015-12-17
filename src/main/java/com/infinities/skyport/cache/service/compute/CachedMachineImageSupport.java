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
package com.infinities.skyport.cache.service.compute;

import com.google.common.eventbus.Subscribe;
import com.infinities.skyport.async.service.compute.AsyncMachineImageSupport;
import com.infinities.skyport.service.EntityListener;
import com.infinities.skyport.service.event.compute.machineimage.MachineImageFailureEvent;
import com.infinities.skyport.service.event.compute.machineimage.MachineImageRefreshedEvent;

public interface CachedMachineImageSupport extends AsyncMachineImageSupport {

	public void addMachineImageListener(CachedMachineImageListener service);

	public void removeMachineImageListener(CachedMachineImageListener service);


	public interface CachedMachineImageListener extends EntityListener {

		@Subscribe
		public void onEntitiesRefreshed(MachineImageRefreshedEvent e) throws Exception;

		@Subscribe
		public void onFailure(MachineImageFailureEvent e);
	}
}
