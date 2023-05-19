package com.oxcentra.phoenix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.oxcentra.phoenix"})
public class ApiManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiManagerApplication.class, args);
	}

}
