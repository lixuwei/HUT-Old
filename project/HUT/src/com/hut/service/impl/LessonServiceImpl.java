package com.hut.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.hut.dao.impl.BaseDaoImpl;
import com.hut.domain.Class;
import com.hut.domain.Lesson;
import com.hut.service.LessonService;

public class LessonServiceImpl extends BaseDaoImpl implements LessonService {

	public List<LessonService> getAllLessons() {
		// TODO Auto-generated method stub
		List<LessonService> list = new ArrayList<LessonService>();
		String sql = "select * from Lesson";
		try {
			list = this.getHibernateTemplate().find(sql);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public Lesson getLessonByName(String kcmc) {
		// TODO Auto-generated method stub
		List<Lesson> list = new ArrayList<Lesson>();
		String sql = "from Lesson where kcmc = ?";
		try {
			list = this.getHibernateTemplate().find(sql, kcmc);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(list.isEmpty()) return null;
		else 
			return list.get(0);
	}

	public List<Lesson> getLessonsByYearAndXueqi(int year, int xueqi) {
		// TODO Auto-generated method stub
		List<Lesson> list = new ArrayList<Lesson>();
		String sql = "from Lesson where year = ? and xueqi = ?";
		try {
			list = this.getHibernateTemplate().find(sql, year, xueqi);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}


}
