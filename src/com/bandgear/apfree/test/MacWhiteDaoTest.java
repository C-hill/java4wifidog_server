package com.bandgear.apfree.test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.bandgear.apfree.bean.MacWhite;
import com.bandgear.apfree.dao.impl.MacWhiteDao;

public class MacWhiteDaoTest {
	MacWhite m=new MacWhite();
	MacWhiteDao d=new MacWhiteDao();
	/**
	 * 增加macwhite
	 */
	@Test
	public void testAdd(){
		m.setAp_id(1);
		m.setMac("bb:bb:bb:bb:bb:bb");
		try {
			d.add(m);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 通过device_token找到对应的macwhite
	 */
	@Test
	public void testFindByDeviceToken(){
		try {
			List<MacWhite> findByDeviceToken = d.findByDeviceToken("adfsadf1312");
			for(MacWhite macwhite:findByDeviceToken){
				System.out.println(macwhite.getMac());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除macwhite（通过mac）
	 */
	@Test
	public void testDel(){
		m.setMac("bb:bb:bb:bb:bb:bb");
		try {
			d.delete(m);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
