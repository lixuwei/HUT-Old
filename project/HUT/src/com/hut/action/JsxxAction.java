package com.hut.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.hut.domain.Jsxx;
import com.hut.domain.vo.JsxxVO;
import com.hut.service.JsxxService;
import com.hut.util.ExcelReader;
import com.opensymphony.xwork2.ActionSupport;

public class JsxxAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private JsxxService jsxxService;
	private File upload;
	private String uploadFileName;
	private int successCount = 0;
	private int updateCount = 0; // 文件中更新的记录的条数
	private int failCount = 0; // 文件中失败的记录的条数
	private boolean success = true;
	private List<Object> items = null;
	private int results = 0;
	private int limit = 0;
	private int start = 0;
	private int page;

	// 导入教室信息 表
	public String insertData2Jsxx() {
		ExcelReader excelReader = new ExcelReader();
		List<ArrayList<String>> data = excelReader.read(upload, uploadFileName);
		int length = data.size();
		for (int i = 1; i < length; i++) {
			ArrayList<String> arrayList = data.get(i);
			Jsxx jsxx = new Jsxx();
			jsxx.setJsmc(arrayList.get(0));
			jsxx.setJswz(arrayList.get(1));
			jsxx.setLx((int) Double.parseDouble(arrayList.get(2)));
			jsxx.setRnskrs((int) Double.parseDouble(arrayList.get(3)));
			jsxx.setRnksrs((int) Double.parseDouble(arrayList.get(4)));
			jsxx.setSsbm(arrayList.get(5));
			jsxx.setFlag((int) Double.parseDouble(arrayList.get(5)));
			jsxx.setBz(arrayList.get(7));

			Jsxx jsxx2 = jsxxService.findByJsMc(arrayList.get(0));
			if (jsxx2 == null)
				jsxxService.addObject(jsxx);
			else {
				jsxx.setJsmc(jsxx2.getJsmc());
				jsxxService.addObject(jsxx);
			}
		}
		return SUCCESS;
	}

	// 分页显示教室
	public String showAllByPage() {
		this.results = jsxxService.rowCount(new Jsxx(), "");
		items = jsxxService.pagination(limit, page, "from Jsxx t " + "");
		// JSONArray json = JSONArray.fromObject(items);
		// JSONObject json1 = JSONObject.fromObject(json);
		// json1.put("results", results);
		/*
		 * try { ServletActionContext.getResponse().getWriter().print(json); }
		 * catch (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		return SUCCESS;
	}

	// 得到所有的教室
	public String getAllJsxxs() {
		List<JsxxVO> jsxxVoList = new ArrayList<JsxxVO>();
		List<Jsxx> jsxxList = jsxxService.getAllJsxxs();
		for (Jsxx jsxx : jsxxList) {
			JsxxVO jsxxVO = new JsxxVO();
			jsxxVO.setId(jsxx.getId());
			jsxxVO.setJsmc(jsxx.getJsmc());
			jsxxVoList.add(jsxxVO);
		}
		JSONArray json = JSONArray.fromObject(jsxxList);
		try {
			ServletActionContext.getResponse().getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@JSON(serialize = false)
	public JsxxService getJsxxService() {
		return jsxxService;
	}

	public void setJsxxService(JsxxService jsxxService) {
		this.jsxxService = jsxxService;
	}

	@JSON(serialize = false)
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

}
