package com.bandgear.apfree.controller.client;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bandgear.apfree.bean.MacBlack;
import com.bandgear.apfree.service.MacBlackService;
import com.bandgear.apfree.service.impl.MacBlackServiceImpl;
/**
 * for http://ip/api/client_op/macblack/(kind)
 * @author hill
 *
 */
public class MacBlackServlet extends HttpServlet {
	MacBlackService s=new MacBlackServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String device_token=req.getParameter("device_token");
		String respJson;//将要通过流返回的json字符串
		/**
		 * 获取请求url后面部分，来判断客户端调用的是哪种操作的接口，并且执行相应的操作。
		 */
		String requestUrl = req.getRequestURL().toString();
		String[] split = requestUrl.split("/api/client_op/macblack/");
		String opertion=split[1];
		MacBlack macBlack=new MacBlack();
		if(opertion.equals("add")){//增加
			System.out.println("macblack add接口被调用了");
			macBlack.setMac(req.getParameter("mac")); 
			
			respJson=s.addMacBlack(macBlack,device_token);
		}else if(opertion.equals("delete")){//删除
			System.out.println("macbalck delete接口被调用了");
			String mac=req.getParameter("mac");
			if("all".equals(mac)){
				respJson=s.clearByDeviceToken(device_token);
			}else{
				macBlack.setMac(req.getParameter("mac"));
				respJson=s.deleteMacBlack(macBlack,device_token);
			}
		}else{//获取所有macblack
			respJson=s.getMacBlacks(device_token);
		}
		System.out.println(opertion);
		resp.getOutputStream().write(respJson.getBytes());
	}

}
