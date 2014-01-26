package com.bandgear.apfree.controller.wifidog;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * auth接口调用该servlet
 * @author hill
 *
 */
public class AuthServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String parameter = request.getParameter("device-token");
		ServletOutputStream os = response.getOutputStream();
		os.write("Auth: 1".getBytes());
		System.out.println("auth接口被调用了");
	}
	public AuthServlet() {
		super();
	}
}
