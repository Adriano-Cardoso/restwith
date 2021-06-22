package com.br.adriano.domain.dto.response;


import java.util.Date;

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

	private Date launchDate;

	private double price;

	private String title;
}
