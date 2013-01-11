package com.hut.service;

import com.hut.dao.BaseDao;
import com.hut.domain.Zjlb;

public interface ZjlbService extends BaseDao {
	/**通过专家名称查询专家	*/
	public  Zjlb findZjlbBymc(String zjlbmc);
	
	/**通过专家代码查询专家	*/
	public  Zjlb findZjlbBydm(String zjlbdm);
}
