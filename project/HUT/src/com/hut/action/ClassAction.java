package com.hut.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
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
import com.hut.domain.vo.TableItem;
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

	public String BuildClassTable() {
		HttpServletResponse response = ServletActionContext.getResponse();
		List<Mid> list = new ArrayList<Mid>();
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = null;
		try {
			pw = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[][] table = new String[4][5];
		list = midService.getAllMids();
		for(int i =0;i<4;i++){
			for(int n=0;n<5;n++){
				table[i][n]="";
			}
		}
		for(Mid mid : list){
			int random = (int)(Math.random()*20);
			if(table[random/5][random%5]!=""){
				table[random/5][random%5]=table[random/5][random%5]+"<br/>"+mid.getLessonName()+"("+mid.getClassName()+","+mid.getClassRoom()+","+mid.getTeacherName()+")";
			}else{
				table[random/5][random%5]=mid.getLessonName()+"("+mid.getClassName()+","+mid.getClassRoom()+","+mid.getTeacherName()+")";
			}
			   
			
		}
		List<TableItem> tableList = new ArrayList<TableItem>();
		for(int i = 0 ;i<5;i++){
			TableItem temp = new TableItem();
			temp.setItemName(""+(i+1));
			tableList.add(temp);
		}
		for(int i = 0;i<5;i++){
			for(int n = 0;n<4;n++){
				switch(n){
				case 0:
					tableList.get(i).setOne(table[n][i]);
					break;
				case 1:
					tableList.get(i).setTwo(table[n][i]);
					break;
				case 2:
					tableList.get(i).setThree(table[n][i]);
					break;
				case 3:
					tableList.get(i).setFour(table[n][i]);
					break;
				}
			}
		}
		JSONArray ja = JSONArray.fromObject(tableList);
		pw.print(ja);
	
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
