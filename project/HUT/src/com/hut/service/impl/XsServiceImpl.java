package com.hut.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.hut.dao.impl.BaseDaoImpl;
import com.hut.domain.Xs;
import com.hut.service.XsService;

public class XsServiceImpl extends BaseDaoImpl implements XsService {

	public int findStuCount(int year, String zydm) {
		// TODO Auto-generated method stub
		String sql = "select count(*) from Xs t where t.ejxkdm= '"+zydm+"' and t.nj = "+year;
		int count = 0;
		long rCount = 0;
		List<Long> list = this.getHibernateTemplate().find(sql);
		if(list.size() > 0){
			rCount = list.get(0);
		}
		count = Integer.parseInt(rCount+"");
		return count;
	}

	public Xs findXsBySfz(String Sfz) {
		// TODO Auto-generated method stub
		List<Xs> list = new ArrayList<Xs>();
		try {
			String queryString = "from Xs t where t.zjhm = ?";
			list = this.getHibernateTemplate().find(queryString, Sfz);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(list.isEmpty()) return null;
		else return list.get(0);
	}

	public Xs findXsByXh(String xh) {
		// TODO Auto-generated method stub
		List<Xs> list = new ArrayList<Xs>();
		try {
			String queryString = "from Xs t where t.xh = ?";
			list = this.getHibernateTemplate().find(queryString, xh);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(list.isEmpty()) return null;
		else return list.get(0);
	}

	/*public List<Xs> findAll(String xy, String zy, String nj) {
		List<Xs> list = new ArrayList<Xs>();
		try {
			String queryString = "from Xs t ";
			String temp1 = null;
			String temp2 = null;
			String temp3 = null;
			int flag = 0;
			if (!xy.equals("") && xy != null) {
				temp1 = "t.xydm = " + xy;
			}
			if (!xy.equals("") && xy != null) {
				temp2 = "t.ejxkdm = " + zy;
			}
			if (!xy.equals("") && xy != null) {
				temp3 = "t.nj = " + nj;
			}
			if (temp1 == null && temp2 == null && temp3 == null) {
				
			} else {
				queryString += "where ";
				if (temp1 != null && flag == 0) {
					queryString += temp1;
					flag = 1;
				}
				if (temp2 != null && flag == 0) {
					queryString += temp2;
					flag = 1;
				}
				if (temp3 != null && flag == 0) {
					queryString += temp3;
					flag = 1;
				}
				if (temp1 != null && flag == 1) {
					queryString = queryString+"and "+temp1;
					flag = 1;
				}
				if (temp2 != null && flag == 1) {
					queryString = queryString+"and "+temp2;
					flag = 1;
				}
				if (temp3 != null && flag == 1) {
					queryString = queryString+"and "+temp3;
					flag = 1;
				}
			}
			System.out.println(queryString);
			list = this.getHibernateTemplate().find(queryString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}*/


}
