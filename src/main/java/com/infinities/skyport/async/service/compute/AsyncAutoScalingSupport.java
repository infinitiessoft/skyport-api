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
package com.infinities.skyport.async.service.compute;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.dasein.cloud.AccessControlledService;
import org.dasein.cloud.CloudException;
import org.dasein.cloud.InternalException;
import org.dasein.cloud.ResourceStatus;
import org.dasein.cloud.compute.AutoScalingGroupDeleteOptions;
import org.dasein.cloud.compute.AutoScalingGroupFilterOptions;
import org.dasein.cloud.compute.AutoScalingGroupNotificationConfig;
import org.dasein.cloud.compute.AutoScalingGroupOptions;
import org.dasein.cloud.compute.AutoScalingSupport;
import org.dasein.cloud.compute.AutoScalingTag;
import org.dasein.cloud.compute.LaunchConfiguration;
import org.dasein.cloud.compute.LaunchConfigurationCreateOptions;
import org.dasein.cloud.compute.ScalingGroup;
import org.dasein.cloud.compute.ScalingPolicy;
import org.dasein.cloud.compute.VirtualMachineProduct;
import org.dasein.cloud.identity.ServiceAction;

import com.infinities.skyport.async.AsyncResult;

public interface AsyncAutoScalingSupport extends AccessControlledService {

	static public final ServiceAction ANY = new ServiceAction("SCALING:ANY");

	static public final ServiceAction CREATE_LAUNCH_CONFIGURATION = new ServiceAction("SCALING:CREATE_LAUNCH_CONFIGURATION");
	static public final ServiceAction CREATE_SCALING_GROUP = new ServiceAction("SCALING:CREATE_SCALING_GROUP");
	static public final ServiceAction GET_LAUNCH_CONFIGURATION = new ServiceAction("SCALING:GET_LAUNCH_CONFIGURATION");
	static public final ServiceAction GET_SCALING_GROUP = new ServiceAction("SCALING:GET_SCALING_GROUP");
	static public final ServiceAction LIST_LAUNCH_CONFIGURATION = new ServiceAction("SCALING:LIST_LAUNCH_CONFIGURATION");
	static public final ServiceAction LIST_SCALING_GROUP = new ServiceAction("SCALING:LIST_SCALING_GROUP");
	static public final ServiceAction REMOVE_LAUNCH_CONFIGURATION = new ServiceAction("SCALING:REMOVE_LAUNCH_CONFIGURATION");
	static public final ServiceAction REMOVE_SCALING_GROUP = new ServiceAction("SCALING:REMOVE_SCALING_GROUP");
	static public final ServiceAction SET_CAPACITY = new ServiceAction("SCALING:SET_CAPACITY");
	static public final ServiceAction SET_SCALING_TRIGGER = new ServiceAction("SCALING:SET_SCALING_TRIGGER");
	static public final ServiceAction UPDATE_SCALING_GROUP = new ServiceAction("SCALING:UPDATE_SCALING_GROUP");
	static public final ServiceAction SUSPEND_AUTO_SCALING_GROUP = new ServiceAction("SCALING:SUSPEND_AUTO_SCALING_GROUP");
	static public final ServiceAction RESUME_AUTO_SCALING_GROUP = new ServiceAction("SCALING:RESUME_AUTO_SCALING_GROUP");
	static public final ServiceAction PUT_SCALING_POLICY = new ServiceAction("SCALING:PUT_SCALING_POLICY");
	static public final ServiceAction DELETE_SCALING_POLICY = new ServiceAction("SCALING:DELETE_SCALING_POLICY");
	static public final ServiceAction LIST_SCALING_POLICIES = new ServiceAction("SCALING:LIST_SCALING_POLICIES");


	/**
	 * Creates an auto scaling group with the provided options.
	 *
	 * @param options
	 *            the auto scaling group options
	 * @return the provider's auto scaling group id
	 * @throws InternalException
	 * @throws CloudException
	 */
	public AsyncResult<String> createAutoScalingGroup(@Nonnull AutoScalingGroupOptions options) throws InternalException,
			CloudException;

	public AsyncResult<Void> updateAutoScalingGroup(String scalingGroupId, @Nullable String launchConfigurationId,
			@Nullable Integer minServers, @Nullable Integer maxServers, @Nullable Integer cooldown,
			@Nullable Integer desiredCapacity, @Nullable Integer healthCheckGracePeriod, @Nullable String healthCheckType,
			@Nullable String vpcZones, @Nullable String... zoneIds) throws InternalException, CloudException;

	public AsyncResult<String> createLaunchConfiguration(String name, String imageId, VirtualMachineProduct size,
			String keyPairName, String userData, String providerRoleId, Boolean detailedMonitoring, String... firewalls)
			throws InternalException, CloudException;

