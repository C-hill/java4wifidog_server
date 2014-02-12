package com.bandgear.apfree.test;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.bandgear.apfree.bean.Device;
import com.bandgear.apfree.dao.impl.DeviceDao;

public class DeviceDaoTest {
	Device d=new Device();
	DeviceDao dao=new DeviceDao();
	/**
	 * 获取所有
	 */
	@Test
	public void testFind(){
		try {
			List<Device> find = dao.find();
			Date d=new Date();
			System.out.println(d.toLocaleString());
			System.out.println(d.toGMTString());
			System.out.println(d.toString());
			for(Device device:find){
				System.out.println(device.getMac());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 通过device_token获取device
	 */
	@Test
	public void testFindByDeviceToken(){
		try {
			List<Device> findByDeviceToken = dao.findByDeviceToken("adfsadf1312");
			for(Device device:findByDeviceToken){
				System.out.println(device.getMac());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
