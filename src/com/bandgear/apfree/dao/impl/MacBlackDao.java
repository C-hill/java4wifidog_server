package com.bandgear.apfree.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.bandgear.apfree.bean.Host;
import com.bandgear.apfree.bean.MacBlack;
import com.bandgear.apfree.bean.User;
import com.bandgear.apfree.dao.Dao;
import com.bandgear.apfree.utils.Utils4DB;

public class MacBlackDao implements Dao<MacBlack>{
	QueryRunner qr=null;
	public MacBlackDao(){
		if(qr==null){
			qr=new QueryRunner(Utils4DB.getDataSource());
		}
	}
	
	/**
	 * 增加macblack
	 */
	@Override
	public int add(MacBlack t) throws SQLException {
		return qr.update("insert into rule_macblack(ap_id,mac,enable) values(?,?,?)", new Object[]{t.getAp_id(),t.getMac(),t.getEnable()+""});
	}

	/**
	 * 删除macblack（通过mac）
	 */
	@Override
	public int delete(MacBlack t) throws SQLException {
		return qr.update("delete from rule_macblack where mac=?", t.getMac());
		
	}

	/**
	 * 获取所有macblack
	 */
	@Override
	public List<MacBlack> find() throws SQLException {
		return qr.query("select * from rule_macblack", new BeanListHandler(MacBlack.class));
	}

	@Override
	public int update(MacBlack t) throws SQLException {
		return 0;
	}
	
	/**
	 * 通过device_token获取对应的macblack
	 * @throws SQLException 
	 */
	public List<MacBlack> findByDeviceToken(String device_token) throws SQLException{
		return qr.query("select * from rule_macblack where ap_id =(select ap_id from ap where dev_md5=?)", 
				new BeanListHandler(MacBlack.class), new Object[]{device_token});
	}
	
	/**
	 * 通过device_token删除对应的macblack
	 * @throws SQLException 
	 */
	public void delByDeviceToken(String device_token) throws SQLException{
		qr.update("delete from rule_macblack where ap_id=(select ap_id from ap where dev_md5=?)", device_token);
	}
	
	/**
	 * 通过dev_id获取macblack
	 * @param devId
	 * @return
	 * @throws SQLException
	 */
	public List<MacBlack> findByDevId(String devId) throws SQLException {
		return qr.query("select * from rule_macblack where ap_id =(select ap_id from ap where dev_id=?)", 
				new BeanListHandler(MacBlack.class), new Object[]{devId});
	}
	public int deleteByDeviceToken(String deviceToken) throws SQLException {
		return qr.update("delete from rule_macblack where ap_id=(select ap_id from ap where dev_md5=?)", deviceToken);
	}
}
