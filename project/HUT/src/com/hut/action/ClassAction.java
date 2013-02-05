package com.hut.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.hut.domain.Class;
import com.hut.domain.Mid;
import com.hut.domain.vo.ClassVO;
import com.hut.service.ClassService;
import com.hut.service.MidService;
import com.opensymphony.xwork2.ActionSupport;

public class ClassAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private ClassService classService;
	private MidService midService;
	
	/*
	 * 合班操作
	 */
	public String MergeClass() {
		HttpServletRequest request = ServletActionContext.getRequest();
		List<Class> list = new ArrayList<Class>();
		String para = request.getParameter("information");
		JSONObject jo = JSONObject.fromObject(para);
		JSONArray json = JSONArray.fromObject(jo.get("info"));
		for(int i = 0; i<json.size(); i++) {
			/*tt.setClassName(json.getJSONObject(i).getString("className"));
			tt.setClassNum(json.getJSONObject(i).getInt("classNum"));*/
			Class tt  = classService.getClassByName(json.getJSONObject(i).getString("className"));
			list.add(tt);
		}
		
		String className = "";
		int classNum = 0;
		for(Class cl : list) {
			className = className +" "+cl.getClassName();
			classNum+=cl.getClassNum();
		}
		Class c = new Class();
		c.setClassName(className);
		c.setClassNum(classNum);
		classService.addMergeClass(list, c);
		return null;
	}
	
	public String getClasses() {
		String flag = null;
		List<Class> list = classService.getAllClasses();
		List<ClassVO> classVo = new ArrayList<ClassVO>();
		for(Class ca : list){
			ClassVO cv = new ClassVO();
			cv.setClassId(ca.getClassId());
			cv.setClassNum(ca.getClassNum());
//			cv.setClassName(ca.getClassName()+"("+ca.getClassNum()+")");
			if(flag != null && flag.equals("1")) {
				cv.setClassName(ca.getClassName()+"("+ca.getClassNum()+")");
			} else {
				cv.setClassName(ca.getClassName());
			}
			classVo.add(cv);
		}
		JSONArray json = JSONArray.fromObject(classVo);
		try {
			ServletActionContext.getResponse().getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String BuildClassTable() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		List<JSONObject> jsonList = new ArrayList<JSONObject>();
		List<Mid> list = midService.getAllMids();
		for(Mid mid : list){
			int temp = (int) (Math.random()*60);
			JSONObject jo = new JSONObject();
			jo.accumulate("position",(temp/10+1)+"-"+(temp%10+1));
			jo.accumulate("value", mid.getLessonName()+"&nbsp"+"("+mid.getClassName()+")<br>"+mid.getTeacherName()+"&nbsp&nbsp"+mid.getClassRoom()+"<br>");
			jsonList.add(jo);
		}
		pw.print(jsonList);
		return null;
	}
	
	@JSON(serialize = false)
	public ClassService getClassService() {
		return classService;
	}

	public void setClassService(ClassService classService) {
		this.classService = classService;
	}

	public MidService getMidService() {
		return midService;
	}

	public void setMidService(MidService midService) {
		this.midService = midService;
	}

}
