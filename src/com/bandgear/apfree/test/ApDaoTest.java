package com.bandgear.apfree.test;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.bandgear.apfree.bean.Ap;
import com.bandgear.apfree.bean.Device;
import com.bandgear.apfree.dao.impl.ApDao;
import com.bandgear.apfree.dao.impl.DeviceDao;
import com.bandgear.apfree.utils.Md5Utils;

public class ApDaoTest {
	Ap ap=new Ap();
	ApDao dao=new ApDao();
	@Test
	public void testAdd(){
		ap.setGw_id("gwid");
		ap.setDev_id("48000201000-66000053164000-35718113561096060");
		System.out.println(Md5Utils.encode(ap.getDev_id()));
		ap.setDev_md5(Md5Utils.encode(ap.getDev_id()));
		ap.setEnable(1);
		try {
			dao.add(ap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
