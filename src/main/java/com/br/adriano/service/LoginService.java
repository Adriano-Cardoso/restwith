package com.br.adriano.service;

import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.br.adriano.config.security.JwtTokenProvider;
import com.br.adriano.domain.dto.request.LoginRequest;
import com.br.adriano.domain.dto.response.LoginResponse;
import lombok.AllArgsConstructor;

@Service("LoginService")
@AllArgsConstructor
@Validated
public class LoginService {
	
	private AuthenticationManager authenticationManager;

    private JwtTokenProvider jwtTokenProvider;

    public LoginResponse auth(@Valid LoginRequest loginRequest) {
     
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),loginRequest.getPassword()));

        String token=jwtTokenProvider.createToken(loginRequest.getEmail(),authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()));

        return new LoginResponse(token,"Bearer");
    }


}
