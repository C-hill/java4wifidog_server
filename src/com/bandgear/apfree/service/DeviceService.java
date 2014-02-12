package com.bandgear.apfree.service;

import com.bandgear.apfree.bean.Device;

public interface DeviceService {

	String getDevices(String deviceToken);

	void addByDevId(Device d, String devId);

}
