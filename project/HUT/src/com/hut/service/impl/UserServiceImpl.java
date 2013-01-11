package com.hut.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.hut.dao.impl.BaseDaoImpl;
import com.hut.domain.User;
import com.hut.service.UserService;
public class UserServiceImpl extends BaseDaoImpl implements UserService  {

	public boolean Login(String username, String password) {
		// TODO Auto-generated method 
		String sql = "select t.password from User t where t.userName = ?";
		List<String> list = new ArrayList<String>();
		list = this.getHibernateTemplate().find(sql,username);
		for(String tempPassword:list)
		{
			if(tempPassword.endsWith(password)) return true;
		}
		return false;
	}
	
	public void saveUserToSession(User user) {
		HttpServletRequest request= ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		session.setAttribute("user", user);
	}
	public User getUserBySession() {
		User user = new User();
		HttpServletRequest request= ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		user = (User)session.getAttribute("user");
		return user;
	}

	public void clearSession() {
		HttpServletRequest request= ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		session.invalidate();
	}

	public User findUserByLsbh(String lsbh) {
		List<User> user = new ArrayList<User>();
		try{
			String query = "from User t where t.userName=?";
			user = this.getHibernateTemplate().find(query,lsbh);
		}catch (Exception e) {
			System.out.println("通过老师编号查询用户名失败");
		}
		if(user.isEmpty()) return null;
		else return user.get(0);
	}

	public void addDataToUser(User user) {
		try {
			this.getHibernateTemplate().save(user);
		} catch (Exception e) {
			System.out.println("出现重复值,插入失败!");
		}
	}

	public void modifyUser(User user) {
		try {
			this.getHibernateTemplate().merge(user);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("更新用户数据失败");
		}
	}
	
}
