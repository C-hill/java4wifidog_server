package com.bandgear.apfree.controller.wifidog;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bandgear.apfree.bean.User;
import com.bandgear.apfree.service.DeviceService;
import com.bandgear.apfree.service.UserService;
import com.bandgear.apfree.service.impl.DeviceServiceImpl;
import com.bandgear.apfree.service.impl.UserServiceImpl;
/**
 * 用户登录验证
 * @author hanyu
 *
 */
public class LoginValidateServlet extends HttpServlet {
	private UserService us=new UserServiceImpl();
	private DeviceService ds=new DeviceServiceImpl();
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) {
		try{
			response.setCharacterEncoding("UTF-8");
			String gw_address = (String) request.getParameter("gw_address");//路由器地址
			String gw_port = (String) request.getParameter("gw_port");//路由器端口
			String url = (String) request.getParameter("url");//成功后的重定向url
			String gw_id = (String) request.getParameter("gw_id");
			String dev_id = (String) request.getParameter("dev_id");
			String mac=(String) request.getParameter("mac");//客户端mac地址
			
			//拼接重定向url
			String token=System.currentTimeMillis()+"";
			String redirectUrl="http://"+gw_address+":"+gw_port+"/wifidog/auth?"+"token="+token+"&url="+url;
	//		System.out.println(redirectUrl);
			
			/**
			 * 根据dev_id的有无判断是否是官方版wifidog
			 * 有dev_id  是官方版wifidog
			 * 没有dev_id  是apfree版wifidog
			 */
			//1.如果没有dev_id，认为是官方版wifidog
			if(request.getParameter("dev_id")==null||"".equals(request.getParameter("dev_id"))){
				//可根据自己的业务实现认证逻辑
				response.sendRedirect(redirectUrl);
				return;
			}
			//2.apfree版wifidog
			//验证用户名和密码的逻辑
			User u=new User();
			u.setUsername(request.getParameter("username"));
			u.setPassword(request.getParameter("password"));
			boolean isValid=us.loginValidate(u, dev_id);
			
			if(isValid){//成功的话，重定向，路由器放行
				System.out.println("认证登录成功");
				//把token更新或写入到client表中（用户token验证）
				ds.updateToken(dev_id,mac,token);
				response.sendRedirect(redirectUrl);
			}else{
				response.getOutputStream().write("认证登录失败!".getBytes("UTF-8"));
			}
		}catch (Exception e) {
			try {
				response.getOutputStream().write("认证登录时出现异常!".getBytes("UTF-8"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
}
