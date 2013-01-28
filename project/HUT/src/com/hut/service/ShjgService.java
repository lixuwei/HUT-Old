package com.hut.service;

import com.hut.dao.BaseDao;
import com.hut.domain.Shjg;

public interface ShjgService extends BaseDao {
	/**通过社会机构名称查询社会机构	*/
	Shjg findShjgBymc(String mc);

	/**通过社会代码名称查询社会机构	*/
	Shjg findShjgBydm(String dm);
}
