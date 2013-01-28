package com.hut.service;

import com.hut.dao.BaseDao;
import com.hut.domain.Xzjg;

public interface XzjgService extends BaseDao {
	
	/**通过行政名称查询行政机构	*/
	Xzjg findXzjgBymc(String mc);
	
	/**通过行政代码查询行政机构	*/
	Xzjg findXzjgBydm(String dm);
}
