package com.hut.action;

import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.hut.domain.Teacher;
import com.hut.domain.User;
import com.hut.domain.UserRole;
import com.hut.domain.X;
import com.hut.domain.Xy;
import com.hut.domain.vo.TeacherVo;
import com.hut.service.DsxxService;
import com.hut.service.MzService;
import com.hut.service.TeacherService;
import com.hut.service.UserRoleService;
import com.hut.service.UserService;
import com.hut.service.XService;
import com.hut.service.XlService;
import com.hut.service.XwService;
import com.hut.service.XxService;
import com.hut.service.XyService;
import com.hut.service.YzbzzyService;
import com.hut.service.ZcService;
import com.hut.service.ZjlbService;
import com.hut.service.ZzmmService;
import com.hut.util.ExcelReader;
import com.hut.util.MD5;
import com.opensymphony.xwork2.ActionSupport;

public class TeacherAction extends ActionSupport {
	
	private TeacherService teacherService; private MzService mzService;
	private XyService xyService;           private XService xService;
	private YzbzzyService yzbzzyService;   private XlService xlService;
	private XwService xwService;           private ZcService zcService;
	private ZzmmService zzmmService;       private UserService userService;
	private XxService xxService;           private UserRoleService userRoleService;
	
	/*导入老师数据  代码段开始	*/
	private File upload; //上传的文件
	private String uploadFileName; //上传的文件的名称
	
