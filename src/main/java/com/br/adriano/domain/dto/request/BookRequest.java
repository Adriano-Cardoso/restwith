package com.br.adriano.domain.dto.request;

import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.br.adriano.validation.OnCreate;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {
	
	@NotBlank(groups={OnCreate.class},message = "O campo 'author' deve ser informado")
	@NotNull(groups = {OnCreate.class}, message = "O valor do campo 'author' é obrigatorio no corpo da requisicao")
	@Size(groups = {OnCreate.class}, min = 1,  max = 70,  message = "O valor do campo 'author' '${validatedValue}' deve estar entre {min} e {max} caracteres")
	@ApiModelProperty(position = 1, required = false, value = "autor do livro", name = "author", dataType = "String", example = "Joao Jose")
	private String author;

	@Min(groups = {OnCreate.class}, value = 1, message = "O campo 'price' está com valor mínimo ('{value}') inválido para o valor '${validatedValue}'")
	@ApiModelProperty(position = 2, required = false, value = "preco do livro", name = "price", dataType = "String", example = "10")
	private BigDecimal price;

	@NotNull(groups = {OnCreate.class}, message = "O valor do campo 'title' é obrigatorio no corpo da requisicao")
	@Size(groups = {OnCreate.class}, min = 1,  max = 90,  message = "O valor do campo 'title' '${validatedValue}' deve estar entre {min} e {max} caracteres")
	@NotBlank(groups={OnCreate.class},message = "O campo 'title' deve ser informado")
	@ApiModelProperty(position = 3, required = false, value = "titulo do livro", name = "title", dataType = "String", example = "Codando em Java")
	private String title;
	

}
