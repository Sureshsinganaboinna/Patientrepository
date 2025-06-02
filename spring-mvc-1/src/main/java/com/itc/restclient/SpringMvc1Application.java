package com.itc.restclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringMvc1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvc1Application.class, args);
	}

}
