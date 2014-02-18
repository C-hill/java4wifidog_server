package com.bandgear.apfree.service.impl;

import java.sql.SQLException;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.bandgear.apfree.bean.IPWhite;
import com.bandgear.apfree.dao.Dao;
import com.bandgear.apfree.dao.impl.IPWhiteDao;
import com.bandgear.apfree.service.IpWhiteService;
import com.bandgear.apfree.utils.Utils4Service;

public class IpWhiteServiceImpl implements IpWhiteService {
	private Dao<IPWhite> d=null;
	Logger logger=Logger.getLogger(IpWhiteServiceImpl.class);
	public IpWhiteServiceImpl(){
		if(d==null){
			d=new IPWhiteDao();
		}
	}
	@Override
	public String addIpWhite(IPWhite ipwhite, String deviceToken) {
		JSONObject resultObj=new JSONObject();
		try {
			if(Utils4Service.checkDeviceToken(deviceToken)!=1){//判断device_token是否合法
				resultObj.put("code", "0");
				resultObj.put("message", "device_token is invalid!");
				return resultObj.toString();
			}
			ipwhite.setAp_id(Utils4Service.getApIdByDeviceToken(deviceToken));
			ipwhite.setEnable(1);
			d.add(ipwhite);
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
	public String deleteIpWhite(IPWhite ipwhite, String deviceToken) {
		JSONObject resultObj=new JSONObject();
		try {
			if(Utils4Service.checkDeviceToken(deviceToken)!=1){//判断device_token是否合法
				resultObj.put("code", "0");
				resultObj.put("message", "device_token is invalid!");
				return resultObj.toString();
			}
			d.delete(ipwhite);
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
	public String getIpWhites(String deviceToken) {
		JSONObject resultObj=new JSONObject();
		try {
			if(Utils4Service.checkDeviceToken(deviceToken)!=1){//判断device_token是否合法
				resultObj.put("code", "0");
				resultObj.put("message", "device_token is invalid!");
				return resultObj.toString();
			}
			List<IPWhite> ipwhites = ((IPWhiteDao)d).findByDeviceToken(deviceToken);
			resultObj.put("result", ipwhites);
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
			((IPWhiteDao)d).deleteByDeviceToken(deviceToken);
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
