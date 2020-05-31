package com.harada.springboot.udemy.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

	private JWTUtil jwtUtil;
	private UserDetailsService userDetailsService;
	
	public JWTAuthorizationFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);
	}

	public JWTAuthorizationFilter(AuthenticationManager authenticationManager, JWTUtil util, UserDetailsService userDetailsService) {
		super(authenticationManager);
		this.jwtUtil = util;
		this.userDetailsService = userDetailsService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String header = request.getHeader("Authorization");
		
		if(header!=null && header.startsWith("Bearer ")) {
			UsernamePasswordAuthenticationToken auth = getAuthenticationToken(header.substring(7),request);
			if(auth!=null) {
				SecurityContextHolder.getContext().setAuthentication(auth);
			}
		}
		
		chain.doFilter(request, response);
	}

	private UsernamePasswordAuthenticationToken getAuthenticationToken(String hash, HttpServletRequest request) {
		if(jwtUtil.isValid(hash)) {
			String username = jwtUtil.getUsername(hash);
			UserDetails details = userDetailsService.loadUserByUsername(username);
			return new UsernamePasswordAuthenticationToken(details.getUsername(), details.getPassword(),new ArrayList<GrantedAuthority>());
		}
		return null;
	}
	
}
