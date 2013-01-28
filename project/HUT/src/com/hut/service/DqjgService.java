package com.hut.service;

import com.hut.dao.BaseDao;
import com.hut.domain.Dqjg;

public interface DqjgService extends BaseDao {
	/**通过党群名称查询党群机构	*/
	Dqjg findDqjgBymc(String mc);
	
	/**通过党群机构代码查询党群机构	*/
	Dqjg findDqjgBydm(String dm);
}
