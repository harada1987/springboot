package com.harada.springboot.udemy.services.exception;

public class ObjectNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -115929330248830510L;
	public ObjectNotFoundException(String message) {
		super(message);
	}
	public ObjectNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
