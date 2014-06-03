package com.bandgear.apfree.bean;

import java.io.Serializable;

public class Ap implements Serializable{
	/**
	 * 对应ap表
	 */
	private Integer ap_id;//
	private String gw_id;
	private String dev_id;//路由器设备id
	private String dev_md5;//device_token，对dev_id加密所得
	private String name;
	private String remark;
	private Integer enable=1;
	public Integer getAp_id() {
		return ap_id;
	}
	public void setAp_id(Integer apId) {
		ap_id = apId;
	}
	public String getGw_id() {
		return gw_id;
	}
	public void setGw_id(String gwId) {
		gw_id = gwId;
	}
	public String getDev_id() {
		return dev_id;
	}
	public void setDev_id(String devId) {
		dev_id = devId;
	}
	public String getDev_md5() {
		return dev_md5;
	}
	public void setDev_md5(String devMd5) {
		dev_md5 = devMd5;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getEnable() {
		return enable;
	}
	public void setEnable(Integer enable) {
		this.enable = enable;
	}
}
