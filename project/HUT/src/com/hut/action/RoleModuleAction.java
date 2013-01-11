package com.hut.action;

import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import com.hut.domain.RoleFunction;
import com.hut.domain.RoleModule;
import com.hut.service.RoleFunctionService;
import com.hut.service.RoleModuleService;
import com.opensymphony.xwork2.ActionSupport;

public class RoleModuleAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	private int roleId;
	private RoleModuleService roleModuleService;
	private List<RoleModule> list;
	
	public String verify()
	{	
		list = roleModuleService.findRoleModuleByRoleId(roleId);
		return SUCCESS;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	@JSON(serialize=false)
	public RoleModuleService getRoleModuleService() {
		return roleModuleService;
	}

	public void setRoleModuleService(RoleModuleService roleModuleService) {
		this.roleModuleService = roleModuleService;
	}

	public List<RoleModule> getList() {
		return list;
	}

	public void setList(List<RoleModule> list) {
		this.list = list;
	}


}
