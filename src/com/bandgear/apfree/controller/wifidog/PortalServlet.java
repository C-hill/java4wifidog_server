package com.bandgear.apfree.controller.wifidog;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * portal接口调用该servlet
 * @author hill
 *
 */
public class PortalServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("调用了portal接口:"+request.getRequestURL().toString()+"?"+request.getQueryString());
		/**
		 * 根据dev_id的有无判断是否是原版wifidog
		 * 有dev_id  是原版wifidog
		 * 没有dev_id  是apfree版wifidog
		 */
		//1.如果没有dev_id，认为是官方版wifidog
		if(request.getParameter("dev_id")==null){
			response.sendRedirect("http://www.google.com.hk");
			return;
		}
		//2.apfree版wifidog
		//用户登录成功，并且路由器放行后，重定向到某个页面
		response.sendRedirect("http://www.apfree.net");
	}
}
