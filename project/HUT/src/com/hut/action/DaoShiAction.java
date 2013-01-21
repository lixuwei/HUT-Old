package com.hut.action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.hut.domain.Dsxx;
import com.hut.domain.UserRole;
import com.hut.domain.vo.DsxxVo;
import com.hut.service.DsxxService;
import com.hut.service.TeacherService;
import com.hut.service.UserRoleService;
import com.hut.service.YzbzzyService;
import com.hut.service.ZjlbService;
import com.hut.service.ZzmmService;
import com.hut.util.ExcelReader;
import com.opensymphony.xwork2.ActionSupport;

public class DaoShiAction extends ActionSupport{
	private UserRoleService userRoleService;  private TeacherService teacherService;
	private DsxxService dsxxService;          private ZzmmService zzmmService;
	private ZjlbService zjlbService;          private YzbzzyService yzbzzyService;
	
	/*导入导师数据  代码段开始	*/
	private File upload;
	private String uploadFileName;
	
	private int successCount = 0;
	private int updateCount = 0;
	private int failCount = 0;
	private boolean success = true;

	public String insertData(){
		ExcelReader excelReader = new ExcelReader();
		List<ArrayList<String>> data = excelReader.read(upload, uploadFileName);
			for(int i=1; i<data.size(); i++) {
				ArrayList<String> arrayList = (ArrayList<String>)data.get(i);
				Dsxx  tDsxx = new Dsxx();
				tDsxx.setLsbh(teacherService.findBysfz(arrayList.get(26)));
				tDsxx.setZyxkyjxkm(yzbzzyService.findZyByZymc(arrayList.get(0)).getZydm());
				tDsxx.setZyxkejxkm(yzbzzyService.findZyByZymc(arrayList.get(1)).getZydm());
				tDsxx.setZyxkzdbs((int)Double.parseDouble(arrayList.get(2)));
				tDsxx.setZybszps((int)Double.parseDouble(arrayList.get(3)));
				tDsxx.setZyxkzdss((int)Double.parseDouble(arrayList.get(4)));
				tDsxx.setZysszps((int)Double.parseDouble(arrayList.get(5)));
				tDsxx.setDexkyjxkm(yzbzzyService.findZyByZymc(arrayList.get(6)).getZydm());
				tDsxx.setDexkejxkm(yzbzzyService.findZyByZymc(arrayList.get(7)).getZydm());
				tDsxx.setDexkzdbs((int)Double.parseDouble(arrayList.get(8)));
				tDsxx.setDebszps((int)Double.parseDouble(arrayList.get(9)));
				tDsxx.setDexkzdss((int)Double.parseDouble(arrayList.get(10)));
				tDsxx.setDesszps((int)Double.parseDouble(arrayList.get(11)));
				tDsxx.setYjfx(arrayList.get(12));
				int zgxl =0;
				if(arrayList.get(13).equals("本科")){
					zgxl  = 1;
				}else if (arrayList.get(13).equals("研究生")) {
					zgxl = 2;
				}else if (arrayList.get(13).equals("博士生")) {
					zgxl = 3;
				}else {
					zgxl = 4;
				}
				tDsxx.setZgxl(zgxl);
				tDsxx.setZgxlsj(arrayList.get(14));
				int zgxw = 0;
				if(arrayList.get(15).equals("博士")){
					zgxw = 1;
				}else if(arrayList.get(15).equals("硕士")){
					zgxw = 2;
				}else if(arrayList.get(15).equals("学士")){
					zgxw = 3;
				}else {
					zgxw = 4;
				}
				tDsxx.setZgxw(zgxw);
				tDsxx.setZgxwsj(arrayList.get(16));
				int zyjszw =0;
				if(arrayList.get(17).equals("正高职")){
					zyjszw = 1;
				}else if (arrayList.get(17).equals("副高职")) {
					zyjszw = 2;
				}else if (arrayList.get(17).equals("中级")) {
					zyjszw = 3;
				}
				tDsxx.setZyjszw(zyjszw);
				int dslb = 0;
				if(arrayList.get(18).equals("博士生导师")){
					dslb = 1;
				}else if (arrayList.get(18).equals("硕士生导师")) {
					dslb = 2;
				}else {
					dslb = 9;
				}
				tDsxx.setDslb(dslb);
				tDsxx.setScrsdsj(arrayList.get(19));
				tDsxx.setScrbdsj(arrayList.get(20));
				tDsxx.setZjlbdm(zjlbService.findZjlbBymc(arrayList.get(21)).getDm());
				tDsxx.setWymc(arrayList.get(22));
				int  wyslcd =0;
				if(arrayList.get(23).equals("精通")){
					wyslcd = 1;
				}else if (arrayList.get(23).equals("熟练")) {
					wyslcd = 2;
				}else if (arrayList.get(23).equals("良好")){
					wyslcd = 3;
				}
				tDsxx.setWyslcd(wyslcd);
				int  jzbsds = 0;
				if(arrayList.get(24).equals("是")){
					jzbsds = 1;
				}else {
					jzbsds = 0;
				}
				tDsxx.setJzbsds(jzbsds);
				tDsxx.setJzdwmc(arrayList.get(25));
				tDsxx.setZydm(yzbzzyService.findZyByZymc(arrayList.get(27)).getZydm());
				
				Dsxx dsxx= new Dsxx();
				dsxx =dsxxService.findDsxxByLsbh(tDsxx.getLsbh());
				UserRole userRole = new UserRole();
				userRole.setRoleId(3);
				userRole.setUsername(tDsxx.getLsbh());
				if(dsxx==null){
					dsxxService.addDsData(tDsxx);
					userRoleService.addObject(userRole);
					successCount++;
				}else {
					tDsxx.setLsbh(dsxx.getLsbh());
					dsxxService.modifyDs(tDsxx);
					updateCount++;
				}
		}
		return SUCCESS;
	}
	
