package com.hut.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.hut.dao.impl.BaseDaoImpl;
import com.hut.domain.Dqjg;
import com.hut.service.DqjgService;

public class DqjgServiceImpl extends BaseDaoImpl implements DqjgService {

	public Dqjg findDqjgBymc(String mc){
		List<Dqjg>  dqjgs = new ArrayList<Dqjg>();
		String query= "";
		try {
			query = "from Dqjg t where t.mc=?";
			dqjgs = this.getHibernateTemplate().find(query,mc);
		} catch (Exception e) {
			System.out.println("查询党群机构失败");
		}
		if(dqjgs.isEmpty()) return  null;
		else  return dqjgs.get(0);
	}

	public Dqjg findDqjgBydm(String dm) {
		List<Dqjg>  dqjgs = new ArrayList<Dqjg>();
		String query= "";
		try {
			query = "from Dqjg t where t.dm=?";
			dqjgs = this.getHibernateTemplate().find(query,dm);
		} catch (Exception e) {
			System.out.println("查询党群机构失败");
		}
		if(dqjgs.isEmpty()) return  null;
		else  return dqjgs.get(0);
	}
}
