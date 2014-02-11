package com.bandgear.apfree.test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.bandgear.apfree.bean.MacBlack;
import com.bandgear.apfree.dao.impl.MacBlackDao;

public class MacBlackDaoTest {
	MacBlack m=new MacBlack();
	MacBlackDao d=new MacBlackDao();
	
	/**
	 * 增加macblack
	 */
	@Test
	public void testAdd(){
		m.setAp_id(1);
		m.setMac("aa:aa:aa:aa:aa:aa");
		try {
			d.add(m);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除macblack（根据mac）
	 */
	@Test
	public void testDel(){
		m.setMac("aa:aa:aa:aa:aa:aa");
		try {
			d.delete(m);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 *通过device_token获取对应的macblack
	 */
	@Test
	public void testFindByDeviceToken(){
		try {
			List<MacBlack> findByDeviceToken = d.findByDeviceToken("adfsadf1312");
			for(MacBlack macblack:findByDeviceToken){
				System.out.println(macblack.getMac());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
