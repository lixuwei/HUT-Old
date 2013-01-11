package com.hut.service;


/*
 * 民族
 */
import java.util.List;

import com.hut.dao.BaseDao;
import com.hut.domain.Mz;
import com.hut.domain.Xy;

public interface MzService extends BaseDao{
	/**通过名族代码查询名族	*/
	public Mz findMzByMzdm(String mzdm);
	
	/**通过名族名称查名族* */
	public Mz findMzdmByMzmc(String mzmc);
	
}