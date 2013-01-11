package com.hut.service.impl;


import java.util.ArrayList;
import java.util.List;

import com.hut.dao.impl.BaseDaoImpl;
import com.hut.domain.Dsxx;
import com.hut.domain.Teacher;
import com.hut.service.DsxxService;


public class DsxxServiceImpl extends BaseDaoImpl implements DsxxService {

	public List<Object[]> getDSBySql(List<String> list){
		List<Object[]> listTeachers = new ArrayList<Object[]>();
		String sql = "select";
		try {
			for(int i= 0;i<list.size();i++){
				if(i==(list.size()-1))
					sql= sql +" "+list.get(i);
				else
					sql= sql +" "+list.get(i)+",";
			}
			sql =sql+" from Dsxx";
			System.out.println(sql);
			listTeachers = this.getHibernateTemplate().find(sql);
		} catch (Exception e) {
			System.out.println(sql);
			System.out.println("查询导师表的部分字段失败");
		}
		return listTeachers;
	} 
	
	
	public  List<Dsxx> findDsxxByXsXh(String xh) {
		// TODO Auto-generated method stub
		List<Dsxx> list = new ArrayList<Dsxx>();
		try {
			String sql = "from Dsxx t where t.xh = ?";
			list = this.getHibernateTemplate().find(sql,xh);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void addDsData(Dsxx dsxx) {
		try {
			this.getHibernateTemplate().save(dsxx);
		} catch (Exception e) {
			System.out.println("插入导师数据失败");
		}
	}

	public Dsxx findDsxxByLsbh(String lsbh) {
		
		return null;
	}

	public List<Dsxx> getAllDS() {
		List<Dsxx> list = new ArrayList<Dsxx>();
		try {
			String queryString = "from Dsxx";
			list = this.getHibernateTemplate().find(queryString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public Dsxx findDSByLsbh(String lsbh) {
		List<Dsxx> dsxxs = new  ArrayList<Dsxx>();
		try {
			String query = "from Dsxx t where t.lsbh=?";
			dsxxs = this.getHibernateTemplate().find(query, lsbh);
		} catch (Exception e) {
			System.out.println("通过导师的编号查询导师");
		}
		if(dsxxs.isEmpty())return null;
		else return dsxxs.get(0);
	}

	public void modifyDs(Dsxx tDsxx) {
		try {
			this.getHibernateTemplate().merge(tDsxx);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("更新导师数据失败");
		}
	}

	public String getDSName(String name) {
		List<Teacher> teachers = new ArrayList<Teacher>();
		try {
			String query = "from Teacher t where t.lsbh=?";
			teachers = this.getHibernateTemplate().find(query,name);
		} catch (Exception e) {
			System.out.println("查询老师姓名失败");
		}
		if(teachers.isEmpty()) return null;
		else return teachers.get(0).getXm();
	}


	
}
