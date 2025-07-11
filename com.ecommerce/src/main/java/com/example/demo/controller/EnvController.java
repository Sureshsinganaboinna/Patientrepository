package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnvController {
	
	 @Value("${custom.message}")
	    private String message;

	    @GetMapping("/env")
	    public String getEnvMessage() {
	        return message;
	    }

}
