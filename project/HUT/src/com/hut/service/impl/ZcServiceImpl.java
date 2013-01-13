package com.hut.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.hut.dao.impl.BaseDaoImpl;
import com.hut.domain.Zc;
import com.hut.domain.Zzmm;
import com.hut.service.ZcService;
import com.hut.service.ZzmmService;

public class ZcServiceImpl extends BaseDaoImpl implements ZcService {

	public Zc findZcByZcmc(String zcmc) {
		List<Zc> txls = new ArrayList<Zc>();
		try {
			String query = "from Zc tx where tx.mc=?";
			txls = this.getHibernateTemplate().find(query,zcmc);
		} catch (Exception e) {
			System.out.println("查询职称代码失败");
		}
		if(txls.isEmpty()) return  null;
		else return txls.get(0);
	}

	public Zc findZcByZcdm(String zcdm) {
		List<Zc> xls = new ArrayList<Zc>();
		try {
			String string = "from Zc t where t.dm=?";
			xls = this.getHibernateTemplate().find(string, zcdm);
		} catch (Exception e) {
			System.out.println("得到老师的学历名称失败");
		}
		if(xls.isEmpty()) return null;
		else return xls.get(0);
	}


}
