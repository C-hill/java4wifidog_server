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
 * auth接口调用该servlet
 * 该接口在用户认证后每隔一段时间调用一次
 * @author hill
 *
 */
public class AuthServlet extends HttpServlet {
	DeviceService ds=new DeviceServiceImpl();
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) {
		try {
			System.out.println("auth接口被调用了:"+request.getRequestURL().toString()+"?"+request.getQueryString());
			ServletOutputStream os = response.getOutputStream();
			/**
			 * 根据dev_id的有无判断是否是官方版wifidog
			 * 有dev_id  是官方版wifidog
			 * 没有dev_id  是apfree版wifidog
			 */
			//1.如果没有dev_id，认为是原版wifidog
			if(request.getParameter("dev_id")==null){
				//可根据自己的业务需求决定在何种条件下放行
				response.getOutputStream().write("Auth: 1".getBytes());
				return;
			}
			//2.apfree版wifidog
			//2.1检查user_agent是否合法,不合法return
//			if(!Utils4Wifidog.checkUserAgent(request.getHeader("user-agent"))){
//				System.out.println("非法user_agent");
//				return;
//			}
			//2.2增加或更新device(client表)
			Device d=new Device();
			d.setDownrate(Integer.parseInt(request.getParameter("downrate")));
			d.setUprate(Integer.parseInt(request.getParameter("uprate")));
			d.setIp(request.getParameter("ip"));
			d.setMac(request.getParameter("mac"));
			d.setToken(request.getParameter("token"));
			d.setIncoming(Integer.parseInt(request.getParameter("incoming")));
			d.setOutgoing(Integer.parseInt(request.getParameter("outgoing")));
			
			String dev_id=request.getParameter("dev_id");
			//token检查
			String token=request.getParameter("token");
			String mac=request.getParameter("mac");
			boolean f=ds.checkToken(token,dev_id,mac);
			if(!f){//token不一致,拒绝
				os.write("Auth: 0".getBytes());
				return;
			}
			ds.addByDevId(d,dev_id);
			//2.3放行或者拒绝
			/**
			 * 0 - 拒绝
			 * 1 - 放行
			 */
			os.write("Auth: 1".getBytes());
		} catch (Exception e) {
			ServletOutputStream os;
			try {
				os = response.getOutputStream();
				os.write("Auth: 0".getBytes());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	public AuthServlet() {
		super();
	}
}
