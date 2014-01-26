package com.bandgear.apfree.bean;

import java.io.Serializable;

public class IPWhite implements Serializable{
	/**
	 * "id":"1",
		"ap_id":"1",
		"ip":"192.168.1.9",
		"netmask":"255.255.255.255",
		"enable":"0"
	 */
	private int id;
	private String ip;
	private String netmask;
	private int enable;
	public IPWhite(int id, String ip, String netmask, int enable) {
		super();
		this.id = id;
		this.ip = ip;
		this.netmask = netmask;
		this.enable = enable;
	}
	public IPWhite(){};
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getNetmask() {
		return netmask;
	}
	public void setNetmask(String netmask) {
		this.netmask = netmask;
	}
	public int getEnable() {
		return enable;
	}
	public void setEnable(int enable) {
		this.enable = enable;
	}
	
}
