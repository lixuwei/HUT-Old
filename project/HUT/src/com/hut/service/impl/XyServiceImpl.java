package com.hut.service.impl;


import java.util.ArrayList;
import java.util.List;

import com.hut.dao.impl.BaseDaoImpl;
import com.hut.domain.Xy;
import com.hut.service.XyService;

public class XyServiceImpl extends BaseDaoImpl implements XyService {

	@SuppressWarnings("unchecked")
	public Xy findXyByXydm(String xydm) {
		List<Xy> list = new ArrayList<Xy>();
		try {
			String queryString = "from Xy t where t.dm = ?";
			list = this.getHibernateTemplate().find(queryString, xydm);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(list.isEmpty()) return null;
		else return list.get(0);
	}

	public boolean deleteXys(List<Xy> list) {
		// TODO Auto-generated method stub
		//this.getHibernateTemplate().deleteAll(entities)
		boolean b = false;
		try {
			this.getHibernateTemplate().deleteAll(list);
			b = true;
		} catch (Exception e) {
			e.printStackTrace();
			b = false;
		}
		return b;
	}

	public Xy findXyByXymc(String xymc) {
		List<Xy> txys = new ArrayList<Xy>();
		try {
			String query = "from Xy tx where tx.xymc=?";
			txys = this.getHibernateTemplate().find(query,xymc);
		} catch (Exception e) {
			System.out.println("查询学院代码失败");
		}
		if(txys.isEmpty())return null;
		else return txys.get(0);
	}
}
