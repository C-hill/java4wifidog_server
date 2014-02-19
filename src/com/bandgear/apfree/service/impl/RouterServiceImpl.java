package com.bandgear.apfree.service.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;

import com.bandgear.apfree.bean.Router;
import com.bandgear.apfree.dao.impl.ApDao;
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
			//1.判断device_token是否合法，不合法返回结果中没有result
			if(checkDeviceToken!=1){
				resultObj.put("code", "0");
				resultObj.put("message", "device_token is invalid!");
				return resultObj.toString();
			}
			//2.合法的话，返回结果中有result
			List<Router> findByDeviceToken = rd.findByDeviceToken(deviceToken);
			for(Router r:findByDeviceToken){
				r.setOnline(1);
				r.setClient_num(Utils4Service.getOnlineDeviceNumByDeviceToken(deviceToken));
			}
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
	@Override
	public void addByDevId(Router router,String devId) {
		try {
			router.setUpdate_time(new Date());
			//1.通过devId获取router
			Router findByDevId = rd.findByDevId(devId);
			//2.1如果没有获取到router，执行add操作
			if(findByDevId==null){
				rd.addByDevId(router,devId);
			//2.2如果获取到router，执行update操作
			}else{
				rd.updateByDevId(router,devId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
