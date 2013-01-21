package com.hut.service;


import java.util.List;

import com.hut.dao.BaseDao;
import com.hut.domain.Ejxk;
import com.hut.domain.RoleFunction;
import com.hut.domain.UserRole;
import com.hut.domain.Xslb;
import com.hut.domain.Xyzy;
import com.hut.domain.vo.EjxkAndXy;

/*
 * 角色功能表
 */
public interface RoleFunctionService extends BaseDao{

	/*
	 * 根据角色id查询
	 */
	public List<RoleFunction> findRoleFunctionByRoleId(int roleId);
	
}