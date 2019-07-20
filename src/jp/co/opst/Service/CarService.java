package jp.co.opst.Service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.opst.Dao.CarDao;
import jp.co.opst.Dao.CategoryDao;
import jp.co.opst.Dao.RegisterDao;
import jp.co.opst.Dto.ReserveDto;
import jp.co.opst.Entity.CarEntity;
import jp.co.opst.Entity.CategoryEntity;
import jp.co.opst.Entity.MemberEntity;
import jp.co.opst.Model.ReserveConfModel;
import jp.co.opst.Model.ReserveModel;

@Service
public class CarService {

	@Autowired
	private RegisterDao registerDao;

	@Autowired
	private CarDao carDao;

	@Autowired
	private CategoryDao categoryDao;

	public ReserveDto productSerch(@Valid ReserveModel resmo) {
		List<MemberEntity> memList = registerDao.memFind(resmo);
		List<CarEntity> carList = carDao.carFind(resmo);
		List<CategoryEntity> categList = categoryDao.categFind(resmo);
		ReserveDto rdt = new ReserveDto();
		rdt.setMemList(memList);
		rdt.setCarList(carList);
		rdt.setCategList(categList);
		return rdt;
	}

	public ReserveDto productSelect(ReserveConfModel rescomo) {
		List<MemberEntity> memList = registerDao.memFind(rescomo);
		List<CarEntity> carList = carDao.carFind(rescomo);
		//List<CarEntity> priList = reserveDao.totalPrice(rescomo);
		List<CategoryEntity> categList = categoryDao.categFind(rescomo);
		ReserveDto rdt = new ReserveDto();
		rdt.setMemList(memList);
		rdt.setCarList(carList);
		rdt.setCategList(categList);
		// rdt.setCarList(priList);
		return rdt;
	}

	public int totalPrice(ReserveConfModel rescomo) {
		List<CarEntity> carList = carDao.carFind(rescomo);
		int total = 0;
		for (CarEntity m : carList) {
			total += m.getPrice();
		}
		return total;
	}

}
