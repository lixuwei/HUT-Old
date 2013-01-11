package com.hut.service.impl;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.hut.dao.impl.BaseDaoImpl;
import com.hut.domain.Ejxk;
import com.hut.domain.UserRole;
import com.hut.domain.Xslb;
import com.hut.domain.Xyzy;
import com.hut.domain.vo.EjxkAndXy;
import com.hut.service.EjxkService;
import com.hut.service.UserRoleService;
import com.hut.service.XslbService;

public class UserRoleServiceImpl extends BaseDaoImpl implements UserRoleService {

	public List<UserRole> findUserRoleByUserName(String username) {
		// TODO Auto-generated method stub
		List<UserRole> list = new ArrayList<UserRole>();
		try {
			String sql = "from UserRole t where t.username = ?";
			list = this.getHibernateTemplate().find(sql,username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void saveRoleIdToSession(int roleId) {
		// TODO Auto-generated method stub
		HttpServletRequest request= ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		session.setAttribute("roleId",roleId);
		System.out.println("写入roleId为"+roleId);
	}

	public int getRoleIdBySession() {
		// TODO Auto-generated method stub
		//Integer obj = new Object();
		int roleId;
		System.out.println("调用读取roleId的方法");
		HttpServletRequest request= ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		roleId = ((Integer)session.getAttribute("roleId")).intValue();
		System.out.println("读取roleId为"+roleId);
		return roleId;
	}

}
