package com.hut.domain;

import java.io.Serializable;

/*
 * 用户角色
 */
public class UserRole implements Serializable{

	private String username;
	private int roleId;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		// return super.hashCode();
		return (this.username+this.roleId).hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		// return super.equals(obj);
		if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserRole userRole = (UserRole) obj;
        if (username == null)
        {
            if (userRole.username != null)
                return false;
        }
        else if (!username.equals(userRole.username))
            return false;
        
        if(roleId != userRole.roleId)
        	return false;
        return true;
	}
}
