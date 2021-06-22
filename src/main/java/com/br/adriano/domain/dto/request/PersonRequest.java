package com.br.adriano.domain.dto.request;

import javax.validation.constraints.NotBlank;

import com.br.adriano.validation.OnCreate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonRequest {
	
	@NotBlank(groups={OnCreate.class},message = "O campo 'firstName' deve ser informado")
	private String firstName;
	
	@NotBlank(groups={OnCreate.class},message = "O campo 'lastName' deve ser informado")
	private String lastName;
	
	@NotBlank(groups={OnCreate.class},message = "O campo 'cpf' deve ser informado")
	private String cpf;
	
	@NotBlank(groups={OnCreate.class},message = "O campo 'address' deve ser informado")
	private String address;
	
	@NotBlank(groups={OnCreate.class},message = "O campo 'gender' deve ser informado")
	private String gender;

}
