package com.bandgear.apfree.controller.client;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bandgear.apfree.bean.MacWhite;
import com.bandgear.apfree.service.MacWhiteService;
import com.bandgear.apfree.service.impl.MacWhiteServiceImpl;
/**
 * for http://ip/api/client_op/macwhite/(kind)
 * @author hill
 *
 */
public class MacWhiteServlet extends HttpServlet {
	MacWhiteService s=new MacWhiteServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String device_token=req.getParameter("device_token");
		String respJson;//将要通过流返回的json字符串
		/**
		 * 获取请求url后面部分，来判断客户端调用的是哪种操作的接口，并且执行相应的操作。
		 */
		String requestUrl = req.getRequestURL().toString();
		String[] split = requestUrl.split("/api/client_op/macwhite/");
		String opertion=split[1];
		MacWhite macWhite=new MacWhite();
		if(opertion.equals("add")){//增加
			System.out.println("macwhite add接口被调用了");
			String mac=req.getParameter("mac");
			if("all".equals(mac)){
				respJson=s.clearByDeviceToken(device_token);
			}else{
				macWhite.setMac(req.getParameter("mac")); 
				respJson=s.addMacWhite(macWhite,device_token);
			}
		}else if(opertion.equals("delete")){//删除
			System.out.println("macwhite delete接口被调用了");
			macWhite.setMac(req.getParameter("mac"));
			
			respJson=s.deleteMacWhite(macWhite,device_token);
		}else{//获取所有
			respJson=s.getMacWhites(device_token);
		}
		System.out.println(opertion);
		resp.getOutputStream().write(respJson.getBytes());
		
	}

}
