package com.bandgear.apfree.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.bandgear.apfree.bean.Host;
import com.bandgear.apfree.bean.Router;
import com.bandgear.apfree.dao.Dao;
import com.bandgear.apfree.utils.Utils4DB;

public class HostDao implements Dao<Host>{
	private QueryRunner qr=null;
	public HostDao(){
		if(qr==null){
			qr=new QueryRunner(Utils4DB.getDataSource());
		}
	}
	
	/**
	 * 增加host
	 */
	@Override
	public int add(Host t) throws SQLException {
		return qr.update("insert into rule_host(ap_id,ip ,netmask ,up ,down,session,enable) values(?,?,?,?,?,?,?)", 
				new Object[]{t.getAp_id(),t.getIp(),t.getNetmask(),t.getUp(),t.getDown(),t.getSession(),t.getEnable()+""});
	}
	
	/**
	 * 删除host(通过id)
	 * @throws SQLException 
	 */
	@Override
	public int delete(Host t) throws SQLException {
		return qr.update("delete from rule_host where id=?", t.getId());
	}
	
	/**
	 * 获取所有host
	 */
	@Override
	public List<Host> find() throws SQLException {
		return qr.query("select * from rule_host", new BeanListHandler(Host.class));
	}
	
	/**
	 * 修改host
	 */
	@Override
	public int update(Host t) throws SQLException {
		return qr.update("update rule_host set ip=?, netmask=?, up=? ,down=?,session=? ,enable=?  where id=?", 
				new Object[]{t.getIp(),t.getNetmask(),t.getUp(),t.getDown(),t.getSession(),t.getEnable()+"",t.getId()});
	}
	
	/**
	 * 通过device_token获取对应host
	 * @throws SQLException 
	 */
	public List<Host> findByDeviceToken(String device_token) throws SQLException{
		return qr.query("select * from rule_host where ap_id =(select ap_id from ap where dev_md5=?)", 
				new BeanListHandler(Host.class), new Object[]{device_token});
	}
	
	/**
	 * 通过dev_id获取host
	 * @param devId
	 * @return
	 * @throws SQLException 
	 */
	public List<Host> findByDevId(String devId) throws SQLException {
		return qr.query("select * from rule_host where ap_id =(select ap_id from ap where dev_id=?)", 
				new BeanListHandler(Host.class), new Object[]{devId});
	}

	public int deleteByDeviceToken(String deviceToken) throws SQLException {
		return qr.update("delete from rule_host where ap_id=(select ap_id from ap where dev_md5=?)", deviceToken);
	}
}
