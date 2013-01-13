package com.hut.util;

import java.util.Iterator;

import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.Column;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.mapping.Property;
import org.hibernate.mapping.Table;

public class HibernateParter {
	private static Configuration hibernateConf;
	
	private static Configuration getHibernateConf(){
		if(hibernateConf == null){
			return new Configuration();
		}
		return hibernateConf;
	}
	
	private static PersistentClass getPersistentClass (Class clazz){
		synchronized (HibernateParter.class) {
			PersistentClass pc = getHibernateConf().getClassMapping(clazz.getName());
			if(pc == null){
				hibernateConf = getHibernateConf().addClass(clazz); 
				pc = getHibernateConf().getClassMapping(clazz.getName());
			}
			return pc;
		}
	}
	
	 /**
	  * 获取实体对应的表名
	  * @param clazz 实体类
	  * @return 表名
	  */
	public static String getTableName(Class clazz){
		return getPersistentClass(clazz).getTable().getName();
	}
	
	 /**
	  * 获取实体对应表的主键字段名称
	  * @param clazz 实体类
	  * @return 主键字段名称
	  */
	public static String getPkColumnName(Class clazz){
		Table table = getPersistentClass(clazz).getTable();
		return table.getPrimaryKey().getColumn(0).getName();
	}
	
	 /**
	  * 通过实体类和属性，获取实体类属性对应的表字段名称
	  * @param clazz 实体类
	  * @param propertyName 属性名称
	  * @return 字段名称
	  */
	public static String getColumnName(Class clazz, String propertyName) {
		  PersistentClass persistentClass = getPersistentClass(clazz);
		  Property property = persistentClass.getProperty(propertyName);
		  Iterator it = property.getColumnIterator();
		  if (it.hasNext()) {   
		   Column column= (Column)it.next();   
		   return column.getName();
		  }
		  return null;
	}
	
	 /**
	  * 通过实体类和属性，获取实体类属性对应的备注名称
	  * @param clazz 实体类
	  * @param propertyName 属性名称
	  * @return 备注名称
	  */
	public static String getColumnComment(Class clazz, String propertyName) {
		  PersistentClass persistentClass = getPersistentClass(clazz);
		  Property property = persistentClass.getProperty(propertyName);
		  Iterator it = property.getColumnIterator();
		  if (it.hasNext()) {   
		   Column column= (Column)it.next();   
		   return column.getComment();
		  }
		  return null;
	}
	
	
}
