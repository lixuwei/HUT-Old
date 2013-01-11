package com.hut.service;


import java.util.List;

import com.hut.dao.BaseDao;
import com.hut.domain.Ejxk;
import com.hut.domain.Function;
import com.hut.domain.FunctionAction;
import com.hut.domain.RoleFunction;
import com.hut.domain.UserRole;
import com.hut.domain.Xslb;
import com.hut.domain.Xyzy;
import com.hut.domain.vo.EjxkAndXy;

/*
 * 功能action表
 */
public interface FunctionActionService extends BaseDao{

	/*
	 * 根据functionId查询
	 */
	public List<FunctionAction> findFunctionActionsByFunctionId(int functionId);



}