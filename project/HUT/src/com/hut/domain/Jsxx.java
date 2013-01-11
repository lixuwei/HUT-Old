package com.hut.domain;

/*
 * 教室信息
 */
public class Jsxx {
	
	private int id;
	private String jsmc;
	private String jswz;
	private int lx;
	private int rnskrs;
	private int rnksrs;
	private String ssbm;
	private int flag;
	private String bz;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getJsmc() {
		return jsmc;
	}
	public void setJsmc(String jsmc) {
		this.jsmc = jsmc;
	}
	public String getJswz() {
		return jswz;
	}
	public void setJswz(String jswz) {
		this.jswz = jswz;
	}
	public int getLx() {
		return lx;
	}
	public void setLx(int lx) {
		this.lx = lx;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public int getRnskrs() {
		return rnskrs;
	}
	public void setRnskrs(int rnskrs) {
		this.rnskrs = rnskrs;
	}
	public int getRnksrs() {
		return rnksrs;
	}
	public void setRnksrs(int rnksrs) {
		this.rnksrs = rnksrs;
	}
	public String getSsbm() {
		return ssbm;
	}
	public void setSsbm(String ssbm) {
		this.ssbm = ssbm;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
}
