package com.bandgear.apfree.service.impl;

import java.sql.SQLException;
import java.util.List;

import net.sf.json.JSONObject;

import com.bandgear.apfree.bean.Device;
import com.bandgear.apfree.dao.Dao;
import com.bandgear.apfree.dao.impl.DeviceDao;
import com.bandgear.apfree.service.DeviceService;
import com.bandgear.apfree.utils.Utils4Service;

public class DeviceServiceImpl implements DeviceService {
	Dao<Device> d=new DeviceDao();
	@Override
	public String getDevices(String deviceToken) {
		JSONObject resultObj=new JSONObject();
		try {
			if(Utils4Service.checkDeviceToken(deviceToken)!=1){//判断device_token是否合法
				resultObj.put("code", "0");
				resultObj.put("message", "device_token is invalid!");
				return resultObj.toString();
			}
			
			List<Device> devices = ((DeviceDao)d).findByDeviceToken(deviceToken);
			resultObj.put("result", devices);
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