	private int successCount = 0; //文件中成功上传的记录的条数
	private int updateCount = 0;  //文件中更新的记录的条数
	private int failCount = 0;    //文件中失败的记录的条数
	private boolean success = true;
	
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
	public int getSuccessCount() {
		return successCount;
	}
	public void setSuccessCount(int successCount) {
		this.successCount = successCount;
	}
	public int getUpdateCount() {
		return updateCount;
	}
	public void setUpdateCount(int updateCount) {
		this.updateCount = updateCount;
	}
	public int getFailCount() {
		return failCount;
	}
	public void setFailCount(int failCount) {
		this.failCount = failCount;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	
	//导入老师信息
	public String insertData(){
		ExcelReader excelReader = new ExcelReader();
		System.out.println(upload.getName()+uploadFileName);
		List<ArrayList<String>> data = excelReader.read(upload, uploadFileName);
		for(int i=1; i<data.size(); i++) {
			ArrayList<String> arrayList = (ArrayList<String>)data.get(i);
			Teacher tTeacher = new Teacher();
			String LSBH =createTeacherNumber(arrayList.get(21), arrayList.get(6));
			tTeacher.setLsbh(LSBH);
			tTeacher.setXm(arrayList.get(0));
			tTeacher.setZgh(arrayList.get(1));
			tTeacher.setZplj("");
			if(arrayList.get(2).toString().equals("男")){
				tTeacher.setXb(1);
			}else {
				tTeacher.setXb(0);
			}
			tTeacher.setMzdm(mzService.findMzdmByMzmc(arrayList.get(3)).getDm());
			tTeacher.setCsrq(arrayList.get(4));
			tTeacher.setZzmmdm(zzmmService.findZzmmdmByMc(arrayList.get(5)).getDm());
			tTeacher.setXydm(xyService.findXyByXymc(arrayList.get(6)).getDm());
			X x = xService.findXByXmc(arrayList.get(7));
			if(x==null) tTeacher.setXdm(null);
			else tTeacher.setXdm(x.getXdm());
			tTeacher.setLxdh(arrayList.get(8));
			tTeacher.setEmail(arrayList.get(9));
			tTeacher.setByxxdm(xxService.findXxByXxmc(arrayList.get(10)).getDm());
			tTeacher.setByzydm(yzbzzyService.findZyByZymc(arrayList.get(11)).getZydm());
			tTeacher.setXldm(xlService.findXlByXlmc(arrayList.get(12)).getDm());
			tTeacher.setXwdm(xwService.findXwByXwmc(arrayList.get(13)).getDm());
			tTeacher.setZcdm(zcService.findZcByZcmc(arrayList.get(14)).getDm());
			tTeacher.setZydm(yzbzzyService.findZyByZymc(arrayList.get(11)).getZydm());
			tTeacher.setZw(arrayList.get(15));
			tTeacher.setXkfx(arrayList.get(16));
			tTeacher.setSfzh(arrayList.get(17));
			tTeacher.setJszgzh(arrayList.get(18));
			tTeacher.setZjjszgzh(arrayList.get(19));
			tTeacher.setJxzlpj(arrayList.get(20));
			tTeacher.setJsjj("");
						
			User  tUser = new User();
			tUser.setUserName(LSBH);
			tUser.setPassword(MD5.toMD5(arrayList.get(17).substring(arrayList.get(17).length()-6, arrayList.get(17).length())));
			User  tUser2 =userService.findUserByLsbh(LSBH);
			
				Teacher temp = teacherService.findByZgh(arrayList.get(17));
				UserRole userRole = new UserRole();
				userRole.setUsername(LSBH);
				userRole.setRoleId(2);
				//没有重复的数据 就添加
			if(temp==null){	
					teacherService.addObject(tTeacher);
					if(tUser2==null)
						userService.addDataToUser(tUser);
					else
						userService.modifyUser(tUser);
					
					userRoleService.addObject(userRole);
					successCount++;
			}else {
				tTeacher.setLsbh(temp.getLsbh());
				teacherService.modifyData(tTeacher);
				if(tUser2==null)
					userService.addDataToUser(tUser);
				else
					userService.modifyUser(tUser);
				userRoleService.addObject(userRole);
				updateCount++;
			}
		}
		return SUCCESS;
	}
	
	//编制学号  传过来的是校内还是校外  还有学院名称
	public String createTeacherNumber(String id,String name ){
		String  LSBH =null;
		char i=0;
		if("在编".equals(id))
			i='1';
		else
			i='2';
		Xy xy = xyService.findXyByXymc(name);
		String xydm =xy.getDm();
		//查询同学院的老师的人数
		int count = teacherService.getTeachers(xydm);
		NumberFormat format = NumberFormat.getInstance();
		format.setMinimumIntegerDigits(3);
		LSBH = i + xy.getDm() +  format.format(count+1);
		return LSBH;
	}  
	
	/*导入老师信息  代码段结束	*/
	
	
	/*显示老师信息  代码段开始	*/
	private List<TeacherVo> items = null;
	private int results=0;
	private int limit=0;
	private int start=0;
	private int page=0;
	public List<TeacherVo> getItems() {
		return items;
	}
	public void setItems(List<TeacherVo> items) {
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
	public String  showAllLS(){
		List<Teacher>  teachersList = teacherService.getAllTeacher();
			int temp1 = 0;
			HttpServletRequest request = ServletActionContext.getRequest();
			page = Integer.parseInt(request.getParameter("page"));
			try{
				start = Integer.parseInt(request.getParameter("start"));
			}catch (NumberFormatException e) {
				start = 0 ;
			}
			try {
				limit = Integer.parseInt(request.getParameter("limit"));
			} catch (NumberFormatException e) {
				limit = 0;
			}
			this.results = teachersList.size();
			items = new ArrayList<TeacherVo>();
			if((results-(page-1)*limit)<limit){
				temp1=start+(results-(page-1)*limit);
			}else {
				temp1=start+limit;
			}
			for (int i = start; i < temp1; i++) {
				TeacherVo teacher = new TeacherVo();
				teacher.setLsbh(teachersList.get(i).getLsbh());
				teacher.setXm(teachersList.get(i).getXm());
				teacher.setZgh(teachersList.get(i).getZgh());
				teacher.setZplj(teachersList.get(i).getZplj());
				
				int  xb = teachersList.get(i).getXb();
				if(xb==1){
					teacher.setXb("男");
				}else {
					teacher.setXb("女");
				}
				
				String NationName = mzService.findMzByMzdm(teachersList.get(i).getMzdm()).getMc();
				teacher.setMzdm(NationName);
				teacher.setCsrq(teachersList.get(i).getCsrq());
				teacher.setLxdh(teachersList.get(i).getLxdh());
				teacher.setEmail(teachersList.get(i).getEmail());
				teacher.setZzmmdm(zzmmService.findZzmmdmByDm(teachersList.get(i).getZzmmdm()).getMc());
				teacher.setXydm(xyService.findXyByXydm(teachersList.get(i).getXydm()).getXymc());
				if(teachersList.get(i).getXdm()==null)  teacher.setXdm("");
				else   teacher.setXdm(xService.findXByXdm(teachersList.get(i).getXdm()).getXmc());
				teacher.setByxxdm(xxService.findXxByXxdm(teachersList.get(i).getByxxdm()).getMc());
				teacher.setByzydm(yzbzzyService.findZyByZydm(teachersList.get(i).getByzydm()).getZymc());
				teacher.setXldm(xlService.findXlByXldm(teachersList.get(i).getXldm()).getCm());
				teacher.setXwdm(xwService.findXwByXwdm(teachersList.get(i).getXwdm()).getMc());
				teacher.setZcdm(zcService.findZcByZcdm(teachersList.get(i).getZcdm()).getMc());
				teacher.setZw(teachersList.get(i).getZw());
				teacher.setXkfx(teachersList.get(i).getXkfx());
				teacher.setSfzh(teachersList.get(i).getSfzh());
				teacher.setJszgzh(teachersList.get(i).getJszgzh());
				teacher.setJsjj(teachersList.get(i).getJsjj());
				teacher.setZjjszgzh(teachersList.get(i).getZjjszgzh());
				teacher.setJxzlpj(teachersList.get(i).getJxzlpj());
				items.add(teacher);
			}
		return SUCCESS;
	}
	
	/*显示老师信息  代码段结束	*/

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}
	public void setMzService(MzService mzService) {
		this.mzService = mzService;
	}
	public void setXyService(XyService xyService) {
		this.xyService = xyService;
	}
	public void setxService(XService xService) {
		this.xService = xService;
	}
	public void setYzbzzyService(YzbzzyService yzbzzyService) {
		this.yzbzzyService = yzbzzyService;
	}
	public void setXlService(XlService xlService) {
		this.xlService = xlService;
	}
	public void setXwService(XwService xwService) {
		this.xwService = xwService;
	}
	public void setZcService(ZcService zcService) {
		this.zcService = zcService;
	}
	public void setZzmmService(ZzmmService zzmmService) {
		this.zzmmService = zzmmService;
	}
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public void setXxService(XxService xxService) {
		this.xxService = xxService;
	}
	public void setUserRoleService(UserRoleService userRoleService) {
		this.userRoleService = userRoleService;
	}
	
	public String getAllTeachers() {
		List<Teacher> teacherList = teacherService.getAllTeacher();
		JSONArray json = JSONArray.fromObject(teacherList);
		try {
			ServletActionContext.getResponse().getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
