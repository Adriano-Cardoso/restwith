package com.br.adriano.domain.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class PersonResponse {

	@ApiModelProperty(position = 1, required = false, value = "id da pessoa que aloca o livro", name = "personId", dataType = "Long", example = "2")
	private Long personId;
	
	@ApiModelProperty(position = 2, required = false, value = "Nome da pessoa que aloca o livro", name = "firstName", dataType = "String", example = "José da Silva")
	private String firstName;
	
	@ApiModelProperty(position = 3, required = false, value = "sobrenome da pessoa que aloca o livro", name = "lastName", dataType = "String", example = "Pereira")
	private String lastName;
	
	@ApiModelProperty(position = 4, required = false, value = "cpf da pessoa que aloca o livro", name = "author", dataType = "String", example = "12345678921")
	private String cpf;
	
	@ApiModelProperty(position = 5, required = false, value = "endereco do locatario", name = "address", dataType = "String", example = "Av Boa viagem")
	private String address;
	
	@ApiModelProperty(position = 6, required = false, value = "sexo do locatario", name = "gender", dataType = "String", example = "M")
	private String gender;
	
	@ApiModelProperty(position = 7, required = false, value = "livro que será alocado", name = "book", dataType = "BookResponse", example = "1")
	private Long bookId;


}
