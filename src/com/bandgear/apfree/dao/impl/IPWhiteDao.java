package com.bandgear.apfree.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.bandgear.apfree.bean.Host;
import com.bandgear.apfree.bean.IPWhite;
import com.bandgear.apfree.dao.Dao;
import com.bandgear.apfree.utils.Utils4DB;

public class IPWhiteDao implements Dao<IPWhite>{
	QueryRunner qr=null;
	public IPWhiteDao(){
		if(qr==null){
			qr=new QueryRunner(Utils4DB.getDataSource());
		}
	}
	
	/**
	 * 增加ipwhite
	 */
	@Override
	public int add(IPWhite t) throws SQLException {
		return qr.update("insert into rule_ipwhite(ap_id,ip ,netmask,enable) values(?,?,?,?)", new Object[]{t.getAp_id(),t.getIp(),t.getNetmask(),t.getEnable()+""});
	}

	/**
	 * 删除ipwhite（通过id）
	 */
	@Override
	public int delete(IPWhite t) throws SQLException {
		return qr.update("delete from rule_ipwhite where id=?", t.getId());
	}

	/**
	 * 获取所有ipwhite
	 */
	@Override
	public List<IPWhite> find() throws SQLException {
		return qr.query("select * from rule_ipwhite", new BeanListHandler(IPWhite.class));
	}

	@Override
	public int update(IPWhite t) throws SQLException {
		return 0;
	}
	
	/**
	 * 通过device_token获取对应的ipwhite
	 * @throws SQLException 
	 */
	public List<IPWhite> findByDeviceToken(String device_token) throws SQLException{
		return qr.query("select * from rule_ipwhite where ap_id =(select ap_id from ap where dev_md5=?)", 
				new BeanListHandler(IPWhite.class), new Object[]{device_token});
	}
	
	/**
	 * 通过device_token删除对应的ipwhite
	 * @throws SQLException 
	 */
	public int delByDeviceToken(String device_token) throws SQLException{
		return qr.update("delete from rule_ipwhite where ap_id=(select ap_id from ap where dev_md5=?)", device_token);
	}

	/**
	 * 通过dev_id获取ipwhite
	 * @param devId
	 * @return
	 * @throws SQLException
	 */
	public List<IPWhite> findByDevId(String devId) throws SQLException {
		return qr.query("select * from rule_ipwhite where ap_id =(select ap_id from ap where dev_id=?)", 
				new BeanListHandler(IPWhite.class), new Object[]{devId});
	}

	public int deleteByDeviceToken(String deviceToken) throws SQLException {
		return qr.update("delete from rule_ipwhite where ap_id=(select ap_id from ap where dev_md5=?)", deviceToken);
	}

	public IPWhite findByDeviceTokenAndIp(String deviceToken, String ip) throws SQLException {
		List<IPWhite> query = qr.query("select * from rule_ipwhite where ap_id =(select ap_id from ap where dev_md5=?) and ip=?", 
				new BeanListHandler(IPWhite.class), new Object[]{deviceToken,ip});
		if(query.size()==0){
			return null;
		}
		return query.get(0);
	}
}
