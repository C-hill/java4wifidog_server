package com.bandgear.apfree.test;


import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.bandgear.apfree.bean.Router;
import com.bandgear.apfree.dao.impl.RouterDao;

public class RouterDaoTest {
	Router r=new Router();
	RouterDao rd=new RouterDao();
	/**
	 * 获取所有router
	 */
	@Test
	public void testFind(){
		try {
			List<Router> find = rd.find();
			for(Router router:find){
				System.out.println(router.getSys_memfree());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据ap_id获取router
	 */
	@Test
	public void testFindByApid(){
		r.setAp_id(1);
		try {
			Router findByApid = rd.findByApid(r);
			System.out.println(findByApid.getSys_memfree());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据device_token获取router
	 */
	@Test
	public void testFindByDeviceToken(){
		try {
			List<Router> findByDeviceToken = rd.findByDeviceToken("adfsadf1312");
			for(Router r:findByDeviceToken){
				System.out.println(r.getSys_memfree());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
