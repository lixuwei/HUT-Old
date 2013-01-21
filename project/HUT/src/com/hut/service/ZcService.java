package com.hut.service;

import com.hut.dao.BaseDao;
import com.hut.domain.Zc;

public interface ZcService extends BaseDao{
	/**通过职称名称职称	*/
	public Zc findZcByZcmc(String zcmc);
	
	/**通过职称代码职称	*/
	public Zc findZcByZcdm(String zcdm);
}