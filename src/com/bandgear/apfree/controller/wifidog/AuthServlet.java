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
/**
 * auth接口调用该servlet
 * 该接口每隔一段时间调用一次
 * @author hill
 *
 */
public class AuthServlet extends HttpServlet {
	DeviceService ds=new DeviceServiceImpl();
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 1.ip
		 * 2. mac
		 * 3. token（login页面下发的token）
		 * 4.incoming 下载流量
		 * 5.outgoing 上传流量 
		 * 6.stage  认证阶段，就两种 login 和 counters
		 * 7.dev_id 设备id，45位字符串（用来区分不同的设备）
		 * 8.uprate 该客户端该时刻即时上行速率，单位  bps
		 * 9.downrate 该客户端该时刻即时下行速率，单位  bps
		 */
		Device d=new Device();
		d.setDownrate(Integer.parseInt(request.getParameter("downrate")));
		d.setUprate(Integer.parseInt(request.getParameter("uprate")));
		d.setIp(request.getParameter("ip"));
		d.setMac(request.getParameter("mac"));
		d.setToken(request.getParameter("token"));
		d.setIncoming(Integer.parseInt(request.getParameter("incoming")));
		d.setOutgoing(Integer.parseInt(request.getParameter("outgoing")));
		
		String stage=request.getParameter("stage");
		String dev_id=request.getParameter("dev_id");
		String gw_id=request.getParameter("gw_id");
		ds.addByDevId(d,dev_id);
		/**
		 * 0 - 拒绝
		 * 1 - 放行
		 */
		System.out.println(request.getQueryString());
		ServletOutputStream os = response.getOutputStream();
		os.write("Auth: 1".getBytes());
		System.out.println("auth接口被调用了");
	}
	public AuthServlet() {
		super();
	}
}
