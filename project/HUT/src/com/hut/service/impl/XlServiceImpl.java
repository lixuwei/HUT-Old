package com.hut.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.hut.dao.impl.BaseDaoImpl;
import com.hut.domain.Xl;
import com.hut.service.XlService;

public class XlServiceImpl extends BaseDaoImpl implements XlService {

	public Xl findXlByXlmc(String xlmc) {
		List<Xl> txls = new ArrayList<Xl>();
		try {
			String query = "from Xl  tx where tx.cm=?";
			txls = this.getHibernateTemplate().find(query,xlmc);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("查询学历代码失败");
		}
		if(txls.isEmpty()) return  null;
		else   return txls.get(0);		
	}

	public Xl findXlByXldm(String xldm) {
		List<Xl> xls = new ArrayList<Xl>();
		try {
			String string = "from Xl t where t.dm=?";
			xls = this.getHibernateTemplate().find(string, xldm);
		} catch (Exception e) {
			System.out.println("得到老师的学历名称失败");
		}
		if(xls.isEmpty()) return null;
		else return xls.get(0);
	}

}
