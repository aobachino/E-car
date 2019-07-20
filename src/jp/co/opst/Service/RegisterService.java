package jp.co.opst.Service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.opst.Dao.RegisterDao;
import jp.co.opst.Entity.MemberEntity;
import jp.co.opst.Model.RegisterModel;

@Service
public class RegisterService {
	@Autowired
	private RegisterDao registerDao;

	public int findUserNum() {
		int max = registerDao.findMaxUserNum();
		return max;

	}

	@Transactional(rollbackForClassName = "Exception")
	public void insert(RegisterModel regmo) throws SQLException {
		List<MemberEntity> userList = registerDao.findAll();

		if (userList.size() == 0) {
			MemberEntity me = new MemberEntity();
			me.setMemNum(1);
			me.setName(regmo.getName());
			me.setAge(regmo.getAge());
			me.setSex(regmo.getSex());
			me.setPostCode(regmo.getPostCode());
			me.setAddress(regmo.getAddress());
			me.setPhoneNum(regmo.getPhoneNum());

			registerDao.insert1(me);
		} else {
			MemberEntity me = new MemberEntity();
			int max = registerDao.findMaxUserNum();
			me.setMemNum(max + 1);
			me.setName(regmo.getName());
			me.setAge(regmo.getAge());
			me.setSex(regmo.getSex());
			me.setPostCode(regmo.getPostCode());
			me.setAddress(regmo.getAddress());
			me.setPhoneNum(regmo.getPhoneNum());

			registerDao.insert1(me);
		}
	}

}
