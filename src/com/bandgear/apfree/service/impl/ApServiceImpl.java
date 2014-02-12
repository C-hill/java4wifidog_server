package com.bandgear.apfree.service.impl;

import com.bandgear.apfree.bean.Ap;
import com.bandgear.apfree.dao.Dao;
import com.bandgear.apfree.dao.impl.ApDao;
import com.bandgear.apfree.service.ApService;
import com.bandgear.apfree.utils.Md5Utils;

public class ApServiceImpl implements ApService {
	Dao<Ap> d=new ApDao();
	@Override
	public void add(Ap ap) {
		try {
			//1.通过dev_id查找对应ap
			Ap findByDevId = ((ApDao)d).findByDevId(ap.getDev_id());
			//2.1如果存在
			if(findByDevId!=null){
				
			//2.2如果不存在,增加ap
			}else{
				ap.setDev_md5(Md5Utils.encode(ap.getDev_id()));
				ap.setEnable(1);
				d.add(ap);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
