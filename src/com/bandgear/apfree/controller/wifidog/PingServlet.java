package com.bandgear.apfree.controller.wifidog;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.bandgear.apfree.bean.Host;
import com.bandgear.apfree.bean.IPWhite;

/**
 * ping接口调用该servlet
 */
public class PingServlet extends HttpServlet {
	
	static Logger logger=Logger.getLogger(PingServlet.class);
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("ping接口被调用了");
		System.out.println(req.getRequestURL().toString()+"?"+req.getQueryString());
		
//		String gw_id = req.getParameter("gw_id");
//		String sys_uptime = req.getParameter("sys_uptime");
//		String sys_memfree = req.getParameter("sys_memfree");
//		String sys_load = req.getParameter("sys_load");
//		String wifidog_uptime = req.getParameter("wifidog_uptime");
		
		JSONObject resultObject=new JSONObject();
		JSONObject ruleObject=new JSONObject();
		JSONArray ruleArray=new JSONArray();
		List<Host> hostlist=new ArrayList<Host>();
		JSONArray ipwhiteArray=new JSONArray();
		
		Host host1=new Host();
		host1.setAp_id(1);
		host1.setDown(1234);
		host1.setIp("12.1.1.2");
		
		Host host2=new Host();
		host2.setAp_id(1);
		host2.setDown(1234);
		host2.setIp("12.1.1.2");
		
		hostlist.add(host1);
		hostlist.add(host2);
		ruleObject.put("hostlist", hostlist);
		
		IPWhite ipWhite1=new IPWhite();
		ipWhite1.setEnable(1);
		ipWhite1.setId(145);
		ipWhite1.setNetmask("255.255.255.255");
		
		IPWhite ipWhite2=new IPWhite();
		ipWhite2.setEnable(1);
		ipWhite2.setId(145);
		ipWhite2.setNetmask("255.255.255.255");
		
		ipwhiteArray.add(ipWhite1);
		ipwhiteArray.add(ipWhite2);
		ruleObject.put("ipwhite", ipwhiteArray);
		
		
		resultObject.put("rule", ruleObject);
		String pongStr="Pong result="+resultObject.toString();
		/**
		 * 返回Pong
		 * 格式为:
		 * 		Pong+空格+result=json字符串
		 * 
		 * 
		 * Pong result={
		 * 		"rule":{
		 * 			"hostlist":[{"ap_id":1,"down":1234,"enable":0,"id":0,"ip":"12.1.1.2","netmask":"","up":0},{"ap_id":1,"down":1234,"enable":0,"id":0,"ip":"12.1.1.2","netmask":"","up":0}],
		 * 			"ipwhite":[{"enable":1,"id":145,"ip":"","netmask":"255.255.255.255"},{"enable":1,"id":145,"ip":"","netmask":"255.255.255.255"}]}
		 * }
		 * json字符串的完整格式请参见wifidog官方文档
		 */
		resp.getOutputStream().write(pongStr.getBytes());

	}
}
