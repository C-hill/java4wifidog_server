package com.bandgear.apfree.controller.client;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bandgear.apfree.bean.IPWhite;
import com.bandgear.apfree.service.IpWhiteService;
import com.bandgear.apfree.service.impl.IpWhiteServiceImpl;
/**
 * for http://ip/api/client_op/ipwhite/(kind)
 * kind: add  delete 
 * @author hill
 *
 */
public class IpWhiteServlet extends HttpServlet {
	IpWhiteService s=new IpWhiteServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String device_token=req.getParameter("device_token");
		String respJson;//将要通过流返回的json字符串
		/**
		 * 获取请求url后面部分，来判断客户端调用的是哪种操作的接口，并且执行相应的操作。
		 */
		String requestUrl = req.getRequestURL().toString();
		String[] split = requestUrl.split("/api/client_op/ipwhite/");
		String opertion=split[1];
		IPWhite ipwhite=new IPWhite();
		if(opertion.equals("add")){//增加
			System.out.println("ipwhite 接口被调用了");
			ipwhite.setIp(req.getParameter("ip")); 
			ipwhite.setNetmask(req.getParameter("netmask"));
			
			respJson=s.addIpWhite(ipwhite,device_token);
		}else if(opertion.equals("delete")){//删除  清空
			System.out.println("ipwhite delete接口被调用了");
			String id=req.getParameter("id");
			if("all".equals(id)){
				respJson=s.clearByDeviceToken(device_token);
			}else{
				ipwhite.setId(Integer.parseInt(id));
				respJson=s.deleteIpWhite(ipwhite,device_token);
			}
		}else{//获取所有host
			respJson=s.getIpWhites(device_token);
		}
		System.out.println(opertion);
		resp.getOutputStream().write(respJson.getBytes());
	}
}
