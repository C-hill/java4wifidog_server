package com.bandgear.apfree.bean;


import java.io.Serializable;
import java.util.Date;

public class Device implements Serializable{
	/**
	 * 连接设备，对应client表
	 */
	private Integer id;//
	private Integer ap_id;
	private Integer kind=1;//客户端类型： 1，pc 2，移动设备
	private String ip="0.0.0.0";//连接设备的ip地址
	private String mac;// mac地址
	private String token; 
	private Integer outgoing=0;//上传流量 单位 b
	private Integer incoming=0;//下载流量 单位 b
	private Integer uprate=0;//上传速度
	private Integer downrate=0;//下载速度
	private Integer status=0;//状态： 1.登录请求  3.计数状态（在线）
	private Integer login_count=0;
	private Date update_time=new Date();//最后更新时间
	private Date login_time=new Date();
	
	//---------------------
	private String netmask;//子网掩码(没使用)
	private Integer in_ipwhite;//是否白名单
	public Integer getKind() {
		return kind;
	}
	
	
	public void setKind(Integer kind) {
		this.kind = kind;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Integer getUprate() {
		return uprate;
	}
	public void setUprate(Integer uprate) {
		this.uprate = uprate;
	}
	public Integer getDownrate() {
		return downrate;
	}
	public void setDownrate(Integer downrate) {
		this.downrate = downrate;
	}
	public String getNetmask() {
		return netmask;
	}
	public void setNetmask(String netmask) {
		this.netmask = netmask;
	}
	public Integer getIn_ipwhite() {
		return in_ipwhite;
	}
	public void setIn_ipwhite(Integer in_ipwhite) {
		this.in_ipwhite = in_ipwhite;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Integer getOutgoing() {
		return outgoing;
	}
	public void setOutgoing(Integer outgoing) {
		this.outgoing = outgoing;
	}
	public Integer getIncoming() {
		return incoming;
	}
	public void setIncoming(Integer incoming) {
		this.incoming = incoming;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public Integer getAp_id() {
		return ap_id;
	}


	public void setAp_id(Integer apId) {
		ap_id = apId;
	}


	public Date getUpdate_time() {
		return update_time;
	}


	public void setUpdate_time(Date updateTime) {
		update_time = updateTime;
	}


	public Integer getLogin_count() {
		return login_count;
	}


	public void setLogin_count(Integer loginCount) {
		login_count = loginCount;
	}


	public Date getLogin_time() {
		return login_time;
	}


	public void setLogin_time(Date loginTime) {
		login_time = loginTime;
	}


	public String toStringTest() {
		return "设备id："+this.id+"\ntoken："+this.token+"\nmac："+this.mac+"\n下载流量："+this.incoming+"\n上传流量："+this.outgoing+"\n最后更新时间："+this.update_time;
	}
}
