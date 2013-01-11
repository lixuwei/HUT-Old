package com.hut.service;

import com.hut.dao.BaseDao;
import com.hut.domain.Xl;

public interface XlService extends BaseDao {	
	/**通过学历名称查询学历	*/
	public Xl findXlByXlmc(String xlmc);
	
	/**通过学历代码查询学历	*/
	public Xl findXlByXldm(String xldm);
	
	
}
