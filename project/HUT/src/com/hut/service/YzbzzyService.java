package com.hut.service;

import com.hut.dao.BaseDao;
import com.hut.domain.Yzbzzy;

public interface YzbzzyService extends BaseDao{
	/**通过研招库专业名称查询专业*/
	public Yzbzzy findZyByZymc(String zymc);
	
	/**通过研招库专业代码查询专业*/
	public Yzbzzy findZyByZydm(String zydm);
	
	/**通过导师**学科代码查询专业*/
	public Yzbzzy findDexkyjxkByZydm(String zydm);
}