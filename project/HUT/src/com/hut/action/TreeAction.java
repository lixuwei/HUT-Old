package com.hut.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.apache.http.HttpRequest;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.hut.domain.Ejxk;
import com.hut.domain.Function;
import com.hut.domain.Module;
import com.hut.domain.RoleFunction;
import com.hut.domain.RoleModule;
import com.hut.domain.Xy;
import com.hut.domain.Xyzy;
import com.hut.domain.vo.EjxkAndXy;
import com.hut.domain.vo.TreeNode;
import com.hut.service.EjxkService;
import com.hut.service.FunctionService;
import com.hut.service.ModuleService;
import com.hut.service.RoleFunctionService;
import com.hut.service.RoleModuleService;
import com.hut.service.UserRoleService;
import com.hut.service.XyService;
import com.hut.service.XyzyService;
import com.opensymphony.xwork2.ActionSupport;

public class TreeAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	//private String id = null;
	private List<TreeNode> items = new ArrayList<TreeNode>();
	private RoleFunctionService roleFunctionService;
	private RoleModuleService roleModuleService;
	private ModuleService moduleService;
	private FunctionService functionService;
	private UserRoleService userRoleService;
 	public String treeData() {
 		int roleId = userRoleService.getRoleIdBySession();
 		HttpServletRequest request = ServletActionContext.getRequest();
 		String idString = null;
 		idString = request.getParameter("id");
 		System.out.println("id="+idString);
 		if(idString.equals("root")) {
 		// 获得用户拥有的模块list
 	 		List<RoleModule> roleModules= roleModuleService.findRoleModuleByRoleId(roleId);
 	 		for(RoleModule roleModule : roleModules) {
 	 			Module module = moduleService.findModuleByModuleId(roleModule.getModuleId());
 	 			TreeNode treeNode = new TreeNode();
 	 			treeNode.setId("P"+module.getModuleId());
 	 			treeNode.setExpanded(false);
 	 	 		treeNode.setLeaf(false);
 	 	 		treeNode.setText(module.getModuleName());
 	 	 		treeNode.setUrl(null);
 	 	 		items.add(treeNode);
 	 		}
 		} else if(idString.contains("P")){
 		// 获得用户拥有的功能list
 			int moduleId = Integer.parseInt(idString.substring(1, idString.length()));
 	 		List<RoleFunction> roleFunctionList = roleFunctionService.findRoleFunctionByRoleId(roleId);
 	 		for(RoleFunction roleFunction : roleFunctionList) {
 	 			Function function = functionService.findFunctionByFunctionId(roleFunction.getFunctionId());
 	 			if(function.getModuleId() == moduleId) {
	 	 			TreeNode treeNode = new TreeNode();
	 	 			treeNode.setId("S"+function.getFunctionId());
	 	 			treeNode.setExpanded(true);
	 	 			treeNode.setLeaf(true);
	 	 			treeNode.setText(function.getFunctionName());
	 	 			treeNode.setUrl(function.getUrl());
	 	 			items.add(treeNode);
 	 			} else {
 	 				continue;
 	 			}
 	 		}
 		}
 		return SUCCESS;
	}
	public List<TreeNode> getItems() {
		return items;
	}
	public void setItems(List<TreeNode> items) {
		this.items = items;
	}
	@JSON(serialize=false)
	public RoleFunctionService getRoleFunctionService() {
		return roleFunctionService;
	}
	public void setRoleFunctionService(RoleFunctionService roleFunctionService) {
		this.roleFunctionService = roleFunctionService;
	}
	@JSON(serialize=false)
	public RoleModuleService getRoleModuleService() {
		return roleModuleService;
	}
	public void setRoleModuleService(RoleModuleService roleModuleService) {
		this.roleModuleService = roleModuleService;
	}
	@JSON(serialize=false)
	public ModuleService getModuleService() {
		return moduleService;
	}
	public void setModuleService(ModuleService moduleService) {
		this.moduleService = moduleService;
	}
	@JSON(serialize=false)
	public FunctionService getFunctionService() {
		return functionService;
	}
	public void setFunctionService(FunctionService functionService) {
		this.functionService = functionService;
	}
	@JSON(serialize=false)
	public UserRoleService getUserRoleService() {
		return userRoleService;
	}
	public void setUserRoleService(UserRoleService userRoleService) {
		this.userRoleService = userRoleService;
	}
}
