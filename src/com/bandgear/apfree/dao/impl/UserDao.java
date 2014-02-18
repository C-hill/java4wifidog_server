package com.bandgear.apfree.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.bandgear.apfree.bean.Router;
import com.bandgear.apfree.bean.User;
import com.bandgear.apfree.dao.Dao;
import com.bandgear.apfree.utils.Utils4DB;

public class UserDao implements Dao<User>{
	QueryRunner qr=null;
	public UserDao(){
		if(qr==null){
			qr=new QueryRunner(Utils4DB.getDataSource());
		}
	}
	/**
	 * 增加用户
	 */
	@Override
	public int add(User t) throws SQLException {
		Object[] params=new Object[]{t.getUsername(),t.getPassword(),t.getEnable(),t.getAp_id()};
		return qr.update("insert into ap_user(username,password,enable,ap_id) values(?,?,?,?)", params);
	}
	/**
	 * 根据id删除用户
	 */
	@Override
	public int delete(User t) throws SQLException {
		return qr.update("delete from ap_user where id=?", t.getId());
	}
	/**
	 * 获取所有的用户
	 */
	@Override
	public List<User> find() throws SQLException {
		return qr.query("select * from ap_user", new BeanListHandler(User.class));
	}
	/**
	 * 修改用户
	 */
	@Override
	public int update(User t) throws SQLException {
		return qr.update("update ap_user set username=?,password=? where id=?", 
				new Object[]{t.getUsername(),t.getPassword(),t.getId()});
	}
	
	/**
	 * 登陆验证
	 * @param u
	 * @return 
	 * @throws SQLException
	 */
	public User findUserByUsernamePasswordAndDevId(User u,String dev_id) throws SQLException{
		 List<User> users=qr.query("select * from ap_user where username=? and password=? and ap_id=(select ap_id from ap where dev_id=?)",
				new String[]{u.getUsername(),u.getPassword(),dev_id}, new BeanListHandler(User.class));
		 return users.size()==0?null:users.get(0);
	}
	
	/**
	 * 改变用户状态
	 * @param user
	 * @throws SQLException
	 */
	public void active(User user) throws SQLException {
		qr.update("update ap_user set enable=? where id=?", new Object[]{user.getEnable()+"",user.getId()});
	}
	
	/**
	 * 根据device_token获取对应的user
	 * @throws SQLException 
	 */
	public List<User> findByDeviceToken(String device_token) throws SQLException{
		return qr.query("select * from ap_user where ap_id =(select ap_id from ap where dev_md5=?)", 
				new BeanListHandler(User.class), new Object[]{device_token});
	}
	
	/**
	 * 通过device_token删除对应的user
	 * @throws SQLException 
	 */
	public void delByDeviceToken(String device_token) throws SQLException{
		qr.update("delete from ap_user where ap_id=(select ap_id from ap where dev_md5=?)", device_token);
	}
}
