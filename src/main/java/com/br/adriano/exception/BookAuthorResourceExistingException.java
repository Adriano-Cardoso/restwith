package com.br.adriano.exception;

public class BookAuthorResourceExistingException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BookAuthorResourceExistingException (String exception) {
		super(exception);
	}

}
