package com.hut.service;


import java.util.List;

import com.hut.dao.BaseDao;
import com.hut.domain.Ejxk;
import com.hut.domain.Pycc;
import com.hut.domain.Xyzy;

/*
 * 培养层次
 */
public interface PyccService extends BaseDao{

	/*
	 * 根据培养层次代码获得对象
	 */
	public Pycc findPyccByPyccdDm(String dm);
}