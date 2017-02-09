package springboot.service.user;

import springboot.pojo.ReturnPojo;
import springboot.pojo.user;

public interface userService {

	public ReturnPojo selectByPrimaryKey(Integer id);
	
	public ReturnPojo insertSelective(user user);
}
