package com.hut.service.impl;



import java.util.ArrayList;
import java.util.List;

import com.hut.dao.impl.BaseDaoImpl;
import com.hut.domain.Function;
import com.hut.domain.FunctionAction;
import com.hut.domain.RoleFunction;
import com.hut.service.FunctionActionService;
import com.hut.service.FunctionService;

public class FunctionActionServiceImpl extends BaseDaoImpl implements FunctionActionService {

	public List<FunctionAction> findFunctionActionsByFunctionId(int functionId) {
		// TODO Auto-generated method stub
		List<FunctionAction> list = new ArrayList<FunctionAction>();
		try {
			String sql = "from FunctionAction t where t.functionId = ?";
			list = this.getHibernateTemplate().find(sql,functionId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}


}
