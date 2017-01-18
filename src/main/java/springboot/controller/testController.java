package springboot.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import springboot.pojo.ReturnPojo;
import springboot.pojo.user;

//@Controller
//@EnableAutoConfiguration
@SpringBootApplication
@RestController
@RequestMapping("/test")
public class testController {

	@RequestMapping("/helloworld")
	@ResponseBody
	public String helloworld() {
		return "Hello World!";
	}

	@RequestMapping("/user")
	@ResponseBody
	public ReturnPojo user() {

		user user = new user();

		user.setUsername("xie");
		user.setPassword("4ever");

		ReturnPojo returnPojo = new ReturnPojo();

		returnPojo.setRetCode(200);
		returnPojo.setRetData(user);
		returnPojo.setRetMsg("success");

		return returnPojo;
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(testController.class, args);
	}
}
