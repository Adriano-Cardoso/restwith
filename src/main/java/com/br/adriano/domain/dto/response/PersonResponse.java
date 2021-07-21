package com.br.adriano.domain.dto.response;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;

@Getter

public class PersonResponse {

	private Long id;
	private String firstName;
	private String lastName;
	private String cpf;
	private String address;
	private String gender;
	private BookResponse book;

	@Builder
	public PersonResponse(Long id, String firstName, String lastName, String cpf, String address, String gender,
			Long booksId, String author, LocalDate launchDate, double price, String title) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.cpf = cpf;
		this.address = address;
		this.gender = gender;
		this.book = new BookResponse(booksId, author, launchDate, price, title);
	}


}
