package com.hut.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import com.hut.domain.Teacher;
import com.hut.domain.X;
import com.hut.domain.vo.TeacherVo;
import com.hut.service.MzService;
import com.hut.service.TeacherService;
import com.hut.service.XService;
import com.hut.service.XlService;
import com.hut.service.XwService;
import com.hut.service.XxService;
import com.hut.service.XyService;
import com.hut.service.YzbzzyService;
import com.hut.service.ZcService;
import com.hut.service.ZzmmService;
import com.hut.util.ExcelWriter;
import com.hut.util.HibernateParter;
import com.hut.util.PropertiesUtil;
import com.opensymphony.xwork2.ActionSupport;

public class DaoChuTeacherAction extends ActionSupport  {
	
	private TeacherService teacherService;  private MzService mzService;
	private XyService xyService;            private XService xService;
	private YzbzzyService yzbzzyService;    private XlService xlService;
	private XwService xwService;            private ZcService zcService;
	private ZzmmService zzmmService;       	private XxService xxService;     
	
    /*导出老师信息  代码段开始*/
	private File file=null;
	private String inputPath;
	public void setInputPath(String value){
		inputPath = value;
	}
	
	//文件名称
	private String fileName;
	public  void setFileName(String filename){
		this.fileName = filename;
	}
	
	private TeacherVo teacherVo = new  TeacherVo();
	public TeacherVo getTeacherVo() {
		return teacherVo;
	}
	public void setTeacherVo(TeacherVo teacherVo) {
		this.teacherVo = teacherVo;
	}
	
	//收集页面传过来的字段
	List<String> list = null;
	List<ArrayList<String>> listChinese = null ;

	/*根据页面传过来的要导出数据的名称，查询数据库
	 * 需要转换的数据 先转换再保存，不需要就直接保存
	 * 	*/
	public List<ArrayList<String>> changeData(){
		list = new ArrayList<String>();
		if(teacherVo.getXm()!=null)	    list.add(teacherVo.getXm());
		if(teacherVo.getLsbh()!=null)	list.add(teacherVo.getLsbh());
		if(teacherVo.getZgh()!=null)    list.add(teacherVo.getZgh());
		if(teacherVo.getXb()!=null)	    list.add(teacherVo.getXb());
		if(teacherVo.getMzdm()!=null)   list.add(teacherVo.getMzdm());
		if(teacherVo.getEmail()!=null)  list.add(teacherVo.getEmail());
		if(teacherVo.getCsrq()!=null)   list.add(teacherVo.getCsrq());
		if(teacherVo.getZzmmdm()!=null) list.add(teacherVo.getZzmmdm());
		if(teacherVo.getXydm()!=null)   list.add(teacherVo.getXydm());
		if(teacherVo.getXdm()!=null)    list.add(teacherVo.getXdm());
		if(teacherVo.getLxdh()!=null)   list.add(teacherVo.getLxdh());
		if(teacherVo.getByxxdm()!=null) list.add(teacherVo.getByxxdm());
		if(teacherVo.getByzydm()!=null)	list.add(teacherVo.getByzydm());
		if(teacherVo.getZydm()!=null)   list.add(teacherVo.getZydm());
		if(teacherVo.getXldm()!=null)   list.add(teacherVo.getXldm());
		if(teacherVo.getXwdm()!=null)   list.add(teacherVo.getXwdm());
		if(teacherVo.getZcdm()!=null)   list.add(teacherVo.getZcdm());
		if(teacherVo.getZydm()!=null)   list.add(teacherVo.getZydm());
		if(teacherVo.getZw()!=null)	    list.add(teacherVo.getZw());
		if(teacherVo.getXkfx()!=null)   list.add(teacherVo.getXkfx());
		if(teacherVo.getSfzh()!=null)   list.add(teacherVo.getSfzh());
		if(teacherVo.getJszgzh()!=null) list.add(teacherVo.getJszgzh());
		if(teacherVo.getZjjszgzh()!=null)list.add(teacherVo.getZjjszgzh());
		if(teacherVo.getJxzlpj()!=null)	list.add(teacherVo.getJxzlpj());
		 
		List<Object[]> teachers = teacherService.getLSBySql(list);
		 /*将teachers转换成teacList
		  * 如果不需要数据转换 直接赋值 如需要 转换再赋值
		  * */
		List<ArrayList<String>> rowList = new ArrayList<ArrayList<String>>();
		for(int row=0;row<teachers.size();row++){
			 ArrayList<String>       colList = new ArrayList<String>();
			 rowList.add(colList);
			 for(int col=0;col<teachers.get(row).length;col++){
				 String  string = list.get(col);
				 String  anything="";
				 if("lsbh".equals(string) || "xm".equals(string) || "zgh".equals(string) || "csrq".equals(string)
				|| "lxdh".equals(string) || "email".equals(string) || "zw".equals(string) || "xkfx".equals(string)
				|| "sfzh".equals(string) || "jszgzh".equals(string) || "zjjszgzh".equals(string) || "jxzlpj".equals(string)
				 ){ 
					 rowList.get(row).add(String.valueOf(teachers.get(row)[col]));
				  }else {
					if("xb".equals(string)){
						switch (Integer.parseInt(String.valueOf(teachers.get(row)[col]))) {
						case 1:
							rowList.get(row).add("男");
							break;
						default:
							rowList.get(row).add("女");
							break;
						}
					}else if ("mzdm".equals(string)) {
						anything=mzService.findMzByMzdm(String.valueOf(teachers.get(row)[col])).getMc();
						rowList.get(row).add(anything);
					}else if ("zzmmdm".equals(string)) {
						anything = zzmmService.findZzmmdmByDm(String.valueOf(teachers.get(row)[col])).getMc();
						rowList.get(row).add(anything);
					}else if ("xydm".equals(string)) {
						anything = xyService.findXyByXydm(String.valueOf(teachers.get(row)[col])).getXymc();
						rowList.get(row).add(anything);
					}else if ("xdm".equals(string)) {
						X x = xService.findXByXdm(String.valueOf(teachers.get(row)[col]));
						if(x==null) anything="";
						else {
							anything =xService.findXByXdm(String.valueOf(teachers.get(row)[col])).getXmc();
							rowList.get(row).add(anything);
						}
					}else if ("byxxdm".equals(string)) {
						anything = xxService.findXxByXxdm(String.valueOf(teachers.get(row)[col])).getMc();
						rowList.get(row).add(anything);
					}else if ("byzydm".equals(string)) {
						anything = yzbzzyService.findZyByZydm(String.valueOf(teachers.get(row)[col])).getZymc();
						rowList.get(row).add(anything);
					}else if ("xldm".equals(string)) {
						anything = xlService.findXlByXldm(String.valueOf(teachers.get(row)[col])).getCm();
						rowList.get(row).add(anything);
					}else if ("xwdm".equals(string)) {
						anything = xwService.findXwByXwdm(String.valueOf(teachers.get(row)[col])).getMc();
						rowList.get(row).add(anything);
					}else if ("zcdm".equals(string)) {
						anything = zcService.findZcByZcdm(String.valueOf(teachers.get(row)[col])).getMc();
						rowList.get(row).add(anything);
					}else if ("zydm".equals(string)) {
						anything = yzbzzyService.findZyByZydm(String.valueOf(teachers.get(row)[col])).getZymc();
						rowList.get(row).add(anything);
					}
						
				}
		    }
		}
		return rowList;
	}
	
