package com.example.demo.security;

import javax.sql.DataSource;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;




//@Configuration
public class SecurityConfig {
	
/*	
	@Bean
	public UserDetailsManager configurationDatabase(DataSource dataSource)
	{
		UserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
		return userDetailsManager;
	}
	*/
	
	/*@Bean
	public InMemoryUserDetailsManager configureInMemory()
	{
		UserDetails user1 = User.builder().username("suresh").password("{noop}suresh123").roles("Admin").build();
		UserDetails user2 = User.builder().username("ramesh").password("{noop}ramesh123").roles("Manager").build();
		UserDetails user3 = User.builder().username("sunil").password("{noop}sunil123").roles("Employee").build();
		
		InMemoryUserDetailsManager objDetailsManager = new InMemoryUserDetailsManager(user1,user2,user3);
		
		return objDetailsManager;
		
	}*/

}
