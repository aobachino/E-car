package jp.co.opst.Entity;

import java.sql.Date;

public class ReserveEntity {
	private int rentNum;
	private int memNum;
	private String carNum;
	private String startDay;
	private String finishDay;
	private int reserveState;
	private int price;
	private Date reserveDay;
	private String colleNum;
	private int staffNum;
	private String updStaff;
	private Date lstDay;
	public int getRentNum() {
		return rentNum;
	}
	public void setRentNum(int rentNum) {
		this.rentNum = rentNum;
	}
	public int getMemNum() {
		return memNum;
	}
	public void setMemNum(int memNum) {
		this.memNum = memNum;
	}
	public String getCarNum() {
		return carNum;
	}
	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}
	public String getStartDay() {
		return startDay;
	}
	public void setStartDay(String startDay) {
		this.startDay = startDay;
	}
	public String getFinishDay() {
		return finishDay;
	}
	public void setFinishDay(String finishDay) {
		this.finishDay = finishDay;
	}
	public int getReserveState() {
		return reserveState;
	}
	public void setReserveState(int reserveState) {
		this.reserveState = reserveState;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getReserveDay() {
		return reserveDay;
	}
	public void setReserveDay(Date reserveDay) {
		this.reserveDay = reserveDay;
	}
	public String getColleNum() {
		return colleNum;
	}
	public void setColleNum(String colleNum) {
		this.colleNum = colleNum;
	}
	public int getStaffNum() {
		return staffNum;
	}
	public void setStaffNum(int staffNum) {
		this.staffNum = staffNum;
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
