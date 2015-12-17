package com.infinities.skyport.proxy;

import java.util.Collections;
import java.util.Date;
import java.util.Set;

import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.infinities.skyport.compute.IDisk;
import com.infinities.skyport.compute.INetworkAdapter;
import com.infinities.skyport.compute.IVm;
import com.infinities.skyport.compute.entity.Statistics;
import com.infinities.skyport.compute.entity.adapter.DoubleAdapter;
import com.infinities.skyport.compute.entity.adapter.ISO8601DateAdapter;
import com.infinities.skyport.distributed.DistributedAtomicLong;

public class VmProxy implements IVm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@XmlTransient
	private volatile IVm vm;

	private final DistributedAtomicLong isLocked;

	private String distributedKey;


	// private final AtomicBoolean isLocked = new AtomicBoolean(false);

	public VmProxy(IVm vm, DistributedAtomicLong isLocked, String distributedKey) {
		this.vm = vm;
		this.isLocked = isLocked;
		this.distributedKey = distributedKey;
	}

	@XmlTransient
	public void setVm(IVm vm) {
		this.vm = vm;
	}

	@XmlTransient
	public IVm getVm() {
		return vm;
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
	public String getStatus() {
		return isLocked.compareAndSet(1, 1) ? IVm.LOCK : vm.getStatus();
	}

	@Override
	public Integer getCpunum() {
		return vm.getCpunum();
	}

	@Override
	public Long getMemorysize() {
		return vm.getMemorysize();
	}

	@Override
	public Set<? extends IDisk> getDisks() {
		return Collections.unmodifiableSet(vm.getDisks());
	}

	@Override
	public Set<? extends INetworkAdapter> getNics() {
		return Collections.unmodifiableSet(vm.getNics());
	}

	@Override
	@XmlJavaTypeAdapter(value = ISO8601DateAdapter.class)
	public Date getCreationdate() {
		return vm.getCreationdate();
	}

	@Override
	public String getOs() {
		return vm.getOs();
	}

	@Override
	public String getName() {
		return vm.getName();
	}

	@Override
	public String getResourceid() {
		return vm.getResourceid();
	}

	@Override
	public String getTemplateid() {
		return vm.getTemplateid();
	}

	@Override
	public String getVmtype() {
		return vm.getVmtype();
	}

	@Override
	public String getHypervisortype() {
		return vm.getHypervisortype();
	}

	// @XmlElement(name = "pool")
	@Override
	public String getPool() {
		return vm.getPool();
	}

	@Override
	public String getDesc() {
		return vm.getDesc();
	}

	@Override
	public Long getId() {
		return vm.getId();
	}

	@Override
	public String getVmid() {
		return vm.getVmid();
	}

	@XmlElement(name = "hostid")
	@Override
	public String getRunningonhostid() {
		return vm.getRunningonhostid();
	}

	@Override
	public String getIp() {
		return vm.getIp();
	}

	@Override
	public String getCdisopath() {
		return vm.getCdisopath();
	}

	@Override
	public String getInfo() {
		return vm.getInfo();
	}

	@XmlTransient
	@Override
	public Statistics getStatistics() {
		return vm.getStatistics();
	}

	@XmlJavaTypeAdapter(value = DoubleAdapter.class)
	public Double getCpuusage() {
		return vm.getStatistics().getCpusys() + vm.getStatistics().getCpuuser();
	}

	@XmlJavaTypeAdapter(value = DoubleAdapter.class)
	public Double getMemusage() {
		return vm.getStatistics().getMemusage();
	}

	public int getNumofsockets() {
		return vm.getCpunum();
	}

	@XmlElement(name = "host")
	@Override
	public String getRunningonhost() {
		return vm.getRunningonhost();
	}

	public String getDistributedKey() {
		return distributedKey;
	}

	public void setDistributedKey(String distributedKey) {
		this.distributedKey = distributedKey;
	}

	@Override
	public String getPoolid() {
		return vm.getPoolid();
	}

	// public Set<? extends INetworkAdapter> getNic() {
	// return Collections.unmodifiableSet(vm.getNics());
	// }

	// @Override
	// public void setRunningonhostid(String runningonhostid) {
	// vm.setRunningonhostid(runningonhostid);
	// }
}