	@JSON(serialize=false)
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	@JSON(serialize=false)
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
	/*导入老师数据  代码段结束	*/
	
	
	
	/*显示导师的所有数据  代码段开始*/
	//一些基本属性
	private List<DsxxVo> items = null;
	private int results=0;
	private int limit=0;
	private int start=0;
	private int page=0;
	public List<DsxxVo> getItems() {
		return items;
	}
	public void setItems(List<DsxxVo> items) {
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

	public String  showAllDS(){
		List<Dsxx> dsList = dsxxService.getAllDS();
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
		this.results = dsList.size();
		items = new ArrayList<DsxxVo>();
		if((results-(page-1)*limit)<limit){
			temp1=start+(results-(page-1)*limit);
		}else {
			temp1=start+limit;
		}
		for (int i = start; i < temp1; i++) {
			DsxxVo tDsxx = new DsxxVo();
			tDsxx.setLsbh(dsList.get(i).getLsbh());
			tDsxx.setXm(dsxxService.getDSName(dsList.get(i).getLsbh()));
			tDsxx.setZyxkyjxkm(dsList.get(i).getZyxkyjxkm());
			tDsxx.setZyxkejxkm(dsList.get(i).getZyxkejxkm());
			tDsxx.setZyxkzdbs(dsList.get(i).getZyxkzdbs());
			tDsxx.setZybszps(dsList.get(i).getZybszps());
			tDsxx.setZyxkzdss(dsList.get(i).getZyxkzdss());
			tDsxx.setZysszps(dsList.get(i).getZysszps());
			tDsxx.setDexkyjxkm(yzbzzyService.findDexkyjxkByZydm(dsList.get(i).getDexkyjxkm()).getZymc());
			tDsxx.setDexkejxkm(yzbzzyService.findDexkyjxkByZydm(dsList.get(i).getDexkejxkm()).getZymc());
			tDsxx.setZydm(yzbzzyService.findZyByZydm(dsList.get(i).getZydm()).getZymc());
			tDsxx.setZyxkejxkm(yzbzzyService.findDexkyjxkByZydm(dsList.get(i).getZyxkejxkm()).getZymc());
			tDsxx.setZyxkyjxkm(yzbzzyService.findDexkyjxkByZydm(dsList.get(i).getZyxkyjxkm()).getZymc());
			tDsxx.setDexkzdbs(dsList.get(i).getDexkzdbs());
			tDsxx.setDebszps(dsList.get(i).getDebszps());
			tDsxx.setDexkzdss(dsList.get(i).getDexkzdss());
			tDsxx.setDesszps(dsList.get(i).getDesszps());
			tDsxx.setYjfx(dsList.get(i).getYjfx());
			int  zgxl = dsList.get(i).getZgxl();
			if(zgxl==1){
				tDsxx.setZgxl("本科");
			}else if (zgxl==2) {
				tDsxx.setZgxl("研究生");
			}else if (zgxl==3) {
				tDsxx.setZgxl("博士生");
			}else {
				tDsxx.setZgxl("其他");
			}
			tDsxx.setZgxlsj(dsList.get(i).getZgxlsj());
			
			int zgxw = dsList.get(i).getZgxw();
			if(zgxw==1){
				tDsxx.setZgxw("博士");
			}else if (zgxw==2) {
				tDsxx.setZgxw("硕士");
			}else if (zgxw==3) {
				tDsxx.setZgxw("学士");
			}else {
				tDsxx.setZgxw("其他");
			}
			
			tDsxx.setZgxwsj(dsList.get(i).getZgxwsj());
			
			int zyjszw = dsList.get(i).getZyjszw();
			if(zyjszw==1){
				tDsxx.setZyjszw("正高职");
			}else if (zyjszw==2) {
				tDsxx.setZyjszw("副高职");
			}else {
				tDsxx.setZyjszw("中级");
			}
			
			int dslb = dsList.get(i).getDslb();
			if(dslb==1){
				tDsxx.setDslb("博士生导师");
			}else if (dslb==2) {
				tDsxx.setDslb("硕士生导师");
			}else {
				tDsxx.setDslb("其他");
			}
			tDsxx.setScrsdsj(dsList.get(i).getScrsdsj());
			tDsxx.setScrbdsj(dsList.get(i).getScrbdsj());
			tDsxx.setZjlbdm(zjlbService.findZjlbBydm(dsList.get(i).getZjlbdm()).getMc());
			tDsxx.setWymc(dsList.get(i).getWymc());
			
			int wyslcd = dsList.get(i).getWyslcd();
			if(wyslcd==1){
				tDsxx.setWyslcd("精通");
			}else if (wyslcd==2) {
				tDsxx.setWyslcd("熟悉");
			}else {
				tDsxx.setWyslcd("良好");
			}
			
			int  jzbsds = dsList.get(i).getJzbsds();
			if(jzbsds==1){
				tDsxx.setJzbsds("是");
			}else {
				tDsxx.setJzbsds("否");
			}
			tDsxx.setJzdwmc(dsList.get(i).getJzdwmc());
			items.add(tDsxx);
		}
		return SUCCESS;
	}
	
	/*显示导师的所有数据  代码段结束***/
	
	public void setDsxxService(DsxxService dsxxService) {
		this.dsxxService = dsxxService;
	}
	public void setZzmmService(ZzmmService zzmmService) {
		this.zzmmService = zzmmService;
	}
	public void setYzbzzyService(YzbzzyService yzbzzyService) {
		this.yzbzzyService = yzbzzyService;
	}
	public void setZjlbService(ZjlbService zjlbService) {
		this.zjlbService = zjlbService;
	}
	public void setUserRoleService(UserRoleService userRoleService) {
		this.userRoleService = userRoleService;
	}
	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}
	
}


