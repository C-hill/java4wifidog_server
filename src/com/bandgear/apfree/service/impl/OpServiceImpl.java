package com.bandgear.apfree.service.impl;

import java.sql.SQLException;
import java.util.List;

import net.sf.json.JSONObject;

import com.bandgear.apfree.bean.Host;
import com.bandgear.apfree.bean.IPWhite;
import com.bandgear.apfree.bean.MacBlack;
import com.bandgear.apfree.dao.Dao;
import com.bandgear.apfree.dao.impl.HostDao;
import com.bandgear.apfree.dao.impl.IPWhiteDao;
import com.bandgear.apfree.dao.impl.MacBlackDao;
import com.bandgear.apfree.service.OpService;
import com.bandgear.apfree.utils.Utils4Service;

public class OpServiceImpl implements OpService {
	Dao<Host> hd=new HostDao();
	Dao<IPWhite> ipwd=new IPWhiteDao();
	Dao<MacBlack> mwd=new MacBlackDao();
	@Override
	public String getAll(String device_token) {
		JSONObject respObj=new JSONObject();
		try {
			if(Utils4Service.checkDeviceToken(device_token)!=1){//判断device_token是否合法
				respObj.put("code", "0");
				respObj.put("message", "device_token is invalid!");
				return respObj.toString();
			}
			JSONObject resultObj=new JSONObject();
			List<Host> hosts = ((HostDao)hd).findByDeviceToken(device_token);
			List<IPWhite> ipwhites = ((IPWhiteDao)ipwd).findByDeviceToken(device_token);
			List<MacBlack> macblacks = ((MacBlackDao)mwd).findByDeviceToken(device_token);
			resultObj.put("host", hosts);
			resultObj.put("ipwhite", ipwhites);
			resultObj.put("macblack", macblacks);
			respObj.put("code", "1");
			respObj.put("message", "success!");
			respObj.put("result", resultObj);
			return respObj.toString();
		} catch (SQLException e) {
			e.printStackTrace();
			respObj.put("code", "0");
			respObj.put("message", "error!");
			return respObj.toString();
		}
	}

}
