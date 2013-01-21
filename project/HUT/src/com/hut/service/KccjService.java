package com.hut.service;

import java.util.List;

import com.hut.dao.BaseDao;
import com.hut.domain.Kccj;

public interface KccjService extends BaseDao{

	public List<Kccj> getKccjByXh(String xh);
}
