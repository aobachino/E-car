package jp.co.opst.Service;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.opst.Dao.ReserveDao;
import jp.co.opst.Dto.ReserveDto;
import jp.co.opst.Entity.ReserveEntity;
import jp.co.opst.Model.ReserveOkModel;

@Service
public class ReserveService {

	@Autowired
	private ReserveDao reserveDao;

	public int findUserNum() {
		int max = reserveDao.findMaxRentalNum();
		return max;

	}

	public ReserveDto findColleNum(ReserveOkModel okmo) {
		ReserveDto rdt = new ReserveDto();
		List<ReserveEntity> resList = reserveDao.findNum(okmo);
		rdt.setResList(resList);
		return rdt;
	}

	@Transactional(rollbackForClassName = "Exception")
	public ReserveDto insert(ReserveOkModel okmo, String memNum) throws SQLException {
		ReserveDto rdt = new ReserveDto();
		List<ReserveEntity> rentalList = reserveDao.findAll();
		ReserveEntity me = new ReserveEntity();
		String dep = okmo.getDepDay().replace("年", "-").replace("月", "-").replace("日", "-");
		String arr = okmo.getArrDay().replace("年", "-").replace("月", "-").replace("日", "-");

		LocalDateTime d = LocalDateTime.now();
		DateTimeFormatter df1 = DateTimeFormatter.ofPattern("yyMMddHHmmss");
		String s = df1.format(d);

		String str = String.format("%05d", Integer.parseInt(memNum));

		if (rentalList.size() == 0) {
			me.setRentNum(1);
		} else {
			int max = reserveDao.findMaxRentalNum();
			me.setRentNum(max + 1);
		}

		me.setMemNum(Integer.parseInt(memNum));
		me.setCarNum(okmo.getCarNum());
		me.setStartDay(dep);
		me.setFinishDay(arr);
		me.setReserveState(0);
		me.setPrice(okmo.getPrice());
		me.setColleNum(str + s);
		me.setStaffNum(11111);
		me.setUpdStaff("11111");

		int count = reserveDao.insert(me);
		if (count != 0) {
			List<ReserveEntity> resList = reserveDao.findInfo(me);
			rdt.setResList(resList);
		}
		return rdt;
	}

}
