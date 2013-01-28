package com.hut.service;

import com.hut.dao.BaseDao;

public interface CreateNumberService extends BaseDao{
	/**给老师编号	*/
	String createNumber(String id,String name);
}
