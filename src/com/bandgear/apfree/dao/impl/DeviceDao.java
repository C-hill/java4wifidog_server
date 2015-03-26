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
	public int add(Device t) throws SQLException {
		return qr.update("insert into client(ap_id,kind,ip,mac,token,outgoing,incoming,uprate,downrate,status,login_count,update_time,login_time) values(?,?,?,?,?,?,?,?,?,?,?,?,?)", 
				new Object[]{t.getAp_id(),t.getKind(),t.getIp(),t.getMac(),t.getToken(),t.getOutgoing(),t.getIncoming(),
				t.getUprate(),t.getDownrate(),t.getStatus(),t.getLogin_count(),t.getUpdate_time(),t.getLogin_time()});
	}
	
	@Override
	public int delete(Device t) throws SQLException {
		return 0;
	}
	/**
	 * 获取所有device
	 */
	@Override
	public List<Device> find() throws SQLException {
		return qr.query("select * from client", new BeanListHandler(Device.class));
	}
	
	@Override
	public int update(Device t) throws SQLException {
		return 0;
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
		qr.update("update client set ip=?,token=?,outgoing=?,incoming=?,uprate=?,downrate=?,login_count=?,update_time=?,login_time=? where ap_id =(select ap_id from ap where dev_id=?) and mac=?", 
				new Object[]{t.getIp(),t.getToken(),t.getOutgoing(),t.getIncoming(),t.getUprate(),t.getDownrate(),t.getLogin_count(),t.getUpdate_time(),t.getLogin_time(),devId,t.getMac()});
	}

	public Device findByDevIdAndMac(String devId, String mac) throws SQLException {
		List<Device> query = qr.query("select * from client where ap_id =(select ap_id from ap where dev_id=?) and mac=?", 
				new BeanListHandler(Device.class), new Object[]{devId,mac});
		if(query.size()==0){
			return null;
		}
		return query.get(0);
	}

	public void update(Device device, String token) throws SQLException {
		qr.update("update client set token=? where ap_id =? and mac=?", 
				new Object[]{token,device.getAp_id(),device.getMac()});
	}

	public void add(String devId, String mac, String token) throws SQLException {
		Device d=new Device();
		qr.update("insert into client(ap_id,kind,ip,mac,token,incoming,outgoing,status,login_count,update_time,login_time) values((select ap_id from ap where dev_id=?),?,?,?,?,?,?,?,?,?,?)", 
				new Object[]{devId,d.getKind(),d.getIp(),mac,token,d.getIncoming(),d.getOutgoing(),d.getStatus()+"",d.getLogin_count(),d.getUpdate_time(),d.getLogin_time()});
	}
}
