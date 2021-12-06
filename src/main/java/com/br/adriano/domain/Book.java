package com.br.adriano.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.br.adriano.domain.dto.request.BookRequest;
import com.br.adriano.domain.dto.response.BookResponse;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_book")
public class Book {
	
	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id", nullable = false)
	private Long bookId;
	
	@Column(name = "author", nullable = false, length = 180)
	private String author;
	
	@Column(name = "launch_date", nullable = false)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate launchDate;
	
	@Column(nullable = false)
	private BigDecimal price;
	
	@Column(nullable = false, length = 180)
	private String title;
	
	
	@PrePersist
	public void prePersist() {
		this.launchDate = LocalDate.now();
	}
	
	public void updateBook(BookRequest request) {
		this.author = request.getAuthor();
	}
	
	public BookResponse toDto() {
		return BookResponse.builder().bookId(this.bookId).author(this.author).launchDate(this.launchDate).price(this.price).title(this.title).build();
	}
	
	public static Book of(BookRequest request) {
		return Book.builder().author(request.getAuthor()).price(request.getPrice()).title(request.getTitle()).build();
		
	}
	
}

