package com.hut.Interceptor;

import java.util.List;
import java.util.Map;

import com.hut.domain.Function;
import com.hut.domain.FunctionAction;
import com.hut.domain.RoleFunction;
import com.hut.domain.User;
import com.hut.service.FunctionActionService;
import com.hut.service.FunctionService;
import com.hut.service.RoleFunctionService;
import com.hut.service.impl.FunctionActionServiceImpl;
import com.hut.service.impl.FunctionServiceImpl;
import com.hut.service.impl.RoleFunctionServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuthorityInterceptor extends AbstractInterceptor {

	private RoleFunctionService roleFunctionService;
	private FunctionService functionService;
	private FunctionActionService functionActionService;
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		ActionContext ctx=invocation.getInvocationContext();  
	    Map session=ctx.getSession();
	    // 取出名为user的session属性
	    User user = (User)session.get("user");
	    if(user == null) {
	    	return "login";  
	    } else {
	    	// 取出名为RoleId的session属性
	    	int roleId = (Integer) session.get("roleId");
	    	// 根据roleId查询是否拥有这个action的访问权限
	    	List<RoleFunction> roleFunctionList = roleFunctionService.findRoleFunctionByRoleId(roleId);
	    	for(RoleFunction roleFunction : roleFunctionList) {
	    		Function function = functionService.findFunctionByFunctionId(roleFunction.getFunctionId());
	    		List<FunctionAction> functionActionList= functionActionService.findFunctionActionsByFunctionId(function.getFunctionId());
	    		for(FunctionAction functionAction : functionActionList) {
	    			(invocation.getProxy().getActionName()+"!"+invocation.getProxy().getMethod()).contains(functionAction.getAction());
	    			return invocation.invoke();
	    		}
	    	}
	    	return "noAuthority";
	    }
	}
	public RoleFunctionService getRoleFunctionService() {
		return roleFunctionService;
	}
	public void setRoleFunctionService(RoleFunctionService roleFunctionService) {
		this.roleFunctionService = roleFunctionService;
	}
	public FunctionService getFunctionService() {
		return functionService;
	}
	public void setFunctionService(FunctionService functionService) {
		this.functionService = functionService;
	}
	public FunctionActionService getFunctionActionService() {
		return functionActionService;
	}
	public void setFunctionActionService(FunctionActionService functionActionService) {
		this.functionActionService = functionActionService;
	}

}
