package com.example.demo;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class Backoffice1Application {

	public static void main(String[] args) {
		SpringApplication.run(Backoffice1Application.class, args);
		System.out.println("I have to month");
	}

}
