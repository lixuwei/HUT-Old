package com.hut.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.hut.dao.impl.BaseDaoImpl;
import com.hut.domain.Mid;
import com.hut.service.MidService;

public class MidServiceImpl extends BaseDaoImpl implements MidService {

	public List<Mid> getAllMids() {
		// TODO Auto-generated method stub
		List<Mid> list = new ArrayList<Mid>();
		String sql = "from Mid";
		try {
			list = this.getHibernateTemplate().find(sql);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public void addFromList(List<Mid> midList) {
		// TODO Auto-generated method stub
		for(Mid mid : midList) {
			this.addObject(mid);
		}
	}

}
