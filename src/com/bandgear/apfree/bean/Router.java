package com.bandgear.apfree.bean;

import java.io.Serializable;

public class Router implements Serializable{
	private int ap_id;//
	private int client_num;//连接设备数量
	private String sys_uptime;//路由器启动时间
	private int sys_memfree;//系统剩余内存 kb
	private String wifidog_uptime;//wifidog运行时间
	private String update_time;//最后更新时间
	private int cpu_usage;//利用率 %
	private int nf_conntrack_num;//网络连接数
	private int online;//是否在线
	private String device_token;//
	
	public int getAp_id() {
		return ap_id;
	}
	public void setAp_id(int ap_id) {
		this.ap_id = ap_id;
	}
	public int getClient_num() {
		return client_num;
	}
	public void setClient_num(int client_num) {
		this.client_num = client_num;
	}
	public int getOnline() {
		return online;
	}
	public void setOnline(int online) {
		this.online = online;
	}
	public String getDevice_token() {
		return device_token;
	}
	public void setDevice_token(String device_token) {
		this.device_token = device_token;
	}
	public String getSys_uptime() {
		return sys_uptime;
	}
	public void setSys_uptime(String sys_uptime) {
		this.sys_uptime = sys_uptime;
	}
	public int getSys_memfree() {
		return sys_memfree;
	}
	public void setSys_memfree(int sys_memfree) {
		this.sys_memfree = sys_memfree;
	}
	public String getWifidog_uptime() {
		return wifidog_uptime;
	}
	public void setWifidog_uptime(String wifidog_uptime) {
		this.wifidog_uptime = wifidog_uptime;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}
	public int getCpu_usage() {
		return cpu_usage;
	}
	public void setCpu_usage(int cpu_usage) {
		this.cpu_usage = cpu_usage;
	}
	public int getNf_conntrack_num() {
		return nf_conntrack_num;
	}
	public void setNf_conntrack_num(int nf_conntrack_num) {
		this.nf_conntrack_num = nf_conntrack_num;
	}
	
}
