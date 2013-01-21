package com.hut.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import com.hut.domain.Ejxk;
import com.hut.domain.Mz;
import com.hut.domain.Pycc;
import com.hut.domain.X;
import com.hut.domain.Xjzt;
import com.hut.domain.Xs;
import com.hut.domain.Xslb;
import com.hut.domain.Xy;
import com.hut.domain.vo.Xsgrxx;
import com.hut.service.EjxkService;
import com.hut.service.MzService;
import com.hut.service.PyccService;
import com.hut.service.TeacherService;
import com.hut.service.UserService;
import com.hut.service.XService;
import com.hut.service.XjztService;
import com.hut.service.XsService;
import com.hut.service.XsdsService;
import com.hut.service.XslbService;
import com.hut.service.XyService;
import com.opensymphony.xwork2.ActionSupport;

public class XsAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private XsService xsService;
	private UserService userService;
	private MzService mzService;
	private XslbService xslbService;
	private XyService xyService;
	private XService xService;
	private PyccService pyccService;
	private EjxkService ejxkService;
	private TeacherService teacherService;
	private XsdsService xsdsService;
	private XjztService xjztService;
	private List<Object> items = null;
	private Xsgrxx data = new Xsgrxx();
	private int results=0;
	private int limit=0;
	private int start=0;
	private int page;
	private String xydm;
	private String ejxkdm;
	private String qt;
	private String qtValue;
	private boolean success = true;
	
	public String showAllByPage() {
		String queryString = "";
		if(ejxkdm != null && !ejxkdm.equals("")) {
			if(queryString == null || queryString.equals("")) {
				queryString = queryString + " t.ejxkdm='" + ejxkdm+"'";
			} else {
				queryString = queryString + " and t.ejxkdm='" + ejxkdm+"'";
			}
		}
		
		if(xydm != null && !xydm.equals("")) {
			if(queryString == null || queryString.equals("")) {
				queryString = queryString + " t.xydm='" + xydm+"'";
			} else {
				queryString = queryString + " and t.xydm='" + xydm+"'";
			}
		}
		
		if(qtValue != null && !qtValue.equals("")) {
			if(queryString == null || queryString.equals("")) {
				queryString = queryString + " t."+qt+ "='"+qtValue+"'";
			} else {
				queryString = queryString + " and t."+qt+ "='"+qtValue+"'";
			}
		}
		

		if(queryString != null && !queryString.equals("")) {
			queryString = "where" + queryString;
		}
		System.out.println("queryString = "+queryString);
		this.results = xsService.rowCount(new Xs(), queryString);
		items = xsService.pagination(limit, page, "from Xs t "+queryString);
		return SUCCESS;
	}
	
	public String findXsgrxxByXh() {
		String xh = userService.getUserBySession().getUserName();
		Xs xs = xsService.findXsByXh(xh);
		data.setXh(xs.getXh());
		data.setZplj(xs.getZplj());
		data.setXm(xs.getXm());
		data.setXmpy(xs.getXmpy());
		data.setCym(xs.getCym());
		data.setZjlx(xs.getZjlx());
		if (xs.getXbm() == 1) {
			data.setXb("男");
		} else if(xs.getXbm() == 2){
			data.setXb("女");
		}
		data.setZjhm(xs.getZjhm());
		Mz mz = mzService.findMzByMzdm(xs.getMzm());
		data.setMz(mz.getMc());
		data.setJg(xs.getJg());
		data.setCsrq(xs.getCsrq());
		if (xs.getHfm() == 1) {
			data.setHf("未婚");
		} else if(xs.getXbm() == 2){
			data.setHf("已婚");
		}
		data.setZzmm(xs.getZzmmm());
		if (xs.getXxfs() == 1) {
			data.setXxfs("全日制");
		} else if(xs.getXxfs() == 2){
			data.setXxfs("非全日制");
		}
		Xslb xslb = xslbService.findXslbByXslbdm(xs.getXslb());
		data.setXslb(xslb.getMc());
		Xy xy = xyService.findXyByXydm(xs.getXydm());
		data.setXy(xy.getXymc());
		if(xs.getXdm() != null) {
			X x = xService.findXByXdm(xs.getXdm());
			data.setX(x.getXmc());
		} else {
			data.setX("");
		}
		if(xs.getPyccdm() != null) {
			Pycc pycc = pyccService.findPyccByPyccdDm(xs.getPyccdm());
			data.setPycc(pycc.getMc());
		} else {
			data.setPycc("");
		}
		Ejxk ejxk = ejxkService.findEjxkByEjxkDm(xs.getEjxkdm());
		data.setXkml(ejxk.getMlmc());
		data.setYjxk(ejxk.getYjxkmc());
		data.setEjxk(ejxk.getEjxkmc());
		// 导师信息的展示这里未写
		/*Teacher dsxx1 = teacherService.findByLsbh(xsdsService.findDsxxByXsXh(xs.getXh()).get(0).getLsbh());
		xsgrxx.setDs1(dsxx1.get)*/
		data.setHdxlfs(xs.getHdxlfsdm());
		if(xs.getXfzqk() == 1) {
			data.setXfzqk("是");
		} else if (xs.getXfzqk() == 2) {
			data.setXfzqk("否");
		}
		data.setXz1(xs.getXz1());
		data.setXz2(xs.getXz2());
		data.setRxny(xs.getRxny());
		data.setNj(xs.getNj());
		data.setRxxq(xs.getRxxq());
		if(xs.getYjxksq() == 1) {
			data.setYjxksq("是");
		} else if (xs.getXfzqk() == 2) {
			data.setYjxksq("否");
		}
		data.setBjdm(xs.getBjdm());
		Xjzt xjzt = xjztService.findXjztByXjztdm(xs.getXjztdm());
		data.setXjzt(xjzt.getMc());
		data.setXjydqk(xs.getXjydqk());
		data.setKsdm(xs.getKsdm());
		data.setZcqk(xs.getZcqk());
		data.setZcrq(xs.getZcrq());
		data.setYhkh(xs.getYhkh());
		data.setJhsh(xs.getJhsh());
		data.setJsxysm(xs.getJsxysm());
		data.setStzk(xs.getStzk());
		data.setBz(xs.getBz());
		return SUCCESS;
	}

	@JSON(serialize=false)
	public MzService getMzService() {
		return mzService;
	}

	public void setMzService(MzService mzService) {
		this.mzService = mzService;
	}

	@JSON(serialize=false)
	public XslbService getXslbService() {
		return xslbService;
	}

	public void setXslbService(XslbService xslbService) {
		this.xslbService = xslbService;
	}

	@JSON(serialize=false)
	public XyService getXyService() {
		return xyService;
	}

	public void setXyService(XyService xyService) {
		this.xyService = xyService;
	}

	@JSON(serialize=false)
	public XService getxService() {
		return xService;
	}

	public void setxService(XService xService) {
		this.xService = xService;
	}

	@JSON(serialize=false)
	public PyccService getPyccService() {
		return pyccService;
	}

	public void setPyccService(PyccService pyccService) {
		this.pyccService = pyccService;
	}

	@JSON(serialize=false)
	public EjxkService getEjxkService() {
		return ejxkService;
	}

	public void setEjxkService(EjxkService ejxkService) {
		this.ejxkService = ejxkService;
	}

	@JSON(serialize=false)
	public TeacherService getTeacherService() {
		return teacherService;
	}

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	@JSON(serialize=false)
	public XsdsService getXsdsService() {
		return xsdsService;
	}

	public void setXsdsService(XsdsService xsdsService) {
		this.xsdsService = xsdsService;
	}

	@JSON(serialize=false)
	public XjztService getXjztService() {
		return xjztService;
	}

	public void setXjztService(XjztService xjztService) {
		this.xjztService = xjztService;
	}

	@JSON(serialize=false)
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	@JSON(serialize=false)
	public XsService getXsService() {
		return xsService;
	}
	public void setXsService(XsService xsService) {
		this.xsService = xsService;
	}

	public List<Object> getItems() {
		return items;
	}

	public void setItems(List<Object> items) {
		this.items = items;
	}

	public int getResults() {
		return results;
	}

	public void setResults(int results) {
		this.results = results;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getXydm() {
		return xydm;
	}

	public void setXydm(String xydm) {
		this.xydm = xydm;
	}

	public String getEjxkdm() {
		return ejxkdm;
	}

	public void setEjxkdm(String ejxkdm) {
		this.ejxkdm = ejxkdm;
	}

	public String getQt() {
		return qt;
	}

	public void setQt(String qt) {
		this.qt = qt;
	}

	public String getQtValue() {
		return qtValue;
	}

	public void setQtValue(String qtValue) {
		try {
			this.qtValue = new String(qtValue.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public Xsgrxx getData() {
		return data;
	}

	public void setData(Xsgrxx data) {
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
}
