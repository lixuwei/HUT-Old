package com.hut.service;


import java.util.List;

import com.hut.dao.BaseDao;
import com.hut.domain.Ejxk;
import com.hut.domain.X;
import com.hut.domain.Xw;
import com.hut.domain.Xyzy;


public interface XwService extends BaseDao{
	/**通过学位名称查询学位	*/
	public Xw findXwByXwmc(String xwmc);
	
	/**通过学位代码查询学位	*/
	public Xw findXwByXwdm(String xwdm);
}