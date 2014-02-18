package com.bandgear.apfree.service;

import com.bandgear.apfree.bean.Host;

public interface HostService {

	String addHost(Host host, String deviceToken);

	String deleteHost(Host host, String deviceToken);

	String modifyHost(Host host, String deviceToken);

	String getHosts(String deviceToken);

	String clearByDeviceToken(String deviceToken);

}
