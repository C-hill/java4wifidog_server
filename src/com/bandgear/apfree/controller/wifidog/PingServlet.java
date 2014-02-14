package com.bandgear.apfree.controller.wifidog;

import java.io.IOException;
import java.sql.SQLException;
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

import com.bandgear.apfree.bean.Ap;
import com.bandgear.apfree.bean.Host;
import com.bandgear.apfree.bean.IPWhite;
import com.bandgear.apfree.bean.Router;
import com.bandgear.apfree.dao.Dao;
import com.bandgear.apfree.dao.impl.RouterDao;
import com.bandgear.apfree.service.ApService;
import com.bandgear.apfree.service.PingService;
import com.bandgear.apfree.service.RouterService;
import com.bandgear.apfree.service.impl.ApServiceImpl;
import com.bandgear.apfree.service.impl.PingServiceImpl;
import com.bandgear.apfree.service.impl.RouterServiceImpl;
import com.bandgear.apfree.utils.Utils4DB;

/**
 * ping接口调用该servlet
 * 该接口每隔一段时间调用一次
 */
public class PingServlet extends HttpServlet {
	PingService ps=new PingServiceImpl();
	RouterService s=new RouterServiceImpl();
	ApService as=new ApServiceImpl();
	static Logger logger=Logger.getLogger(PingServlet.class);
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("ping接口被调用了");
		System.out.println(req.getRequestURL().toString()+"?"+req.getQueryString());
		/**
		 * 根据dev_id的有无判断是否是官方版wifidog
		 * 有dev_id  是官方版wifidog
		 * 没有dev_id  是apfree版wifidog
		 */
		//1.如果没有dev_id，认为是官方版wifidog
		if(req.getParameter("dev_id")==null){
			String pongStr4Origin = ps.getPongStr4Origin();
			resp.getOutputStream().write(pongStr4Origin.getBytes());
			return;
		}
		//2.apfree版wifidog
		//2.1 增加ap到数据库
		Ap ap=new Ap();
		ap.setDev_id(req.getParameter("dev_id"));
		ap.setGw_id(req.getParameter("gw_id"));
		as.add(ap);
		//2.2增加router到数据库
		Router r=new Router();
		r.setSys_uptime(Integer.parseInt(req.getParameter("sys_uptime")));
		r.setSys_memfree(Integer.parseInt(req.getParameter("sys_memfree")));
		r.setSys_load(Float.parseFloat(req.getParameter("sys_load")));
		r.setWifidog_uptime(Integer.parseInt(req.getParameter("wifidog_uptime")));
		r.setCpu_usage(Integer.parseInt(req.getParameter("cpu_usage")));
		r.setNf_conntrack_num(Integer.parseInt(req.getParameter("nf_conntrack_num")));
		String gw_id = req.getParameter("gw_id");
		String dev_id = req.getParameter("dev_id");
		s.addByDevId(r,dev_id);
		
		//2.3响应
		String pongStr = ps.getPongStr(dev_id);
		resp.getOutputStream().write(pongStr.getBytes());
	}
}
