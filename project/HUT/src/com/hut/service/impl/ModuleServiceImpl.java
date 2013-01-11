package com.hut.service.impl;


import java.util.ArrayList;
import java.util.List;

import com.hut.dao.impl.BaseDaoImpl;
import com.hut.domain.Function;
import com.hut.domain.Module;
import com.hut.domain.RoleFunction;
import com.hut.service.ModuleService;
import com.hut.service.RoleFunctionService;

public class ModuleServiceImpl extends BaseDaoImpl implements ModuleService {

	public Module findModuleByModuleId(int moduleId) {
		// TODO Auto-generated method stub
		Module module = new Module();
		try {
			module = this.getHibernateTemplate().get(Module.class, moduleId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return module;
	}


}
