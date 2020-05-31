package com.harada.springboot.udemy.dto;

import java.io.Serializable;

public class CredencialDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9211992151123148984L;
	private String email;
	private String senha;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
