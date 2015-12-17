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

public class RelationalDatabaseConfiguration implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	private FunctionConfiguration addAccess = new FunctionConfiguration();
	private FunctionConfiguration alterDatabase = new FunctionConfiguration();
	private FunctionConfiguration createFromScratch = new FunctionConfiguration();
	private FunctionConfiguration createFromLatest = new FunctionConfiguration();
	private FunctionConfiguration createFromSnapshot = new FunctionConfiguration();
	private FunctionConfiguration createFromTimestamp = new FunctionConfiguration();
	private FunctionConfiguration getConfiguration = new FunctionConfiguration();
	private FunctionConfiguration getDatabase = new FunctionConfiguration();
	private FunctionConfiguration getDatabaseEngines = new FunctionConfiguration();
	private FunctionConfiguration getDefaultVersion = new FunctionConfiguration();
	private FunctionConfiguration getSupportedVersions = new FunctionConfiguration();
	private FunctionConfiguration listDatabaseProducts = new FunctionConfiguration();
	private FunctionConfiguration getSnapshot = new FunctionConfiguration();
	private FunctionConfiguration listAccess = new FunctionConfiguration();
	private FunctionConfiguration listConfigurations = new FunctionConfiguration();
	private FunctionConfiguration listDatabaseStatus = new FunctionConfiguration();
	private FunctionConfiguration listDatabases = new FunctionConfiguration();
	private FunctionConfiguration listParameters = new FunctionConfiguration();
	private FunctionConfiguration listSnapshots = new FunctionConfiguration();
	private FunctionConfiguration removeConfiguration = new FunctionConfiguration();
	private FunctionConfiguration removeDatabase = new FunctionConfiguration();
	private FunctionConfiguration removeSnapshot = new FunctionConfiguration();
	private FunctionConfiguration resetConfiguration = new FunctionConfiguration();
	private FunctionConfiguration restart = new FunctionConfiguration();
	private FunctionConfiguration revokeAccess = new FunctionConfiguration();
	private FunctionConfiguration updateConfiguration = new FunctionConfiguration();
	private FunctionConfiguration snapshot = new FunctionConfiguration();
	private FunctionConfiguration getUsableBackup = new FunctionConfiguration();
	private FunctionConfiguration listBackups = new FunctionConfiguration();
	private FunctionConfiguration createFromBackup = new FunctionConfiguration();
	private FunctionConfiguration removeBackup = new FunctionConfiguration();
	private FunctionConfiguration restoreBackup = new FunctionConfiguration();
	private FunctionConfiguration removeTags = new FunctionConfiguration();
	private FunctionConfiguration updateTags = new FunctionConfiguration();
	private FunctionConfiguration setTags = new FunctionConfiguration();


	public FunctionConfiguration getAddAccess() {
		return addAccess;
	}

	public void setAddAccess(FunctionConfiguration addAccess) {
		this.addAccess = addAccess;
	}

	public FunctionConfiguration getAlterDatabase() {
		return alterDatabase;
	}

	public void setAlterDatabase(FunctionConfiguration alterDatabase) {
		this.alterDatabase = alterDatabase;
	}

	public FunctionConfiguration getCreateFromScratch() {
		return createFromScratch;
	}

	public void setCreateFromScratch(FunctionConfiguration createFromScratch) {
		this.createFromScratch = createFromScratch;
	}

	public FunctionConfiguration getCreateFromLatest() {
		return createFromLatest;
	}

	public void setCreateFromLatest(FunctionConfiguration createFromLatest) {
		this.createFromLatest = createFromLatest;
	}

	public FunctionConfiguration getCreateFromSnapshot() {
		return createFromSnapshot;
	}

	public void setCreateFromSnapshot(FunctionConfiguration createFromSnapshot) {
		this.createFromSnapshot = createFromSnapshot;
	}

	public FunctionConfiguration getCreateFromTimestamp() {
		return createFromTimestamp;
	}

	public void setCreateFromTimestamp(FunctionConfiguration createFromTimestamp) {
		this.createFromTimestamp = createFromTimestamp;
	}

	public FunctionConfiguration getGetConfiguration() {
		return getConfiguration;
	}

	public void setGetConfiguration(FunctionConfiguration getConfiguration) {
		this.getConfiguration = getConfiguration;
	}

	public FunctionConfiguration getGetDatabase() {
		return getDatabase;
	}

	public void setGetDatabase(FunctionConfiguration getDatabase) {
		this.getDatabase = getDatabase;
	}

	public FunctionConfiguration getGetDatabaseEngines() {
		return getDatabaseEngines;
	}

	public void setGetDatabaseEngines(FunctionConfiguration getDatabaseEngines) {
		this.getDatabaseEngines = getDatabaseEngines;
	}

	public FunctionConfiguration getGetDefaultVersion() {
		return getDefaultVersion;
	}

	public void setGetDefaultVersion(FunctionConfiguration getDefaultVersion) {
		this.getDefaultVersion = getDefaultVersion;
	}

	public FunctionConfiguration getGetSupportedVersions() {
		return getSupportedVersions;
	}

	public void setGetSupportedVersions(FunctionConfiguration getSupportedVersions) {
		this.getSupportedVersions = getSupportedVersions;
	}

	public FunctionConfiguration getListDatabaseProducts() {
		return listDatabaseProducts;
	}

	public void setListDatabaseProducts(FunctionConfiguration listDatabaseProducts) {
		this.listDatabaseProducts = listDatabaseProducts;
	}

	public FunctionConfiguration getGetSnapshot() {
		return getSnapshot;
	}

	public void setGetSnapshot(FunctionConfiguration getSnapshot) {
		this.getSnapshot = getSnapshot;
	}

	public FunctionConfiguration getListAccess() {
		return listAccess;
	}

	public void setListAccess(FunctionConfiguration listAccess) {
		this.listAccess = listAccess;
	}

	public FunctionConfiguration getListConfigurations() {
		return listConfigurations;
	}

	public void setListConfigurations(FunctionConfiguration listConfigurations) {
		this.listConfigurations = listConfigurations;
	}

	public FunctionConfiguration getListDatabaseStatus() {
		return listDatabaseStatus;
	}

	public void setListDatabaseStatus(FunctionConfiguration listDatabaseStatus) {
		this.listDatabaseStatus = listDatabaseStatus;
	}

	public FunctionConfiguration getListDatabases() {
		return listDatabases;
	}

	public void setListDatabases(FunctionConfiguration listDatabases) {
		this.listDatabases = listDatabases;
	}

	public FunctionConfiguration getListParameters() {
		return listParameters;
	}

	public void setListParameters(FunctionConfiguration listParameters) {
		this.listParameters = listParameters;
	}

	public FunctionConfiguration getListSnapshots() {
		return listSnapshots;
	}

	public void setListSnapshots(FunctionConfiguration listSnapshots) {
		this.listSnapshots = listSnapshots;
	}

	public FunctionConfiguration getRemoveConfiguration() {
		return removeConfiguration;
	}

	public void setRemoveConfiguration(FunctionConfiguration removeConfiguration) {
		this.removeConfiguration = removeConfiguration;
	}

	public FunctionConfiguration getRemoveDatabase() {
		return removeDatabase;
	}

	public void setRemoveDatabase(FunctionConfiguration removeDatabase) {
		this.removeDatabase = removeDatabase;
	}

	public FunctionConfiguration getRemoveSnapshot() {
		return removeSnapshot;
	}

	public void setRemoveSnapshot(FunctionConfiguration removeSnapshot) {
		this.removeSnapshot = removeSnapshot;
	}

	public FunctionConfiguration getResetConfiguration() {
		return resetConfiguration;
	}

	public void setResetConfiguration(FunctionConfiguration resetConfiguration) {
		this.resetConfiguration = resetConfiguration;
	}

	public FunctionConfiguration getRestart() {
		return restart;
	}

	public void setRestart(FunctionConfiguration restart) {
		this.restart = restart;
	}

	public FunctionConfiguration getRevokeAccess() {
		return revokeAccess;
	}

	public void setRevokeAccess(FunctionConfiguration revokeAccess) {
		this.revokeAccess = revokeAccess;
	}

	public FunctionConfiguration getUpdateConfiguration() {
		return updateConfiguration;
	}

	public void setUpdateConfiguration(FunctionConfiguration updateConfiguration) {
		this.updateConfiguration = updateConfiguration;
	}

	public FunctionConfiguration getSnapshot() {
		return snapshot;
	}

	public void setSnapshot(FunctionConfiguration snapshot) {
		this.snapshot = snapshot;
	}

	public FunctionConfiguration getGetUsableBackup() {
		return getUsableBackup;
	}

	public void setGetUsableBackup(FunctionConfiguration getUsableBackup) {
		this.getUsableBackup = getUsableBackup;
	}

	public FunctionConfiguration getListBackups() {
		return listBackups;
	}

	public void setListBackups(FunctionConfiguration listBackups) {
		this.listBackups = listBackups;
	}

	public FunctionConfiguration getCreateFromBackup() {
		return createFromBackup;
	}

	public void setCreateFromBackup(FunctionConfiguration createFromBackup) {
		this.createFromBackup = createFromBackup;
	}

	public FunctionConfiguration getRemoveBackup() {
		return removeBackup;
	}

	public void setRemoveBackup(FunctionConfiguration removeBackup) {
		this.removeBackup = removeBackup;
	}

	public FunctionConfiguration getRestoreBackup() {
		return restoreBackup;
	}

	public void setRestoreBackup(FunctionConfiguration restoreBackup) {
		this.restoreBackup = restoreBackup;
	}

	public FunctionConfiguration getRemoveTags() {
		return removeTags;
	}

	public void setRemoveTags(FunctionConfiguration removeTags) {
		this.removeTags = removeTags;
	}

	public FunctionConfiguration getUpdateTags() {
		return updateTags;
	}

	public void setUpdateTags(FunctionConfiguration updateTags) {
		this.updateTags = updateTags;
	}

	public FunctionConfiguration getSetTags() {
		return setTags;
	}

	public void setSetTags(FunctionConfiguration setTags) {
		this.setTags = setTags;
	}

	@Override
	public RelationalDatabaseConfiguration clone() {
		RelationalDatabaseConfiguration clone = new RelationalDatabaseConfiguration();
		clone.addAccess = addAccess.clone();
		clone.alterDatabase = alterDatabase.clone();
		clone.createFromScratch = createFromScratch.clone();
		clone.createFromLatest = createFromLatest.clone();
		clone.createFromSnapshot = createFromSnapshot.clone();
		clone.createFromTimestamp = createFromTimestamp.clone();
		clone.getConfiguration = getConfiguration.clone();
		clone.getDatabase = getDatabase.clone();
		clone.getDatabaseEngines = getDatabaseEngines.clone();
		clone.getDefaultVersion = getDefaultVersion.clone();
		clone.getSupportedVersions = getSupportedVersions.clone();
		clone.listDatabaseProducts = listDatabaseProducts.clone();
		clone.getSnapshot = getSnapshot.clone();
		clone.listAccess = listAccess.clone();
		clone.listConfigurations = listConfigurations.clone();
		clone.listDatabaseStatus = listDatabaseStatus.clone();
		clone.listDatabases = listDatabases.clone();
		clone.listParameters = listParameters.clone();
		clone.listSnapshots = listSnapshots.clone();
		clone.removeConfiguration = removeConfiguration.clone();
		clone.removeDatabase = removeDatabase.clone();
		clone.removeSnapshot = removeSnapshot.clone();
		clone.resetConfiguration = resetConfiguration.clone();
		clone.restart = restart.clone();
		clone.revokeAccess = revokeAccess.clone();
		clone.updateConfiguration = updateConfiguration.clone();
		clone.snapshot = snapshot.clone();
		clone.getUsableBackup = getUsableBackup.clone();
		clone.listBackups = listBackups.clone();
		clone.createFromBackup = createFromBackup.clone();
		clone.removeBackup = removeBackup.clone();
		clone.restoreBackup = restoreBackup.clone();
		clone.removeTags = removeTags.clone();
		clone.updateTags = updateTags.clone();
		clone.setTags = setTags.clone();
		return clone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addAccess == null) ? 0 : addAccess.hashCode());
		result = prime * result + ((alterDatabase == null) ? 0 : alterDatabase.hashCode());
		result = prime * result + ((createFromBackup == null) ? 0 : createFromBackup.hashCode());
		result = prime * result + ((createFromLatest == null) ? 0 : createFromLatest.hashCode());
		result = prime * result + ((createFromScratch == null) ? 0 : createFromScratch.hashCode());
		result = prime * result + ((createFromSnapshot == null) ? 0 : createFromSnapshot.hashCode());
		result = prime * result + ((createFromTimestamp == null) ? 0 : createFromTimestamp.hashCode());
		result = prime * result + ((getConfiguration == null) ? 0 : getConfiguration.hashCode());
		result = prime * result + ((getDatabase == null) ? 0 : getDatabase.hashCode());
		result = prime * result + ((getDatabaseEngines == null) ? 0 : getDatabaseEngines.hashCode());
		result = prime * result + ((getDefaultVersion == null) ? 0 : getDefaultVersion.hashCode());
		result = prime * result + ((getSnapshot == null) ? 0 : getSnapshot.hashCode());
		result = prime * result + ((getSupportedVersions == null) ? 0 : getSupportedVersions.hashCode());
		result = prime * result + ((getUsableBackup == null) ? 0 : getUsableBackup.hashCode());
		result = prime * result + ((listAccess == null) ? 0 : listAccess.hashCode());
		result = prime * result + ((listBackups == null) ? 0 : listBackups.hashCode());
		result = prime * result + ((listConfigurations == null) ? 0 : listConfigurations.hashCode());
		result = prime * result + ((listDatabaseProducts == null) ? 0 : listDatabaseProducts.hashCode());
		result = prime * result + ((listDatabaseStatus == null) ? 0 : listDatabaseStatus.hashCode());
		result = prime * result + ((listDatabases == null) ? 0 : listDatabases.hashCode());
		result = prime * result + ((listParameters == null) ? 0 : listParameters.hashCode());
		result = prime * result + ((listSnapshots == null) ? 0 : listSnapshots.hashCode());
		result = prime * result + ((removeBackup == null) ? 0 : removeBackup.hashCode());
		result = prime * result + ((removeConfiguration == null) ? 0 : removeConfiguration.hashCode());
		result = prime * result + ((removeDatabase == null) ? 0 : removeDatabase.hashCode());
		result = prime * result + ((removeSnapshot == null) ? 0 : removeSnapshot.hashCode());
		result = prime * result + ((removeTags == null) ? 0 : removeTags.hashCode());
		result = prime * result + ((resetConfiguration == null) ? 0 : resetConfiguration.hashCode());
		result = prime * result + ((restart == null) ? 0 : restart.hashCode());
		result = prime * result + ((restoreBackup == null) ? 0 : restoreBackup.hashCode());
		result = prime * result + ((revokeAccess == null) ? 0 : revokeAccess.hashCode());
		result = prime * result + ((setTags == null) ? 0 : setTags.hashCode());
		result = prime * result + ((snapshot == null) ? 0 : snapshot.hashCode());
		result = prime * result + ((updateConfiguration == null) ? 0 : updateConfiguration.hashCode());
		result = prime * result + ((updateTags == null) ? 0 : updateTags.hashCode());
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
		RelationalDatabaseConfiguration other = (RelationalDatabaseConfiguration) obj;
		if (addAccess == null) {
			if (other.addAccess != null)
				return false;
		} else if (!addAccess.equals(other.addAccess))
			return false;
		if (alterDatabase == null) {
			if (other.alterDatabase != null)
				return false;
		} else if (!alterDatabase.equals(other.alterDatabase))
			return false;
		if (createFromBackup == null) {
			if (other.createFromBackup != null)
				return false;
		} else if (!createFromBackup.equals(other.createFromBackup))
			return false;
		if (createFromLatest == null) {
			if (other.createFromLatest != null)
				return false;
		} else if (!createFromLatest.equals(other.createFromLatest))
			return false;
		if (createFromScratch == null) {
			if (other.createFromScratch != null)
				return false;
		} else if (!createFromScratch.equals(other.createFromScratch))
			return false;
		if (createFromSnapshot == null) {
			if (other.createFromSnapshot != null)
				return false;
		} else if (!createFromSnapshot.equals(other.createFromSnapshot))
			return false;
		if (createFromTimestamp == null) {
			if (other.createFromTimestamp != null)
				return false;
		} else if (!createFromTimestamp.equals(other.createFromTimestamp))
			return false;
		if (getConfiguration == null) {
			if (other.getConfiguration != null)
				return false;
		} else if (!getConfiguration.equals(other.getConfiguration))
			return false;
		if (getDatabase == null) {
			if (other.getDatabase != null)
				return false;
		} else if (!getDatabase.equals(other.getDatabase))
			return false;
		if (getDatabaseEngines == null) {
			if (other.getDatabaseEngines != null)
				return false;
		} else if (!getDatabaseEngines.equals(other.getDatabaseEngines))
			return false;
		if (getDefaultVersion == null) {
			if (other.getDefaultVersion != null)
				return false;
		} else if (!getDefaultVersion.equals(other.getDefaultVersion))
			return false;
		if (getSnapshot == null) {
			if (other.getSnapshot != null)
				return false;
		} else if (!getSnapshot.equals(other.getSnapshot))
			return false;
		if (getSupportedVersions == null) {
			if (other.getSupportedVersions != null)
				return false;
		} else if (!getSupportedVersions.equals(other.getSupportedVersions))
			return false;
		if (getUsableBackup == null) {
			if (other.getUsableBackup != null)
				return false;
		} else if (!getUsableBackup.equals(other.getUsableBackup))
			return false;
		if (listAccess == null) {
			if (other.listAccess != null)
				return false;
		} else if (!listAccess.equals(other.listAccess))
			return false;
		if (listBackups == null) {
			if (other.listBackups != null)
				return false;
		} else if (!listBackups.equals(other.listBackups))
			return false;
		if (listConfigurations == null) {
			if (other.listConfigurations != null)
				return false;
		} else if (!listConfigurations.equals(other.listConfigurations))
			return false;
		if (listDatabaseProducts == null) {
			if (other.listDatabaseProducts != null)
				return false;
		} else if (!listDatabaseProducts.equals(other.listDatabaseProducts))
			return false;
		if (listDatabaseStatus == null) {
			if (other.listDatabaseStatus != null)
				return false;
		} else if (!listDatabaseStatus.equals(other.listDatabaseStatus))
			return false;
		if (listDatabases == null) {
			if (other.listDatabases != null)
				return false;
		} else if (!listDatabases.equals(other.listDatabases))
			return false;
		if (listParameters == null) {
			if (other.listParameters != null)
				return false;
		} else if (!listParameters.equals(other.listParameters))
			return false;
		if (listSnapshots == null) {
			if (other.listSnapshots != null)
				return false;
		} else if (!listSnapshots.equals(other.listSnapshots))
			return false;
		if (removeBackup == null) {
			if (other.removeBackup != null)
				return false;
		} else if (!removeBackup.equals(other.removeBackup))
			return false;
		if (removeConfiguration == null) {
			if (other.removeConfiguration != null)
				return false;
		} else if (!removeConfiguration.equals(other.removeConfiguration))
			return false;
		if (removeDatabase == null) {
			if (other.removeDatabase != null)
				return false;
		} else if (!removeDatabase.equals(other.removeDatabase))
			return false;
		if (removeSnapshot == null) {
			if (other.removeSnapshot != null)
				return false;
		} else if (!removeSnapshot.equals(other.removeSnapshot))
			return false;
		if (removeTags == null) {
			if (other.removeTags != null)
				return false;
		} else if (!removeTags.equals(other.removeTags))
			return false;
		if (resetConfiguration == null) {
			if (other.resetConfiguration != null)
				return false;
		} else if (!resetConfiguration.equals(other.resetConfiguration))
			return false;
		if (restart == null) {
			if (other.restart != null)
				return false;
		} else if (!restart.equals(other.restart))
			return false;
		if (restoreBackup == null) {
			if (other.restoreBackup != null)
				return false;
		} else if (!restoreBackup.equals(other.restoreBackup))
			return false;
		if (revokeAccess == null) {
			if (other.revokeAccess != null)
				return false;
		} else if (!revokeAccess.equals(other.revokeAccess))
			return false;
		if (setTags == null) {
			if (other.setTags != null)
				return false;
		} else if (!setTags.equals(other.setTags))
			return false;
		if (snapshot == null) {
			if (other.snapshot != null)
				return false;
		} else if (!snapshot.equals(other.snapshot))
			return false;
		if (updateConfiguration == null) {
			if (other.updateConfiguration != null)
				return false;
		} else if (!updateConfiguration.equals(other.updateConfiguration))
			return false;
		if (updateTags == null) {
			if (other.updateTags != null)
				return false;
		} else if (!updateTags.equals(other.updateTags))
			return false;
		return true;
	}

}
