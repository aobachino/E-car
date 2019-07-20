package jp.co.opst.Dto;

import java.util.ArrayList;
import java.util.List;

import jp.co.opst.Entity.MemberEntity;

public class MemberDto {
	List<MemberEntity> meList = new ArrayList<MemberEntity>();

	public List<MemberEntity> getMeList() {
		return meList;
	}

	public void setUiList(List<MemberEntity> meList) {
		this.meList = meList;
	}
}
