package com.hut.dao;

import java.util.List;

public interface BaseDao {
	/**
	 * 添加对象
	 */
	public boolean addObject(Object object);
	/**
	 * 分页查询
	 */
	public List<Object> pagination(int pageSize,int pageNow,String queryString);
	/**
	 * 功能：得到类的名称，供查询语句使用
	 */
	public String getObjectName(Object object);
	/**
	 * 功能：获得某一对象对应数据库表的总记录数
	 * @param object 对象
	 * @param rowCount 总记录数
	 */
	public int rowCount(Object object,String queryString);
	/**
	 * 修改
	 */
	public boolean modifyObject(Object object);
	/**
	 * 删除
	 */
	public boolean delObject(Object object);
	/**
	 * 根据id查对象
	 */
	//public Object searchObjectById(int id);
	/*
	 * 查询所有对象
	 */
	public List<Object> findAllObject(Object object);
	/*
	 * 获得session的值
	 */
	/*public Object getObjectBySessionName(String sessionName);
	public void saveObjectToSession(String sessionName, Object obj);*/
}
