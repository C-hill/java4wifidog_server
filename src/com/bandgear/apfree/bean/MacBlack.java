package com.bandgear.apfree.bean;

public class MacBlack {
	/**
	 * 对应rule_macblack表
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
