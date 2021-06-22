package com.br.adriano.domain.dto.request;

import javax.validation.constraints.NotBlank;

import com.br.adriano.validation.OnCreate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data	
@AllArgsConstructor
@Builder
public class UserRequest {
	
	@NotBlank(groups={OnCreate.class},message = "O campo 'userName' deve ser informado")
	private String userName;
    
	@NotBlank(groups={OnCreate.class},message = "O campo 'fullName' deve ser informado")
	private String fullName;

	@NotBlank(groups={OnCreate.class},message = "O campo 'password' deve ser informado")
	private String password;

//	@NotBlank(groups={OnCreate.class},message = "O campo 'accountNonExpired' deve ser informado")
//	private boolean accountNonExpired;
//
//	@NotBlank(groups={OnCreate.class},message = "O campo 'accountNonLocked' deve ser informado")
//	private boolean accountNonLocked;
//
//	@NotBlank(groups={OnCreate.class},message = "O campo 'credentialsNonExpired' deve ser informado")
//	private boolean credentialsNonExpired;
//
//	@NotBlank(groups={OnCreate.class},message = "O campo 'enabled' deve ser informado")
//	private boolean enabled;

}
