package com.hut.action;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.hut.domain.Dqjg;
import com.hut.domain.Mz;
import com.hut.domain.Shjg;
import com.hut.domain.Teacher;
import com.hut.domain.User;
import com.hut.domain.UserRole;
import com.hut.domain.X;
import com.hut.domain.Xl;
import com.hut.domain.Xw;
import com.hut.domain.Xx;
import com.hut.domain.Xy;
import com.hut.domain.Xzjg;
import com.hut.domain.Yzbzzy;
import com.hut.domain.Zc;
import com.hut.domain.Zzmm;
import com.hut.domain.vo.TeacherVo;
import com.hut.service.CreateNumberService;
import com.hut.service.DqjgService;
import com.hut.service.DsxxService;
import com.hut.service.MzService;
import com.hut.service.ShjgService;
import com.hut.service.TeacherService;
import com.hut.service.UserRoleService;
import com.hut.service.UserService;
import com.hut.service.XService;
import com.hut.service.XlService;
import com.hut.service.XwService;
import com.hut.service.XxService;
import com.hut.service.XyService;
import com.hut.service.XzjgService;
import com.hut.service.YzbzzyService;
import com.hut.service.ZcService;
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
	private DqjgService dqjgService;       private XzjgService  xzjgService;
	private ShjgService shjgService;       private CreateNumberService  createNumberService;
	
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
			String LSBH =createNumberService.createNumber(arrayList.get(21), arrayList.get(6));
			tTeacher.setLsbh(LSBH);
			tTeacher.setXm(arrayList.get(0));
			tTeacher.setZgh(arrayList.get(1));
			tTeacher.setZplj("");
			if(arrayList.get(2).toString().equals("男")){
				tTeacher.setXb(1);
			}else {
				tTeacher.setXb(0);
			}
			Mz  mz= mzService.findMzdmByMzmc(arrayList.get(3));
			if(mz!=null) tTeacher.setMzdm(mz.getDm());
			else  tTeacher.setMzdm(null);
			
			String csrq = arrayList.get(4);
			if("无".equals(csrq)) 	tTeacher.setCsrq(null);
			else tTeacher.setCsrq(csrq);
			
			Zzmm  zzmm = zzmmService.findZzmmdmByMc(arrayList.get(5));
			if(zzmm!=null) tTeacher.setZzmmdm(zzmm.getDm());
			else  tTeacher.setZzmmdm(null);
			
			/*处理老师来源的代码		开始	*/
			String mc =arrayList.get(6);
			if("无".equals(mc)){
				tTeacher.setXydm(null);
			}else{
				Xy   xy = xyService.findXyByXymc(mc);
				if(xy!=null)  tTeacher.setXydm(xy.getDm());
				else{
					Dqjg dqjg = dqjgService.findDqjgBymc(mc);
					if(dqjg!=null) tTeacher.setXydm(dqjg.getDm());
					else {
						Xzjg xzjg = xzjgService.findXzjgBymc(mc);
						if(xzjg!=null) tTeacher.setXydm(xzjg.getDm());
						else {
							Shjg shjg = shjgService.findShjgBymc(mc);
							if(shjg!=null) tTeacher.setXydm(shjg.getDm());
							else  tTeacher.setXydm(null);
						}
					}
				}
			}
			/*处理老师来源的代码	   结束	*/
			
			X x = xService.findXByXmc(arrayList.get(7));
			if(x==null) tTeacher.setXdm(null);
			else tTeacher.setXdm(x.getXdm());
			
			String lxdh = arrayList.get(8);
			if("无".equals(lxdh)) tTeacher.setLxdh(null);
			else  tTeacher.setLxdh(lxdh);
			
			String email = arrayList.get(9);
			if("无".equals(email))  tTeacher.setEmail(null);
			else 	tTeacher.setEmail(email);
			
			Xx  xx = xxService.findXxByXxmc(arrayList.get(10));
			if(xx!=null)	tTeacher.setByxxdm(xx.getDm());
			else   tTeacher.setByxxdm(null);
			
			Yzbzzy  yzbzzy = yzbzzyService.findZyByZymc(arrayList.get(11));
			if(yzbzzy!=null) tTeacher.setByzydm(yzbzzy.getZydm());
			else tTeacher.setByzydm(null);
			
			Xl   xl = xlService.findXlByXlmc(arrayList.get(12));
			if(xl!=null) 	tTeacher.setXldm(xl.getDm());
			else  tTeacher.setXldm(null);
			
			Xw   xw  = xwService.findXwByXwmc(arrayList.get(13));
			if(xw!=null)   tTeacher.setXwdm(xw.getDm());
			else tTeacher.setXwdm(null);
			
			Zc   zc  = zcService.findZcByZcmc(arrayList.get(14));
			if(zc!=null)    tTeacher.setZcdm(zc.getDm());
			else tTeacher.setZcdm(null);
			
			Yzbzzy  yzbzzy2 = yzbzzyService.findZyByZymc(arrayList.get(11));
			if(yzbzzy2!=null)  tTeacher.setZydm(yzbzzy2.getZydm());
			else tTeacher.setZydm(null);
			
			String  zw = arrayList.get(15);
			if("无".equals(zw))  tTeacher.setZw(null);
			else  tTeacher.setZw(zw);
			
			String  xkfx = arrayList.get(16);
			if("无".equals(xkfx))  tTeacher.setXkfx(null);
			else  	tTeacher.setXkfx(xkfx);
			
			String  sfzh = arrayList.get(17);
			if("无".equals(sfzh))  tTeacher.setSfzh(null);
			else   	tTeacher.setSfzh(sfzh);
			
			String  jszgzh = arrayList.get(18);
			if("无".equals(jszgzh))  tTeacher.setJszgzh(null);
			else  tTeacher.setJszgzh(jszgzh);
			
			String  zjjszgzh =  arrayList.get(19);
			if("无".equals(zjjszgzh)) tTeacher.setZjjszgzh(null);
			else 	tTeacher.setZjjszgzh(zjjszgzh);
			
			String  jxzlpj = arrayList.get(20);
			if("无".equals(jxzlpj))  tTeacher.setJxzlpj(null);
			else  	tTeacher.setJxzlpj(jxzlpj);
			
			tTeacher.setJsjj("");
						
			User  tUser = new User();
			tUser.setUserName(LSBH);
			tUser.setPassword(MD5.toMD5(arrayList.get(17).substring(arrayList.get(17).length()-6, arrayList.get(17).length())));
			tUser.setEmail(tTeacher.getEmail());
			tUser.setTel(tTeacher.getLxdh());
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
				
				String  mzdm = teachersList.get(i).getMzdm();
				if(mzdm==null) teacher.setMzdm("");
				else  teacher.setMzdm(mzService.findMzByMzdm(mzdm).getMc());
				
				String  csrq = teachersList.get(i).getCsrq();
				if(csrq==null) teacher.setCsrq("");
				else  teacher.setCsrq(csrq);
				
				String  lxdh = teachersList.get(i).getLxdh();
				if(lxdh==null) teacher.setLxdh("");
				else  teacher.setLxdh(lxdh);
				
				String  email = teachersList.get(i).getEmail(); 
				if(email==null)  teacher.setEmail("");
				else  teacher.setEmail(email);
				
				String  zzmm = teachersList.get(i).getZzmmdm();
				if(zzmm!=null) teacher.setZzmmdm(zzmmService.findZzmmdmByDm(zzmm).getMc());
				else  teacher.setZzmmdm("");
				
				String dm = teachersList.get(i).getXydm();
				if(dm!=null){
					Xy   xy = xyService.findXyByXydm(dm);
					if(xy!=null)  teacher.setXydm(xy.getXymc());
					else{
						Dqjg dqjg = dqjgService.findDqjgBydm(dm);
						if(dqjg!=null) teacher.setXydm(dqjg.getMc());
						else{
							Xzjg xzjg = xzjgService.findXzjgBydm(dm);
							if(xzjg!=null) teacher.setXydm(xzjg.getMc());
							else{
								Shjg shjg = shjgService.findShjgBydm(dm);
								if(shjg!=null) teacher.setXydm(shjg.getMc());
								else teacher.setXydm("");
							}
						}
					}
				}else teacher.setXydm("");
				
				if(teachersList.get(i).getXdm()==null)  teacher.setXdm("");
				else   teacher.setXdm(xService.findXByXdm(teachersList.get(i).getXdm()).getXmc());
				
				String byxx = teachersList.get(i).getByxxdm();
				if(byxx==null) teacher.setByxxdm("");
				else 	teacher.setByxxdm(xxService.findXxByXxdm(byxx).getMc());
				
				String byzy = teachersList.get(i).getByzydm();
				if(byzy==null) teacher.setByzydm("");
				else    teacher.setByzydm(yzbzzyService.findZyByZydm(byzy).getZymc());
				
				String xl = teachersList.get(i).getXldm();
				if(xl==null)  teacher.setXldm("");
				else	teacher.setXldm(xlService.findXlByXldm(xl).getCm());
				
				String xw = teachersList.get(i).getXwdm();
				if(xw==null)  teacher.setXwdm("");
				else 	teacher.setXwdm(xwService.findXwByXwdm(xw).getMc());
				
				String zc = teachersList.get(i).getZcdm();
				if(zc==null) teacher.setZcdm("");
				else   teacher.setZcdm(zcService.findZcByZcdm(zc).getMc());
				
				String  zw =teachersList.get(i).getZw();
				if(zw==null) teacher.setZw("");
				else teacher.setZw(zw);
				
				String  xkfx = teachersList.get(i).getXkfx();
				if(xkfx==null) teacher.setXkfx("");
				else   teacher.setXkfx(xkfx);
				
				String  sfzh = teachersList.get(i).getSfzh();
				if(sfzh==null) teacher.setSfzh("");
				else  teacher.setSfzh(sfzh);
				
				String jszgzh = teachersList.get(i).getJszgzh();
				if(jszgzh==null) teacher.setJszgzh("");
				else  teacher.setJszgzh(jszgzh);
				
				teacher.setJsjj(teachersList.get(i).getJsjj());
				
				String  zjjszgzh = teachersList.get(i).getZjjszgzh();
				if(zjjszgzh==null) teacher.setZjjszgzh("");
				else 	teacher.setZjjszgzh(zjjszgzh);
				
				String  jxzlpj  = teachersList.get(i).getJxzlpj();
				if(jxzlpj==null) teacher.setJxzlpj("");
				else  teacher.setJxzlpj(jxzlpj);
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
	public void setDqjgService(DqjgService dqjgService) {
		this.dqjgService = dqjgService;
	}
	public void setXzjgService(XzjgService xzjgService) {
		this.xzjgService = xzjgService;
	}
	public void setShjgService(ShjgService shjgService) {
		this.shjgService = shjgService;
	}
	public void setCreateNumberService(CreateNumberService createNumberService) {
		this.createNumberService = createNumberService;
	}
	
/*	public String getAllTeachers() {
		List<Teacher> teacherList = teacherService.getAllTeacher();
		JSONArray json = JSONArray.fromObject(teacherList);
		try {
			ServletActionContext.getResponse().getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}*/
}
