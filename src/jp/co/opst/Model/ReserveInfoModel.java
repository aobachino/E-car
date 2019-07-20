package jp.co.opst.Model;

import javax.validation.constraints.NotEmpty;

public class ReserveInfoModel {
	@NotEmpty(message = "必須入力です ")
	private String memNum;
	@NotEmpty(message = "必須入力です ")
	private String colleNum;

	public String getMemNum() {
		return memNum;
	}

	public void setMemNum(String memNum) {
		this.memNum = memNum;
	}

	public String getColleNum() {
		return colleNum;
	}

	public void setColleNum(String colleNum) {
		this.colleNum = colleNum;
	}
}
