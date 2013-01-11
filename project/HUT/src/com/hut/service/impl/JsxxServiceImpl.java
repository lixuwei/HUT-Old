package com.hut.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.hut.dao.impl.BaseDaoImpl;
import com.hut.domain.Jsxx;
import com.hut.service.JsxxService;

public class JsxxServiceImpl extends BaseDaoImpl implements JsxxService {

	public Jsxx getJsxxByJsxxId(int jsxxId) {
		// TODO Auto-generated method stub
		List<Jsxx> list = new ArrayList<Jsxx>();
		String sql = "from Jsxx where id = ?";
		try {
			list = this.getHibernateTemplate().find(sql, jsxxId);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(list.isEmpty())
			return null;
		else 
			return list.get(0);
	}

	public List<Jsxx> getAllJsxxs() {
		// TODO Auto-generated method stub
		List<Jsxx> list = new ArrayList<Jsxx>();
		String sql = "from Jsxx";
		try {
			list = this.getHibernateTemplate().find(sql);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public Jsxx findByJsMc(String jsmc) {
		List<Jsxx>  jsxxs  = new ArrayList<Jsxx>();
		try {
			String  sql = "from Jsxx t where t.jsmc=?";
			jsxxs  = this.getHibernateTemplate().find(sql,jsmc);
		} catch (Exception e) {
			System.out.println("根据教室名称查询教室信息失败");
		}
		if(jsxxs.isEmpty())  return null;
		else return jsxxs.get(0);
	}

}
