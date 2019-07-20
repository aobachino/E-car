package jp.co.opst.Service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.opst.Dao.CarDao;
import jp.co.opst.Dao.RegisterDao;
import jp.co.opst.Dao.ReserveDao;
import jp.co.opst.Dto.ReserveDto;
import jp.co.opst.Entity.CarEntity;
import jp.co.opst.Entity.MemberEntity;
import jp.co.opst.Entity.ReserveEntity;
import jp.co.opst.Model.ReserveInfoModel;

@Service
public class ReserveOperateService {

	@Autowired
	private ReserveDao reserveDao;
	@Autowired
	private RegisterDao registerDao;
	@Autowired
	private CarDao carDao;

	public ReserveDto infoFind(ReserveInfoModel resimo) {
		ReserveEntity en = new ReserveEntity();
		en.setColleNum(resimo.getColleNum());
		en.setMemNum(Integer.parseInt(resimo.getMemNum()));
		List<ReserveEntity> resList = reserveDao.findInfo(en);
		List<MemberEntity> memList = registerDao.memfind(en);
		List<CarEntity> carList = null;
		for (ReserveEntity r : resList) {
			en.setCarNum(r.getCarNum());
			carList = carDao.findCar(r.getCarNum());

		}
		ReserveDto rdt = new ReserveDto();
		rdt.setResList(resList);
		rdt.setMemList(memList);
		rdt.setCarList(carList);
		return rdt;
	}

	@Transactional(rollbackForClassName = "Exception")
	public boolean change(String dep, String arr, ReserveDto info, String price) throws SQLException {
		boolean res = true;
		ReserveEntity me = new ReserveEntity();
		String depart = dep.replace("年", "-").replace("月", "-").replace("日", "-");
		String arrive = arr.replace("年", "-").replace("月", "-").replace("日", "-");
		String colleNum = null;
		for (ReserveEntity r : info.getResList()) {
			colleNum = r.getColleNum();
		}
		me.setColleNum(colleNum);
		me.setPrice(Integer.parseInt(price));
		me.setStartDay(depart);
		me.setFinishDay(arrive);

		int cnt = reserveDao.changeDate(me);
		if (cnt == 0) {
			res = false;
		}
		return res;
	}

	public ReserveDto display(ReserveDto info) {
		ReserveDto rdt = new ReserveDto();
		ReserveEntity me = new ReserveEntity();
		for (ReserveEntity r : info.getResList()) {
			me.setColleNum(r.getColleNum());
			List<ReserveEntity> resList = reserveDao.findDeta(me);
			rdt.setResList(resList);
		}

		return rdt;
	}
	@Transactional(rollbackForClassName = "Exception")
	public boolean cancel(ReserveDto info) throws SQLException {
		boolean res = true;
		ReserveEntity me = new ReserveEntity();
		for(ReserveEntity rt : info.getResList()) {
			me.setColleNum(rt.getColleNum());
			me.setReserveState(3);
			int cnt = reserveDao.resCancel(me);
			if (cnt == 0) {
				res = false;
			}
		}


		return res;
	}

}
