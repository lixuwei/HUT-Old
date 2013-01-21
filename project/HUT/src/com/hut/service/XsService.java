package com.hut.service;

import com.hut.dao.BaseDao;
import com.hut.domain.Xs;

/*
 * 学生基础信息
 */
public interface XsService extends BaseDao{
	/*
	 * 查询**年**专业下多少人
	 */
	public int findStuCount(int year, String zydm);
	
	/*
	 * 通过身份证查询
	 */
	public Xs findXsBySfz(String Sfz);

	/*
	 * 通过学号查询
	 */
	public Xs findXsByXh(String xh);

	/*
	 * 通过学院 专业 年份查询
	 */
	/*public List<Xs> findAll(String xy,String zy, String nj);*/
}
