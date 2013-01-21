package com.hut.service;


import java.util.List;

import com.hut.dao.BaseDao;
import com.hut.domain.Ejxk;
import com.hut.domain.Xyzy;

/*
 * 二级学科(专业)
 */
public interface EjxkService extends BaseDao{

	/*
	 * 根据专业代码获得专业对象
	 */
	public Ejxk findEjxkByEjxkDm(String ejxkdm);

	/*
	 * 添加专业 并且添加到学院专业关系表
	 */
	public boolean addEjxk(Ejxk ejxk, Xyzy xyzy);

	/*
	 * 修改专业 同时更新学院专业关系表
	 */
	public boolean modifyEjxk(Ejxk ejxk, Xyzy xyzy);
	
	public boolean deleteZys(List<Xyzy> xyzyList, List<Ejxk> ejxkList);
	
}