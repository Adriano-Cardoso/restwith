package com.br.adriano.validation;

import org.springframework.http.HttpStatus;

import com.br.adriano.exception.BusinessException;

public enum Message {

	NOT_FOUND_USER_PERMISSION("O usuario nao foi tem permiss�o para seguir em frente", HttpStatus.NOT_FOUND),
	PERSON_EXIST("Pessoa ja existe em nossa base de dados ", HttpStatus.BAD_REQUEST),
	NOT_FOUND_ID_PERSON("O id nao existe", HttpStatus.NOT_FOUND),
	NOT_FOUND_CPF_PERSON("O cpf nao foi encontrado em nossa base de dados ", HttpStatus.NOT_FOUND),
	BOOK_AUTHOR("O Autor ja em nossa base de dados ", HttpStatus.BAD_REQUEST),
	NOT_FOUND_ID_BOOK("O Id do book nao foi encontrado em nossa base de dados ", HttpStatus.NOT_FOUND),
	TOKEN_ERROR("O Token esta invalido ", HttpStatus.UNAUTHORIZED),
	NOT_FOT_USER_PERMISSION("O usuario nao tem permissao ", HttpStatus.FORBIDDEN),
	IS_PRESENT_USER("O usuario ja existe ", HttpStatus.BAD_REQUEST),
	NAME_PROFILE_NOT_FOUND("Perfil não encontrado", HttpStatus.NOT_FOUND),
	BOOK("Livro já existe em nossa base de dados ", HttpStatus.BAD_REQUEST);

	private String value;
	private String description;
	private HttpStatus statusCode;

	private Message(String value, HttpStatus statusCode) {
		this.value = value;
		this.statusCode = statusCode;
	}

	private Message(String value, String description, HttpStatus statusCode) {
		this.value = value;
		this.description = description;
		this.statusCode = statusCode;
	}

	private Message(String value) {
		this.value = value;
	}

	public String getMessage() {
		return this.value;
	}

	public HttpStatus getStatus() {
		return this.statusCode;
	}

	public String getDescription() {
		return description;
	}

	public BusinessException asBusinessException() {
		return BusinessException.builder().httpStatusCode(this.getStatus())
				.code(String.valueOf(this.getStatus().value())).message(this.getMessage())
				.description(this.getDescription()).build();
	}

}
