package com.infinities.skyport.model.console;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;

@XmlAccessorType(XmlAccessType.FIELD)
public class ServerConfiguration implements Serializable {

	public enum Mode implements Serializable {
		local, remote
	}


	private static final long serialVersionUID = 1L;
	// must be provided in both mode
	@XmlAttribute
	private Mode mode;
	// user might not want ip be 127.0.0.1 in local mode so ip must be provided
	// in both mode
	@XmlAttribute
	private String ip;
	// user might not want ip be 8085 in local mode so port must be provided in
	// both mode
	@XmlAttribute
	private String port;
	// must be provided in local mode
	@XmlAttribute
	private String path;
	// @XmlTransient
	// private boolean requireSSL;
	@XmlAttribute(name = "SSLEnabled")
	private boolean enableSSL;
	// must be provided in remote mode
	@XmlAttribute
	private String username;
	// must be provided in remote mode
	@XmlAttribute
	private String password;
	@XmlAttribute
	private String protocol;
	// must be provided in local mode if use https protocol
	@XmlAttribute
	private String keystoreType;
	// must be provided in local mode if use https protocol
	@XmlAttribute
	private String keystoreFile;
	// must be provided in local mode if use https protocol
	@XmlAttribute
	private String keystorePass;
	@XmlAttribute
	private String keystoreKeyPass;
	@XmlTransient
	private String webDirectory;
	// must be provided in local mode
	@XmlAttribute
	private int minPort;
	// must be provided in local mode
	@XmlAttribute
	private int maxPort;

	@XmlAttribute
	private String sshPath;

	@XmlAttribute
	private String rdpPath;


	public ServerConfiguration() {

	}

	public ServerConfiguration(String protocol, String ip, String port, String path, String username, String password,
			String keystoreType, String keystorePath, String keystorePass, String keystoreKeyPass, boolean enableSSL,
			String webDirectory, int minPort, int maxPort, Mode mode, String sshPath, String rdpPath) {
		super();
		this.protocol = protocol;
		this.ip = ip;
		this.port = port;
		this.path = path;
		this.keystoreType = keystoreType;
		this.keystoreFile = keystorePath;
		this.keystorePass = keystorePass;
		this.keystoreKeyPass = keystoreKeyPass;
		// this.requireSSL = requireSSL;
		this.enableSSL = enableSSL;
		this.webDirectory = webDirectory;
		this.minPort = minPort;
		this.maxPort = maxPort;
		this.username = username;
		this.password = password;
		this.mode = mode;
		this.sshPath = sshPath;
		this.rdpPath = rdpPath;
	}

	public String getKeystoreType() {
		return keystoreType;
	}

	public void setKeystoreType(String keystoreType) {
		this.keystoreType = keystoreType;
	}

	public String getKeystoreFile() {
		return keystoreFile;
	}

	public void setKeystoreFile(String keystoreFile) {
		this.keystoreFile = keystoreFile;
	}

	public String getKeystorePass() {
		return keystorePass;
	}

	public void setKeystorePass(String keystorePass) {
		this.keystorePass = keystorePass;
	}

	public String getKeystoreKeyPass() {
		return keystoreKeyPass;
	}

	public void setKeystoreKeyPass(String keystoreKeyPass) {
		this.keystoreKeyPass = keystoreKeyPass;
	}

	public boolean isRequireSSL() {
		return enableSSL;
	}

	public void setRequireSSL(boolean enableSSL) {
		this.enableSSL = enableSSL;
	}

	public boolean isEnableSSL() {
		return enableSSL;
	}

	public void setEnableSSL(boolean enableSSL) {
		this.enableSSL = enableSSL;
		// this.requireSSL = enableSSL;
	}

	public String getWebDirectory() {
		return webDirectory;
	}

	public void setWebDirectory(String webDirectory) {
		this.webDirectory = webDirectory;
	}

	public int getMinPort() {
		return minPort;
	}

	public void setMinPort(int minPort) {
		this.minPort = minPort;
	}

	public int getMaxPort() {
		return maxPort;
	}

	public void setMaxPort(int maxPort) {
		this.maxPort = maxPort;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Mode getMode() {
		return mode;
	}

	public void setMode(Mode mode) {
		this.mode = mode;
	}

	public String getSshPath() {
		return sshPath;
	}

	public void setSshPath(String sshPath) {
		this.sshPath = sshPath;
	}

	public String getRdpPath() {
		return rdpPath;
	}

	public void setRdpPath(String rdpPath) {
		this.rdpPath = rdpPath;
	}

	@Override
	public String toString() {
		return "ServerConfiguration [mode=" + mode + ", ip=" + ip + ", port=" + port + ", path=" + path + ", requireSSL="
				+ this.isRequireSSL() + ", enableSSL=" + enableSSL + ", username=" + username + ", password=" + password
				+ ", protocol=" + protocol + ", keystoreType=" + keystoreType + ", keystoreFile=" + keystoreFile
				+ ", keystorePassword=" + keystorePass + ", keystoreKeyPassword=" + keystoreKeyPass + ", webDirectory="
				+ webDirectory + ", minPort=" + minPort + ", maxPort=" + maxPort + ", sshPath=" + sshPath + ", rdpPath="
				+ rdpPath + "]";
	}

}
