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

import com.bandgear.apfree.bean.Host;
import com.bandgear.apfree.bean.IPWhite;
import com.bandgear.apfree.bean.Router;
import com.bandgear.apfree.dao.Dao;
import com.bandgear.apfree.dao.impl.RouterDao;
import com.bandgear.apfree.service.PingService;
import com.bandgear.apfree.service.impl.PingServiceImpl;
import com.bandgear.apfree.utils.Utils4DB;

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
		
		PingService ps=new PingServiceImpl();
		String pongStr = ps.getPongStr();
		resp.getOutputStream().write(pongStr.getBytes());
		Dao<Router> dao=new RouterDao();
		try {
			List<Router> find = dao.find();
			System.out.println(find.get(0).getSys_memfree());
		} catch (SQLException e) {
			System.out.println("dao errror");
			e.printStackTrace();
		}
	}
}
