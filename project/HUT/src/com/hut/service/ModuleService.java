package com.hut.service;


import java.util.List;

import com.hut.dao.BaseDao;
import com.hut.domain.Ejxk;
import com.hut.domain.Module;
import com.hut.domain.RoleFunction;
import com.hut.domain.UserRole;
import com.hut.domain.Xslb;
import com.hut.domain.Xyzy;
import com.hut.domain.vo.EjxkAndXy;

/*
 * 模块表
 */
public interface ModuleService extends BaseDao{

	/*
	 * 根据模块id查询
	 */
	public Module findModuleByModuleId(int moduleId);


}