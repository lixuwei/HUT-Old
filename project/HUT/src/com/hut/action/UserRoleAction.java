package com.hut.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hslf.record.InteractiveInfo;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.hut.domain.Role;
import com.hut.domain.User;
import com.hut.domain.UserRole;
import com.hut.service.UserService;
import com.hut.service.RoleService;
import com.hut.service.UserRoleService;
import com.opensymphony.xwork2.ActionSupport;

public class UserRoleAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private String username;
	private int roleId;
	private UserRoleService userRoleService;
	private RoleService roleService;
	private List<UserRole> list;
	private List<Role> items;
	public String showRole()
	{	
		list = userRoleService.findUserRoleByUserName(username);
		items = new ArrayList<Role>();
		for(UserRole temp : list) {
			Role role = roleService.findRoleByRoleId(temp.getRoleId());
			items.add(role);
		}
		// 将roleId写入session
		userRoleService.saveRoleIdToSession(items.get(0).getRoleId());
		return SUCCESS;
	}
	
	public String writeRoleIdToSession() {
		userRoleService.saveRoleIdToSession(roleId);
		return SUCCESS;
	}
	
	public String getRoleIdFromeSession() {
		roleId = userRoleService.getRoleIdBySession();
		return SUCCESS;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	@JSON(serialize=false)
	public UserRoleService getUserRoleService() {
		return userRoleService;
	}

	public void setUserRoleService(UserRoleService userRoleService) {
		this.userRoleService = userRoleService;
	}

	public List<UserRole> getList() {
		return list;
	}

	public void setList(List<UserRole> list) {
		this.list = list;
	}

	@JSON(serialize=false)
	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	
	public List<Role> getItems() {
		return items;
	}

	public void setItems(List<Role> items) {
		this.items = items;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

}
