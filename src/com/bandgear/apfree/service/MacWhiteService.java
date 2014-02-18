package com.bandgear.apfree.service;

import com.bandgear.apfree.bean.MacWhite;

public interface MacWhiteService {

	String addMacWhite(MacWhite macWhite, String deviceToken);

	String deleteMacWhite(MacWhite macWhite, String deviceToken);

	String getMacWhites(String deviceToken);

	String clearByDeviceToken(String deviceToken);

}
