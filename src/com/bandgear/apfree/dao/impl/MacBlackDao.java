package com.bandgear.apfree.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

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
	@Override
	public void add(MacBlack t) throws SQLException {
		qr.update("insert into rule_macblack(ap_id,mac,enable) values(?,?,?)", new Object[]{t.getAp_id(),t.getMac(),t.getEnable()+""});
	}

	@Override
	public void delete(MacBlack t) throws SQLException {
		qr.update("delete from rule_macblack where mac=?", t.getMac());
		
	}

	@Override
	public List<MacBlack> find() throws SQLException {
		return qr.query("select * from rule_macblack", new BeanListHandler(MacBlack.class));
	}

	@Override
	public void update(MacBlack t) throws SQLException {
		// TODO Auto-generated method stub
		
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
}
