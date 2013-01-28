package com.hut.action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.hut.domain.Dqjg;
import com.hut.domain.Dsxx;
import com.hut.domain.Mz;
import com.hut.domain.Shjg;
import com.hut.domain.Teacher;
import com.hut.domain.User;
import com.hut.domain.UserRole;
import com.hut.domain.Xw;
import com.hut.domain.Xy;
import com.hut.domain.Xzjg;
import com.hut.domain.Yjdw;
import com.hut.domain.Yzbzzy;
import com.hut.domain.Zjlb;
import com.hut.domain.Zzmm;
import com.hut.domain.vo.DsxxVo;
import com.hut.service.CreateNumberService;
import com.hut.service.DqjgService;
import com.hut.service.DsxxService;
import com.hut.service.MzService;
import com.hut.service.ShjgService;
import com.hut.service.TeacherService;
import com.hut.service.UserRoleService;
import com.hut.service.UserService;
import com.hut.service.XlService;
import com.hut.service.XwService;
import com.hut.service.XyService;
import com.hut.service.XzjgService;
import com.hut.service.YjdwService;
import com.hut.service.YzbzzyService;
import com.hut.service.ZcService;
import com.hut.service.ZjlbService;
import com.hut.service.ZzmmService;
import com.hut.util.ExcelReader;
import com.hut.util.MD5;
import com.opensymphony.xwork2.ActionSupport;

public class DaoShiAction extends ActionSupport{
	private UserRoleService userRoleService;  private TeacherService teacherService;
	private DsxxService dsxxService;          private ZzmmService zzmmService;
	private ZjlbService zjlbService;          private YzbzzyService yzbzzyService;
	private YjdwService yjdwService;          private MzService  mzService;
	private XyService   xyService ;           private DqjgService dqjgService;
	private XzjgService xzjgService;          private ShjgService shjgService;
	private CreateNumberService createNumberService;   
	private XwService   xwService;            private XlService  xlService;
	private UserService userService;          private ZcService  zcService;
	
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
				
				/*对已有的导师数据,如果导师也是老师，老师编号就是导师编号，否则重新编号		*/
				String  sfzhm = arrayList.get(7);
				Teacher teacher = teacherService.findBySfzhm(sfzhm);
				if(teacher!=null)	tDsxx.setLsbh(teacher.getLsbh());
				else  tDsxx.setLsbh(createNumberService.createNumber(arrayList.get(0), arrayList.get(8)));
				
				//在编或外聘
				String  xnxw = arrayList.get(0);
				if("在编".equals(xnxw)) tDsxx.setXnxw(1);
				else tDsxx.setXnxw(2);
				
				//姓名
				tDsxx.setXm(arrayList.get(1));
				//单位名称
				Yjdw  yjdw = yjdwService.findYjdwBymc(arrayList.get(2));
				if(yjdw!=null) tDsxx.setDwdm(yjdw.getDwdm());
				else  tDsxx.setDwdm(null);
				//性别
				String xb = arrayList.get(3);
				if("男".equals(xb)) tDsxx.setXb(1);
				else  tDsxx.setXb(0);
				//出生年月
				tDsxx.setCsny(arrayList.get(4));
				//民族
				Mz  mz = mzService.findMzdmByMzmc(arrayList.get(5));
				if(mz!=null) tDsxx.setMz(mz.getDm());
				else  tDsxx.setMz(null);
				//政治身份
				Zzmm  zzmm  = zzmmService.findZzmmdmByMc(arrayList.get(6));
				if(zzmm!=null) tDsxx.setZzmm(zzmm.getDm());
				else  tDsxx.setZzmm(null);
				//身份证号码
				tDsxx.setSfzhm(arrayList.get(7));
				/*处理导师所在部门		代码段开始	*/
				String mc =arrayList.get(8);
				Xy   xy = xyService.findXyByXymc(mc);
				if(xy!=null)  tDsxx.setSzbm(xy.getDm());
				else{
					Dqjg dqjg = dqjgService.findDqjgBymc(mc);
					if(dqjg!=null) tDsxx.setSzbm(dqjg.getDm());
					else {
						Xzjg xzjg = xzjgService.findXzjgBymc(mc);
						if(xzjg!=null) tDsxx.setSzbm(xzjg.getDm());
						else {
							Shjg shjg = shjgService.findShjgBymc(mc);
							if(shjg!=null) tDsxx.setSzbm(shjg.getDm());
							else  tDsxx.setSzbm(null);
						}
					}
				}
				/*处理导师所在部门		代码段结束	*/
				//行政职务
				String    xzzw = arrayList.get(9);
 				if("无".equals(xzzw)) tDsxx.setXzzw(null);
 				else  tDsxx.setXzzw(xzzw);
 				//主研学科一级学科名称
 				Yzbzzy  yzbzzy  =  yzbzzyService.findZyByYjxkmc(arrayList.get(10));
				if(yzbzzy!=null)  tDsxx.setZyxkyjxkm(yzbzzy.getYjxkdm());
				else tDsxx.setZyxkyjxkm(null);
				//主研学科二级学科名称
				yzbzzy = yzbzzyService.findZyByZymc(arrayList.get(11));
				if(yzbzzy!=null)  tDsxx.setZyxkejxkm(yzbzzy.getZydm());
				else tDsxx.setZyxkyjxkm(null);
				
