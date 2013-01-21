package com.hut.service;

import com.hut.dao.BaseDao;
import com.hut.domain.User;
public interface UserService extends BaseDao{
	/*
	 * 验证登录
	 */
	public boolean Login(String username, String password);
	
	/*
	 * 保存session
	 */
	public void saveUserToSession(User user);
	
	/*
	 * 清空session
	 */
	public void clearSession();
	
	/*
	 * 从session中得到User对象
	 */
	public User getUserBySession();
	
	/**通过老师编号查询用户*/
	public User findUserByLsbh(String lsbh);
	
	/**添加一个用户*/
	public void addDataToUser(User user);
	
	/**已有用户的修改	*/
	public void modifyUser(User user);
}
