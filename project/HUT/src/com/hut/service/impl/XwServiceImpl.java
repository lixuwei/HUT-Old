package com.hut.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.hut.dao.impl.BaseDaoImpl;
import com.hut.domain.Xs;
import com.hut.domain.Xw;
import com.hut.service.XsService;
import com.hut.service.XwService;

public class XwServiceImpl extends BaseDaoImpl implements XwService {
	public Xw findXwByXwmc(String xwmc) {
		List<Xw> txls = new ArrayList<Xw>();
		try {
			String query = "from Xw tx where tx.mc=?";
			txls = this.getHibernateTemplate().find(query,xwmc);
		} catch (Exception e) {
			System.out.println("查询学位代码失败");
		}
		if(txls.isEmpty()) return null;
		else return txls.get(0);
	}

	public Xw findXwByXwdm(String xwdm) {
		List<Xw> xls = new ArrayList<Xw>();
		try {
			String string = "from Xw t where t.dm=?";
			xls = this.getHibernateTemplate().find(string, xwdm);
		} catch (Exception e) {
			System.out.println("得到老师的学历名称失败");
		}
		if(xls.isEmpty()) return null;
		else return xls.get(0);
	}

	


}
