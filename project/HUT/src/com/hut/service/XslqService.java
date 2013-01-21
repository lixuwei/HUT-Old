package com.hut.service;

import java.util.List;

import com.hut.dao.BaseDao;
import com.hut.domain.User;
import com.hut.domain.UserRole;
import com.hut.domain.Xs;
import com.hut.domain.Xslq;
import com.hut.domain.Xsxjzc;
import com.hut.domain.Xsxl;

/*
 * 学生录取
 */
public interface XslqService extends BaseDao{
	
	/*
	 * 添加学生录取信息
	 */
	public void addXslq(Xslq xslq);
	
	/*
	 * 显示所有的内容
	 */
	public List<Xslq> getAllXslq();

	/*
	 * 获得未编制学号的学生
	 */
	public List<Xslq> getNoXhList();
	
	/*
	 * 更新学生录取信息
	 */
	public void modifyXslq(Xslq xslq);
	
	/*
	 * 通过身份证查询
	 */
	public Xslq findXslqBySfz(String Sfz);
	
	/*
	 * 编制学号后将数据插入其他表
	 */
	public boolean addToOtherTable(User user, UserRole userRole, Xs xs, Xsxjzc xsxjzc, Xsxl xsxl);
	
}
