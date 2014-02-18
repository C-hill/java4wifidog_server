package com.bandgear.apfree.service;

import com.bandgear.apfree.bean.IPWhite;

public interface IpWhiteService {

	String addIpWhite(IPWhite ipwhite, String deviceToken);

	String deleteIpWhite(IPWhite ipwhite, String deviceToken);

	String getIpWhites(String deviceToken);

	String clearByDeviceToken(String deviceToken);

}
