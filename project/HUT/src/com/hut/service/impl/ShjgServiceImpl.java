package com.hut.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.hut.dao.impl.BaseDaoImpl;
import com.hut.domain.Shjg;
import com.hut.service.ShjgService;

public class ShjgServiceImpl extends BaseDaoImpl implements ShjgService {

	public Shjg findShjgBymc(String mc){
		List<Shjg>  shjgs = new ArrayList<Shjg>();
		String query= "";
		try {
			query = "from Shjg t where t.mc=?";
			shjgs = this.getHibernateTemplate().find(query,mc);
		} catch (Exception e) {
			System.out.println("查询社会机构失败");
		}
		if(shjgs.isEmpty()) return  null;
		else  return shjgs.get(0);
	}

	public Shjg findShjgBydm(String dm) {
		List<Shjg>  shjgs = new ArrayList<Shjg>();
		String query= "";
		try {
			query = "from Shjg t where t.dm=?";
			shjgs = this.getHibernateTemplate().find(query,dm);
		} catch (Exception e) {
			System.out.println("查询社会机构失败");
		}
		if(shjgs.isEmpty()) return  null;
		else  return shjgs.get(0);
	}
}
