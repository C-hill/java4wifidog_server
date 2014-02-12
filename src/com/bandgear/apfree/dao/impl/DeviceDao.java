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
		qr.update("insert into client(ap_id,kind,ip,mac,token,outgoing,incoming,uprate,downrate,status,login_count,update_time,login_time) values(?,?,?,?,?,?,?,?,?,?,?,?,?)", 
				new Object[]{t.getAp_id(),t.getKind(),t.getIp(),t.getMac(),t.getToken(),t.getOutgoing(),t.getIncoming(),
				t.getUprate(),t.getDownrate(),t.getStatus(),t.getLogin_count(),t.getUpdate_time(),t.getLogin_time()});
	}
	
	@Override
	public void delete(Device t) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 获取所有device
	 */
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
	
	/**
	 * 通过mac获取device
	 * @param device
	 * @return
	 * @throws SQLException 
	 */
	public Device findByMacAndDevId(Device device,String devId) throws SQLException {
		List<Device> query = qr.query("select * from client where ap_id =(select ap_id from ap where dev_id=?) and mac=?", 
				new BeanListHandler(Device.class), new Object[]{devId,device.getMac()});
		if(query.size()==0){
			return null;
		}
		return query.get(0);
	}
	
	/**
	 * 通过dev_id增加device
	 * @param device
	 * @param devId
	 * @throws SQLException 
	 */
	public void addByDevId(Device t, String devId) throws SQLException {
		qr.update("insert into client(ap_id,kind,ip,mac,token,outgoing,incoming,uprate,downrate,status,login_count,update_time,login_time) values((select ap_id from ap where dev_id=?),?,?,?,?,?,?,?,?,?,?,?,?)", 
				new Object[]{devId,t.getKind(),t.getIp(),t.getMac(),t.getToken(),t.getOutgoing(),t.getIncoming(),
				t.getUprate(),t.getDownrate(),t.getStatus(),t.getLogin_count(),t.getUpdate_time(),t.getLogin_time()});
	}

	public void updateByMacAndDevId(Device t, String devId) throws SQLException {
		qr.update("update client set ip=?,mac=?,token=?,outgoing=?,incoming=?,uprate=?,downrate=?,login_count=?,update_time=?,login_time=?", 
				new Object[]{t.getIp(),t.getMac(),t.getToken(),t.getOutgoing(),t.getIncoming(),t.getUprate(),t.getDownrate(),t.getLogin_count(),t.getUpdate_time(),t.getLogin_time()});
	}
}
