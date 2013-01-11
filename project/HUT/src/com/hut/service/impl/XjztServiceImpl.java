package com.hut.service.impl;


import java.util.List;

import com.hut.dao.impl.BaseDaoImpl;
import com.hut.domain.Ejxk;
import com.hut.domain.Xjzt;
import com.hut.domain.Xyzy;
import com.hut.service.EjxkService;
import com.hut.service.XjztService;

public class XjztServiceImpl extends BaseDaoImpl implements XjztService {

	public Xjzt findXjztByXjztdm(int xjztdm) {
		// TODO Auto-generated method stub
		Xjzt xjzt = new Xjzt();
		try {
			xjzt = this.getHibernateTemplate().get(Xjzt.class, xjztdm);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return xjzt;
	}
}
