package com.bandgear.apfree.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.bandgear.apfree.bean.MacBlack;
import com.bandgear.apfree.bean.MacWhite;
import com.bandgear.apfree.dao.Dao;
import com.bandgear.apfree.utils.Utils4DB;

public class MacWhiteDao implements Dao<MacWhite>{
	QueryRunner qr=null;
	public MacWhiteDao(){
		if(qr==null){
			qr=new QueryRunner(Utils4DB.getDataSource());
		}
	}
	/**
	 * 增加macwhite
	 */
	@Override
	public int add(MacWhite t) throws SQLException {
		return qr.update("insert into rule_macwhite(ap_id,mac,enable) values(?,?,?)", new Object[]{t.getAp_id(),t.getMac(),t.getEnable()+""});
	}

	/**
	 * 删除macwhite（根据mac）
	 */
	@Override
	public int delete(MacWhite t) throws SQLException {
		return qr.update("delete from rule_macwhite where mac=?", t.getMac());
	}
	
	/**
	 * 获取所有的macwhite
	 */
	@Override
	public List<MacWhite> find() throws SQLException {
		return qr.query("select * from rule_macwhite", new BeanListHandler(MacBlack.class));
	}

	@Override
	public int update(MacWhite t) throws SQLException {
		return 0;
	}
	/**
	 * 通过device_token删除对应的macwhite
	 * @throws SQLException 
	 */
	public void delByDeviceToken(String device_token) throws SQLException{
		qr.update("delete from rule_macwhite where ap_id=(select ap_id from ap where dev_md5=?)", device_token);
	}
	
	/**
	 * 通过device_token获取对应的macwhite
	 */
	public List<MacWhite> findByDeviceToken(String device_token) throws SQLException{
		return qr.query("select * from rule_macwhite where ap_id =(select ap_id from ap where dev_md5=?)", 
				new BeanListHandler(MacWhite.class), new Object[]{device_token});
	}
	public int deleteByDeviceToken(String deviceToken) throws SQLException {
		return qr.update("delete from rule_macwhite where ap_id=(select ap_id from ap where dev_md5=?)", deviceToken);
	}
}
