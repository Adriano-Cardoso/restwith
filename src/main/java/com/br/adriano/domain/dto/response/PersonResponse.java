package com.br.adriano.domain.dto.response;

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
public class PersonResponse {

	private Long id;
	private String firstName;
	private String lastName;
	private String cpf;
	private String address;
	private String gender;
	
	
}
