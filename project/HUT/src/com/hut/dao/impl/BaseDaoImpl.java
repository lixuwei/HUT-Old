package com.hut.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hut.dao.BaseDao;
import com.hut.domain.Ejxk;

public class BaseDaoImpl extends HibernateDaoSupport implements BaseDao{
	
	/**
	 * 添加对象
	 */
	public boolean addObject(Object object) {
		try {
			this.getHibernateTemplate().save(object);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 功能：得到类的名称，供查询语句使用
	 * @param object 对象
	 */
	public String getObjectName(Object object) {
		if(object != null){
			String className = object.getClass().getName();
			int lastIndex = className.lastIndexOf(".");
			className = className.substring(lastIndex+1);
			return className;
		}else{
			System.out.println("The object is null!");
			return null;
		}
	}

	/**
	 * 功能：获得某一对象对应数据库表的总记录数
	 * @param object 对象
	 * @param rowCount 总记录数
	 */
	public int rowCount(Object object,String queryString) {
		String className = getObjectName(object);
		String sql = "select count(*) from "+className+" t ";
		System.out.println(sql);
		if(queryString != null && !queryString.equals("")) {
			sql += queryString;
		}
		int rowCount = 0;
		long rCount = 0;
		List<Long> list = this.getHibernateTemplate().find(sql);
		if(list.size() > 0){
			rCount = list.get(0);
		}
		rowCount = Integer.parseInt(rCount+"");
		return rowCount;
	}
	
	public List<Object> pagination(int pageSize, int pageNow, String queryString) {
		List<Object> list = new ArrayList<Object>();
		try {
			list = this.getSession().createQuery(queryString).setFirstResult((pageNow-1)*pageSize).setMaxResults(pageSize).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(list != null){
			return list;
		}else{
			return null;
		}
	}
	
	public boolean modifyObject(Object object) {
		boolean b = false;
		try {
			this.getHibernateTemplate().update(object);
			b = true;
		} catch (Exception e) {
			e.printStackTrace();
			b = false;
		}
		return b;
	}
	
	public boolean delObject(Object object) {
		boolean b = false;
		try {
			this.getHibernateTemplate().delete(object);
			b = true;
		} catch (Exception e) {
			e.printStackTrace();
			b = false;
		}
		return b;
	}
	
	/*public Object searchObjectById(int id) {
		Object object = new Object();
		try {
			object = this.getHibernateTemplate().load(Object.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return object;
	}
*/
	
	public List<Object> findAllObject(Object object) {
		// TODO Auto-generated method stub
		String objectName = getObjectName(object);
		List<Object> list = new ArrayList<Object>();
		try {
			String queryString = "from "+objectName+" t";
			list = this.getHibernateTemplate().find(queryString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(list.isEmpty()) 
			return null;
		else 
			return list;
	}
	/*public Object getObjectBySessionName(String sessionName) {
		// TODO Auto-generated method stub
		Object obj = new Object();
		HttpServletRequest request= ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		obj = session.getAttribute(sessionName);
		return obj;
	}
	public void saveObjectToSession(String sessionName, Object obj) {
		// TODO Auto-generated method stub
		HttpServletRequest request= ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		session.setAttribute(sessionName,obj);
	}*/
}
