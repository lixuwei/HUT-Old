package com.hut.service;

import java.util.List;

import com.hut.dao.BaseDao;
import com.hut.domain.Role;

public interface RoleService extends BaseDao{

	public Role findRoleByRoleId(int roleId);
	//public List<String> getModule(String role);
}
