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

import jp.co.opst.Entity.ReserveEntity;
import jp.co.opst.Model.ReserveOkModel;

@Repository
public class ReserveDao {
	@Autowired
	private NamedParameterJdbcTemplate namedParameterTemplate;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private class ReserveRowMapper extends BeanPropertyRowMapper<ReserveEntity> {
		@Override
		public ReserveEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
			ReserveEntity en = new ReserveEntity();
			en.setRentNum(rs.getInt("RENTAL_NO"));
			en.setMemNum(rs.getInt("MEMBER_NO"));
			en.setCarNum(rs.getString("CAR_CODE"));
			en.setStartDay(rs.getString("START_DAY"));
			en.setFinishDay(rs.getString("END_DAY"));
			en.setReserveState(rs.getInt("STATE_FLG"));
			en.setPrice(rs.getInt("RENTAL_MONEY"));
			en.setReserveDay(rs.getDate("RESERVE_DAY"));
			en.setColleNum(rs.getString("COLLECT_NO"));
			en.setStaffNum(rs.getInt("STAFF_NO"));
			en.setUpdStaff(rs.getString("LAST_UPD_STAFF"));
			en.setLstDay(rs.getDate("LAST_UPD_DAY"));

			return en;
		}
	}

	public Integer findMaxRentalNum() {
		String sql = "select MAX(RENTAL_NO)  from RENTAL_RESERVE";
		Integer max = this.jdbcTemplate.queryForObject(sql, Integer.class);
		return max;
	}

	public List<ReserveEntity> findAll() {
		String sql = "select * from RENTAL_RESERVE";
		List<ReserveEntity> rentList = this.namedParameterTemplate.query(sql, new ReserveRowMapper());
		return rentList;
	}

	public int insert(ReserveEntity en) {
		String sql = "insert into RENTAL_RESERVE(RENTAL_NO,MEMBER_NO,CAR_CODE,START_DAY,END_DAY,STATE_FLG,RENTAL_MONEY,RESERVE_DAY,COLLECT_NO,STAFF_NO,LAST_UPD_STAFF,LAST_UPD_DAY)"
				+ "values (:rentNum,:memNum,:carNum,cast( :startDay as datetime ),cast(:finishDay as datetime),:reserveState,:price,NOW(),:colleNum,:staffNum,:updStaff,NOW())";
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("rentNum", en.getRentNum());
		paramMap.addValue("memNum", en.getMemNum());
		paramMap.addValue("carNum", en.getCarNum());
		paramMap.addValue("startDay", en.getStartDay());
		paramMap.addValue("finishDay", en.getFinishDay());
		paramMap.addValue("reserveState", en.getReserveState());
		paramMap.addValue("price", en.getPrice());
		paramMap.addValue("colleNum", en.getColleNum());
		paramMap.addValue("staffNum", en.getStaffNum());
		paramMap.addValue("updStaff", en.getUpdStaff());
		int count = this.namedParameterTemplate.update(sql, paramMap);
		return count;
	}

	public List<ReserveEntity> findInfo(ReserveEntity en) {
		String sql = "select * from RENTAL_RESERVE where MEMBER_NO = :memNum AND COLLECT_NO = :colleNum";
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("memNum", en.getMemNum());
		paramMap.addValue("colleNum", en.getColleNum());
		List<ReserveEntity> resList = this.namedParameterTemplate.query(sql, paramMap, new ReserveRowMapper());
		return resList;
	}

	public List<ReserveEntity> findNum(ReserveOkModel okmo) {
		String sql = "select COLLECT_NO from RENTAL_RESERVE where CAR_CODE = :carNum";
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("carNum", okmo.getCarNum());
		List<ReserveEntity> rentList = this.namedParameterTemplate.query(sql, new ReserveRowMapper());
		return rentList;
	}

	public int changeDate(ReserveEntity me) {
		String sql = "update RENTAL_RESERVE set START_DAY = :startDay,END_DAY = :finishDay,RENTAL_MONEY =:price where COLLECT_NO = :colleNum ";
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("colleNum", me.getColleNum());
		paramMap.addValue("price", me.getPrice());
		paramMap.addValue("startDay", me.getStartDay());
		paramMap.addValue("finishDay", me.getFinishDay());
		int cnt = this.namedParameterTemplate.update(sql, paramMap);
		return cnt;
	}

	public List<ReserveEntity> findDeta(ReserveEntity me) {
		String sql = "select * from RENTAL_RESERVE where COLLECT_NO = :colleNum";
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("colleNum", me.getColleNum());
		List<ReserveEntity> resList = this.namedParameterTemplate.query(sql, paramMap, new ReserveRowMapper());
		return resList;
	}

	public int resCancel(ReserveEntity me) {
		String sql = "update RENTAL_RESERVE set STATE_FLG =:state where COLLECT_NO = :colleNum ";
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("colleNum", me.getColleNum());
		paramMap.addValue("state", me.getReserveState());
		int cnt = this.namedParameterTemplate.update(sql, paramMap);
		return cnt;
	}

}
