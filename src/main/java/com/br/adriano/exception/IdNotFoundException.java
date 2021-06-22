package com.br.adriano.exception;

public class IdNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public IdNotFoundException(String exception) {
		super(exception);
	}
	
}
