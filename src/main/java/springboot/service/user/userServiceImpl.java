package springboot.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springboot.dao.userMapper;
import springboot.exception.testException;
import springboot.pojo.ReturnPojo;
import springboot.pojo.user;

@Service
public class userServiceImpl implements userService {

	@Autowired
	userMapper userMapper;

	public ReturnPojo selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub

		ReturnPojo returnPojo = new ReturnPojo();

		if (id == null || id <= 0) {

			returnPojo.setRetCode(500);
			returnPojo.setRetMsg("id有误");

			return returnPojo;
		}

		user user = userMapper.selectByPrimaryKey(id);

		if (user == null) {

			returnPojo.setRetCode(500);
			returnPojo.setRetMsg("查询失败");

			return returnPojo;

		} else {

			returnPojo.setRetCode(200);
			returnPojo.setRetData(user);
			returnPojo.setRetMsg("查询成功");

			return returnPojo;
		}
	}

	@Transactional
	public ReturnPojo insertSelective(user user) {
		// TODO Auto-generated method stub

		ReturnPojo returnPojo = new ReturnPojo();

		if (userMapper.insertSelective(user) > 0) {

			System.out.println("插入成功");

			throw new testException("虽然插入成功了，但是这个混蛋非要抛出一个错误！我也很绝望啊！");
		}

		returnPojo.setRetCode(500);
		returnPojo.setRetMsg("插入失败");

		return returnPojo;
	}
}
