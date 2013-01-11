package com.hut.domain;


public class X implements java.io.Serializable {

	// Fields

	private String xdm;
	private String xmc;
	private String xydm;
	// Property accessors

	public String getXydm() {
		return xydm;
	}

	public void setXydm(String xydm) {
		this.xydm = xydm;
	}

	public String getXdm() {
		return this.xdm;
	}

	public void setXdm(String xdm) {
		this.xdm = xdm;
	}

	public String getXmc() {
		return this.xmc;
	}

	public void setXmc(String xmc) {
		this.xmc = xmc;
	}

}