	/**
	 * Created an Auto Scaling Launch Configuration based on passed options
	 *
	 * @param options
	 *            the auto scaling launch configuration options
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	public AsyncResult<String> createLaunchConfiguration(@Nonnull LaunchConfigurationCreateOptions options)
			throws InternalException, CloudException;

	public AsyncResult<Void> deleteAutoScalingGroup(String providerAutoScalingGroupId) throws CloudException,
			InternalException;

	/**
	 * Deletes an Auto Scaling group based on passed options
	 *
	 * @param options
	 *            the auto scaling group delete options
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	public AsyncResult<Void> deleteAutoScalingGroup(@Nonnull AutoScalingGroupDeleteOptions options) throws CloudException,
			InternalException;

	public AsyncResult<Void> deleteLaunchConfiguration(String providerLaunchConfigurationId) throws CloudException,
			InternalException;

	public AsyncResult<LaunchConfiguration> getLaunchConfiguration(String providerLaunchConfigurationId)
			throws CloudException, InternalException;

	public AsyncResult<ScalingGroup> getScalingGroup(String providerScalingGroupId) throws CloudException, InternalException;

	public boolean isSubscribed() throws CloudException, InternalException;

	public AsyncResult<Void> suspendAutoScaling(String providerScalingGroupId, String[] processesToSuspend)
			throws CloudException, InternalException;

	public AsyncResult<Void> resumeAutoScaling(String providerScalingGroupId, String[] processesToResume)
			throws CloudException, InternalException;

	public AsyncResult<String> updateScalingPolicy(String policyName, String adjustmentType, String autoScalingGroupName,
			Integer cooldown, Integer minAdjustmentStep, Integer scalingAdjustment) throws CloudException, InternalException;

	public AsyncResult<Void> deleteScalingPolicy(String policyName, String autoScalingGroupName) throws CloudException,
			InternalException;

	public AsyncResult<Iterable<ScalingPolicy>> listScalingPolicies(@Nullable String autoScalingGroupName)
			throws CloudException, InternalException;

	public AsyncResult<ScalingPolicy> getScalingPolicy(@Nonnull String policyName) throws CloudException, InternalException;

	public AsyncResult<Iterable<ResourceStatus>> listScalingGroupStatus() throws CloudException, InternalException;

	public AsyncResult<Iterable<ScalingGroup>> listScalingGroups(AutoScalingGroupFilterOptions options)
			throws CloudException, InternalException;

	public AsyncResult<Iterable<ScalingGroup>> listScalingGroups() throws CloudException, InternalException;

	public AsyncResult<Iterable<ResourceStatus>> listLaunchConfigurationStatus() throws CloudException, InternalException;

	public AsyncResult<Iterable<LaunchConfiguration>> listLaunchConfigurations() throws CloudException, InternalException;

	public AsyncResult<Void> setDesiredCapacity(String scalingGroupId, int capacity) throws CloudException,
			InternalException;

	public AsyncResult<String> setTrigger(String name, String scalingGroupId, String statistic, String unitOfMeasure,
			String metric, int periodInSeconds, double lowerThreshold, double upperThreshold, int lowerIncrement,
			boolean lowerIncrementAbsolute, int upperIncrement, boolean upperIncrementAbsolute, int breachDuration)
			throws InternalException, CloudException;

	/**
	 * Set notification configurations for scaling group.
	 *
	 * @param scalingGroupId
	 *            the auto scaling group id
	 * @param topic
	 *            the notification service topic
	 * @param notificationTypes
	 *            types to set
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	public AsyncResult<Void> setNotificationConfig(@Nonnull String scalingGroupId, @Nonnull String topic,
			@Nonnull String[] notificationTypes) throws CloudException, InternalException;

	/**
	 * Get list of notification configs for multiple auto scaling groups.
	 *
	 * @param scalingGroupIds
	 *            the auto scaling group ids
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	public AsyncResult<Iterable<AutoScalingGroupNotificationConfig>> listNotificationConfigs(final String[] scalingGroupIds)
			throws CloudException, InternalException;

	/**
	 * Updates meta-data for multiple auto scaling groups with the new values.
	 * It will not overwrite any value that currently exists unless it appears
	 * in the tags you submit.
	 *
	 * @param providerScalingGroupIds
	 *            the auto scaling groups to update
	 * @param tags
	 *            the meta-data tags to set
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	public AsyncResult<Void> updateTags(@Nonnull String[] providerScalingGroupIds, @Nonnull AutoScalingTag... tags)
			throws CloudException, InternalException;

	/**
	 * Removes meta-data from multiple auto scaling groups. If tag values are
	 * set, their removal is dependent on underlying cloud provider behavior.
	 * They may be removed only if the tag value matches or they may be removed
	 * regardless of the value.
	 *
	 * @param providerScalingGroupIds
	 *            the auto scaling groups to update
	 * @param tags
	 *            the meta-data tags to remove
	 * @throws CloudException
	 *             an error occurred within the cloud provider
	 * @throws InternalException
	 *             an error occurred within the Dasein Cloud API implementation
	 */
	public AsyncResult<Void> removeTags(@Nonnull String[] providerScalingGroupIds, @Nonnull AutoScalingTag... tags)
			throws CloudException, InternalException;

	/**
	 * Set meta-data for auto scaling group. Remove any tags that were not
	 * provided by the incoming tags, and add or overwrite any new or
	 * pre-existing tags.
	 *
	 * @param providerScalingGroupId
	 *            the auto scaling group to set
	 * @param tags
	 *            the meta-data tags to set
	 * @throws CloudException
	 * @throws InternalException
	 */
	public AsyncResult<Void> setTags(@Nonnull String providerScalingGroupId, @Nonnull AutoScalingTag... tags)
			throws CloudException, InternalException;

	/**
	 * Set meta-data for multiple auto scaling groups. Remove any tags that were
	 * not provided by the incoming tags, and add or overwrite any new or
	 * pre-existing tags.
	 *
	 * @param providerScalingGroupIds
	 *            the auto scaling groups to set
	 * @param tags
	 *            the meta-data tags to set
	 * @throws CloudException
	 * @throws InternalException
	 */
	public AsyncResult<Void> setTags(@Nonnull String[] providerScalingGroupIds, @Nonnull AutoScalingTag... tags)
			throws CloudException, InternalException;

	AutoScalingSupport getSupport();
}
