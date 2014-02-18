package com.bandgear.apfree.controller.client;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bandgear.apfree.service.OpService;
import com.bandgear.apfree.service.impl.OpServiceImpl;
/**
 * for http://ip/api/client_op/get_all
 * @author hill
 *
 */
public class OpServlet extends HttpServlet {
	OpService s=new OpServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("http://ip/api/client_op/get_all接口被调用了");
		String device_token = req.getParameter("device_token");
		String respStr = s.getAll(device_token);
		resp.getOutputStream().write(respStr.getBytes());
	}

}
