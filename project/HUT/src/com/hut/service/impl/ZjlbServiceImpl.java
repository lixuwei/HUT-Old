package com.hut.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.hut.dao.impl.BaseDaoImpl;
import com.hut.domain.Zjlb;
import com.hut.service.ZjlbService;

public class ZjlbServiceImpl extends BaseDaoImpl implements ZjlbService {

	public Zjlb findZjlbBymc(String zjlbmc) {
		List<Zjlb> zjlbs =new ArrayList<Zjlb>();
		try {
			String query = "from Zjlb t where t.mc=?";
			zjlbs = this.getHibernateTemplate().find(query, zjlbmc);
		} catch (Exception e) {
			System.out.println("查询专家类别代码失败");
		}
		if(zjlbs.isEmpty())return null;
		else  return zjlbs.get(0);
	}

	public Zjlb findZjlbBydm(String zjlbdm) {
		List<Zjlb> zjlbs = new ArrayList<Zjlb>();
		try {
			String  query = "from Zjlb t where t.dm=?";
			zjlbs = this.getHibernateTemplate().find(query, zjlbdm);
		} catch (Exception e) {
			System.out.println("查询专家类型名称失败");
		}
		if(zjlbs.isEmpty()) return null;
		else return zjlbs.get(0);
	}

}
