package com.bandgear.apfree.controller.client;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bandgear.apfree.service.DeviceService;
import com.bandgear.apfree.service.impl.DeviceServiceImpl;

public class DeviceServlet extends HttpServlet {
	DeviceService ds=new DeviceServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String device_token=req.getParameter("device_token");
		String respStr=ds.getDevices(device_token);
		resp.getOutputStream().write(respStr.getBytes());
	}
}
