package com.bandgear.apfree.controller.wifidog;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * login接口调用该servlet
 * @author hill
 *
 */
public class LoginServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("login接口被调用了");
		System.out.println(request.getRequestURL().toString()+"?"+request.getQueryString());
		HttpSession session = request.getSession();
		LonginParam param=new LonginParam();
		String method = request.getMethod();
		if("get".equalsIgnoreCase(method)){
			param.setGw_address(request.getParameter("gw_address"));
			param.setGw_id(request.getParameter("gw_id"));
			param.setGw_port(request.getParameter("gw_port"));
			param.setUrl(request.getParameter("url"));
			
//			session.setAttribute("gw_address", request.getParameter("gw_address"));
//			session.setAttribute("gw_id", request.getParameter("gw_id"));
//			session.setAttribute("gw_port", request.getParameter("gw_port"));
//			session.setAttribute("url", request.getParameter("url"));
		}else{
			param.setGw_address("");
			param.setGw_id("");
			param.setGw_port("");
			param.setUrl("");
		}
		/**
		 * 跳转到用户登录页面
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
	}
}
