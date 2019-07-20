package jp.co.opst.Dto;

import java.util.ArrayList;
import java.util.List;

import jp.co.opst.Entity.CarEntity;
import jp.co.opst.Entity.CategoryEntity;
import jp.co.opst.Entity.MemberEntity;
import jp.co.opst.Entity.ReserveEntity;

public class ReserveDto {
	private List<MemberEntity> memList = new ArrayList<MemberEntity>();
	private List<CarEntity> carList = new ArrayList<CarEntity>();
	private List<CategoryEntity> categList = new ArrayList<CategoryEntity>();
	private List<ReserveEntity> resList = new ArrayList<ReserveEntity>();

	public List<MemberEntity> getMemList() {
		return memList;
	}

	public void setMemList(List<MemberEntity> memList) {
		this.memList = memList;
	}

	public List<CarEntity> getCarList() {
		return carList;
	}

	public void setCarList(List<CarEntity> carList) {
		this.carList = carList;
	}

	public List<CategoryEntity> getCategList() {
		return categList;
	}

	public void setCategList(List<CategoryEntity> categList) {
		this.categList = categList;
	}

	public List<ReserveEntity> getResList() {
		return resList;
	}

	public void setResList(List<ReserveEntity> resList) {
		this.resList = resList;
	}
}
