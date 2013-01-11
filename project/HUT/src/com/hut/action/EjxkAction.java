package com.hut.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import org.apache.struts2.json.annotations.JSON;

import com.hut.domain.Ejxk;
import com.hut.domain.Xy;
import com.hut.domain.Xyzy;
import com.hut.domain.vo.EjxkAndXy;
import com.hut.service.EjxkService;
import com.hut.service.XyService;
import com.hut.service.XyzyService;
import com.opensymphony.xwork2.ActionSupport;

public class EjxkAction extends ActionSupport{
	

	private static final long serialVersionUID = 1L;
	private EjxkService ejxkService;
	private XyzyService xyzyService;
	private XyService xyService;
	private List<Object> items = null;
	private List<EjxkAndXy> ejxkAndXyItems = null;
	private int results=0;
	private int limit=0;
	private int start=0;
	private int page;
	private boolean success = true;
	
	private String ejxkdm;
	private String ejxkmc;
	private String yjxkdm;
	private String yjxkmc;
	private String mldm;
	private String mlmc;
	private String xwlx;
	private String xydm;
	private int id;

	private int[] ids;
	
	private EjxkAndXy ejxkAndXy;
	
	public String showAll() {
		items = ejxkService.findAllObject(new Ejxk());
		return SUCCESS;
	}
	
	public String showAllByPage() {
		ejxkAndXyItems = new ArrayList<EjxkAndXy>();
		
		this.results = xyzyService.rowCount(new Xyzy(), "");
		items = xyzyService.pagination(limit, page, "from Xyzy t "+"");
		for (Iterator iterator = items.iterator(); iterator.hasNext();) {
			Xyzy xyzy = (Xyzy) iterator.next();
			EjxkAndXy ejxkAndXy = new EjxkAndXy();
			Ejxk ejxk = new Ejxk();
			Xy xy = new Xy();
			
			ejxk = ejxkService.findEjxkByEjxkDm(xyzy.getZydm());
			xy = xyService.findXyByXydm(xyzy.getXydm());
			
			ejxkAndXy.setEjxkdm(xyzy.getZydm());
			ejxkAndXy.setEjxkmc(ejxk.getEjxkmc());
			ejxkAndXy.setYjxkdm(ejxk.getYjxkdm());
			ejxkAndXy.setYjxkmc(ejxk.getYjxkmc());
			ejxkAndXy.setMldm(ejxk.getMldm());
			ejxkAndXy.setMlmc(ejxk.getMlmc());
			ejxkAndXy.setXwlx(ejxk.getXwlx());
			ejxkAndXy.setId(xyzy.getId());
			ejxkAndXy.setXydm(xyzy.getXydm());
			ejxkAndXy.setXymc(xy.getXymc());
			ejxkAndXyItems.add(ejxkAndXy);
		}
		return SUCCESS;
	}
	
	public String addEjxk() {
		Ejxk ejxk = new Ejxk();
		
		if(ejxkService.findEjxkByEjxkDm(ejxkdm) == null) {
			ejxk.setEjxkdm(ejxkdm);
			ejxk.setEjxkmc(ejxkmc);
			ejxk.setYjxkdm(yjxkdm);
			ejxk.setYjxkmc(yjxkmc);
			ejxk.setMldm(mldm);
			ejxk.setMlmc(mlmc);
			ejxk.setXwlx(xwlx);
		} else {
			ejxk = null;
		}
		
		Xyzy xyzy = new Xyzy();
		xyzy.setXydm(xydm);
		xyzy.setZydm(ejxkdm);
		
		success = ejxkService.addEjxk(ejxk, xyzy);
		return SUCCESS;
	}
	
	public String modifyEjxk() {
		Ejxk ejxk = new Ejxk();
		ejxk.setEjxkdm(ejxkdm);
		ejxk.setEjxkmc(ejxkmc);
		ejxk.setYjxkdm(yjxkdm);
		ejxk.setYjxkmc(yjxkmc);
		ejxk.setMldm(mldm);
		ejxk.setMlmc(mlmc);
		ejxk.setXwlx(xwlx);
		Xyzy xyzy = new Xyzy();
		xyzy = (Xyzy)xyzyService.findXyzyById(id);
		//xyzy = xyzyService.findByXyAndZydm(xydm, ejxkdm);
		success = ejxkService.modifyEjxk(ejxk, xyzy);
		return SUCCESS;
	}
	
	public String deleteEjxks() {
		List<Xyzy> xyzyList = new ArrayList<Xyzy>();
		List<Ejxk> ejxkList = new ArrayList<Ejxk>();
		for(int i=0; i<ids.length; i++) {
			
			Xyzy xyzy = new Xyzy();
			Ejxk ejxk = new Ejxk();
			//ejxk = ejxkService.findEjxkByEjxkDm(ejxkdms[i]);
			
			xyzy = (Xyzy)xyzyService.findXyzyById(ids[i]);

			List<Xyzy> list = xyzyService.findByZydm(xyzy.getXydm());
			if(list.size() == 1) {
				ejxk = ejxkService.findEjxkByEjxkDm(xyzy.getZydm());
				ejxkList.add(ejxk);
			}
			
			xyzyList.add(xyzy);
		}
		success = ejxkService.deleteZys(xyzyList, ejxkList);
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
	public XyService getXyService() {
		return xyService;
	}

	public void setXyService(XyService xyService) {
		this.xyService = xyService;
	}

	@JSON(serialize=false)
	public EjxkService getEjxkService() {
		return ejxkService;
	}

	public void setEjxkService(EjxkService ejxkService) {
		this.ejxkService = ejxkService;
	}

	public List<Object> getItems() {
		return items;
	}

	public void setItems(List<Object> items) {
		this.items = items;
	}

	public List<EjxkAndXy> getEjxkAndXyItems() {
		return ejxkAndXyItems;
	}

	public void setEjxkAndXyItems(List<EjxkAndXy> ejxkAndXyItems) {
		this.ejxkAndXyItems = ejxkAndXyItems;
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

	public String getEjxkdm() {
		return ejxkdm;
	}

	public void setEjxkdm(String ejxkdm) {
		this.ejxkdm = ejxkdm;
	}

	public String getEjxkmc() {
		return ejxkmc;
	}

	public void setEjxkmc(String ejxkmc) {
		this.ejxkmc = ejxkmc;
	}

	public String getYjxkdm() {
		return yjxkdm;
	}

	public void setYjxkdm(String yjxkdm) {
		this.yjxkdm = yjxkdm;
	}

	public String getYjxkmc() {
		return yjxkmc;
	}

	public void setYjxkmc(String yjxkmc) {
		this.yjxkmc = yjxkmc;
	}

	public String getMldm() {
		return mldm;
	}

	public void setMldm(String mldm) {
		this.mldm = mldm;
	}

	public String getMlmc() {
		return mlmc;
	}

	public void setMlmc(String mlmc) {
		this.mlmc = mlmc;
	}

	public String getXwlx() {
		return xwlx;
	}

	public void setXwlx(String xwlx) {
		this.xwlx = xwlx;
	}

	public String getXydm() {
		return xydm;
	}

	public void setXydm(String xydm) {
		this.xydm = xydm;
	}

	public EjxkAndXy getEjxkAndXy() {
		return ejxkAndXy;
	}

	public void setEjxkAndXy(EjxkAndXy ejxkAndXy) {
		this.ejxkAndXy = ejxkAndXy;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int[] getIds() {
		return ids;
	}

	public void setIds(int[] ids) {
		this.ids = ids;
	}
}
