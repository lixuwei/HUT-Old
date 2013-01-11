package com.hut.service.impl;


import java.util.ArrayList;
import java.util.List;

import com.hut.dao.impl.BaseDaoImpl;
import com.hut.domain.Dsxx;
import com.hut.domain.Ejxk;
import com.hut.domain.Xs;
import com.hut.domain.Xyzy;
import com.hut.service.DsxxService;
import com.hut.service.EjxkService;
import com.hut.service.XsdsService;

public class XsdsServiceImpl extends BaseDaoImpl implements XsdsService {

	public List<Dsxx> findDsxxByXsXh(String xh) {
		// TODO Auto-generated method stub
		List<Dsxx> list = new ArrayList<Dsxx>();
		try {
			String queryString = "from Dsxx t where t.xh = ?";
			list = this.getHibernateTemplate().find(queryString, xh);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
