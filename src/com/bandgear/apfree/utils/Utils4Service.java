package com.bandgear.apfree.utils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import com.bandgear.apfree.bean.Ap;
import com.bandgear.apfree.bean.Device;
import com.bandgear.apfree.bean.IPWhite;
import com.bandgear.apfree.dao.Dao;
import com.bandgear.apfree.dao.impl.ApDao;
import com.bandgear.apfree.dao.impl.DeviceDao;
import com.bandgear.apfree.dao.impl.IPWhiteDao;

public class Utils4Service {
	static QueryRunner qr=new QueryRunner(Utils4DB.getDataSource());
	static Dao<Ap> d=new ApDao();
	static Dao<Device> dd=new DeviceDao();
	static Dao<IPWhite> dipw=new IPWhiteDao();
	/**
	 * 判断device_token的有效性
	 * @param device_token
	 * @return
	 * @throws SQLException
	 */
	public static int checkDeviceToken(String device_token) throws SQLException{
		Ap findByDeviceToken = ((ApDao)d).findByDeviceToken(device_token);
		if(findByDeviceToken==null){//没有该device_token
			return 0;
		}else{
			Integer enable = findByDeviceToken.getEnable();
			if(enable==0){//device_token不可用
				return 2;
			}
		}
		return 1;
	}
	
	/**
	 * 获取ap_id
	 * @param device_token
	 * @return
	 */
	public static Integer getApIdByDeviceToken(String device_token){
		try {
			Ap findByDeviceToken = ((ApDao)d).findByDeviceToken(device_token);
			return findByDeviceToken.getAp_id();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	/**
	 * 获取在线的连接设备
	 * @param devices
	 * @return
	 */
	public static List<Device> getOnlineDevice(List<Device> devices) {
		List<Device> devs=new ArrayList<Device>();
		for(Device d:devices){
			Date updateTime = d.getUpdate_time();
//			System.out.println(System.currentTimeMillis());
//			System.out.println(updateTime.getTime());
			if(System.currentTimeMillis()-updateTime.getTime()<2*60*1000){
				devs.add(d);
			}
		}
		return devs;
	}
	/**
	 * 获取在线的连接设备数量
	 * @param device_token
	 * @return
	 * @throws SQLException
	 */
	public static int getOnlineDeviceNumByDeviceToken(String device_token) throws SQLException {
		return getOnlineDevice(((DeviceDao)dd).findByDeviceToken(device_token)).size();
	}
	/**
	 * 判断device（连接设备）是否在ip白名单中
	 * @param device
	 * @param device_token
	 * @return
	 * @throws SQLException
	 */
	public static boolean isDeviceInIpWhite(Device device,String device_token) throws SQLException {
		IPWhite findByDeviceTokenAndIp = ((IPWhiteDao)dipw).findByDeviceTokenAndIp(device_token,device.getIp());
		if(findByDeviceTokenAndIp==null){
			return false;
		}
		return true;
	}
}
