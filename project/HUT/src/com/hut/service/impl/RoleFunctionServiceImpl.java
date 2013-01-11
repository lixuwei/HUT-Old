package com.hut.service.impl;


import java.util.ArrayList;
import java.util.List;

import com.hut.dao.impl.BaseDaoImpl;
import com.hut.domain.RoleFunction;
import com.hut.service.RoleFunctionService;

public class RoleFunctionServiceImpl extends BaseDaoImpl implements RoleFunctionService {

	public List<RoleFunction> findRoleFunctionByRoleId(int roleId) {
		// TODO Auto-generated method stub
		List<RoleFunction> list = new ArrayList<RoleFunction>();
		try {
			String sql = "from RoleFunction t where t.roleId = ?";
			list = this.getHibernateTemplate().find(sql, roleId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
