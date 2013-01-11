package com.hut.service.impl;


import java.util.List;

import com.hut.dao.impl.BaseDaoImpl;
import com.hut.domain.Xslb;
import com.hut.service.XslbService;

public class XslbServiceImpl extends BaseDaoImpl implements XslbService {

	public Xslb findXslbByXslbdm(int dm) {
		// TODO Auto-generated method stub
		Xslb xslb = new Xslb();
		try {
			xslb = this.getHibernateTemplate().load(Xslb.class, dm);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return xslb;
	}

	public boolean deleteXslbs(List<Xslb> xslbs) {
		// TODO Auto-generated method stub
		boolean b = false;
		try {
			this.getHibernateTemplate().deleteAll(xslbs);
			b = true;
		} catch (Exception e) {
			e.printStackTrace();
			b = false;
		}
		return b;
	}

	
}
