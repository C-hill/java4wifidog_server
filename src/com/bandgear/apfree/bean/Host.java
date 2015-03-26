package com.bandgear.apfree.bean;

import java.io.Serializable;

public class Host implements Serializable{
	/**
	 * 主机规则，对应rule_host表
	 * host主要可以实现针对某个ip或网段的限速
	 */
	private Integer id;
	private Integer ap_id;//对应路由的ap_id
	private String ip;//目标ip或网段
	private Integer up;//上行速率
	private Integer down;//下行速率
	private String netmask;//掩码，跟ip一起表示某个网段
	private Integer enable;//是否可用，可忽略
	private Integer session;//连接数
	public Host(Integer id, Integer up, Integer down, Integer enable, String ip,
			String netmask) {
		this.id=id;
		this.ip=ip;
		this.up=up;
		this.down=down;
		this.netmask=netmask;
		this.enable=enable;
	}
	public Host(){}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAp_id() {
		return ap_id;
	}
	public void setAp_id(Integer apId) {
		ap_id = apId;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Integer getUp() {
		return up;
	}
	public void setUp(Integer up) {
		this.up = up;
	}
	public Integer getDown() {
		return down;
	}
	public void setDown(Integer down) {
		this.down = down;
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
	public Integer getSession() {
		return session;
	}
	public void setSession(Integer session) {
		this.session = session;
	}
	
}
