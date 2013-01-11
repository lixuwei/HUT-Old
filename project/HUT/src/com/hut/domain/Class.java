package com.hut.domain;

/*
 * 班级
 */
public class Class {
	
	private int classId;
	private String className;
	private int  classNum;
	private int year;
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public int getClassNum() {
		return classNum;
	}
	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	
}
