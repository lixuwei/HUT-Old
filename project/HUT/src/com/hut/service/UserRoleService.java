package com.hut.service;


import java.util.List;

import com.hut.dao.BaseDao;
import com.hut.domain.Ejxk;
import com.hut.domain.UserRole;
import com.hut.domain.Xslb;
import com.hut.domain.Xyzy;
import com.hut.domain.vo.EjxkAndXy;

/*
 * 用户角色表
 */
public interface UserRoleService extends BaseDao{

	/*
	 * 根据用户名查询
	 */
	public List<UserRole> findUserRoleByUserName(String username);

	/*
	 * 将RoleId写入session
	 */
	public void saveRoleIdToSession(int roleId);

	/*
	 * 从session得到RoleId
	 */
	public int getRoleIdBySession();
	
}