package com.bandgear.apfree.controller.wifidog;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 用户登录验证
 * @author hanyu
 *
 */
public class LoginValidateServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = (String) request.getParameter("username");//用户名
		String password = (String) request.getParameter("password");//密码
		
		String gw_address = (String) request.getParameter("gw_address");//路由器地址
		String gw_port = (String) request.getParameter("gw_port");//路由器端口
		String url = (String) request.getParameter("url");//成功后的重定向url
		String gw_id = (String) request.getParameter("gw_id");
		
		//拼接重定向url
		String redirectUrl="http://"+gw_address+":"+gw_port+"/wifidog/auth?"+"token="+System.currentTimeMillis()+"&url="+url;
//		System.out.println(redirectUrl);
		
		//验证用户名和密码的逻辑
		boolean isValid="admin".equals(username)&&"admin".equals(password);
		
		if(isValid){//成功的话，重定向，路由器放行
			System.out.println("验证成功");
			response.sendRedirect(redirectUrl);
		}else{
			response.getOutputStream().write("验证失败!".getBytes());
		}
	}
	public LoginValidateServlet() {
		super();
	}
}
