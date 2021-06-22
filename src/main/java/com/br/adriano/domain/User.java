package com.br.adriano.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.br.adriano.domain.dto.request.UserRequest;
import com.br.adriano.domain.dto.response.UserResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@AllArgsConstructor
@Table(name = "USER")
public class User implements UserDetails, Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "user_name", unique = true)
	private String userName;

	@Column(name = "full_name")
	private String fullName;

	@Column(name = "password")
	private String password;

	@Column(name = "account_non_expired")
	private boolean accountNonExpired;

	@Column(name = "account_non_Locked")
	private boolean accountNonLocked;

	@Column(name = "credentials_non_Expired")
	private boolean credentialsNonExpired;

	@Column(name = "enabled")
	private boolean enabled;

	public List<String> getRoles() {
		List<String> roles = new ArrayList<>();
		for (Permission permission : this.permission) {
			roles.add(permission.getDescription());

		}
		return roles;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "USER_PERMISSION", joinColumns = { @JoinColumn(name = "id_user") }, inverseJoinColumns = {
			@JoinColumn(name = "id_permission") })
	private List<Permission> permission;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.permission;
	}

	@Override
	public String getUsername() {
		return this.userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return this.accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return this.accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return this.credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return this.enabled;
	}

	public UserResponse toDto() {
		return UserResponse.builder().id(this.id).userName(this.userName).build();
	}

	public static User of(UserRequest request) {
		return User.builder().userName(request.getUserName()).fullName(request.getFullName())
				.password(request.getPassword()).build();
	}
}
