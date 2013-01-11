package com.hut.action;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.http.HttpRequest;
import org.apache.struts2.ServletActionContext;

import com.hut.domain.Class;
import com.hut.domain.Jsxx;
import com.hut.domain.Lesson;
import com.hut.domain.Mid;
import com.hut.domain.Teacher;
import com.hut.service.ClassService;
import com.hut.service.JsxxService;
import com.hut.service.LessonService;
import com.hut.service.MidService;
import com.hut.service.TeacherService;
import com.opensymphony.xwork2.ActionSupport;

public class MidAction extends ActionSupport {
	
	private ClassService classService;
	private LessonService lessonService;
	private JsxxService jsxxService;
	private TeacherService teacherService;
	private MidService midService;
	
	public String addMid() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String kcmc = request.getParameter("kcmc");
		List<Class> classList = new ArrayList<Class>();
		List<Jsxx> jsxxList = new ArrayList<Jsxx>();
		List<Mid> midList = new ArrayList<Mid>();
		List<Teacher> teacherlList = new ArrayList<Teacher>();
		JSONObject firstJson = JSONObject.fromObject(request.getParameter("information"));
		JSONArray firstJsonArray = firstJson.optJSONArray("all");
		for(int i=0; i<firstJsonArray.size(); i++) {
			Class temp = classService.getClassByClassId(firstJsonArray.getJSONObject(i).optInt("i"));
			Jsxx temp1 = jsxxService.getJsxxByJsxxId(firstJsonArray.getJSONObject(i).optInt("c"));
			Teacher temp2 = teacherService.findTeacherByLsbh(firstJsonArray.getJSONObject(i).optString("t"));
			if(temp != null) {
				classList.add(temp);
			}
			if(temp1 != null) {
				jsxxList.add(temp1);
			}
			if(temp2 != null) {
				teacherlList.add(temp2);
			}
		}
		Lesson lesson = lessonService.getLessonByName(kcmc);
		for(int i=0; i<classList.size(); i++) {
			Mid mid = new Mid();
			mid.setClassName(classList.get(i).getClassName());
			mid.setLessonName(lesson.getKcmc());
			mid.setClassRoom(jsxxList.get(0).getJsmc());
			mid.setTeacherName(teacherlList.get(0).getXm());
			midList.add(mid);
		}
		midService.addFromList(midList);
		Lesson lesson2 = lessonService.getLessonByName(kcmc);
		lesson2.setState(1);
		lessonService.modifyObject(lesson2);
		return null;
	}
	
	public String getAllMid() {
		List<Mid> list = midService.getAllMids();
		JSONArray jsonArray = JSONArray.fromObject(list);
		JSONObject json = new JSONObject();
		json.accumulate("mid", jsonArray);
		try {
			ServletActionContext.getResponse().getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ClassService getClassService() {
		return classService;
	}

	public void setClassService(ClassService classService) {
		this.classService = classService;
	}

	public LessonService getLessonService() {
		return lessonService;
	}

	public void setLessonService(LessonService lessonService) {
		this.lessonService = lessonService;
	}

	public JsxxService getJsxxService() {
		return jsxxService;
	}

	public void setJsxxService(JsxxService jsxxService) {
		this.jsxxService = jsxxService;
	}

	public TeacherService getTeacherService() {
		return teacherService;
	}

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	public MidService getMidService() {
		return midService;
	}

	public void setMidService(MidService midService) {
		this.midService = midService;
	}
}
