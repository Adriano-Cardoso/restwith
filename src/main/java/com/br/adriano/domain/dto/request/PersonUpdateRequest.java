package com.br.adriano.domain.dto.request;

import javax.validation.constraints.NotBlank;

import com.br.adriano.validation.OnCreate;

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
	private String firstName;
	
	@NotBlank(groups={OnCreate.class},message = "O campo 'lastName' deve ser informado")
	private String lastName;

}
