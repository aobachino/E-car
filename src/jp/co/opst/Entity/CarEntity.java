package jp.co.opst.Entity;

import java.sql.Date;

public class CarEntity {
	
	private String carNum;
	private int categNum;
	private String carName;
	private String maker;
	private int gas;
	private Date regDay;
	private int price;
	private String memo;
	private int delflg;
	private String updStaff;
	private Date lstDay;
	public String getCarNum() {
		return carNum;
	}
	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}
	public int getCategNum() {
		return categNum;
	}
	public void setCategNum(int categNum) {
		this.categNum = categNum;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public int getGas() {
		return gas;
	}
	public void setGas(int gas) {
		this.gas = gas;
	}
	public Date getRegDay() {
		return regDay;
	}
	public void setRegDay(Date regDay) {
		this.regDay = regDay;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public int getDelflg() {
		return delflg;
	}
	public void setDelflg(int delflg) {
		this.delflg = delflg;
	}
	public String getUpdStaff() {
		return updStaff;
	}
	public void setUpdStaff(String updStaff) {
		this.updStaff = updStaff;
	}
	public Date getLstDay() {
		return lstDay;
	}
	public void setLstDay(Date lstDay) {
		this.lstDay = lstDay;
	}
}
