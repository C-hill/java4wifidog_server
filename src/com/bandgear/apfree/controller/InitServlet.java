package com.bandgear.apfree.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.PropertyConfigurator;

/**
 * 该servlet用作初始化
 * @author hanyu
 *
 */
public class InitServlet extends HttpServlet {

	public void init() throws ServletException {
		initLog4j();//初始化log4j
	}

	private void initLog4j() {
		String filePath = getInitParameter("log4j");
//		System.out.println("日志的配置文件路径为："+filePath);
		if(filePath!=null){
			PropertyConfigurator.configure(filePath);
//			System.out.println("日志的配置文件读取成功");
		}		
	}
}
