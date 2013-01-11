package com.hut.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.hut.dao.impl.BaseDaoImpl;
import com.hut.domain.Class;
import com.hut.service.ClassService;

public class ClassServiceImpl extends BaseDaoImpl implements ClassService  {

	public List<Class> getAllClasses() {
		// TODO Auto-generated method stub
		List<Class> list = new ArrayList<Class>();
		String sql = "from Class";
		try {
			list = this.getHibernateTemplate().find(sql);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public Class getClassByName(String name) {
		// TODO Auto-generated method stub
		List<Class> list = new ArrayList<Class>();
		String sql = "from Class where className = ?";
		try {
			list = this.getHibernateTemplate().find(sql, name);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(list.isEmpty())
			return null;
		else 
			return list.get(0);
	}

	public boolean addMergeClass(List<Class> list, Class c) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			this.getHibernateTemplate().deleteAll(list);
			this.addObject(c);
			flag = true;
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	public Class getClassByClassId(int classId) {
		// TODO Auto-generated method stub
		List<Class> list = new ArrayList<Class>();
		String sql = "from Class where classId = ?";
		try {
			list = this.getHibernateTemplate().find(sql, classId);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(list.isEmpty()) return null;
		else return list.get(0);
	}


}
