package com.example.demo.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import com.example.demo.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class Jwt {
	
	@Value("${jwt.secret.key}")
	private String JWT_SECRET_KEY;
	
	private int JWT_TOKEN_VALIDITY = 60*60*24*1000;
	
	
	private SecretKey generateSecretKey()
	{
		return Keys.hmacShaKeyFor(JWT_SECRET_KEY.getBytes());
		
	}
	
	public String generateTokenKey(User Userdata)
	{
		
		Date tokengeneratedtime = new Date();
		Date expiryDate = new Date(tokengeneratedtime.getTime()+JWT_TOKEN_VALIDITY);
		
		Map<String, Object> tokenuserdata = new HashMap<String, Object>();
		tokenuserdata.put("userid", Userdata.getId());
		tokenuserdata.put("username", Userdata.getName());
		tokenuserdata.put("useremail", Userdata.getEmail());
		
		String jwttoken = Jwts.builder().claims().add(tokenuserdata)
				.and()
				.subject(Userdata.getEmail())
				.issuedAt(tokengeneratedtime)
				.expiration(expiryDate)
				.signWith(generateSecretKey()).compact();
		
		return jwttoken;
		
		
	
	}
	
	
	

}
