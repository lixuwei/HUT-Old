package com.hut.service;


import java.util.List;

import com.hut.dao.BaseDao;
import com.hut.domain.Ejxk;
import com.hut.domain.X;
import com.hut.domain.Xyzy;

/*
 * 系
 */
public interface XService extends BaseDao{

	/*
	 * 根据系代码查询
	 */
	public X findXByXdm(String xdm);
	
	/**通过系名称查询系	*/
	public X findXByXmc(String xmc);
}