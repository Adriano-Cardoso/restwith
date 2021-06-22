package com.br.adriano.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.br.adriano.domain.User;
import com.br.adriano.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {
	
	
	private UserRepository repository;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = this.repository.findByuserName(username);
		if (user != null) {
			return user;
		}
		else {
			throw new UsernameNotFoundException(username + " not found"); 
		}
		
		
	}

}
