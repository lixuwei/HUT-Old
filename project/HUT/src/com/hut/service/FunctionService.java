package com.hut.service;


import java.util.List;

import com.hut.dao.BaseDao;
import com.hut.domain.Ejxk;
import com.hut.domain.Function;
import com.hut.domain.RoleFunction;
import com.hut.domain.UserRole;
import com.hut.domain.Xslb;
import com.hut.domain.Xyzy;
import com.hut.domain.vo.EjxkAndXy;

/*
 * 功能表
 */
public interface FunctionService extends BaseDao{

	/*
	 * 根据功能id查询
	 */
	public Function findFunctionByFunctionId(int functionId);


}