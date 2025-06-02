package com.itc.restclient.config;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

import com.itc.restclient.utils.PasscodeGenerator2;





@Configuration
public class PasscodeConfig {

   @Bean
    PasscodeGenerator2 passcodeGenerator() {
	        return new PasscodeGenerator2();
	    }
	

}
