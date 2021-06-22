package com.br.adriano.exception;

public class UserNameNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UserNameNotFoundException(String exception) {
		super(exception);
	}

}
