package com.bandgear.apfree.service.impl;

import java.sql.SQLException;
import java.util.List;

import net.sf.json.JSONObject;

import com.bandgear.apfree.bean.Router;
import com.bandgear.apfree.dao.impl.RouterDao;
import com.bandgear.apfree.service.RouterService;
import com.bandgear.apfree.utils.Utils4Service;

public class RouterServiceImpl implements RouterService{
	RouterDao rd=new RouterDao();
	@Override
	public String getStatus(String deviceToken) {
		JSONObject resultObj=new JSONObject();
		try {
			int checkDeviceToken = Utils4Service.checkDeviceToken(deviceToken);
			if(checkDeviceToken!=1){//判断device_token是否合法
				resultObj.put("code", "0");
				resultObj.put("message", "device_token is invalid!");
				return resultObj.toString();
			}
			List<Router> findByDeviceToken = rd.findByDeviceToken(deviceToken);
			resultObj.put("result", findByDeviceToken);
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