				tDsxx.setZyxkzdbs((int)Double.parseDouble(arrayList.get(12)));
				tDsxx.setZybszps((int)Double.parseDouble(arrayList.get(13)));
				tDsxx.setZyxkzdss((int)Double.parseDouble(arrayList.get(14)));
				tDsxx.setZysszps((int)Double.parseDouble(arrayList.get(15)));
				//第二学科一级学科名称
				yzbzzy = yzbzzyService.findZyByYjxkmc(arrayList.get(16));
				if(yzbzzy!=null)  	tDsxx.setDexkyjxkm(yzbzzy.getYjxkdm());
				else     tDsxx.setDexkyjxkm(null);
				//第二学科二级学科名称
				yzbzzy  = yzbzzyService.findZyByZymc(arrayList.get(17));
				if(yzbzzy!=null) 	tDsxx.setDexkejxkm(yzbzzy.getZydm());
				else     tDsxx.setDexkejxkm(null);
				
				tDsxx.setDexkzdbs((int)Double.parseDouble(arrayList.get(18)));
				tDsxx.setDebszps((int)Double.parseDouble(arrayList.get(19)));
				tDsxx.setDexkzdss((int)Double.parseDouble(arrayList.get(20)));
				tDsxx.setDesszps((int)Double.parseDouble(arrayList.get(21)));
				//研究方向
				String yjfx = arrayList.get(22);
				if("无".equals(yjfx))  tDsxx.setYjfx(null);
				else tDsxx.setYjfx(yjfx);
				//专业代码
				yzbzzy = yzbzzyService.findZyByZymc(arrayList.get(23));
				if(yzbzzy!=null)   tDsxx.setZydm(yzbzzy.getZydm());
				else     tDsxx.setZydm(null);
				//最高学历
				String xlmc = arrayList.get(24);
				if("无".equals(xlmc))  tDsxx.setZgxl(0);
				else   tDsxx.setZgxl(Integer.parseInt(xlService.findXlByXlmc(xlmc).getDm()));
				//最高学历获得时间
				String zgxlsj  = arrayList.get(25);
				if("无".equals(zgxlsj)) tDsxx.setZgxlsj(null);
				else tDsxx.setZgxlsj(zgxlsj);
				//最高学位
				String zgxwmc =  arrayList.get(26);
				Xw xw = xwService.findXwByXwmc(zgxwmc);
				if(xw!=null)  tDsxx.setZgxw(xw.getDm());
				else tDsxx.setZgxw(null);
				//最高学位获得时间
				if("无".equals(arrayList.get(27))) tDsxx.setZgxwsj(null);
				else tDsxx.setZgxwsj(arrayList.get(27));
				
				//职称
				if("无".equals(arrayList.get(28))) tDsxx.setZyjszw(null);
				else tDsxx.setZyjszw(zcService.findZcByZcmc(arrayList.get(28)).getDm());
				
