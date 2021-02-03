package rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "rest", "service" })

public class TestApp1 {
	private static final Logger logger = LoggerFactory.getLogger(TestApp.class);

	public static void main(String[] args) {
		logger.info("this is a info message");
		logger.warn("this is a warn message");
		logger.error("this is a error message");
		ConfigurableApplicationContext context = SpringApplication.run(TestApp1.class, args);

		// EmpService service = context.getBean(EmpService.class);
		// service.process();
	}
}
