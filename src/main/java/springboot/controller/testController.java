package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import springboot.pojo.ReturnPojo;
import springboot.pojo.user;
import springboot.service.user.userService;

@Api
@RestController
@RequestMapping("/test")
public class testController {
	
	@Autowired
	userService userService;
	
	@ResponseBody
	@RequestMapping(value = "/testSelect", method = RequestMethod.GET)
	public ReturnPojo testSelect(@RequestParam(value = "id") Integer id) {

		return userService.selectByPrimaryKey(id);
	}

	@RequestMapping(value = "/testException", method = RequestMethod.GET)
	public void testException() {

		System.out.println(100 / 0);
	}
	
	@ResponseBody
	@ExceptionHandler(RuntimeException.class)
	public ReturnPojo exceptionHandler() {

		ReturnPojo returnPojo = new ReturnPojo();

		returnPojo.setRetCode(500);
		returnPojo.setRetMsg("错误捕获方法捕获内部错误");

		return returnPojo;
	}
	
	@ResponseBody
	@RequestMapping(value = "/testTransaction", method = RequestMethod.POST)
	public ReturnPojo testTransaction(@RequestBody user user) {

		return userService.insertSelective(user);
	}
}
