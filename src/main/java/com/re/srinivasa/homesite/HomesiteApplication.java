package com.re.srinivasa.homesite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

@SpringBootApplication(exclude = ErrorMvcAutoConfiguration.class)
public class HomesiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomesiteApplication.class, args);
	}

}
