package com.br.adriano.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.br.adriano.domain.dto.request.PersonRequest;
import com.br.adriano.domain.dto.request.PersonUpdateRequest;
import com.br.adriano.domain.dto.response.PersonResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_person")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long personId;

	@Column(name = "first_name", nullable = false, length = 80)
	private String firstName;

	@Column(name = "last_name", nullable = false, length = 80)
	private String lastName;

	@Column(name = "cpf", nullable = false, length = 11)
	private String cpf;

	@Column(name = "address", nullable = false, length = 100)
	private String address;

	@Column(name = "gender", nullable = false, length = 1)
	private String gender;

	@Column(name = "book_id", nullable = true, insertable = false, updatable = false)
	private Long bookId;

	@ManyToOne
	@Cascade(CascadeType.PERSIST)
	@JoinColumn(name = "book_id", insertable = true)
	private Book book;

	public PersonResponse toDto() {
		return PersonResponse.builder().personId(this.personId).firstName(this.firstName).lastName(this.lastName)
				.cpf(this.cpf).address(this.address).gender(this.gender).bookId(this.book.getBookId()).build();
	}

	public static Person of(PersonRequest request) {
		return Person.builder().firstName(request.getFirstName()).lastName(request.getLastName()).cpf(request.getCpf())
				.address(request.getAddress()).gender(request.getGender()).build();
	}

	public void updatePerson(PersonUpdateRequest request) {

		this.firstName = request.getFirstName();
		this.lastName = request.getLastName();

	}

	public void addBook(Book book) {
		this.book = book;
		this.bookId = book.getBookId();
	}

}
