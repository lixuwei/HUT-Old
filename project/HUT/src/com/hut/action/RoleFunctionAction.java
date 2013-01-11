package com.hut.action;

import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import com.hut.domain.RoleFunction;
import com.hut.service.RoleFunctionService;
import com.opensymphony.xwork2.ActionSupport;

public class RoleFunctionAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	private int roleId;
	private RoleFunctionService roleFunctionService;
	private List<RoleFunction> list;
	
	public String verify()
	{	
		list = roleFunctionService.findRoleFunctionByRoleId(roleId);
		return SUCCESS;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	@JSON(serialize=false)
	public RoleFunctionService getRoleFunctionService() {
		return roleFunctionService;
	}

	public void setRoleFunctionService(RoleFunctionService roleFunctionService) {
		this.roleFunctionService = roleFunctionService;
	}

	public List<RoleFunction> getList() {
		return list;
	}

	public void setList(List<RoleFunction> list) {
		this.list = list;
	}



}
