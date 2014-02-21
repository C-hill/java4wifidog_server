package com.bandgear.apfree.controller.client;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bandgear.apfree.bean.Host;
import com.bandgear.apfree.bean.User;
import com.bandgear.apfree.service.HostService;
import com.bandgear.apfree.service.impl.HostServiceImpl;
/**
 * for http://ip/api/client_op/host/(kind)
 * @author hill
 *
 */
public class HostServlet extends HttpServlet {
	HostService s=new HostServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String device_token=req.getParameter("device_token");
		String respJson;//将要通过流返回的json字符串
		/**
		 * 获取请求url后面部分，来判断客户端调用的是哪种操作的接口，并且执行相应的操作。
		 */
		String requestUrl = req.getRequestURL().toString();
		String[] split = requestUrl.split("/api/client_op/host/");
		String opertion=split[1];
		Host host=new Host();
		if(opertion.equals("add")){//增加
			System.out.println("host add接口被调用了");
			host.setIp(req.getParameter("ip")); 
			host.setNetmask(req.getParameter("netmask"));
			host.setUp(Integer.parseInt(req.getParameter("up")));
			host.setDown(Integer.parseInt(req.getParameter("down")));
			
			respJson=s.addHost(host,device_token);
		}else if(opertion.equals("delete")){//删除
			System.out.println("host delete接口被调用了");
			String id=req.getParameter("id");
			if("all".equals(id)){
				respJson=s.clearByDeviceToken(device_token);
			}else{
				host.setId(Integer.parseInt(id));
				respJson=s.deleteHost(host,device_token);
			}
		}else if(opertion.equals("modify")){//修改
			System.out.println("host modify接口被调用了");
			host.setId(Integer.parseInt(req.getParameter("id")));
			host.setIp(req.getParameter("ip")); 
			host.setNetmask(req.getParameter("netmask"));
			host.setUp(Integer.parseInt(req.getParameter("up")));
			host.setDown(Integer.parseInt(req.getParameter("down")));
			
			respJson=s.modifyHost(host,device_token);
		}else{//获取host
			respJson=s.getHosts(device_token);
		}
		System.out.println(opertion);
		resp.getOutputStream().write(respJson.getBytes());
	}
}
