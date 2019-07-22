package com.harada.springboot.udemy.services.exception;

public class ObjectNotFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -115929330248830510L;
	public ObjectNotFoundException(String string) {
		super(string);
	}

}
