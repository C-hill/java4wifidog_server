package com.bandgear.apfree.controller.wifidog;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * login接口调用该servlet
 * 在用户第一次打开网页时
 * @author hill
 *
 */
public class LoginServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("login接口被调用了");
//		System.out.println(request.getRequestURL().toString()+"?"+request.getQueryString());
		
		/**
		 * 根据dev_id的有无判断是否是官方版wifidog
		 * 有dev_id  是官方版wifidog
		 * 没有dev_id  是apfree版wifidog
		 */
		//1.如果没有dev_id，认为是官方版wifidog
		if(request.getParameter("dev_id")==null){
			/**
			 * 跳转到用户登录认证页面
			 */
			request.getRequestDispatcher("/WEB-INF/jsp/login4origin.jsp").forward(request, response);
			return;
		}
		//2.apfree版wifidog
		HttpSession session = request.getSession();
		LonginParam param=new LonginParam();
		String method = request.getMethod();
		param.setGw_address(request.getParameter("gw_address"));
		param.setGw_id(request.getParameter("gw_id"));
		param.setGw_port(request.getParameter("gw_port"));
		param.setUrl(request.getParameter("url"));
		param.setUrl(request.getParameter("dev_id"));
		/**
		 * 跳转到用户登录认证页面
		 */
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
	}

	public LoginServlet() {
		super();
	}
	class LonginParam{
		private String gw_address;
		private String gw_port;
		private String gw_id;
		private String url;
		private String dev_id;
		public String getGw_address() {
			return gw_address;
		}
		public void setGw_address(String gwAddress) {
			gw_address = gwAddress;
		}
		public String getGw_port() {
			return gw_port;
		}
		public void setGw_port(String gwPort) {
			gw_port = gwPort;
		}
		public String getGw_id() {
			return gw_id;
		}
		public void setGw_id(String gwId) {
			gw_id = gwId;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public String getDev_id() {
			return dev_id;
		}
		public void setDev_id(String devId) {
			dev_id = devId;
		}
		
	}
}
