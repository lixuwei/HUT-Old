package com.hut.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import com.hut.domain.Xslb;
import com.hut.service.XslbService;
import com.opensymphony.xwork2.ActionSupport;

public class XslbAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private XslbService xslbService;
	private List<Object> items = null;
	private Xslb xslb;
	private int dm;
	private String mc;
	private String bz;
	private int[] xslbdms;
	private int results=0;
	private int limit=0;
	private int start=0;
	private int page;
	private boolean success = true;
	
	public String showAll() {
		items = xslbService.findAllObject(new Xslb());
		return SUCCESS;
	}
	
	public String showAllByPage() {
		this.results = xslbService.rowCount(new Xslb(), "");
		items = xslbService.pagination(limit, page, "from Xslb t ");
		return SUCCESS;
	}
	
	public String addXslb() {
		xslb = new Xslb();
		System.out.println("dm="+xslbService.rowCount(new Xslb(), ""));
		xslb.setDm(xslbService.rowCount(new Xslb(), "")+1);
		xslb.setMc(mc);
		xslb.setBz(bz);
		success = xslbService.addObject(xslb);
		return SUCCESS;
	}
	
	public String modifyXslb() {
		xslb = new Xslb();
		xslb.setDm(dm);
		xslb.setMc(mc);
		xslb.setBz(bz);
		success = xslbService.modifyObject(xslb);
		return SUCCESS;
	}
	
	public String deleteXslbs() {
		List<Xslb> list = new ArrayList<Xslb>();
		for(int i=0; i<xslbdms.length; i++) {
			xslb = xslbService.findXslbByXslbdm(xslbdms[i]);
			list.add(xslb);
		}
		success = xslbService.deleteXslbs(list);
		return SUCCESS;
	}
	
	public List<Object> getItems() {
		return items;
	}
	public void setItems(List<Object> items) {
		this.items = items;
	}
	@JSON(serialize=false)
	public XslbService getXslbService() {
		return xslbService;
	}
	public void setXslbService(XslbService xslbService) {
		this.xslbService = xslbService;
	}

	public Xslb getXslb() {
		return xslb;
	}

	public void setXslb(Xslb xslb) {
		this.xslb = xslb;
	}

	public int getDm() {
		return dm;
	}

	public void setDm(int dm) {
		this.dm = dm;
	}

	public String getMc() {
		return mc;
	}

	public void setMc(String mc) {
		this.mc = mc;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public int[] getXslbdms() {
		return xslbdms;
	}

	public void setXslbdms(int[] xslbdms) {
		this.xslbdms = xslbdms;
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
}
