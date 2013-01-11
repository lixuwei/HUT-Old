package com.hut.service.impl;


import java.util.List;

import com.hut.dao.impl.BaseDaoImpl;
import com.hut.domain.Ejxk;
import com.hut.domain.Pycc;
import com.hut.domain.Xyzy;
import com.hut.service.EjxkService;
import com.hut.service.PyccService;

public class PyccServiceImpl extends BaseDaoImpl implements PyccService {

	public Pycc findPyccByPyccdDm(String dm) {
		// TODO Auto-generated method stub
		Pycc pycc = new Pycc();
		try {
			pycc = this.getHibernateTemplate().get(Pycc.class, dm);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pycc;
	}

}
