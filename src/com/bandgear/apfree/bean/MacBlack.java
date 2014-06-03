package com.bandgear.apfree.bean;

import java.io.Serializable;

public class MacBlack implements Serializable{
	/**
	 * mac黑名单，对应rule_macblack表
	 * macblack主要实现禁止某个设备访问网络（踢下线通过该名单实现），
	 */
	private Integer id;
	private String mac;
	private Integer enable;
	private Integer ap_id;
	public Integer getAp_id() {
		return ap_id;
	}
	public void setAp_id(Integer apId) {
		ap_id = apId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public Integer getEnable() {
		return enable;
	}
	public void setEnable(Integer enable) {
		this.enable = enable;
	}
	
}
