package com.bandgear.apfree.utils;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.bandgear.apfree.bean.Ap;

public class Utils4Service {
	static QueryRunner qr=new QueryRunner(Utils4DB.getDataSource());
	public static int checkDeviceToken(String device_token) throws SQLException{
		List<Ap> query = qr.query("select * from ap where dev_md5=?", new BeanListHandler(Ap.class), device_token);
		if(query.size()==0){//没有该device_token
			return 0;
		}else{
			Ap ap = query.get(0);
			Integer enable = ap.getEnable();
			if(enable==0){//device_token不可用
				return 2;
			}
		}
		return 1;
	}
	
	public static Integer getApIdByDeviceToken(String device_token){
		try {
			List<Ap> query = qr.query("select * from ap where dev_md5=?", new BeanListHandler(Ap.class), device_token);
			return query.get(0).getAp_id();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
}
