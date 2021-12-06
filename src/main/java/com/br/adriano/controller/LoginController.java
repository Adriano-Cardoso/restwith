package com.br.adriano.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.adriano.domain.dto.request.LoginRequest;
import com.br.adriano.domain.dto.response.LoginResponse;
import com.br.adriano.service.LoginService;

import lombok.AllArgsConstructor;

@RequestMapping("/auth")
@AllArgsConstructor
@RestController
public class LoginController {

	private LoginService loginService;

	@PostMapping
	public ResponseEntity<LoginResponse> auth(@RequestBody LoginRequest loginRequest) {
		return ResponseEntity.ok(loginService.auth(loginRequest));
	}

}
