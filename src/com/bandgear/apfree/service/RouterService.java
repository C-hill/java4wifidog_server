package com.bandgear.apfree.service;

import com.bandgear.apfree.bean.Router;

public interface RouterService {

	String getStatus(String deviceToken);

	void addByDevId(Router router,String devId);
	
}
