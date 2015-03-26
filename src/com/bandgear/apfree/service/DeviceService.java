package com.bandgear.apfree.service;

import java.sql.SQLException;

import com.bandgear.apfree.bean.Device;

public interface DeviceService {

	String getDevices(String deviceToken);

	void addByDevId(Device d, String devId);

	void updateToken(String devId, String mac, String token) throws SQLException;

	boolean checkToken(String token, String devId, String mac) throws SQLException;

}
