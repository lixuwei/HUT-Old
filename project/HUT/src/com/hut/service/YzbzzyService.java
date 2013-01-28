package com.hut.service;

import com.hut.dao.BaseDao;
import com.hut.domain.Yzbzzy;

public interface YzbzzyService extends BaseDao{
	/**通过研招库专业名称查询二级学科专业代码*/
	public Yzbzzy findZyByZymc(String zymc);
	
	/**通过研招库一级学科名称查询专业代码*/
	public Yzbzzy findZyByYjxkmc(String zymc);
	
	/**通过研招库专业代码查询二级学科码专业名称*/
	public Yzbzzy findZyByZydm(String zydm);
	
	/**通过研招库专业代码查询一级学科码专业名称*/
	public Yzbzzy findYjxkmByZydm(String zydm);

}