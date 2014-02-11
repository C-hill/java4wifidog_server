package com.bandgear.apfree.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.bandgear.apfree.bean.Router;
import com.bandgear.apfree.dao.Dao;
import com.bandgear.apfree.utils.Utils4DB;


public class RouterDao implements Dao<Router>{
	private QueryRunner qr=null;
	public RouterDao(){
		qr=new QueryRunner(Utils4DB.getDataSource());
	}
	@Override
	public void add(Router t) {
		
	}

	@Override
	public void delete(Router t) {
		
	}

	@Override
	public List<Router> find() throws SQLException {
		List<Router> query =  qr.query("select * from ap_status",new BeanListHandler(Router.class));
		return query;
	}

	@Override
	public void update(Router t) throws SQLException {
		
	}
	/**
	 * 根据ap_id获取router
	 * @throws SQLException 
	 */
	public Router findByApid(Router router) throws SQLException{
		List<Router> query = qr.query("select * from ap_status where ap_id = ?",
				new Object[]{router.getAp_id()}, new BeanListHandler(Router.class));
		return query.get(0);
	}
	/**
	 * 根据device_token获取对应的router
	 * @throws SQLException 
	 */
	public List<Router> findByDeviceToken(String device_token) throws SQLException{
		List<Router> query = qr.query("select * from ap_status where ap_id =(select ap_id from ap where dev_md5=?)", 
				new BeanListHandler(Router.class), new Object[]{device_token});
		return query;
	}
	
}
