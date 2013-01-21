package com.hut.service;


import java.util.List;

import com.hut.dao.BaseDao;
import com.hut.domain.Dsxx;
import com.hut.domain.Ejxk;
import com.hut.domain.Xyzy;

/*
 * 学生导师
 */
public interface XsdsService extends BaseDao{

	/*
	 * 根据学生的学号查询导师1 2
	 */
	public List<Dsxx> findDsxxByXsXh(String xh);
}