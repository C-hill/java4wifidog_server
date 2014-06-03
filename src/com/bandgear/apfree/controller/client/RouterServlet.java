package com.bandgear.apfree.controller.client;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bandgear.apfree.service.RouterService;
import com.bandgear.apfree.service.impl.RouterServiceImpl;

/**
 * for  http://ip/api/get_status
 * @author hill
 *
 */
public class RouterServlet extends HttpServlet {
	RouterService rs=new RouterServiceImpl();
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("get_status接口被调用了");
		String device_token=request.getParameter("device_token");
		System.out.println("device_token:"+device_token);
		String respStr=rs.getStatus(device_token);
		resp.getOutputStream().write(respStr.getBytes());
	}
}
