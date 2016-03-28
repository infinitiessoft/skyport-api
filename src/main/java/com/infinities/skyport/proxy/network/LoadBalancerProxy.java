package com.infinities.skyport.proxy.network;

import java.io.Serializable;
import java.util.Map;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.xml.bind.annotation.XmlTransient;

import org.dasein.cloud.VisibleScope;
import org.dasein.cloud.network.IPVersion;
import org.dasein.cloud.network.LbListener;
import org.dasein.cloud.network.LbType;
import org.dasein.cloud.network.LoadBalancer;
import org.dasein.cloud.network.LoadBalancerAddressType;
import org.dasein.cloud.network.LoadBalancerState;

import com.infinities.skyport.distributed.DistributedAtomicLong;

public class LoadBalancerProxy extends LoadBalancer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XmlTransient
	private volatile LoadBalancer loadbalancer;
	private String configName;
	private String configId;
	private final DistributedAtomicLong isLocked;


	@SuppressWarnings("deprecation")
	public LoadBalancerProxy(LoadBalancer loadbalancer, String configName, String configId, DistributedAtomicLong isLocked) {
		super();
		this.loadbalancer = loadbalancer;
		this.configName = configName;
		this.configId = configId;
		this.isLocked = isLocked;
	}

	public LoadBalancer getLoadbalancer() {
		return loadbalancer;
	}

	public void setLoadbalancer(LoadBalancer loadbalancer) {
		this.loadbalancer = loadbalancer;
	}
	
	 @Override
    public @Nonnull String getAddress() {
        return getLoadbalancer().getAddress();
    }

    @Override
    public LoadBalancerAddressType getAddressType() {
        return getLoadbalancer().getAddressType();
    }

    @Override
    public @Nonnegative long getCreationTimestamp() {
        return getLoadbalancer().getCreationTimestamp();
    }

    @Override
    public @Nonnull LoadBalancerState getCurrentState() {
        return getLoadbalancer().getCurrentState();
    }

    @Override
    public @Nonnull String getDescription() {
        return getLoadbalancer().getDescription();
    }

    @Override
    public LbType getType() {
      return getLoadbalancer().getType();
    }

    @Override
    public @Nonnull LbListener[] getListeners() {
        return getLoadbalancer().getListeners();
    }

    @Override
    public @Nonnull String getName() {
        return getLoadbalancer().getName();
    }

    @Override
    public @Nonnull String[] getProviderDataCenterIds() {
        return getLoadbalancer().getProviderDataCenterIds();
    }

    @Override
    public @Nonnull String getProviderLoadBalancerId() {
        return getLoadbalancer().getProviderLoadBalancerId();
    }

    @Override
    public @Nonnull String getProviderOwnerId() {
        return getLoadbalancer().getProviderOwnerId();
    }

    @Override
    public @Nonnull String getProviderRegionId() {
        return getLoadbalancer().getProviderRegionId();
    }

    @Override
    public @Nonnull int[] getPublicPorts() {
        return getLoadbalancer().getPublicPorts();
    }

    @Override
    public @Nonnull IPVersion[] getSupportedTraffic() {
       return getLoadbalancer().getSupportedTraffic();
    }

    @Override
    public @Nullable String getProviderLBHealthCheckId(){
        return getLoadbalancer().getProviderLBHealthCheckId();
    }

    @Override
    public @Nullable VisibleScope getVisibleScope(){
        return getLoadbalancer().getVisibleScope();
    }

    @Override
    public @Nullable String getProviderVlanId() {
        return getLoadbalancer().getProviderVlanId();
    }

    @Override
    public @Nonnull LoadBalancer operatingIn(@Nonnull String ... dataCenterIds) {
        return getLoadbalancer().operatingIn(dataCenterIds);
    }

    @Override
    public Iterable<String> getProviderSubnetIds() {
      return getLoadbalancer().getProviderSubnetIds();
    }

    @Override
    public LoadBalancer withProviderSubnetIds( String... providerSubnetIds ) {
      return getLoadbalancer().withProviderSubnetIds(providerSubnetIds);
    }

    @Override
    public @Nullable String getTag(@Nonnull String key) {
        return getLoadbalancer().getTag(key);
    }

    @Override
    public @Nonnull Map<String,String> getTags() {
    	return getLoadbalancer().getTags();
    }

    @Override
    public void setTag(@Nonnull String key, @Nonnull String value) {
        getLoadbalancer().setTag(key, value);
    }

    @Override
    public void setTags(@Nonnull Map<String,String> tags) {
       getLoadbalancer().setTags(tags);
    }

    @Override
    public String[] getProviderFirewallIds() {
        return getLoadbalancer().getProviderFirewallIds();
    }

    @Override
    public void setProviderFirewallIds(String[] providerFirewallIds) {
        getLoadbalancer().setProviderFirewallIds(providerFirewallIds);
    }

    @Override
    public LoadBalancer supportingTraffic(@Nonnull IPVersion ... traffic) {
        return getLoadbalancer().supportingTraffic(traffic);
    }

    @Override
    public @Nonnull LoadBalancer withListeners(@Nonnull LbListener ... listeners) {
       return getLoadbalancer().withListeners(listeners);
    }

    @Override
    public @Nonnull LoadBalancer forVlan(@Nullable String providerVlanId) {
        return getLoadbalancer().forVlan(providerVlanId);
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
		result = prime * result + ((loadbalancer == null) ? 0 : loadbalancer.hashCode());
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
		LoadBalancerProxy other = (LoadBalancerProxy) obj;
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
		if (loadbalancer == null) {
			if (other.loadbalancer != null)
				return false;
		} else if (!loadbalancer.equals(other.loadbalancer))
			return false;
		return true;
	}

}
