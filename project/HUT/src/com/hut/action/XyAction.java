package com.hut.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import com.hut.domain.Xy;
import com.hut.service.XyService;
import com.opensymphony.xwork2.ActionSupport;

public class XyAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private XyService xyService;
	private List<Object> items = null;
	private Xy xy;
	private String dm;
	private String[] xydms;
	private String xymc;
	private int results=0;
	private int limit=0;
	private int start=0;
	private int page;
	private boolean success = true;
	
	public String showAll() {
		items = xyService.findAllObject(new Xy());
		return SUCCESS;
	}
	
	public String showAllByPage() {
		this.results = xyService.rowCount(new Xy(), "");
		items = xyService.pagination(limit, page, "from Xy t "+"");
		return SUCCESS;
	}
	
	public String addXy() {
		xy = new Xy();
		xy.setDm(dm);
		xy.setXymc(xymc);
		success = xyService.addObject(xy);
		return SUCCESS;
	}
	
	public String modifyXy() {
		xy = new Xy();
		xy.setDm(dm);
		xy.setXymc(xymc);
		success = xyService.modifyObject(xy);
		return SUCCESS;
	}
	
	public String deleteXys() {
		List<Xy> list = new ArrayList<Xy>();
		for(int i=0; i<xydms.length; i++) {
			xy = xyService.findXyByXydm(xydms[i]);
			list.add(xy);
		}
		success = xyService.deleteXys(list);
		return SUCCESS;
	}
	
	public String findXyByXydm() {
		xy = xyService.findXyByXydm(dm);
		return SUCCESS;
	}
	@JSON(serialize=false)
	public XyService getXyService() {
		return xyService;
	}

	public void setXyService(XyService xyService) {
		this.xyService = xyService;
	}

	public List<Object> getItems() {
		return items;
	}

	public void setItems(List<Object> items) {
		this.items = items;
	}

	public Xy getXy() {
		return xy;
	}

	public void setXy(Xy xy) {
		this.xy = xy;
	}

	public String getDm() {
		return dm;
	}

	public void setDm(String dm) {
		this.dm = dm;
	}

	public String getXymc() {
		return xymc;
	}

	public void setXymc(String xymc) {
		this.xymc = xymc;
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

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String[] getXydms() {
		return xydms;
	}

	public void setXydms(String[] xydms) {
		this.xydms = xydms;
	}

}
