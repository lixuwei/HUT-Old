package com.hut.service;

import java.util.List;

import com.hut.dao.BaseDao;
import com.hut.domain.Class;
import com.hut.domain.Lesson;

public interface LessonService extends BaseDao {

	public List<LessonService> getAllLessons();
	
	public Lesson getLessonByName(String kcmc);

	// 根据年份和学期来查询
	public List<Lesson> getLessonsByYearAndXueqi(int year, int xueqi);

}
