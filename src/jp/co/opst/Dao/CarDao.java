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

import jp.co.opst.Entity.CarEntity;
import jp.co.opst.Model.ReserveConfModel;
import jp.co.opst.Model.ReserveModel;

@Repository
public class CarDao {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterTemplate;

	private class CarRowMapper extends BeanPropertyRowMapper<CarEntity> {
		@Override
		public CarEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
			CarEntity en = new CarEntity();
			en.setCarNum(rs.getString("CAR_CODE"));
			en.setCategNum(rs.getInt("CTGR_ID"));
			en.setCarName(rs.getString("CAR_NAME"));
			en.setMaker(rs.getString("CAR_MAKER"));
			en.setGas(rs.getInt("ENGINE"));
			en.setRegDay(rs.getDate("REGISTER_DAY"));
			en.setPrice(rs.getInt("RENTAL_MONEY"));
			en.setMemo(rs.getString("MEMO"));
			en.setDelflg(rs.getInt("DELETE_FLG"));
			en.setUpdStaff(rs.getString("LAST_UPD_STAFF"));
			en.setLstDay(rs.getDate("LAST_UPD_DAY"));
			return en;
		}
	}

	public List<CarEntity> carFind(@Valid ReserveModel resmo) {
		String sql = "select * from RENTAL_CAR where CTGR_ID = :categNum";
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("categNum", resmo.getCategNum());
		List<CarEntity> carList = namedParameterTemplate.query(sql, paramMap, new CarRowMapper());
		return carList;
	}

	//値が複数入るようにする
	public List<CarEntity> carFind(ReserveConfModel rescomo) {
		String sql = "select * from RENTAL_CAR where ";
		StringBuffer aaa = new StringBuffer(sql);
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		int count = 1;
		for (String num : rescomo.getCarNum()) {
			aaa.append("CAR_CODE = :num");
			paramMap.addValue("num", num);
			if (count < rescomo.getCarNum().length) {
				aaa.append(" OR ");
			}
			count++;
		}
		List<CarEntity> carList = this.namedParameterTemplate.query(aaa.toString(), paramMap, new CarRowMapper());

		return carList;
		/*
		String sql = "select GOODS_NUM,GOODS_NAME,GOODS_PRICE,GOODS_EXP,MAKER from GOODS where GOODS_NUM in (";
		
		StringBuilder sb = new StringBuilder(sql);
		
		try (Connection con = DriverManager.getConnection(DBConnectionInfo.HOST, DBConnectionInfo.USER_ID,
				DBConnectionInfo.PASS);) {
		
			for (int i = 1; i <= array.length; i++) {
				sb.append("?");
				if (i < array.length) {
					sb.append(",");
				}
			}
			sb.append(")");*/
	}

	public List<CarEntity> findCar(String carNum) {
		String sql = "select * from RENTAL_CAR where CAR_CODE  = :carNum";
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("carNum", carNum);
		List<CarEntity> carList = this.namedParameterTemplate.query(sql, paramMap, new CarRowMapper());
		return carList;
	}
}
