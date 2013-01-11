package com.hut.service;

import com.hut.dao.BaseDao;
import com.hut.domain.Xx;

public interface XxService extends BaseDao{
	/**通过学校名称查询学校*/
	public Xx findXxByXxmc(String xxmc); 
	
	/**通过学校名称查询学校*/
	public Xx findXxByXxdm(String xxdm); 
}
