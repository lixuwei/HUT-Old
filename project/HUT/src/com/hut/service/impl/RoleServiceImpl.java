package com.hut.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.hut.dao.impl.BaseDaoImpl;
import com.hut.domain.Role;
import com.hut.service.RoleService;

public class RoleServiceImpl extends BaseDaoImpl implements RoleService {

	public Role findRoleByRoleId(int roleId) {
		// TODO Auto-generated method stub
		Role role = new Role();
		try {
			role = this.getHibernateTemplate().load(Role.class, roleId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return role;
	}

	/*public List<String> getModule(String role) {
		String sql = "select t.moduleId from t_role_module t where t.roleId=?";
		List<String> list = new ArrayList<String>();
		list = this.getHibernateTemplate().find(sql,role);
		return list;
	}*/

}
