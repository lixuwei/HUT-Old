package com.hut.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.hut.domain.Lesson;
import com.hut.service.LessonService;
import com.hut.util.ExcelReader;
import com.opensymphony.xwork2.ActionSupport;

public class LessonAction extends ActionSupport {

	private LessonService lessonService;
	private int year = 2012;
	private int xueqi;
	private File upload;
	private String uploadFileName;
	
	/*
	 * 显示**年**学期的课程
	 */
	public String showLessonByYearAndXueqi() {
		List<Lesson> list = null;
		ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
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
	
	/*
	 * 根据课程名得到课程
	 */
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
	
	/*
	 * 从excel中导入
	 */
	public String uploadLesson() {
		int successCount = 0;
		int failCount = 0;
		ExcelReader excelReader = new ExcelReader();
		List<ArrayList<String>> data = excelReader.read(upload, uploadFileName);
		for(int i=1; i<data.size(); i++) {
			ArrayList<String> arrayList = data.get(i);
			Lesson lesson = new Lesson();
			lesson.setKcdm((int)Double.parseDouble(arrayList.get(0)));
			lesson.setKcmc(arrayList.get(1));
			lesson.setXf(Double.parseDouble(arrayList.get(2)));
			lesson.setXs((int)Double.parseDouble(arrayList.get(3)));
			lesson.setXueqi((int)Double.parseDouble(arrayList.get(4)));
			lesson.setKkdw(arrayList.get(5));
			lesson.setFlag((int)Double.parseDouble(arrayList.get(6)));
			lesson.setKclb((int)Double.parseDouble(arrayList.get(7)));
			lesson.setKhfs(arrayList.get(8));
			lesson.setYear((int)Double.parseDouble(arrayList.get(9)));
			lesson.setBz(arrayList.get(10));
			lesson.setState(0);
			if (lessonService.addObject(lesson)) {
				successCount++;
			} else {
				failCount++;
			}
		}
		JSONObject json = new JSONObject();
		json.put("successCount", successCount);
		json.put("failCount", failCount);
		json.put("success", true);
		try {
			ServletActionContext.getResponse().getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String showAllByPage() {
		List<Object> items = null;
		int limit = 0;
		int page = 1;
		int results = 0;
		int start = 0;
		HttpServletRequest request = ServletActionContext.getRequest();
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
		results = lessonService.rowCount(new Lesson(), "");
		items = lessonService.pagination(limit, page, "from Lesson t ");
		JSONArray jsonArray = JSONArray.fromObject(items);
		JSONObject json = JSONObject.fromObject(jsonArray);
		json.put("results", results);
		try {
			ServletActionContext.getResponse().getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
}
