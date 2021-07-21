package com.br.adriano.domain.dto.response;


import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class BookResponse {

	private Long id;

	private String author;

	private LocalDate launchDate;

	private double price;

	private String title;
}
