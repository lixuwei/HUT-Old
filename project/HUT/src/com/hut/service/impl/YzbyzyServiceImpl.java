package com.hut.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.hut.dao.impl.BaseDaoImpl;
import com.hut.domain.Yzbzzy;
import com.hut.domain.Zc;
import com.hut.service.YzbzzyService;

public class YzbyzyServiceImpl extends BaseDaoImpl implements YzbzzyService {

	public Yzbzzy findZyByZymc(String zymc) {
		List<Yzbzzy> txls = new ArrayList<Yzbzzy>();
		try {
			String query = "from Yzbzzy tx where tx.zymc=?";
			txls = this.getHibernateTemplate().find(query,zymc);
		} catch (Exception e) {
			System.out.println("查询专业代码失败");
		}
		if(txls.isEmpty()) return  null;
		else return txls.get(0);
	}

	public Yzbzzy findZyByZydm(String zydm) {
		List<Yzbzzy> yzbzzys = new ArrayList<Yzbzzy>();
		try {
			String string = "from Yzbzzy t where t.zydm=?";
			yzbzzys = this.getHibernateTemplate().find(string, zydm);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("得到老师毕业专业名称失败");
		}
		if(yzbzzys.isEmpty()) return null;
		else return yzbzzys.get(0);
	}

	public Yzbzzy findZyByYjxkmc(String zymc) {
		List<Yzbzzy> txls = new ArrayList<Yzbzzy>();
		try {
			String query = "from Yzbzzy tx where tx.yjxkmc=?";
			txls = this.getHibernateTemplate().find(query,zymc);
		} catch (Exception e) {
			System.out.println("查询专业代码失败");
		}
		if(txls.isEmpty()) return  null;
		else return txls.get(0);
	}

	public Yzbzzy findYjxkmByZydm(String zydm) {
		List<Yzbzzy> txls = new ArrayList<Yzbzzy>();
		try {
			String query = "from Yzbzzy tx where tx.yjxkdm=?";
			txls = this.getHibernateTemplate().find(query,zydm);
		} catch (Exception e) {
			System.out.println("查询专业代码失败");
		}
		if(txls.isEmpty()) return  null;
		else return txls.get(0);
	}

	


}
