package com.bandgear.apfree.service.impl;

import java.sql.SQLException;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.bandgear.apfree.bean.Host;
import com.bandgear.apfree.dao.Dao;
import com.bandgear.apfree.dao.impl.HostDao;
import com.bandgear.apfree.dao.impl.IPWhiteDao;
import com.bandgear.apfree.service.HostService;
import com.bandgear.apfree.utils.Utils4Service;

public class HostServiceImpl implements HostService {
	private Dao<Host> d=null;
	Logger logger=Logger.getLogger(HostServiceImpl.class);
	public HostServiceImpl(){
		if(d==null){
			d=new HostDao();
		}
	}
	/**
	 * 增加host，并返回json形式字符串
	 */
	@Override
	public String addHost(Host host, String deviceToken) {
		JSONObject resultObj=new JSONObject();
		try {
			if(Utils4Service.checkDeviceToken(deviceToken)!=1){//判断device_token是否合法
				resultObj.put("code", "0");
				resultObj.put("message", "device_token is invalid!");
				return resultObj.toString();
			}
			host.setAp_id(Utils4Service.getApIdByDeviceToken(deviceToken));
			host.setSession(10);//设置session的默认值为10
			host.setEnable(1);//默认有效
			d.add(host);
			resultObj.put("code", "1");
			resultObj.put("message", "success!");
			return resultObj.toString();
		} catch (SQLException e) {
			e.printStackTrace();
			resultObj.put("code", "0");
			resultObj.put("message", "error!");
			return resultObj.toString();
		}
	}

	@Override
	public String deleteHost(Host host, String deviceToken) {
		JSONObject resultObj=new JSONObject();
		try {
			if(Utils4Service.checkDeviceToken(deviceToken)!=1){//判断device_token是否合法
				resultObj.put("code", "0");
				resultObj.put("message", "device_token is invalid!");
				return resultObj.toString();
			}
			d.delete(host);
			resultObj.put("code", "1");
			resultObj.put("message", "success!");
			return resultObj.toString();
		} catch (SQLException e) {
			e.printStackTrace();
			resultObj.put("code", "0");
			resultObj.put("message", "error!");
			return resultObj.toString();
		}
	}
	
	/**
	 * 通过device_token获取host
	 */
	@Override
	public String getHosts(String deviceToken) {
		JSONObject resultObj=new JSONObject();
		try {
			if(Utils4Service.checkDeviceToken(deviceToken)!=1){//判断device_token是否合法
				resultObj.put("code", "0");
				resultObj.put("message", "device_token is invalid!");
				return resultObj.toString();
			}
			List<Host> hosts = ((HostDao)d).findByDeviceToken(deviceToken);
			resultObj.put("result", hosts);
			resultObj.put("code", "1");
			resultObj.put("message", "success!");
			return resultObj.toString();
		} catch (SQLException e) {
			e.printStackTrace();
			resultObj.put("code", "0");
			resultObj.put("message", "error!");
			return resultObj.toString();
		}
	}

	@Override
	public String modifyHost(Host host, String deviceToken) {
		JSONObject resultObj=new JSONObject();
		try {
			//1.判断device_token是否合法
			if(Utils4Service.checkDeviceToken(deviceToken)!=1){
				resultObj.put("code", "0");
				resultObj.put("message", "device_token is invalid!");
				return resultObj.toString();
			}
			//2.调用dao
			host.setEnable(1);
			host.setSession(10);
			d.update(host);
			resultObj.put("code", "1");
			resultObj.put("message", "success!");
			return resultObj.toString();
		} catch (SQLException e) {
			e.printStackTrace();
			resultObj.put("code", "0");
			resultObj.put("message", "error!");
			return resultObj.toString();
		}
	}
	@Override
	public String clearByDeviceToken(String deviceToken) {
		JSONObject resultObj=new JSONObject();
		try {
			if(Utils4Service.checkDeviceToken(deviceToken)!=1){//判断device_token是否合法
				resultObj.put("code", "0");
				resultObj.put("message", "device_token is invalid!");
				return resultObj.toString();
			}
			((HostDao)d).deleteByDeviceToken(deviceToken);
			resultObj.put("code", "1");
			resultObj.put("message", "success!");
			return resultObj.toString();
		} catch (SQLException e) {
			e.printStackTrace();
			resultObj.put("code", "0");
			resultObj.put("message", "error!");
			return resultObj.toString();
		}
	}

}
