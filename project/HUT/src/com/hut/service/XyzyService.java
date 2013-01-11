package com.hut.service;


import java.util.List;

import com.hut.dao.BaseDao;
import com.hut.domain.Xyzy;

/*
 * 学院专业关系
 */
public interface XyzyService extends BaseDao{

	/*
	 * 根据学院代码查询下面所有系
	 */
	public List<Xyzy> findAllByXy(String xydm);
	
	/*
	 * 根据专业代码查询所有的学院专业
	 */
	public List<Xyzy> findByZydm(String zydm);

	/*
	 * 根据id查询学院专业
	 */
	public Xyzy findXyzyById(int id);

}