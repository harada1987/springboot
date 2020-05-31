package com.harada.springboot.udemy.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtil {

	@Value("${jwt.secret}")
	private String secret;
	
	@Value("${jwt.expiration}")
	private Long expiration;

	public String generateToken(String username) {
		return Jwts.builder()
				.setSubject(username)
				.setExpiration(new Date(System.currentTimeMillis()+expiration))
				.signWith(SignatureAlgorithm.HS512, secret.getBytes())
				.compact();
	}

	public boolean isValid(String hash) {
		Claims claims = getClaims(hash);
		if(claims!=null) {
			String username = claims.getSubject();
			Date expiration = claims.getExpiration();
			Date now = new Date();
			
			if(username!=null && expiration !=null && now.before(expiration)) {
				return true;
			}
		}
		return false;
	}

	private Claims getClaims(String hash) {
		return Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(hash).getBody();
	}

	public String getUsername(String hash) {
		Claims claims = getClaims(hash);
		if(claims!=null) {
			return claims.getSubject();
		}
		return null;
	}
	
}
