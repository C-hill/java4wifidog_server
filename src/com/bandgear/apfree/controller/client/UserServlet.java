package com.bandgear.apfree.controller.client;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bandgear.apfree.bean.User;
import com.bandgear.apfree.service.UserService;
import com.bandgear.apfree.service.impl.UserServiceImpl;
/**
 * for http://ip/api/wifidog_user/(kind)
 * @author hill
 *
 */
public class UserServlet extends HttpServlet {
	private UserService us=new UserServiceImpl();
	public UserServlet() {
		super();
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String device_token=req.getParameter("device_token");
		String respJson;//将要通过流返回的json字符串
		/**
		 * 获取请求url后面部分，来判断客户端调用的是哪种操作的接口，并且执行相应的操作。
		 */
		String requestUrl = req.getRequestURL().toString();
		String[] split = requestUrl.split("/api/wifidog_user/");
		String opertion=split[1];
		User user=new User();
		if(opertion.equals("add")){//增加
			String username=req.getParameter("username");
			String password=req.getParameter("password");
			String enable=req.getParameter("active");
			user.setUsername(username);
			user.setPassword(password);
			user.setEnable(Integer.parseInt(enable));
			respJson=us.addUser(user,device_token);
		}else if(opertion.equals("delete")){//删除
			String id=req.getParameter("id");
			user.setId(Integer.parseInt(id));
			
			respJson=us.deleteUser(user,device_token);
		}else if(opertion.equals("modify")){//修改
			String username=req.getParameter("username");
			String password=req.getParameter("password");
			String id=req.getParameter("id");
			user.setUsername(username);
			user.setPassword(password);
			user.setId(Integer.parseInt(id));
			
			respJson=us.modifyUser(user,device_token);
		}else if(opertion.equals("active")){//激活or禁用
			String id=req.getParameter("id");
			user.setId(Integer.parseInt(id));
			String enable=req.getParameter("active");
			user.setEnable(Integer.parseInt(enable));
			
			respJson=us.activeUser(user,device_token);
		}else{//获取所有上网账户
			respJson=us.getUsers(device_token);
		}
		System.out.println(opertion);
		resp.getOutputStream().write(respJson.getBytes());
	}
}
