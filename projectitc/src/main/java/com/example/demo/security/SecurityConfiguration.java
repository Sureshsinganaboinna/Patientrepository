package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	
	/*
	 * public api's ---> without token
	 * secured api's ---> with token
	 * role based ---> ADMIN, Student
	 * SecurityFilterChain is an interface in Spring Security. It defines a filter chain for processing security-related aspects of HTTP requests. 
	 * Implementations of this interface are responsible for filtering incoming HTTP requests and applying security rules, such as authentication and authorization.
	 * No Session Management on the Server:
	 * The server does not store any information about the client between requests (such as login sessions or shopping cart data).
         Each request is treated independently, as if it's the first interaction with the client.
         
         authorizeHttpRequests(auth -> auth... )
         This method configures which HTTP requests are allowed and which require authentication. 
      The lambda expression is used to provide a configuration of authorization rules.
         
         SessionCreationPolicy.STATELESS: This tells Spring Security to not create or use HTTP sessions. It enforces a stateless architecture, 
         meaning that no session is created and the server does not store any user information between requests. 
         Each request must carry the authentication information (e.g., a token, usually JWT), making it ideal for APIs.
         
	 */

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
	{
		
		http.csrf(Csrf -> Csrf.disable())
		.authorizeHttpRequests(auth -> 
		auth
		.requestMatchers("/login").permitAll()
		.requestMatchers("/auth-login").permitAll()
		//.requestMatchers("/auth/**").permitAll()
		.anyRequest().authenticated()
				)
		.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		return http.build();
	}
	

}
