package com.hut.service;


import java.util.List;

import com.hut.dao.BaseDao;
import com.hut.domain.Dqjg;
import com.hut.domain.Shjg;
import com.hut.domain.Xy;
import com.hut.domain.Xzjg;

/*
 * 学院
 */
public interface XyService extends BaseDao{
	/**通过学院代码查询学院	*/
	public Xy findXyByXydm(String xydm);
	
	/**通过学院名称查询学院	*/
	public Xy findXyByXymc(String xymc);
	
	public boolean deleteXys(List<Xy> list);
}