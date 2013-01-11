package com.hut.service.impl;


import java.util.List;

import com.hut.dao.impl.BaseDaoImpl;
import com.hut.domain.Ejxk;
import com.hut.domain.Xyzy;
import com.hut.service.EjxkService;

public class EjxkServiceImpl extends BaseDaoImpl implements EjxkService {

	public Ejxk findEjxkByEjxkDm(String ejxkdm) {
		// TODO Auto-generated method stub
		Ejxk ejxk = new Ejxk();
		try {
			ejxk = this.getHibernateTemplate().get(Ejxk.class, ejxkdm);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ejxk;
	}

	public boolean addEjxk(Ejxk ejxk, Xyzy xyzy) {
		// TODO Auto-generated method stub
		try {
			System.out.println("ejxk="+ejxk);
			if(ejxk != null) 
				this.addObject(ejxk);
			this.addObject(xyzy);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean modifyEjxk(Ejxk ejxk, Xyzy xyzy) {
		// TODO Auto-generated method stub
		try {
			this.modifyObject(ejxk);
			this.modifyObject(xyzy);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deleteZys(List<Xyzy> xyzyList, List<Ejxk> ejxkList) {
		// TODO Auto-generated method stub
		//this.getHibernateTemplate().deleteAll(entities)
		boolean b = false;
		try {
			this.getHibernateTemplate().deleteAll(xyzyList);
			this.getHibernateTemplate().deleteAll(ejxkList);
			b = true;
		} catch (Exception e) {
			e.printStackTrace();
			b = false;
		}
		return b;
	}

}
