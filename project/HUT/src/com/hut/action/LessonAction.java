package com.hut.action;

import java.io.IOException;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.hut.domain.Lesson;
import com.hut.service.LessonService;
import com.opensymphony.xwork2.ActionSupport;

public class LessonAction extends ActionSupport {

	private LessonService lessonService;
	private List<Lesson> list;
	private int year = 2012;
	private int xueqi;
	
	/*
	 * 显示**年**学期的课程
	 */
	public String showLessonByYearAndXueqi() {
		list = lessonService.getLessonsByYearAndXueqi(year, xueqi);
		JSONArray json = JSONArray.fromObject(list);
		try {
			ServletActionContext.getResponse().getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String getLessonByLessonName() {
		String kcmc = ServletActionContext.getRequest().getParameter("kcmc");
		Lesson lesson = lessonService.getLessonByName(kcmc);
		JSONObject json = new JSONObject();
		if(lesson != null) {
			if (lesson.getState() == 1) {
				json.put("state", "false");
				try {
					ServletActionContext.getResponse().getWriter().print(json);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				json.accumulate("state", "true");
				try {
					ServletActionContext.getResponse().getWriter().print(json);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
		}
		return null;
	}
	
	@JSON(serialize = false)
	public LessonService getLessonService() {
		return lessonService;
	}
	public void setLessonService(LessonService lessonService) {
		this.lessonService = lessonService;
	}
	public List<Lesson> getList() {
		return list;
	}
	public void setList(List<Lesson> list) {
		this.list = list;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getXueqi() {
		return xueqi;
	}
	public void setXueqi(int xueqi) {
		this.xueqi = xueqi;
	}
}
