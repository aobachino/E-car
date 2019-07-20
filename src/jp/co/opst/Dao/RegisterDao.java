package jp.co.opst.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.opst.Entity.MemberEntity;
import jp.co.opst.Entity.ReserveEntity;
import jp.co.opst.Model.ReserveConfModel;
import jp.co.opst.Model.ReserveModel;

@Repository
public class RegisterDao {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterTemplate;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private class RegRowMapper extends BeanPropertyRowMapper<MemberEntity> {
		@Override
		public MemberEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
			MemberEntity en = new MemberEntity();
			en.setMemNum(rs.getInt("MEMBER_NO"));
			en.setName(rs.getString("NAME"));
			en.setAge(rs.getString("AGE"));
			en.setSex(rs.getString("SEX"));
			en.setPostCode(rs.getString("ZIP"));
			en.setAddress(rs.getString("ADDRESS"));
			en.setPhoneNum(rs.getString("TEL"));
			en.setRegTime(rs.getDate("REGISTER_DAY"));
			en.setDelflig(rs.getInt("DELETE_FLG"));
			en.setPoint(rs.getInt("RENTAL_POINT"));
			en.setUpdstaff(rs.getString("LAST_UPD_STAFF"));
			en.setLstTime(rs.getDate("LAST_UPD_DAY"));
			return en;
		}
	}

	public List<MemberEntity> findAll() {
		String sql = "select * from RENTAL_MEMBER";
		List<MemberEntity> userInfoList = this.namedParameterTemplate.query(sql, new RegRowMapper());
		return userInfoList;
	}

	public Integer findMaxUserNum() {
		String sql = "select MAX(MEMBER_NO)  from RENTAL_MEMBER ";
		Integer max = this.jdbcTemplate.queryForObject(sql, Integer.class);
		return max;
	}

	public int insert1(MemberEntity entity) {
		String sql = "insert into RENTAL_MEMBER (MEMBER_NO,NAME,AGE,SEX,ZIP,ADDRESS,TEL,REGISTER_DAY,DELETE_FLG,RENTAL_POINT,LAST_UPD_STAFF,LAST_UPD_DAY)"
				+ "values (:memNum,:name,:age,:sex,:postCode,:address,:phoneNum,NOW(),0,0,11111,NOW()) ";
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("memNum", entity.getMemNum());
		paramMap.addValue("name", entity.getName());
		paramMap.addValue("age", Integer.parseInt(entity.getAge()));
		paramMap.addValue("sex", entity.getSex());
		paramMap.addValue("postCode", entity.getPostCode());
		paramMap.addValue("address", entity.getAddress());
		paramMap.addValue("phoneNum", entity.getPhoneNum());
		int count = this.namedParameterTemplate.update(sql, paramMap);
		return count;
	}

	public List<MemberEntity> memFind(ReserveModel resmo) {
		String sql = "select * from RENTAL_MEMBER where MEMBER_NO = :memNum";
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("memNum", resmo.getMemNum());
		List<MemberEntity> memList = namedParameterTemplate.query(sql, paramMap, new RegRowMapper());
		return memList;
	}

	public List<MemberEntity> memFind(ReserveConfModel rescomo) {
		String sql = "select * from RENTAL_MEMBER where MEMBER_NO = :memNum";
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("memNum", rescomo.getMemNum());
		List<MemberEntity> memList = namedParameterTemplate.query(sql, paramMap, new RegRowMapper());
		return memList;
	}

	public List<MemberEntity> memfind(ReserveEntity en) {
		String sql = "select * from RENTAL_MEMBER where MEMBER_NO = :memNum";
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("memNum", en.getMemNum());
		List<MemberEntity> memList = namedParameterTemplate.query(sql, paramMap, new RegRowMapper());
		return memList;
	}
}
