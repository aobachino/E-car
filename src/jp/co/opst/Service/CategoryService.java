package jp.co.opst.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.opst.Dao.CategoryDao;
import jp.co.opst.Dto.CategoryDto;
import jp.co.opst.Entity.CategoryEntity;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;
	
	public CategoryDto findCategory() {
		 List<CategoryEntity> categorys = categoryDao.selectAllCategory();
		 CategoryDto categdt = new CategoryDto();
		 categdt.setCategList(categorys);
		 return categdt;	
	}
}
