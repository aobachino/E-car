package jp.co.opst.Dto;

import java.util.ArrayList;
import java.util.List;

import jp.co.opst.Entity.CategoryEntity;

public class CategoryDto {
	
	private List<CategoryEntity> categList = new ArrayList<CategoryEntity>();

	public List<CategoryEntity> getCategList() {
		return categList;
	}

	public void setCategList(List<CategoryEntity> categList) {
		this.categList = categList;
	}
}
