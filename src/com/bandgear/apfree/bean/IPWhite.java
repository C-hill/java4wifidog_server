package com.bandgear.apfree.bean;

import java.io.Serializable;

public class IPWhite implements Serializable{
	/**
	 * ip白名单，对应rule_ipwhite表
	 * 加入ip白名单的设备会被限速
	 */
	private Integer ap_id;//对应路由器ap_id
	private Integer id;//唯一标识
	private String ip;//目标ip
	private String netmask;//子网掩码，跟ip结合使用代表某一网段
	private Integer enable;//是否可用，0不可用，1可用
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
