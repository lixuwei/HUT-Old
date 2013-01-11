package com.hut.domain;

import java.io.Serializable;

/*
 * 用户模块表
 */
public class RoleModule implements Serializable{

	private int roleId;
	private int moduleId;
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		// return super.hashCode();
		return (String.valueOf(this.roleId)+String.valueOf(this.moduleId)).hashCode();
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
        RoleModule roleModule = (RoleModule)obj;
        if(roleId != roleModule.roleId)
        	return false;
        if(moduleId != roleModule.moduleId)
        	return false;
        return true;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public int getModuleId() {
		return moduleId;
	}
	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}
}
