package jp.co.opst.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.opst.Entity.CategoryEntity;
import jp.co.opst.Model.ReserveConfModel;
import jp.co.opst.Model.ReserveModel;

@Repository
public class CategoryDao {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterTemplate;

	private class CategryRowMapper extends BeanPropertyRowMapper<CategoryEntity> {
		@Override
		public CategoryEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
			CategoryEntity en = new CategoryEntity();
			en.setCategNum(rs.getInt("CTGR_ID"));
			en.setName(rs.getString("NAME"));
			en.setLstTime(rs.getDate("LAST_UPD_DAY"));
			return en;
		}
	}

	public List<CategoryEntity> selectAllCategory() {
		String sql = "select * from RENTAL_CATEGORY";
		List<CategoryEntity> cate = this.namedParameterTemplate.query(sql, new CategryRowMapper());

		return cate;
	}

	public List<CategoryEntity> categFind(@Valid ReserveModel resmo) {
		String sql = "select * from RENTAL_CATEGORY where CTGR_ID = :categNum";
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("categNum", resmo.getCategNum());
		List<CategoryEntity> categList = namedParameterTemplate.query(sql, paramMap, new CategryRowMapper());
		return categList;
	}

	public List<CategoryEntity> categFind(ReserveConfModel rescomo) {
		String sql = "select * from RENTAL_CATEGORY where NAME = :categName";
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("categName", rescomo.getCategName());
		List<CategoryEntity> categList = namedParameterTemplate.query(sql, paramMap, new CategryRowMapper());
		return categList;
	}

}
