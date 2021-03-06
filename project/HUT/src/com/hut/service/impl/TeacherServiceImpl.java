package com.hut.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.hut.dao.impl.BaseDaoImpl;
import com.hut.domain.Teacher;
import com.hut.service.TeacherService;

public class TeacherServiceImpl extends BaseDaoImpl implements TeacherService{
	
	//通过老师身份证号查询老师
	public Teacher findBySfzhm(String string) {
		List<Teacher> teachers = new ArrayList<Teacher>();
		try{
			String query = "from Teacher t where t.sfzh=?";
			teachers = this.getHibernateTemplate().find(query,string);
		}catch (Exception e) {
			System.out.println("通过老师身份证号查询老师失败");
		}
		if(teachers.isEmpty()) return null;
		else return teachers.get(0);
	}
	
	//添加一个老师的数据
	public void addData(Teacher tTeacher) {
		try {
			this.getHibernateTemplate().save(tTeacher);
		} catch (Exception e) {
			System.out.println("出现重复值,插入失败!");
		}
	}
	
	//老师出现重复值 就替换
	public void modifyData( Teacher tTeacher) {
		try {
			this.getHibernateTemplate().merge(tTeacher);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("更新老师数据失败");
		}
		
	}
	
	
	//得到所有的老师
	public List<Teacher> getAllTeacher() {
		List<Teacher> list = new ArrayList<Teacher>();
		try {
			String queryString = "from Teacher";
			list = this.getHibernateTemplate().find(queryString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	
	//通过在同一学院的老师人数
	public int getTeachers(String xydm) {
		List<Teacher> teachers = new ArrayList<Teacher>();
		try {
			String query = "from Teacher  tt where tt.xydm=?";
			teachers=this.getHibernateTemplate().find(query,xydm);
		} catch (Exception e) {
			System.out.println("查询老师的人数失败");
		}
		return teachers.size();
	}
	
	public List<Object[]> getLSBySql(List<String> list){
		List<Object[]> listTeachers = new ArrayList<Object[]>();
		String sql = "select";
		try {
			for(int i= 0;i<list.size();i++){
				if(i==(list.size()-1))
					sql= sql +" "+list.get(i);
				else
					sql= sql +" "+list.get(i)+",";
			}
			sql =sql+" from Teacher";
			listTeachers = this.getHibernateTemplate().find(sql);
		} catch (Exception e) {
			System.out.println(sql);
			System.out.println("查询老师表的部分字段失败");
		}
		return listTeachers;
	} 

	public Teacher findTeacherByLsbh(String lsbh) {
		// TODO Auto-generated method stub
		List<Teacher> list = new ArrayList<Teacher>();
		String sql = "from Teacher where lsbh = ?";
		try {
			list = this.getHibernateTemplate().find(sql, lsbh);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(list.isEmpty())
			return null;
		else 
			return list.get(0);
	}

	public Teacher findByZgh(String zgh) {
		List<Teacher> teachers = new ArrayList<Teacher>();
		try {
			String query = "from Teacher t where t.zgh=?";
			teachers = this.getHibernateTemplate().find(query,zgh);
		} catch (Exception e) {
			System.out.println("根据职工号查找老师失败");
		}
		if(teachers.isEmpty()) return null;
		else return  teachers.get(0);
	}

}
