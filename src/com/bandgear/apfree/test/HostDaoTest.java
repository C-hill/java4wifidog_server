package com.bandgear.apfree.test;

import java.security.MessageDigest;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.bandgear.apfree.bean.Host;
import com.bandgear.apfree.dao.impl.HostDao;
import com.bandgear.apfree.utils.Md5Utils;

public class HostDaoTest {
	Host h=new Host();
	HostDao d=new HostDao();
	/**
	 * 增加host
	 */
	@Test
	public void testAdd(){
		h.setAp_id(4);
		h.setIp("12.14.15.13");
		h.setNetmask("255.255.255.255");
		h.setUp(100);
		h.setDown(50);
		h.setSession(10);
		h.setEnable(1);
		try {
			d.add(h);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除host（通过id）
	 */
	@Test
	public void testDel(){
		h.setId(4);
		try {
			d.delete(h);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 修改host（通过id）
	 */
	@Test
	public void testUpdate(){
		h.setId(3);
		h.setIp("12.14.15.13");
		h.setNetmask("255.255.255.0");
		h.setUp(100);
		h.setDown(500);
		try {
			d.update(h);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 通过device_token获取对应host
	 */
	@Test
	public void findByDeviceToken(){
		try {
			List<Host> findByDeviceToken = d.findByDeviceToken("adfsadf1312");
			for(Host host:findByDeviceToken){
				System.out.println(host.getIp());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
