package com.hut.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.hut.dao.impl.BaseDaoImpl;
import com.hut.domain.Xzjg;
import com.hut.service.XzjgService;

public class XzjgServiceImpl extends BaseDaoImpl implements XzjgService {
	
	public Xzjg findXzjgBymc(String mc){
		List<Xzjg> xzjgs = new ArrayList<Xzjg>();
		String query= "";
		try {
			query = "from Xzjg t where t.mc=?";
			xzjgs = this.getHibernateTemplate().find(query,mc);
		} catch (Exception e) {
			System.out.println("查询行政机构失败");
		}
		if(xzjgs.isEmpty()) return  null;
		else  return xzjgs.get(0);
	}

	public Xzjg findXzjgBydm(String dm) {
		List<Xzjg> xzjgs = new ArrayList<Xzjg>();
		String query= "";
		try {
			query = "from Xzjg t where t.dm=?";
			xzjgs = this.getHibernateTemplate().find(query,dm);
		} catch (Exception e) {
			System.out.println("查询行政机构失败");
		}
		if(xzjgs.isEmpty()) return  null;
		else  return xzjgs.get(0);
	}
}
