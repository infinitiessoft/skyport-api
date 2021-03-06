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

import com.infinities.skyport.async.service.admin.AsyncAccountSupport;
import com.infinities.skyport.async.service.admin.AsyncBillingSupport;
import com.infinities.skyport.async.service.admin.AsyncPrepaymentSupport;

public interface AsyncAdminServices {

	public @Nullable AsyncPrepaymentSupport getPrepaymentSupport();

	public boolean hasPrepaymentSupport();

	public @Nullable AsyncAccountSupport getAccountSupport();

	public boolean hasAccountSupport();

	public @Nullable AsyncBillingSupport getBillingSupport();

	public boolean hasBillingSupport();

	void initialize() throws Exception;

	void close();
}
