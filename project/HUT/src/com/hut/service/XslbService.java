package com.hut.service;


import java.util.List;

import com.hut.dao.BaseDao;
import com.hut.domain.Xslb;

/*
 * 学生类别
 */
public interface XslbService extends BaseDao{

	public Xslb findXslbByXslbdm(int dm);

	public boolean deleteXslbs(List<Xslb> list);
}