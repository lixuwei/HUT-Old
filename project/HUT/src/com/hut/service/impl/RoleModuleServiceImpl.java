package com.hut.service.impl;


import java.util.ArrayList;
import java.util.List;

import com.hut.dao.impl.BaseDaoImpl;
import com.hut.domain.RoleModule;
import com.hut.service.RoleModuleService;

public class RoleModuleServiceImpl extends BaseDaoImpl implements RoleModuleService {

	public List<RoleModule> findRoleModuleByRoleId(int roleId) {
		// TODO Auto-generated method stub
		List<RoleModule> list = new ArrayList<RoleModule>();
		try {
			String sql = "from RoleModule t where t.roleId = ?";
			list = this.getHibernateTemplate().find(sql,roleId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
