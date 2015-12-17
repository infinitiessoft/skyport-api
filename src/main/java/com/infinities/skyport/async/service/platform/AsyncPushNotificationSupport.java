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
package com.infinities.skyport.async.service.platform;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.dasein.cloud.AccessControlledService;
import org.dasein.cloud.CloudException;
import org.dasein.cloud.DataFormat;
import org.dasein.cloud.InternalException;
import org.dasein.cloud.ResourceStatus;
import org.dasein.cloud.identity.ServiceAction;
import org.dasein.cloud.platform.EndpointType;
import org.dasein.cloud.platform.PushNotificationCapabilities;
import org.dasein.cloud.platform.PushNotificationSupport;
import org.dasein.cloud.platform.Subscription;
import org.dasein.cloud.platform.Topic;

import com.infinities.skyport.async.AsyncResult;

public interface AsyncPushNotificationSupport extends AccessControlledService {

	static public final ServiceAction ANY = new ServiceAction("PUSH:ANY");

	static public final ServiceAction CREATE_TOPIC = new ServiceAction("PUSH:CREATE_TOPIC");
	static public final ServiceAction GET_TOPIC = new ServiceAction("PUSH:GET_TOPIC");
	static public final ServiceAction LIST_TOPIC = new ServiceAction("PUSH:LIST_TOPIC");
	static public final ServiceAction PUBLISH = new ServiceAction("PUSH:PUBLISH");
	static public final ServiceAction REMOVE_TOPIC = new ServiceAction("PUSH:REMOVE_TOPIC");
	static public final ServiceAction SUBSCRIBE = new ServiceAction("PUSH:SUBSCRIBE");
	static public final ServiceAction UNSUBSCRIBE = new ServiceAction("PUSH:UNSUBSCRIBE");


	public AsyncResult<String> confirmSubscription(String providerTopicId, String token, boolean authenticateUnsubscribe)
			throws CloudException, InternalException;

	public AsyncResult<Topic> createTopic(String name) throws CloudException, InternalException;

	/**
	 * Gets the details of a single Topic.
	 * 
	 * @param providerTopicId
	 *            the provider topic id
	 * @return the topic
	 * @throws CloudException
	 * @throws InternalException
	 */
	public @Nullable AsyncResult<Topic> getTopic(@Nonnull String providerTopicId) throws CloudException, InternalException;

	/**
	 * Provides access to meta-data about Push Notification capabilities in the
	 * current region of this cloud.
	 * 
	 * @return a description of the features supported by this region of this
	 *         cloud
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 */
	public @Nonnull PushNotificationCapabilities getCapabilities() throws InternalException, CloudException;

	public boolean isSubscribed() throws CloudException, InternalException;

	public @Nonnull AsyncResult<Iterable<Subscription>> listSubscriptions(String optionalTopicId) throws CloudException,
			InternalException;

	public @Nonnull AsyncResult<Iterable<ResourceStatus>> listTopicStatus() throws CloudException, InternalException;

	public @Nonnull AsyncResult<Iterable<Topic>> listTopics() throws CloudException, InternalException;

	public AsyncResult<String> publish(String providerTopicId, String subject, String message) throws CloudException,
			InternalException;

	public AsyncResult<Void> removeTopic(String providerTopicId) throws CloudException, InternalException;

	public AsyncResult<Void> subscribe(String providerTopicId, EndpointType endpointType, DataFormat dataFormat,
			String endpoint) throws CloudException, InternalException;

	public AsyncResult<Void> unsubscribe(String providerSubscriptionId) throws CloudException, InternalException;

	PushNotificationSupport getSupport();
}
