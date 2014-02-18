package com.bandgear.apfree.service;

import com.bandgear.apfree.bean.MacBlack;

public interface MacBlackService {

	String addMacBlack(MacBlack macBlack, String deviceToken);

	String deleteMacBlack(MacBlack macBlack, String deviceToken);

	String getMacBlacks(String deviceToken);

	String clearByDeviceToken(String deviceToken);

}
