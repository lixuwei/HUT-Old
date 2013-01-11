package com.hut.domain;

import java.io.Serializable;

/*
 * 学生导师关系表
 */
public class Xsds implements Serializable {
	
	private String xh;
	private String lsbh;
	private int flag;
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		// return super.hashCode();
		return (String.valueOf(this.xh)+String.valueOf(this.lsbh)).hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		// return super.equals(obj);
		if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Xsds xsds = (Xsds)obj;
        if(xh.equals(xsds.xh))
        	return false;
        if(lsbh.equals(xsds.lsbh))
        	return false;
        return true;
	}
	public String getXh() {
		return xh;
	}
	public void setXh(String xh) {
		this.xh = xh;
	}
	public String getLsbh() {
		return lsbh;
	}
	public void setLsbh(String lsbh) {
		this.lsbh = lsbh;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
}
