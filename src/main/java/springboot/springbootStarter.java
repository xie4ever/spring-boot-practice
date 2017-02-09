package springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2  //开启swagger支持
public class springbootStarter {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(springbootStarter.class, args);
	}
}
