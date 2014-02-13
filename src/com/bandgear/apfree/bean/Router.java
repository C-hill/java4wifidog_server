package com.bandgear.apfree.bean;

import java.io.Serializable;
import java.util.Date;

public class Router implements Serializable{
	/**
	 * 路由器，对应ap_status表
	 */
	private Integer ap_id;//
	private Integer client_num;//连接设备数量
	private Integer sys_uptime;//路由器启动时间
	private Integer sys_memfree;//系统剩余内存 kb
	private Float sys_load;
	private Integer wifidog_uptime;//wifidog运行时间
	private Date update_time;//最后更新时间
	private Integer cpu_usage;//利用率 %
	private Integer nf_conntrack_num;//网络连接数
	private Integer online;//是否在线
	private String device_token;//
	
	public Float getSys_load() {
		return sys_load;
	}
	public void setSys_load(Float sysLoad) {
		sys_load = sysLoad;
	}
	public Integer getAp_id() {
		return ap_id;
	}
	public void setAp_id(Integer ap_id) {
		this.ap_id = ap_id;
	}
	public Integer getClient_num() {
		return client_num;
	}
	public void setClient_num(Integer client_num) {
		this.client_num = client_num;
	}
	public Integer getOnline() {
		return online;
	}
	public void setOnline(Integer online) {
		this.online = online;
	}
	public String getDevice_token() {
		return device_token;
	}
	public void setDevice_token(String device_token) {
		this.device_token = device_token;
	}
	public Integer getSys_memfree() {
		return sys_memfree;
	}
	public void setSys_memfree(Integer sys_memfree) {
		this.sys_memfree = sys_memfree;
	}
	public Integer getCpu_usage() {
		return cpu_usage;
	}
	public void setCpu_usage(Integer cpu_usage) {
		this.cpu_usage = cpu_usage;
	}
	public Integer getNf_conntrack_num() {
		return nf_conntrack_num;
	}
	public void setNf_conntrack_num(Integer nf_conntrack_num) {
		this.nf_conntrack_num = nf_conntrack_num;
	}
	public Integer getSys_uptime() {
		return sys_uptime;
	}
	public void setSys_uptime(Integer sysUptime) {
		sys_uptime = sysUptime;
	}
	public Integer getWifidog_uptime() {
		return wifidog_uptime;
	}
	public void setWifidog_uptime(Integer wifidogUptime) {
		wifidog_uptime = wifidogUptime;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date updateTime) {
		update_time = updateTime;
	}
	
}
