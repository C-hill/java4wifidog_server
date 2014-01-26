package com.bandgear.apfree.bean;

public class Host {
	/**
	 * "id":"1",
		"ap_id":"1",
		"ip":"192.168.1.9",
		"netmask":"255.255.255.255",
		"enable":"0"
	 */
	private int id;
	private int ap_id;
	private String ip;
	private int up;
	private int down;
	private String netmask;
	private int enable;
	public Host(int id, int up, int down, int enable, String ip,
			String netmask) {
		this.id=id;
		this.ip=ip;
		this.up=up;
		this.down=down;
		this.netmask=netmask;
		this.enable=enable;
	}
	public Host() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAp_id() {
		return ap_id;
	}
	public void setAp_id(int ap_id) {
		this.ap_id = ap_id;
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
	public int getUp() {
		return up;
	}
	public void setUp(int up) {
		this.up = up;
	}
	public int getDown() {
		return down;
	}
	public void setDown(int down) {
		this.down = down;
	}
	
}
