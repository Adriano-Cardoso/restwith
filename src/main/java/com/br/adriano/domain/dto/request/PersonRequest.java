package com.br.adriano.domain.dto.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.br.adriano.validation.OnCreate;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonRequest {
	
	@NotNull(groups = {OnCreate.class}, message = "O valor do campo 'firstName' é obrigatorio no corpo da requisicao")
	@Size(groups = {OnCreate.class}, min = 1,  max = 40,  message = "O valor do campo 'author' '${validatedValue}' deve estar entre {min} e {max} caracteres")
	@ApiModelProperty(position = 1, required = false, value = "Nome da pessoa que aloca o livro", name = "firstName", dataType = "String", example = "José da Silva")
	private String firstName;
	
	@NotNull(groups = {OnCreate.class}, message = "O valor do campo 'lastName' é obrigatorio no corpo da requisicao")
	@Size(groups = {OnCreate.class}, min = 2,  max = 40,  message = "O valor do campo 'author' '${validatedValue}' deve estar entre {min} e {max} caracteres")
	@ApiModelProperty(position = 2, required = false, value = "sobrenome da pessoa que aloca o livro", name = "lastName", dataType = "String", example = "Pereira")
	private String lastName;
	
//	@NotBlank(groups={OnCreate.class},message = "O campo 'cpf' deve ser informado")
	@NotNull(groups = {OnCreate.class}, message = "O valor do campo 'cpf' é obrigatorio no corpo da requisicao")
	@Size(groups = {OnCreate.class}, min = 3,  max = 11,  message = "O valor do campo 'author' '${validatedValue}' deve estar entre {min} e {max} caracteres")
	@ApiModelProperty(position = 3, required = false, value = "cpf da pessoa que aloca o livro", name = "author", dataType = "String", example = "12345678921")
	private String cpf;
	
//	@NotBlank(groups={OnCreate.class},message = "O campo 'address' deve ser informado")
	@NotNull(groups = {OnCreate.class}, message = "O valor do campo 'address' é obrigatorio no corpo da requisicao")
	@Size(groups = {OnCreate.class}, min = 4,  max = 70,  message = "O valor do campo 'author' '${validatedValue}' deve estar entre {min} e {max} caracteres")
	@ApiModelProperty(position = 4, required = false, value = "endereco do locatario", name = "address", dataType = "String", example = "Av Boa viagem")
	private String address;
	
//	@NotBlank(groups={OnCreate.class},message = "O campo 'gender' deve ser informado")
	@NotNull(groups = {OnCreate.class}, message = "O valor do campo 'gender' é obrigatorio no corpo da requisicao")
	@Size(groups = {OnCreate.class}, min = 1,  max = 1,  message = "O valor do campo 'author' '${validatedValue}' deve estar entre {min} e {max} caracteres")
	@ApiModelProperty(position = 5, required = false, value = "sexo do locatario", name = "gender", dataType = "String", example = "M")
	private String gender;
	
//	@NotBlank(groups={OnCreate.class},message = "O campo 'book' deve ser informado")	
	@NotNull(groups = {OnCreate.class}, message = "O valor do campo 'bookId' é obrigatorio no corpo da requisicao")
//	@Size(groups = {OnCreate.class}, min = 1,  message = "O valor do campo 'author' '${validatedValue}' deve estar entre {min} e {max} caracteres")
	@ApiModelProperty(position = 6, required = false, value = "livro que será alocado", name = "book", dataType = "String", example = "1")
	private Long bookId;

}
