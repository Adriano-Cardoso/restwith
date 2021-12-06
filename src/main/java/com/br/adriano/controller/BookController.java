package com.br.adriano.controller;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.adriano.domain.dto.request.BookRequest;
import com.br.adriano.domain.dto.response.BookResponse;
import com.br.adriano.service.BookService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@Api(value = "Book Endpoint", description = "Description for book", tags = { "Book Endpoint" })
@RestController
@RequestMapping("api/v1/book")
@AllArgsConstructor
public class BookController {

	private BookService service;

	@ApiOperation(value = "find all Book")
	@GetMapping()
	public ResponseEntity<Page<BookResponse>> listAllBook() {
		return ResponseEntity.status(HttpStatus.OK).body(this.service.listAllBook());
	}

	@ApiOperation(value = "list person by author")
	@GetMapping("/author/{author}")
	public ResponseEntity<BookResponse> listAuthorBook(@PathVariable("author") String author) {
		return ResponseEntity.status(HttpStatus.OK).body(this.service.findByAuthor(author));
	}

	@ApiOperation(value = "create new book")
	@PostMapping
	public ResponseEntity<BookResponse> createNewBook(@Valid @RequestBody BookRequest request) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.createNewBook(request));
	}

	@ApiOperation(value = "update name book")
	@PatchMapping("/{bookId}")
	public ResponseEntity<BookResponse> updateNameBook(@PathVariable Long bookId, @RequestBody BookRequest bookRequest) {
		return ResponseEntity.status(HttpStatus.OK).body(this.service.updateNameBook(bookId, bookRequest));
	}

	@ApiOperation(value = "delete book by bookId")
	@DeleteMapping("/{bookId}")
	public ResponseEntity<BookResponse> deleteByIdPerson(@PathVariable Long bookId) {
		this.service.deleteByIdBook(bookId);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
