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
package com.infinities.skyport.proxy;

import java.io.Serializable;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.dasein.cloud.compute.VolumeProduct;
import org.dasein.cloud.compute.VolumeType;
import org.dasein.util.uom.storage.Gigabyte;
import org.dasein.util.uom.storage.Storage;

public class VolumeProductProxy implements Serializable {

	private static final long serialVersionUID = 1L;
	private String configName;
	private String configId;
	private String currency;
	private String description;
	private Float iopsCost;
	private int maxIops;
	private int minIops;
	private Float monthlyGigabyteCost;
	private String name;
	private String providerProductId;
	private transient Storage<Gigabyte> volumeSize;
	private transient Storage<Gigabyte> minVolumeSize;
	private transient Storage<Gigabyte> maxVolumeSize;
	private VolumeType type;
	private Float maxIopsRatio;


	@SuppressWarnings("deprecation")
	public VolumeProductProxy(VolumeProduct product, String configName, String configId) {
		this.currency = product.getCurrency();
		this.description = product.getDescription();
		this.iopsCost = product.getIopsCost();
		this.maxIops = product.getMaxIops();
		this.minIops = product.getMinIops();
		this.monthlyGigabyteCost = product.getMonthlyGigabyteCost();
		this.name = product.getName();
		this.providerProductId = product.getProviderProductId();
		this.volumeSize = product.getVolumeSize();
		this.minVolumeSize = product.getMinVolumeSize();
		this.maxVolumeSize = product.getMaxVolumeSize();
		this.type = product.getType();
		this.maxIopsRatio = product.getMaxIopsRatio();
		this.configId = configId;
		this.configName = configName;
	}

	public VolumeProduct getProduct() {
		return VolumeProduct.getInstance(providerProductId, configName, description, type, volumeSize, currency, minIops,
				maxIops, monthlyGigabyteCost, iopsCost);
	}

	public String getConfigName() {
		return configName;
	}

	public void setConfigName(String configName) {
		this.configName = configName;
	}

	public String getConfigId() {
		return configId;
	}

	public void setConfigId(String configId) {
		this.configId = configId;
	}

	public @Nullable String getCurrency() {
		return this.currency;
	}

	public @Nonnull String getDescription() {
		return this.description;
	}

	public @Nonnegative int getMaxIops() {
		return this.maxIops;
	}

	public @Nonnegative int getMinIops() {
		return this.minIops;
	}

	public @Nullable Float getIopsCost() {
		return this.iopsCost;
	}

	public @Nonnull String getName() {
		return this.name;
	}

	public @Nullable Float getMonthlyGigabyteCost() {
		return this.monthlyGigabyteCost;
	}

	public @Nonnull String getProviderProductId() {
		return this.providerProductId;
	}

	public @Nonnull VolumeType getType() {
		return this.type;
	}

	@Deprecated
	public @Nullable Storage<Gigabyte> getVolumeSize() {
		return this.volumeSize;
	}

	public @Nullable Storage<Gigabyte> getMinVolumeSize() {
		return this.minVolumeSize;
	}

	public @Nullable Storage<Gigabyte> getMaxVolumeSize() {
		return this.maxVolumeSize;
	}

	public @Nullable Float getMaxIopsRatio() {
		return this.maxIopsRatio;
	}

}
