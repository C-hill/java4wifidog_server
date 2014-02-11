package com.bandgear.apfree.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.bandgear.apfree.bean.Device;
import com.bandgear.apfree.bean.Host;
import com.bandgear.apfree.bean.Router;
import com.bandgear.apfree.dao.Dao;
import com.bandgear.apfree.utils.Utils4DB;

public class DeviceDao implements Dao<Device>{
	private QueryRunner qr=null;
	public DeviceDao(){
		if(qr==null){
			qr=new QueryRunner(Utils4DB.getDataSource());
		}
	}
	@Override
	public void add(Device t) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(Device t) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<Device> find() throws SQLException {
		return qr.query("select * from client", new BeanListHandler(Device.class));
	}
	@Override
	public void update(Device t) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 通过device_token获取device
	 * @param device_token
	 * @return
	 * @throws SQLException
	 */
	public List<Device> findByDeviceToken(String device_token) throws SQLException{
		return qr.query("select * from client where ap_id =(select ap_id from ap where dev_md5=?)", 
				new BeanListHandler(Device.class), new Object[]{device_token});
	}
}
