package com.bandgear.apfree.test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.bandgear.apfree.bean.User;
import com.bandgear.apfree.dao.impl.UserDao;

public class UserDaoTest {
	User u=new User();
	UserDao ud=new UserDao();
	
	/**
	 * 增加
	 */
	@Test
	public void testAdd(){
		u.setUsername("uname");
		u.setPassword("pword");
		u.setEnable(1);
		u.setAp_id(1);
		try {
			ud.add(u);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据device_token获取对应的user
	 */
	@Test
	public void testFindByDeviceToken(){
		try {
			List<User> findByDeviceToken = ud.findByDeviceToken("adfsadf1312");
			for(User user:findByDeviceToken){
				System.out.println(user.getUsername());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 修改(根据id来修改用户名或密码)
	 */
	@Test
	public void testUpdate(){
		u.setId(4);
		u.setUsername("hill");
		u.setPassword("pword");
		try {
			ud.update(u);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除（根据id删除）
	 */
	@Test
	public void testDel(){
		u.setId(3);
		try {
			ud.delete(u);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 获取所有
	 */
	@Test
	public void testFindAll(){
		try {
			List<User> find = ud.find();
			for(User u:find){
				System.out.println(u.getUsername());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 验证一组用户名密码是否存在
	 */
	@Test
	public void testFindUserByUsernameAndPassword(){
		u.setUsername("admin");
		u.setPassword("admin");
		try {
			User findUserByUsernamePasswordAndDevId = ud.findUserByUsernamePasswordAndDevId(u, "48000201000-66000053164000-35718113561096060");
			System.out.println(findUserByUsernamePasswordAndDevId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 改变用户的状态（根据id）
	 */
	@Test
	public void testActive(){
		u.setEnable(0);
		u.setId(4);
		try {
			ud.active(u);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
