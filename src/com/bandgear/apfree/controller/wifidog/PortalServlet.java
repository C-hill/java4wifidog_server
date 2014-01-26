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
		System.out.println("调用了portal接口");
		//用户登录成功，并且路由器放行后，重定向到某个页面
		response.sendRedirect("http://www.baidu.com");
	}

}
