package com.hut.domain;

import java.io.Serializable;

/*
 * 功能action表
 */
public class FunctionAction implements Serializable{

	private String action;
	private int functionId;
	
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public int getFunctionId() {
		return functionId;
	}
	public void setFunctionId(int functionId) {
		this.functionId = functionId;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		// return super.hashCode();
		return (this.functionId+this.action).hashCode();
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
        FunctionAction functionAction = (FunctionAction) obj;
        if (action == null)
        {
            if (functionAction.action != null)
                return false;
        }
        else if (!action.equals(functionAction.action))
            return false;
        
        if(functionId != functionAction.functionId)
        	return false;
        return true;
	}
}
