package com.oxcentra.phoenix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@ComponentScan(basePackages = {"com.oxcentra.phoenix.controller","com.oxcentra.phoenix.model","com.oxcentra.phoenix.repository","com.oxcentra.phoenix.service"})
public class ApiManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiManagerApplication.class, args);
	}

}
