package com.hut.service.impl;


import java.util.List;

import com.hut.dao.impl.BaseDaoImpl;
import com.hut.domain.Ejxk;
import com.hut.domain.X;
import com.hut.domain.Xyzy;
import com.hut.service.EjxkService;
import com.hut.service.XService;

public class XServiceImpl extends BaseDaoImpl implements XService {

	public X findXByXdm(String xdm) {
		// TODO Auto-generated method stub
		X x = new X();
		try {
			x = this.getHibernateTemplate().get(X.class, xdm);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return x;
	}

	public X findXByXmc(String xmc) {
		X x = new X();
		try {
			x = this.getHibernateTemplate().get(X.class,xmc);
		} catch (Exception e) {
			System.out.println("通过系名称查询系失败");
		}
		return x;
	}


}
