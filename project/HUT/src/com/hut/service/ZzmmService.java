package com.hut.service;

import com.hut.dao.BaseDao;
import com.hut.domain.Zzmm;
 
public interface ZzmmService extends BaseDao{
	/**通过政治名称查询政治身份* */
	public Zzmm findZzmmdmByMc(String zzmmmc);
	
	/**通过政治代码查询政治身份* */
	public Zzmm findZzmmdmByDm(String zzmmdm);
}
