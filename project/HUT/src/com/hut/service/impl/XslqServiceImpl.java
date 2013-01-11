package com.hut.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.hut.dao.impl.BaseDaoImpl;
import com.hut.domain.User;
import com.hut.domain.UserRole;
import com.hut.domain.Xs;
import com.hut.domain.Xslq;
import com.hut.domain.Xsxjzc;
import com.hut.domain.Xsxl;
import com.hut.exception.DaoException;
import com.hut.service.XslqService;

public class XslqServiceImpl extends BaseDaoImpl implements XslqService {
	
	public void addXslq(Xslq xslq) {
		try {
			this.getHibernateTemplate().save(xslq);
		} catch (Exception e) {
			System.out.println("出现重复值,插入失败!");
		}
	}

	public List<Xslq> getAllXslq() {
		// TODO Auto-generated method stub
		List<Xslq> list = new ArrayList<Xslq>();
		try {
			String queryString = "from Xslq t order by t.id desc";
			list = this.getHibernateTemplate().find(queryString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Xslq> getNoXhList() {
		// TODO Auto-generated method stub
		List<Xslq> list = new ArrayList<Xslq>();
		try {
			String queryString = "from Xslq t where t.flag = 0";
			list = this.getHibernateTemplate().find(queryString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void modifyXslq(Xslq xslq) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().merge(xslq);
	}

	public Xslq findXslqBySfz(String Sfz) {
		// TODO Auto-generated method stub
		List<Xslq> list = new ArrayList<Xslq>();
		try {
			String queryString = "from Xslq t where t.zjhm = ?";
			list = this.getHibernateTemplate().find(queryString, Sfz);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(list.isEmpty()) return null;
		else return list.get(0);
	}

	public boolean addToOtherTable(User user, UserRole userRole, Xs xs, Xsxjzc xsxjzc, Xsxl xsxl) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().save(user);
			this.getHibernateTemplate().save(xs);
			this.getHibernateTemplate().save(userRole);
			this.getHibernateTemplate().save(xsxjzc);
			this.getHibernateTemplate().save(xsxl);
			return true;
		} catch (Exception e) {
			throw new DaoException();
		}
	}

}
