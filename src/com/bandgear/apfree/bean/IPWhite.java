package com.bandgear.apfree.bean;

import java.io.Serializable;

public class IPWhite implements Serializable{
	/**
	 * 对应rule_ipwhite表
	 */
	private Integer ap_id;
	private Integer id;
	private String ip;
	private String netmask;
	private Integer enable;
	public IPWhite(Integer id, String ip, String netmask, Integer enable) {
		super();
		this.id = id;
		this.ip = ip;
		this.netmask = netmask;
		this.enable = enable;
	}
	public IPWhite(){};
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public Integer getEnable() {
		return enable;
	}
	public void setEnable(Integer enable) {
		this.enable = enable;
	}
	public Integer getAp_id() {
		return ap_id;
	}
	public void setAp_id(Integer apId) {
		ap_id = apId;
	}
}
