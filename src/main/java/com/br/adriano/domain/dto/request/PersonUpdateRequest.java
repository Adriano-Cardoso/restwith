package com.br.adriano.domain.dto.request;

import javax.validation.constraints.NotBlank;

import com.br.adriano.validation.OnCreate;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class PersonUpdateRequest {
	
	@NotBlank(groups={OnCreate.class},message = "O campo 'firstName' deve ser informado")
	@ApiModelProperty(position = 1, required = false, value = "Nome da pessoa que aloca o livro", name = "firstName", dataType = "String", example = "Lucas da Silva")
	private String firstName;
	
	@NotBlank(groups={OnCreate.class},message = "O campo 'lastName' deve ser informado")
	@ApiModelProperty(position = 2, required = false, value = "sobrenome da pessoa que aloca o livro", name = "lastName", dataType = "String", example = "Santos")
	private String lastName;

}
