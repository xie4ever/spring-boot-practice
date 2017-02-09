package springboot.exception;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import springboot.pojo.ReturnPojo;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

	@ResponseBody
	@ExceptionHandler(value = RuntimeException.class)
	public ReturnPojo defaultErrorHandler(RuntimeException e, HttpServletResponse response) {

		ReturnPojo returnPojo = new ReturnPojo();

		returnPojo.setRetCode(500);
		returnPojo.setRetMsg("错误捕获类捕获到内部错误");

		return returnPojo;
	}
}
