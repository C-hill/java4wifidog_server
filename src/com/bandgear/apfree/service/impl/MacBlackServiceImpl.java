package com.bandgear.apfree.service.impl;

import java.sql.SQLException;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.bandgear.apfree.bean.MacBlack;
import com.bandgear.apfree.dao.Dao;
import com.bandgear.apfree.dao.impl.IPWhiteDao;
import com.bandgear.apfree.dao.impl.MacBlackDao;
import com.bandgear.apfree.service.MacBlackService;
import com.bandgear.apfree.utils.Utils4Service;

public class MacBlackServiceImpl implements MacBlackService {
	private Dao<MacBlack> d=null;
	Logger logger=Logger.getLogger(MacBlackServiceImpl.class);
	public MacBlackServiceImpl(){
		if(d==null){
			d=new MacBlackDao();
		}
	}
	@Override
	public String addMacBlack(MacBlack macBlack, String deviceToken) {
		JSONObject resultObj=new JSONObject();
		try {
			if(Utils4Service.checkDeviceToken(deviceToken)!=1){//判断device_token是否合法
				resultObj.put("code", "0");
				resultObj.put("message", "device_token is invalid!");
				return resultObj.toString();
			}
			macBlack.setAp_id(Utils4Service.getApIdByDeviceToken(deviceToken));
			macBlack.setEnable(1);
			d.add(macBlack);
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
	public String deleteMacBlack(MacBlack macBlack, String deviceToken) {
		JSONObject resultObj=new JSONObject();
		try {
			if(Utils4Service.checkDeviceToken(deviceToken)!=1){//判断device_token是否合法
				resultObj.put("code", "0");
				resultObj.put("message", "device_token is invalid!");
				return resultObj.toString();
			}
			d.delete(macBlack);
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
	public String getMacBlacks(String deviceToken) {
		JSONObject resultObj=new JSONObject();
		try {
			if(Utils4Service.checkDeviceToken(deviceToken)!=1){//判断device_token是否合法
				resultObj.put("code", "0");
				resultObj.put("message", "device_token is invalid!");
				return resultObj.toString();
			}
			List<MacBlack> macBlacks = ((MacBlackDao)d).findByDeviceToken(deviceToken);
			resultObj.put("result", macBlacks);
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
			((MacBlackDao)d).deleteByDeviceToken(deviceToken);
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
