package com.br.adriano.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.br.adriano.domain.Book;
import com.br.adriano.domain.dto.request.BookRequest;
import com.br.adriano.domain.dto.response.BookResponse;
import com.br.adriano.exception.BookAuthorResourceExistingException;
import com.br.adriano.exception.BookAuthorResourceNotFoundException;
import com.br.adriano.exception.IdNotFoundException;
import com.br.adriano.repository.BookRepository;
import com.br.adriano.validation.OnCreate;
import com.br.adriano.validation.OnUpdate;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
@Validated
@Service("BookService")
public class BookService {

	private BookRepository repository;

	@Validated(OnCreate.class)
	public BookResponse createNewBook(BookRequest request) throws BookAuthorResourceExistingException{
		this.repository.findByAuthor(request.getAuthor()).ifPresent(p -> {
			throw new BookAuthorResourceExistingException("O author ja existe " + request.getAuthor());
		});

		Book book = Book.of(request);

		this.repository.save(book);
		log.info("method=createNewBook id={}", book.getId());

		return book.toDto();
	}

	@Transactional
	@Validated(OnUpdate.class)
	public BookResponse updateNameBook(Long id, BookRequest request) {
		Book book = this.repository.findById(id)
				.orElseThrow(() -> new IdNotFoundException("O id informado nao existe " + id));

		book.updateBook(request);

		log.info("method=updateNameBook id={}", book.getId());

		return book.toDto();

	}

	public List<BookResponse> listAllBook() {
		log.info("method=listAllBook");
		return this.repository.listAllBook();
	}

	public void deleteByIdBook(Long id) {
		Book Book = this.repository.findById(id)
				.orElseThrow(() -> new IdNotFoundException("O id informado nao existe " + id));
		log.info("method=findByCpf findByCpf={}", id);
		this.repository.delete(Book);

	}

	public BookResponse findByCpf(String author) {
		log.info("method=findByCpf findByCpf={}", author);
		return this.repository.findByAuthor(author)
				.orElseThrow(() -> new BookAuthorResourceNotFoundException("O Author informado nao existe " + author));

	}

}
