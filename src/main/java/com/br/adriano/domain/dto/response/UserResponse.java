package com.br.adriano.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class UserResponse {
	
	private Long id; 
	
	private String userName;


	private String password;


}
