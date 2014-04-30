package com.bandgear.apfree.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;



public class Utils4DB {
	private static DataSource bds;
	static{
		if(bds==null){
			bds=new BasicDataSource();
		}
		try {
			loadProperties();
		} catch (FileNotFoundException e) {
			System.out.println("找不到db配置文件");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("db配置文件错误");
			e.printStackTrace();
		}
	}
	private static void loadProperties() throws FileNotFoundException, IOException {
		Properties p=new Properties();
		String filePath="/db.properties";
		p.load(Utils4DB.class.getResourceAsStream(filePath));
		((BasicDataSource) bds).setDriverClassName("com.mysql.jdbc.Driver");
		((BasicDataSource) bds).setUrl(p.getProperty("url"));
		((BasicDataSource) bds).setUsername(p.getProperty("username"));
		((BasicDataSource) bds).setPassword(p.getProperty("password"));
	}
	public static DataSource getDataSource(){
		return bds;
	}
	public static Connection getConnection(){
		Connection c=null;
		try {
			c= bds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
}
