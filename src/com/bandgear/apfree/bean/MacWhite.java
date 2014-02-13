package com.bandgear.apfree.bean;

import java.io.Serializable;

public class MacWhite implements Serializable{
	/**
	 * mac白名单，对应rule_macwhite表
	 */
	private Integer id;
	private Integer ap_id;
	private String mac;
	private Integer enable;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAp_id() {
		return ap_id;
	}
	public void setAp_id(Integer ap_id) {
		this.ap_id = ap_id;
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
