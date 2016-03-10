package com.infinities.skyport.proxy.network;

import java.io.Serializable;
import java.util.Map;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlTransient;

import org.dasein.cloud.VisibleScope;
import org.dasein.cloud.network.IPVersion;
import org.dasein.cloud.network.VLAN;
import org.dasein.cloud.network.VLANState;

import com.infinities.skyport.distributed.DistributedAtomicLong;

public class VLANProxy extends VLAN implements Serializable{

	private static final long serialVersionUID = 1L;
	@XmlTransient
	private volatile VLAN vlan;
	private String configName;
	private String configId;
	private final DistributedAtomicLong isLocked;


	public VLANProxy(VLAN vlan, String configName, String configId, DistributedAtomicLong isLocked) {
		super();
		this.vlan = vlan;
		this.configName = configName;
		this.configId = configId;
		this.isLocked = isLocked;
	}

	public VLAN getVlan() {
		return vlan;
	}

	public void setVlan(VLAN vlan) {
		this.vlan = vlan;
	}
	
	@Override
	public String getCidr() {
        return getVlan().getCidr();
    }

	@Override
    public void setCidr(String cidr) {
    	getVlan().setCidr(cidr);
    }

	@Override
    public void setCidr(@Nonnull String netmask, @Nonnull String anAddress) {
		getVlan().setCidr(netmask, anAddress);
    }

	@Override
    public String getDescription() {
        return getVlan().getDescription();
    }

	@Override
    public void setDescription(String description) {
		getVlan().setDescription(description);
    }

	@Override
    public String getName() {
        return getVlan().getName();
    }

	@Override
    public void setName(String name) {
    	getVlan().setName(name);
    }

	@Override
    public String getProviderDataCenterId() {
        return getVlan().getProviderDataCenterId();
    }

	@Override
    public void setProviderDataCenterId(String providerDataCenterId) {
        getVlan().setProviderDataCenterId(providerDataCenterId);
    }

	@Override
    public String getProviderOwnerId() {
        return getVlan().getProviderOwnerId();
    }

	@Override
    public void setProviderOwnerId(String providerOwnerId) {
        getVlan().setProviderOwnerId(providerOwnerId);
    }
    
	@Override
    public String getProviderRegionId() {
        return getVlan().getProviderRegionId();
    }

	@Override
    public void setProviderRegionId(String providerRegionId) {
        getVlan().setProviderRegionId(providerRegionId);
    }

	@Override
    public String getProviderVlanId() {
        return getVlan().getProviderVlanId();
    }

	@Override
    public void setProviderVlanId(String providerVlanId) {
        getVlan().setProviderVlanId(providerVlanId);
    }
    
	@Override
	public void setDnsServers(String[] dnsServers) {
        getVlan().setDnsServers(dnsServers);
    }

	@Override
    public String[] getDnsServers() {
        return getVlan().getDnsServers();
    }

	@Override
    public void setTags(Map<String,String> tags) {
        getVlan().setTags(tags);
    }

	@Override
    public @Nonnull Map<String,String> getTags() {
        return getVlan().getTags();
    }

	@Override
    public void setVisibleScope(VisibleScope visibleScope){
        getVlan().setVisibleScope(visibleScope);
    }

	@Override
    public VisibleScope getVisibleScope(){
        return getVlan().getVisibleScope();
    }

	@Override
    public void setDomainName(String domainName) {
        getVlan().setDomainName(domainName);
    }

	@Override
    public String getDomainName() {
        return getVlan().getDomainName();
    }

	@Override
    public void setNtpServers(String[] ntpServers) {
        getVlan().setNtpServers(ntpServers);
	}

	@Override
    public String[] getNtpServers() {
        return getVlan().getNtpServers();
    }

	@Override
    public void setCurrentState(VLANState currentState) {
        getVlan().setCurrentState(currentState);
    }

	@Override
    public VLANState getCurrentState() {
        return getVlan().getCurrentState();
    }

	@Override
    public IPVersion[] getSupportedTraffic() {
        return getVlan().getSupportedTraffic();
    }

	@Override
    public void setSupportedTraffic(IPVersion ... supportedTraffic) {
        getVlan().setSupportedTraffic(supportedTraffic);
    }

	@Override
    public @Nullable String getNetworkType() {
        return getVlan().getNetworkType();
    }

	@Override
    public void setNetworkType(@Nonnull String t) {
        getVlan().setNetworkType(t);
    }

    @Override
    public void setTag(@Nonnull String key, @Nonnull String value) {
    	getVlan().setTag(key, value);
    }

    @Override
    public @Nullable String getTag(@Nonnull String key) {
        return getVlan().getTag(key);
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

	@XmlTransient
	@Transient
	public boolean lock() {
		return isLocked.compareAndSet(0, 1);
	}

	@XmlTransient
	@Transient
	public boolean unlock() {
		return isLocked.compareAndSet(1, 0);
	}

	@XmlTransient
	@Transient
	public boolean isLocked() {
		return isLocked.compareAndSet(1, 1);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((configId == null) ? 0 : configId.hashCode());
		result = prime * result + ((configName == null) ? 0 : configName.hashCode());
		result = prime * result + ((vlan == null) ? 0 : vlan.hashCode());
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
		VLANProxy other = (VLANProxy) obj;
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
		if (vlan == null) {
			if (other.vlan != null)
				return false;
		} else if (!vlan.equals(other.vlan))
			return false;
		return true;
	}

}
