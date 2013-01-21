package com.hut.service.impl;

import java.util.List;

import com.hut.dao.impl.BaseDaoImpl;
import com.hut.domain.Kccj;
import com.hut.service.KccjService;

public class KccjServiceImpl extends BaseDaoImpl implements KccjService {

	public List<Kccj> getKccjByXh(String xh) {
		// TODO Auto-generated method stub
		List<Kccj> list = null;
		String sql = "from Kccj where xh = ?";
		list = this.getHibernateTemplate().find(sql, xh);
		return list;
	}

}
