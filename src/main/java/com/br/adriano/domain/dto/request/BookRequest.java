package com.br.adriano.domain.dto.request;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.br.adriano.validation.OnCreate;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {
	
	@NotBlank(groups={OnCreate.class},message = "O campo 'author' deve ser informado")
	private String author;

	
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@NotEmpty(groups={OnCreate.class},message = "O campo 'launchDate' deve ser informado")
	private LocalDate launchDate;

	@NotEmpty(groups={OnCreate.class},message = "O campo 'price' deve ser informado")
	private double price;

	@NotBlank(groups={OnCreate.class},message = "O campo 'title' deve ser informado")
	private String title;

}
