package com.harada.springboot.udemy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.harada.springboot.udemy.domain.Cliente;
import com.harada.springboot.udemy.repositories.ClienteRepository;
import com.harada.springboot.udemy.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private ClienteRepository clienteRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Cliente cliente = clienteRepo.findByEmail(username);
		if(cliente==null) {
			throw new UsernameNotFoundException("Email nao cadastrado");
		}
		return new UserSS(cliente);
	}

}