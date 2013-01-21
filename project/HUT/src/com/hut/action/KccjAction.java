package com.hut.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.hut.domain.Ejxk;
import com.hut.domain.Kccj;
import com.hut.domain.Lesson;
import com.hut.domain.User;
import com.hut.domain.Xs;
import com.hut.domain.Xy;
import com.hut.domain.vo.XscjVO;
import com.hut.service.EjxkService;
import com.hut.service.KccjService;
import com.hut.service.LessonService;
import com.hut.service.UserService;
import com.hut.service.XsService;
import com.hut.service.XyService;
import com.opensymphony.xwork2.ActionSupport;

public class KccjAction extends ActionSupport {

	private KccjService kccjService;
	private UserService userService;
	private XsService xsService;
	private EjxkService ejxkService;
	private XyService xyService;
	private LessonService lessonService;
	// 显示学生成绩
	public String showXsCj() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=GBK");
		int results = 0;
		int page = 0;
		int limit = 0;
		int start = 0;
		String pageString = request.getParameter("page");
		if(pageString != null) {
			page = Integer.parseInt(pageString);
		}
		String limitString = request.getParameter("limit");
		if(limitString != null) {
			limit = Integer.parseInt(limitString);
		}
		String startString = request.getParameter("start");
		if(startString != null) {
			start = Integer.parseInt(startString);
		}
		
		String yearString = request.getParameter("year");
		int year = -1;
		String xueqiString = request.getParameter("xueqi");
		int xueqi = -1;
		if(yearString != null && !yearString.equals("")) 
			year = Integer.parseInt(yearString);
		if(xueqiString != null && !xueqiString.equals(""))
			xueqi = Integer.parseInt(xueqiString);

		User user = userService.getUserBySession();
		results = kccjService.rowCount(new Kccj(), "where t.xh = '"+user.getUserName()+"'");
		Xs xs = xsService.findXsByXh(user.getUserName());
		Ejxk ejxk = ejxkService.findEjxkByEjxkDm(xs.getEjxkdm());
		Xy xy = xyService.findXyByXydm(xs.getXydm());
		List<Object> list =kccjService.pagination(limit, page, "from Kccj t where t.xh = '"+user.getUserName()+"'");
		List<XscjVO> items = new ArrayList<XscjVO>();
		for(Object temp : list) {
			Lesson lesson = lessonService.getLessonByKcdm(((Kccj)temp).getKcdm());
			if(year != -1 && year != lesson.getYear()) 
				break;
			if(xueqi != -1 && xueqi != lesson.getXueqi())
				break;
			XscjVO xscjVO = new XscjVO();
			xscjVO.setXh(xs.getXh());
			xscjVO.setXm(xs.getXm());
			xscjVO.setEjxk(ejxk.getEjxkmc());
			xscjVO.setXy(xy.getXymc());
			
			xscjVO.setKcmc(lesson.getKcmc());
			String kclb = "";
			//1为学位课的公共课 2为学位课的专业课 3为选修课 4为必修课 5补休课
			if(lesson.getKclb() == 1) {
				kclb="公开课";
			} else if(lesson.getKclb() == 2) {
				kclb="专业课";
			} else if(lesson.getKclb() == 3) {
				kclb="选修课";
			} else if(lesson.getKclb() == 4) {
				kclb="必修环节";
			} else if(lesson.getKclb() == 5) {
				kclb="实践环节";
			} else if(lesson.getKclb() == 6) {
				kclb="补休课";
			}
			xscjVO.setKclb(kclb);
			xscjVO.setXf(((Kccj)temp).getXf());
			xscjVO.setCj(((Kccj)temp).getPscj()*0.2 + ((Kccj)temp).getKscj()*0.8);
			items.add(xscjVO);
		}
		//JSONArray jsonArray = JSONArray.fromObject(items);
		JSONObject json = new JSONObject();
		json.element("items", items);
		json.put("results", results);
		try {
			ServletActionContext.getResponse().getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public KccjService getKccjService() {
		return kccjService;
	}
	public void setKccjService(KccjService kccjService) {
		this.kccjService = kccjService;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public XsService getXsService() {
		return xsService;
	}
	public void setXsService(XsService xsService) {
		this.xsService = xsService;
	}
	public EjxkService getEjxkService() {
		return ejxkService;
	}
	public void setEjxkService(EjxkService ejxkService) {
		this.ejxkService = ejxkService;
	}
	public XyService getXyService() {
		return xyService;
	}
	public void setXyService(XyService xyService) {
		this.xyService = xyService;
	}
	public LessonService getLessonService() {
		return lessonService;
	}
	public void setLessonService(LessonService lessonService) {
		this.lessonService = lessonService;
	}
}
