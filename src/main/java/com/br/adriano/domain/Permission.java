package com.br.adriano.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Table(name = "USER_PERMISSION")
@AllArgsConstructor
public class Permission  implements  GrantedAuthority{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_permission")
	private Long id;
	@Column(name = "description")
	private String description;

	@Override
	public String getAuthority() {
		
		return this.description;
	}

}
