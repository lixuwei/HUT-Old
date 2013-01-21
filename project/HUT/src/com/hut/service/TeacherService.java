package com.hut.service;

import java.util.List;

import com.hut.dao.BaseDao;
import com.hut.domain.Dsxx;
import com.hut.domain.Teacher;
import com.hut.domain.User;
import com.hut.domain.Xy;

public interface TeacherService extends BaseDao{
	/**得到所有的老师	*/
	public List<Teacher> getAllTeacher();
	
	/**通过老师身份证查询老师	*/
	public Teacher findByZgh(String string);
	
	/**添加一条老师记录	*/
	public boolean addObject(Object object);
	
	/**老师记录重复，就修改	*/
	public void modifyData( Teacher tTeacher);
	
	/**通过老师身份证号码查询老师的编号 */	
	public String findBysfz(String string);
	
	/**统计现有老师的人数 */	
	public int getTeachers(String xydm);
	
	/**导出老师的部分字段	*/
	public abstract List<Object[]> getLSBySql(List<String> list);
	
	/*
	 * 根据老师编号得到老师对象
	 */
	public Teacher findTeacherByLsbh(String lsbh);
}
