package jp.co.opst.Model;

import javax.validation.GroupSequence;
import javax.validation.constraints.NotEmpty;

import jp.co.opst.Model.ReserveModel.Group1;

@GroupSequence({ Group1.class, ReserveModel.class })
public class ReserveModel {
	public interface Group1 {
	}

	@NotEmpty(message = "必須入力です ", groups = Group1.class)
	private String memNum;
	@NotEmpty(message = "必須入力です ", groups = Group1.class)
	private String categNum;
	@NotEmpty(message = "必須入力です ", groups = Group1.class)
	private String depYear;
	@NotEmpty(message = "必須入力です ", groups = Group1.class)
	private String depMounth;
	@NotEmpty(message = "必須入力です ", groups = Group1.class)
	private String depDay;
	@NotEmpty(message = "必須入力です ", groups = Group1.class)
	private String arrYear;
	@NotEmpty(message = "必須入力です ", groups = Group1.class)
	private String arrMounth;
	@NotEmpty(message = "必須入力です ", groups = Group1.class)
	private String arrDay;

	public String getMemNum() {
		return memNum;
	}

	public void setMemNum(String memNum) {
		this.memNum = memNum;
	}

	public String getCategNum() {
		return categNum;
	}

	public void setCategNum(String categNum) {
		this.categNum = categNum;
	}

	public String getDepYear() {
		return depYear;
	}

	public void setDepYear(String depYear) {
		this.depYear = depYear;
	}

	public String getDepMounth() {
		return depMounth;
	}

	public void setDepMounth(String depMounth) {
		this.depMounth = depMounth;
	}

	public String getDepDay() {
		return depDay;
	}

	public void setDepDay(String depDay) {
		this.depDay = depDay;
	}

	public String getArrYear() {
		return arrYear;
	}

	public void setArrYear(String arrYear) {
		this.arrYear = arrYear;
	}

	public String getArrMounth() {
		return arrMounth;
	}

	public void setArrMounth(String arrMounth) {
		this.arrMounth = arrMounth;
	}

	public String getArrDay() {
		return arrDay;
	}

	public void setArrDay(String arrDay) {
		this.arrDay = arrDay;
	}

}
