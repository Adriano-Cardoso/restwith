package com.br.adriano.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
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

import com.br.adriano.domain.dto.response.UserResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@EqualsAndHashCode
@Table(name = "tb_user")
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails, Serializable {

	private static final long serialVersionUID = -8276366860908411458L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;

	@Column(name = "user_name", unique = true)
	private String userName;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;


	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
    @JoinTable(name="tb_user_profile",joinColumns = @JoinColumn(name="user_id"),
    inverseJoinColumns = @JoinColumn(name="profile_id"))
	private List<Profile> profile;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.profile;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	public UserResponse toResponse() {
		return UserResponse.builder().userName(this.userName).password(this.password).build();
	}

}
