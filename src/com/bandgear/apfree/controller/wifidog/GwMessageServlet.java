package com.bandgear.apfree.controller.wifidog;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bandgear.apfree.bean.Ap;
import com.bandgear.apfree.bean.Device;
import com.bandgear.apfree.service.ApService;
import com.bandgear.apfree.service.DeviceService;
import com.bandgear.apfree.service.impl.ApServiceImpl;
import com.bandgear.apfree.service.impl.DeviceServiceImpl;
import com.bandgear.apfree.utils.Utils4Wifidog;
/**
 * gw_message接口调用该servlet
 * @author hill
 *
 */
public class GwMessageServlet extends HttpServlet {
	DeviceService ds=new DeviceServiceImpl();
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) {
		try {
			System.out.println("gw_message接口被调用了:"+request.getRequestURL().toString()+"?"+request.getQueryString());
			request.getRequestDispatcher("/WEB-INF/jsp/gw_message.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public GwMessageServlet() {
		super();
	}
}
