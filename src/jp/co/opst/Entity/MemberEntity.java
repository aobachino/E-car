package jp.co.opst.Entity;

import java.sql.Date;

public class MemberEntity {

	private int memNum;
	private String name;
	private String age;
	private String sex;
	private String postCode;
	private String address;
	private String phoneNum;
	private Date regTime;
	private int delflig;
	private int point;
	private String updstaff;
	private Date lstTime;
	public int getMemNum() {
		return memNum;
	}
	public void setMemNum(int memNum) {
		this.memNum = memNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public Date getRegTime() {
		return regTime;
	}
	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getUpdstaff() {
		return updstaff;
	}
	public void setUpdstaff(String updstaff) {
		this.updstaff = updstaff;
	}
	public Date getLstTime() {
		return lstTime;
	}
	public void setLstTime(Date lstTime) {
		this.lstTime = lstTime;
	}
	public int getDelflig() {
		return delflig;
	}
	public void setDelflig(int delflig) {
		this.delflig = delflig;
	}
}
