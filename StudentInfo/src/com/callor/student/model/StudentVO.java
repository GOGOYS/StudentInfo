package com.callor.student.model;

public class StudentVO {
	String stNum;
	String stName;
	String stDept;
	String stGrade;
	String stTel;
	public String getStNum() {
		return stNum;
	}
	public void setStNum(String stNum) {
		this.stNum = stNum;
	}
	public String getStName() {
		return stName;
	}
	public void setStName(String stName) {
		this.stName = stName;
	}
	public String getStDept() {
		return stDept;
	}
	public void setStDept(String stDept) {
		this.stDept = stDept;
	}
	public String getStGrade() {
		return stGrade;
	}
	public void setStGrade(String stGrade) {
		this.stGrade = stGrade;
	}
	public String getStTel() {
		return stTel;
	}
	public void setStTel(String stTel) {
		this.stTel = stTel;
	}
	@Override
	public String toString() {
		return stNum + "\t" + stName + "\t" + stDept + "\t" + stGrade
				+ "\t" + stTel;
	}
	
}
