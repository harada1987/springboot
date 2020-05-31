/**
 * 
 */
package com.harada.springboot.udemy.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.harada.springboot.udemy.domain.Cliente;

/**
 * @author Daniel
 *
 */
public class UserSS implements UserDetails {

	private Cliente cliente;	
	private List<GrantedAuthority> authorities;
	
	public UserSS() {
		this.cliente = new Cliente();
	}
	
	public UserSS(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return authorities;
	}

	@Override
	public String getPassword() {
		return cliente.getSenha();
	}

	@Override
	public String getUsername() {
		return cliente.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
