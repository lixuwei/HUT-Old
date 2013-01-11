package com.hut.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.hut.domain.Ejxk;
import com.hut.domain.Role;
import com.hut.domain.User;
import com.hut.domain.UserRole;
import com.hut.service.UserService;
import com.hut.service.RoleService;
import com.hut.service.UserRoleService;
import com.opensymphony.xwork2.ActionSupport;

public class RoleAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	private int roleId;
	private List<Object> items = null;
	private RoleService roleService;
	
	public String showAll()
	{	
		items = roleService.findAllObject(new Role());
		return SUCCESS;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public List<Object> getItems() {
		return items;
	}

	public void setItems(List<Object> items) {
		this.items = items;
	}

	@JSON(serialize=false)
	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}



}
