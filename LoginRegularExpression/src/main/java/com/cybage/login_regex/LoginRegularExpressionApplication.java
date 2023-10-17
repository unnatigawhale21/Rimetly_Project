package com.cybage.login_regex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

@SpringBootApplication(scanBasePackages = "com.cybage", exclude = {ErrorMvcAutoConfiguration.class})
@EntityScan(basePackages = "com.cybage.model")
public class LoginRegularExpressionApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginRegularExpressionApplication.class, args);
	}

}
