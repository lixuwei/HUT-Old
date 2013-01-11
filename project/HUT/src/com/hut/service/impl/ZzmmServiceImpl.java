package com.hut.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.hut.dao.impl.BaseDaoImpl;
import com.hut.domain.Zzmm;
import com.hut.service.ZzmmService;

public class ZzmmServiceImpl extends BaseDaoImpl implements ZzmmService {

	public Zzmm findZzmmdmByMc(String zzmmmc) {
		List<Zzmm> zzmms = new ArrayList<Zzmm>();
		try {
			String query = "from Zzmm tz where tz.mc=?";
			zzmms = this.getHibernateTemplate().find(query,zzmmmc);
		} catch (Exception e) {
			System.out.println("查询政治身份代码失败");
		}
		if(zzmms.isEmpty()) return null;
		else return zzmms.get(0);
	}

	public Zzmm findZzmmdmByDm(String zzmmdm) {
		List<Zzmm> zzmms = new ArrayList<Zzmm>();
		try {
			String  query = "from Zzmm t where t.dm=?";
			zzmms = this.getHibernateTemplate().find(query,zzmmdm); 
		} catch (Exception e) {
			System.out.println("查询政治身份名称失败");
		}
		if(zzmms.isEmpty()) return null;
		else return zzmms.get(0);
	}

}