				//导师类型
				int dslb = 0;
				if(arrayList.get(29).equals("博士生导师")){
					dslb = 1;
				}else if (arrayList.get(29).equals("硕士生导师")) {
					dslb = 2;
				}else {
					dslb = 9;
				}
				tDsxx.setDslb(dslb);
				//首次任导师的时间
				tDsxx.setScrsdsj(arrayList.get(30));
				//首次任博导时间
				tDsxx.setScrbdsj(arrayList.get(31));
				//专家类别代码
				Zjlb zjlb = zjlbService.findZjlbBymc(arrayList.get(32));
				if(zjlb!=null)  tDsxx.setZjlbdm(zjlb.getDm());
				else    tDsxx.setZjlbdm(null);
				//外语名称
				String wymc = arrayList.get(33);
				if("无".equals(wymc))  tDsxx.setWymc(null);
				else tDsxx.setWymc(wymc);
				//外语熟练程度
				int  wyslcd =0;
				if(arrayList.get(34).equals("精通")){
					wyslcd = 1;
				}else if (arrayList.get(34).equals("熟悉")) {
					wyslcd = 2;
				}else if (arrayList.get(34).equals("良好")){
					wyslcd = 3;
				}
				tDsxx.setWyslcd(wyslcd);
				//是否兼职
				int  jzbsds = 0;
				if(arrayList.get(35).equals("是")){
					jzbsds = 1;
				}
				tDsxx.setJzbsds(jzbsds);
				//兼职单位名称
				String jzdwmc = arrayList.get(36);
				if("无".equals(jzdwmc)) tDsxx.setJzdwmc(null);
				else tDsxx.setJzdwmc(jzdwmc);
				//通讯地址
 				String    txdz  = arrayList.get(37);
 				if("无".equals(txdz)) tDsxx.setTxdz(null);
 				else  tDsxx.setTxdz(txdz);
 				//邮政编码
				String    yzbm  = arrayList.get(38);
				if("无".equals(yzbm)) tDsxx.setYzbm(null);
				else   tDsxx.setYzbm(yzbm);
				//办公电话
				String   bgdh   =  arrayList.get(39);
				if("无".equals(bgdh)) tDsxx.setBgdh(null);
				else   tDsxx.setBgdh(bgdh);
				//住宅电话
				String   zzdh  = arrayList.get(40);
				if("无".equals(zzdh))  tDsxx.setZzdh(null);
				else   tDsxx.setZzdh(zzdh);
				//移动电话
				String   yddh  = arrayList.get(41);
				if("无".equals(yddh))  tDsxx.setYddh(null);
				else    tDsxx.setYddh(yddh);
				//电子信箱
				String   dzxx  = arrayList.get(42);
				if("无".equals(dzxx))  tDsxx.setDzxx(null);
				else    tDsxx.setDzxx(dzxx);
				//传真电话
				String   czdh =  arrayList.get(43);
				if("无".equals(czdh))  tDsxx.setCzdh(null);
				else     tDsxx.setCzdh(czdh);
				
				
				Dsxx dsxx = dsxxService.findDsxxByLsbh(tDsxx.getLsbh());
				
