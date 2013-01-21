package com.hut.service;


import java.util.List;

import com.hut.dao.BaseDao;
import com.hut.domain.Dsxx;
import com.hut.domain.Ejxk;
import com.hut.domain.Xyzy;

/*
 * 导师信息表
 */
public interface DsxxService extends BaseDao{
	
	/**导出老师的部分字段	*/
	public abstract List<Object[]> getDSBySql(List<String> list);
	/*
	 * 根据老师编号获得对象
	 */
	public Dsxx findDsxxByLsbh(String lsbh);

	/**添加导师*/
	public void addDsData(Dsxx dsxx);
	
	/**查询所有的导师	*/
	public List<Dsxx> getAllDS();
	
	/**通过老师编号查询导师	*/
	public Dsxx findDSByLsbh(String lsbh);
	
	/**修改导师	*/
	public void modifyDs(Dsxx tDsxx);
	
	/**根据导师的编号查询导师的姓名	*/
	public  String getDSName(String name);
	

	
}