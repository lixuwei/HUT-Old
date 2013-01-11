package com.hut.action;

import javax.jms.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.hut.domain.User;
import com.hut.service.UserService;
import com.hut.service.RoleService;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private User user;
	private boolean success;
	private UserService userService;
	private String oldPassword;
	private String newPassword;
	

	public String login()
	{	
		if(userService.Login(username, password))
		{
			User user = new User();
			user.setUserName(username);
			this.userService.saveUserToSession(user);
			return "show";
		}
		return ERROR;
	}
	
	public String getUserBySession() {
		user = userService.getUserBySession();
		return "jsonData";
	}
	
	public String modifyPassword() {
		user = userService.getUserBySession();
		if (userService.Login(user.getUserName(), oldPassword)) {
			user.setPassword(newPassword);
			userService.modifyObject(user);
			userService.clearSession();
			success = true;
//			return "login";
		} else {
			success = false;
		}
		return SUCCESS;
	}
	
	@JSON(serialize=false)
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean getSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

}