	//从页面传过来的字段 转化为相对应的备注名称
	public List<ArrayList<String>> changeToChinese(List<String> list){
		listChinese = new ArrayList<ArrayList<String>>();
		for(int i=0;i<1;i++ ){
			ArrayList<String> strings =new ArrayList<String>();
			listChinese.add(strings);
			for(int j=0;j<list.size();j++){
				String name = HibernateParter.getColumnComment(Teacher.class, list.get(j));
				listChinese.get(i).add(name);
			}
		}
		return listChinese;
	}
	
	//将从数据库查找的信息写入Excel表
	public void writeToExcel(List<ArrayList<String>> dataList,List<ArrayList<String>> columnName){
		ExcelWriter excelWriter = new ExcelWriter();
		//两个for()将两种数据合并在一起
		List<ArrayList<String>> newDataRow = new ArrayList<ArrayList<String>>();
		for(int row=0;row<columnName.size();row++){
			ArrayList<String>       newDataCol = new ArrayList<String>();
			newDataRow.add(newDataCol);
			for(int col=0;col<columnName.get(row).size();col++){
				newDataRow.get(row).add(columnName.get(row).get(col));
			}
		}
		
		for(int row=0;row<dataList.size();row++){
			ArrayList<String>       newDataCol = new ArrayList<String>();
			newDataRow.add(newDataCol);
			for(int col=0;col<dataList.get(row).size();col++){
				newDataRow.get(row+1).add(dataList.get(row).get(col));
			}
		}
		
		//将数据写入Excel表
		for(int i=0;i<newDataRow.size();i++){
				excelWriter.addData(newDataRow.get(i));
		}
		try {
			String fileName = this.getFilePath();
			file = new File(fileName);
			file.mkdirs();
			fileName = fileName +"/信息表.xls";
			excelWriter.write(fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	//得到下载的文件名称
	public String getDownFileName(){
		String downFileName = fileName;
		try {
			downFileName = new String(downFileName.getBytes(),"ISO8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return downFileName;
	}
	
	//读取filepath.properties里面文件存储的路径
	@JSON(serialize= false)
	public String getFilePath(){
		return  PropertiesUtil.getValue("filePath.properties", "downloadExcel");
		  
	}
	
	
	public InputStream getInputStream() throws Exception{
		File file = new File(this.getFilePath()+"/信息表.xls");
		InputStream inputStream = new FileInputStream(file);
		return inputStream;
	}

	public String getData(){
		List<ArrayList<String>> dataList = changeData();
		List<ArrayList<String>> columnName = changeToChinese(list); 
		writeToExcel(dataList,columnName);
		System.out.println("asdfasdf");
		return "input";
	}
	
	/*导出老师信息  代码段结束	*/
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
	public void setXxService(XxService xxService) {
		this.xxService = xxService;
	}
	
	
	
	
}
