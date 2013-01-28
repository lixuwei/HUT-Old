package com.hut.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.hut.dao.impl.BaseDaoImpl;
import com.hut.domain.Yjdw;
import com.hut.service.YjdwService;

public class YjdwServiceImpl extends BaseDaoImpl implements YjdwService {

	public Yjdw findYjdwBymc(String mc) {
		List<Yjdw>  yjdws = new ArrayList<Yjdw>();
		try {
			String query = "from Yjdw t where t.dwmc=?";
			yjdws = this.getHibernateTemplate().find(query, mc);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("根据一级单位名称查询一级单位失败");
		}
		if(yjdws.isEmpty()) return null;
		else  return yjdws.get(0);
	}

	public Yjdw findYjdwBydm(String dwdm) {
		List<Yjdw>  yjdws = new ArrayList<Yjdw>();
		try {
			String query = "from Yjdw t where t.dwdm=?";
			yjdws = this.getHibernateTemplate().find(query, dwdm);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("根据一级单位代码查询一级单位失败");
		}
		if(yjdws.isEmpty()) return null;
		else  return yjdws.get(0);
	}

}
