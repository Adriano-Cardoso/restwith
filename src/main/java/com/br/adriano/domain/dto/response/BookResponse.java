package com.br.adriano.domain.dto.response;


import java.math.BigDecimal;
import java.time.LocalDate;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class BookResponse {

	private Long bookId;

	@ApiModelProperty(position = 1, required = false, value = "autor do livro", name = "author", dataType = "String", example = "Joao Jose")
	private String author;

	@ApiModelProperty(position = 2, required = false, value = "Data de lancamento ", name = "launchDate", dataType = "LocalDate", example = "2019-06-06")
	private LocalDate launchDate;

	@ApiModelProperty(position = 3, required = false, value = "preco do livro", name = "price", dataType = "String", example = "10.00")
	private BigDecimal price;

	@ApiModelProperty(position = 4, required = false, value = "titulo do livro", name = "title", dataType = "String", example = "Codando em Java")
	private String title;
}
