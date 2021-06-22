package com.br.adriano.controller;

import java.util.List;

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
@RequestMapping("api/v1/book/")
@AllArgsConstructor
public class BookController {

	private BookService service;

	@ApiOperation(value = "find all Book")
	@GetMapping
	public ResponseEntity<List<BookResponse>> listAllBook() {
		return ResponseEntity.ok(this.service.listAllBook());
	}

	@ApiOperation(value = "list person by author")
	@GetMapping("/author/{author}")
	public ResponseEntity<BookResponse> listAuthorBook(@PathVariable("author") String author) {
		return ResponseEntity.ok(this.service.findByCpf(author));
	}

	@ApiOperation(value = "create new book")
	@PostMapping
	public ResponseEntity<BookResponse> createNewBook(@RequestBody BookRequest request) {
		return ResponseEntity.ok(this.service.createNewBook(request));
	}

	@ApiOperation(value = "update name book")
	@PatchMapping("/{id}")
	public ResponseEntity<BookResponse> updateNameBook(@PathVariable Long id, @RequestBody BookRequest request) {
		return ResponseEntity.ok(this.service.updateNameBook(id, request));
	}

	@ApiOperation(value = "delete book by id")
	@DeleteMapping("/{id}")
	public ResponseEntity<BookResponse> deleteByIdPerson(@PathVariable Long id) {
		this.service.deleteByIdBook(id);
		return ResponseEntity.ok().build();
	}
}
