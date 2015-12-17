package com.infinities.skyport.proxy;

import java.io.Serializable;
import java.util.Map;

import javax.annotation.Nonnull;
import javax.xml.bind.annotation.XmlTransient;

import org.dasein.cloud.VisibleScope;
import org.dasein.cloud.compute.Architecture;
import org.dasein.cloud.compute.VirtualMachineProduct;
import org.dasein.util.uom.storage.Gigabyte;
import org.dasein.util.uom.storage.Megabyte;
import org.dasein.util.uom.storage.Storage;

public class VirtualMachineProductProxy extends VirtualMachineProduct implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlTransient
	private volatile VirtualMachineProduct product;
	private String configName;
	private String configId;


	public VirtualMachineProductProxy(VirtualMachineProduct product, String configName, String configId) {
		super();
		this.product = product;
		this.configName = configName;
		this.configId = configId;
	}

	public VirtualMachineProduct getProduct() {
		return product;
	}

	public void setProduct(VirtualMachineProduct product) {
		this.product = product;
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

	@Override
	public String getName() {
		return getProduct().getName();
	}

	@Override
	public int getCpuCount() {
		return getProduct().getCpuCount();
	}

	@Override
	public String getDescription() {
		return getProduct().getDescription();
	}

	@Override
	public String getProviderProductId() {
		return getProduct().getProviderProductId();
	}

	@Override
	public Storage<Gigabyte> getRootVolumeSize() {
		return getProduct().getRootVolumeSize();
	}

	@Override
	public Storage<Megabyte> getRamSize() {
		return getProduct().getRamSize();
	}

	@Override
	public float getStandardHourlyRate() {
		return getProduct().getStandardHourlyRate();
	}

	@Override
	public VisibleScope getVisibleScope() {
		return getProduct().getVisibleScope();
	}

	@Override
	public String getDataCenterId() {
		return getProduct().getDataCenterId();
	}

	@Override
	public Status getStatus() {
		return getProduct().getStatus();
	}

	/**
	 * List of supported architectures. This is of type List as opposed to
	 * Iterable as this is a model class, so all data is already pre-populated.
	 * 
	 * @return
	 */
	@Override
	public @Nonnull Architecture[] getArchitectures() {
		return getProduct().getArchitectures();
	}

	/**
	 * Cloud-specific metadata that drivers may or may not use for matching
	 * products with machine images. This is considered driver-internal.
	 * 
	 * @return product metadata
	 */
	@Override
	public @Nonnull Map<String, String> getProviderMetadata() {
		return getProduct().getProviderMetadata();
	}

	@Override
	public String toString() {
		return getProduct().toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((configId == null) ? 0 : configId.hashCode());
		result = prime * result + ((configName == null) ? 0 : configName.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		VirtualMachineProductProxy other = (VirtualMachineProductProxy) obj;
		if (configId == null) {
			if (other.configId != null)
				return false;
		} else if (!configId.equals(other.configId))
			return false;
		if (configName == null) {
			if (other.configName != null)
				return false;
		} else if (!configName.equals(other.configName))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		return true;
	}

}
