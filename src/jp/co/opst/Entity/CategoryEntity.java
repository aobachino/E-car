package jp.co.opst.Entity;

import java.sql.Date;

public class CategoryEntity {

	private int categNum;
	private String name;
	private String updStaff;
	private Date lstTime;

	public int getCategNum() {
		return categNum;
	}

	public void setCategNum(int categNum) {
		this.categNum = categNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUpdStaff() {
		return updStaff;
	}

	public void setUpdStaff(String updStaff) {
		this.updStaff = updStaff;
	}

	public Date getLstTime() {
		return lstTime;
	}

	public void setLstTime(Date lstTime) {
		this.lstTime = lstTime;
	}
}
