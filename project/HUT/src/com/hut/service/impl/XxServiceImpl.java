package com.hut.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.hut.dao.impl.BaseDaoImpl;
import com.hut.domain.Xx;
import com.hut.service.XxService;

public class XxServiceImpl extends BaseDaoImpl implements XxService {

	public Xx findXxByXxmc(String xxmc) {
		List<Xx> txxs = new ArrayList<Xx>();
		try {
			String query = "from Xx  tx where tx.mc=?";
			txxs = this.getHibernateTemplate().find(query,xxmc);
		} catch (Exception e) {
			System.out.println("查询毕业学校的代码失败");
		}
		if(txxs.isEmpty())return null;
		else return txxs.get(0);
	}

	public Xx findXxByXxdm(String xxdm) {
		List<Xx> xxs = new ArrayList<Xx>();
		try {
			String string = "from Xx t where t.dm=?";
			xxs = this.getHibernateTemplate().find(string,xxdm);
		} catch (Exception e) {
			System.out.println("得到老师毕业学校名称失败");
		}
		if(xxs.isEmpty()) return null;
		else return xxs.get(0);
	}

}
