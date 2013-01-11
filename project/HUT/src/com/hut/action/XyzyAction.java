package com.hut.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import com.hut.domain.Ejxk;
import com.hut.domain.Xyzy;
import com.hut.service.EjxkService;
import com.hut.service.XyzyService;
import com.opensymphony.xwork2.ActionSupport;

public class XyzyAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private XyzyService xyzyService;
	private EjxkService ejxkService;
	private List<Ejxk> items = new ArrayList<Ejxk>();
	private String xydm;
	public String findAllByXy() {
		List<Xyzy> temp = xyzyService.findAllByXy(xydm);
		for (Iterator iterator = temp.iterator(); iterator.hasNext();) {
			Xyzy xyzy = (Xyzy) iterator.next();
			Ejxk ejxk = (Ejxk)ejxkService.findEjxkByEjxkDm(xyzy.getZydm());
			items.add(ejxk);
		}
		return SUCCESS;
	}

	@JSON(serialize=false)
	public XyzyService getXyzyService() {
		return xyzyService;
	}

	public void setXyzyService(XyzyService xyzyService) {
		this.xyzyService = xyzyService;
	}

	@JSON(serialize=false)
	public EjxkService getEjxkService() {
		return ejxkService;
	}

	public void setEjxkService(EjxkService ejxkService) {
		this.ejxkService = ejxkService;
	}

	
	public String getXydm() {
		return xydm;
	}
	public void setXydm(String xydm) {
		this.xydm = xydm;
	}

	public void setItems(List<Ejxk> items) {
		this.items = items;
	}

	public List<Ejxk> getItems() {
		return items;
	}

	
}
