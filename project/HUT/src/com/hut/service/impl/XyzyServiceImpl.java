package com.hut.service.impl;


import java.util.ArrayList;
import java.util.List;

import com.hut.dao.impl.BaseDaoImpl;
import com.hut.domain.Xyzy;
import com.hut.service.XyzyService;

public class XyzyServiceImpl extends BaseDaoImpl implements XyzyService {

	public List<Xyzy> findAllByXy(String xydm) {
		// TODO Auto-generated method stub
		String queryString = "from Xyzy t";
		List<Xyzy> list  = new ArrayList<Xyzy>();
		if(xydm != null) {
			queryString += " where t.xydm = " + xydm;
		}
		list = this.getHibernateTemplate().find(queryString);
		return list;
	}

	public List<Xyzy> findByZydm(String zydm) {
		// TODO Auto-generated method stub
		String queryString = "from Xyzy t";
		List<Xyzy> list  = new ArrayList<Xyzy>();
		if(zydm != null) {
			queryString += " where t.zydm = " + zydm;
		}
		list = this.getHibernateTemplate().find(queryString);
		return list;
	}

	public Xyzy findXyzyById(int id) {
		Xyzy xyzy = new Xyzy();
		try {
			xyzy = this.getHibernateTemplate().load(Xyzy.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return xyzy;
	}
	
	/*public Xyzy findByXyAndZydm(String xydm, String zydm) {
		// TODO Auto-generated method stub
		List<Xyzy> list = new ArrayList<Xyzy>();
		try {
			String queryString = "from Xyzy t where t.xydm = ? and t.zydm = ?";
			list = this.getHibernateTemplate().find(queryString, xydm, zydm);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(list.isEmpty()) return null;
		else return list.get(0);
	}*/

}
