package com.hut.service;


import java.util.List;

import com.hut.dao.BaseDao;
import com.hut.domain.Class;
import com.hut.domain.Ejxk;
import com.hut.domain.Xyzy;

/*
 * 班级
 */
public interface ClassService extends BaseDao{

	// 查询所有的班级
	public List<Class> getAllClasses();
	
	//根据班级名称得到班级对象
	public Class getClassByName(String name);
	
	// 合班操作
	public boolean addMergeClass(List<Class> list, Class c);

	// 根据班级id得到班级对象
	public Class getClassByClassId(int classId);
	
}