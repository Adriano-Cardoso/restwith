package com.br.adriano.domain.dto.request;

import java.sql.Date;

import javax.validation.constraints.NotBlank;

import com.br.adriano.validation.OnCreate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {
	
	@NotBlank(groups={OnCreate.class},message = "O campo 'author' deve ser informado")
	private String author;

	@NotBlank(groups={OnCreate.class},message = "O campo 'launchDate' deve ser informado")
	private Date launchDate;

	@NotBlank(groups={OnCreate.class},message = "O campo 'price' deve ser informado")
	private double price;

	@NotBlank(groups={OnCreate.class},message = "O campo 'title' deve ser informado")
	private String title;

}
