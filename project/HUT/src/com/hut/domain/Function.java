package com.hut.domain;

/*
 * 用户角色
 */
public class Function {

	private int functionId;
	private int moduleId;
	private String functionName;
	private String url;
	public int getFunctionId() {
		return functionId;
	}
	public void setFunctionId(int functionId) {
		this.functionId = functionId;
	}
	public int getModuleId() {
		return moduleId;
	}
	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}
	public String getFunctionName() {
		return functionName;
	}
	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
