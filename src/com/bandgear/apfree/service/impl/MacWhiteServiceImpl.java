package com.bandgear.apfree.service.impl;

import java.sql.SQLException;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.bandgear.apfree.bean.MacWhite;
import com.bandgear.apfree.dao.Dao;
import com.bandgear.apfree.dao.impl.IPWhiteDao;
import com.bandgear.apfree.dao.impl.MacWhiteDao;
import com.bandgear.apfree.service.MacWhiteService;
import com.bandgear.apfree.utils.Utils4Service;

public class MacWhiteServiceImpl implements MacWhiteService {
	private Dao<MacWhite> d=null;
	Logger logger=Logger.getLogger(MacWhiteServiceImpl.class);
	public MacWhiteServiceImpl(){
		if(d==null){
			d=new MacWhiteDao();
		}
	}
	@Override
	public String addMacWhite(MacWhite macWhite, String deviceToken) {
		JSONObject resultObj=new JSONObject();
		try {
			if(Utils4Service.checkDeviceToken(deviceToken)!=1){//判断device_token是否合法
				resultObj.put("code", "0");
				resultObj.put("message", "device_token is invalid!");
				return resultObj.toString();
			}
			macWhite.setEnable(1);
			macWhite.setAp_id(Utils4Service.getApIdByDeviceToken(deviceToken));
			d.add(macWhite);
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
	 * 删除macwhite
	 */
	@Override
	public String deleteMacWhite(MacWhite macWhite, String deviceToken) {
		JSONObject resultObj=new JSONObject();
		try {
			if(Utils4Service.checkDeviceToken(deviceToken)!=1){//判断device_token是否合法
				resultObj.put("code", "0");
				resultObj.put("message", "device_token is invalid!");
				return resultObj.toString();
			}
			d.delete(macWhite);
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
	public String getMacWhites(String deviceToken) {
		JSONObject resultObj=new JSONObject();
		try {
			if(Utils4Service.checkDeviceToken(deviceToken)!=1){//判断device_token是否合法
				resultObj.put("code", "0");
				resultObj.put("message", "device_token is invalid!");
				return resultObj.toString();
			}
			List<MacWhite> macWhites = ((MacWhiteDao)d).findByDeviceToken(deviceToken);
			resultObj.put("result", macWhites);
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
			((MacWhiteDao)d).deleteByDeviceToken(deviceToken);
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
