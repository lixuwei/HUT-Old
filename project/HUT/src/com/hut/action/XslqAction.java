package com.hut.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.hut.domain.User;
import com.hut.domain.UserRole;
import com.hut.domain.Xs;
import com.hut.domain.Xslb;
import com.hut.domain.Xslq;
import com.hut.domain.Xsxjzc;
import com.hut.domain.Xsxl;
import com.hut.exception.DaoException;
import com.hut.service.UserRoleService;
import com.hut.service.UserService;
import com.hut.service.XsService;
import com.hut.service.XslbService;
import com.hut.service.XslqService;
import com.hut.service.XsxjzcService;
import com.hut.service.XsxlService;
import com.hut.util.ExcelReader;
import com.hut.util.MD5;
import com.opensymphony.xwork2.ActionSupport;

public class XslqAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private File upload;
	private String uploadFileName;
	private boolean success = true;
	private int xslx;
	private int year;
	private int successCount = 0;
	private int updateCount = 0;
	private int failCount = 0;
	private List<Object> items = null;
	private int results=0;
	private int limit=0;
	private int start=0;
	private int page;
	
	private XslqService xslqService;
	private XsService xsService;
	private XsxjzcService xsxjzcService;
	private XslbService xslbService;
	private XsxlService xsxlService;
	private UserService loginService;
	private UserRoleService userRoleService;
	
	// 导入录取信息表
	public String uploadXslq() {
		ExcelReader excelReader = new ExcelReader();
		List<ArrayList<String>> data = excelReader.read(upload, uploadFileName);
		if (xslx == 1) {
			for(int i=1; i<data.size(); i++) {
				ArrayList<String> arrayList = (ArrayList<String>)data.get(i);
				Xslq xslq = new Xslq();
				xslq.setKsbh(arrayList.get(0));
				xslq.setZjlx(arrayList.get(1));
				xslq.setZjhm(arrayList.get(2));
				xslq.setXm(arrayList.get(3));
				xslq.setCsrq(arrayList.get(4));
				xslq.setMzm(arrayList.get(5));
				xslq.setXbm(Integer.parseInt(arrayList.get(6)));
				xslq.setHfm(Integer.parseInt(arrayList.get(7)));
				//xslq.setLxdh("");
				xslq.setXyjrm(arrayList.get(8));
				xslq.setZzmmm(arrayList.get(9));
				xslq.setHkszdm(Integer.parseInt(arrayList.get(10)));
				xslq.setHkszdxxdz(arrayList.get(11));
				xslq.setLqdwdm(Integer.parseInt(arrayList.get(12)));
				xslq.setLqdwmc(arrayList.get(13));
				xslq.setLqyxsm(arrayList.get(14));
				xslq.setLqzydm(arrayList.get(15));
				xslq.setLqzymc(arrayList.get(16));
				xslq.setBydwm(arrayList.get(17));
				xslq.setBydwmc(arrayList.get(18));
				xslq.setByzydm(arrayList.get(19));
				xslq.setByzymc(arrayList.get(20));
				xslq.setByny(arrayList.get(21));
				xslq.setXlm(arrayList.get(22));
				xslq.setXlzsbh(arrayList.get(23));
				xslq.setXxxsdm(Integer.parseInt(arrayList.get(24)));
				xslq.setXwm(arrayList.get(25));
				xslq.setXwzsbh(arrayList.get(26));
				xslq.setKslydm(Integer.parseInt(arrayList.get(27)));
				xslq.setKsfsdm(Integer.parseInt(arrayList.get(28)));
				xslq.setDaszdw(arrayList.get(29));
				xslq.setDaszdwdz(arrayList.get(30));
				xslq.setDaszdwyzbm(Integer.parseInt(arrayList.get(31)));
				xslq.setLqlbm((int)Double.parseDouble(arrayList.get(32)));
				xslq.setZzllm(Integer.parseInt(arrayList.get(33)));
				xslq.setZzllmc(arrayList.get(34));
				xslq.setWgym(Integer.parseInt(arrayList.get(35)));
				xslq.setWgymc(arrayList.get(36));
				xslq.setYwk1m(arrayList.get(37));
				xslq.setYwk1mc(arrayList.get(38));
				xslq.setYwk2m(arrayList.get(39));
				xslq.setYwk2mc(arrayList.get(40));
				xslq.setZzllcj(Double.parseDouble(arrayList.get(41)));
				xslq.setWgycj(Double.parseDouble(arrayList.get(42)));
				xslq.setYwk1cj(Double.parseDouble(arrayList.get(43)));
				xslq.setYwk2cj(Double.parseDouble(arrayList.get(44)));
				xslq.setZf(Double.parseDouble(arrayList.get(45)));
				xslq.setFscj(Double.parseDouble(arrayList.get(46)));
				xslq.setJs1mc(arrayList.get(47));
				xslq.setJs1cj(Double.parseDouble(arrayList.get(48)));
				xslq.setJs2mc(arrayList.get(49));
				xslq.setJs2cj(Double.parseDouble(arrayList.get(50)));
				xslq.setDxwpdw(arrayList.get(51));
				xslq.setDxwpdwszdm(arrayList.get(52));
				xslq.setBlzgnx(arrayList.get(53));
				xslq.setPg(arrayList.get(54));
				xslq.setZxjh(Integer.parseInt(arrayList.get(55)));
				xslq.setXszgzc(Integer.parseInt(arrayList.get(56)));
				xslq.setZcxh(arrayList.get(57));
				xslq.setSzssm(Integer.parseInt(arrayList.get(58)));
				xslq.setBz(arrayList.get(59));
				xslq.setFscjqz(Double.parseDouble(arrayList.get(60)));
				xslq.setNf(year);
				xslq.setXslxdm(xslx);
				
				Xslq temp = xslqService.findXslqBySfz(xslq.getZjhm());

				// 没有重复的数据,添加
				if (temp == null) {
					xslq.setFlag(0);
					xslqService.addXslq(xslq);
					successCount++;
				} else {
					xslq.setId(temp.getId());
					// 更新数据
					if (temp.getXslxdm() == xslq.getXslxdm()) {
						xslq.setFlag(temp.getFlag());
						xslqService.modifyXslq(xslq);
					} else {
						// 考虑到进修生成正式生的情况
						xslq.setFlag(0);
						xslqService.modifyXslq(xslq);
					}
					updateCount++;
				}
			}
		} else if(xslx == 2){
			for(int i=1; i<data.size(); i++) {
				ArrayList<String> arrayList = (ArrayList<String>)data.get(i);
				Xslq xslq = new Xslq();
				xslq.setKsbh(arrayList.get(0));
				xslq.setZjlx(arrayList.get(1));
				xslq.setZjhm(arrayList.get(2));
				xslq.setXm(arrayList.get(3));
				xslq.setCsrq(arrayList.get(4));
				xslq.setMzm(arrayList.get(5));
				xslq.setXbm(Integer.parseInt(arrayList.get(6)));
				xslq.setLqyxsm(arrayList.get(7));
				xslq.setLqzydm(arrayList.get(8));
				xslq.setLqzymc(arrayList.get(9));
				xslq.setXwm(arrayList.get(10));
				xslq.setNf(year);
				xslq.setXslxdm(xslx);
				
				Xslq temp = xslqService.findXslqBySfz(xslq.getZjhm());

				// 没有重复的数据,添加
				if (temp == null) {
					xslq.setFlag(0);
					xslqService.addXslq(xslq);
					successCount++;
				} else {
					xslq.setId(temp.getId());
					// 更新数据
					if (temp.getXslxdm() == xslq.getXslxdm()) {
						xslq.setFlag(temp.getFlag());
						xslqService.modifyXslq(xslq);
					}
					updateCount++;
				}
			}
		
		} else if(xslx == 3) {
			
		} else if(xslx == 4) {

			for(int i=1; i<data.size(); i++) {
				ArrayList<String> arrayList = (ArrayList<String>)data.get(i);
				Xslq xslq = new Xslq();
				xslq.setZjlx(arrayList.get(0));
				xslq.setZjhm(arrayList.get(1));
				xslq.setXm(arrayList.get(2));
				xslq.setCsrq(arrayList.get(3));
				xslq.setMzm(arrayList.get(4));
				xslq.setXbm(Integer.parseInt(arrayList.get(5)));
				xslq.setLqyxsm(arrayList.get(6));
				xslq.setLqzydm(arrayList.get(7));
				xslq.setLqzymc(arrayList.get(8));
				xslq.setNf(year);
				xslq.setXslxdm(xslx);
				
				Xslq temp = xslqService.findXslqBySfz(xslq.getZjhm());

				// 没有重复的数据,添加
				if (temp == null) {
					xslq.setFlag(0);
					xslqService.addXslq(xslq);
					successCount++;
				} else {
					xslq.setId(temp.getId());
					// 更新数据
					if (temp.getXslxdm() == xslq.getXslxdm()) {
						xslq.setFlag(temp.getFlag());
						xslqService.modifyXslq(xslq);
					}
					updateCount++;
				}
			}
		
		
		}
		return SUCCESS;
	}
	
	/*
	 * 编制学号
	 */
	private String formatXh(int sxlbm, int year, String zydm) {
		String XH;
		Xslb xslb = new Xslb(); 
		xslb = (Xslb)this.xslbService.findXslbByXslbdm(sxlbm);
		int count = xsService.findStuCount(year, zydm);
		NumberFormat format = NumberFormat.getInstance();
		format.setMinimumIntegerDigits(3);
		XH = xslb.getBz() + String.valueOf(year).substring(2) + String.valueOf(zydm) + format.format(count+1);
		return XH;
	}
	
	/*
	 * 学号编制同时将信息导入其他几个表
	 */
	public String addToOtherTable() {
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out;
		try {
			out = response.getWriter();
			List<Xslq> xslqList = new ArrayList<Xslq>();
			// 获取没有编制学号的
			xslqList = xslqService.getNoXhList();
			for(int i=0; i<xslqList.size(); i++) {
				Xslq xslq = new Xslq();
				xslq = xslqList.get(i);
				
				// 编制学号
				String XH = this.formatXh(xslq.getXslxdm(), xslq.getNf(), xslq.getLqzydm());
				System.out.println("学号="+XH);
				System.out.println("二级学科代码="+xslq.getLqzydm());

				User user = new User();
				Xs xs = new Xs();
				Xsxjzc xsxjzc = new Xsxjzc();
				Xsxl xsxl = new Xsxl();
				
				// 添加信息到用户登陆表
				user.setUserName(XH);
				user.setPassword(MD5.toMD5(xslq.getZjhm().substring(xslq.getZjhm().length()-6, xslq.getZjhm().length())));

				// 添加到用户角色表
				UserRole userRole = new UserRole();
				userRole.setUsername(XH);
				userRole.setRoleId(1);
				if (xslq.getXslxdm() == 1) {
					// 全日制硕士研究生
					Xs temp = new Xs();
					temp = xsService.findXsBySfz(xslq.getZjhm());
					if(temp == null) {
						// 添加的是一个完全新的数据
						// 添加到学生基础信息表
						xs.setXh(XH);
						xs.setXm(xslq.getXm());
						xs.setXbm(xslq.getXbm());
						xs.setZjlx(xslq.getZjlx());
						xs.setZjhm(xslq.getZjhm());
						xs.setMzm(xslq.getMzm());
						xs.setCsrq(xslq.getCsrq());
						xs.setHfm(xslq.getHfm());
						xs.setZzmmm(xslq.getZzmmm());
						xs.setXslb(1);
						xs.setXydm(xslq.getLqyxsm());
						xs.setXdm(null);
						xs.setPyccdm(null);
						xs.setLqlbm(xslq.getLqlbm());
						xs.setEjxkdm(xslq.getLqzydm());
						xs.setHdxlfsdm(null);
						xs.setXz1(3);
						xs.setXjztdm(1);
						xs.setNj(xslq.getNf());
						
						// 学生学籍表
						xsxjzc.setXh(XH);
						xsxjzc.setZczt("保留入学资格");
						xsxjzc.setXm(xslq.getXm());
						xsxjzc.setXbm(xslq.getXbm());
						xsxjzc.setCsrq(xslq.getCsrq());
						xsxjzc.setSfzh(xslq.getZjhm());
						xsxjzc.setZzmmm(xslq.getZzmmm());
						xsxjzc.setMzm(xslq.getMzm());
						xsxjzc.setEjxkdm(xslq.getLqzydm());
						xsxjzc.setXydm(xslq.getLqyxsm());
						xsxjzc.setFlag(1);
						
						// 学生学历表
						xsxl.setXh(XH);
						xsxl.setXm(xslq.getXm());
						xsxl.setXbm(xslq.getXbm());
						xsxl.setCsrq(xslq.getCsrq());
						xsxl.setYxdm(xslq.getLqyxsm());
						xsxl.setEjxkdm(xslq.getLqzydm());
						xsxl.setXxxsdm(xslq.getXxxsdm());
						xsxl.setPyccdm(null);
						xsxl.setXwdm(xslq.getXwm());
						xsxl.setXldm(xslq.getXlm());
					} else if(temp.getXslb() != 4) {
						// 如果是进修生.....
						// 先添加这个数据  并将以前数据删除 同时将成绩表的学号改为这个学号
					} else if (temp.getXslb() == 1) {
						// 添加重复的
						continue;
					} 
				} else if(xslq.getXslxdm() == 2){
					//非全日制硕士研究生
					xs.setXh(XH);
					xs.setXm(xslq.getXm());
					xs.setXbm(xslq.getXbm());
					xs.setZjlx(xslq.getZjlx());
					xs.setZjhm(xslq.getZjhm());
					xs.setMzm(xslq.getMzm());
					xs.setCsrq(xslq.getCsrq());
					xs.setXslb(2);
					xs.setXydm(xslq.getLqyxsm());
					xs.setXdm(null);
					xs.setPyccdm(null);
					xs.setEjxkdm(xslq.getLqzydm());
					xs.setHdxlfsdm(null);
					xs.setXz1(3);
					xs.setNj(xslq.getNf());
				} else if(xslq.getXslxdm() == 3){
				// 全日制博士研究生
				} else if(xslq.getXslxdm() == 4){
					// 进修生
					// 添加到学生基础信息表
					xs.setXh(XH);
					xs.setXm(xslq.getXm());
					xs.setXbm(xslq.getXbm());
					xs.setZjlx(xslq.getZjlx());
					xs.setZjhm(xslq.getZjhm());
					xs.setMzm(xslq.getMzm());
					xs.setCsrq(xslq.getCsrq());
					xs.setXslb(4);
					xs.setXydm(xslq.getLqyxsm());
					xs.setXdm(null);
					xs.setPyccdm(null);
					xs.setEjxkdm(xslq.getLqzydm());
					xs.setHdxlfsdm(null);
					xs.setXz1(3);
					xs.setNj(xslq.getNf());
				}
				
				try {
					xslqService.addToOtherTable(user, userRole, xs, xsxjzc, xsxl);
					xslq.setFlag(1);
					xslqService.modifyXslq(xslq);
					successCount++;
				} catch (DaoException e) {
					failCount++;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	/*
	 * 分页查询信息
	 */
	public String showAllByPage() {
		this.results = xslqService.rowCount(new Xslq(), "");
		items = xslqService.pagination(limit, page, "from Xslq t order by t.id desc");
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
	
	public boolean getSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}

	@JSON(serialize=false)
	public int getXslx() {
		return xslx;
	}

	public void setXslx(int xslx) {
		this.xslx = xslx;
	}

	@JSON(serialize=false)
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
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

	public List<Object> getItems() {
		return items;
	}

	public void setItems(List<Object> items) {
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

	public int getFailCount() {
		return failCount;
	}

	public void setFailCount(int failCount) {
		this.failCount = failCount;
	}
	
	@JSON(serialize=false)
	public XslqService getXslqService() {
		return xslqService;
	}
	
	public void setXslqService(XslqService xslqService) {
		this.xslqService = xslqService;
	}
	
	@JSON(serialize=false)
	public XsService getXsService() {
		return xsService;
	}

	public void setXsService(XsService xsService) {
		this.xsService = xsService;
	}

	@JSON(serialize=false)
	public XsxjzcService getXsxjzcService() {
		return xsxjzcService;
	}

	public void setXsxjzcService(XsxjzcService xsxjzcService) {
		this.xsxjzcService = xsxjzcService;
	}

	@JSON(serialize=false)
	public XslbService getXslbService() {
		return xslbService;
	}

	public void setXslbService(XslbService xslbService) {
		this.xslbService = xslbService;
	}

	@JSON(serialize=false)
	public XsxlService getXsxlService() {
		return xsxlService;
	}

	public void setXsxlService(XsxlService xsxlService) {
		this.xsxlService = xsxlService;
	}
	
	@JSON(serialize=false)
	public UserService getLoginService() {
		return loginService;
	}

	public void setLoginService(UserService loginService) {
		this.loginService = loginService;
	}


}
