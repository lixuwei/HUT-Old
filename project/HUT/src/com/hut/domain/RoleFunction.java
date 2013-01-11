package com.hut.domain;

import java.io.Serializable;

/*
 * 用户功能表
 */
public class RoleFunction implements Serializable{

	private int roleId;
	private int functionId;
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		// return super.hashCode();
		return (String.valueOf(this.roleId)+String.valueOf(this.functionId)).hashCode();
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
        RoleFunction roleFunction = (RoleFunction)obj;
        if(roleId != roleFunction.roleId)
        	return false;
        if(functionId != roleFunction.functionId)
        	return false;
        return true;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public int getFunctionId() {
		return functionId;
	}
	public void setFunctionId(int functionId) {
		this.functionId = functionId;
	}
}
