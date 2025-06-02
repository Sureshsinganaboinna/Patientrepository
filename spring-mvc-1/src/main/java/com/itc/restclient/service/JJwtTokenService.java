package com.itc.restclient.service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.itc.restclient.entities.SaveUser;
import com.itc.restclient.execeptions.TokenExperiy;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JJwtTokenService {

	@Value("${jwt.secret.key}")
	private String jwtSecretkey;

	private int JWT_TOKEN_VALIDATE_TIME = 1000 * 60 * 2;

	private Key generateSecretKey() {
		return Keys.hmacShaKeyFor(jwtSecretkey.getBytes());
	}

	public String generateJwtTokenKey(SaveUser userdata) {
		Date tokengeneratTime = new Date();

		Date expiryDate = new Date(tokengeneratTime.getTime() + JWT_TOKEN_VALIDATE_TIME);

		HashMap<String, Object> resHashMap = new HashMap<String, Object>();
		resHashMap.put("id", userdata.getId());
		resHashMap.put("email", userdata.getEmail());
		resHashMap.put("password", userdata.getPassword());

		String tokennString = Jwts.builder().claims().add(resHashMap).and().subject(userdata.getEmail())
				.issuedAt(tokengeneratTime).expiration(expiryDate).signWith(generateSecretKey()).compact();

		@SuppressWarnings("deprecation")
		String token = Jwts.builder().setClaims(resHashMap).setSubject(userdata.getEmail())
				.setIssuedAt(tokengeneratTime).setExpiration(expiryDate).signWith(generateSecretKey()).compact();

		return tokennString;

	}
	
	@SuppressWarnings("deprecation")
	public String decodeJwtToken(String token) {
		try {
			Claims claims = Jwts.parser().setSigningKey(generateSecretKey()).build().parseClaimsJws(token).getBody();

			Date expiryDate = claims.getExpiration();

			if (expiryDate.before(new Date())) {
				throw new TokenExperiy("token has expired");
			}
			return token;

		} catch (io.jsonwebtoken.ExpiredJwtException e) {
			// Throw custom exception
			throw new TokenExperiy("Token has expired");
		} catch (Exception e) {
			throw new TokenExperiy("Invalid token: " + e.getMessage());
		}

	}

}
