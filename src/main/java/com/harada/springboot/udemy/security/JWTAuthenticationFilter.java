/**
 * 
 */
package com.harada.springboot.udemy.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.harada.springboot.udemy.dto.CredencialDTO;

/**
 * @author Daniel
 *
 */
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private AuthenticationManager manager;
	private JWTUtil util;
	
	public JWTAuthenticationFilter(AuthenticationManager manager, JWTUtil util) {
		this.manager = manager;
		this.util = util;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		try {
			CredencialDTO credencial = new ObjectMapper().readValue(request.getInputStream(),CredencialDTO.class);
			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(credencial.getEmail(),credencial.getSenha());
			
			return manager.authenticate(token);
		} catch (JsonParseException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (JsonMappingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		String username = ((UserSS) authResult.getPrincipal()).getUsername();
		String token = util.generateToken(username);
		response.addHeader("Authorization", "Bearer "+token);
	}

	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException failed) throws IOException, ServletException {
		// TODO Auto-generated method stub
		super.unsuccessfulAuthentication(request, response, failed);
	}
}
