package com.br.adriano.service;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

import com.br.adriano.domain.Book;
import com.br.adriano.domain.dto.request.BookRequest;
import com.br.adriano.domain.dto.response.BookResponse;
import com.br.adriano.repository.BookRepository;
import com.br.adriano.validation.Message;
import com.br.adriano.validation.OnCreate;
import com.br.adriano.validation.OnUpdate;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
@Validated
@Service("BookService")
public class BookService {

	private BookRepository bookRepository;

	@Validated(OnCreate.class)
	public BookResponse createNewBook(@Valid  BookRequest bookRequest){
		this.bookRepository.findByAuthor(bookRequest.getAuthor()).ifPresent(p -> {
			throw Message.BOOK.asBusinessException();
		});

		Book book = Book.of(bookRequest);

		this.bookRepository.save(book);
		log.info("method=createNewBook id={}", book.toString());

		return book.toDto();
	}

	@Transactional
	@Validated(OnUpdate.class)
	public BookResponse updateNameBook( Long bookId, @Valid @RequestBody BookRequest bookRequest) {
		Book book = this.bookRepository.findById(bookId).orElseThrow(() -> Message.NOT_FOUND_ID_BOOK.asBusinessException());

		book.updateBook(bookRequest);

		log.info("method=updateNameBook id={}", book.toString());

		return book.toDto();

	}

	public Page<BookResponse> listAllBook() {
		log.info("method=listAllBook");
		
		int limit = 3;
		int page = 0;
		
		Pageable pageable = PageRequest.of(page, limit);
		
		log.info("method=listAllBook limit{}", limit);
		
		return this.bookRepository.listAllBook(pageable);
	}

	public void deleteByIdBook(Long bookId) {
		Book book = this.bookRepository.findById(bookId).orElseThrow(() -> Message.NOT_FOUND_ID_BOOK.asBusinessException());
		
		log.info("method=findByCpf findByCpf={}", bookId.toString());
		
		this.bookRepository.delete(book);

	}

	public BookResponse findByAuthor(String author) {
		
		log.info("method=findByCpf findByAuthor={}", author.toString());
		return this.bookRepository.findByAuthor(author).orElseThrow(() -> Message.NOT_FOUND_ID_BOOK.asBusinessException());

	}
	
	public Book findById(Long categoryId) {

		log.info("method=listAllCategorias");

		return bookRepository.findById(categoryId).orElseThrow(() -> Message.NOT_FOUND_ID_BOOK.asBusinessException());
	}
	

}
