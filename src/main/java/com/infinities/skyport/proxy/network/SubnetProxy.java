package com.infinities.skyport.proxy.network;

import java.io.Serializable;
import java.util.Map;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.xml.bind.annotation.XmlTransient;

import org.dasein.cloud.network.AllocationPool;
import org.dasein.cloud.network.IPVersion;
import org.dasein.cloud.network.RawAddress;
import org.dasein.cloud.network.Subnet;
import org.dasein.cloud.network.SubnetState;

import com.infinities.skyport.distributed.DistributedAtomicLong;

public class SubnetProxy extends Subnet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XmlTransient
	private volatile Subnet subnet;
	private String configName;
	private String configId;
	private final DistributedAtomicLong isLocked;

	public SubnetProxy(Subnet subnet, String configName, String configId, DistributedAtomicLong isLocked) {
		super();
		this.subnet = subnet;
		this.configName = configName;
		this.configId = configId;
		this.isLocked = isLocked;
	}

	public Subnet getSubnet() {
		return subnet;
	}

	public void setSubnet(Subnet subnet) {
		this.subnet = subnet;
	}

	@Override
	public @Nonnull AllocationPool[] getAllocationPools() {
		return getSubnet().getAllocationPools();
	}

	@Override
	public @Nonnegative int getAvailableIpAddresses() {
		return getSubnet().getAvailableIpAddresses();
	}

	@Override
	public String getCidr() {
		return getSubnet().getCidr();
	}

	@Override
	public SubnetState getCurrentState() {
		return getSubnet().getCurrentState();
	}

	@Override
	public @Nonnull String getDescription() {
		return getSubnet().getDescription();
	}

	@Override
	public @Nullable RawAddress getGateway() {
		return getSubnet().getGateway();
	}

	@Override
	public @Nonnull String getName() {
		return getSubnet().getName();
	}

	@Override
	public @Nullable String getProviderDataCenterId() {
		return getSubnet().getProviderDataCenterId();
	}

	@Override
	public @Nonnull String getProviderOwnerId() {
		return getSubnet().getProviderOwnerId();
	}

	@Override
	public @Nonnull String getProviderRegionId() {
		return getSubnet().getProviderRegionId();
	}

	@Override
	public @Nonnull String getProviderSubnetId() {
		return getSubnet().getProviderSubnetId();
	}

	@Override
	public @Nonnull String getProviderVlanId() {
		return getSubnet().getProviderVlanId();
	}

	@Override
	public @Nonnull IPVersion[] getSupportedTraffic() {
		return getSubnet().getSupportedTraffic();
	}

	@Override
	public @Nonnull Subnet havingAllocationPools(@Nonnull AllocationPool... pools) {
		return getSubnet().havingAllocationPools(pools);
	}

	@Override
	public @Nonnull Map<String, String> getTags() {
		return getSubnet().getTags();
	}

	@Override
	public void setTag(@Nonnull String key, @Nonnull String value) {
		getSubnet().setTag(key, value);
	}

	@Override
	public void setTags(@Nonnull Map<String, String> tags) {
		getSubnet().setTags(tags);
	}

	@Override
	public Subnet supportingTraffic(@Nonnull IPVersion... traffic) {
		return getSubnet().supportingTraffic(traffic);
	}

	@Override
	public @Nonnull Subnet usingGateway(@Nonnull RawAddress gatewayIp) {
		return getSubnet().usingGateway(gatewayIp);
	}

	@Override
	public @Nonnull Subnet withAvailableIpAddresses(int count) {
		return getSubnet().withAvailableIpAddresses(count);
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

	public DistributedAtomicLong getIsLocked() {
		return isLocked;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((configId == null) ? 0 : configId.hashCode());
		result = prime * result + ((configName == null) ? 0 : configName.hashCode());
		result = prime * result + ((subnet == null) ? 0 : subnet.hashCode());
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
		SubnetProxy other = (SubnetProxy) obj;
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
		if (subnet == null) {
			if (other.subnet != null)
				return false;
		} else if (!subnet.equals(other.subnet))
			return false;
		return true;
	}
}
