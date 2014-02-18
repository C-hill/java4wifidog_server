package com.bandgear.apfree.service.impl;

import java.sql.SQLException;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.bandgear.apfree.bean.User;
import com.bandgear.apfree.dao.Dao;
import com.bandgear.apfree.dao.impl.UserDao;
import com.bandgear.apfree.service.UserService;
import com.bandgear.apfree.utils.Utils4Service;

public class UserServiceImpl implements UserService{
	private Dao<User> ud=null;
	Logger logger=Logger.getLogger(UserServiceImpl.class);
	public UserServiceImpl(){
		if(ud==null){
			ud=new UserDao();
		}
	}
	/**
	 * 用户登陆验证
	 */
	@Override
	public boolean loginValidate(User u, String dev_id){
		try {
			User findUserByUsernamePasswordAndDevId = ((UserDao)ud).findUserByUsernamePasswordAndDevId(u,dev_id);
			if(findUserByUsernamePasswordAndDevId!=null){
				return true;
			}
		} catch (SQLException e) {
			logger.error("SQLException,登陆验证错误");
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 通过device_token获取所有user
	 */
	@Override
	public String getUsers(String deviceToken) {
		JSONObject resultObj=new JSONObject();
		try {
			if(Utils4Service.checkDeviceToken(deviceToken)!=1){//判断device_token是否合法
				resultObj.put("code", "0");
				resultObj.put("message", "device_token is invalid!");
				return resultObj.toString();
			}
			List<User> users = ((UserDao)ud).findByDeviceToken(deviceToken);
			JSONArray jsonArray=new JSONArray();
			jsonArray.add(users);
			
			resultObj.put("result", jsonArray);
			resultObj.put("code", "1");
			resultObj.put("message", "success!");
			return resultObj.toString();
		} catch (SQLException e) {
			e.printStackTrace();
			resultObj.put("code", "0");
			resultObj.put("message", "error!");
			return resultObj.toString();
		}
	}
	/**
	 * 增加用户,并返回json形式字符串
	 */
	@Override
	public String addUser(User user,String deviceToken) {
		JSONObject resultObj=new JSONObject();
		try {
			if(Utils4Service.checkDeviceToken(deviceToken)==0){//判断device_token是否合法
				resultObj.put("code", "0");
				resultObj.put("message", "device_token is invalid!");
				return resultObj.toString();
			}
			user.setAp_id(Utils4Service.getApIdByDeviceToken(deviceToken));
			ud.add(user);
			resultObj.put("code", "1");
			resultObj.put("message", "success!");
			return resultObj.toString();
		} catch (SQLException e) {
			e.printStackTrace();
			resultObj.put("code", "0");
			resultObj.put("message", "error!");
			return resultObj.toString();
		}
	}
	/**
	 * 改变账户的状态，并放回json形式字符串
	 */
	@Override
	public String activeUser(User user,String deviceToken) {
		JSONObject resultObj=new JSONObject();
		try {
			if(Utils4Service.checkDeviceToken(deviceToken)!=1){//判断device_token是否合法
				resultObj.put("code", "0");
				resultObj.put("message", "device_token is invalid!");
				return resultObj.toString();
			}
			((UserDao)ud).active(user);
			resultObj.put("code", "1");
			resultObj.put("message", "success!");
			return resultObj.toString();
		} catch (SQLException e) {
			e.printStackTrace();
			resultObj.put("code", "0");
			resultObj.put("message", "error!");
			return resultObj.toString();
		}
	}
	@Override
	public String deleteUser(User user,String deviceToken) {
		JSONObject resultObj=new JSONObject();
		try {
			ud.delete(user);
			resultObj.put("code", "1");
			resultObj.put("message", "success!");
			return resultObj.toString();
		} catch (SQLException e) {
			e.printStackTrace();
			resultObj.put("code", "0");
			resultObj.put("message", "error!");
			return resultObj.toString();
		}
	}
	/**
	 * 修改用户,并返回json形式字符串
	 */
	@Override
	public String modifyUser(User user,String deviceToken) {
		JSONObject resultObj=new JSONObject();
		try {
			//1.判断device_token是否合法
			if(Utils4Service.checkDeviceToken(deviceToken)!=1){
				resultObj.put("code", "0");
				resultObj.put("message", "device_token is invalid!");
				return resultObj.toString();
			}
			//2.调用dao
			((UserDao)ud).update(user);
			resultObj.put("code", "1");
			resultObj.put("message", "success!");
			return resultObj.toString();
		} catch (SQLException e) {
			e.printStackTrace();
			resultObj.put("code", "0");
			resultObj.put("message", "error!");
			return resultObj.toString();
		}
	}

}
