package com.hut.service;

import com.hut.dao.BaseDao;
import com.hut.domain.Yjdw;

public interface YjdwService extends BaseDao {
	/**根据一级单位名称查询一级单位	*/
	Yjdw findYjdwBymc(String mc);
	/**根据一级单位代码查询一级单位	*/
	Yjdw findYjdwBydm(String dwdm);
}
