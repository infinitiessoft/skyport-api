package com.infinities.skyport.model.webserver;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;

import com.infinities.skyport.model.console.ServerConfiguration.Mode;

@XmlAccessorType(XmlAccessType.FIELD)
public class Connector implements Serializable {

	/**
	 * 
	 */
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

	@XmlAttribute(name = "default")
	private boolean defaultConnector;


	public Connector() {

	}

	public Connector(String protocol, String ip, String port, String path, String username, String password,
			String keystoreType, String keystorePath, String keystorePass, String keystoreKeyPass, boolean enableSSL,
			String webDirectory, int minPort, int maxPort, Mode mode, boolean defaultConnector) {
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
		this.defaultConnector = defaultConnector;
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

	public boolean isDefaultConnector() {
		return defaultConnector;
	}

	public void setDefaultConnector(boolean defaultConnector) {
		this.defaultConnector = defaultConnector;
	}

	@Override
	public String toString() {
		return "Connector [mode=" + mode + ", ip=" + ip + ", port=" + port + ", path=" + path + ", enableSSL=" + enableSSL
				+ ", username=" + username + ", password=" + password + ", protocol=" + protocol + ", keystoreType="
				+ keystoreType + ", keystoreFile=" + keystoreFile + ", keystorePass=" + keystorePass + ", keystoreKeyPass="
				+ keystoreKeyPass + ", webDirectory=" + webDirectory + ", minPort=" + minPort + ", maxPort=" + maxPort
				+ ", defaultConnector=" + defaultConnector + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (defaultConnector ? 1231 : 1237);
		result = prime * result + (enableSSL ? 1231 : 1237);
		result = prime * result + ((ip == null) ? 0 : ip.hashCode());
		result = prime * result + ((keystoreFile == null) ? 0 : keystoreFile.hashCode());
		result = prime * result + ((keystoreKeyPass == null) ? 0 : keystoreKeyPass.hashCode());
		result = prime * result + ((keystorePass == null) ? 0 : keystorePass.hashCode());
		result = prime * result + ((keystoreType == null) ? 0 : keystoreType.hashCode());
		result = prime * result + maxPort;
		result = prime * result + minPort;
		result = prime * result + ((mode == null) ? 0 : mode.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((path == null) ? 0 : path.hashCode());
		result = prime * result + ((port == null) ? 0 : port.hashCode());
		result = prime * result + ((protocol == null) ? 0 : protocol.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + ((webDirectory == null) ? 0 : webDirectory.hashCode());
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
		Connector other = (Connector) obj;
		if (defaultConnector != other.defaultConnector)
			return false;
		if (enableSSL != other.enableSSL)
			return false;
		if (ip == null) {
			if (other.ip != null)
				return false;
		} else if (!ip.equals(other.ip))
			return false;
		if (keystoreFile == null) {
			if (other.keystoreFile != null)
				return false;
		} else if (!keystoreFile.equals(other.keystoreFile))
			return false;
		if (keystoreKeyPass == null) {
			if (other.keystoreKeyPass != null)
				return false;
		} else if (!keystoreKeyPass.equals(other.keystoreKeyPass))
			return false;
		if (keystorePass == null) {
			if (other.keystorePass != null)
				return false;
		} else if (!keystorePass.equals(other.keystorePass))
			return false;
		if (keystoreType == null) {
			if (other.keystoreType != null)
				return false;
		} else if (!keystoreType.equals(other.keystoreType))
			return false;
		if (maxPort != other.maxPort)
			return false;
		if (minPort != other.minPort)
			return false;
		if (mode != other.mode)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		if (port == null) {
			if (other.port != null)
				return false;
		} else if (!port.equals(other.port))
			return false;
		if (protocol == null) {
			if (other.protocol != null)
				return false;
		} else if (!protocol.equals(other.protocol))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (webDirectory == null) {
			if (other.webDirectory != null)
				return false;
		} else if (!webDirectory.equals(other.webDirectory))
			return false;
		return true;
	}

}
