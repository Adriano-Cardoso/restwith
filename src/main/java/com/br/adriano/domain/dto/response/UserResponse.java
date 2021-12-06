package com.br.adriano.domain.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class UserResponse {
	
	@ApiModelProperty(position = 1, required = false, value = "email do usuario", name = "email", dataType = "String", example = "teste@email.com")
	private String email;
	
	@ApiModelProperty(position = 2, required = false, value = "username do usuario", name = "username", dataType = "String", example = "teste")
	private String userName;

	@ApiModelProperty(position = 3, required = false, value = "senha do usuario", name = "password", dataType = "String", example = "123")
	private String password;


}
