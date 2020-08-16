package com.harada.springboot.udemy.services.exception;

public class DataIntegrityException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -115929330248830510L;
	public DataIntegrityException(String message) {
		super(message);
	}
	public DataIntegrityException(String message, Throwable cause) {
		super(message, cause);
	}
}
