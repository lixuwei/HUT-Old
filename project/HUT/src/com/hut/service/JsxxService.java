package com.hut.service;

import java.util.List;

import com.hut.dao.BaseDao;
import com.hut.domain.Jsxx;

public interface JsxxService extends BaseDao {
	
	/**根据教室名称查询教室	*/
	public Jsxx findByJsMc(String jsmc);

	/*
	 * 根据教室id得到对象
	 */
	public Jsxx getJsxxByJsxxId(int jsxxId);

	/*
	 * 获得所有的教室
	 */
	public List<Jsxx> getAllJsxxs();
}
