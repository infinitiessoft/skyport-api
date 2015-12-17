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
package com.infinities.skyport.model.configuration.platform;

import java.io.Serializable;

import com.infinities.skyport.model.FunctionConfiguration;

public class MonitoringConfiguration implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	private FunctionConfiguration listMetrics = new FunctionConfiguration();
	private FunctionConfiguration listAlarms = new FunctionConfiguration();
	private FunctionConfiguration updateAlarm = new FunctionConfiguration();
	private FunctionConfiguration removeAlarms = new FunctionConfiguration();
	private FunctionConfiguration enableAlarmActions = new FunctionConfiguration();
	private FunctionConfiguration disableAlarmActions = new FunctionConfiguration();


	public FunctionConfiguration getListMetrics() {
		return listMetrics;
	}

	public void setListMetrics(FunctionConfiguration listMetrics) {
		this.listMetrics = listMetrics;
	}

	public FunctionConfiguration getListAlarms() {
		return listAlarms;
	}

	public void setListAlarms(FunctionConfiguration listAlarms) {
		this.listAlarms = listAlarms;
	}

	public FunctionConfiguration getUpdateAlarm() {
		return updateAlarm;
	}

	public void setUpdateAlarm(FunctionConfiguration updateAlarm) {
		this.updateAlarm = updateAlarm;
	}

	public FunctionConfiguration getRemoveAlarms() {
		return removeAlarms;
	}

	public void setRemoveAlarms(FunctionConfiguration removeAlarms) {
		this.removeAlarms = removeAlarms;
	}

	public FunctionConfiguration getEnableAlarmActions() {
		return enableAlarmActions;
	}

	public void setEnableAlarmActions(FunctionConfiguration enableAlarmActions) {
		this.enableAlarmActions = enableAlarmActions;
	}

	public FunctionConfiguration getDisableAlarmActions() {
		return disableAlarmActions;
	}

	public void setDisableAlarmActions(FunctionConfiguration disableAlarmActions) {
		this.disableAlarmActions = disableAlarmActions;
	}

	@Override
	public MonitoringConfiguration clone() {
		MonitoringConfiguration clone = new MonitoringConfiguration();
		clone.listMetrics = listMetrics.clone();
		clone.listAlarms = listAlarms.clone();
		clone.updateAlarm = updateAlarm.clone();
		clone.removeAlarms = removeAlarms.clone();
		clone.enableAlarmActions = enableAlarmActions.clone();
		clone.disableAlarmActions = disableAlarmActions.clone();
		return clone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((disableAlarmActions == null) ? 0 : disableAlarmActions.hashCode());
		result = prime * result + ((enableAlarmActions == null) ? 0 : enableAlarmActions.hashCode());
		result = prime * result + ((listAlarms == null) ? 0 : listAlarms.hashCode());
		result = prime * result + ((listMetrics == null) ? 0 : listMetrics.hashCode());
		result = prime * result + ((removeAlarms == null) ? 0 : removeAlarms.hashCode());
		result = prime * result + ((updateAlarm == null) ? 0 : updateAlarm.hashCode());
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
		MonitoringConfiguration other = (MonitoringConfiguration) obj;
		if (disableAlarmActions == null) {
			if (other.disableAlarmActions != null)
				return false;
		} else if (!disableAlarmActions.equals(other.disableAlarmActions))
			return false;
		if (enableAlarmActions == null) {
			if (other.enableAlarmActions != null)
				return false;
		} else if (!enableAlarmActions.equals(other.enableAlarmActions))
			return false;
		if (listAlarms == null) {
			if (other.listAlarms != null)
				return false;
		} else if (!listAlarms.equals(other.listAlarms))
			return false;
		if (listMetrics == null) {
			if (other.listMetrics != null)
				return false;
		} else if (!listMetrics.equals(other.listMetrics))
			return false;
		if (removeAlarms == null) {
			if (other.removeAlarms != null)
				return false;
		} else if (!removeAlarms.equals(other.removeAlarms))
			return false;
		if (updateAlarm == null) {
			if (other.updateAlarm != null)
				return false;
		} else if (!updateAlarm.equals(other.updateAlarm))
			return false;
		return true;
	}

}
