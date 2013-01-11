package com.hut.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.hut.dao.impl.BaseDaoImpl;
import com.hut.domain.Mz;
import com.hut.domain.User;
import com.hut.domain.Xs;
import com.hut.domain.Xslq;
import com.hut.domain.Xsxjzc;
import com.hut.domain.Xsxl;
import com.hut.domain.Xy;
import com.hut.exception.DaoException;
import com.hut.service.MzService;
import com.hut.service.XslqService;

public class MzServiceImpl extends BaseDaoImpl implements MzService{

	public Mz findMzByMzdm(String mzdm) {
		// TODO Auto-generated method stub
		List<Mz> list = new ArrayList<Mz>();
		try {
			String queryString = "from Mz t where t.dm = ?";
			list = this.getHibernateTemplate().find(queryString, mzdm);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(list.isEmpty()) return null;
		else return list.get(0);
	}

	public Mz findMzdmByMzmc(String mzmc) {
		List<Mz> mzs = new ArrayList<Mz>();
		try {
			String query = "from Mz tt where tt.mc=?";
			mzs = this.getHibernateTemplate().find(query,mzmc);
		} catch (Exception e) {
			System.out.println("查询民族代码失败");
			e.printStackTrace();
		}
		if(mzs.isEmpty()) return null;
		else return mzs.get(0);
	}
	
}
