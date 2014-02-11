package com.bandgear.apfree.test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.bandgear.apfree.bean.IPWhite;
import com.bandgear.apfree.dao.impl.IPWhiteDao;

public class IpWhiteDaoTest {
	IPWhite i=new IPWhite();
	IPWhiteDao d=new IPWhiteDao();
	/**
	 * 增加ipwhite
	 */
	@Test
	public void testAdd(){
		i.setAp_id(1);
		i.setIp("123.15.15.15");
		i.setNetmask("255.255.255.255");
		try {
			d.add(i);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除ipwhite(通过id)
	 */
	@Test
	public void testDel(){
		i.setId(1);
		try {
			d.delete(i);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 通过device_token删除对应的ipwhite
	 */
	@Test
	public void testDelByDeviceToken(){
		try {
			d.delByDeviceToken("adfsadf1312");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 通过device_token获取对应的ipwhite
	 */
	@Test
	public  void testFindByDeviceToken(){
		try {
			List<IPWhite> findByDeviceToken = d.findByDeviceToken("adfsadf1312");
			for(IPWhite ipwhite:findByDeviceToken){
				System.out.println(ipwhite.getIp());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
