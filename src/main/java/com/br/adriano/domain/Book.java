package com.br.adriano.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.br.adriano.domain.dto.request.BookRequest;
import com.br.adriano.domain.dto.response.BookResponse;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "BOOKS")
@Getter
@Setter
@Entity
public class Book {
	
	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "author", nullable = false, length = 180)
	private String author;
	
	@Column(name = "launch_date", nullable = false)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date launchDate;
	
	@Column(nullable = false)
	private double price;
	
	@Column(nullable = false, length = 180)
	private String title;
	
	
	public void updateBook(BookRequest request) {
		this.author = request.getAuthor();
	}
	
	public BookResponse toDto() {
		return BookResponse.builder().id(this.id).author(this.author).launchDate(this.launchDate).price(this.price).title(this.title).build();
	}
	
	public static Book of(BookRequest request) {
		return Book.builder().author(request.getAuthor()).launchDate(request.getLaunchDate()).price(request.getPrice()).title(request.getTitle()).build();
		
	}
	
}

