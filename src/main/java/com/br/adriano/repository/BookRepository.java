package com.br.adriano.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.br.adriano.domain.Book;
import com.br.adriano.domain.dto.response.BookResponse;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	@Query("select new com.br.adriano.domain.dto.response.BookResponse(b.id, "
			+ "b.author,"
			+ " b.launchDate,"
			+ " b.price,"
			+ " b.title)"
			+ " FROM Book b"
			+ " WHERE b.author=:author")
	Optional<BookResponse> findByAuthor(@Param("author") String author);
	
	@Query("select new com.br.adriano.domain.dto.response.BookResponse(b.id,"
			+ " b.author,"
			+ " b.launchDate,"
			+ " b.price,"
			+ " b.title)"
			+ " FROM Book b")
	Page<BookResponse> listAllBook(Pageable page);
	
}
