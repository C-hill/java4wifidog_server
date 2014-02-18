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
	public int add(Router t) throws SQLException {
		return qr.update("insert into ap_status(sys_uptime,sys_memfree,sys_load,wifidog_uptime,update_time,cpu_usage,nf_conntrack_num) values(?,?,?,?,?,?,?)", 
				new Object[]{t.getSys_uptime(),t.getSys_memfree(),t.getSys_load(),t.getWifidog_uptime(),t.getUpdate_time(),t.getCpu_usage(),t.getNf_conntrack_num()});
	}

	@Override
	public int delete(Router t) {
		return 0;
	}

	@Override
	public List<Router> find() throws SQLException {
		List<Router> query =  qr.query("select * from ap_status",new BeanListHandler(Router.class));
		return query;
	}

	@Override
	public int update(Router t) throws SQLException {
		return 0;
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
	/**
	 * 通过dev_id获取router
	 * @param devId
	 * @return
	 * @throws SQLException 
	 */
	public Router findByDevId(String devId) throws SQLException {
		List<Router> query = qr.query("select * from ap_status where ap_id =(select ap_id from ap where dev_id=?)", 
				new BeanListHandler(Router.class), new Object[]{devId});
		if(query.size()==0){
			return null;
		}
		return query.get(0);
	}
	
	/**
	 * 通过dev_id更新router
	 * @param router
	 * @param devId
	 * @throws SQLException
	 */
	public void updateByDevId(Router router, String devId) throws SQLException {
		qr.update("update ap_status set sys_uptime=?,sys_memfree=?,sys_load=?,wifidog_uptime=?,update_time=?,cpu_usage=?,nf_conntrack_num=? where ap_id=(select ap_id from ap where dev_id=?)", 
				new Object[]{router.getSys_uptime(),router.getSys_memfree(),router.getSys_load(),router.getWifidog_uptime(),
				router.getUpdate_time(),router.getCpu_usage(),router.getNf_conntrack_num(),devId});
		}
	
	/**
	 * 通过dev_id增加router
	 * @param router
	 * @param devId
	 * @throws SQLException
	 */
	public void addByDevId(Router router, String devId) throws SQLException {
		qr.update("insert into ap_status values((select ap_id from ap where dev_id=?),?,?,?,?,?,?,?)", 
				new Object[]{devId,router.getSys_uptime(),router.getSys_memfree(),router.getSys_load(),router.getWifidog_uptime(),router.getUpdate_time(),router.getCpu_usage(),router.getNf_conntrack_num()});
	}
	
}
