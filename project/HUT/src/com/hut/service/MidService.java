package com.hut.service;

import java.util.List;

import com.hut.dao.BaseDao;
import com.hut.domain.Mid;

public interface MidService extends BaseDao {
	
	public List<Mid> getAllMids();

	/*
	 * 批量添加Mid
	 */
	public void addFromList(List<Mid> midList);
	
}
