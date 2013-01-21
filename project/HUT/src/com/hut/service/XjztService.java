package com.hut.service;


import java.util.List;

import com.hut.dao.BaseDao;
import com.hut.domain.Ejxk;
import com.hut.domain.Xjzt;
import com.hut.domain.Xyzy;

/*
 * 学籍状态
 */
public interface XjztService extends BaseDao{

	/*
	 * 根据学籍状态代码获得对象
	 */
	public Xjzt findXjztByXjztdm(int xjztdm);

}