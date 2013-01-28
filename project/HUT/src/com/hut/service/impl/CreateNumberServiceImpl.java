package com.hut.service.impl;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import com.hut.dao.impl.BaseDaoImpl;
import com.hut.domain.Dqjg;
import com.hut.domain.Shjg;
import com.hut.domain.Teacher;
import com.hut.domain.Xy;
import com.hut.domain.Xzjg;
import com.hut.service.CreateNumberService;

public class CreateNumberServiceImpl extends BaseDaoImpl implements CreateNumberService {

	public String createNumber(String id, String name) {
		String  LSBH ="";
		char i=0;
		if("在编".equals(id))
			i='1';
		else
			i='2';

		int count =0;
		String dm = this.findXyByXymc(name);
		
		if(!"".equals(dm)) count = this.findXyrsByXydm(dm);
		else{
			dm = this.findDqjgByDqjgmc(name);
			if(!"".equals(dm))  count = this.findDqjgrsByDqjgdm(dm);
			else {
				dm = this.findXzjgByXzjgmc(name);
				if(!"".equals(dm)) count = this.findXzjgrsByXzjgdm(dm);
				else {
					dm = this.findShjgByShjgmc(name);
					if(!"".equals(dm)) count = this.findShjgrsByShjgdm(dm);
				}
			}
		}
		
		NumberFormat format = NumberFormat.getInstance();
		format.setMinimumIntegerDigits(3);
		LSBH = i + dm +  format.format(count+1);
		return LSBH;
	}
	
	/**根据老师所在学院的名称查询学院的代码	*/
	public String  findXyByXymc(String name ){
		List<Xy> xyList = new ArrayList<Xy>();
		try {
			String query = "from Xy t where t.xymc=?";
			xyList = this.getHibernateTemplate().find(query, name);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("根据老师所在学院名称查询学院代码  失败");
		}
		if(xyList.isEmpty()) return "";
		else  return xyList.get(0).getDm();
	}
	
	/**根据老师所在学院的代码查询老师的人数	*/
	public int  findXyrsByXydm(String xydm ){
		List<Teacher> teachers = new ArrayList<Teacher>();
		try {
			String query = "from Teacher t where t.xydm=?";
			teachers = this.getHibernateTemplate().find(query, xydm);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("根据老师所在学院的代码查询老师的人数 失败");
		}
		if(teachers.isEmpty()) return 0;
		else  return teachers.size();
	}
	
	/**跟据老师所在的党群机构的名称查询党群机构的代码	*/
	public String findDqjgByDqjgmc(String name ){
		List<Dqjg>  dqjgs = new ArrayList<Dqjg>();
		try {
			String query = "from Dqjg t where t.mc=?";
			dqjgs = this.getHibernateTemplate().find(query, name);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("跟据老师所在的党群机构名称查询党群机构的代码 失败");
		}
		if(dqjgs.isEmpty()) return "";
		else return  dqjgs.get(0).getDm();
	}

	/**根据老师所在党群机构的代码查询老师的人数	*/
	public int  findDqjgrsByDqjgdm(String dqjgdm ){
		List<Dqjg> teachers = new ArrayList<Dqjg>();
		try {
			String query = "from Teacher t where t.xydm=?";
			teachers = this.getHibernateTemplate().find(query, dqjgdm);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("根据老师所在党群机构的代码查询老师的人数 失败");
		}
		if(teachers.isEmpty()) return 0;
		else  return teachers.size();
	}
	
	/**跟据老师所在的行政机构的名称查询行政机构的代码	*/
	public String findXzjgByXzjgmc(String name ){
		List<Xzjg>  xzjgs = new ArrayList<Xzjg>();
		try {
			String query = "from Xzjg t where t.mc=?";
			xzjgs = this.getHibernateTemplate().find(query, name);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("跟据老师所在的行政机构名称查询行政机构的代码 失败");
		}
		if(xzjgs.isEmpty()) return "";
		else return  xzjgs.get(0).getDm();
	}
	
	/**根据老师所在行政机构的代码查询老师的人数	*/
	public int  findXzjgrsByXzjgdm(String xzjgdm ){
		List<Xzjg> teachers = new ArrayList<Xzjg>();
		try {
			String query = "from Teacher t where t.xydm=?";
			teachers = this.getHibernateTemplate().find(query, xzjgdm);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("根据老师所在行政机构的代码查询老师的人数 失败");
		}
		if(teachers.isEmpty()) return 0;
		else  return teachers.size();
	}

	/**跟据老师所在的社会机构的名称查询社会机构的代码	*/
	public String findShjgByShjgmc(String name ){
		List<Shjg>  xzjgs = new ArrayList<Shjg>();
		try {
			String query = "from Shjg t where t.mc=?";
			xzjgs = this.getHibernateTemplate().find(query, name);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("跟据老师所在的社会机构名称查询社会机构的代码 失败");
		}
		if(xzjgs.isEmpty()) return "";
		else return  xzjgs.get(0).getDm();
	}
	
	/**根据老师所在社会机构的代码查询老师的人数	*/
	public int  findShjgrsByShjgdm(String shjgdm ){
		List<Shjg> teachers = new ArrayList<Shjg>();
		try {
			String query = "from Teacher t where t.xydm=?";
			teachers = this.getHibernateTemplate().find(query, shjgdm);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("根据老师所在社会机构的代码查询老师的人数 失败");
		}
		if(teachers.isEmpty()) return 0;
		else  return teachers.size();
	}
}
