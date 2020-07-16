package mainPackage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
@ComponentScan("Controller")
@MapperScan("mapper")
public class ZhihuDemoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ZhihuDemoApplication.class, args);
	}

}
