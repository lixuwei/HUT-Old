package com.hut.service.impl;



import com.hut.dao.impl.BaseDaoImpl;
import com.hut.domain.Function;
import com.hut.service.FunctionService;

public class FunctionServiceImpl extends BaseDaoImpl implements FunctionService {

	public Function findFunctionByFunctionId(int functionId) {
		// TODO Auto-generated method stub
		Function function = new Function();
		try {
			function = this.getHibernateTemplate().get(Function.class, functionId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return function;
	}


}
