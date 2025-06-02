package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import com.example.demo.utils.PasscodeGenerator2;


@Configuration
public class PasscodeConfig {

   @Bean
    PasscodeGenerator2 passcodeGenerator() {
	        return new PasscodeGenerator2();
	    }
	

}