				User  user = new User();
				User  user2 = userService.findUserByLsbh(tDsxx.getLsbh());
				if(user2==null){
					user.setUserName(tDsxx.getLsbh());
					user.setPassword(MD5.toMD5(tDsxx.getSfzhm().substring(tDsxx.getSfzhm().length()-6, tDsxx.getSfzhm().length())));
					user.setEmail(tDsxx.getDzxx());
					user.setTel(tDsxx.getYddh());
				}
				UserRole userRole = new UserRole();
				userRole.setRoleId(3);
				userRole.setUsername(tDsxx.getLsbh());
				if(dsxx==null){
					dsxxService.addDsData(tDsxx);
					userService.addObject(user);
					userRoleService.addObject(userRole);
					successCount++;
				}else {
					tDsxx.setLsbh(dsxx.getLsbh());
					dsxxService.modifyDs(tDsxx);
					userService.addObject(user);
					userRoleService.addObject(userRole);
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
			int xnxw = dsList.get(i).getXnxw();
			if(xnxw==1)	tDsxx.setXnxw("在编");
			else  tDsxx.setXnxw("外聘");
			tDsxx.setLsbh(dsList.get(i).getLsbh());
			tDsxx.setXm(dsList.get(i).getXm());
			
			String  dwdm = dsList.get(i).getDwdm(); 
			if(dwdm==null) 	tDsxx.setDwmc("");
			else tDsxx.setDwmc(yjdwService.findYjdwBydm(dwdm).getDwmc());
			
			if(dsList.get(i).getXb()==1)  tDsxx.setXb("男");
			else tDsxx.setXb("女");
			tDsxx.setCsny(dsList.get(i).getCsny());
			
			String string = dsList.get(i).getMz();
			if(string!=null)	tDsxx.setMz(mzService.findMzByMzdm(string).getMc());
			else  tDsxx.setMz("");
			
			string   = dsList.get(i).getZzmm();
			if(string!=null)    tDsxx.setZzmm(zzmmService.findZzmmdmByDm(string).getMc());
			else  tDsxx.setZzmm("");
			
			tDsxx.setSfzhm(dsList.get(i).getSfzhm());
			//导师所在的部门
			String dm = dsList.get(i).getSzbm();
				if(dm!=null){
				Xy   xy = xyService.findXyByXydm(dm);
				if(xy!=null)  tDsxx.setSzbm(xy.getXymc());
				else{
					Dqjg dqjg = dqjgService.findDqjgBydm(dm);
					if(dqjg!=null) tDsxx.setSzbm(dqjg.getMc());
					else{
						Xzjg xzjg = xzjgService.findXzjgBydm(dm);
						if(xzjg!=null) tDsxx.setSzbm(xzjg.getMc());
						else{
							Shjg shjg = shjgService.findShjgBydm(dm);
							if(shjg!=null) tDsxx.setSzbm(shjg.getMc());
							else tDsxx.setSzbm("");
						}
					}
				}
			}else tDsxx.setSzbm("");
			
			string = dsList.get(i).getXzzw(); 
			if(string!=null)  tDsxx.setXzzw(string);
			else tDsxx.setXzzw("");
		
			string = dsList.get(i).getZyxkyjxkm();
			if(string!=null) tDsxx.setZyxkyjxkm(yzbzzyService.findYjxkmByZydm(string).getYjxkmc());
			else  tDsxx.setZyxkyjxkm("");
			string = dsList.get(i).getZyxkejxkm();
			if(string!=null) tDsxx.setZyxkejxkm(yzbzzyService.findZyByZydm(string).getZymc());
			else  tDsxx.setZyxkejxkm("");
			
			tDsxx.setZyxkzdbs(dsList.get(i).getZyxkzdbs());
			tDsxx.setZybszps(dsList.get(i).getZybszps());
			tDsxx.setZyxkzdss(dsList.get(i).getZyxkzdss());
			tDsxx.setZysszps(dsList.get(i).getZysszps());
			
			String   yzbzzy = dsList.get(i).getDexkyjxkm();
			if(yzbzzy!=null) tDsxx.setDexkyjxkm(yzbzzyService.findYjxkmByZydm(yzbzzy).getZymc());
			else tDsxx.setDexkyjxkm("");
			
			yzbzzy = dsList.get(i).getDexkejxkm();
			if(yzbzzy!=null) tDsxx.setDexkejxkm(yzbzzyService.findZyByZydm(yzbzzy).getZymc());
			else   tDsxx.setDexkejxkm("");
			
			tDsxx.setDexkzdbs(dsList.get(i).getDexkzdbs());
			tDsxx.setDebszps(dsList.get(i).getDebszps());
			tDsxx.setDexkzdss(dsList.get(i).getDexkzdss());
			tDsxx.setDesszps(dsList.get(i).getDesszps());
			
			yzbzzy = dsList.get(i).getZydm();
			if(yzbzzy!=null) tDsxx.setZydm(yzbzzyService.findZyByZydm(yzbzzy).getZymc());
			else  tDsxx.setZydm("");
			
			string = dsList.get(i).getYjfx();
			if(string!=null) tDsxx.setYjfx(string);
			else  tDsxx.setYjfx("");
			
			int  zgxl = dsList.get(i).getZgxl();
			if(zgxl==0) tDsxx.setZgxl("");
			else    tDsxx.setZgxl(xlService.findXlByXldm(String.valueOf(zgxl)).getCm());
				
			string  = dsList.get(i).getZgxlsj();
			if(string!=null)  tDsxx.setZgxlsj(string);
			else tDsxx.setZgxlsj("");
			
			String zgxw =dsList.get(i).getZgxw();
			if(zgxw==null) tDsxx.setZgxw("");
			else tDsxx.setZgxw(xwService.findXwByXwdm(zgxw).getMc());
			
			tDsxx.setZgxwsj(dsList.get(i).getZgxwsj());
			
			//职称
			String zyjszw = dsList.get(i).getZyjszw();
			if(zyjszw==null) tDsxx.setZyjszw("");
			else  tDsxx.setZyjszw(zcService.findZcByZcdm(zyjszw).getMc());
			
			int dslb = dsList.get(i).getDslb();
			if(dslb==1){
				tDsxx.setDslb("博士生导师");
			}else if (dslb==2) {
				tDsxx.setDslb("硕士生导师");
			}else {
				tDsxx.setDslb("其他");
			}
			
			string = dsList.get(i).getScrsdsj();
			if(string!=null) tDsxx.setScrsdsj(string);
			else   tDsxx.setScrsdsj("");
			string = dsList.get(i).getScrbdsj();
			if(string!=null) tDsxx.setScrbdsj(string);
			else   tDsxx.setScrbdsj("");
			
			String   zjlb = dsList.get(i).getZjlbdm();
			if(zjlb!=null) 	tDsxx.setZjlbdm(zjlbService.findZjlbBydm(zjlb).getMc());
			else  tDsxx.setZjlbdm("");
			string  = dsList.get(i).getWymc();
			if(string!=null) tDsxx.setWymc(string);
			else  tDsxx.setWymc("");
			
			int wyslcd = dsList.get(i).getWyslcd();
			if(wyslcd==1){
				tDsxx.setWyslcd("精通");
			}else if (wyslcd==2) {
				tDsxx.setWyslcd("熟悉");
			}else if(wyslcd==0){
				tDsxx.setWyslcd("");
			}else {
				tDsxx.setWyslcd("良好");
			}
			
			int  jzbsds = dsList.get(i).getJzbsds();
			if(jzbsds==1){
				tDsxx.setJzbsds("是");
			}else {
				tDsxx.setJzbsds("否");
			}
			string = dsList.get(i).getJzdwmc();
			if(string!=null)  	tDsxx.setJzdwmc(string);
			else tDsxx.setJzdwmc("");
			
			string = dsList.get(i).getTxdz();
			if(string!=null)    tDsxx.setTxdz(string);
			else tDsxx.setTxdz("");
			
			string = dsList.get(i).getYzbm();
			if(string!=null)    tDsxx.setYzbm(string);
			else tDsxx.setYzbm("");
			
			string  = dsList.get(i).getBgdh();
			if(string!=null)    tDsxx.setBgdh(string);
			else tDsxx.setBgdh("");
			
			string  = dsList.get(i).getZzdh();
			if(string!=null)    tDsxx.setZzdh(string);
			else tDsxx.setZzdh("");
			
			string  = dsList.get(i).getYddh();
			if(string!=null)    tDsxx.setYddh(string);
			else tDsxx.setYddh("");
			
			string  = dsList.get(i).getDzxx();
			if(string!=null)    tDsxx.setDzxx(string);
			else tDsxx.setDzxx("");
			
			string  = dsList.get(i).getCzdh();
			if(string!=null)    tDsxx.setCzdh(string);
			else tDsxx.setCzdh("");
			
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
	
	public void setYjdwService(YjdwService yjdwService) {
		this.yjdwService = yjdwService;
	}
	public void setMzService(MzService mzService) {
		this.mzService = mzService;
	}
	public void setXyService(XyService xyService) {
		this.xyService = xyService;
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
	public void setXwService(XwService xwService) {
		this.xwService = xwService;
	}
	public void setXlService(XlService xlService) {
		this.xlService = xlService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public void setZcService(ZcService zcService) {
		this.zcService = zcService;
	}
	
}


